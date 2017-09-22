package entities.character;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import entities.BaseEntity;

public class Enemy extends BaseEntity{
	private SpriteSheet spriteSheet;
	public Enemy(float x, float y) throws SlickException {
		this.x=x;
		this.y=y;
		animation = new Animation();
		spriteSheet = new SpriteSheet("data/Turret.png", 32, 32);
		animation.addFrame(spriteSheet.getSubImage(0, 0), 100);
	}
}
