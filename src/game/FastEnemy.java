package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject{

	private Handler handler;
	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler=handler;
		velx=2;
		vely=10;
		
		
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	}
	
	public void tick() {
		x += velx;
		y += vely;
		
		if(y<=0 || y>+Game.HEIGHT-32){
			vely *=-1;// reversing the coordinates if it hits the edges of the game
		}
		if(x<=0 || x>+Game.WIDTH-16){
			velx *=-1;// reversing the coordinates if it hits the edges of the game
		}
		
	  //handler.addObject(new Trail(x,y,ID.Trail,Color.red,16,16,0.02f,handler));
	}


	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x, y, 32, 32);
	}



}
