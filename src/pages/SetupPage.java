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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupPage window = new SetupPage();
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
	public SetupPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][][][grow]", "[][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Setup");
		frame.getContentPane().add(lblNewLabel, "cell 5 0");
		
		JLabel lblNewLabel_2 = new JLabel("Team Name");
		frame.getContentPane().add(lblNewLabel_2, "cell 4 2,alignx trailing");
		
		txtTeamName = new JTextField();
		frame.getContentPane().add(txtTeamName, "cell 5 2,alignx left");
		txtTeamName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Difficulty");
		frame.getContentPane().add(lblNewLabel_1, "cell 4 3");
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"Easy", "Medium", "Hard"}));
		frame.getContentPane().add(spinner, "cell 5 3");
		
		JLabel lblNewLabel_3 = new JLabel("Week No.");
		frame.getContentPane().add(lblNewLabel_3, "cell 4 4");
		
		JSlider slider = new JSlider();
		frame.getContentPane().add(slider, "cell 5 4");
		
		JButton finishSetup = new JButton("Finish Setup");
		frame.getContentPane().add(finishSetup, "cell 5 5,alignx left");
		
		finishSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GamePage();
				GamePage.main(null);
				frame.setVisible(false);
			}
		});
		
	}

}
