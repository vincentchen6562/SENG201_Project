package src.pages;

import src.*;
import src.team.Athlete;
import java.util.ArrayList;
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
	private String opponentTeamName;
	

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
	public MatchPage(GameEnvironment incomingEnvironment, String oppTeamName) {
		environment = incomingEnvironment;
		opponentTeamName = oppTeamName;
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
		
		ArrayList<Athlete> opponentAthletes = new Match(1, 3, 3).getOpponentAthletes();
		ArrayList<String> opponentAthleteNames = new ArrayList<String>();
		ArrayList<Integer> opponentCenterStats = new ArrayList<Integer>();
		ArrayList<Integer> opponentSFStats = new ArrayList<Integer>();
		ArrayList<Integer> opponentPFStats = new ArrayList<Integer>();
		ArrayList<Integer> opponentPGStats = new ArrayList<Integer>();
		ArrayList<Integer> opponentSGStats = new ArrayList<Integer>();
		
		
		
		for(Athlete athlete : opponentAthletes) {
			opponentAthleteNames.add(athlete.getFullName());
			opponentCenterStats.add(athlete.getDefence());
			opponentSFStats.add((athlete.getOffence() + athlete.getAgility() + athlete.getDefence()) / 3);
			opponentPFStats.add(athlete.getOffence());
			opponentPGStats.add((athlete.getOffence() + athlete.getAgility()) / 2);
			opponentSGStats.add(athlete.getOffence());
		}
		
		
		
		
		JPanel teamNamespanel = new JPanel();
		
		JPanel centerPositionPanel = new JPanel();
		centerPositionPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel scoreBoardPanel = new JPanel();
		scoreBoardPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JButton btnFinishButton = new JButton("FINISH");
		btnFinishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnFinishButton.setFont(new Font("Orbitron", Font.BOLD, 12));
		
		JPanel centerPositionPanel_1 = new JPanel();
		centerPositionPanel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel smallForwardLabel = new JLabel("Small Forward");
		smallForwardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		smallForwardLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JPanel centerVersusPanel_1 = new JPanel();
		
		JLabel playerCenterLabel_1 = new JLabel("<Center Name>");
		playerCenterLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		playerCenterLabel_1.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel centerVersusLabel_1 = new JLabel("VS");
		centerVersusLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		centerVersusLabel_1.setFont(new Font("Orbitron", Font.PLAIN, 11));
		
		JLabel oppCenterLabel_1 = new JLabel(opponentAthleteNames.get(1));
		oppCenterLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		oppCenterLabel_1.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_centerVersusPanel_1 = new GroupLayout(centerVersusPanel_1);
		gl_centerVersusPanel_1.setHorizontalGroup(
			gl_centerVersusPanel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 346, Short.MAX_VALUE)
				.addGroup(gl_centerVersusPanel_1.createSequentialGroup()
					.addComponent(playerCenterLabel_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(centerVersusLabel_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(oppCenterLabel_1, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
		);
		gl_centerVersusPanel_1.setVerticalGroup(
			gl_centerVersusPanel_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 38, Short.MAX_VALUE)
				.addGroup(gl_centerVersusPanel_1.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_centerVersusPanel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(playerCenterLabel_1, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(centerVersusLabel_1, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(oppCenterLabel_1, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
		);
		centerVersusPanel_1.setLayout(gl_centerVersusPanel_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("<Score>");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_centerPositionPanel_1 = new GroupLayout(centerPositionPanel_1);
		gl_centerPositionPanel_1.setHorizontalGroup(
			gl_centerPositionPanel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 414, Short.MAX_VALUE)
				.addGroup(gl_centerPositionPanel_1.createSequentialGroup()
					.addGroup(gl_centerPositionPanel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_centerPositionPanel_1.createSequentialGroup()
							.addComponent(centerVersusPanel_1, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
							.addGap(8))
						.addGroup(Alignment.TRAILING, gl_centerPositionPanel_1.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(smallForwardLabel)
							.addGap(91)))
					.addComponent(lblNewLabel_3_1)
					.addGap(6))
		);
		gl_centerPositionPanel_1.setVerticalGroup(
			gl_centerPositionPanel_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 66, Short.MAX_VALUE)
				.addGroup(gl_centerPositionPanel_1.createSequentialGroup()
					.addGroup(gl_centerPositionPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_centerPositionPanel_1.createSequentialGroup()
							.addGap(5)
							.addComponent(smallForwardLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(centerVersusPanel_1, GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE))
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		centerPositionPanel_1.setLayout(gl_centerPositionPanel_1);
		
		JPanel centerPositionPanel_2 = new JPanel();
		centerPositionPanel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel powerForwardLabel = new JLabel("Power Forward");
		powerForwardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		powerForwardLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JPanel centerVersusPanel_2 = new JPanel();
		
		JLabel playerCenterLabel_2 = new JLabel("<Center Name>");
		playerCenterLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		playerCenterLabel_2.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel centerVersusLabel_2 = new JLabel("VS");
		centerVersusLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		centerVersusLabel_2.setFont(new Font("Orbitron", Font.PLAIN, 11));
		
		JLabel oppCenterLabel_2 = new JLabel(opponentAthleteNames.get(2));
		oppCenterLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		oppCenterLabel_2.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_centerVersusPanel_2 = new GroupLayout(centerVersusPanel_2);
		gl_centerVersusPanel_2.setHorizontalGroup(
			gl_centerVersusPanel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 346, Short.MAX_VALUE)
				.addGroup(gl_centerVersusPanel_2.createSequentialGroup()
					.addComponent(playerCenterLabel_2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(centerVersusLabel_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(oppCenterLabel_2, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
		);
		gl_centerVersusPanel_2.setVerticalGroup(
			gl_centerVersusPanel_2.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 38, Short.MAX_VALUE)
				.addGroup(gl_centerVersusPanel_2.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_centerVersusPanel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(playerCenterLabel_2, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(centerVersusLabel_2, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(oppCenterLabel_2, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
		);
		centerVersusPanel_2.setLayout(gl_centerVersusPanel_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("<Score>");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_centerPositionPanel_2 = new GroupLayout(centerPositionPanel_2);
		gl_centerPositionPanel_2.setHorizontalGroup(
			gl_centerPositionPanel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 414, Short.MAX_VALUE)
				.addGroup(gl_centerPositionPanel_2.createSequentialGroup()
					.addGroup(gl_centerPositionPanel_2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_centerPositionPanel_2.createSequentialGroup()
							.addComponent(centerVersusPanel_2, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
							.addGap(8))
						.addGroup(Alignment.TRAILING, gl_centerPositionPanel_2.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(powerForwardLabel)
							.addGap(88)))
					.addComponent(lblNewLabel_3_2)
					.addGap(6))
		);
		gl_centerPositionPanel_2.setVerticalGroup(
			gl_centerPositionPanel_2.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 66, Short.MAX_VALUE)
				.addGroup(gl_centerPositionPanel_2.createSequentialGroup()
					.addGroup(gl_centerPositionPanel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_centerPositionPanel_2.createSequentialGroup()
							.addGap(5)
							.addComponent(powerForwardLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(centerVersusPanel_2, GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE))
						.addComponent(lblNewLabel_3_2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		centerPositionPanel_2.setLayout(gl_centerPositionPanel_2);
		
		JPanel centerPositionPanel_3 = new JPanel();
		centerPositionPanel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel pointGuardLabel = new JLabel("Point Guard");
		pointGuardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pointGuardLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JPanel centerVersusPanel_3 = new JPanel();
		
		JLabel playerCenterLabel_3 = new JLabel("<Center Name>");
		playerCenterLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		playerCenterLabel_3.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel centerVersusLabel_3 = new JLabel("VS");
		centerVersusLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		centerVersusLabel_3.setFont(new Font("Orbitron", Font.PLAIN, 11));
		
		JLabel oppCenterLabel_3 = new JLabel(opponentAthleteNames.get(3));
		oppCenterLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		oppCenterLabel_3.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_centerVersusPanel_3 = new GroupLayout(centerVersusPanel_3);
		gl_centerVersusPanel_3.setHorizontalGroup(
			gl_centerVersusPanel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 346, Short.MAX_VALUE)
				.addGroup(gl_centerVersusPanel_3.createSequentialGroup()
					.addComponent(playerCenterLabel_3, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(centerVersusLabel_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(oppCenterLabel_3, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
		);
		gl_centerVersusPanel_3.setVerticalGroup(
			gl_centerVersusPanel_3.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 38, Short.MAX_VALUE)
				.addGroup(gl_centerVersusPanel_3.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_centerVersusPanel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(playerCenterLabel_3, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(centerVersusLabel_3, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(oppCenterLabel_3, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
		);
		centerVersusPanel_3.setLayout(gl_centerVersusPanel_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("<Score>");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_centerPositionPanel_3 = new GroupLayout(centerPositionPanel_3);
		gl_centerPositionPanel_3.setHorizontalGroup(
			gl_centerPositionPanel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 414, Short.MAX_VALUE)
				.addGroup(gl_centerPositionPanel_3.createSequentialGroup()
					.addGroup(gl_centerPositionPanel_3.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_centerPositionPanel_3.createSequentialGroup()
							.addComponent(centerVersusPanel_3, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
							.addGap(8))
						.addGroup(Alignment.TRAILING, gl_centerPositionPanel_3.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(pointGuardLabel)
							.addGap(108)))
					.addComponent(lblNewLabel_3_3)
					.addGap(6))
		);
		gl_centerPositionPanel_3.setVerticalGroup(
			gl_centerPositionPanel_3.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 66, Short.MAX_VALUE)
				.addGroup(gl_centerPositionPanel_3.createSequentialGroup()
					.addGroup(gl_centerPositionPanel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_centerPositionPanel_3.createSequentialGroup()
							.addGap(5)
							.addComponent(pointGuardLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(centerVersusPanel_3, GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE))
						.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		centerPositionPanel_3.setLayout(gl_centerPositionPanel_3);
		
		JPanel centerPositionPanel_4 = new JPanel();
		centerPositionPanel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel shootingGuardLabel = new JLabel("Shooting Guard");
		shootingGuardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		shootingGuardLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JPanel centerVersusPanel_4 = new JPanel();
		
		JLabel playerCenterLabel_4 = new JLabel("<Center Name>");
		playerCenterLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		playerCenterLabel_4.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel centerVersusLabel_4 = new JLabel("VS");
		centerVersusLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		centerVersusLabel_4.setFont(new Font("Orbitron", Font.PLAIN, 11));
		
		JLabel oppCenterLabel_4 = new JLabel(opponentAthleteNames.get(4));
		oppCenterLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		oppCenterLabel_4.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_centerVersusPanel_4 = new GroupLayout(centerVersusPanel_4);
		gl_centerVersusPanel_4.setHorizontalGroup(
			gl_centerVersusPanel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 346, Short.MAX_VALUE)
				.addGroup(gl_centerVersusPanel_4.createSequentialGroup()
					.addComponent(playerCenterLabel_4, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(centerVersusLabel_4, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(oppCenterLabel_4, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
		);
		gl_centerVersusPanel_4.setVerticalGroup(
			gl_centerVersusPanel_4.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 38, Short.MAX_VALUE)
				.addGroup(gl_centerVersusPanel_4.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_centerVersusPanel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(playerCenterLabel_4, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(centerVersusLabel_4, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(oppCenterLabel_4, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
		);
		centerVersusPanel_4.setLayout(gl_centerVersusPanel_4);
		
		JLabel lblNewLabel_3_4 = new JLabel("<Score>");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_centerPositionPanel_4 = new GroupLayout(centerPositionPanel_4);
		gl_centerPositionPanel_4.setHorizontalGroup(
			gl_centerPositionPanel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 414, Short.MAX_VALUE)
				.addGroup(gl_centerPositionPanel_4.createSequentialGroup()
					.addGroup(gl_centerPositionPanel_4.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_centerPositionPanel_4.createSequentialGroup()
							.addComponent(centerVersusPanel_4, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
							.addGap(8))
						.addGroup(Alignment.TRAILING, gl_centerPositionPanel_4.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(shootingGuardLabel)
							.addGap(90)))
					.addComponent(lblNewLabel_3_4)
					.addGap(6))
		);
		gl_centerPositionPanel_4.setVerticalGroup(
			gl_centerPositionPanel_4.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 66, Short.MAX_VALUE)
				.addGroup(gl_centerPositionPanel_4.createSequentialGroup()
					.addGroup(gl_centerPositionPanel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_centerPositionPanel_4.createSequentialGroup()
							.addGap(5)
							.addComponent(shootingGuardLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(centerVersusPanel_4, GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE))
						.addComponent(lblNewLabel_3_4, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		centerPositionPanel_4.setLayout(gl_centerPositionPanel_4);
		GroupLayout groupLayout = new GroupLayout(frmMatchPage.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(centerPositionPanel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(teamNamespanel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(142)
							.addComponent(btnFinishButton, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scoreBoardPanel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(centerPositionPanel_1, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(centerPositionPanel_2, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(centerPositionPanel_3, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(centerPositionPanel_4, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(teamNamespanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerPositionPanel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerPositionPanel_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerPositionPanel_2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerPositionPanel_3, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerPositionPanel_4, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scoreBoardPanel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnFinishButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		
		JLabel teamNameLabel = new JLabel(environment.getGame().getTeam().getTeamName());
		teamNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamNameLabel.setFont(new Font("Orbitron", Font.BOLD, 18));
		
		JLabel lblNewLabel = new JLabel("VS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel opponentTeamNameLabel = new JLabel(opponentTeamName);
		opponentTeamNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeamNameLabel.setFont(new Font("Orbitron", Font.BOLD, 18));
		
		JPanel weekNumberpanel = new JPanel();
		GroupLayout gl_teamNamespanel = new GroupLayout(teamNamespanel);
		gl_teamNamespanel.setHorizontalGroup(
			gl_teamNamespanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_teamNamespanel.createSequentialGroup()
					.addGroup(gl_teamNamespanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_teamNamespanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addGap(140))
						.addGroup(gl_teamNamespanel.createSequentialGroup()
							.addGap(124)
							.addGroup(gl_teamNamespanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(opponentTeamNameLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
								.addComponent(teamNameLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
							.addGap(77)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(weekNumberpanel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
		);
		gl_teamNamespanel.setVerticalGroup(
			gl_teamNamespanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_teamNamespanel.createSequentialGroup()
					.addGap(6)
					.addComponent(teamNameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(opponentTeamNameLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addComponent(weekNumberpanel, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel_1 = new JLabel("Week");
		lblNewLabel_1.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Score");
		lblNewLabel_2.setFont(new Font("Orbitron", Font.PLAIN, 14));
		GroupLayout gl_weekNumberpanel = new GroupLayout(weekNumberpanel);
		gl_weekNumberpanel.setHorizontalGroup(
			gl_weekNumberpanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_weekNumberpanel.createSequentialGroup()
					.addGroup(gl_weekNumberpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_weekNumberpanel.createSequentialGroup()
							.addGap(13)
							.addComponent(lblNewLabel_1))
						.addGroup(Alignment.TRAILING, gl_weekNumberpanel.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_weekNumberpanel.setVerticalGroup(
			gl_weekNumberpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_weekNumberpanel.createSequentialGroup()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
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
		
		JLabel centerLabel = new JLabel("Center");
		centerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		centerLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JPanel centerVersusPanel = new JPanel();
		
		JLabel lblNewLabel_3 = new JLabel("<Score>");
		lblNewLabel_3.setFont(new Font("Orbitron", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_centerPositionPanel = new GroupLayout(centerPositionPanel);
		gl_centerPositionPanel.setHorizontalGroup(
			gl_centerPositionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPositionPanel.createSequentialGroup()
					.addGroup(gl_centerPositionPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_centerPositionPanel.createSequentialGroup()
							.addComponent(centerVersusPanel, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
							.addGap(8))
						.addGroup(Alignment.TRAILING, gl_centerPositionPanel.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(centerLabel)
							.addGap(126)))
					.addComponent(lblNewLabel_3)
					.addGap(6))
		);
		gl_centerPositionPanel.setVerticalGroup(
			gl_centerPositionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_centerPositionPanel.createSequentialGroup()
					.addGroup(gl_centerPositionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_centerPositionPanel.createSequentialGroup()
							.addGap(5)
							.addComponent(centerLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(centerVersusPanel, GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE))
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel playerCenterLabel = new JLabel("<Center Name>");
		playerCenterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerCenterLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel oppCenterLabel = new JLabel(opponentAthleteNames.get(0));
		oppCenterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		oppCenterLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel centerVersusLabel = new JLabel("VS");
		centerVersusLabel.setFont(new Font("Orbitron", Font.PLAIN, 11));
		centerVersusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_centerVersusPanel = new GroupLayout(centerVersusPanel);
		gl_centerVersusPanel.setHorizontalGroup(
			gl_centerVersusPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerVersusPanel.createSequentialGroup()
					.addComponent(playerCenterLabel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(centerVersusLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(oppCenterLabel, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
		);
		gl_centerVersusPanel.setVerticalGroup(
			gl_centerVersusPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_centerVersusPanel.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_centerVersusPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(playerCenterLabel, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(centerVersusLabel, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(oppCenterLabel, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
		);
		centerVersusPanel.setLayout(gl_centerVersusPanel);
		centerPositionPanel.setLayout(gl_centerPositionPanel);
		frmMatchPage.getContentPane().setLayout(groupLayout);
	}
}
