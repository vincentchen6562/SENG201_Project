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
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][][][grow]", "[][][][][][][][][]"));
		
		JLabel setupLabel = new JLabel("Setup");
		frame.getContentPane().add(setupLabel, "cell 5 0");
		
		JLabel teamInput = new JLabel("Team Name");
		frame.getContentPane().add(teamInput, "cell 4 2,alignx trailing");
		String teamName = teamInput.getText();
		
		txtTeamName = new JTextField();
		frame.getContentPane().add(txtTeamName, "cell 5 2,alignx left");
		txtTeamName.setColumns(10);
		
		JLabel difficultyLabel = new JLabel("Difficulty");
		frame.getContentPane().add(difficultyLabel, "cell 4 3");
		
		JSpinner difficultySpinner = new JSpinner();
		difficultySpinner.setModel(new SpinnerListModel(new String[] {"Easy", "Medium", "Hard"}));
		frame.getContentPane().add(difficultySpinner, "cell 5 3");
		String difficulty = (String) difficultySpinner.getValue();

		
		JLabel weekLabel = new JLabel("Week No.");
		frame.getContentPane().add(weekLabel, "cell 4 4");
		
		JSlider weekSlider = new JSlider();
		frame.getContentPane().add(weekSlider, "cell 5 4");
		int weekNum = weekSlider.getValue();
		
		JButton finishSetup = new JButton("Finish Setup");
		frame.getContentPane().add(finishSetup, "cell 5 5,alignx left");
		
		finishSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				frame.setVisible(false);
			}
		});
		
	}

}
