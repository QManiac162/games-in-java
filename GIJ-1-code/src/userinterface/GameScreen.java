package userinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

import objectgame.Cloud;
import objectgame.Land;
import objectgame.MainCharacter;

public class GameScreen extends JPanel implements Runnable, KeyListener{
	
	public static final float GRAVITY = 0.2f;
	public static final float GROUNDY = 100; // by pixels
	
	private MainCharacter mainCharacter;
	private Thread thread;
	private Land land;
	private Cloud cloud;
	
	public GameScreen() {
		thread = new Thread(this);
		mainCharacter = new MainCharacter();
		mainCharacter.setX(50);
		land = new Land(this);
		cloud = new Cloud();
	}
	public void startGame() {
		thread.start();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				mainCharacter.update();
				land.update();
				cloud.update();
				repaint();
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.GRAY);
		cloud.draw(g);
		land.draw(g);
		mainCharacter.draw(g);
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		mainCharacter.jump();
		System.out.println("Key Presses!");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Key Released!");
	}
}