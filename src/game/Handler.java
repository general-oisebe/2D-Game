package game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
// to update and render every objects in the game
	
	LinkedList<GameObject> object=new LinkedList<GameObject>();// weve just created a list of all objects in our game
	
	public void tick(){
		
		// going through each object one at a time
		for(int i=0; i<object.size(); i++){
			GameObject tempObject=object.get(i);
			tempObject.tick();
		}
		
	}
	public void render(Graphics g){
		// going through each object one at a time and rendering them
				for(int i=0; i < object.size(); i++){
					GameObject tempObject=object.get(i);// getting the index of the obj
					tempObject.render(g);
				}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
}
