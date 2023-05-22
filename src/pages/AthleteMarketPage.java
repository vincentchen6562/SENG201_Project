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
/**
 * The AthleteMarketPage class represents the user interface for the athlete market in the game.
 * It allows the user to view and purchase athletes from the market.
 */
public class AthleteMarketPage {

	private JFrame frmMarket;
	private GameEnvironment environment;

  /**
   * Creates a new instance of AthleteMarketPage.
   *
   * @param incomingEnvironment the GameEnvironment object representing the game environment
   */
	public AthleteMarketPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frmMarket.setVisible(true);
	}
	
	/**
	 * Closes the market window.
	 */
	public void closeWindow() {
		frmMarket.dispose();
	}
	
	/**
   * closes the athlete market page through Game Environment
   */
	public void finishedWindow() {
		environment.closeAthleteMarketPage(this);
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
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Athlete Market!");
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
				.addComponent(lblWelcomeToThe, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
		);
		titlePanel.setLayout(gl_titlePanel);
		
		
		ArrayList<String> athletesNames = new ArrayList<String>();
		ArrayList<ArrayList<Integer>> athletesStats = new ArrayList<ArrayList<Integer>>();
		ArrayList<String> athletesCosts = new ArrayList<String>();
		
		ArrayList<Athlete> athletes = new Market().getAthletes(environment);
		for (int i = 0; i < athletes.size(); i++)
		{
			athletesNames.add(athletes.get(i).getFullName());
			ArrayList<Integer> statList = athletes.get(i).getStatList();
			statList.add(athletes.get(i).getStamina());
			athletesStats.add(statList);
			athletesCosts.add(String.valueOf(athletes.get(i).getValue()));
		}

		
		JPanel InfoPanel = new JPanel();
		
		JButton athlete1Button = new JButton(athletesNames.get(0));

		JButton athlete2Button = new JButton(athletesNames.get(1));
		
		JButton athlete3Button = new JButton(athletesNames.get(2));
		
		JButton athlete4Button = new JButton(athletesNames.get(3));
		
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
							.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(athlete3Button, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addComponent(athlete1Button, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(athlete2Button, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
								.addComponent(athlete4Button, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
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
		JLabel offenceLabel = new JLabel("Offence:");
		JLabel defenceLabel = new JLabel("Defence:");
		JLabel agilityLabel = new JLabel("Agility:");
		JLabel staminaLabel = new JLabel("Stamina:");
		JLabel costLabel = new JLabel("Cost:");
		
		athlete1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameLabel.setText(String.format("Name: %s", athletesNames.get(0)));
				offenceLabel.setText(String.format("Offence: %s", athletesStats.get(0).get(0)));
				defenceLabel.setText(String.format("Defence: %s", athletesStats.get(0).get(1)));
				agilityLabel.setText(String.format("Agility: %s", athletesStats.get(0).get(2)));
				staminaLabel.setText(String.format("Stamina: %s", athletesStats.get(0).get(3)));	
				costLabel.setText(String.format("Cost: %s", athletesCosts.get(0)));
				
				buyButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (environment.getGame().getBank().getMoney() >= athletes.get(0).getValue()) {
							environment.getGame().getTeam().addAthlete(athletes.get(0));
							environment.getGame().getBank().alterMoney(-athletes.get(0).getValue());
						}
					}
				});
			}
		});
		
		athlete2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameLabel.setText(String.format("Name: %s", athletesNames.get(1)));
				offenceLabel.setText(String.format("Offence: %s", athletesStats.get(1).get(0)));
				defenceLabel.setText(String.format("Defence: %s", athletesStats.get(1).get(1)));
				agilityLabel.setText(String.format("Agility: %s", athletesStats.get(1).get(2)));
				staminaLabel.setText(String.format("Stamina: %s", athletesStats.get(1).get(3)));	
				costLabel.setText(String.format("Cost: %s", athletesCosts.get(1)));
				
				buyButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						environment.getGame().getTeam().addAthlete(athletes.get(1));
					}
				});
			}
		});
		
		athlete3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameLabel.setText(String.format("Name: %s", athletesNames.get(2)));
				offenceLabel.setText(String.format("Offence: %s", athletesStats.get(2).get(0)));
				defenceLabel.setText(String.format("Defence: %s", athletesStats.get(2).get(1)));
				agilityLabel.setText(String.format("Agility: %s", athletesStats.get(2).get(2)));
				staminaLabel.setText(String.format("Stamina: %s", athletesStats.get(2).get(3)));	
				costLabel.setText(String.format("Cost: %s", athletesCosts.get(2)));
				
				buyButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						environment.getGame().getTeam().addAthlete(athletes.get(2));
					}
				});
			}
		});
		
		athlete4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameLabel.setText(String.format("Name: %s", athletesNames.get(3)));
				offenceLabel.setText(String.format("Offence: %s", athletesStats.get(3).get(0)));
				defenceLabel.setText(String.format("Defence: %s", athletesStats.get(3).get(1)));
				agilityLabel.setText(String.format("Agility: %s", athletesStats.get(3).get(2)));
				staminaLabel.setText(String.format("Stamina: %s", athletesStats.get(3).get(3)));	
				costLabel.setText(String.format("Cost: %s", athletesCosts.get(3)));
				
				buyButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						environment.getGame().getTeam().addAthlete(athletes.get(3));
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
						.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
						.addComponent(offenceLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(defenceLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(agilityLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(staminaLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(costLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_InfoPanel.setVerticalGroup(
			gl_InfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InfoPanel.createSequentialGroup()
					.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(offenceLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(defenceLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(agilityLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(staminaLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(costLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
		);
		InfoPanel.setLayout(gl_InfoPanel);
		frmMarket.getContentPane().setLayout(groupLayout);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		
	
		
	}

  /**
   * Returns the frame associated with this AthleteMarketPage.
   *
   * @return the JFrame object representing the market frame
   */
	public JFrame getFrame() {
		return frmMarket;
	}
}