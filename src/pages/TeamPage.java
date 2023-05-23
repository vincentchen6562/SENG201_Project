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
import javax.swing.SwingConstants;
/**
 * The TeamPage class represents the graphical user interface (GUI) for managing the team in the game.
 * It allows the player to view and interact with the team's athletes and make changes to their positions.
 */
public class TeamPage {

	private JFrame frame;
	private GameEnvironment environment;
	private Boolean swapButtonExecuted = false;

  /**
   * Constructs a TeamPage object.
   *
   * @param incomingEnvironment The GameEnvironment object representing the game environment.
   */
	public TeamPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frame.setVisible(true);
	}
	
	/**
	* Closes the team page window.
	*/
	public void closeWindow() {
		frame.dispose();
	}
	
	/**
	 * requests the game environment to close the team page
	 * if isSwapped is set to true, opens team page again instead of game page
	 */
	public void finishedWindow(Boolean isSwapped) {
		environment.closeTeamPage(this, isSwapped);
	}
	
	/**
	 * Sets the swapButtonExecuted flag to indicate that the swap button has been executed.
	 */
	public void setSwapButtonExecuted() {
		this.swapButtonExecuted = true;
	}
	
  /**
   * Helper method to handle the swap button action.
   *
   * @param comboBox   The JComboBox component representing the athlete selection dropdown.
   * @param index      The index of the athlete to swap.
   * @param swapButton The JButton component representing the swap button.
   */
	public void swapButtonHelper(JComboBox<String> comboBox, int index, JButton swapButton) {
		swapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!swapButtonExecuted) {
				environment.getGame().getTeam().setAthlete(comboBox.getSelectedIndex(), index);
				setSwapButtonExecuted();
				finishedWindow(true);
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
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JButton sellButton = new JButton("Sell");
		sellButton.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JButton athlete1Button = new JButton();
		athlete1Button.setFont(new Font("Orbitron", Font.PLAIN, 10));
		JButton athlete2Button = new JButton();
		athlete2Button.setFont(new Font("Orbitron", Font.PLAIN, 10));
		JButton athlete3Button = new JButton();
		athlete3Button.setFont(new Font("Orbitron", Font.PLAIN, 10));
		JButton athlete4Button = new JButton();
		athlete4Button.setFont(new Font("Orbitron", Font.PLAIN, 10));
		JButton athlete5Button = new JButton();
		athlete5Button.setFont(new Font("Orbitron", Font.PLAIN, 10));
		JButton excessAthleteButton = new JButton();
		excessAthleteButton.setFont(new Font("Orbitron", Font.PLAIN, 10));
		
		excessAthleteButton.setForeground(Color.BLACK);
		excessAthleteButton.setBackground(Color.GRAY);
		if (excessAthlete != null) {
			excessAthleteButton.setText(excessAthlete.getFullName());
		}
		
		JButton swapButton = new JButton("Swap");
		swapButton.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel centerLabel = new JLabel("Center");
		centerLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		centerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel smallForwardLabel = new JLabel("Small Forward");
		smallForwardLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		smallForwardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel powerForwardLabel = new JLabel("Power Forward");
		powerForwardLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		powerForwardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel pointGuardLabel = new JLabel("Point Guard");
		pointGuardLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		pointGuardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel shootingGuardLabel = new JLabel("Shooting Guard");
		shootingGuardLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		shootingGuardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel benchLabel = new JLabel("Bench");
		benchLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		benchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pointGuardLabel, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(shootingGuardLabel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(centerLabel, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(smallForwardLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(athlete1Button, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
							.addComponent(athlete2Button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(athlete4Button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(athlete5Button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 0, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(benchLabel, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
						.addComponent(athlete3Button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(excessAthleteButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(powerForwardLabel, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(swapButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(sellButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 185, Short.MAX_VALUE)))
					.addContainerGap())
				.addComponent(titlePanel, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(smallForwardLabel)
							.addComponent(centerLabel))
						.addComponent(powerForwardLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(athlete2Button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(athlete3Button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(athlete1Button, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(pointGuardLabel)
								.addComponent(benchLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(shootingGuardLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(athlete5Button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(athlete4Button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(excessAthleteButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(sellButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(swapButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		JLabel offenceLabel = new JLabel("Offence:");
		offenceLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		JLabel defenceLabel = new JLabel("Defence:");
		defenceLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		JLabel agilityLabel = new JLabel("Agility:");
		agilityLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		JLabel staminaLabel = new JLabel("Stamina:");
		staminaLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		JLabel healthLabel = new JLabel("Health:");
		healthLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		JLabel equippedItemsLabel = new JLabel("Equipped Items: ");
		equippedItemsLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Orbitron", Font.PLAIN, 11));
		JLabel swapLabel = new JLabel("Swap With:");
		swapLabel.setFont(new Font("Orbitron", Font.PLAIN, 10));
		JLabel valueLabel = new JLabel("Sells For:");
		valueLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
			
		
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
					for (Athlete athlete: equippedAthletes) {
						comboBox.addItem(athlete.getFullName());
					}
					if (excessAthlete != null) {
						comboBox.addItem(excessAthlete.getFullName());
					}
					nameLabel.setText(String.format("Name: %s", equippedAthletes.get(0).getFullName()));
					offenceLabel.setText(String.format("Offence: %d", equippedAthletes.get(0).getOffence()));
					defenceLabel.setText(String.format("Defence: %d", equippedAthletes.get(0).getDefence()));
					agilityLabel.setText(String.format("Agility: %d", equippedAthletes.get(0).getAgility()));
					staminaLabel.setText(String.format("Stamina: %d/%d", equippedAthletes.get(0).getStamina(),equippedAthletes.get(0).getMaxStamina()));
					
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
							finishedWindow(true);
						}
					});
					
					swapButtonHelper(comboBox, 0, swapButton);
				}
			});
		}
		
		if (equippedAthletes.size() > 1) {
			athlete2Button.setText(equippedAthletes.get(1).getFullName());
			athlete2Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ArrayList<String> athletesItems = new ArrayList<String>();
					ArrayList<Item> itemList  = environment.getGame().getTeam().getEquippedAthletes().get(1).getEquippedItems();
					String result = itemList.stream()
							.map(n -> n.getName())
							.collect(Collectors.joining(", "));
					equippedItemsLabel.setText(String.format("Items: %s", result));
					
					comboBox.setEnabled(true);
					swapButton.setEnabled(true);
					swapLabel.setEnabled(true);
					for (Athlete athlete: equippedAthletes) {
						comboBox.addItem(athlete.getFullName());
					}
					if (excessAthlete != null) {
						comboBox.addItem(excessAthlete.getFullName());
					}
					nameLabel.setText(String.format("Name: %s", equippedAthletes.get(1).getFullName()));
					offenceLabel.setText(String.format("Offence: %d", equippedAthletes.get(1).getOffence()));
					defenceLabel.setText(String.format("Defence: %d", equippedAthletes.get(1).getDefence()));
					agilityLabel.setText(String.format("Agility: %d", equippedAthletes.get(1).getAgility()));
					staminaLabel.setText(String.format("Stamina: %d/%d", equippedAthletes.get(1).getStamina(),equippedAthletes.get(1).getMaxStamina()));
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
							finishedWindow(true);
						}
					});
					
					swapButtonHelper(comboBox, 1, swapButton);
				}
			});
		}
		
		if (equippedAthletes.size() > 2) {
			athlete3Button.setText(equippedAthletes.get(2).getFullName());
			athlete3Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ArrayList<String> athletesItems = new ArrayList<String>();
					ArrayList<Item> itemList  = environment.getGame().getTeam().getEquippedAthletes().get(2).getEquippedItems();
					String result = itemList.stream()
							.map(n -> n.getName())
							.collect(Collectors.joining(", "));
					equippedItemsLabel.setText(String.format("Items: %s", result));
					
					comboBox.setEnabled(true);
					swapButton.setEnabled(true);
					swapLabel.setEnabled(true);
					for (Athlete athlete: equippedAthletes) {
						comboBox.addItem(athlete.getFullName());
					}
					if (excessAthlete != null) {
						comboBox.addItem(excessAthlete.getFullName());
					}
					nameLabel.setText(String.format("Name: %s", equippedAthletes.get(2).getFullName()));
					offenceLabel.setText(String.format("Offence: %d", equippedAthletes.get(2).getOffence()));
					defenceLabel.setText(String.format("Defence: %d", equippedAthletes.get(2).getDefence()));
					agilityLabel.setText(String.format("Agility: %d", equippedAthletes.get(2).getAgility()));
					staminaLabel.setText(String.format("Stamina: %d/%d", equippedAthletes.get(2).getStamina(),equippedAthletes.get(2).getMaxStamina()));
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
							finishedWindow(true);
						}
					});
					
					swapButtonHelper(comboBox, 2, swapButton);
				}
			});	
		}	
		
		if (equippedAthletes.size() > 3) {
			athlete4Button.setText(equippedAthletes.get(3).getFullName());
			athlete4Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ArrayList<String> athletesItems = new ArrayList<String>();
					ArrayList<Item> itemList  = environment.getGame().getTeam().getEquippedAthletes().get(3).getEquippedItems();
					String result = itemList.stream()
							.map(n -> n.getName())
							.collect(Collectors.joining(", "));
					equippedItemsLabel.setText(String.format("Items: %s", result));
					
					comboBox.setEnabled(true);
					swapButton.setEnabled(true);
					swapLabel.setEnabled(true);
					for (Athlete athlete: equippedAthletes) {
						comboBox.addItem(athlete.getFullName());
					}
					if (excessAthlete != null) {
						comboBox.addItem(excessAthlete.getFullName());
					}
					nameLabel.setText(String.format("Name: %s", equippedAthletes.get(3).getFullName()));
					offenceLabel.setText(String.format("Offence: %d", equippedAthletes.get(3).getOffence()));
					defenceLabel.setText(String.format("Defence: %d", equippedAthletes.get(3).getDefence()));
					agilityLabel.setText(String.format("Agility: %d", equippedAthletes.get(3).getAgility()));
					staminaLabel.setText(String.format("Stamina: %d/%d", equippedAthletes.get(3).getStamina(),equippedAthletes.get(3).getMaxStamina()));
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
							finishedWindow(true);
						}
					});
					
					swapButtonHelper(comboBox, 3, swapButton);
				}
			});
			
		}
		
		if (equippedAthletes.size() > 4) {
			athlete5Button.setText(equippedAthletes.get(4).getFullName());
			athlete5Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ArrayList<String> athletesItems = new ArrayList<String>();
					ArrayList<Item> itemList  = environment.getGame().getTeam().getEquippedAthletes().get(4).getEquippedItems();
					String result = itemList.stream()
							.map(n -> n.getName())
							.collect(Collectors.joining(", "));
					equippedItemsLabel.setText(String.format("Items: %s", result));
					
					comboBox.setEnabled(true);
					swapButton.setEnabled(true);
					swapLabel.setEnabled(true);
					for (Athlete athlete: equippedAthletes) {
						comboBox.addItem(athlete.getFullName());
					}
					if (excessAthlete != null) {
						comboBox.addItem(excessAthlete.getFullName());
					}
					nameLabel.setText(String.format("Name: %s", equippedAthletes.get(4).getFullName()));
					offenceLabel.setText(String.format("Offence: %d", equippedAthletes.get(4).getOffence()));
					defenceLabel.setText(String.format("Defence: %d", equippedAthletes.get(4).getDefence()));
					agilityLabel.setText(String.format("Agility: %d", equippedAthletes.get(4).getAgility()));
					staminaLabel.setText(String.format("Stamina: %d/%d", equippedAthletes.get(4).getStamina(),equippedAthletes.get(4).getMaxStamina()));
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
							finishedWindow(true);
						}
					});
					
					swapButtonHelper(comboBox, 4, swapButton);
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
					for (Athlete athlete: equippedAthletes) {
						comboBox.addItem(athlete.getFullName());
					}
					if (excessAthlete != null) {
						comboBox.addItem(excessAthlete.getFullName());
					}
					
					swapButtonHelper(comboBox, 5, swapButton);
					sellButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							environment.getGame().getBank().alterMoney(excessAthlete.getValue()/2);
							environment.getGame().getTeam().removeExcessAthlete();
							finishedWindow(true);
						}
					});
					
				}
			});
		};
		
		
		JLabel ifdeleteeverythingbreaks = new JLabel("");
								
		
		GroupLayout gl_infoPanel = new GroupLayout(infoPanel);
		gl_infoPanel.setHorizontalGroup(
			gl_infoPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addContainerGap(191, Short.MAX_VALUE)
					.addComponent(ifdeleteeverythingbreaks)
					.addContainerGap())
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addGap(8)
					.addComponent(swapLabel)
					.addGap(6)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addGroup(gl_infoPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_infoPanel.createSequentialGroup()
							.addGap(9)
							.addComponent(staminaLabel, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_infoPanel.createSequentialGroup()
							.addGap(9)
							.addComponent(agilityLabel, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_infoPanel.createSequentialGroup()
							.addGap(9)
							.addComponent(defenceLabel, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_infoPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(offenceLabel, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_infoPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_infoPanel.createSequentialGroup()
							.addGap(8)
							.addComponent(equippedItemsLabel, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_infoPanel.createSequentialGroup()
					.addGap(8)
					.addComponent(healthLabel, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_infoPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(valueLabel, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addContainerGap())
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
							.addGap(5)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_infoPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(swapLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(valueLabel)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		infoPanel.setLayout(gl_infoPanel);
		
		JButton backButton = new JButton("<");
		backButton.setFont(new Font("SimSun", Font.BOLD, 12));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(false);
			}
		});
		
		JLabel teamNameLabel = new JLabel(environment.getGame().getTeam().getTeamName());
		teamNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamNameLabel.setFont(new Font("Orbitron", Font.BOLD, 26));
		GroupLayout gl_titlePanel = new GroupLayout(titlePanel);
		gl_titlePanel.setHorizontalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addGroup(gl_titlePanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(backButton)
						.addGroup(gl_titlePanel.createSequentialGroup()
							.addContainerGap(10, Short.MAX_VALUE)
							.addComponent(teamNameLabel, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_titlePanel.setVerticalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addComponent(backButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(teamNameLabel)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		titlePanel.setLayout(gl_titlePanel);
		frame.getContentPane().setLayout(groupLayout);
	}
}