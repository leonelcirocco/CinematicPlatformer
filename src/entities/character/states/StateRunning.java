package entities.character.states;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import entities.character.MainCharacter;

public class StateRunning extends BaseState{
	private int keyPressed;
	private boolean direction;
	public StateRunning(MainCharacter character, int keyPressed) {
		super(character);
		if(keyPressed == Input.KEY_D){
			direction=true;
		}else{
			direction=false;
		}
		this.keyPressed=keyPressed;
		Animation animation = new Animation();
		minAnimationSpeed=70;
		animationSpeed = 100;
		animation.addFrame(character.getSpriteSheet().getSubImage(1, 0).getFlippedCopy(!direction, false), animationSpeed);
		animation.addFrame(character.getSpriteSheet().getSubImage(2, 0).getFlippedCopy(!direction, false), animationSpeed);
		animation.addFrame(character.getSpriteSheet().getSubImage(3, 0).getFlippedCopy(!direction, false), animationSpeed);
		animation.addFrame(character.getSpriteSheet().getSubImage(4, 0).getFlippedCopy(!direction, false), animationSpeed);
		animation.addFrame(character.getSpriteSheet().getSubImage(5, 0).getFlippedCopy(!direction, false), animationSpeed);
		animation.addFrame(character.getSpriteSheet().getSubImage(6, 0).getFlippedCopy(!direction, false), animationSpeed);
		animation.addFrame(character.getSpriteSheet().getSubImage(7, 0).getFlippedCopy(!direction, false), animationSpeed);
		animation.addFrame(character.getSpriteSheet().getSubImage(8, 0).getFlippedCopy(!direction, false), animationSpeed);
		animation.addFrame(character.getSpriteSheet().getSubImage(9, 0).getFlippedCopy(!direction, false), animationSpeed);
		character.setAnimation(animation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(GameContainer arg0) {
		character.updateHitbox();
		updateAnimation();
		forceCrouch();
		jump(arg0);
		fall();
		acelerate(direction,character.getMaxSpeed());
		if(!arg0.getInput().isKeyDown(keyPressed)){
			character.setState(new StateSlow(character));
		}
		if(arg0.getInput().isKeyDown(Input.KEY_S)){
			character.setState(new StateSlide(character, keyPressed));
		}
	}
	private void updateAnimation(){
		int i=0;
		if(!(character.getAnimation().getFrame()==character.getAnimation().getFrameCount()-1)){
			i=character.getAnimation().getFrame()+1;
		}else{
			i=0;
		}
		character.getAnimation().setDuration(i, character.getState().getAnimationSpeed());
		if(animationSpeed>minAnimationSpeed){
		animationSpeed=animationSpeed-1;
		}
	}

}
