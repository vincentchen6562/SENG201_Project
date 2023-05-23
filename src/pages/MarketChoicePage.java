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
		frame.setBounds(100, 100, 455, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton itemButton = new JButton("Item Market");
		itemButton.setFont(new Font("Orbitron", Font.PLAIN, 12));
		itemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchItemMarketPage();
			}
		});
		
		JButton athleteButton = new JButton("Athlete Market");
		athleteButton.setFont(new Font("Orbitron", Font.PLAIN, 12));
		athleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchAthleteMarketPage();
			}
		});
		
		
		
		JButton backButton = new JButton("<");
		backButton.setFont(new Font("Orbitron", Font.BOLD, 12));
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
		
		JLabel welcomeLabel = new JLabel("Welcome to the Market!");
		welcomeLabel.setFont(new Font("Orbitron", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(itemButton, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(athleteButton, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(welcomeLabel, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)))
					.addGap(59)
					.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(welcomeLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))))
					.addGap(14, 14, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(itemButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(athleteButton, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
