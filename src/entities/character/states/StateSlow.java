package entities.character.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import entities.character.MainCharacter;

public class StateSlow extends BaseState{

	public StateSlow(MainCharacter character) {
		super(character);
		character.setSpeed((int)character.getSpeed());
	}

	@Override
	public void update(GameContainer arg0) {
		character.updateHitbox();
		fall();
		if(character.getSpeed()>0){
			if(arg0.getInput().isKeyPressed(Input.KEY_D)){
				character.setState(new StateRunning(character, Input.KEY_D));
			}
			character.setSpeed(character.getSpeed()-0.5f);
		}
		if(character.getSpeed()<0){
			if(arg0.getInput().isKeyPressed(Input.KEY_A)){
				character.setState(new StateRunning(character, Input.KEY_A));
			}
			character.setSpeed(character.getSpeed()+0.5f);
		}
		if(character.getSpeed()==0){
			character.setState(new StateStill(character));
		}
	}

}
