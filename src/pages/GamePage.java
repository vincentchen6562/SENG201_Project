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

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		int week = Game.getWeek();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamePage window = new GamePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GamePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][][][][][][][][][][][]", "[][][][][][][][][]"));
		

		Bank bank = new Bank();
		JLabel lblNewLabel = new JLabel(String.format("Money: %d", bank.getBank()));
		frame.getContentPane().add(lblNewLabel, "cell 0 0");
		
		Game game = new Game(0, 0);
		JLabel lblNewLabel_1 = new JLabel(String.format("Week: %d",game.getSeason()));
		frame.getContentPane().add(lblNewLabel_1, "cell 14 0");
		
		JButton marketButton = new JButton("Market");
		marketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MarketPage();
				MarketPage.main(null);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(marketButton, "cell 6 2");
		
		JButton teamButton = new JButton("Team");
		teamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeamPage();
				TeamPage.main(null);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(teamButton, "cell 6 3");

		JButton stadiumButton = new JButton("Stadium");
		frame.getContentPane().add(stadiumButton, "cell 6 4");
		stadiumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StadiumPage();
				StadiumPage.main(null);
				frame.setVisible(false);
			}
		});
		
		
		JButton restButton = new JButton("Rest");
		frame.getContentPane().add(restButton, "cell 6 5");
		restButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RestPage();
				RestPage.main(null);
				frame.setVisible(false);
			}
		});
		
	}

}
