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

public class MarketPage {

	private JFrame frmMarket;
	private GameEnvironment environment;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MarketPage window = new MarketPage();
//					window.getFrame().setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public MarketPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frmMarket.setVisible(true);
	}
	
	public void closeWindow() {
		frmMarket.dispose();
	}
	
	public void finishedWindow() {
		environment.closeMarketPage(this);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMarket = new JFrame();
		frmMarket.setTitle("Market");
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarket.getContentPane().setLayout(new MigLayout("", "[]", "[]"));
		
		JButton backButton = new JButton("<");
		backButton.setFont(new Font("SimSun", Font.BOLD, 12));
		frmMarket.getContentPane().add(backButton, "cell 0 0");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		
		
		
		ArrayList<String> athletesNames = new ArrayList<String>();
		ArrayList<String> athletesStats = new ArrayList<String>();
		ArrayList<String> athletesCosts = new ArrayList<String>();
		
		ArrayList<Athlete> athletes = new Market().getAthletes();
		for (int i = 0; i < athletes.size(); i++)
		{
			athletesNames.add(athletes.get(i).getFullName());
			
			ArrayList<Integer> statList = athletes.get(i).getStatList();
			statList.add(athletes.get(i).getStamina());
			String statString = statList.stream()
					.map(n -> String.valueOf(n))
					.collect(Collectors.joining(",", "", ""));
			athletesStats.add(statString);
			
			athletesCosts.add(String.valueOf(athletes.get(i).getPrice()));
			
		}

		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(nameLabel, "cell 1 1,alignx right,aligny top");
		
		JLabel statDescription = new JLabel("atk,def,agi,sta");
		statDescription.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(statDescription, "cell 0 2 3 1,alignx right,aligny top");
	
		
		JLabel costLabel = new JLabel("Cost");
		costLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(costLabel, "cell 2 3,alignx right,aligny top");
		
		JLabel buyPrompt = new JLabel("Buy");
		buyPrompt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(buyPrompt, "cell 2 4,alignx right,aligny center");
		
		
		// One
		JLabel athlete1Name = new JLabel(athletesNames.get(0));
		athlete1Name.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(athlete1Name, "cell 3 1,alignx left,aligny top");
		
		JLabel athlete1Stats = new JLabel(athletesStats.get(0));
		athlete1Stats.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(athlete1Stats, "cell 3 2,alignx left,aligny top");	
		
		JLabel athlete1Cost = new JLabel(athletesCosts.get(0));
		athlete1Cost.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(athlete1Cost, "cell 3 3,alignx left,aligny top");
		
		JRadioButton athlete1RadioButton = new JRadioButton("");
		frame.getContentPane().add(athlete1RadioButton, "cell 3 4,alignx left,aligny top");
		
		// Two
		JLabel athlete2Name = new JLabel(athletesNames.get(1));
		athlete2Name.setFont(new Font("Tahoma", Font.PLAIN, 9));
		athlete2Name.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(athlete2Name, "cell 4 1,alignx left,aligny top");
		
		JLabel athlete2Stats = new JLabel(athletesStats.get(1));
		athlete2Stats.setFont(new Font("Tahoma", Font.PLAIN, 9));
		athlete2Stats.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(athlete2Stats, "cell 4 2,alignx left,aligny top");	
		
		JLabel athlete2Cost = new JLabel(athletesCosts.get(1));
		athlete2Cost.setFont(new Font("Tahoma", Font.PLAIN, 9));
		athlete2Cost.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(athlete2Cost, "cell 4 3,alignx left,aligny top");
		
		JRadioButton athlete2RadioButton = new JRadioButton("");
		frame.getContentPane().add(athlete2RadioButton, "cell 4 4,alignx left,aligny top");
		
		// Three
		JLabel athlete3Name = new JLabel(athletesNames.get(2));
		athlete3Name.setFont(new Font("Tahoma", Font.PLAIN, 9));
		athlete3Name.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(athlete3Name, "cell 5 1,alignx left,aligny top");
		
		JLabel athlete3Stats = new JLabel(athletesStats.get(2));
		athlete3Stats.setFont(new Font("Tahoma", Font.PLAIN, 9));
		athlete3Stats.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(athlete3Stats, "cell 5 2,alignx left,aligny top");	
		
		JLabel athlete3Cost = new JLabel(athletesCosts.get(2));
		athlete3Cost.setFont(new Font("Tahoma", Font.PLAIN, 9));
		athlete3Cost.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(athlete3Cost, "cell 5 3,alignx left,aligny top");
		
		JRadioButton athlete3RadioButton = new JRadioButton("");
		frame.getContentPane().add(athlete3RadioButton, "cell 5 4,alignx left,aligny top");
		
		// Four
		JLabel athlete4Name = new JLabel(athletesNames.get(3));
		athlete4Name.setFont(new Font("Tahoma", Font.PLAIN, 9));
		athlete4Name.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(athlete4Name, "cell 6 1,alignx left,aligny top");
		
		JLabel athlete4Stats = new JLabel(athletesStats.get(3));
		athlete4Stats.setFont(new Font("Tahoma", Font.PLAIN, 9));
		athlete4Stats.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(athlete4Stats, "cell 6 2,alignx left,aligny top");	
		
		JLabel athlete4Cost = new JLabel(athletesCosts.get(3));
		athlete4Cost.setFont(new Font("Tahoma", Font.PLAIN, 9));
		athlete4Cost.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(athlete4Cost, "cell 6 3,alignx left,aligny top");
		
		JRadioButton athlete4RadioButton = new JRadioButton("");
		frame.getContentPane().add(athlete4RadioButton, "cell 6 4,alignx left,aligny top");
		
		// Five
		
		JLabel athlete5Name = new JLabel(athletesNames.get(4));
		athlete5Name.setFont(new Font("Tahoma", Font.PLAIN, 9));
		athlete5Name.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(athlete5Name, "cell 7 1,alignx left,aligny top");
		
		JLabel athlete5Stats = new JLabel(athletesStats.get(4));
		athlete5Stats.setFont(new Font("Tahoma", Font.PLAIN, 9));
		athlete5Stats.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(athlete5Stats, "cell 7 2,alignx left,aligny top");	
		
		JLabel athlete5Cost = new JLabel(athletesCosts.get(4));
		athlete5Cost.setFont(new Font("Tahoma", Font.PLAIN, 9));
		athlete5Cost.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(athlete5Cost, "cell 7 3,alignx left,aligny top");
		
		JRadioButton athlete5RadioButton = new JRadioButton("");
		frame.getContentPane().add(athlete5RadioButton, "cell 7 4,alignx left,aligny top");
	}

	public JFrame getFrame() {
		return frmMarket;
	}

}