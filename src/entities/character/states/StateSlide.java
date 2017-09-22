package entities.character.states;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import entities.character.MainCharacter;

public class StateSlide extends BaseState{
	private int keyInput;
	public StateSlide(MainCharacter character, int keyInput) {
		super(character);
		this.keyInput=keyInput;
		Animation animation = new Animation();
		animation.addFrame(character.getSpriteSheet().getSubImage(4, 2).getFlippedCopy(!character.isDirection(), false), 100);
		character.setAnimation(animation);
	}

	@Override
	public void update(GameContainer arg0) {
		boolean direction = true;
		fall();
		int i = 1;
		if(character.getSpeed()<0){
			i  = -1;
			direction = false;
		}
		character.updateHitboxCrouch(direction);
		character.setSpeed(character.getSpeed()-0.1f*i);
		if(!arg0.getInput().isKeyDown(Input.KEY_S)){
			character.setState(new StateRunning(character, keyInput));
		}
		if(character.getSpeed()>-2&&character.getSpeed()<2){
			character.setSpeed(0);
			character.setState(new StateCrouch(character));
		}
	}

}
