package Graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Background {

	private ImageLoader		loader;
	private BufferedImage	image;
	private double			x, y;
	private double			dx, dy;

	public Background(String path) {
		loader = new ImageLoader();
		image = loader.loadImage(path);
		this.x = 0;
		this.y = 0;
	}

	public void draw(Graphics2D g) {

		g.drawImage(image, (int) x, (int) y, GamePanel.WIDTH, GamePanel.HEIGHT,
				null);
		g.drawImage(image, (int) x - GamePanel.WIDTH, (int) y, GamePanel.WIDTH,
				GamePanel.HEIGHT, null);

		if (x == GamePanel.WIDTH)
			x = 0;
	}

	public void setSpeed(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public void update() {
		x += dx;
		y += dy;
	}
}
