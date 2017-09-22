package level;

import java.io.FileNotFoundException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

import entities.NextLevel;
import entities.NonColisionable;
import entities.Sprites;
import entities.character.Enemy;
import entities.character.MainCharacter;
import main.Camera;

public class Level1 extends BaseLevel{
	private Music music;
	private NextLevel nextLevel = new NextLevel(2,2000,3872,10000,200);
	private Shape activate;
	private float musicSpeed = 1;
	public Level1() throws SlickException {
		character = new MainCharacter();
		camera = new Camera(character);
		character.setX(20);
		character.setY(780);
		music = new Music("data/sound/drums.wav");
		activate = new Rectangle(1500, 302, 200, 10);
		enemy.add(new Enemy(1782,162));
		decorationFront.add(new NonColisionable(0, 720, Sprites.trees.getSubImage(1, 0)));
		decorationFront.add(new NonColisionable(50, 720, Sprites.trees.getSubImage(1, 0)));
		decorationFront.add(new NonColisionable(20, 720, Sprites.trees.getSubImage(0, 0)));
		decorationFront.add(new NonColisionable(80, 720, Sprites.trees.getSubImage(0, 0)));
		decorationFront.add(new NonColisionable(530, 680, Sprites.trees.getSubImage(1, 0)));
		decorationFront.add(new NonColisionable(570, 680, Sprites.trees.getSubImage(1, 0)));
		decorationFront.add(new NonColisionable(620, 680, Sprites.trees.getSubImage(1, 0)));
		decorationFront.add(new NonColisionable(650, 680, Sprites.trees.getSubImage(1, 0)));
		decorationFront.add(new NonColisionable(690, 680, Sprites.trees.getSubImage(1, 0)));
		decorationFront.add(new NonColisionable(750, 680, Sprites.trees.getSubImage(2, 0)));
		decorationFront.add(new NonColisionable(800, 680, Sprites.trees.getSubImage(2, 0)));
		decorationFront.add(new NonColisionable(750, 680, Sprites.trees.getSubImage(2, 0)));
		decorationFront.add(new NonColisionable(650, 680, Sprites.trees.getSubImage(2, 0)));
		decorationFront.add(new NonColisionable(850, 680, Sprites.trees.getSubImage(2, 0)));
		decorationFront.add(new NonColisionable(554, 680, Sprites.trees.getSubImage(0, 0)));
		decorationFront.add(new NonColisionable(634, 680, Sprites.trees.getSubImage(0, 0)));
		decorationFront.add(new NonColisionable(704, 680, Sprites.trees.getSubImage(0, 0)));
		decorationFront.add(new NonColisionable(754, 680, Sprites.trees.getSubImage(0, 0)));
		decorationFront.add(new NonColisionable(854, 680, Sprites.trees.getSubImage(0, 0)));
		decorationFront.add(new NonColisionable(904, 680, Sprites.trees.getSubImage(0, 0)));
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		try {
			load("level.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		camera.render(arg0, arg1, arg2);
		arg2.draw(nextLevel.getHitbox());
		renderAll();
		
		character.getAnimation().draw(character.getX(),character.getY());
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		gravity(character);
		ledge(character);
		move(character);
		checkCoor(arg0);
		if(character.getHitbox().intersects(nextLevel.getHitbox())){
			arg1.enterState(nextLevel.getNextLevel());
			music.stop();
		}
		character.getState().update(arg0);
		camera.update(arg0, arg1, arg2);
		if(!music.playing()){
			music.setPosition(0.15f);
			//music.play(musicSpeed, 0.5f);
		}
		if(character.getHitbox().intersects(activate)){
			activate=new Rectangle(0, 0, 0, 0);
			music.stop();
			musicSpeed=2;
			
		}
	}
	@Override
	public int getID() {
		return 1;
	}

}
