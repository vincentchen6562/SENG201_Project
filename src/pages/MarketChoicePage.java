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

public class MarketChoicePage {

	private JFrame frame;
	private GameEnvironment environment;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MarketChoicePage window = new MarketChoicePage();
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
	public MarketChoicePage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void intoItemMarket() {
		environment.launchItemMarketPage();
	}
	
	public void intoAthleteMarket() {
		environment.launchAthleteMarketPage();
	}
	
	public void finishedWindow() {
		environment.closeMarketChoicePage(this);
	}

	/**
	 * Initialize the contents of the frame.
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
