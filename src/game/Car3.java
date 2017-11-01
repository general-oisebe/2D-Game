/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Tech Guy
 */
public class Car3 extends GameObject {

    Handler handler;

    public Car3(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velx = 6;
    }

    @Override
    public void tick() {
        x -= velx;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(x, y, 64, 32);
    }

    @Override
    public Rectangle getBounds() {
        return null;

    }

}
