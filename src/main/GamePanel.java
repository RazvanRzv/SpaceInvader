package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import GameStates.GameStateManager;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {

	// dimensions
	public static final int		WIDTH	= 540;
	public static final int		HEIGHT	= WIDTH / 16 * 9;
	public static final int		SCALE	= 2;
	public static final int		FPS		= 60;
	public static final double	DT		= 1000000000.0 / (double) FPS;

	private Thread		thread;
	private Keyboard	key;
	private boolean		running	= false;

	private BufferedImage	image;
	private Graphics2D		g;

	private GameStateManager gsm;

	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();

		this.addKeyListener(key);
	}

	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}

	private void init() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		gsm = new GameStateManager();
		running = true;
	}

	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0;
		int updates = 0;
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / DT;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			draw();
			drawToScreen();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
//				System.out.println(updates + " UPS " + frames + " FPS");
				updates = 0;
				frames = 0;
			}
		}
	}

	public void update() {
		gsm.update();
	}

	public void draw() {
		gsm.draw(g);
	}

	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g2.dispose();
	}

	@Override
	public void keyPressed(KeyEvent key) {
		gsm.keyPressed(key.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent key) {
		gsm.keyReleased(key.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent key) {}

}
