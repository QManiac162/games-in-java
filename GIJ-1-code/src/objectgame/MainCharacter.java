package objectgame;

import static userinterface.GameScreen.GRAVITY;
import static userinterface.GameScreen.GROUNDY;

import java.awt.Color;
import java.awt.Graphics;

public class MainCharacter {
	private float x = 0;
	private float y = 0;
	private float speedY = 0;
	
	public void update() {
		// all this line code for jumping
		if(y>=GROUNDY-100) {
			speedY = 0;
			y = GROUNDY-100;
		} else {
			speedY+=GRAVITY;
			y+=speedY;
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect((int)x, (int)y, 100, 100);
	}
	public void jump() {
		speedY = -4;
		y+=speedY;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getSpeedY() {
		return speedY;
	}
	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}
	
}
