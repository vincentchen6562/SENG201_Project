package src.pages;
import src.*;

import java.util.ArrayList;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;


public class StadiumPage {

	private JFrame frmStadium;
	private GameEnvironment environment;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StadiumPage window = new StadiumPage();
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
	public StadiumPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frmStadium.setVisible(true);
	}
	
	public void closeWindow() {
		frmStadium.dispose();
	}
	
	public void finishedWindow() {
		environment.closeStadiumPage(this);
	}
	
	public void intoMatch() {
		environment.launchMatchPage();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStadium = new JFrame();
		frmStadium.setTitle("Stadium");
		frmStadium.setBounds(100, 100, 650, 400);
		frmStadium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton backButton = new JButton("<");
		backButton.setFont(new Font("SimSun", Font.BOLD, 12));
		
		JPanel statPanel = new JPanel();
		statPanel.setBorder(new CompoundBorder());
		
		JPanel titlePanel = new JPanel();
		
		JLabel welcomeLabel = new JLabel("Welcome to the Stadium!");
		welcomeLabel.setFont(new Font("Orbitron", Font.BOLD, 20));
		GroupLayout gl_titlePanel = new GroupLayout(titlePanel);
		gl_titlePanel.setHorizontalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(welcomeLabel, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_titlePanel.setVerticalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_titlePanel.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addComponent(welcomeLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		titlePanel.setLayout(gl_titlePanel);
		
		JPanel match1Panel = new JPanel();
		match1Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel team1Reward = new JLabel("<reward>");
		
		JLabel team1RewardTitle = new JLabel("Reward");
		team1RewardTitle.setFont(new Font("Orbitron", Font.BOLD, 11));
		
		ArrayList<String> opponentTeamNames = new Match(1, 2, 3).getOpponentTNames(); // doesn't really work since the Match instance is not properly generated
		
		JLabel team1NameTitle = new JLabel("Team Name");
		team1NameTitle.setFont(new Font("Orbitron", Font.BOLD, 11));
		
		JPanel match2Panel = new JPanel();
		match2Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel team2Reward = new JLabel("<reward>");
		
		JLabel team2RewardTitle = new JLabel("Reward");
		team2RewardTitle.setFont(new Font("Orbitron", Font.BOLD, 11));
		
		
		JLabel team2NameTitle = new JLabel("Team Name");
		team2NameTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel team1Name = new JLabel(opponentTeamNames.get(0));
		GroupLayout gl_match2Panel = new GroupLayout(match2Panel);
		gl_match2Panel.setHorizontalGroup(
			gl_match2Panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_match2Panel.createParallelGroup(Alignment.LEADING)
						.addComponent(team2RewardTitle)
						.addComponent(team2Reward))
					.addContainerGap(54, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_match2Panel.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_match2Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_match2Panel.createSequentialGroup()
							.addGap(10)
							.addComponent(team1Name)
							.addContainerGap())
						.addGroup(gl_match2Panel.createSequentialGroup()
							.addComponent(team2NameTitle, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
							.addGap(33))))
		);
		gl_match2Panel.setVerticalGroup(
			gl_match2Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(team2NameTitle)
					.addGap(2)
					.addComponent(team1Name)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team2RewardTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team2Reward)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		match2Panel.setLayout(gl_match2Panel);
		
		JPanel match3Panel = new JPanel();
		match3Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel team3Reward = new JLabel("<reward>");
		
		JLabel team3RewardTitle = new JLabel("Reward");
		team3RewardTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel team3Name = new JLabel(opponentTeamNames.get(2));
		
		JLabel team3NameTitle = new JLabel("Team Name");
		team3NameTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_match3Panel = new GroupLayout(match3Panel);
		gl_match3Panel.setHorizontalGroup(
			gl_match3Panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_match3Panel.createParallelGroup(Alignment.LEADING)
						.addComponent(team3Name)
						.addComponent(team3RewardTitle)
						.addComponent(team3Reward))
					.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addComponent(team3NameTitle)
					.addGap(33))
		);
		gl_match3Panel.setVerticalGroup(
			gl_match3Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(team3NameTitle)
					.addGap(2)
					.addComponent(team3Name)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team3RewardTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team3Reward)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		match3Panel.setLayout(gl_match3Panel);
		
		JPanel match4Panel = new JPanel();
		match4Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel team4Reward = new JLabel("<reward>");
		
		JLabel team4RewardTitle = new JLabel("Reward");
		team4RewardTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel team4Name = new JLabel(opponentTeamNames.get(3));
		
		JLabel team4NameTitle = new JLabel("Team Name");
		team4NameTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_match4Panel = new GroupLayout(match4Panel);
		gl_match4Panel.setHorizontalGroup(
			gl_match4Panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_match4Panel.createParallelGroup(Alignment.LEADING)
						.addComponent(team4Name)
						.addComponent(team4RewardTitle)
						.addComponent(team4Reward))
					.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addComponent(team4NameTitle)
					.addGap(33))
		);
		gl_match4Panel.setVerticalGroup(
			gl_match4Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(team4NameTitle)
					.addGap(2)
					.addComponent(team4Name)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team4RewardTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team4Reward)
					.addContainerGap(153, Short.MAX_VALUE))
		);
		match4Panel.setLayout(gl_match4Panel);
		
		JButton team1StartButton = new JButton("Start Match\r\n");
		team1StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				intoMatch();
			}
		});
		
		JButton team2StartButton = new JButton("Start Match");
		team2StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow(); //need to keep the team name consistent with the one displayed in the match page
				intoMatch();
			}
			
		});
		
		JButton team3StartButton = new JButton("Start Match");
		team3StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				intoMatch();
			}
		});
		
		JButton team4StartButton = new JButton("Start Match");
		team4StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				intoMatch();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmStadium.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(backButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(team1StartButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(match2Panel, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(7)
									.addComponent(match1Panel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(team2StartButton, GroupLayout.PREFERRED_SIZE, 52, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(team3StartButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(match3Panel, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(team4StartButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(match4Panel, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(backButton)
						.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, 60, Short.MAX_VALUE)
						.addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(match4Panel, GroupLayout.PREFERRED_SIZE, 87, Short.MAX_VALUE)
						.addComponent(match3Panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 87, Short.MAX_VALUE)
						.addComponent(match1Panel, 0, 0, Short.MAX_VALUE)
						.addComponent(match2Panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 87, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(team4StartButton, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(team1StartButton, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
							.addComponent(team2StartButton, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
							.addComponent(team3StartButton, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)))
					.addContainerGap())
		);
		JLabel team2Name = new JLabel(opponentTeamNames.get(1));
		GroupLayout gl_match1Panel = new GroupLayout(match1Panel);
		gl_match1Panel.setHorizontalGroup(
			gl_match1Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_match1Panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_match1Panel.createParallelGroup(Alignment.LEADING)
						.addComponent(team1NameTitle, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
						.addGroup(gl_match1Panel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_match1Panel.createParallelGroup(Alignment.LEADING)
								.addComponent(team1Reward, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
								.addComponent(team1RewardTitle)
								.addComponent(team2Name))))
					.addContainerGap())
		);
		gl_match1Panel.setVerticalGroup(
			gl_match1Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_match1Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(team1NameTitle, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(team2Name)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team1RewardTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team1Reward)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		match1Panel.setLayout(gl_match1Panel);
		
		JLabel moneyLabel = new JLabel("Money: ");
		moneyLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel weekLabel = new JLabel("Week:");
		weekLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel pointsLabel = new JLabel("Points:");
		pointsLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel statsTotalLabel = new JLabel("StatTotal:");
		statsTotalLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_statPanel = new GroupLayout(statPanel);
		gl_statPanel.setHorizontalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_statPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(moneyLabel))
					.addGap(43)
					.addGroup(gl_statPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(pointsLabel)
						.addComponent(statsTotalLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_statPanel.setVerticalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_statPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(moneyLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_statPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(statsTotalLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(3))
		);
		statPanel.setLayout(gl_statPanel);
		frmStadium.getContentPane().setLayout(groupLayout);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
	}
}
