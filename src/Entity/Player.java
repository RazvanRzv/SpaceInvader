package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Graphics.ImageLoader;
import main.GamePanel;

public class Player {

	private ImageLoader		loader;
	private BufferedImage	playerImg;

	private double	x;
	private double	y;
	private double	dx;
	private double	dy;

	private boolean	left;
	private boolean	right;
	private boolean	down;
	private boolean	up;
	private boolean	fire;

	public boolean shootOnce;

	public Bullet				bullet;
	public ArrayList<Bullet>	bulletArray	= new ArrayList<Bullet>();

	private int playerSize = 32;

	public Player() {
		loader = new ImageLoader();
		playerImg = loader.loadImage("/Player/Player2.png");
		this.x = GamePanel.WIDTH / 2 - playerSize / 2;
		this.y = GamePanel.HEIGHT - playerSize;
		bullet = new Bullet(this);
		bulletArray.add(bullet);
	}

	public void checkAttack(ArrayList<Enemy> enemies) {
		for (int j = 0; j < enemies.size(); j++) {
			Enemy e = enemies.get(j);
			if (bulletArray.size() >= 2) {
				if (e.getBounds().intersects(bulletArray.get(1).getBounds())) {
					bulletArray.remove(1);
					enemies.remove(j);
					j--;
				}
			}
		}
	}

	public void move() {
		if (left) {
			x -= dx;
		}
		if (right) {
			x += dx;
		}
		if (down) {
			y += dy;
		}
		if (up) {
			y -= dy;
		}
		if (y < GamePanel.HEIGHT / 2 - 40)
			y = GamePanel.HEIGHT / 2 - 40;
		if (y + playerSize > GamePanel.HEIGHT)
			y = GamePanel.HEIGHT - playerSize;
		if (x < 0)
			x = 0;
		if (x + playerSize > GamePanel.WIDTH)
			x = GamePanel.WIDTH - playerSize;
	}

	public int shotsPerSecond = 3;

	public void shoot() {
		if (fire) {
			// if (bulletArray.isEmpty()) {
			// bullet = new Bullet(this);
			// bullet.setSpeed(2);
			// bulletArray.add(bullet);
			// System.out.println("shoot here");
			// }
			if ((!bulletArray.isEmpty() && bullet.shootAgain())) {
				System.out.println("shooting");
				bullet = new Bullet(this);
				bullet.setSpeed(2);
				bulletArray.add(bullet);
			}
		}

	}

	public void update() {
		shoot();

		for (int i = 0; i < bulletArray.size(); i++) {
			bulletArray.get(i).move();
			if (bulletArray.get(i).removeBullet()) {
				bulletArray.remove(i);
				i--;
			}
		}
		move();
	}

	public void draw(Graphics2D g) {
		for (int i = 1; i < bulletArray.size(); i++) {
			bulletArray.get(i).draw(g);
		}
		g.drawImage(playerImg, (int) x, (int) y, playerSize, playerSize, null);
	}

	public void setVectors(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public void setLeft(boolean bool) {
		left = bool;
	}

	public void setRight(boolean bool) {
		right = bool;
	}

	public void setUp(boolean bool) {
		up = bool;
	}

	public void setDown(boolean bool) {
		down = bool;
	}

	public void setFire(boolean bool) {
		fire = bool;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getSize() {
		return playerSize;
	}

}
