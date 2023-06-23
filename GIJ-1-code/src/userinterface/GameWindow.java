package userinterface;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameWindow extends JFrame{
	public GameWindow() {
		super("Game-In-Java: google dino game");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new GameWindow().setVisible(true);
	}
	public void paint(Graphics g) {
		// command to add background: 
		super.paint(g);
		// to draw lines in GameWindow: 
		g.drawLine(10, 10, 100, 100);
		
		BufferedImage image = null;
		
		// since this method to import picture is an exception, we surround with try catch
		try {
			image  =ImageIO.read(new File("data/cactus1.png"));
			g.drawImage(image, 100, 100, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
