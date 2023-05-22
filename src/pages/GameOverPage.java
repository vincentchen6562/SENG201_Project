package src.pages;

import src.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameOverPage {

	private JFrame frmGameOver;
	private GameEnvironment environment;
	private int totalWins;
	private int totalLosses;
	private int totalMoney;

	/**
	 * Create the application.
	 */
	public GameOverPage(GameEnvironment incomingEnvironment, int numWins, int numLoss, int moneyLeft) {
		environment = incomingEnvironment;
		totalWins = numWins;
		totalLosses = numLoss;
		totalMoney = moneyLeft;
		initialize();
		frmGameOver.setVisible(true);
	}
	
	public void closeWindow() {
		frmGameOver.dispose();
	}
	
	public void finishedWindow() {
		environment.closeGameOverPage(this);
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
		
		JLabel thankYouLabel = new JLabel("Thank You for Playing!");
		thankYouLabel.setFont(new Font("Orbitron", Font.PLAIN, 20));
		thankYouLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmGameOver.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addComponent(thankYouLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(thankYouLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		
		JLabel moneyLabel = new JLabel(String.format("Total Money: %d", totalMoney));
		moneyLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel winsLabel = new JLabel(String.format("Total Wins: %d", totalWins));
		winsLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		winsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel(String.format("Total Losses: %d", totalLosses));
		lblNewLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton closeButton = new JButton("Click Here to Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		closeButton.setFont(new Font("Orbitron", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(winsLabel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(moneyLabel, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(116, Short.MAX_VALUE)
					.addComponent(closeButton)
					.addGap(113))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(moneyLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(winsLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(closeButton)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frmGameOver.getContentPane().setLayout(groupLayout);
	}
}
