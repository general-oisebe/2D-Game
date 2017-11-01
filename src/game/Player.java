package game;

import java.awt.*;
import java.io.*;
import com.sun.speech.freetts.*;

import javax.swing.JOptionPane;

public class Player extends GameObject {

    public int tempObjLocation;
    public String status = null;
    public Car_speed_2_reverse car;
    public static final String VOICENAME = "kevin";
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velx = 1;

    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, 32, 32);
    }

    public void tick() {

        x += velx;
		//y += vely;

        //seeting the boundaries of the scene
        //x=Game.clamp(x, 0, Game.WIDTH-37);
        //y=Game.clamp(y, 0, Game.HEIGHT-60);
        //handler.addObject(new Trail(x,y,ID.Trail,Color.white,32,32,0.02f,handler));
        collision();
    }

    private void collision() {

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Enemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //Collission detection // Perform action
                    Metrics.HEALTH -= 2;
                    Metrics.points -= 1;
                }
            }
            if (tempObject.getId() == ID.FastEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //Collission detection // Perform action
                    Metrics.HEALTH -= 3;
                    Metrics.points -= 5;

                }
            }
            if (tempObject.getId() == ID.Destroyer) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //Collission detection // Perform action
                    Metrics.HEALTH -= 4;
                    Metrics.points -= 5;
                }
            }

            if (tempObject.getId() == ID.Car_speed_2_reverse) {
                tempObjLocation = tempObject.getX();
                if (getBounds().intersects(tempObject.getBounds())) {
                    status = "Wrecked";
                }

                if ((this.getX() - tempObject.getX()) <= 350) {
                    status = "approaching";
                }
                if ((this.getX() - tempObject.getX()) <= 250) {
                    status = "watch_out";
                }
                if ((this.getX() - tempObject.getX()) <= 150) {
                    status = "critical";
                }
                if ((this.getX() - tempObject.getX()) < 0) {
                    status = "Wrecked";

                }
                if ((this.getX() - tempObject.getX()) < -10) {
                    status = "Wrecked";

                    car.setVelx(0);
                }

            }
        }
    }

    public void render(Graphics g) {
        Font fnt = new Font("Serif", 1, 14);

        g.setFont(fnt);
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);

        g.drawString("You: " + this.getX() + "M", 10, 64);
        g.drawString("Car behind: " + Integer.toString(tempObjLocation) + " M", 10, 80);

        if (status == "approaching") {
            g.setColor(Color.blue);
            g.drawString("An approaching car from behind", 300, 12);

            //voice out put
            Voice voice;
            VoiceManager vm = VoiceManager.getInstance();
            voice = vm.getVoice(VOICENAME);
            voice.allocate();

            try {

                voice.speak("An approaching car from behind");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (status == "watch_out") {
            g.setColor(Color.yellow);
            g.drawString("Please hurry up, the car is just a few meters behind!", 300, 12);
        } else if (status == "critical") {
            g.setColor(Color.orange);
            g.drawString("Danger!!Danger!!", 300, 12);
        } else if (status == "Wrecked") {
            g.setColor(Color.red);
            g.drawString("Whoops!. You crashed. I guess there are Injuries... Am contacting 911 NOW. calling....", 300, 12);
            this.setVelx(0);

            //voice out put
            Voice voice;
            VoiceManager vm = VoiceManager.getInstance();
            voice = vm.getVoice(VOICENAME);
            voice.allocate();

            try {

                voice.speak("Ooops. You crashed. I guess there are Injuries... Am contacting 9 1 1 NOW. calling....");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            g.setColor(Color.green);
            g.drawString("It's safe, free to accelarate...", 300, 12);

        }
    }

}
