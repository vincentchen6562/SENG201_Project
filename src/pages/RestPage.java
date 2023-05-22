package src.pages;
import src.*;
import src.team.Athlete;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class RestPage {

	private JFrame frmTakeABye;
	private GameEnvironment environment;

	/**
	 * Create the application.
	 */
	public RestPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frmTakeABye.setVisible(true);
	}
	
	public void closeWindow() {
		frmTakeABye.dispose();
	}
	
	public void finishedWindow() {
		environment.closeRestPage(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTakeABye = new JFrame();
		frmTakeABye.setTitle("Take a Bye");
		frmTakeABye.setBounds(100, 100, 600, 400);
		frmTakeABye.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int money = environment.getGame().getBank().getMoney();
		int currentWeek = environment.getGame().getCurrentWeek();
		int totalWeek = environment.getGame().getWeek();
		int numWins = environment.getGame().getWins();
		int numLoss = environment.getGame().getLosses();
		
		// Get the athlete names from the team
		String playerTeamName = environment.getGame().getTeam().getTeamName();
		ArrayList<Athlete> playerAthletes = environment
				.getGame().getTeam().getEquippedAthletes();
		ArrayList<String> playerAthleteNames = new ArrayList<String>();
		ArrayList<Integer> playerCenterStats = new ArrayList<Integer>();
		ArrayList<Integer> playerSFStats = new ArrayList<Integer>();
		ArrayList<Integer> playerPFStats = new ArrayList<Integer>();
		ArrayList<Integer> playerPGStats = new ArrayList<Integer>();
		ArrayList<Integer> playerSGStats = new ArrayList<Integer>();
		
		for(Athlete playerAthlete : playerAthletes) {
			playerAthleteNames.add(playerAthlete.getFullName());
			playerCenterStats.add(playerAthlete.getDefence());
			playerSFStats.add((playerAthlete.getOffence() + playerAthlete.getAgility() + playerAthlete.getDefence()) / 3);
			playerPFStats.add(playerAthlete.getOffence());
			playerPGStats.add((playerAthlete.getOffence() + playerAthlete.getAgility()) / 2);
			playerSGStats.add(playerAthlete.getOffence());
		}
		
		JPanel statPanel = new JPanel();
		statPanel.setBorder(new CompoundBorder());
		
		JLabel moneyLabel = new JLabel(String.format("Money: $%d", money));
		moneyLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel weekLabel = new JLabel(String.format("Week: %d/%d", currentWeek, totalWeek));
		weekLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel winsLabel = new JLabel(String.format("Wins: %d", numWins));
		winsLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel lossLabel = new JLabel(String.format("Losses: %d", numLoss));
		lossLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_statPanel = new GroupLayout(statPanel);
		gl_statPanel.setHorizontalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 215, Short.MAX_VALUE)
				.addGroup(gl_statPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_statPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(moneyLabel)
						.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_statPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(winsLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(lossLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_statPanel.setVerticalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 60, Short.MAX_VALUE)
				.addGroup(gl_statPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_statPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(moneyLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(winsLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_statPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lossLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
		);
		statPanel.setLayout(gl_statPanel);
		
		JLabel takeAByeLabel = new JLabel("Take a Bye");
		takeAByeLabel.setFont(new Font("Orbitron", Font.BOLD, 20));
		takeAByeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		
		JButton readyButton = new JButton("Ready");
		readyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.getGame().incrementWeek();
				finishedWindow();
			}
		});
		readyButton.setFont(new Font("Orbitron", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(frmTakeABye.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(takeAByeLabel, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(246)
					.addComponent(readyButton)
					.addContainerGap(255, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(takeAByeLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(readyButton, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addGap(18))
		);
		
		JPanel athlete1Panel = new JPanel();
		athlete1Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel athlete1Panel_1 = new JPanel();
		athlete1Panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JToggleButton toggleButton_1 = new JToggleButton("New toggle button");
		
		JLabel athlete2NameLabel = new JLabel(playerAthleteNames.get(1));
		athlete2NameLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel sfLabel = new JLabel("Small Forward");
		sfLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sfLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel sfStatsLabel = new JLabel(String.format("Avg(DEF+OFF+AGL): %d",playerSFStats.get(1)));
		sfStatsLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_athlete1Panel_1 = new GroupLayout(athlete1Panel_1);
		gl_athlete1Panel_1.setHorizontalGroup(
			gl_athlete1Panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 179, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_athlete1Panel_1.createSequentialGroup()
							.addGap(10)
							.addComponent(toggleButton_1))
						.addComponent(athlete2NameLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(sfLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(sfStatsLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_athlete1Panel_1.setVerticalGroup(
			gl_athlete1Panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(sfLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete2NameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sfStatsLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toggleButton_1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		athlete1Panel_1.setLayout(gl_athlete1Panel_1);
		
		JPanel athlete1Panel_2 = new JPanel();
		athlete1Panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JToggleButton toggleButton_2 = new JToggleButton("New toggle button");
		
		JLabel athlete3NameLabel = new JLabel(playerAthleteNames.get(2));
		athlete3NameLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel pfLabel = new JLabel("Power Forward");
		pfLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pfLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel pfStatsLabel = new JLabel(String.format("OFF: %d",playerPFStats.get(2)));
		pfStatsLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_athlete1Panel_2 = new GroupLayout(athlete1Panel_2);
		gl_athlete1Panel_2.setHorizontalGroup(
			gl_athlete1Panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 179, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_athlete1Panel_2.createSequentialGroup()
							.addGap(10)
							.addComponent(toggleButton_2))
						.addComponent(athlete3NameLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(pfLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(pfStatsLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_athlete1Panel_2.setVerticalGroup(
			gl_athlete1Panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(pfLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete3NameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pfStatsLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toggleButton_2)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		athlete1Panel_2.setLayout(gl_athlete1Panel_2);
		
		JPanel athlete1Panel_3 = new JPanel();
		athlete1Panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JToggleButton toggleButton_3 = new JToggleButton("New toggle button");
		
		JLabel athlete4NameLabel = new JLabel(playerAthleteNames.get(3));
		athlete4NameLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel pgLabel = new JLabel("Point Guard");
		pgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pgLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel pgStatsLabel = new JLabel(String.format("Avg(OFF+AGL): %d",playerCenterStats.get(2)));
		pgStatsLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_athlete1Panel_3 = new GroupLayout(athlete1Panel_3);
		gl_athlete1Panel_3.setHorizontalGroup(
			gl_athlete1Panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 179, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_athlete1Panel_3.createSequentialGroup()
							.addGap(10)
							.addComponent(toggleButton_3))
						.addComponent(athlete4NameLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(pgLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(pgStatsLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_athlete1Panel_3.setVerticalGroup(
			gl_athlete1Panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(pgLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete4NameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pgStatsLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toggleButton_3)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		athlete1Panel_3.setLayout(gl_athlete1Panel_3);
		
		JPanel athlete1Panel_4 = new JPanel();
		athlete1Panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JToggleButton toggleButton_4 = new JToggleButton("New toggle button");
		
		JLabel athlete5NameLabel = new JLabel(playerAthleteNames.get(4));
		athlete5NameLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel sgLabel = new JLabel("Shooting Guard");
		sgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sgLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel sgStatsLabel = new JLabel(String.format("OFF: %d",playerCenterStats.get(4)));
		sgStatsLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_athlete1Panel_4 = new GroupLayout(athlete1Panel_4);
		gl_athlete1Panel_4.setHorizontalGroup(
			gl_athlete1Panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 179, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_athlete1Panel_4.createSequentialGroup()
							.addGap(10)
							.addComponent(toggleButton_4))
						.addComponent(athlete5NameLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(sgLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(sgStatsLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_athlete1Panel_4.setVerticalGroup(
			gl_athlete1Panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(sgLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete5NameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sgStatsLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toggleButton_4)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		athlete1Panel_4.setLayout(gl_athlete1Panel_4);
		
		JPanel athlete1Panel_5 = new JPanel();
		athlete1Panel_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JToggleButton toggleButton_5 = new JToggleButton("New toggle button");
		
		JLabel athlete6NameLabel = new JLabel("Name");
		athlete6NameLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel reserveLabel = new JLabel("Reserve");
		reserveLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reserveLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel reserveStatsLabel = new JLabel("Stats");
		reserveStatsLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_athlete1Panel_5 = new GroupLayout(athlete1Panel_5);
		gl_athlete1Panel_5.setHorizontalGroup(
			gl_athlete1Panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 179, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_athlete1Panel_5.createSequentialGroup()
							.addGap(10)
							.addComponent(toggleButton_5))
						.addComponent(athlete6NameLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(reserveLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(reserveStatsLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_athlete1Panel_5.setVerticalGroup(
			gl_athlete1Panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(reserveLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete6NameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reserveStatsLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toggleButton_5)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		athlete1Panel_5.setLayout(gl_athlete1Panel_5);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(athlete1Panel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(athlete1Panel_1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(athlete1Panel_2, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(athlete1Panel_3, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(athlete1Panel_4, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(athlete1Panel_5, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(athlete1Panel_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(athlete1Panel_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(athlete1Panel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(athlete1Panel_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(athlete1Panel_4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(athlete1Panel_5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(17))
		);
		
		JLabel centerLabel = new JLabel("Center");
		centerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		centerLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel athlete1NameLabel = new JLabel(playerAthleteNames.get(0));
		athlete1NameLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel centerStats = new JLabel(String.format("DEF: %d",playerCenterStats.get(0)));
		centerStats.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JToggleButton toggleButton = new JToggleButton("New toggle button");
		GroupLayout gl_athlete1Panel = new GroupLayout(athlete1Panel);
		gl_athlete1Panel.setHorizontalGroup(
			gl_athlete1Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_athlete1Panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_athlete1Panel.createSequentialGroup()
							.addGap(10)
							.addComponent(toggleButton))
						.addComponent(athlete1NameLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(centerLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(centerStats, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_athlete1Panel.setVerticalGroup(
			gl_athlete1Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_athlete1Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(centerLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete1NameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centerStats)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toggleButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		athlete1Panel.setLayout(gl_athlete1Panel);
		panel.setLayout(gl_panel);
		frmTakeABye.getContentPane().setLayout(groupLayout);
	}
}
