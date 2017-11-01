package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Savior extends GameObject {

	Handler handler;
	
	public Savior(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler=handler;
		velx=2;
		vely=2;
		
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
		collision();
	}

private void collision(){
		
		for(int i=0; i<handler.object.size(); i++){
			GameObject tempObject=handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				if(getBounds().intersects(tempObject.getBounds())){
					//Collission detection // Perform action
					
					if(Metrics.HEALTH < 100){// for me to add the life, it must be less than 100
					Metrics.HEALTH += 1;
					Metrics.points -= 10;// consuming 10 coins for restoring life
					}
					
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 32, 32);
	}
}
