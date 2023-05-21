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
		frmMatchPage.setTitle("Match");
		frmMatchPage.setResizable(false);
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
							.addContainerGap()
							.addComponent(centerPositionPanel_2, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
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
							.addComponent(centerPositionPanel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(centerPositionPanel_1, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(teamNamespanel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(teamNamespanel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerPositionPanel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerPositionPanel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerPositionPanel_2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
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
		
		JLabel teamNameLabel = new JLabel("<Player Team Name>");
		teamNameLabel.setFont(new Font("Orbitron", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("VS");
		lblNewLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel opponentTeamNameLabel = new JLabel("<Opponent Team Name>");
		opponentTeamNameLabel.setFont(new Font("Orbitron", Font.PLAIN, 16));
		
		JPanel weekNumberpanel = new JPanel();
		GroupLayout gl_teamNamespanel = new GroupLayout(teamNamespanel);
		gl_teamNamespanel.setHorizontalGroup(
			gl_teamNamespanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_teamNamespanel.createSequentialGroup()
					.addGroup(gl_teamNamespanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_teamNamespanel.createSequentialGroup()
							.addGap(109)
							.addComponent(teamNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(57))
						.addGroup(gl_teamNamespanel.createSequentialGroup()
							.addGap(187)
							.addComponent(lblNewLabel)
							.addGap(140))
						.addGroup(gl_teamNamespanel.createSequentialGroup()
							.addGap(97)
							.addComponent(opponentTeamNameLabel)
							.addGap(43)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(weekNumberpanel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
		);
		gl_teamNamespanel.setVerticalGroup(
			gl_teamNamespanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_teamNamespanel.createSequentialGroup()
					.addComponent(teamNameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(opponentTeamNameLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addComponent(weekNumberpanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel_1 = new JLabel("Week");
		lblNewLabel_1.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Score");
		lblNewLabel_2.setFont(new Font("Orbitron", Font.PLAIN, 14));
		GroupLayout gl_weekNumberpanel = new GroupLayout(weekNumberpanel);
		gl_weekNumberpanel.setHorizontalGroup(
			gl_weekNumberpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_weekNumberpanel.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel_1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_weekNumberpanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2)
					.addContainerGap())
		);
		gl_weekNumberpanel.setVerticalGroup(
			gl_weekNumberpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_weekNumberpanel.createSequentialGroup()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2))
		);
		weekNumberpanel.setLayout(gl_weekNumberpanel);
		teamNamespanel.setLayout(gl_teamNamespanel);
		
		JLabel scoreBoardLabel = new JLabel("Scoreboard");
		scoreBoardLabel.setFont(new Font("Orbitron", Font.BOLD, 14));
		GroupLayout gl_scoreBoardPanel = new GroupLayout(scoreBoardPanel);
		gl_scoreBoardPanel.setHorizontalGroup(
			gl_scoreBoardPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_scoreBoardPanel.createSequentialGroup()
					.addGap(155)
					.addComponent(scoreBoardLabel)
					.addContainerGap(163, Short.MAX_VALUE))
		);
		gl_scoreBoardPanel.setVerticalGroup(
			gl_scoreBoardPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_scoreBoardPanel.createSequentialGroup()
					.addComponent(scoreBoardLabel)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		scoreBoardPanel.setLayout(gl_scoreBoardPanel);
		
		JLabel pointGuardLabel = new JLabel("Point Guard");
		pointGuardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pointGuardLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JPanel pointGuardScorePanel = new JPanel();
		GroupLayout gl_centerPositionPanel_3 = new GroupLayout(centerPositionPanel_3);
		gl_centerPositionPanel_3.setHorizontalGroup(
			gl_centerPositionPanel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_centerPositionPanel_3.createSequentialGroup()
					.addGap(131)
					.addComponent(pointGuardLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
					.addComponent(pointGuardScorePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_centerPositionPanel_3.setVerticalGroup(
			gl_centerPositionPanel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPositionPanel_3.createSequentialGroup()
					.addComponent(pointGuardLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(pointGuardScorePanel, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
		);
		GroupLayout gl_pointGuardScorePanel = new GroupLayout(pointGuardScorePanel);
		gl_pointGuardScorePanel.setHorizontalGroup(
			gl_pointGuardScorePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 60, Short.MAX_VALUE)
		);
		gl_pointGuardScorePanel.setVerticalGroup(
			gl_pointGuardScorePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 66, Short.MAX_VALUE)
		);
		pointGuardScorePanel.setLayout(gl_pointGuardScorePanel);
		centerPositionPanel_3.setLayout(gl_centerPositionPanel_3);
		
		JLabel shootingGuardLabel = new JLabel("Shooting Guard");
		shootingGuardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		shootingGuardLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JPanel shootingGuardScorePanel = new JPanel();
		GroupLayout gl_centerPositionPanel_4 = new GroupLayout(centerPositionPanel_4);
		gl_centerPositionPanel_4.setHorizontalGroup(
			gl_centerPositionPanel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_centerPositionPanel_4.createSequentialGroup()
					.addGap(119)
					.addComponent(shootingGuardLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
					.addComponent(shootingGuardScorePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_centerPositionPanel_4.setVerticalGroup(
			gl_centerPositionPanel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPositionPanel_4.createSequentialGroup()
					.addComponent(shootingGuardLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(shootingGuardScorePanel, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
		);
		GroupLayout gl_shootingGuardScorePanel = new GroupLayout(shootingGuardScorePanel);
		gl_shootingGuardScorePanel.setHorizontalGroup(
			gl_shootingGuardScorePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 61, Short.MAX_VALUE)
		);
		gl_shootingGuardScorePanel.setVerticalGroup(
			gl_shootingGuardScorePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 68, Short.MAX_VALUE)
		);
		shootingGuardScorePanel.setLayout(gl_shootingGuardScorePanel);
		centerPositionPanel_4.setLayout(gl_centerPositionPanel_4);
		
		JLabel powerForwardLabel = new JLabel("Power Forward");
		powerForwardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		powerForwardLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JPanel powerForwardScorePanel = new JPanel();
		GroupLayout gl_centerPositionPanel_2 = new GroupLayout(centerPositionPanel_2);
		gl_centerPositionPanel_2.setHorizontalGroup(
			gl_centerPositionPanel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_centerPositionPanel_2.createSequentialGroup()
					.addGap(118)
					.addComponent(powerForwardLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
					.addComponent(powerForwardScorePanel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
		);
		gl_centerPositionPanel_2.setVerticalGroup(
			gl_centerPositionPanel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(powerForwardScorePanel, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
				.addGroup(gl_centerPositionPanel_2.createSequentialGroup()
					.addComponent(powerForwardLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		GroupLayout gl_powerForwardScorePanel = new GroupLayout(powerForwardScorePanel);
		gl_powerForwardScorePanel.setHorizontalGroup(
			gl_powerForwardScorePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 61, Short.MAX_VALUE)
		);
		gl_powerForwardScorePanel.setVerticalGroup(
			gl_powerForwardScorePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 58, Short.MAX_VALUE)
		);
		powerForwardScorePanel.setLayout(gl_powerForwardScorePanel);
		centerPositionPanel_2.setLayout(gl_centerPositionPanel_2);
		
		JLabel smallForwardLabel = new JLabel("Small Forward");
		smallForwardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		smallForwardLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JPanel smallForwardScorePanel = new JPanel();
		GroupLayout gl_centerPositionPanel_1 = new GroupLayout(centerPositionPanel_1);
		gl_centerPositionPanel_1.setHorizontalGroup(
			gl_centerPositionPanel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_centerPositionPanel_1.createSequentialGroup()
					.addGap(120)
					.addComponent(smallForwardLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
					.addComponent(smallForwardScorePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_centerPositionPanel_1.setVerticalGroup(
			gl_centerPositionPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPositionPanel_1.createSequentialGroup()
					.addComponent(smallForwardLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(smallForwardScorePanel, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
		);
		GroupLayout gl_smallForwardScorePanel = new GroupLayout(smallForwardScorePanel);
		gl_smallForwardScorePanel.setHorizontalGroup(
			gl_smallForwardScorePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 60, Short.MAX_VALUE)
		);
		gl_smallForwardScorePanel.setVerticalGroup(
			gl_smallForwardScorePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 66, Short.MAX_VALUE)
		);
		smallForwardScorePanel.setLayout(gl_smallForwardScorePanel);
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
