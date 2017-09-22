package entities.character.states;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;

import entities.character.MainCharacter;

public class StateClimb extends BaseState{

	public StateClimb(MainCharacter character) {
		super(character);
		character.getCheckWall().setX(-100);
		Animation animation = new Animation();
		int animationduration = 50;
		animation.addFrame(character.getSpriteSheet().getSubImage(8, 1).getFlippedCopy(!character.isDirection(), false), animationduration);
		animation.addFrame(character.getSpriteSheet().getSubImage(9, 1).getFlippedCopy(!character.isDirection(), false), animationduration);
		animation.addFrame(character.getSpriteSheet().getSubImage(0, 2).getFlippedCopy(!character.isDirection(), false), animationduration);
		animation.addFrame(character.getSpriteSheet().getSubImage(1, 2).getFlippedCopy(!character.isDirection(), false), animationduration);
		animation.addFrame(character.getSpriteSheet().getSubImage(2, 2).getFlippedCopy(!character.isDirection(), false), animationduration);
		animation.addFrame(character.getSpriteSheet().getSubImage(3, 2).getFlippedCopy(!character.isDirection(), false), animationduration);
		character.setAnimation(animation);
	}

	@Override
	public void update(GameContainer arg0) {
		character.setY(character.getY()-4f);
		character.getAnimation().stopAt(5);
		if(character.getAnimation().isStopped()){
			if(character.isDirection()){
				character.setX(character.getX()+10);
			}else{
				character.setX(character.getX()-10);
				
			}
			character.setState(new StateCrouch(character));
			
		}
	}

}
