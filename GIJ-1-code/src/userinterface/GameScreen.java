package userinterface;

import static userinterface.GameScreen.GROUNDY;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import objectgame.MainCharacter;

public class GameScreen extends JPanel implements Runnable, KeyListener{
	
	public static final float GRAVITY = 0.1f;
	public static final float GROUNDY = 300; // by pixels
	
	private MainCharacter mainCharacter;
	private Thread thread;
	
	public GameScreen() {
		thread = new Thread(this);
		mainCharacter = new MainCharacter();
		
	}
	public void startGame() {
		thread.start();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				mainCharacter.update();
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
		g.setColor(Color.RED);
		g.drawLine(0, (int)GROUNDY, getWidth(), (int)GROUNDY);
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