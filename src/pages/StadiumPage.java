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
import javax.swing.SwingConstants;

/**
 * The StadiumPage class represents a GUI window for the stadium page in the
 * game.
 * It allows the user to interact with the stadium and initiate matches against
 * opponents.
 */
public class StadiumPage {

	private JFrame frmStadium;
	private GameEnvironment environment;
	public String teamNameStadium;
	public int rewardStadium;

	/**
	 * Create the application.
	 *
	 * @param incomingEnvironment The game environment.
	 */
	public StadiumPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frmStadium.setVisible(true);
	}

	/**
	 * Closes the stadium page window.
	 */
	public void closeWindow() {
		frmStadium.dispose();
	}

	/**
	 * requests the game environment to close the stadium page
	 */
	public void finishedWindow() {
		environment.closeStadiumPage(this);
	}

	/**
	 * Launches the match page with the specified opponent team name and reward.
	 *
	 * @param oppTeamName The name of the opponent team.
	 * @param reward      The reward for winning the match.
	 */
	public void intoMatch(String oppTeamName, int reward) {
		setOppTName(oppTeamName);
		rewardStadium = reward;
		environment.launchMatchPage(teamNameStadium, rewardStadium);
	}

	/**
	 * Returns the opponent team name.
	 *
	 * @return The opponent team name.
	 */
	public String getOppTName() {
		return teamNameStadium;
	}

	/**
	 * Sets the opponent team name.
	 *
	 * @param teamName The opponent team name to be set.
	 */
	public void setOppTName(String teamName) {
		teamNameStadium = teamName;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStadium = new JFrame();
		frmStadium.setResizable(false);
		frmStadium.setTitle("Stadium");
		frmStadium.setBounds(100, 100, 650, 400);
		frmStadium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ArrayList<String> opponentTeamNames = new Match(1, 2, 3).getOpponentTNames(); // doesn't really work since the
																						// Match instance is not
																						// properly generated
		String oppTeam1Name = opponentTeamNames.get(0);
		String oppTeam2Name = opponentTeamNames.get(1);
		String oppTeam3Name = opponentTeamNames.get(2);
		String oppTeam4Name = opponentTeamNames.get(3);

		ArrayList<Integer> rewardPoolStadium = environment.getGame()
				.generateRewardPool(environment.getGame().getDifficultyObject());

		JButton backButton = new JButton("<");
		backButton.setFont(new Font("Orbitron", Font.BOLD, 12));

		JPanel statPanel = new JPanel();
		statPanel.setBorder(new CompoundBorder());

		JPanel titlePanel = new JPanel();

		JLabel welcomeLabel = new JLabel("Welcome to the Stadium!");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Orbitron", Font.BOLD, 20));
		GroupLayout gl_titlePanel = new GroupLayout(titlePanel);
		gl_titlePanel.setHorizontalGroup(
				gl_titlePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(welcomeLabel, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE));
		gl_titlePanel.setVerticalGroup(
				gl_titlePanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_titlePanel.createSequentialGroup()
								.addContainerGap(12, Short.MAX_VALUE)
								.addComponent(welcomeLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		titlePanel.setLayout(gl_titlePanel);

		JPanel match1Panel = new JPanel();
		match1Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		int reward2 = rewardPoolStadium.get(1);
		JLabel team2Reward = new JLabel(String.format("$%d", reward2));
		team2Reward.setFont(new Font("Orbitron", Font.PLAIN, 12));
		team2Reward.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel team2RewardTitle = new JLabel("Reward");
		team2RewardTitle.setHorizontalAlignment(SwingConstants.CENTER);
		team2RewardTitle.setFont(new Font("Orbitron", Font.BOLD, 11));

		JLabel team2NameTitle = new JLabel("Opponent");
		team2NameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		team2NameTitle.setFont(new Font("Orbitron", Font.BOLD, 11));

		JPanel match2Panel = new JPanel();
		match2Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		int reward1 = rewardPoolStadium.get(0);
		JLabel team1Reward = new JLabel(String.format("$%d", reward1));

		team1Reward.setFont(new Font("Orbitron", Font.PLAIN, 12));
		team1Reward.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel team1RewardTitle = new JLabel("Reward");
		team1RewardTitle.setHorizontalAlignment(SwingConstants.CENTER);
		team1RewardTitle.setFont(new Font("Orbitron", Font.BOLD, 11));

		JLabel team1NameTitle = new JLabel("Opponent");
		team1NameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		team1NameTitle.setFont(new Font("Orbitron", Font.PLAIN, 11));

		JLabel team1Name = new JLabel(oppTeam1Name);
		team1Name.setFont(new Font("Orbitron", Font.PLAIN, 14));
		team1Name.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_match2Panel = new GroupLayout(match2Panel);
		gl_match2Panel.setHorizontalGroup(
				gl_match2Panel.createParallelGroup(Alignment.LEADING)
						.addComponent(team1Name, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
						.addComponent(team1NameTitle, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
						.addComponent(team1RewardTitle, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
						.addComponent(team1Reward, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE));
		gl_match2Panel.setVerticalGroup(
				gl_match2Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_match2Panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(team1NameTitle)
								.addGap(2)
								.addComponent(team1Name)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(team1RewardTitle)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(team1Reward)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		match2Panel.setLayout(gl_match2Panel);

		JPanel match3Panel = new JPanel();
		match3Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		int reward3 = rewardPoolStadium.get(2);
		JLabel team3Reward = new JLabel(String.format("$%d", reward3));
		team3Reward.setFont(new Font("Orbitron", Font.PLAIN, 12));
		team3Reward.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel team3RewardTitle = new JLabel("Reward");
		team3RewardTitle.setHorizontalAlignment(SwingConstants.CENTER);
		team3RewardTitle.setFont(new Font("Orbitron", Font.BOLD, 11));

		JLabel team3Name = new JLabel(oppTeam3Name);
		team3Name.setFont(new Font("Orbitron", Font.PLAIN, 14));
		team3Name.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel team3NameTitle = new JLabel("Opponent");
		team3NameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		team3NameTitle.setFont(new Font("Orbitron", Font.BOLD, 11));
		GroupLayout gl_match3Panel = new GroupLayout(match3Panel);
		gl_match3Panel.setHorizontalGroup(
				gl_match3Panel.createParallelGroup(Alignment.LEADING)
						.addComponent(team3Name, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
						.addComponent(team3RewardTitle, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
						.addComponent(team3Reward, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
						.addComponent(team3NameTitle, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE));
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
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		match3Panel.setLayout(gl_match3Panel);

		JPanel match4Panel = new JPanel();
		match4Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		int reward4 = rewardPoolStadium.get(3);
		JLabel team4Reward = new JLabel(String.format("$%d", reward4));
		team4Reward.setFont(new Font("Orbitron", Font.PLAIN, 12));
		team4Reward.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel team4RewardTitle = new JLabel("Reward");
		team4RewardTitle.setHorizontalAlignment(SwingConstants.CENTER);
		team4RewardTitle.setFont(new Font("Orbitron", Font.BOLD, 11));

		JLabel team4Name = new JLabel(oppTeam4Name);
		team4Name.setFont(new Font("Orbitron", Font.PLAIN, 14));
		team4Name.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel team4NameTitle = new JLabel("Opponent");
		team4NameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		team4NameTitle.setFont(new Font("Orbitron", Font.BOLD, 11));
		GroupLayout gl_match4Panel = new GroupLayout(match4Panel);
		gl_match4Panel.setHorizontalGroup(
				gl_match4Panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(team4Name, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
						.addComponent(team4RewardTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 143,
								Short.MAX_VALUE)
						.addComponent(team4Reward, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
						.addComponent(team4NameTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 143,
								Short.MAX_VALUE));
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
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		match4Panel.setLayout(gl_match4Panel);

		JButton team1StartButton = new JButton("Start Match\r\n");
		team1StartButton.setFont(new Font("Orbitron", Font.PLAIN, 12));
		team1StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean isReady = environment.getGame().getTeam().checkTeamStamina();
				if (isReady) {
					closeWindow();
					intoMatch(oppTeam1Name, reward1);
				} else {
					team1StartButton.setText("Stamina Depleted!");
				}
			}
		});

		JButton team2StartButton = new JButton("Start Match");
		team2StartButton.setFont(new Font("Orbitron", Font.PLAIN, 12));
		team2StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean isReady = environment.getGame().getTeam().checkTeamStamina();
				if (isReady) {
					closeWindow();
					intoMatch(oppTeam2Name, reward2);
				} else {
					team2StartButton.setText("Stamina Depleted!");
				}
			}

		});

		JButton team3StartButton = new JButton("Start Match");
		team3StartButton.setFont(new Font("Orbitron", Font.PLAIN, 12));
		team3StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean isReady = environment.getGame().getTeam().checkTeamStamina();
				if (isReady) {
					closeWindow();
					intoMatch(oppTeam3Name, reward3);
				} else {
					team3StartButton.setText("Stamina Depleted!");
				}
			}
		});

		JButton team4StartButton = new JButton("Start Match");
		team4StartButton.setFont(new Font("Orbitron", Font.PLAIN, 12));
		team4StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean isReady = environment.getGame().getTeam().checkTeamStamina();
				if (isReady) {
					closeWindow();
					intoMatch(oppTeam4Name, reward4);
				} else {
					team4StartButton.setText("Stamina Depleted!");
				}
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
												.addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, 354,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, 215,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addContainerGap()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(match2Panel, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED))
														.addComponent(team1StartButton, GroupLayout.DEFAULT_SIZE, 153,
																Short.MAX_VALUE))
												.addGap(7)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(match1Panel, GroupLayout.PREFERRED_SIZE, 145,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(team2StartButton, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(team3StartButton, GroupLayout.DEFAULT_SIZE, 148,
																Short.MAX_VALUE)
														.addComponent(match3Panel, GroupLayout.DEFAULT_SIZE, 148,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(team4StartButton, GroupLayout.DEFAULT_SIZE, 149,
																Short.MAX_VALUE)
														.addComponent(match4Panel, GroupLayout.DEFAULT_SIZE, 149,
																Short.MAX_VALUE))))
								.addContainerGap()));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, 60, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(backButton)
												.addComponent(titlePanel, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(match2Panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 87,
												Short.MAX_VALUE)
										.addComponent(match3Panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 87,
												Short.MAX_VALUE)
										.addComponent(match1Panel, 0, 0, Short.MAX_VALUE)
										.addComponent(match4Panel, GroupLayout.PREFERRED_SIZE, 87, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(team1StartButton, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
										.addComponent(team3StartButton, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
										.addComponent(team2StartButton, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
										.addComponent(team4StartButton, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
								.addContainerGap()));

		JLabel team2Name = new JLabel(oppTeam2Name);
		team2Name.setFont(new Font("Orbitron", Font.PLAIN, 14));
		team2Name.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_match1Panel = new GroupLayout(match1Panel);
		gl_match1Panel.setHorizontalGroup(
				gl_match1Panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(team2Name, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
						.addComponent(team2NameTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
						.addComponent(team2RewardTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 143,
								Short.MAX_VALUE)
						.addGroup(gl_match1Panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(team2Reward, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
								.addContainerGap()));
		gl_match1Panel.setVerticalGroup(
				gl_match1Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_match1Panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(team2NameTitle, GroupLayout.PREFERRED_SIZE, 14,
										GroupLayout.PREFERRED_SIZE)
								.addGap(4)
								.addComponent(team2Name)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(team2RewardTitle)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(team2Reward)
								.addContainerGap()));
		match1Panel.setLayout(gl_match1Panel);

		JLabel moneyLabel = new JLabel(String.format("Money: $%d", environment.getGame().getBank().getMoney()));
		moneyLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));

		JLabel weekLabel = new JLabel(
				String.format("Week: %d/%d", environment.getGame().getCurrentWeek(), environment.getGame().getWeek()));
		weekLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));

		JLabel winsLabel = new JLabel(String.format("Wins: %d", environment.getGame().getWins()));
		winsLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));

		JLabel lossLabel = new JLabel(String.format("Losses: %d", environment.getGame().getLosses()));
		lossLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_statPanel = new GroupLayout(statPanel);
		gl_statPanel.setHorizontalGroup(
				gl_statPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_statPanel.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_statPanel.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_statPanel.createSequentialGroup()
												.addComponent(moneyLabel)
												.addGap(18))
										.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_statPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(winsLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
										.addComponent(lossLabel, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		gl_statPanel.setVerticalGroup(
				gl_statPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_statPanel.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_statPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(moneyLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(winsLabel, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_statPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lossLabel, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))));
		statPanel.setLayout(gl_statPanel);
		frmStadium.getContentPane().setLayout(groupLayout);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
	}
}
