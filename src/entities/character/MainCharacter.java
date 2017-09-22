package entities.character;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import entities.Colisionable;
import entities.character.states.BaseState;
import entities.character.states.StateStill;

public class MainCharacter extends Colisionable{
	private float speed;
	private float maxSpeed = 8;
	private float ySpeed = 0;
	private BaseState state;
	private SpriteSheet spriteSheet;
	private Shape hitboxGravity;
	private Shape checkLedge;
	private Shape checkWall;
	private Shape checkCeiling;
	private Shape hitboxHp;
	private boolean direction;
	private boolean falling;
	private boolean wall;
	private boolean crouch;
	private float checkLedgeWidth = maxSpeed+1;
	public MainCharacter() throws SlickException {
		x = 40;
		spriteSheet = new SpriteSheet("data/personaje.png", 128, 100);
		state = new StateStill(this);
		hitboxHp=new Rectangle(0, 0, 0, 0);
		hitbox=new Rectangle(0, 0, 0, 0);
		checkWall=new Rectangle(0, 0, 0, 0);
		checkLedge=new Rectangle(0, 0, 0, 0);
		hitboxGravity=new Rectangle(0, 0, 0, 0);
		checkCeiling=new Rectangle(0, 0, 0, 0);
	}
	public boolean isCrouch() {
		return crouch;
	}
	public void setCrouch(boolean crouch) {
		this.crouch = crouch;
	}
	public Shape getCheckCeiling() {
		return checkCeiling;
	}
	public Shape getHitboxHp() {
		return hitboxHp;
	}
	public void updateHitbox(){
		hitboxHp = new Rectangle(x+animation.getWidth()/3, y+animation.getHeight()/3, animation.getWidth()/2, animation.getHeight()/1.5f);
		checkCeiling = new Rectangle(x+animation.getWidth()/2.1f, y, spriteSheet.getSubImage(0, 0).getWidth()/10, 10);
		if(ySpeed>=0){
			hitboxGravity = new Rectangle(x+animation.getWidth()/2f, y+animation.getHeight(), spriteSheet.getSubImage(0, 0).getWidth()/10, ySpeed);
		}
		if(ySpeed<0){
			hitboxGravity = new Rectangle(x+animation.getWidth()/2f, y, spriteSheet.getSubImage(0, 0).getWidth()/10, ySpeed);
		}
		if(direction){
			hitbox = new Rectangle(x+animation.getWidth()/1.65f, y+20, speed, animation.getHeight()-30);
			checkWall = new Rectangle(x+animation.getWidth()/1.5f, y+15, checkLedgeWidth, animation.getHeight()/4);
			checkLedge = new Rectangle(x+animation.getWidth()/1.5f, y+5, checkLedgeWidth, 10);
		}else{
			hitbox = new Rectangle(x+animation.getWidth()/2.9f, y+20, speed, animation.getHeight()-30);
			checkWall = new Rectangle(x+animation.getWidth()/3, y+15, -checkLedgeWidth, animation.getHeight()/4);
			checkLedge = new Rectangle(x+animation.getWidth()/3, y+5, -checkLedgeWidth, 10);
		}
	}
	public void updateHitboxCrouch(boolean direction){
		hitboxHp = new Rectangle(x+animation.getWidth()/3, y+animation.getHeight()/1.5f, animation.getWidth()/2, animation.getHeight()/3);
		checkCeiling = new Rectangle(x+animation.getWidth()/2.5f, y, spriteSheet.getSubImage(0, 0).getWidth()/5, 10);
		if(ySpeed>=0){
			hitboxGravity = new Rectangle(x+animation.getWidth()/2.5f, y+animation.getHeight(), spriteSheet.getSubImage(0, 0).getWidth()/5, ySpeed);
		}
		if(direction){
			hitbox = new Rectangle(x+animation.getWidth(), y+animation.getHeight()/1.5f, speed, 10);
		}else{
			hitbox = new Rectangle(x, y+animation.getHeight()/1.5f, speed, 10);
		}
	}
	public Shape getCheckLedge() {
		return checkLedge;
	}
	public Shape getCheckWall() {
		return checkWall;
	}
	public boolean isFalling() {
		return falling;
	}
	public void setFalling(boolean falling) {
		this.falling = falling;
	}
	public float getSpeed() {
		return speed;
	}
	public boolean isDirection() {
		return direction;
	}
	public void setDirection(boolean direction) {
		this.direction = direction;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public float getMaxSpeed() {
		return maxSpeed;
	}
	public BaseState getState() {
		return state;
	}
	public void setState(BaseState state) {
		this.state = state;
	}
	public SpriteSheet getSpriteSheet() {
		return spriteSheet;
	}
	public float getySpeed() {
		return ySpeed;
	}
	public void setySpeed(float ySpeed) {
		this.ySpeed = ySpeed;
	}
	public Shape getHitboxGravity() {
		return hitboxGravity;
	}
	public void setHitboxGravity(Shape hitboxGravity) {
		this.hitboxGravity = hitboxGravity;
	}
	public boolean isWall() {
		return wall;
	}
	public void setWall(boolean wall) {
		this.wall = wall;
	}

}
