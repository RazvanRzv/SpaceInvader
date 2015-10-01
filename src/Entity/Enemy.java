package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Graphics.ImageLoader;
import main.GamePanel;

public class Enemy {

	private ImageLoader			loader;
	public BufferedImage		enemyImg;
	private static final int	enemySize	= 32;

	private double	x;
	private double	y;
	private double	dx;
	private double	dy;
	private boolean	fire;

	private EBullet				bullet;
	public ArrayList<EBullet>	bulletArray	= new ArrayList<EBullet>();

	public Enemy() {
		loader = new ImageLoader();
		enemyImg = loader.loadImage("/Player/Enemy4.png");
	}

	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setSpeed(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public boolean colision() {
		if (this.x <= 0 || this.x >= GamePanel.WIDTH - enemySize)
			return true;
		return false;
	}

	public void update() {
		x += dx;
		y += dy;
	}

	public void draw(Graphics2D g) {
		g.drawImage(enemyImg, (int) x, (int) y, enemySize, enemySize, null);
	}

	public Rectangle getBounds() {
		return (new Rectangle((int) x, (int) y, enemySize, enemySize));
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setFire(boolean bool) {
		fire = bool;
	}

	public static int getSize() {
		return enemySize;
	}
}
