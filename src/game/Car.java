package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Car extends GameObject {

    Handler handler;

    public Car(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velx = 5;
    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, 32, 32);
    }

    public void tick() {

        x -= velx;
		// y += vely;

        // seeting the boundaries of the scene
        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);

        //handler.addObject(new Trail(x,y,ID.Trail,Color.white,32,32,0.02f,handler));
        collision();
    }

    private void collision() {

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Enemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    // Collission detection // Perform action
                    Metrics.HEALTH -= 2;
                    Metrics.points -= 1;
                }
            }
            if (tempObject.getId() == ID.FastEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    // Collission detection // Perform action
                    Metrics.HEALTH -= 3;
                    Metrics.points -= 5;
                }
            }
            if (tempObject.getId() == ID.Destroyer) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    // Collission detection // Perform action
                    Metrics.HEALTH -= 4;
                    Metrics.points -= 5;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(x, y, 32, 32);
    }

}
