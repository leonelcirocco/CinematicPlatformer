package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import level.Level1;
import level.Level2;


public class Main extends StateBasedGame{

	public Main(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) throws SlickException{
		AppGameContainer app = new AppGameContainer((Game) new Main("name"));
		app.setDisplayMode(Options.WIDTH, Options.HEIGTH, false);
		app.setAlwaysRender(true);
		app.setShowFPS(true);
		app.setTargetFrameRate(60);
		app.setVSync(false);
		app.start();
		// TODO Auto-generated method stub

	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new Level1());
		addState(new Level2());
		
	}

}
