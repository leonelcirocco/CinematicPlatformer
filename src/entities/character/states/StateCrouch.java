package entities.character.states;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import entities.character.MainCharacter;

public class StateCrouch extends BaseState{
	public StateCrouch(MainCharacter character) {
		super(character);
		Animation animation = new Animation();
		animation.addFrame(character.getSpriteSheet().getSubImage(5, 2).getFlippedCopy(!character.isDirection(), false), 100);
		character.setAnimation(animation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(GameContainer arg0) {
		boolean direction = false;
		fall();
		if(!arg0.getInput().isKeyDown(Input.KEY_S)&&!character.isCrouch()){
			character.setState(new StateStill(character));
		}
		if(arg0.getInput().isKeyDown(Input.KEY_A)){
			direction = false;
			acelerate(false, character.getMaxSpeed()/4);
			
		}
		if(arg0.getInput().isKeyDown(Input.KEY_D)){
			direction = true;
			acelerate(true, character.getMaxSpeed()/4);
			
		}
		if(!arg0.getInput().isKeyDown(Input.KEY_A)&&!arg0.getInput().isKeyDown(Input.KEY_D)){
			character.setSpeed(0);
		}
		character.updateHitboxCrouch(direction);
	}

}
