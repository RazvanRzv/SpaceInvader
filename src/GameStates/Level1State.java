package GameStates;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Entity.Enemy;
import Entity.Player;
import Graphics.Background;
import main.GamePanel;

public class Level1State extends GameState {

	Background			bg1, bg2;
	Player				player;
	ArrayList<Enemy>	enemies;
	Enemy				enemy;
	int					rand;

	public Level1State(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}

	@Override
	public void init() {
		bg1 = new Background("/Backgrounds/Level1Background.png");
		enemies = new ArrayList<Enemy>();
		populateWithEnemies();
		player = new Player();
		player.setVectors(3, 3);

	}

	public void populateWithEnemies() {
		int offsetX = 15;
		int spaceX = 10;
		int offsetY = 10;
		for (int i = 0; i < ((GamePanel.WIDTH
				/ (Enemy.getSize() + spaceX))); i++) {
			for (int j = 0; j < 4; j++) {
				Enemy enemy = new Enemy();
				enemy.setPosition(offsetX + (Enemy.getSize() + spaceX) * i,
						offsetY + Enemy.getSize() * j);
//				enemy.setSpeed(1, 0);
				enemies.add(enemy);
			}
		}
	}

	@Override
	public void update() {
		player.update();
		player.checkAttack(enemies);
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update();
		}
//		if (enemies.get(0).colision()) {
//			for (int i = 0; i < enemies.size(); i++) {
//				enemies.get(i).setSpeed(1, 0);
//			}
//			 } else if (enemies.get(enemies.size() - 1).colision()) {
//			for (int i = 0; i < enemies.size(); i++) {
//				enemies.get(i).setSpeed(-1, 0);
//			}
//		}
	}

	@Override
	public void draw(Graphics2D g) {
		bg1.draw(g);
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}
		player.draw(g);
	}

	@Override
	public void keyPressed(int key) {
		if (key == KeyEvent.VK_LEFT) {
			player.setLeft(true);
		}
		if (key == KeyEvent.VK_RIGHT) {
			player.setRight(true);
		}
		if (key == KeyEvent.VK_UP) {
			player.setUp(true);
		}
		if (key == KeyEvent.VK_DOWN) {
			player.setDown(true);
		}
		if (key == KeyEvent.VK_SPACE) {
			player.setFire(true);

		}
	}

	@Override
	public void keyReleased(int key) {
		if (key == KeyEvent.VK_LEFT) {
			player.setLeft(false);
		}
		if (key == KeyEvent.VK_RIGHT) {
			player.setRight(false);
		}
		if (key == KeyEvent.VK_UP) {
			player.setUp(false);
		}
		if (key == KeyEvent.VK_DOWN) {
			player.setDown(false);
		}
		if (key == KeyEvent.VK_SPACE) {
			player.setFire(false);
		}
		if (key == KeyEvent.VK_Q) {
			// System.out.println(player.getX());
//			System.out.println(enemies.size());
			 System.out.println(player.bulletArray.size());
		}
	}

}
