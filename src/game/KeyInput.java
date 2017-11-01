package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // checking for object to affect with the key strokes
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {

                // now add key events for the player
                if (key == KeyEvent.VK_UP) {
                    tempObject.setVely(-2);
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setVely(2);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setVelx(2);
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setVelx(-2);
                }
            }

            if (tempObject.getId() == ID.Enemy) {

                // now add key eventes for the player
            }
        }

        if (key == KeyEvent.VK_ESCAPE) {// escaping the window
            System.exit(2);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {

                // now add key eventes for the player
                if (key == KeyEvent.VK_UP) {
                    tempObject.setVely(0);
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setVely(0);
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setVelx(0);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setVelx(0);
                }
            }

            if (tempObject.getId() == ID.Enemy) {

                // now add key eventes for the player
            }
        }
    }
}
