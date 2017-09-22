package entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public class Floor extends Colisionable{


	public Floor(float x, float y, Image image) {
		this.x=x;
		this.y=y;
		animation = new Animation();
		animation.addFrame(image, 100);
		hitbox = new Rectangle(x, y, animation.getCurrentFrame().getWidth(), animation.getCurrentFrame().getHeight());
	}
}
