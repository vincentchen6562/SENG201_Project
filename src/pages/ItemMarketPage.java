package src.pages;
import src.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
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
		
		JLabel moneyLabel = new JLabel("Money: ");
		moneyLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel weekLabel = new JLabel("Week:");
		weekLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel pointsLabel = new JLabel("Points:");
		pointsLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel statsTotalLabel = new JLabel("StatTotal:");
		statsTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout gl_statPanel = new GroupLayout(statPanel);
		gl_statPanel.setHorizontalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 215, Short.MAX_VALUE)
				.addGroup(gl_statPanel.createSequentialGroup()
					.addComponent(moneyLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(statsTotalLabel, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
					.addGap(8))
		);
		gl_statPanel.setVerticalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 26, Short.MAX_VALUE)
				.addGroup(gl_statPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(moneyLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addComponent(statsTotalLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
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
		
		

		
		JPanel InfoPanel = new JPanel();
		
		JButton athlete1Button = new JButton();

		JButton athlete2Button = new JButton();
		
		JButton athlete3Button = new JButton();
		
		JButton athlete4Button = new JButton();
		
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
								.addComponent(athlete3Button, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
								.addComponent(athlete1Button, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(athlete2Button, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addComponent(athlete4Button, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
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
								.addComponent(athlete2Button, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(athlete1Button, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(athlete4Button, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(athlete3Button, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))))
					.addContainerGap())
		);
		
		JLabel nameLabel = new JLabel("Name:");
		JLabel typeLabel = new JLabel("Type: (coach/item)");
		JLabel costLabel = new JLabel("Cost:");
		int athleteToBuy = 10;
		
//		athlete1Button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				nameLabel.setText(String.format("Name: %s"));
//				typeLabel.setText(String.format("Offence: %s"));
//				defenceLabel.setText(String.format("Defence: %s", athletesStats.get(0).get(1)));
//				agilityLabel.setText(String.format("Agility: %s", athletesStats.get(0).get(2)));
//				staminaLabel.setText(String.format("Stamina: %s", athletesStats.get(0).get(3)));	
//				costLabel.setText(String.format("Cost: %s", athletesCosts.get(0)));
//				int athleteToBuy = 0;
//			}
//		});
//		
//		athlete2Button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				nameLabel.setText(String.format("Name: %s", athletesNames.get(1)));
//				typeLabel.setText(String.format("Offence: %s", athletesStats.get(1).get(0)));
//				defenceLabel.setText(String.format("Defence: %s", athletesStats.get(1).get(1)));
//				agilityLabel.setText(String.format("Agility: %s", athletesStats.get(1).get(2)));
//				staminaLabel.setText(String.format("Stamina: %s", athletesStats.get(1).get(3)));	
//				costLabel.setText(String.format("Cost: %s", athletesCosts.get(1)));
//				int athleteToBuy = 1;
//			}
//		});
		
//		athlete3Button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				nameLabel.setText(String.format("Name: %s", athletesNames.get(2)));
//				typeLabel.setText(String.format("Offence: %s", athletesStats.get(2).get(0)));
//				defenceLabel.setText(String.format("Defence: %s", athletesStats.get(2).get(1)));
//				agilityLabel.setText(String.format("Agility: %s", athletesStats.get(2).get(2)));
//				staminaLabel.setText(String.format("Stamina: %s", athletesStats.get(2).get(3)));	
//				costLabel.setText(String.format("Cost: %s", athletesCosts.get(2)));
//				int athleteToBuy = 2;
//			}
//		});
//		
//		athlete4Button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				nameLabel.setText(String.format("Name: %s", athletesNames.get(3)));
//				typeLabel.setText(String.format("Offence: %s", athletesStats.get(3).get(0)));
//				defenceLabel.setText(String.format("Defence: %s", athletesStats.get(3).get(1)));
//				agilityLabel.setText(String.format("Agility: %s", athletesStats.get(3).get(2)));
//				staminaLabel.setText(String.format("Stamina: %s", athletesStats.get(3).get(3)));	
//				costLabel.setText(String.format("Cost: %s", athletesCosts.get(3)));
//				int athleteToBuy = 3;
//			}
//		});
		
		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (athleteToBuy > 5) {
					//Team.addAthlete(athletes.get(athleteToBuy)); TODO add universal team
				}
			}
		});
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Athlete");
		
		JLabel boostLabel = new JLabel("Boost: +2 atk, etc.");
		
		JLabel lblNewLabel = new JLabel("Equip To:");
		

		

		
		
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
							.addComponent(comboBox, 0, 125, Short.MAX_VALUE)))
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
					.addContainerGap(138, Short.MAX_VALUE))
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
