package entities.character.states;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import entities.character.MainCharacter;

public class StateStill extends BaseState{

	public StateStill(MainCharacter character) {
		super(character);
		Animation animation = new Animation();
		animation.addFrame(character.getSpriteSheet().getSubImage(0, 0).getFlippedCopy(!character.isDirection(), false), 100);
		character.setAnimation(animation);
	}

	@Override
	public void update(GameContainer arg0) {
		character.updateHitbox();
		forceCrouch();
		fall();
		jump(arg0);
		if(arg0.getInput().isKeyDown(Input.KEY_D)){
			character.setState(new StateRunning(character, Input.KEY_D));
			character.setDirection(true);
		}
		if(arg0.getInput().isKeyDown(Input.KEY_A)){
			character.setState(new StateRunning(character, Input.KEY_A));
			character.setDirection(false);
		}
		if(arg0.getInput().isKeyDown(Input.KEY_S)){
			character.setState(new StateCrouch(character));
		}
	}

}
