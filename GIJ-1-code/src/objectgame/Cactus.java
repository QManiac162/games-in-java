package objectgame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import util.Resource;

public class Cactus {
	private BufferedImage Cactusimage;
	private int posX;
	private int posY;
	private Rectangle rect;
	
	public Cactus() {
		Cactusimage = Resource.getResourceImage("data/cactus1.png");
		posX = 500;
		posY = 50;
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
}
