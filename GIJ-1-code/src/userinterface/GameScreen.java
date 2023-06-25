package userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import objectgame.CactusEnemyManager;
import objectgame.Cloud;
import objectgame.Land;
import objectgame.MainCharacter;
import util.Resource;

public class GameScreen extends JPanel implements Runnable, KeyListener{
	public static final int GAME_FIRST_STATE = 0;
	public static final int GAME_PLAY_STATE = 1;
	public static final int GAME_OVER_STATE = 2;
	
	public static final float GRAVITY = 0.15f;
	public static final float GROUNDY = 100; // by pixels
	
	private MainCharacter mainCharacter;
	private Thread thread;
	private Land land;
	private Cloud cloud;
	private CactusEnemyManager cactusEnemyManager;
	private int score;
	
	private int gameState = GAME_FIRST_STATE;
	private BufferedImage imageGameOverText;
	private BufferedImage replay;
	
	public GameScreen() {
		thread = new Thread(this);
		mainCharacter = new MainCharacter();
		mainCharacter.setX(50);
		land = new Land(this);
		cloud = new Cloud();
		cactusEnemyManager = new CactusEnemyManager(mainCharacter, this);
		imageGameOverText = Resource.getResourceImage("data/gameover_text.png");
		replay = Resource.getResourceImage("data/replay_button.png");
	}
	public void startGame() {
		thread.start();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				update();
				repaint();
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void update() {
		switch(gameState) {
			case GAME_PLAY_STATE:
				mainCharacter.update();
				land.update();
				cloud.update();
				cactusEnemyManager.update();
				if(!mainCharacter.getAlive()) {
					gameState = GAME_OVER_STATE;
				}
				break;
		}
	}
	public void plusScore(int score) {
		this.score += score;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		switch(gameState) {
			case GAME_FIRST_STATE:
				mainCharacter.draw(g);
				break;
			case GAME_PLAY_STATE:
				cloud.draw(g);
				land.draw(g);
				mainCharacter.draw(g);
				cactusEnemyManager.draw(g);
				g.setColor(Color.GRAY);
				g.setFont(new Font("Noto Sans JP", Font.BOLD, 15));
				g.drawString("HS: "+String.valueOf(score), 500, 20);
				break;
			case GAME_OVER_STATE:
				cloud.draw(g);
				land.draw(g);
				mainCharacter.draw(g);
				cactusEnemyManager.draw(g);
				g.drawImage(imageGameOverText, 200, 30, null);
				g.drawImage(replay, 270, 50, null);
				break;
		}

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Key Presses!");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				if(gameState == GAME_FIRST_STATE) {
					gameState = GAME_PLAY_STATE;
				} else if(gameState == GAME_PLAY_STATE) {
					mainCharacter.jump();
				} else if(gameState == GAME_OVER_STATE) {
					gameState = GAME_PLAY_STATE;
				}
				break;
		}
		System.out.println("Key Released!");
	}
}