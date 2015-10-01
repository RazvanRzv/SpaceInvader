package Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	public BufferedImage	image;
	private int				spriteSize;

	public SpriteSheet(BufferedImage image, int spriteSize) {
		this.image = image;
		this.spriteSize = spriteSize;
	}

	public BufferedImage getImage(int col, int row) {

		BufferedImage img;
		img = image.getSubimage((col * spriteSize) - spriteSize,
				(row * spriteSize) - spriteSize, spriteSize, spriteSize);
		return img;

	}
}
