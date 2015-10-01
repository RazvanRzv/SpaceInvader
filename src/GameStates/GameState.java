package GameStates;

import java.awt.Graphics2D;

public abstract class GameState {

	protected GameStateManager gsm;

	public abstract void init();

	public abstract void update();

	public abstract void draw(Graphics2D g);

	public abstract void keyPressed(int key);

	public abstract void keyReleased(int key);
}
