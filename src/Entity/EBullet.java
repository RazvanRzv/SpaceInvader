package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Graphics.ImageLoader;

public class EBullet {

	private Enemy			enemy;
	private BufferedImage	bulletImg;
	public double			x;
	public double			y;
	private double			speed;
	public double			dy;

	public EBullet(Enemy enemy) {
		ImageLoader loader = new ImageLoader();
		bulletImg = loader.loadImage("/Player/EBullet.png");
		this.enemy = enemy;
		speed = 0;
		this.x = (int) enemy.getX()
				+ (enemy.enemyImg.getWidth() - bulletImg.getWidth()) / 2;
		this.y = (int) enemy.getY() - bulletImg.getHeight();
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

	public Rectangle getBounds() {
		return (new Rectangle((int) x, (int) y, bulletImg.getWidth(),
				bulletImg.getHeight()));
	}
}
