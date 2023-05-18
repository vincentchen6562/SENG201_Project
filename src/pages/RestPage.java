package src.pages;
import src.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class RestPage {

	private JFrame frmTakeABye;
	private GameEnvironment environment;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RestPage window = new RestPage();
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
	public RestPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frmTakeABye.setVisible(true);
	}
	
	public void closeWindow() {
		frmTakeABye.dispose();
	}
	
	public void finishedWindow() {
		environment.closeRestPage(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTakeABye = new JFrame();
		frmTakeABye.setTitle("Take a Bye");
		frmTakeABye.setBounds(100, 100, 450, 300);
		frmTakeABye.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTakeABye.getContentPane().setLayout(new MigLayout("", "[1px]", "[1px]"));
		
		JButton backButton = new JButton("<");
		backButton.setFont(new Font("SimSun", Font.BOLD, 12));
		frmTakeABye.getContentPane().add(backButton, "cell 0 0,grow");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
	}

}
