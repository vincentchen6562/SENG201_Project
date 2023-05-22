package src.pages;
import src.*;
import src.items.Item;
import src.team.Athlete;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	private Boolean swapButtonExecuted = false;

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
	
	public void setSwapButtonExecuted() {
		this.swapButtonExecuted = true;
	}
	

	public void swapButtonHelper(JComboBox<String> comboBox, int index, JButton swapButton) {
		swapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!swapButtonExecuted) {
				environment.getGame().getTeam().setAthlete(comboBox.getSelectedIndex(), index);
				setSwapButtonExecuted();
				finishedWindow();
				}
			}
		});
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
		
		JLabel centerLabel = new JLabel("Center");
		
		JLabel smallForwardLabel = new JLabel("Small Forward");
		
		JLabel powerForwardLabel = new JLabel("Power Forward");
		
		JLabel pointGuardLabel = new JLabel("Point Guard");
		
		JLabel shootingGuardLabel = new JLabel("Shooting Guard");
		
		JLabel benchLabel = new JLabel("Bench");
		
		JLabel coachLabel = new JLabel("Coach:");
		
		JLabel coachBoostLabel = new JLabel("Coach Boost:");
	
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(52)
									.addComponent(centerLabel)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(smallForwardLabel)
									.addGap(57)
									.addComponent(powerForwardLabel)
									.addGap(23))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(1)
											.addComponent(athlete1Button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
											.addGap(16)
											.addComponent(athlete2Button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(athlete4Button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(athlete5Button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(excessAthleteButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
										.addComponent(athlete3Button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
									.addGap(6)))
							.addGap(6))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(pointGuardLabel)
							.addGap(65)
							.addComponent(shootingGuardLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
							.addComponent(benchLabel)
							.addGap(53)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(swapButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(sellButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(coachLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(infoPanel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 194, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(coachBoostLabel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addComponent(titlePanel, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(powerForwardLabel)
								.addComponent(coachLabel))
							.addComponent(smallForwardLabel))
						.addComponent(centerLabel))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(athlete3Button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(athlete2Button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(athlete1Button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(pointGuardLabel)
								.addComponent(benchLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(shootingGuardLabel))
							.addGap(9)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(excessAthleteButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(athlete5Button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(athlete4Button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(coachBoostLabel)
							.addGap(12)
							.addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(swapButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addComponent(sellButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		JLabel nameLabel = new JLabel("Name:");
		JLabel offenceLabel = new JLabel("Offence:");
		JLabel defenceLabel = new JLabel("Defence:");
		JLabel agilityLabel = new JLabel("Agility:");
		JLabel staminaLabel = new JLabel("Stamina:");
		JLabel healthLabel = new JLabel("Health:");
		JLabel equippedItemsLabel = new JLabel("Equipped Items: ");

		JComboBox<String> comboBox = new JComboBox<String>();
		JLabel swapLabel = new JLabel("Swap With:");
		JLabel valueLabel = new JLabel("Sells For:");
			
		
		comboBox.setEnabled(false);
		swapButton.setEnabled(false);
		swapLabel.setEnabled(false);
		
		
		if (equippedAthletes.size() > 0) {
			athlete1Button.setText(equippedAthletes.get(0).getFullName());
			athlete1Button.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					comboBox.setEnabled(true);
					swapButton.setEnabled(true);
					swapLabel.setEnabled(true);
					nameLabel.setText(String.format("Name: %s", equippedAthletes.get(0).getFullName()));
					offenceLabel.setText(String.format("Offence: %d", equippedAthletes.get(0).getOffence()));
					defenceLabel.setText(String.format("Defence: %d", equippedAthletes.get(0).getDefence()));
					agilityLabel.setText(String.format("Agility: %d", equippedAthletes.get(0).getAgility()));
					staminaLabel.setText(String.format("Stamina: %d", equippedAthletes.get(0).getStamina()));
					valueLabel.setText(String.format("Sells For: %d", equippedAthletes.get(0).getValue()/2));
					ArrayList<String> athletesItems = new ArrayList<String>();
					ArrayList<Item> itemList  = environment.getGame().getTeam().getEquippedAthletes().get(0).getEquippedItems();
					String result = itemList.stream()
							.map(n -> n.getName())
							.collect(Collectors.joining(", "));
					equippedItemsLabel.setText(String.format("Items: %s", result));
					
					if (equippedAthletes.get(0).getIsInjured()) {
						healthLabel.setText("Health: Injured");
					} else {
						healthLabel.setText("Health: Good-Condition");
					}
					
					sellButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							environment.getGame().getBank().alterMoney(equippedAthletes.get(0).getValue()/2);
							environment.getGame().getTeam().getEquippedAthletes().remove(0);
							finishedWindow();
						}
					});
					
					swapButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							environment.getGame().getTeam().setAthlete(comboBox.getSelectedIndex(), 0);
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
					comboBox.setEnabled(true);
					swapButton.setEnabled(true);
					swapLabel.setEnabled(true);
					comboBox.addItem(equippedAthletes.get(0).getFullName());
					comboBox.addItem(equippedAthletes.get(1).getFullName());
					comboBox.addItem(equippedAthletes.get(2).getFullName());
					comboBox.addItem(equippedAthletes.get(3).getFullName());
					comboBox.addItem(equippedAthletes.get(4).getFullName());
					nameLabel.setText(String.format("Name: %s", equippedAthletes.get(1).getFullName()));
					offenceLabel.setText(String.format("Offence: %d", equippedAthletes.get(1).getOffence()));
					defenceLabel.setText(String.format("Defence: %d", equippedAthletes.get(1).getDefence()));
					agilityLabel.setText(String.format("Agility: %d", equippedAthletes.get(1).getAgility()));
					staminaLabel.setText(String.format("Stamina: %d", equippedAthletes.get(1).getStamina()));
					valueLabel.setText(String.format("Sells For: %d", equippedAthletes.get(1).getValue()/2));
					if (equippedAthletes.get(1).getIsInjured()) {
						healthLabel.setText("Health: Injured");
					} else {
						healthLabel.setText("Health: Good-Condition");
					}
					
					sellButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							environment.getGame().getBank().alterMoney(equippedAthletes.get(1).getValue()/2);
							environment.getGame().getTeam().getEquippedAthletes().remove(1);
							finishedWindow();
						}
					});
					
					swapButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							swapButtonHelper(comboBox, 0, swapButton);
						}
					});
				}
			});
		}
		
		if (equippedAthletes.size() > 2) {
			athlete3Button.setText(equippedAthletes.get(2).getFullName());
			athlete3Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox.setEnabled(true);
					swapButton.setEnabled(true);
					swapLabel.setEnabled(true);
					comboBox.addItem(equippedAthletes.get(0).getFullName());
					comboBox.addItem(equippedAthletes.get(1).getFullName());
					comboBox.addItem(equippedAthletes.get(2).getFullName());
					comboBox.addItem(equippedAthletes.get(3).getFullName());
					comboBox.addItem(equippedAthletes.get(4).getFullName());
					nameLabel.setText(String.format("Name: %s", equippedAthletes.get(2).getFullName()));
					offenceLabel.setText(String.format("Offence: %d", equippedAthletes.get(2).getOffence()));
					defenceLabel.setText(String.format("Defence: %d", equippedAthletes.get(2).getDefence()));
					agilityLabel.setText(String.format("Agility: %d", equippedAthletes.get(2).getAgility()));
					staminaLabel.setText(String.format("Stamina: %d", equippedAthletes.get(2).getStamina()));
					valueLabel.setText(String.format("Sells For: %d", equippedAthletes.get(2).getValue()/2));
					if (equippedAthletes.get(2).getIsInjured()) {
						healthLabel.setText("Health: Injured");
					} else {
						healthLabel.setText("Health: Good-Condition");
					}
					
					sellButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							environment.getGame().getBank().alterMoney(equippedAthletes.get(2).getValue()/2);
							environment.getGame().getTeam().getEquippedAthletes().remove(2);
							finishedWindow();
						}
					});
					
					swapButtonHelper(comboBox, 0, swapButton);
				}
			});	
		}	
		
		if (equippedAthletes.size() > 3) {
			athlete4Button.setText(equippedAthletes.get(3).getFullName());
			athlete4Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox.setEnabled(true);
					swapButton.setEnabled(true);
					swapLabel.setEnabled(true);
					comboBox.addItem(equippedAthletes.get(0).getFullName());
					comboBox.addItem(equippedAthletes.get(1).getFullName());
					comboBox.addItem(equippedAthletes.get(2).getFullName());
					comboBox.addItem(equippedAthletes.get(3).getFullName());
					comboBox.addItem(equippedAthletes.get(4).getFullName());
					nameLabel.setText(String.format("Name: %s", equippedAthletes.get(3).getFullName()));
					offenceLabel.setText(String.format("Offence: %d", equippedAthletes.get(3).getOffence()));
					defenceLabel.setText(String.format("Defence: %d", equippedAthletes.get(3).getDefence()));
					agilityLabel.setText(String.format("Agility: %d", equippedAthletes.get(3).getAgility()));
					staminaLabel.setText(String.format("Stamina: %d", equippedAthletes.get(3).getStamina()));
					valueLabel.setText(String.format("Sells For: %d", equippedAthletes.get(3).getValue()/2));
					if (equippedAthletes.get(3).getIsInjured()) {
						healthLabel.setText("Health: Injured");
					} else {
						healthLabel.setText("Health: Good-Condition");
					}
					sellButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							environment.getGame().getBank().alterMoney(equippedAthletes.get(3).getValue()/2);
							environment.getGame().getTeam().getEquippedAthletes().remove(3);
							finishedWindow();
						}
					});
					
					swapButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							swapButtonHelper(comboBox, 3, swapButton);
						}
					});
				}
			});
			
		}
		
		if (equippedAthletes.size() > 4) {
			athlete5Button.setText(equippedAthletes.get(4).getFullName());
			athlete5Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox.setEnabled(true);
					swapButton.setEnabled(true);
					swapLabel.setEnabled(true);
					comboBox.addItem(equippedAthletes.get(0).getFullName());
					comboBox.addItem(equippedAthletes.get(1).getFullName());
					comboBox.addItem(equippedAthletes.get(2).getFullName());
					comboBox.addItem(equippedAthletes.get(3).getFullName());
					comboBox.addItem(equippedAthletes.get(4).getFullName());
					nameLabel.setText(String.format("Name: %s", equippedAthletes.get(4).getFullName()));
					offenceLabel.setText(String.format("Offence: %d", equippedAthletes.get(4).getOffence()));
					defenceLabel.setText(String.format("Defence: %d", equippedAthletes.get(4).getDefence()));
					agilityLabel.setText(String.format("Agility: %d", equippedAthletes.get(4).getAgility()));
					staminaLabel.setText(String.format("Stamina: %d", equippedAthletes.get(4).getStamina()));
					valueLabel.setText(String.format("Sells For: %d", equippedAthletes.get(4).getValue()/2));
					if (equippedAthletes.get(4).getIsInjured()) {
						healthLabel.setText("Health: Injured");
					} else {
						healthLabel.setText("Health: Good-Condition");
					}
					sellButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							environment.getGame().getBank().alterMoney(equippedAthletes.get(4).getValue()/2);
							environment.getGame().getTeam().getEquippedAthletes().remove(4);
							finishedWindow();
						}
					});
					
					swapButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							swapButtonHelper(comboBox, 4, swapButton);
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
					
					swapButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							swapButtonHelper(comboBox, 5, swapButton);
						}
					});
				}
			});
		};
		
		
		JLabel ifdeleteeverythingbreaks = new JLabel("");
								
		
		GroupLayout gl_infoPanel = new GroupLayout(infoPanel);
		gl_infoPanel.setHorizontalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(offenceLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(92, Short.MAX_VALUE))
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addGap(9)
					.addComponent(defenceLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(93, Short.MAX_VALUE))
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addGap(9)
					.addComponent(agilityLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(93, Short.MAX_VALUE))
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_infoPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_infoPanel.createSequentialGroup()
							.addGap(191)
							.addComponent(ifdeleteeverythingbreaks)))
					.addContainerGap())
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addGap(9)
					.addComponent(staminaLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(93, Short.MAX_VALUE))
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addGap(8)
					.addComponent(healthLabel)
					.addContainerGap(149, Short.MAX_VALUE))
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addGap(8)
					.addComponent(equippedItemsLabel, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addGap(8)
					.addComponent(swapLabel)
					.addGap(6)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addGap(7)
					.addComponent(valueLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		gl_infoPanel.setVerticalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_infoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameLabel)
						.addComponent(ifdeleteeverythingbreaks))
					.addGap(3)
					.addComponent(offenceLabel)
					.addGap(3)
					.addComponent(defenceLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(agilityLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(staminaLabel)
					.addGap(3)
					.addComponent(healthLabel)
					.addGap(2)
					.addComponent(equippedItemsLabel)
					.addGroup(gl_infoPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_infoPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(swapLabel))
						.addGroup(gl_infoPanel.createSequentialGroup()
							.addGap(5)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)))
					.addGap(5)
					.addComponent(valueLabel)
					.addContainerGap(15, Short.MAX_VALUE))
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