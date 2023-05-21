package src.pages;

import java.awt.EventQueue;
import src.items.*;
import src.*;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.Font;

public class GamePage {

	private JFrame frmMainPage;
	private GameEnvironment environment;	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
////		int week = Game.getWeek();
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GamePage window = new GamePage();
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
	public GamePage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frmMainPage.setVisible(true);
	}
	
	public void closeWindow() {
		frmMainPage.dispose();
	}
	
	public void intoMarket() {
		environment.launchMarketChoicePage();
	}
	
	public void intoRest() {
		environment.launchRestPage();
	}
	
	public void intoStadium() {
		environment.launchStadiumPage();
	}
	
	public void intoTeam() {
		environment.launchTeamPage();
	}
	
	public void finishedWindow() {
		environment.closeGamePage(this);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainPage = new JFrame();
		frmMainPage.setTitle("Home");
		frmMainPage.setBounds(100, 100, 600, 400);
		frmMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JLabel moneyLabel = new JLabel(String.format("Money: %d", environment.getGame().getBank().getMoney()));
		
		
		JLabel weekLabel = new JLabel(String.format("Week: %d",environment.getGame().getWeek()));
		
		JButton marketButton = new JButton("Market");
		marketButton.setFont(new Font("Orbitron", Font.PLAIN, 12));
		marketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				intoMarket();
			}
		});
		
		JButton teamButton = new JButton("Team");
		teamButton.setFont(new Font("Orbitron", Font.PLAIN, 12));
		teamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				intoTeam();
			}
		});

		JButton stadiumButton = new JButton("Stadium");
		stadiumButton.setFont(new Font("Orbitron", Font.PLAIN, 12));
		stadiumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				intoStadium();
			}
		});
		
		
		JButton restButton = new JButton("Rest");
		restButton.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JPanel GreetingPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmMainPage.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(moneyLabel)
							.addGap(477)
							.addComponent(weekLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(marketButton, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(teamButton, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stadiumButton, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(restButton, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(GreetingPanel, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(moneyLabel)
						.addComponent(weekLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(GreetingPanel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(restButton, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addComponent(stadiumButton, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addComponent(marketButton, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addComponent(teamButton, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		
		JLabel GreetingMessage = new JLabel(String.format("Hello %s's Manager!", environment.getGame().getTeam().getTeamName()));
		GreetingMessage.setFont(new Font("Orbitron", Font.BOLD, 26));
		GreetingPanel.add(GreetingMessage);
		frmMainPage.getContentPane().setLayout(groupLayout);
		restButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				intoRest();
			}
		});
		
	}
}
