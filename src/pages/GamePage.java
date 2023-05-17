package src.pages;

import java.awt.EventQueue;
import src.items.*;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class GamePage {

	private JFrame frame;
	private static int bank;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][][][][][][][][][][]", "[][][][][][]"));
		

		Bank bank = new Bank();
		JLabel lblNewLabel = new JLabel(String.format("money: %d", bank.getBank()));
		frame.getContentPane().add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_1 = new JLabel("Week");
		frame.getContentPane().add(lblNewLabel_1, "cell 13 0");
		
		JButton btnNewButton = new JButton("Market");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton, "cell 5 2");
		
		JButton btnNewButton_1 = new JButton("Team");
		frame.getContentPane().add(btnNewButton_1, "cell 5 3");
		
		JButton btnNewButton_2 = new JButton("Stadium");
		frame.getContentPane().add(btnNewButton_2, "cell 5 4");
		
		JButton btnNewButton_3 = new JButton("Rest");
		frame.getContentPane().add(btnNewButton_3, "cell 5 5");
	}

}
