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
import javax.swing.SwingConstants;

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
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmMainPage.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(marketButton, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(teamButton, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stadiumButton, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(restButton, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
						.addComponent(GreetingPanel, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(GreetingPanel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(teamButton, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addComponent(stadiumButton, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addComponent(restButton, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addComponent(marketButton, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel difficultyLabel = new JLabel("Difficulty:");
		difficultyLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		difficultyLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		difficultyLabel.setText(String.format("Difficulty: %s", environment.getGame().getDifficultyObject().getDifficulty()));
		

		JLabel moneyLabel = new JLabel(String.format("Money: %d", environment.getGame().getBank().getMoney()));
		moneyLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		
		JLabel weekLabel = new JLabel(String.format("Week: %d/%d", environment.getGame().getCurrentWeek(), environment.getGame().getWeek())); //still needs to update the current week
		weekLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(difficultyLabel)
					.addGap(29)
					.addComponent(moneyLabel)
					.addGap(18)
					.addComponent(weekLabel)
					.addGap(12))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(difficultyLabel)
						.addComponent(weekLabel)
						.addComponent(moneyLabel)))
		);
		panel.setLayout(gl_panel);
		
		
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
