package src.pages;

import src.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class MatchPage {

	private JFrame frmMatchPage;
	private GameEnvironment environment;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MatchPage window = new MatchPage();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public MatchPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frmMatchPage.setVisible(true);
	}
	
	public void closeWindow() {
		frmMatchPage.dispose();
	}
	
	public void finishedWindow() {
		environment.closeMatchPage(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMatchPage = new JFrame();
		frmMatchPage.setBounds(100, 100, 450, 630);
		frmMatchPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel teamNamespanel = new JPanel();
		
		JPanel centerPositionPanel = new JPanel();
		centerPositionPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel centerPositionPanel_1 = new JPanel();
		centerPositionPanel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel centerPositionPanel_2 = new JPanel();
		centerPositionPanel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel centerPositionPanel_3 = new JPanel();
		centerPositionPanel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel centerPositionPanel_4 = new JPanel();
		centerPositionPanel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel scoreBoardPanel = new JPanel();
		scoreBoardPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JButton btnFinishButton = new JButton("FINISH");
		btnFinishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnFinishButton.setFont(new Font("Orbitron", Font.BOLD, 12));
		GroupLayout groupLayout = new GroupLayout(frmMatchPage.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(142)
							.addComponent(btnFinishButton, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scoreBoardPanel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(centerPositionPanel_4, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(centerPositionPanel_3, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(centerPositionPanel_2, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
								.addComponent(centerPositionPanel_1, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
								.addComponent(teamNamespanel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
								.addComponent(centerPositionPanel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(teamNamespanel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerPositionPanel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerPositionPanel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerPositionPanel_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerPositionPanel_3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerPositionPanel_4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scoreBoardPanel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(btnFinishButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		GroupLayout gl_scoreBoardPanel = new GroupLayout(scoreBoardPanel);
		gl_scoreBoardPanel.setHorizontalGroup(
			gl_scoreBoardPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 348, Short.MAX_VALUE)
		);
		gl_scoreBoardPanel.setVerticalGroup(
			gl_scoreBoardPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 76, Short.MAX_VALUE)
		);
		scoreBoardPanel.setLayout(gl_scoreBoardPanel);
		
		JLabel pointGuardLabel = new JLabel("Point Guard");
		pointGuardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pointGuardLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JPanel centerScorePanel_3 = new JPanel();
		GroupLayout gl_centerPositionPanel_3 = new GroupLayout(centerPositionPanel_3);
		gl_centerPositionPanel_3.setHorizontalGroup(
			gl_centerPositionPanel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_centerPositionPanel_3.createSequentialGroup()
					.addGap(131)
					.addComponent(pointGuardLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
					.addComponent(centerScorePanel_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
		);
		gl_centerPositionPanel_3.setVerticalGroup(
			gl_centerPositionPanel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(centerScorePanel_3, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
				.addGroup(gl_centerPositionPanel_3.createSequentialGroup()
					.addComponent(pointGuardLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		GroupLayout gl_centerScorePanel_3 = new GroupLayout(centerScorePanel_3);
		gl_centerScorePanel_3.setHorizontalGroup(
			gl_centerScorePanel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 60, Short.MAX_VALUE)
		);
		gl_centerScorePanel_3.setVerticalGroup(
			gl_centerScorePanel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 66, Short.MAX_VALUE)
		);
		centerScorePanel_3.setLayout(gl_centerScorePanel_3);
		centerPositionPanel_3.setLayout(gl_centerPositionPanel_3);
		
		JLabel shootingGuardLabel = new JLabel("Shooting Guard");
		shootingGuardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		shootingGuardLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JPanel centerScorePanel_4 = new JPanel();
		GroupLayout gl_centerPositionPanel_4 = new GroupLayout(centerPositionPanel_4);
		gl_centerPositionPanel_4.setHorizontalGroup(
			gl_centerPositionPanel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_centerPositionPanel_4.createSequentialGroup()
					.addGap(119)
					.addComponent(shootingGuardLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
					.addComponent(centerScorePanel_4, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
		);
		gl_centerPositionPanel_4.setVerticalGroup(
			gl_centerPositionPanel_4.createParallelGroup(Alignment.LEADING)
				.addComponent(centerScorePanel_4, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
				.addGroup(gl_centerPositionPanel_4.createSequentialGroup()
					.addComponent(shootingGuardLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		GroupLayout gl_centerScorePanel_4 = new GroupLayout(centerScorePanel_4);
		gl_centerScorePanel_4.setHorizontalGroup(
			gl_centerScorePanel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 61, Short.MAX_VALUE)
		);
		gl_centerScorePanel_4.setVerticalGroup(
			gl_centerScorePanel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 68, Short.MAX_VALUE)
		);
		centerScorePanel_4.setLayout(gl_centerScorePanel_4);
		centerPositionPanel_4.setLayout(gl_centerPositionPanel_4);
		
		JLabel powerForwardLabel = new JLabel("Power Forward");
		powerForwardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		powerForwardLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JPanel centerScorePanel_2 = new JPanel();
		GroupLayout gl_centerPositionPanel_2 = new GroupLayout(centerPositionPanel_2);
		gl_centerPositionPanel_2.setHorizontalGroup(
			gl_centerPositionPanel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_centerPositionPanel_2.createSequentialGroup()
					.addGap(118)
					.addComponent(powerForwardLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
					.addComponent(centerScorePanel_2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
		);
		gl_centerPositionPanel_2.setVerticalGroup(
			gl_centerPositionPanel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(centerScorePanel_2, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
				.addGroup(gl_centerPositionPanel_2.createSequentialGroup()
					.addComponent(powerForwardLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		GroupLayout gl_centerScorePanel_2 = new GroupLayout(centerScorePanel_2);
		gl_centerScorePanel_2.setHorizontalGroup(
			gl_centerScorePanel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 61, Short.MAX_VALUE)
		);
		gl_centerScorePanel_2.setVerticalGroup(
			gl_centerScorePanel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 58, Short.MAX_VALUE)
		);
		centerScorePanel_2.setLayout(gl_centerScorePanel_2);
		centerPositionPanel_2.setLayout(gl_centerPositionPanel_2);
		
		JLabel smallForwardLabel = new JLabel("Small Forward");
		smallForwardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		smallForwardLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JPanel centerScorePanel_1 = new JPanel();
		GroupLayout gl_centerPositionPanel_1 = new GroupLayout(centerPositionPanel_1);
		gl_centerPositionPanel_1.setHorizontalGroup(
			gl_centerPositionPanel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_centerPositionPanel_1.createSequentialGroup()
					.addGap(120)
					.addComponent(smallForwardLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
					.addComponent(centerScorePanel_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
		);
		gl_centerPositionPanel_1.setVerticalGroup(
			gl_centerPositionPanel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(centerScorePanel_1, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
				.addGroup(gl_centerPositionPanel_1.createSequentialGroup()
					.addComponent(smallForwardLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		GroupLayout gl_centerScorePanel_1 = new GroupLayout(centerScorePanel_1);
		gl_centerScorePanel_1.setHorizontalGroup(
			gl_centerScorePanel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 60, Short.MAX_VALUE)
		);
		gl_centerScorePanel_1.setVerticalGroup(
			gl_centerScorePanel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 66, Short.MAX_VALUE)
		);
		centerScorePanel_1.setLayout(gl_centerScorePanel_1);
		centerPositionPanel_1.setLayout(gl_centerPositionPanel_1);
		
		JLabel centerLabel = new JLabel("Center");
		centerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		centerLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JPanel centerScorePanel = new JPanel();
		GroupLayout gl_centerPositionPanel = new GroupLayout(centerPositionPanel);
		gl_centerPositionPanel.setHorizontalGroup(
			gl_centerPositionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPositionPanel.createSequentialGroup()
					.addGap(146)
					.addComponent(centerLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
					.addComponent(centerScorePanel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
		);
		gl_centerPositionPanel.setVerticalGroup(
			gl_centerPositionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPositionPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(centerLabel)
					.addContainerGap(52, Short.MAX_VALUE))
				.addComponent(centerScorePanel, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
		);
		GroupLayout gl_centerScorePanel = new GroupLayout(centerScorePanel);
		gl_centerScorePanel.setHorizontalGroup(
			gl_centerScorePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 60, Short.MAX_VALUE)
		);
		gl_centerScorePanel.setVerticalGroup(
			gl_centerScorePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 72, Short.MAX_VALUE)
		);
		centerScorePanel.setLayout(gl_centerScorePanel);
		centerPositionPanel.setLayout(gl_centerPositionPanel);
		frmMatchPage.getContentPane().setLayout(groupLayout);
	}
}
