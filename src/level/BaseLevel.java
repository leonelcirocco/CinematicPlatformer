package level;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;

import entities.BaseEntity;
import entities.Colisionable;
import entities.Floor;
import entities.NonColisionable;
import entities.Sprites;
import entities.character.Enemy;
import entities.character.MainCharacter;
import entities.character.states.StateFalling;
import entities.character.states.StateLedge;
import main.Camera;
import main.Options;

public abstract class BaseLevel extends BasicGameState{

	protected File file /*= new File("level.txt")*/;
	protected Scanner fileIn;
	protected ArrayList<Colisionable>floor = new ArrayList<>();
	protected Camera camera;
	protected ArrayList<Colisionable>movingFloor = new ArrayList<>();
	protected ArrayList<NonColisionable>background = new ArrayList<>();
	protected ArrayList<NonColisionable>decoration = new ArrayList<>();
	protected ArrayList<NonColisionable>decorationFront = new ArrayList<>();
	protected ArrayList<Enemy> enemy = new ArrayList<>();
	protected MainCharacter character;
	protected Sprites sprites;
	public BaseLevel() throws SlickException {
		 sprites = new Sprites();
	}
	protected void renderAll(){
		for(int i=0;i<background.size();i++){
			draw(background.get(i));
		}
		for(int i=0;i<decoration.size();i++){
			draw(decoration.get(i));
		}
		for(int i=0;i<decorationFront.size();i++){
			draw(decorationFront.get(i));
		}
		for(int i=0;i<floor.size();i++){
			draw(floor.get(i));
		}
		for(int i=0;i<enemy.size();i++){
			draw(enemy.get(i));
		}
	}
	protected void gravity(MainCharacter character){
		boolean fall = true;
		float y = 0;
		for(int i=0;i<floor.size();i++){
			if(character.getHitboxGravity().intersects(floor.get(i).getHitbox())){
				if(character.getHitboxGravity().getY()<=character.getY()){
					//character.setY(floor.get(i).getY()+floor.get(i).getAnimation().getHeight()*2);
					character.setySpeed(0);
					character.setState(new StateFalling(character));
					fall=true;
					
				}else{
					fall = false;
					y=floor.get(i).getY();
				}
			}
		}
		if(fall){
			character.setFalling(true);
		}else{
			character.setY(y-character.getAnimation().getHeight());
			character.setySpeed(0);
			character.setFalling(false);
		}

		character.setY(character.getY()+character.getySpeed());
	}
	protected void checkCoor(GameContainer arg0){
		if(arg0.getInput().isKeyPressed(Input.KEY_Q)){
			System.out.println(character.getX());
			System.out.println(character.getY());
		}
		if(arg0.getInput().isKeyPressed(Input.KEY_E)){

		character.setX(1782);
		character.setY(182);
		}
	}
	protected void ledge(MainCharacter character){
		boolean wall = false;
		boolean ledge = true;
		character.setWall(false);
		Colisionable colisionable = null;
		float y=0;
		float x=0;
		character.setCrouch(false);
		for(int i=0;i<floor.size();i++){
			if(character.getCheckCeiling().intersects(floor.get(i).getHitbox())){
				character.setCrouch(true);
			}
			if(character.getCheckWall().intersects(floor.get(i).getHitbox())){
				wall=true;
				y=floor.get(i).getY();
				x=floor.get(i).getX();
				colisionable = floor.get(i);
				character.setWall(true);
			}
			if(character.getCheckLedge().intersects(floor.get(i).getHitbox())){
				ledge = false;
			}
		}
		if(wall && ledge&&character.getySpeed()!=0){
			character.setState(new StateLedge(character,colisionable));
			character.setY(y);
			if(character.isDirection()){
				character.setX(x-character.getAnimation().getWidth()/1.8f);
			}else{
				character.setX(x-30);
			}
		}
	}
	public void move(MainCharacter character){
		boolean move = true;
		for(int i=0;i<floor.size();i++){
			if(character.getHitbox().intersects(floor.get(i).getHitbox())){
				move=false;
			}
		}
		if(move){
			character.setX(character.getX()+character.getSpeed());
		}else{
			if(!character.isFalling()){
			character.setSpeed(0);
			}
		}
	}
	protected void load(String fileName) throws SlickException, FileNotFoundException{
			floor.clear();
			file = new File(fileName);
			fileIn = new Scanner(file);
			while(fileIn.hasNextLine()){
				String string = fileIn.nextLine();
				String xstring = string.substring(string.indexOf('x')+1, string.indexOf('y'));
				String ystring = string.substring(string.indexOf('y')+1, string.indexOf('r'));
				String imageRoute = string.substring(string.indexOf('r')+1, string.indexOf('c'));
				String imageCoor = string.substring(string.indexOf('c')+1, string.indexOf('|'));
				float x = Float.parseFloat(xstring);
				float y = Float.parseFloat(ystring);
				int coorx = Integer.valueOf(imageCoor.substring(0, imageCoor.indexOf(',')));
				int coory = Integer.valueOf(imageCoor.substring(imageCoor.indexOf(',')+1, imageCoor.length()));
				SpriteSheet spriteSheet = new SpriteSheet(imageRoute, 32, 32);
				Image image = spriteSheet.getSubImage(coorx, coory);
				image.setName(coorx+","+coory);
				floor.add(new Floor(x, y, image));
			}
			fileIn = new Scanner(file);
			fileIn = new Scanner(new File("bbb.txt"));
			while(fileIn.hasNextLine()){
				String string = fileIn.nextLine();
				String xstring = string.substring(string.indexOf('x')+1, string.indexOf('y'));
				String ystring = string.substring(string.indexOf('y')+1, string.indexOf('r'));
				String imageRoute = string.substring(string.indexOf('r')+1, string.indexOf('c'));
				String imageCoor = string.substring(string.indexOf('c')+1, string.indexOf('|'));
				float x = Float.parseFloat(xstring);
				float y = Float.parseFloat(ystring);
				int coorx = Integer.valueOf(imageCoor.substring(0, imageCoor.indexOf(',')));
				int coory = Integer.valueOf(imageCoor.substring(imageCoor.indexOf(',')+1, imageCoor.length()));
				SpriteSheet spriteSheet = new SpriteSheet(imageRoute, 32, 32);
				Image image = spriteSheet.getSubImage(coorx, coory);
				image.setName(coorx+","+coory);
				background.add(new NonColisionable(x, y, image));
			}
			fileIn = new Scanner(new File("decoration.txt"));
			while(fileIn.hasNextLine()){
				String string = fileIn.nextLine();
				String xstring = string.substring(string.indexOf('x')+1, string.indexOf('y'));
				String ystring = string.substring(string.indexOf('y')+1, string.indexOf('r'));
				String imageRoute = string.substring(string.indexOf('r')+1, string.indexOf('c'));
				String imageCoor = string.substring(string.indexOf('c')+1, string.indexOf('|'));
				float x = Float.parseFloat(xstring);
				float y = Float.parseFloat(ystring);
				int coorx = Integer.valueOf(imageCoor.substring(0, imageCoor.indexOf(',')));
				int coory = Integer.valueOf(imageCoor.substring(imageCoor.indexOf(',')+1, imageCoor.length()));
				SpriteSheet spriteSheet = new SpriteSheet(imageRoute, 32, 32);
				Image image = spriteSheet.getSubImage(coorx, coory);
				image.setName(coorx+","+coory);
				decoration.add(new NonColisionable(x, y, image));
			}
			fileIn = new Scanner(new File("decorationFront.txt"));
			while(fileIn.hasNextLine()){
				String string = fileIn.nextLine();
				String xstring = string.substring(string.indexOf('x')+1, string.indexOf('y'));
				String ystring = string.substring(string.indexOf('y')+1, string.indexOf('r'));
				String imageRoute = string.substring(string.indexOf('r')+1, string.indexOf('c'));
				String imageCoor = string.substring(string.indexOf('c')+1, string.indexOf('|'));
				float x = Float.parseFloat(xstring);
				float y = Float.parseFloat(ystring);
				int coorx = Integer.valueOf(imageCoor.substring(0, imageCoor.indexOf(',')));
				int coory = Integer.valueOf(imageCoor.substring(imageCoor.indexOf(',')+1, imageCoor.length()));
				SpriteSheet spriteSheet = new SpriteSheet(imageRoute, 32, 32);
				Image image = spriteSheet.getSubImage(coorx, coory);
				image.setName(coorx+","+coory);
				decorationFront.add(new NonColisionable(x, y, image));
			}
	}
	protected void draw(BaseEntity object){
		if(object.getX()+200>camera.getX()&&object.getX()<camera.getX()+Options.WIDTH){
			if(object.getY()+200>camera.getY()&&object.getY()<camera.getY()+Options.HEIGTH){
				object.getAnimation().draw(object.getX(), object.getY());
			}
			
		}
	}
}
