package objectgame;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class CactusEnemy {
	public abstract Rectangle getBound();
	public abstract void draw(Graphics g);
	public abstract void update();
	public abstract boolean isOutOfScreen();
	public abstract boolean isOver();
	public abstract boolean isScoreGot();
	public abstract void setScoreGot(boolean isScoreGot);
}
