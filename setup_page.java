import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class setup_page {

	private JFrame frame;
	private JTextField txtTeamNameHere;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setup_page window = new setup_page();
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
	public setup_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Game Setup");
		lblNewLabel.setBounds(175, 11, 58, 14);
		frame.getContentPane().add(lblNewLabel);

		txtTeamNameHere = new JTextField();
		txtTeamNameHere.setText("team name here");
		txtTeamNameHere.setBounds(114, 78, 147, 20);
		frame.getContentPane().add(txtTeamNameHere);
		txtTeamNameHere.setColumns(10);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(161, 188, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JSlider slider = new JSlider();
		slider.setMaximum(25);
		slider.setBounds(114, 104, 147, 26);
		frame.getContentPane().add(slider);
	}
}
