package entities.character.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import entities.character.MainCharacter;

public abstract class BaseState {
	protected MainCharacter character;
	protected int animationSpeed;
	protected int minAnimationSpeed;
	public BaseState(MainCharacter character) {
		this.character=character;
	}
	public abstract void update(GameContainer arg0);
	protected void acelerate(boolean direction, float maxSpeed){
		if(direction){
			if(character.getSpeed()<maxSpeed){
				character.setSpeed(character.getSpeed()+0.15f);
			}
		}else{
			if(character.getSpeed()>-maxSpeed){
				character.setSpeed(character.getSpeed()-0.15f);
			}
		}
	}
	public int getAnimationSpeed() {
		return animationSpeed;
	}
	protected void jump(GameContainer arg0){
		if(arg0.getInput().isKeyPressed(Input.KEY_SPACE)){
			if(arg0.getInput().isKeyDown(Input.KEY_SPACE)){
				character.setState(new StateJumping(character));
			}
		}
	}
	protected void fall(){
		if(character.isFalling()){
			character.setState(new StateFalling(character));
		}
		character.setySpeed(character.getySpeed()+1);
	}
	protected void forceCrouch(){
		if(character.isCrouch()){
			character.setState(new StateCrouch(character));
		}
	}
	
}
