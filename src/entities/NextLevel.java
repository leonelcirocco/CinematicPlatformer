package entities;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class NextLevel{
	private int nextLevel;
	private int x;
	private int y;
	private Shape hitbox;
	public NextLevel(int nextLevel, int x, int y,int length,int heigth) {
		this.nextLevel = nextLevel;
		hitbox = new Rectangle(x, y, length, heigth);
	} 
	public int getNextLevel() {
		return nextLevel;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Shape getHitbox() {
		return hitbox;
	}

}
