package main;

import javax.swing.JFrame;

public class GameMain {

	public static void main(String[] args) {
		JFrame window = new JFrame("Space Invaders");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		window.setLocationRelativeTo(null);
	}
}
