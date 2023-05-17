package src.pages;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

public class MarketPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketPage window = new MarketPage();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MarketPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[]", "[]"));
		
		JButton backButton = new JButton("<-");
		frame.getContentPane().add(backButton, "cell 0 0");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GamePage();
				GamePage.main(null);
				frame.setVisible(false);
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

}