package src.pages;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class SetupPage {

	private JFrame frame;
	private JTextField txtTeamName;
	private GameEnvironment environment;

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
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		environment.closeSetupPage(this);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel setupLabel = new JLabel("Setup");
		
		JLabel teamInput = new JLabel("Team Name");
		String teamName = teamInput.getText();
		
		txtTeamName = new JTextField();
		txtTeamName.setColumns(10);
		
		JLabel difficultyLabel = new JLabel("Difficulty");
		
		JSpinner difficultySpinner = new JSpinner();
		difficultySpinner.setModel(new SpinnerListModel(new String[] {"Easy", "Medium", "Hard"}));
		String difficulty = (String) difficultySpinner.getValue();

		
		JLabel weekLabel = new JLabel("Week No.");
		
		JSlider weekSlider = new JSlider();
		int weekNum = weekSlider.getValue();
		
		JButton finishSetup = new JButton("Finish Setup");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(183)
					.addComponent(setupLabel))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(123)
					.addComponent(teamInput)
					.addGap(4)
					.addComponent(txtTeamName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(123)
					.addComponent(difficultyLabel)
					.addGap(18)
					.addComponent(difficultySpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(123)
					.addComponent(weekLabel)
					.addGap(13)
					.addComponent(weekSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(183)
					.addComponent(finishSetup))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(setupLabel)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(teamInput))
						.addComponent(txtTeamName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(difficultyLabel))
						.addComponent(difficultySpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(weekLabel))
						.addComponent(weekSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addComponent(finishSetup))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		finishSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				frame.setVisible(false);
			}
		});
		
	}

}
