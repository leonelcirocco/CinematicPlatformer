package entities.character.states;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import entities.Colisionable;
import entities.character.MainCharacter;

public class StateLedge extends BaseState{
	private Colisionable colisionable;
	private boolean fall = false;
	public StateLedge(MainCharacter character, Colisionable colisionable) {
		super(character);
		this.colisionable=colisionable;
		character.setY(colisionable.getY());
		character.setySpeed(0);
		character.setSpeed(0);
		character.getCheckWall().setX(-1000);
		Animation animation = new Animation();
		animation.addFrame(character.getSpriteSheet().getSubImage(7, 1).getFlippedCopy(!character.isDirection(), false), 100);
		character.setAnimation(animation);
		
	}

	@Override
	public void update(GameContainer arg0) {
		if(!arg0.getInput().isKeyDown(Input.KEY_S)){
			fall=true;
		}
		character.setY(colisionable.getY());
		if(arg0.getInput().isKeyPressed(Input.KEY_S)&&fall){
			if(arg0.getInput().isKeyDown(Input.KEY_S)){
				character.setX(character.getX()-character.getCheckWall().getWidth());
				character.updateHitbox();
				character.setState(new StateFalling(character));
			}
		}
		if(arg0.getInput().isKeyPressed(Input.KEY_SPACE)){
			if(arg0.getInput().isKeyDown(Input.KEY_SPACE)){
				if(character.isDirection()){
					character.setDirection(false);
					character.setSpeed(-7);
				}else{
					character.setDirection(true);
					character.setSpeed(7);
				}
				character.updateHitbox();
				character.setState(new StateJumping(character));
			}
		}
		if(arg0.getInput().isKeyPressed(Input.KEY_W)){
			if(arg0.getInput().isKeyDown(Input.KEY_W)){
			character.setState(new StateClimb(character));
			}
		}

	}

}
