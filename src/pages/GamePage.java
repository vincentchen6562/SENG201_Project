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
		environment.launchMarketPage();
	}
	
	public void intoRest() {
		environment.launchRestPage();
	}
	
	public void intoStadium() {
		environment.launchStadiumPage();
	}
	
	public void finishedWindow() {
		environment.closeGamePage(this);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainPage = new JFrame();
		frmMainPage.setTitle("Main Page");
		frmMainPage.setBounds(100, 100, 450, 300);
		frmMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainPage.getContentPane().setLayout(new MigLayout("", "[][][][][][][][][][][][][][][]", "[][][][][][][][][]"));
		

		Bank bank = new Bank();
		JLabel lblNewLabel = new JLabel(String.format("Money: %d", bank.getBank()));
		frmMainPage.getContentPane().add(lblNewLabel, "cell 0 0");
		
		Game game = new Game(0, 0);
		JLabel lblNewLabel_1 = new JLabel(String.format("Week: %d",game.getSeason()));
		frmMainPage.getContentPane().add(lblNewLabel_1, "cell 14 0");
		
		JButton marketButton = new JButton("Market");
		marketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				intoMarket();
				
			}
		});
		frmMainPage.getContentPane().add(marketButton, "cell 6 2");
		
		JButton teamButton = new JButton("Team");
		teamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeamPage();
				TeamPage.main(null);
				frmMainPage.setVisible(false);
			}
		});
		frmMainPage.getContentPane().add(teamButton, "cell 6 3");

		JButton stadiumButton = new JButton("Stadium"); 
		frmMainPage.getContentPane().add(stadiumButton, "cell 6 4");
		stadiumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intoStadium();
			}
		});
		
		
		JButton restButton = new JButton("Rest");
		frmMainPage.getContentPane().add(restButton, "cell 6 5");
		restButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intoRest();
			}
		});
		
	}

}
