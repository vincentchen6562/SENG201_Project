package src.pages;
import src.*;
import src.team.Athlete;
import src.team.Team;

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
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class RestPage {

	private JFrame frmTakeABye;
	private GameEnvironment environment;

	/**
	 * constructs a rest page object.
	 * 
	 * @param incomingEnvironment the game environment
	 */

	public RestPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frmTakeABye.setVisible(true);
	}
	
	/**
	 * Closes the match page window.
	 */
	public void closeWindow() {
		frmTakeABye.dispose();
	}
	
	/**
	 * closes the rest page window through the game environment
	 */
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
		
		// for the reserve athlete
		Athlete reserve = environment.getGame().getTeam().getExcessAthlete();
		
		String reserveName = new String();
		String reserveStatDisplay = new String();
		
		
		if(reserve == null) {
			reserveName = "N/A";
			reserveStatDisplay = "N/A";
		} else {
			reserveName = reserve.getFullName();
			int[] reserveStat = {reserve.getOffence(), reserve.getDefence(), reserve.getAgility()};
			reserveStatDisplay = String.format("OFF/DEF/AGL: %d/%d/%d", reserveStat[0], reserveStat[1], reserveStat[2]);
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
		
		JLabel lblNewLabel = new JLabel("Note: training cost is $500");
		lblNewLabel.setFont(new Font("Orbitron", Font.PLAIN, 11));
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
							.addComponent(readyButton)
							.addGap(42))))
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(readyButton, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JPanel athlete1Panel = new JPanel();
		athlete1Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel athlete1Panel_1 = new JPanel();
		athlete1Panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel sfStatsLabel = new JLabel(String.format("Avg(DEF+OFF+AGL): %d",playerSFStats.get(1)));
		sfStatsLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		JToggleButton sfTrainBtn = new JToggleButton("Train");
		sfTrainBtn.setFont(new Font("Orbitron", Font.PLAIN, 12));
		sfTrainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sfTrainBtn.isSelected()) {
					sfTrainBtn.setText("Rest");
					environment.getGame().getBank().decreaseMoney(500);
					Team team = environment.getGame().getTeam();
					if(team.getSFStat() < 10) {
						Athlete smallForward = team.getEquippedAthletes().get(1);
						if(team.getEquippedAthletes().get(1).getDefence() < 10) {
							smallForward.randomAlterStat("Defence");
						}
						if(team.getEquippedAthletes().get(1).getAgility() < 10) {
							smallForward.randomAlterStat("Agility");
						}
						if(team.getEquippedAthletes().get(1).getOffence() < 10) {
							smallForward.randomAlterStat("Offence");
						}
						
					}
				} else {
					sfTrainBtn.setText("Train");
				}
				
			}
		});
		sfTrainBtn.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int updatedSFStat = environment.getGame().getTeam().getSFStat();
				int updatedMoney = environment.getGame().getBank().getMoney();
				if(updatedSFStat > 10) {
					updatedSFStat = 10;
				}
				sfStatsLabel.setText(String.format("Avg(DEF+OFF+AGL): %d", updatedSFStat));
				if(updatedMoney <= 0) {
					updatedMoney = 0;
				}
				moneyLabel.setText(String.format("Money: $%d", updatedMoney));
			}
		});
		
		JLabel athlete2NameLabel = new JLabel(playerAthleteNames.get(1));
		athlete2NameLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel sfLabel = new JLabel("Small Forward");
		sfLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sfLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		
		GroupLayout gl_athlete1Panel_1 = new GroupLayout(athlete1Panel_1);
		gl_athlete1Panel_1.setHorizontalGroup(
			gl_athlete1Panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_athlete1Panel_1.createSequentialGroup()
					.addGroup(gl_athlete1Panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_athlete1Panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_athlete1Panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(athlete2NameLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addComponent(sfLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addComponent(sfStatsLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
						.addGroup(gl_athlete1Panel_1.createSequentialGroup()
							.addGap(20)
							.addComponent(sfTrainBtn, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_athlete1Panel_1.setVerticalGroup(
			gl_athlete1Panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_athlete1Panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(sfLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete2NameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sfStatsLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sfTrainBtn, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
					.addContainerGap())
		);
		athlete1Panel_1.setLayout(gl_athlete1Panel_1);
		
		JPanel athlete1Panel_2 = new JPanel();
		athlete1Panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel pfStatsLabel = new JLabel(String.format("OFF: %d",playerPFStats.get(2)));
		pfStatsLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		JToggleButton pfToggleButton = new JToggleButton("Train");
		pfToggleButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int updatedOffence = environment.getGame().getTeam().getEquippedAthletes().get(2).getOffence();
				
				if(updatedOffence > 10) {
					updatedOffence = 10;
				}
				pfStatsLabel.setText(String.format("OFF: %d", updatedOffence));
				
				int updatedMoney = environment.getGame().getBank().getMoney();
				if(updatedMoney <= 0) {
					updatedMoney = 0;
				}
				moneyLabel.setText(String.format("Money: $%d", updatedMoney));
			}
		});
		pfToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pfToggleButton.isSelected()) {
					pfToggleButton.setText("Rest");
					environment.getGame().getBank().decreaseMoney(500);
					Athlete powerForward = playerAthletes.get(2);
					if(powerForward.getOffence() < 10) {
						if(environment.getGame().getBank().getMoney() > 500) {
							powerForward.randomAlterStat("Offence");
							environment.getGame().getBank().decreaseMoney(500);
						}
					}
				} else {
					pfToggleButton.setText("Train");
				}
			}
			
		});
		pfToggleButton.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel athlete3NameLabel = new JLabel(playerAthleteNames.get(2));
		athlete3NameLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel pfLabel = new JLabel("Power Forward");
		pfLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pfLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		GroupLayout gl_athlete1Panel_2 = new GroupLayout(athlete1Panel_2);
		gl_athlete1Panel_2.setHorizontalGroup(
			gl_athlete1Panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_athlete1Panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(athlete3NameLabel, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addComponent(pfLabel, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addComponent(pfStatsLabel, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addGroup(gl_athlete1Panel_2.createSequentialGroup()
							.addGap(10)
							.addComponent(pfToggleButton, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_athlete1Panel_2.setVerticalGroup(
			gl_athlete1Panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_athlete1Panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(pfLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete3NameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pfStatsLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pfToggleButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		athlete1Panel_2.setLayout(gl_athlete1Panel_2);
		
		JPanel athlete1Panel_3 = new JPanel();
		athlete1Panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel pgStatsLabel = new JLabel(String.format("Avg(OFF+AGL): %d",playerPGStats.get(3)));
		pgStatsLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JToggleButton pgTrainBtn = new JToggleButton("Train");
		pgTrainBtn.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int updatedPGStat = environment.getGame().getTeam().getPGStat();
				int updatedMoney = environment.getGame().getBank().getMoney();
				if(updatedPGStat > 10) {
					updatedPGStat = 10;
				}
				pgStatsLabel.setText(String.format("Avg(OFF+AGL): %d", updatedPGStat));
				if(updatedMoney <= 0) {
					updatedMoney = 0;
				}
				moneyLabel.setText(String.format("Money: $%d", updatedMoney));
			}
		});
		pgTrainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pgTrainBtn.isSelected()) {
					pgTrainBtn.setText("Rest");
					environment.getGame().getBank().decreaseMoney(500);
					Team team = environment.getGame().getTeam();
					if(team.getPGStat() < 10) {
						Athlete pointGuard = team.getEquippedAthletes().get(3);
						if(team.getEquippedAthletes().get(3).getAgility() < 10) {
							pointGuard.randomAlterStat("Agility");
						}
						if(team.getEquippedAthletes().get(3).getOffence() < 10) {
							pointGuard.randomAlterStat("Offence");
						}
						
					}
				} else {
					pgTrainBtn.setText("Train");
				}
			}
			
		});
		pgTrainBtn.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel athlete4NameLabel = new JLabel(playerAthleteNames.get(3));
		athlete4NameLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel pgLabel = new JLabel("Point Guard");
		pgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pgLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		GroupLayout gl_athlete1Panel_3 = new GroupLayout(athlete1Panel_3);
		gl_athlete1Panel_3.setHorizontalGroup(
			gl_athlete1Panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_athlete1Panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(athlete4NameLabel, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addComponent(pgLabel, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addComponent(pgStatsLabel, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addGroup(gl_athlete1Panel_3.createSequentialGroup()
							.addGap(10)
							.addComponent(pgTrainBtn, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_athlete1Panel_3.setVerticalGroup(
			gl_athlete1Panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_athlete1Panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(pgLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete4NameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pgStatsLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pgTrainBtn)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		athlete1Panel_3.setLayout(gl_athlete1Panel_3);
		
		JPanel athlete1Panel_4 = new JPanel();
		athlete1Panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel sgStatsLabel = new JLabel(String.format("OFF: %d",playerCenterStats.get(4)));
		sgStatsLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JToggleButton sgTrainBtn = new JToggleButton("Train");
		sgTrainBtn.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int updatedOffence1 = environment.getGame().getTeam().getEquippedAthletes().get(4).getOffence();
				
				if(updatedOffence1 > 10) {
					updatedOffence1 = 10;
				}
				sgStatsLabel.setText(String.format("OFF: %d", updatedOffence1));
				
				int updatedMoney = environment.getGame().getBank().getMoney();
				if(updatedMoney <= 0) {
					updatedMoney = 0;
				}
				moneyLabel.setText(String.format("Money: $%d", updatedMoney));
			}
			
			
		});
		sgTrainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // there is a bug with this button
				if(sgTrainBtn.isSelected()) {
					sgTrainBtn.setText("Rest");
					System.out.println(playerAthletes.get(4).getOffence()); // needs to be deleted
					environment.getGame().getBank().decreaseMoney(500);
					Athlete shootingGuard = playerAthletes.get(4);
					if(shootingGuard.getOffence() < 10) {
						if(environment.getGame().getBank().getMoney() > 500) {
							shootingGuard.randomAlterStat("Offence");
							environment.getGame().getBank().decreaseMoney(500);
						}
					}
				} else {
					sgTrainBtn.setText("Train");
				}
			}
				
			
		});
		sgTrainBtn.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel athlete5NameLabel = new JLabel(playerAthleteNames.get(4));
		athlete5NameLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel sgLabel = new JLabel("Shooting Guard");
		sgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sgLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		GroupLayout gl_athlete1Panel_4 = new GroupLayout(athlete1Panel_4);
		gl_athlete1Panel_4.setHorizontalGroup(
			gl_athlete1Panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_athlete1Panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(athlete5NameLabel, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addComponent(sgLabel, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addComponent(sgStatsLabel, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addGroup(gl_athlete1Panel_4.createSequentialGroup()
							.addGap(10)
							.addComponent(sgTrainBtn, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_athlete1Panel_4.setVerticalGroup(
			gl_athlete1Panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_athlete1Panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(sgLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete5NameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sgStatsLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sgTrainBtn)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		athlete1Panel_4.setLayout(gl_athlete1Panel_4);
		
		JPanel athlete1Panel_5 = new JPanel();
		athlete1Panel_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel athlete6NameLabel = new JLabel(reserveName);
		athlete6NameLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel reserveLabel = new JLabel("Reserve");
		reserveLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reserveLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel reserveStatsLabel = new JLabel(reserveStatDisplay);
		reserveStatsLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_athlete1Panel_5 = new GroupLayout(athlete1Panel_5);
		gl_athlete1Panel_5.setHorizontalGroup(
			gl_athlete1Panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_athlete1Panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(athlete6NameLabel, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addComponent(reserveLabel, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addComponent(reserveStatsLabel, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_athlete1Panel_5.setVerticalGroup(
			gl_athlete1Panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_athlete1Panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(reserveLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete6NameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reserveStatsLabel)
					.addContainerGap(61, Short.MAX_VALUE))
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
		
		JToggleButton centerToggleButton = new JToggleButton("Train");
		centerToggleButton.setFont(new Font("Orbitron", Font.PLAIN, 12));
		centerToggleButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int updatedDefence = environment.getGame().getTeam().getEquippedAthletes().get(0).getDefence();
				
				if(updatedDefence > 10) {
					updatedDefence = 10;
				}
				centerStats.setText(String.format("DEF: %d", updatedDefence));
				
				int updatedMoney = environment.getGame().getBank().getMoney();
				if(updatedMoney <= 0) {
					updatedMoney = 0;
				}
				moneyLabel.setText(String.format("Money: $%d", updatedMoney));
			}
		});
		centerToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(centerToggleButton.isSelected()) {
					centerToggleButton.setText("Rest");
					environment.getGame().getBank().decreaseMoney(500);
					Athlete center = playerAthletes.get(0);
					if(center.getDefence() < 10) {
						if(environment.getGame().getBank().getMoney() > 500) {
							center.randomAlterStat("Defence");
							environment.getGame().getBank().decreaseMoney(500);
						}
						
					}
				} else {
					centerToggleButton.setText("Train");
				}
				
			}
		});
		GroupLayout gl_athlete1Panel = new GroupLayout(athlete1Panel);
		gl_athlete1Panel.setHorizontalGroup(
			gl_athlete1Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_athlete1Panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_athlete1Panel.createSequentialGroup()
							.addGap(10)
							.addComponent(centerToggleButton, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addComponent(athlete1NameLabel, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addComponent(centerLabel, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addComponent(centerStats, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(centerToggleButton)
					.addContainerGap())
		);
		athlete1Panel.setLayout(gl_athlete1Panel);
		panel.setLayout(gl_panel);
		frmTakeABye.getContentPane().setLayout(groupLayout);
	}
}
