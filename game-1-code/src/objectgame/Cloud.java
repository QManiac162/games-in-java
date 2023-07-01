package objectgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import util.Resource;

public class Cloud {
	private BufferedImage cloudImage;
	private List<ImageCloud> clouds;
	
	public Cloud() {
		cloudImage = Resource.getResourceImage("data/cloud.png");
		clouds = new ArrayList<ImageCloud>();
		
		ImageCloud cloud1 = new ImageCloud();
		cloud1.posX = 100;
		cloud1.posY = 50;
		clouds.add(cloud1);
		
		ImageCloud cloud2 = new ImageCloud();
		cloud2.posX = 300;
		cloud2.posY = 25;
		clouds.add(cloud2);
		
		ImageCloud cloud3 = new ImageCloud();
		cloud3.posX = 450;
		cloud3.posY = 45;
		clouds.add(cloud3);
		
		ImageCloud cloud4 = new ImageCloud();
		cloud4.posX = 650;
		cloud4.posY = 60;
		clouds.add(cloud4);
	}
	public void update() {
		for(ImageCloud cloud: clouds) {
			cloud.posX--;
		}
		ImageCloud firstCloud = clouds.get(0);
		if(firstCloud.posX + cloudImage.getWidth() < 0) {
			firstCloud.posX = 600;
			clouds.remove(firstCloud);
			clouds.add(firstCloud);
		}
		
	}
	public void draw(Graphics g) {
		for(ImageCloud cloud: clouds) {
			g.drawImage(cloudImage, (int)cloud.posX, (int)cloud.posY, null);
		}
	}
	private class ImageCloud{
		float posX;
		float posY;
	}
}
