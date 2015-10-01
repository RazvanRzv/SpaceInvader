package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Graphics.Background;

public class MenuState extends GameState {

	private Background	bg;
	private String[]	options	= { "Start", "Help", "Exit" };
	private Font		titleFont, optionsFont;
	private Color		normalColor, selectColor, titleColor;
	private int			currentOption;

	public MenuState(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}

	@Override
	public void init() {
		// bg = new Background("/Backgrounds/background2.png");
		bg = new Background("/Backgrounds/menuBackground.jpg");
		titleFont = new Font("Imparct", Font.BOLD, 20);
		optionsFont = new Font("Arial", Font.PLAIN, 15);
		normalColor = Color.BLUE;
		selectColor = Color.RED;
		titleColor = Color.GREEN;
		bg.setSpeed(0.35, 0);
	}

	@Override
	public void update() {
		bg.update();
	}

	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Space Invaders", 175, 50);

		g.setFont(optionsFont);
		for (int i = 0; i < options.length; ++i) {
			if (i == currentOption) {
				g.setColor(selectColor);
			} else {
				g.setColor(normalColor);
			}
			g.drawString(options[i], 220, 120 + i * 30);
		}
	}

	public void selectOption() {
		if (currentOption == 0) {
			gsm.setState(GameStateManager.LEVEL1STATE);
		}
		if (currentOption == 1) {
			// HelpState
		}
		if (currentOption == 2) {
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(int key) {
		if (key == KeyEvent.VK_UP) {
			currentOption--;
			if (currentOption == -1)
				currentOption = options.length - 1;
		}
		if (key == KeyEvent.VK_DOWN) {
			currentOption++;
			if (currentOption > options.length - 1)
				currentOption = 0;
		}
		if (key == KeyEvent.VK_ENTER) {
			selectOption();
		}
	}

	@Override
	public void keyReleased(int key) {}
}
