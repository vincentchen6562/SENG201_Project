package src.pages;
import src.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.miginfocom.swing.MigLayout;

import java.awt.Font;
import javax.swing.*;
import src.team.*;
import src.items.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
/**
 * The ItemMarketPage class represents the user interface for the item market.
 * It displays four items to the player, and provides them with the ability to buy and equip them to specified athletes in their team.
 * The class also provides information about the selected item in the market, including: name, type, boost, and cost
 * Money, week, and points are also displayed
 */
public class ItemMarketPage {

	private JFrame frmMarket;
	private GameEnvironment environment;

	/**
	 * Creates a new instance of the ItemMarketPageClass
	 * 
	 * @param incomingEnvironment the GameEnvironment object representing the game environment
	 */
	public ItemMarketPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frmMarket.setVisible(true);
	}
	
	/**
	* Closes the item market page window.
	*/
	public void closeWindow() {
		frmMarket.dispose();
	}

	/**
 	* Close this instance of ItemMarketPage through Game Environment
	*/
	public void finishedWindow() {
		environment.closeItemMarketPage(this);
	}
	
	/**
	 * Helper function to handle the buy button action.
	 * @param buyButton 	The JButton componenent responsible for triggering the buy action
	 * @param items 		The ArrayList of items displayed in the shop
	 * @param comboBox		The JComboBox from which the athlete to equip to can be selected
	 * @param warningLabel	The JLabel that displays a warning if insufficient funds are available
	 * @param index			The integer that represents the index of the item being bought
	 */
	public void buyHelper(JButton buyButton, ArrayList<Item> items, 
			JComboBox<String> comboBox, JLabel warningLabel, Integer index) {
		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (items.get(index).getIsCoach() && (environment.getGame().getBank().getMoney() >= items.get(index).getCost())) {
					environment.getGame().getBank().alterMoney(-items.get(index).getCost());
					environment.getGame().setCoach(items.get(index));
					comboBox.setEnabled(false);
					
				} else if (environment.getGame().getBank().getMoney() >= items.get(index).getCost()) {
					int athleteIndex = comboBox.getSelectedIndex();
					environment.getGame().getBank().alterMoney(-items.get(index).getCost());
					environment.getGame().getTeam().getEquippedAthletes().get(athleteIndex).equipItem(items.get(index));	
				} else {
					warningLabel.setText("Not Enough Money!");
				}
			}
		});
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMarket = new JFrame();
		frmMarket.setTitle("Market");
		getFrame().setBounds(100, 100, 600, 400);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton backButton = new JButton("<");
		backButton.setFont(new Font("Orbitron", Font.BOLD, 12));
		
		JPanel statPanel = new JPanel();
		
		JLabel moneyLabel = new JLabel(String.format("Money: $%d", environment.getGame().getBank().getMoney()));
		moneyLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		GroupLayout gl_statPanel = new GroupLayout(statPanel);
		gl_statPanel.setHorizontalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statPanel.createSequentialGroup()
					.addComponent(moneyLabel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		gl_statPanel.setVerticalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(moneyLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
		);
		statPanel.setLayout(gl_statPanel);
		
		ArrayList<String> itemNames = new ArrayList<String>();
		ArrayList<String> itemTypes = new ArrayList<String>();
		ArrayList<Integer> itemBoosts = new ArrayList<Integer>();
		ArrayList<String> itemBoostTypes = new ArrayList<String>();
		ArrayList<Integer> itemCosts = new ArrayList<Integer>();
		
		ArrayList<Item> items = new Market().getItems();
		for (int i = 0; i < items.size(); i ++) {
			Item item = items.get(i);
			itemNames.add(item.getName());
			itemTypes.add(item.getType());
			itemBoosts.add(item.getBoost());
			itemBoostTypes.add(item.getBoostType());
			itemCosts.add(item.getCost());
		}
		
		
		JPanel InfoPanel = new JPanel();
		
		JButton item1Button = new JButton(itemNames.get(0));
		item1Button.setFont(new Font("Orbitron", Font.PLAIN, 12));

		JButton item2Button = new JButton(itemNames.get(1));
		item2Button.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JButton item3Button = new JButton(itemNames.get(2));
		item3Button.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JButton item4Button = new JButton(itemNames.get(3));
		item4Button.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JButton buyButton = new JButton("Buy");
		buyButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				moneyLabel.setText(String.format("Money: $%d", environment.getGame().getBank().getMoney()));
			}
		});
		buyButton.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Item Market!");
		lblWelcomeToThe.setFont(new Font("Orbitron", Font.PLAIN, 14));

		GroupLayout groupLayout = new GroupLayout(frmMarket.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(backButton)
							.addGap(35)
							.addComponent(lblWelcomeToThe, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(item3Button, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addComponent(item1Button, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(item2Button, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
								.addComponent(item4Button, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
							.addGap(4)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(buyButton, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(InfoPanel, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
							.addContainerGap())
						.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(backButton)
								.addComponent(lblWelcomeToThe, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(InfoPanel, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buyButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(item2Button, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(item1Button, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(item4Button, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(item3Button, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))))
					.addContainerGap())
		);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		JLabel typeLabel = new JLabel("Type: ");
		typeLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		JLabel costLabel = new JLabel("Cost:");
		costLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		JLabel boostLabel = new JLabel("Boost: +2 atk, etc.");
		boostLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		JLabel lblNewLabel = new JLabel("Equip To:");
		lblNewLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		ArrayList<Athlete> equippedAthletes = environment
				.getGame().getTeam().getEquippedAthletes();
		
		Athlete excessAthlete = environment
				.getGame().getTeam().getExcessAthlete();
		
		JLabel warningLabel = new JLabel("");

				
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem(equippedAthletes.get(0).getFullName());
		comboBox.addItem(equippedAthletes.get(1).getFullName());
		comboBox.addItem(equippedAthletes.get(2).getFullName());
		comboBox.addItem(equippedAthletes.get(3).getFullName());
		comboBox.addItem(equippedAthletes.get(4).getFullName());
		if (excessAthlete != null) {
			comboBox.addItem(excessAthlete.getFullName());
		}
		comboBox.setEnabled(false);
		buyButton.setEnabled(false);
		
		item1Button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				
				comboBox.setEnabled(!items.get(0).getIsCoach());
				buyButton.setEnabled(true);
				nameLabel.setText(String.format("Name: %s", itemNames.get(0)));
				typeLabel.setText(String.format("Type: %s", itemTypes.get(0)));
				costLabel.setText(String.format("Cost: %d", itemCosts.get(0)));
				boostLabel.setText(String.format("Boost: +%d %s", itemBoosts.get(0), itemBoostTypes.get(0)));
				buyHelper(buyButton, items, comboBox, warningLabel, 0);
				

			}
		});

		item2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setEnabled(!items.get(1).getIsCoach());
				buyButton.setEnabled(true);
				nameLabel.setText(String.format("Name: %s", itemNames.get(1)));
				typeLabel.setText(String.format("Type: %s", itemTypes.get(1)));
				costLabel.setText(String.format("Cost: %d", itemCosts.get(1)));
				boostLabel.setText(String.format("Boost: +%d %s", itemBoosts.get(1), itemBoostTypes.get(1)));
				
				buyHelper(buyButton, items, comboBox, warningLabel, 1);

			}
		});
		
		item3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setEnabled(!items.get(2).getIsCoach());
				buyButton.setEnabled(true);
				nameLabel.setText(String.format("Name: %s", itemNames.get(2)));
				typeLabel.setText(String.format("Type: %s", itemTypes.get(2)));
				costLabel.setText(String.format("Cost: %d", itemCosts.get(2)));
				boostLabel.setText(String.format("Boost: +%d %s", itemBoosts.get(2), itemBoostTypes.get(2)));
				
				buyHelper(buyButton, items, comboBox, warningLabel, 2);

			}
		});
		
		item4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setEnabled(!items.get(3).getIsCoach());
				buyButton.setEnabled(true);
				nameLabel.setText(String.format("Name: %s", itemNames.get(3)));
				typeLabel.setText(String.format("Type: %s", itemTypes.get(3)));
				costLabel.setText(String.format("Cost: %d", itemCosts.get(3)));
				boostLabel.setText(String.format("Boost: +%d %s", itemBoosts.get(3), itemBoostTypes.get(3)));
				
				buyHelper(buyButton, items, comboBox, warningLabel, 3);

			}
		});
		
		

		
		GroupLayout gl_InfoPanel = new GroupLayout(InfoPanel);
		gl_InfoPanel.setHorizontalGroup(
			gl_InfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InfoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_InfoPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
						.addComponent(typeLabel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addComponent(boostLabel)
						.addComponent(costLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addGroup(gl_InfoPanel.createSequentialGroup()
							.addComponent(warningLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, 0, 117, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_InfoPanel.setVerticalGroup(
			gl_InfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InfoPanel.createSequentialGroup()
					.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(typeLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(boostLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(costLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_InfoPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(warningLabel)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(123, Short.MAX_VALUE))
		);
		InfoPanel.setLayout(gl_InfoPanel);
		frmMarket.getContentPane().setLayout(groupLayout);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
	}
	
	public JFrame getFrame() {
		return frmMarket;
	}
}
