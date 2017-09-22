package entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class NonColisionable extends BaseEntity{

	public NonColisionable(float x, float y, Image image) {
		this.x=x;
		this.y=y;
		animation = new Animation();
		animation.addFrame(image, 100);
	}

}
