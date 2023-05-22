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

public class ItemMarketPage {

	private JFrame frmMarket;
	private GameEnvironment environment;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ItemMarketPage window = new ItemMarketPage();
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
	public ItemMarketPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frmMarket.setVisible(true);
	}
	
	public void closeWindow() {
		frmMarket.dispose();
	}
	
	public void finishedWindow() {
		environment.closeItemMarketPage(this);
	}
	
	private void buyItem() {
		
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
		backButton.setFont(new Font("SimSun", Font.BOLD, 12));
		
		JPanel statPanel = new JPanel();
		statPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		
		JLabel moneyLabel = new JLabel(String.format("Money: %d", environment.getGame().getBank().getMoney()));
		moneyLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel weekLabel = new JLabel(String.format("Week: %d",environment.getGame().getWeek()));
		weekLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel pointsLabel = new JLabel(String.format("Points: %d", environment.getGame().getPoints()));
		pointsLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		GroupLayout gl_statPanel = new GroupLayout(statPanel);
		gl_statPanel.setHorizontalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statPanel.createSequentialGroup()
					.addComponent(moneyLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		gl_statPanel.setVerticalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(moneyLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		);
		statPanel.setLayout(gl_statPanel);
		
		JPanel titlePanel = new JPanel();
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Item Market!");
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_titlePanel = new GroupLayout(titlePanel);
		gl_titlePanel.setHorizontalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcomeToThe, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_titlePanel.setVerticalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblWelcomeToThe, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
		);
		titlePanel.setLayout(gl_titlePanel);
		
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

		JButton item2Button = new JButton(itemNames.get(1));
		
		JButton item3Button = new JButton(itemNames.get(2));
		
		JButton item4Button = new JButton(itemNames.get(3));
		
		JButton buyButton = new JButton("Buy");

		GroupLayout groupLayout = new GroupLayout(frmMarket.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(backButton)
							.addGap(49)
							.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(item3Button, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
								.addComponent(item1Button, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(item2Button, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addComponent(item4Button, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
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
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(3)
								.addComponent(backButton)))
						.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
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
		JLabel typeLabel = new JLabel("Type: ");
		JLabel costLabel = new JLabel("Cost:");
		JLabel boostLabel = new JLabel("Boost: +2 atk, etc.");
		JLabel lblNewLabel = new JLabel("Equip To:");
		
		buyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				finishedWindow();	
			}
		});
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
				comboBox.setEnabled(true);
				buyButton.setEnabled(true);
				nameLabel.setText(String.format("Name: %s", itemNames.get(0)));
				typeLabel.setText(String.format("Type: %s", itemTypes.get(0)));
				costLabel.setText(String.format("Cost: %d", itemCosts.get(0)));
				boostLabel.setText(String.format("Boost: +%d %s", itemBoosts.get(0), itemBoostTypes.get(0)));
				
				buyButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (items.get(0).getIsCoach() && (environment.getGame().getBank().getMoney() >= items.get(0).getCost())) {
							environment.getGame().setCoach(items.get(0));
							comboBox.setEnabled(false);
							warningLabel.setText("test");
						} else if (environment.getGame().getBank().getMoney() >= items.get(0).getCost()) {
							int athleteIndex = comboBox.getSelectedIndex();
							environment.getGame().getBank().alterMoney(-itemCosts.get(0));
							environment.getGame().getTeam().getEquippedAthletes().get(athleteIndex).equipItem(items.get(0));	
						} else {
							warningLabel.setText("Not Enough Money!");
						}
					}
				});
			}
		});

		item2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setEnabled(true);
				buyButton.setEnabled(true);
				nameLabel.setText(String.format("Name: %s", itemNames.get(1)));
				typeLabel.setText(String.format("Type: %s", itemTypes.get(1)));
				costLabel.setText(String.format("Cost: %d", itemCosts.get(1)));
				boostLabel.setText(String.format("Boost: +%d %s", itemBoosts.get(1), itemBoostTypes.get(1)));
				
				buyButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (items.get(1).getIsCoach() && (environment.getGame().getBank().getMoney() >= items.get(1).getCost())) {
							environment.getGame().setCoach(items.get(1));
							comboBox.setEnabled(false);
							warningLabel.setText("test");
						} else if (environment.getGame().getBank().getMoney() >= items.get(1).getCost()) {
							int athleteIndex = comboBox.getSelectedIndex();
							environment.getGame().getBank().alterMoney(-itemCosts.get(1));
							environment.getGame().getTeam().getEquippedAthletes().get(athleteIndex).equipItem(items.get(1));	
						} else {
							warningLabel.setText("Not Enough Money!");
						}
					}
				});
			}
		});
		
		item3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setEnabled(true);
				buyButton.setEnabled(true);
				nameLabel.setText(String.format("Name: %s", itemNames.get(2)));
				typeLabel.setText(String.format("Type: %s", itemTypes.get(2)));
				costLabel.setText(String.format("Cost: %d", itemCosts.get(2)));
				boostLabel.setText(String.format("Boost: +%d %s", itemBoosts.get(2), itemBoostTypes.get(2)));
				
				buyButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (items.get(2).getIsCoach() && (environment.getGame().getBank().getMoney() >= items.get(2).getCost())) {
							environment.getGame().setCoach(items.get(2));
							comboBox.setEnabled(false);
							warningLabel.setText("test");
						} else if (environment.getGame().getBank().getMoney() >= items.get(2).getCost()) {
							int athleteIndex = comboBox.getSelectedIndex();
							environment.getGame().getBank().alterMoney(-itemCosts.get(2));
							environment.getGame().getTeam().getEquippedAthletes().get(athleteIndex).equipItem(items.get(2));	
						} else {
							warningLabel.setText("Not Enough Money!");
						}
					}
				});
			}
		});
		
		item4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setEnabled(true);
				buyButton.setEnabled(true);
				nameLabel.setText(String.format("Name: %s", itemNames.get(3)));
				typeLabel.setText(String.format("Type: %s", itemTypes.get(3)));
				costLabel.setText(String.format("Cost: %d", itemCosts.get(3)));
				boostLabel.setText(String.format("Boost: +%d %s", itemBoosts.get(3), itemBoostTypes.get(3)));
				buyButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (items.get(3).getIsCoach() && (environment.getGame().getBank().getMoney() >= items.get(3).getCost())) {
							environment.getGame().setCoach(items.get(3));
							comboBox.setEnabled(false);
							warningLabel.setText("test");
						} else if (environment.getGame().getBank().getMoney() >= items.get(3).getCost()) {
							int athleteIndex = comboBox.getSelectedIndex();
							environment.getGame().getBank().alterMoney(-itemCosts.get(3));
							environment.getGame().getTeam().getEquippedAthletes().get(athleteIndex).equipItem(items.get(3));	
						} else {
							warningLabel.setText("Not Enough Money!");
						}
					}
				});
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
						.addGroup(gl_InfoPanel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(14)
							.addComponent(comboBox, 0, 126, Short.MAX_VALUE))
						.addComponent(warningLabel))
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
					.addGroup(gl_InfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(warningLabel)
					.addContainerGap(115, Short.MAX_VALUE))
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
