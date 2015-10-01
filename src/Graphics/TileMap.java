package Graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileMap {

	ImageLoader loader;

	private double	x;
	private double	y;

	private int	xMin;
	private int	xMax;
	private int	yMin;
	private int	yMax;

	private int[][]	map;
	private int		tileSize;
	private int		rows;
	private int		cols;
	private int		width;
	private int		height;

	private BufferedImage	tileImage;
	private int				tilesAcross;
	// public Tile[][] tiles;
	public BufferedImage[]	tiles;

	private int	rowsToDraw;
	private int	colsToDraw;

	public TileMap(int tileSize, String path) {
		this.tileSize = tileSize;
		loader = new ImageLoader();
		tileImage = loader.loadImage(path);
		rowsToDraw = GamePanel.HEIGHT / tileSize + 2;
		colsToDraw = GamePanel.WIDTH / tileSize + 2;

	}

	public void loadTiles() {

		tilesAcross = tileImage.getWidth() / tileSize;
		tiles = new BufferedImage[tilesAcross];

		for (int col = 0; col < tilesAcross; col++) {
			tiles[col] = tileImage.getSubimage(col * tileSize, 0, tileSize,
					tileSize);
		}
	}

	public void draw(Graphics2D g) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				// g.drawImage(tiles[0], tileSize * j, 270 - tileSize * i,
				// null);
			}
		}
	}

}
