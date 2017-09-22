package main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entities.character.MainCharacter;

public class Camera extends BasicGameState{
	private float x=0;
	private float y=0;
	private MainCharacter character;
	public Camera(MainCharacter character) {
		this.character=character;
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		arg2.translate(-x, -y);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		x=character.getX()-350;
		y=character.getY()-300;
	}

	@Override
	public int getID() {
		return 0;
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	

}
