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
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * The SetupPage class represents a GUI window for setting up the game.
 * It allows the user to input the team name, select the difficulty level, and
 * set the week number.
 */
public class SetupPage {

	private JFrame frmWelcome;
	private JTextField teamInput;
	private GameEnvironment environment;
	private Difficulty setDifficulty;
	private int weekNum = 1;

	/**
	 * Creates a SetupPage object.
	 *
	 * @param incomingEnvironment The game environment.
	 */
	public SetupPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frmWelcome.setVisible(true);
	}

	/**
	 * Closes the setup page window.
	 */
	public void closeWindow() {
		frmWelcome.dispose();
	}

	/**
	 * requests the game environment to close the setup page
	 */
	public void finishedWindow() {
		environment.closeSetupPage(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setResizable(false);
		frmWelcome.setTitle("Welcome");
		frmWelcome.setBounds(100, 100, 454, 300);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel setupLabel = new JLabel("Welcome to Basketball League!");
		setupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		setupLabel.setFont(new Font("Orbitron", Font.BOLD, 22));

		JLabel teamLabel = new JLabel("Team Name");
		teamLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));

		JTextField teamInput = new JTextField();
		teamInput.setFont(new Font("Orbitron", Font.PLAIN, 12));
		teamInput.setColumns(10);

		JLabel difficultyLabel = new JLabel("Difficulty");
		difficultyLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));

		JSpinner difficultySpinner = new JSpinner();
		difficultySpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) { // handles the difficulty when it's changed
				setDifficulty = new Difficulty((String) difficultySpinner.getValue());
			}
		});
		difficultySpinner.setFont(new Font("Orbitron", Font.PLAIN, 12));
		difficultySpinner.setModel(new SpinnerListModel(new String[] { "Normal", "Hard" }));
		String difficultyValue = (String) difficultySpinner.getValue();
		setDifficulty = new Difficulty(difficultyValue);

		JLabel weekLabel = new JLabel("Week No.");
		weekLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));

		JButton finishSetup = new JButton("Finish Setup");
		finishSetup.setFont(new Font("Orbitron", Font.PLAIN, 12));

		JLabel weekNumLabel = new JLabel("<Week>");
		weekNumLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		weekNumLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JSlider weekSlider = new JSlider();
		weekSlider.setMinimum(1);
		weekSlider.setMaximum(10);
		weekSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int weekNumber = weekSlider.getValue();
				weekNum = weekNumber;
				weekNumLabel.setText(Integer.toString(weekNumber));
			}
		});

		weekSlider.setValue(0);
		GroupLayout groupLayout = new GroupLayout(frmWelcome.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addContainerGap()
												.addComponent(setupLabel, GroupLayout.PREFERRED_SIZE, 420,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addGap(103)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(weekLabel)
														.addComponent(difficultyLabel)
														.addComponent(teamLabel))
												.addGap(18)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(difficultySpinner, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGroup(groupLayout.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(weekSlider, GroupLayout.PREFERRED_SIZE,
																		147, GroupLayout.PREFERRED_SIZE)
																.addGap(2)
																.addComponent(weekNumLabel))
														.addComponent(teamInput, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
												.addGap(157)
												.addComponent(finishSetup)))
								.addContainerGap(78, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(27)
								.addComponent(setupLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addGap(18)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(teamInput, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(teamLabel))
												.addGap(4)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(difficultyLabel)
														.addComponent(difficultySpinner, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 26,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(weekSlider, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(finishSetup))
										.addGroup(groupLayout.createSequentialGroup()
												.addGap(63)
												.addComponent(weekNumLabel, GroupLayout.PREFERRED_SIZE, 22,
														GroupLayout.PREFERRED_SIZE)))
								.addGap(87)));
		frmWelcome.getContentPane().setLayout(groupLayout);

		finishSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String teamName = teamInput.getText();
				ArrayList<Athlete> startingTeam = new Market().getAthletes(environment);
				Team team = new Team(teamName, startingTeam);
				Bank bank = new Bank(1);
				if (setDifficulty.getDifficulty() == "Hard") {
					bank = new Bank(1000);

				} else {
					bank = new Bank(5000);
				}
				Game game = new Game(weekNum, team, bank, setDifficulty);
				environment.setGame(game);
				finishedWindow();
			}
		});

	}
}
