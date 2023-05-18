package src.pages;
import src.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;

public class StadiumPage {

	private JFrame frame;
	private GameEnvironment environment;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StadiumPage window = new StadiumPage();
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
	public StadiumPage(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		environment.closeStadiumPage(this);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton backButton = new JButton("<-");
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Stadium!");
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcomeToThe)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblWelcomeToThe, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel lblNewLabel_8_1 = new JLabel("<outcome>");
		
		JButton btnNewButton_1 = new JButton("Start Match");
		
		JLabel lblNewLabel_4_1 = new JLabel("Team Name");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_6_1 = new JLabel("<name>");
		
		JLabel lblNewLabel_7_1 = new JLabel("<reward>");
		
		JLabel lblNewLabel_5_1 = new JLabel("Reward");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
		gl_panel_2_1.setHorizontalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 92, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGap(1)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel_8_1)
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel_7_1)
					.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_5_1)
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_6_1)
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel_4_1)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_panel_2_1.setVerticalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 150, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_4_1)
					.addGap(8)
					.addComponent(lblNewLabel_6_1)
					.addGap(7)
					.addComponent(lblNewLabel_5_1)
					.addGap(4)
					.addComponent(lblNewLabel_7_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_8_1)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel_2_1.setLayout(gl_panel_2_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel lblNewLabel_8_1_1 = new JLabel("<outcome>");
		
		JButton btnNewButton_1_1 = new JButton("Start Match");
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Team Name");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_6_1_1 = new JLabel("<name>");
		
		JLabel lblNewLabel_7_1_1 = new JLabel("<reward>");
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Reward");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panel_2_1_1 = new GroupLayout(panel_2_1_1);
		gl_panel_2_1_1.setHorizontalGroup(
			gl_panel_2_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 92, Short.MAX_VALUE)
				.addGap(0, 92, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1_1.createSequentialGroup()
					.addGap(1)
					.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_panel_2_1_1.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel_8_1_1)
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(gl_panel_2_1_1.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel_7_1_1)
					.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(gl_panel_2_1_1.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_5_1_1)
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(gl_panel_2_1_1.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_6_1_1)
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(gl_panel_2_1_1.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel_4_1_1)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_panel_2_1_1.setVerticalGroup(
			gl_panel_2_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 150, Short.MAX_VALUE)
				.addGap(0, 150, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_4_1_1)
					.addGap(8)
					.addComponent(lblNewLabel_6_1_1)
					.addGap(7)
					.addComponent(lblNewLabel_5_1_1)
					.addGap(4)
					.addComponent(lblNewLabel_7_1_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_8_1_1)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel_2_1_1.setLayout(gl_panel_2_1_1);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("<outcome>");
		
		JButton btnNewButton_1_1_1 = new JButton("Start Match");
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Team Name");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("<name>");
		
		JLabel lblNewLabel_7_1_1_1 = new JLabel("<reward>");
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Reward");
		lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panel_2_1_1_1 = new GroupLayout(panel_2_1_1_1);
		gl_panel_2_1_1_1.setHorizontalGroup(
			gl_panel_2_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 92, Short.MAX_VALUE)
				.addGap(0, 92, Short.MAX_VALUE)
				.addGap(0, 92, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1_1_1.createSequentialGroup()
					.addGap(1)
					.addComponent(btnNewButton_1_1_1, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_panel_2_1_1_1.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel_8_1_1_1)
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(gl_panel_2_1_1_1.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel_7_1_1_1)
					.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(gl_panel_2_1_1_1.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_5_1_1_1)
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(gl_panel_2_1_1_1.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_6_1_1_1)
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(gl_panel_2_1_1_1.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel_4_1_1_1)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_panel_2_1_1_1.setVerticalGroup(
			gl_panel_2_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 150, Short.MAX_VALUE)
				.addGap(0, 150, Short.MAX_VALUE)
				.addGap(0, 150, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1_1_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_4_1_1_1)
					.addGap(8)
					.addComponent(lblNewLabel_6_1_1_1)
					.addGap(7)
					.addComponent(lblNewLabel_5_1_1_1)
					.addGap(4)
					.addComponent(lblNewLabel_7_1_1_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1_1_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_8_1_1_1)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel_2_1_1_1.setLayout(gl_panel_2_1_1_1);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(backButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(panel_2_1_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(backButton)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_1_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_4 = new JLabel("Team Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_5 = new JLabel("Reward");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_6 = new JLabel("<name>");
		
		JLabel lblNewLabel_7 = new JLabel("<reward>");
		
		JButton btnNewButton = new JButton("Start Match");
		
		JLabel lblNewLabel_8 = new JLabel("<outcome>");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_8))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(21)
							.addComponent(lblNewLabel_7))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel_5))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel_6))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(13)
							.addComponent(lblNewLabel_4))
						.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_4)
					.addGap(8)
					.addComponent(lblNewLabel_6)
					.addGap(7)
					.addComponent(lblNewLabel_5)
					.addGap(4)
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_8)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Money: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblNewLabel_1 = new JLabel("Week:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblNewLabel_2 = new JLabel("Points:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblNewLabel_3 = new JLabel("StatTotal:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
					.addGap(8))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
	}
}
