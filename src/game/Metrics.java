package game;

import java.awt.*;
import javax.swing.JOptionPane;

public class Metrics {

    public static int HEALTH = 100;
    public static int points = 0;

    // TUORIAL VALUES
    private int score = 0;
    private int level = 1;
    private double newPoints;
    private double cash;
    private Game game;
    private Player player;
	//private int greenValue = 255;// creating a greenvalue

    public void tick() {
        points += 1;

        score++;

        if (HEALTH <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Oooops, You're DEAD!!!, You scored " + points / 10 + " points! and a CashPrice of Ksh." + getCash() + " try again latter.");
            int confirm = JOptionPane.showConfirmDialog(null, "Do you wanna quit?");

            if (confirm == 1) {
                //game.start();
                HEALTH = 100;
                points = 0;

            } else {
                System.exit(0);
            }

            // System.exit(10);
        }

		//greenValue = Game.clamp(greenValue, 0, 255);
        //greenValue = HEALTH * 2;
    }

    public void render(Graphics g) {

        Font fnt = new Font("Serif", 1, 14);

        g.setFont(fnt);
        g.setColor(Color.gray);
        g.fillRect(100, 15, 75, 25);

        g.setColor(new Color(0, 255, 0));
        g.fillRect(10, 15, 75, 25);
        //g.fillRect(15, 15, HEALTH * 2, 32);

        g.setColor(Color.WHITE);
//        //g.drawRect(15, 15, 200, 32);
//        g.drawString("START.", 30, 33);
//        g.drawString("STOP.", 120, 33);

        /*/g.drawString(Integer.toString(HEALTH) + "%  Coins: ", 100, 12);
         //g.setColor(Color.green);

         if (level == 1 || level == 2 || level == 3) {
         newPoints=points / 50;
         g.drawString("" + Double.toString(newPoints), 180, 12);
         } else if (level > 3 && level <= 5) {
         newPoints=points / 30;
         g.drawString("" + Double.toString(newPoints), 180, 12);
         }else if (player.status=="Wrecked" ) {
			
         newPoints=points / 10;
         g.drawString("Ooops, your car is wrecked!!!" + Double.toString(newPoints ), 200, 12);
         }
		
         cash=newPoints/100*10;
         */
        g.setColor(Color.green);
        g.drawString("Status.", 250, 12);
    }

    public int getLevel() {

        return level;
    }

    public void setLevel(int level) {
        this.level = level;

    }

    public double getCash() {

        return cash;
    }

    public int getScore() {

        return score;
    }

    public void setScore(int score) {
        this.score = score;

    }

}
