package src.pages;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JSlider;
import src.*;
import src.items.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import src.team.*;

public class SetupPage {

	private JFrame frmWelcome;
	private JTextField teamInput;
	private GameEnvironment environment;
	private Difficulty setDifficulty;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SetupPage window = new SetupPage();
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
	public SetupPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frmWelcome.setVisible(true);
	}
	
	public void closeWindow() {
		frmWelcome.dispose();
	}
	
	public void finishedWindow() {
		environment.closeSetupPage(this);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setTitle("Welcome");
		frmWelcome.setBounds(100, 100, 450, 300);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel setupLabel = new JLabel("Welcome to Basketball League!");
		setupLabel.setFont(new Font("Orbitron", Font.BOLD, 20));
		
		JLabel teamLabel = new JLabel("Team Name");
		teamLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));

		
		JTextField teamInput = new JTextField();
		teamInput.setColumns(10);
		
		JLabel difficultyLabel = new JLabel("Difficulty");
		difficultyLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JSpinner difficultySpinner = new JSpinner();
		difficultySpinner.setModel(new SpinnerListModel(new String[] {"Normal", "Hard"}));
		String difficultyValue = (String) difficultySpinner.getValue();
		setDifficulty = new Difficulty(difficultyValue);
		
		
		JLabel weekLabel = new JLabel("Week No.");
		weekLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JSlider weekSlider = new JSlider();
		weekSlider.setValue(10);
		int weekNum = weekSlider.getValue();
		
		JButton finishSetup = new JButton("Finish Setup");
		finishSetup.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout groupLayout = new GroupLayout(frmWelcome.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(109)
							.addComponent(teamLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(123)
							.addComponent(difficultyLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(120)
							.addComponent(weekLabel)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(difficultySpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(teamInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(weekSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(setupLabel, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
					.addGap(31))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(150)
					.addComponent(finishSetup)
					.addContainerGap(169, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(setupLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(teamInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(teamLabel))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(difficultyLabel)
						.addComponent(difficultySpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(weekSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(finishSetup)
					.addContainerGap(88, Short.MAX_VALUE))
		);
		frmWelcome.getContentPane().setLayout(groupLayout);
		
		finishSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String teamName = teamInput.getText();
				ArrayList<Athlete> startingTeam = new Market().getAthletes(environment);			
				Team team = new Team(teamName, startingTeam);
				Bank bank = new Bank(999999); // set high for testing, TODO set back to 0
				Game game = new Game(1, 1, team, bank, setDifficulty); // TODO implement difficulty
				environment.setGame(game);
				frmWelcome.setVisible(false);
				finishedWindow();
			}
		});
		
	}

}
