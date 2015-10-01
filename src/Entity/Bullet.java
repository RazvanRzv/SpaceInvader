package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Graphics.ImageLoader;

public class Bullet {

	private Player			player;
	private BufferedImage	bulletImg;
	public double			x;
	public double			y;
	private double			speed;
	public double			dy;

	public static double lastTimeFired = 0;

	public Bullet(Player player) {
		ImageLoader loader = new ImageLoader();
		bulletImg = loader.loadImage("/Player/Bullet.png");
		this.player = player;
		speed = 0;
		this.x = (int) player.getX()
				+ (player.getSize() - bulletImg.getWidth()) / 2;
		this.y = (int) player.getY() - bulletImg.getHeight();
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void draw(Graphics2D g) {
		g.drawImage(bulletImg, (int) x, (int) y, null);
	}

	public void move() {
		y -= speed;
	}

	public boolean removeBullet() {
		if (y < 0)
			return true;
		return false;
	}

	public boolean shootAgain() {
		double shotTime = System.currentTimeMillis();
		if (shotTime - lastTimeFired >= 1000 / player.shotsPerSecond) {
			lastTimeFired = shotTime;
			return true;
		}
		return false;
	}

	public Rectangle getBounds() {
		return (new Rectangle((int) x, (int) y, bulletImg.getWidth(),
				bulletImg.getHeight()));
	}
}
