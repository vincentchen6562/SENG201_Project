package src.pages;

import src.*;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class GameOverPage {

	private JFrame frmGameOver;
	private GameEnvironment environment;

	/**
	 * Create the application.
	 */
	public GameOverPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frmGameOver.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGameOver = new JFrame();
		frmGameOver.setTitle("Game Over");
		frmGameOver.setResizable(false);
		frmGameOver.setBounds(100, 100, 450, 300);
		frmGameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
