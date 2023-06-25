package objectgame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import util.Resource;

public class Cactus extends CactusEnemy{
	private BufferedImage Cactusimage;
	private int posX;
	private int posY;
	private Rectangle rect;
	private MainCharacter mainCharacter;
	private boolean isScoreGot = false;
	
	public Cactus(MainCharacter mainCharacter) {
		this.mainCharacter = mainCharacter;
		rect = new Rectangle();
	}
	public void update() {
		posX-=5;
		rect.x = posX;
		rect.y = posY;
		rect.width = Cactusimage.getWidth();
		rect.height = Cactusimage.getHeight();
	}
	public Rectangle getBound() {
		return rect;
	}
	public void draw(Graphics g) {
		g.drawImage(Cactusimage, posX, posY, null);
	}
	public void setX(int x) {
		posX = x;
	}
	public void setY(int y) {
		posY = y;
	}
	public void setImage(BufferedImage image) {
		this.Cactusimage = image;
	}
	public boolean isOutOfScreen() {
		return posX + Cactusimage.getWidth() < 0;
	}
	public boolean isOver() {
		return mainCharacter.getX() > posX;
	}
	public boolean isScoreGot() {
		return isScoreGot;
	}
	public void setScoreGot(boolean isScoreGot) {
		this.isScoreGot = isScoreGot;
	}
}
