package entities;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Sprites {
	public static SpriteSheet trees;
	public Sprites() throws SlickException {
		trees = new SpriteSheet("data/arbol.png", 115, 256);
	}
}
