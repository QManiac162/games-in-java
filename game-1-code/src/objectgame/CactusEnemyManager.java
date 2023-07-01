package objectgame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import userinterface.GameScreen;
import util.Resource;

public class CactusEnemyManager {
	// since list can extend to abstract classes, we don't need separate object here
	private List<CactusEnemy> enemy;
	private Random random;
	
	private BufferedImage imageCactus1;
	private BufferedImage imageCactus2;
	
	private MainCharacter mainCharacter;
	private GameScreen gameScreen;
	
	@SuppressWarnings("removal")
	private AudioClip deadSound;
	
	public CactusEnemyManager(MainCharacter mainCharacter, GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		this.mainCharacter = mainCharacter;
		enemy = new ArrayList<CactusEnemy>();
		imageCactus1 = Resource.getResourceImage("data/cactus1.png");
		imageCactus2 = Resource.getResourceImage("data/cactus2.png");
		random = new Random();
		enemy.add(getRandomCactus());
		try {
			deadSound = Applet.newAudioClip(new URL("file","","data/dead.wav"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update() {
		for(CactusEnemy e: enemy) {
			e.update();
			if(e.isOver() && !e.isScoreGot()) {
				gameScreen.plusScore(10);
				e.setScoreGot(true);
			}
			if(e.getBound().intersects(mainCharacter.getBound())) {
				deadSound.play();
				mainCharacter.setAlive(false);
			}
		}
		CactusEnemy firstEnemy = enemy.get(0);
		if(firstEnemy.isOutOfScreen()) {
			enemy.remove(firstEnemy);
			enemy.add(getRandomCactus());
		}
		
	}
	public void draw(Graphics g) {
		for(CactusEnemy e: enemy) {
			e.draw(g);
		}
	}
	public void reset() {
		enemy.clear();
		enemy.add(getRandomCactus());
	}
	private Cactus getRandomCactus() {
		Cactus cactus = new Cactus(mainCharacter);
		cactus.setX(600);
		if(random.nextBoolean()) {
			cactus.setImage(imageCactus1);
			cactus.setY(50);
		} else {
			cactus.setImage(imageCactus2);
			cactus.setY(61);
		}
		return cactus;
	}
}
