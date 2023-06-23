package userinterface;

import java.awt.Color;
import javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable{
	
	private int i = 0;
	private Thread thread;
	
	public GameScreen() {
		// to color the game screen: setBackground(Color.RED);
		thread = new Thread(this);
	}
	public void startGame() {
		thread.start();
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(i++);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
