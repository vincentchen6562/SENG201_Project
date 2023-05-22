package src.pages;

import java.awt.EventQueue;
import src.*;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The MarketChoicePage class represents a page that allows the user
 * to choose between the item market and athlete market. It provides buttons to navigate to the
 * respective markets and displays the user's current stats, such as money, week, and points.
 */
public class MarketChoicePage {

	private JFrame frame;
	private GameEnvironment environment;

    /**
     * Constructs a new instance of MarketChoicePage.
     *
     * @param incomingEnvironment the GameEnvironment object representing the game environment
     */
	public MarketChoicePage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frame.setVisible(true);
	}
	
	/**
     * Closes the window of the market choice page.
     */
	public void closeWindow() {
		frame.dispose();
	}
	
	/**
     * Launches the item market page.
     */
	public void intoItemMarket() {
		environment.launchItemMarketPage();
	}
	
	/**
     * Launches the athlete market page.
     */
	public void intoAthleteMarket() {
		environment.launchAthleteMarketPage();
	}
	
	/**
 	* Close this instance of MarketChoicePage through Game Environment
	*/
	public void finishedWindow() {
		environment.closeMarketChoicePage(this);
	}

    /**
     * Initializes the contents of the frame and sets up the GUI components.
     */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton itemButton = new JButton("Item Market");
		itemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launchItemMarketPage();
			}
		});
		
		JButton athleteButton = new JButton("Athlete Market");
		athleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launchAthleteMarketPage();
			}
		});
		
		
		
		JButton backButton = new JButton("<");
		backButton.setFont(new Font("SimSun", Font.BOLD, 12));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		
		JPanel titlePanel = new JPanel();
		GroupLayout gl_titlePanel = new GroupLayout(titlePanel);
		gl_titlePanel.setHorizontalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 204, Short.MAX_VALUE)
		);
		gl_titlePanel.setVerticalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 26, Short.MAX_VALUE)
		);
		titlePanel.setLayout(gl_titlePanel);
		
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
					.addGap(2)
					.addComponent(moneyLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_statPanel.setVerticalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(moneyLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		);
		statPanel.setLayout(gl_statPanel);
		
		JLabel welcomeLabel = new JLabel("Welcome to the Market!");
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(welcomeLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addComponent(itemButton, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(137)
							.addComponent(athleteButton, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(backButton)
								.addComponent(welcomeLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
						.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(athleteButton, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addComponent(itemButton, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
