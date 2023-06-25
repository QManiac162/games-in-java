package objectgame;

import static userinterface.GameScreen.GROUNDY;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import userinterface.GameScreen;
import util.Resource;

public class Land {
	
	private List<ImageLand> listImage;
	
	private BufferedImage imageLand1;
	private BufferedImage imageLand2;
	private BufferedImage imageLand3;
	
	public Land(GameScreen game) {
		imageLand1 = Resource.getResourceImage("data/land1.png");
		imageLand2 = Resource.getResourceImage("data/land2.png");
		imageLand3 = Resource.getResourceImage("data/land3.png");
		listImage = new ArrayList<ImageLand>();
		int numberOfLandTiles = 600 / imageLand1.getWidth()+2;
		
		for(int i=0; i<numberOfLandTiles; i++) {
			ImageLand imageLand = new ImageLand();
			imageLand.posX = (int)(i*imageLand1.getWidth());
			imageLand.image = imageLand1;
			listImage.add(imageLand);
		}
	}
	public void update() {
		for(ImageLand imageLand: listImage) {
			imageLand.posX--;
		}
		ImageLand firstElement = listImage.get(0);
		if(firstElement.posX+imageLand1.getWidth()<0) {
			firstElement.posX = listImage.get(listImage.size()-1).posX + imageLand1.getWidth();
			listImage.add(firstElement);
			listImage.remove(0);
		}
	}
	public void draw(Graphics g) {
		for(ImageLand imageLand: listImage) {
			g.drawImage(imageLand.image, imageLand.posX, (int)GROUNDY-15, null);
		}
	}
	private class ImageLand{
		int posX;
		BufferedImage image;
	}
}
