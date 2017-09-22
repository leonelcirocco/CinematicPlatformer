package entities.character.states;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import entities.character.MainCharacter;

public class StateFalling extends BaseState{

	public StateFalling(MainCharacter character) {
		super(character);
		Animation animation = new Animation();
		animation.addFrame(character.getSpriteSheet().getSubImage(1, 1).getFlippedCopy(!character.isDirection(), false), 100);
		animation.addFrame(character.getSpriteSheet().getSubImage(2, 1).getFlippedCopy(!character.isDirection(), false), 100);
		animation.addFrame(character.getSpriteSheet().getSubImage(3, 1).getFlippedCopy(!character.isDirection(), false), 100);
		animation.addFrame(character.getSpriteSheet().getSubImage(4, 1).getFlippedCopy(!character.isDirection(), false), 100);
		animation.addFrame(character.getSpriteSheet().getSubImage(5, 1).getFlippedCopy(!character.isDirection(), false), 100);
		animation.addFrame(character.getSpriteSheet().getSubImage(6, 1).getFlippedCopy(!character.isDirection(), false), 100);
		character.setAnimation(animation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(GameContainer arg0) {
		character.updateHitbox();
		character.setySpeed(character.getySpeed()+1);
		if(!character.isFalling()){
			if(character.getSpeed()>0){
			character.setState(new StateRunning(character, Input.KEY_D));
			}
			if(character.getSpeed()<0){
				character.setState(new StateRunning(character, Input.KEY_A));
			}
			if(character.getSpeed()==0){
				character.setState(new StateStill(character));
				
			}
			
		}
		if(arg0.getInput().isKeyDown(Input.KEY_SPACE)){
			if(arg0.getInput().isKeyPressed(Input.KEY_SPACE)){
				if(character.isWall()&&character.getSpeed()!=0&&character.getySpeed()<15){
					character.setDirection(!character.isDirection());
					character.setState(new StateJumping(character));
					character.setSpeed(-character.getSpeed());
				}
			}
		}
		
	}

}
