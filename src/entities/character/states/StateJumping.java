package entities.character.states;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;

import entities.character.MainCharacter;

public class StateJumping extends BaseState{

	public StateJumping(MainCharacter character) {
		super(character);
		character.setY(character.getY()-10);
		character.setySpeed(-15);
		character.getHitboxGravity().setX(10000);
		Animation animation = new Animation();
		//animation.addFrame(character.getSpriteSheet().getSubImage(0, 1).getFlippedCopy(!character.isDirection(), false), 100);
		animation.addFrame(character.getSpriteSheet().getSubImage(1, 1).getFlippedCopy(!character.isDirection(), false), 100);
		animation.addFrame(character.getSpriteSheet().getSubImage(3, 1).getFlippedCopy(!character.isDirection(), false), 100);
		animation.addFrame(character.getSpriteSheet().getSubImage(4, 1).getFlippedCopy(!character.isDirection(), false), 100);
		animation.addFrame(character.getSpriteSheet().getSubImage(5, 1).getFlippedCopy(!character.isDirection(), false), 100);
		animation.addFrame(character.getSpriteSheet().getSubImage(6, 1).getFlippedCopy(!character.isDirection(), false), 100);
		character.setAnimation(animation);
	}

	@Override
	public void update(GameContainer arg0) {
		character.updateHitbox();
		character.getAnimation().stopAt(2);
		character.setySpeed(character.getySpeed()+1);
		if(character.getySpeed()>=0){
		character.setState(new StateFalling(character));
		}
	}

}
