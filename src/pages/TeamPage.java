package src.pages;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class TeamPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamPage window = new TeamPage();
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
	public TeamPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[46px][45px]", "[23px]"));
		
		JButton backButton = new JButton("<-");
		frame.getContentPane().add(backButton, "cell 0 0,alignx left,aligny top");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GamePage();
				GamePage.main(null);
				frame.setVisible(false);
			}
		});
	}

}