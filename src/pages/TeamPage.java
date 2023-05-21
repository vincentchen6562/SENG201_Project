package src.pages;
import src.*;
import src.team.Athlete;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JComboBox;

public class TeamPage {

	private JFrame frame;
	private GameEnvironment environment;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeamPage window = new TeamPage();
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
	public TeamPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		environment.closeTeamPage(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ArrayList<Athlete> equippedAthletes = environment
				.getGame().getTeam().getEquippedAthletes();
		
		Athlete excessAthlete = environment
				.getGame().getTeam().getExcessAthlete();
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JButton sellButton = new JButton("Sell");
		
		JButton athlete1Button = new JButton();
		JButton athlete2Button = new JButton();
		JButton athlete3Button = new JButton();
		JButton athlete4Button = new JButton();
		JButton athlete5Button = new JButton();
		JButton excessAthleteButton = new JButton();
		
		excessAthleteButton.setForeground(Color.BLACK);
		excessAthleteButton.setBackground(Color.GRAY);
		if (excessAthlete != null) {
			excessAthleteButton.setText(excessAthlete.getFullName());
		}
		
		JButton swapButton = new JButton("Swap");
	
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(athlete1Button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(athlete2Button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(athlete4Button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(athlete5Button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(athlete3Button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(excessAthleteButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(swapButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(sellButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(4, Short.MAX_VALUE))
				.addComponent(titlePanel, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(swapButton, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(sellButton, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(athlete1Button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(athlete2Button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(athlete3Button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(excessAthleteButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(athlete5Button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(athlete4Button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel nameLabel = new JLabel("Name:");
		JLabel offenceLabel = new JLabel("Offence:");
		JLabel defenceLabel = new JLabel("Defence:");
		JLabel agilityLabel = new JLabel("Agility:");
		JLabel staminaLabel = new JLabel("Stamina:");
		JLabel healthLabel = new JLabel("Health:");
		
		JComboBox<String> comboBox = new JComboBox<String>();
		JLabel swapLabel = new JLabel("Swap With:");

		
		comboBox.setEnabled(false);
		swapButton.setEnabled(false);
		swapLabel.setEnabled(false);
		
		if (equippedAthletes.size() > 0) {
			athlete1Button.setText(equippedAthletes.get(0).getFullName());
			athlete1Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox.setEnabled(false);
					swapButton.setEnabled(false);
					swapLabel.setEnabled(false);
					nameLabel.setText(String.format("Name: %s", equippedAthletes.get(0).getFullName()));
					offenceLabel.setText(String.format("Offence: %d", equippedAthletes.get(0).getOffence()));
					defenceLabel.setText(String.format("Defence: %d", equippedAthletes.get(0).getDefence()));
					agilityLabel.setText(String.format("Agility: %d", equippedAthletes.get(0).getAgility()));
					staminaLabel.setText(String.format("Stamina: %d", equippedAthletes.get(0).getStamina()));
					if (equippedAthletes.get(0).getIsInjured()) {
						healthLabel.setText("Health: Injured");
					} else {
						healthLabel.setText("Health: Good-Condition");
					}
					
					sellButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							environment.getGame().getBank().alterMoney(equippedAthletes.get(0).getPrice()/2);
							environment.getGame().getTeam().getEquippedAthletes().remove(0);
							finishedWindow();
						}
					});
				}
			});
		}
		
		if (equippedAthletes.size() > 1) {
			athlete2Button.setText(equippedAthletes.get(1).getFullName());
			athlete2Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox.setEnabled(false);
					swapButton.setEnabled(false);
					swapLabel.setEnabled(false);
					nameLabel.setText(String.format("Name: %s", equippedAthletes.get(1).getFullName()));
					offenceLabel.setText(String.format("Offence: %d", equippedAthletes.get(1).getOffence()));
					defenceLabel.setText(String.format("Defence: %d", equippedAthletes.get(1).getDefence()));
					agilityLabel.setText(String.format("Agility: %d", equippedAthletes.get(1).getAgility()));
					staminaLabel.setText(String.format("Stamina: %d", equippedAthletes.get(1).getStamina()));
					if (equippedAthletes.get(1).getIsInjured()) {
						healthLabel.setText("Health: Injured");
					} else {
						healthLabel.setText("Health: Good-Condition");
					}
					
					sellButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							environment.getGame().getBank().alterMoney(equippedAthletes.get(1).getPrice()/2);
							environment.getGame().getTeam().getEquippedAthletes().remove(1);
							finishedWindow();
						}
					});
				}
			});
		}
		
		if (equippedAthletes.size() > 2) {
			athlete3Button.setText(equippedAthletes.get(2).getFullName());
			athlete3Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox.setEnabled(false);
					swapButton.setEnabled(false);
					swapLabel.setEnabled(false);
					nameLabel.setText(String.format("Name: %s", equippedAthletes.get(2).getFullName()));
					offenceLabel.setText(String.format("Offence: %d", equippedAthletes.get(2).getOffence()));
					defenceLabel.setText(String.format("Defence: %d", equippedAthletes.get(2).getDefence()));
					agilityLabel.setText(String.format("Agility: %d", equippedAthletes.get(2).getAgility()));
					staminaLabel.setText(String.format("Stamina: %d", equippedAthletes.get(2).getStamina()));
					if (equippedAthletes.get(2).getIsInjured()) {
						healthLabel.setText("Health: Injured");
					} else {
						healthLabel.setText("Health: Good-Condition");
					}
					
					sellButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							environment.getGame().getBank().alterMoney(equippedAthletes.get(2).getPrice()/2);
							environment.getGame().getTeam().getEquippedAthletes().remove(2);
							finishedWindow();
						}
					});
				}
			});	
		}	
		
		if (equippedAthletes.size() > 3) {
			athlete4Button.setText(equippedAthletes.get(3).getFullName());
			athlete4Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox.setEnabled(false);
					swapButton.setEnabled(false);
					swapLabel.setEnabled(false);
					nameLabel.setText(String.format("Name: %s", equippedAthletes.get(3).getFullName()));
					offenceLabel.setText(String.format("Offence: %d", equippedAthletes.get(3).getOffence()));
					defenceLabel.setText(String.format("Defence: %d", equippedAthletes.get(3).getDefence()));
					agilityLabel.setText(String.format("Agility: %d", equippedAthletes.get(3).getAgility()));
					staminaLabel.setText(String.format("Stamina: %d", equippedAthletes.get(3).getStamina()));
					if (equippedAthletes.get(3).getIsInjured()) {
						healthLabel.setText("Health: Injured");
					} else {
						healthLabel.setText("Health: Good-Condition");
					}
					sellButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							environment.getGame().getBank().alterMoney(equippedAthletes.get(3).getPrice()/2);
							environment.getGame().getTeam().getEquippedAthletes().remove(3);
							finishedWindow();
						}
					});
				}
			});
			
		}
		
		if (equippedAthletes.size() > 4) {
			athlete5Button.setText(equippedAthletes.get(4).getFullName());
			athlete5Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox.setEnabled(false);
					swapButton.setEnabled(false);
					swapLabel.setEnabled(false);
					nameLabel.setText(String.format("Name: %s", equippedAthletes.get(4).getFullName()));
					offenceLabel.setText(String.format("Offence: %d", equippedAthletes.get(4).getOffence()));
					defenceLabel.setText(String.format("Defence: %d", equippedAthletes.get(4).getDefence()));
					agilityLabel.setText(String.format("Agility: %d", equippedAthletes.get(4).getAgility()));
					staminaLabel.setText(String.format("Stamina: %d", equippedAthletes.get(4).getStamina()));
					if (equippedAthletes.get(4).getIsInjured()) {
						healthLabel.setText("Health: Injured");
					} else {
						healthLabel.setText("Health: Good-Condition");
					}
					sellButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							environment.getGame().getBank().alterMoney(equippedAthletes.get(4).getPrice()/2);
							environment.getGame().getTeam().getEquippedAthletes().remove(4);
							finishedWindow();
						}
					});
				}
			});
		}

		if (excessAthlete != null) {
			excessAthleteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nameLabel.setText(String.format("Name: %s", excessAthlete.getFullName()));
					offenceLabel.setText(String.format("Offence: %d", excessAthlete.getOffence()));
					defenceLabel.setText(String.format("Defence: %d", excessAthlete.getDefence()));
					agilityLabel.setText(String.format("Agility: %d", excessAthlete.getAgility()));
					staminaLabel.setText(String.format("Stamina: %d", excessAthlete.getStamina()));
					if (excessAthlete.getIsInjured()) {
						healthLabel.setText("Health: Injured");
					} else {
						healthLabel.setText("Health: Good-Condition");
					}
					
					comboBox.setEnabled(true);
					swapButton.setEnabled(true);
					swapLabel.setEnabled(true);
					comboBox.addItem(equippedAthletes.get(0).getFullName());
					comboBox.addItem(equippedAthletes.get(1).getFullName());
					comboBox.addItem(equippedAthletes.get(2).getFullName());
					comboBox.addItem(equippedAthletes.get(3).getFullName());
					comboBox.addItem(equippedAthletes.get(4).getFullName());
		
				}
			});
		};
		
		swapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.getGame().getTeam().setAthlete(comboBox.getSelectedIndex());
				finishedWindow();
			}
		});
				
		
		GroupLayout gl_infoPanel = new GroupLayout(infoPanel);
		gl_infoPanel.setHorizontalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_infoPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addComponent(offenceLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(defenceLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(agilityLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(staminaLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(healthLabel)
					.addContainerGap(147, Short.MAX_VALUE))
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(swapLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_infoPanel.setVerticalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addGap(1)
					.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(offenceLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(defenceLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(agilityLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(staminaLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(healthLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_infoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(swapLabel)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		infoPanel.setLayout(gl_infoPanel);
		
		JButton backButton = new JButton("<");
		backButton.setFont(new Font("SimSun", Font.BOLD, 12));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		
		JLabel teamNameLabel = new JLabel(environment.getGame().getTeam().getTeamName());
		teamNameLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		GroupLayout gl_titlePanel = new GroupLayout(titlePanel);
		gl_titlePanel.setHorizontalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addComponent(backButton)
					.addGap(185)
					.addComponent(teamNameLabel)
					.addContainerGap(223, Short.MAX_VALUE))
		);
		gl_titlePanel.setVerticalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addComponent(backButton)
					.addContainerGap(34, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_titlePanel.createSequentialGroup()
					.addContainerGap(21, Short.MAX_VALUE)
					.addComponent(teamNameLabel)
					.addGap(14))
		);
		titlePanel.setLayout(gl_titlePanel);
		frame.getContentPane().setLayout(groupLayout);
	}
}