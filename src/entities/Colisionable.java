package entities;

import org.newdawn.slick.geom.Shape;

public abstract class Colisionable extends BaseEntity{
	protected Shape hitbox;
	
	public Shape getHitbox() {
		return hitbox;
	}
	public void setHitbox(Shape hitbox) {
		this.hitbox = hitbox;
	}
}
