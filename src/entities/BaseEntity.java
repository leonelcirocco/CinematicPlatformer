package entities;

import org.newdawn.slick.Animation;

public abstract class BaseEntity {
	protected float x;
	protected float y;
	protected Animation animation;
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public Animation getAnimation() {
		return animation;
	}
	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

}
