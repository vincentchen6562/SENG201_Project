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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;

public class RestPage {

	private JFrame frmTakeABye;
	private GameEnvironment environment;

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
		frmTakeABye.setBounds(100, 100, 600, 400);
		frmTakeABye.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int money = environment.getGame().getBank().getMoney();
		int currentWeek = environment.getGame().getCurrentWeek();
		int totalWeek = environment.getGame().getWeek();
		int numWins = environment.getGame().getWins();
		int numLoss = environment.getGame().getLosses();
		
		JButton backButton = new JButton("<");
		backButton.setFont(new Font("SimSun", Font.BOLD, 12));
		
		JPanel statPanel = new JPanel();
		statPanel.setBorder(new CompoundBorder());
		
		JLabel moneyLabel = new JLabel(String.format("Money: $%d", money));
		moneyLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel weekLabel = new JLabel(String.format("Week: %d/%d", currentWeek, totalWeek));
		weekLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel winsLabel = new JLabel(String.format("Wins: %d", numWins));
		winsLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel lossLabel = new JLabel(String.format("Losses: %d", numLoss));
		lossLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_statPanel = new GroupLayout(statPanel);
		gl_statPanel.setHorizontalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 215, Short.MAX_VALUE)
				.addGroup(gl_statPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_statPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(moneyLabel)
						.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_statPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(winsLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(lossLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_statPanel.setVerticalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 60, Short.MAX_VALUE)
				.addGroup(gl_statPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_statPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(moneyLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(winsLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_statPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lossLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
		);
		statPanel.setLayout(gl_statPanel);
		
		JLabel takeAByeLabel = new JLabel("Take a Bye");
		takeAByeLabel.setFont(new Font("Orbitron", Font.BOLD, 20));
		takeAByeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		
		JButton readyButton = new JButton("Ready");
		readyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.getGame().incrementWeek();
				finishedWindow();
			}
		});
		readyButton.setFont(new Font("Orbitron", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(frmTakeABye.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(backButton)
					.addGap(10)
					.addComponent(takeAByeLabel, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(246)
					.addComponent(readyButton)
					.addContainerGap(255, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(backButton)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(takeAByeLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
						.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(readyButton, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addGap(18))
		);
		
		JPanel athlete1Panel = new JPanel();
		
		JPanel athlete1Panel_1 = new JPanel();
		
		JToggleButton toggleButton_1 = new JToggleButton("New toggle button");
		
		JLabel athlete1NameLabel_1 = new JLabel("Athlete 1 Name");
		athlete1NameLabel_1.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel centerLabel_1 = new JLabel("Center");
		centerLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		centerLabel_1.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_athlete1Panel_1 = new GroupLayout(athlete1Panel_1);
		gl_athlete1Panel_1.setHorizontalGroup(
			gl_athlete1Panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 179, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_athlete1Panel_1.createSequentialGroup()
							.addGap(10)
							.addComponent(toggleButton_1))
						.addComponent(athlete1NameLabel_1, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(centerLabel_1, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_athlete1Panel_1.setVerticalGroup(
			gl_athlete1Panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(centerLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete1NameLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toggleButton_1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		athlete1Panel_1.setLayout(gl_athlete1Panel_1);
		
		JPanel athlete1Panel_2 = new JPanel();
		
		JToggleButton toggleButton_2 = new JToggleButton("New toggle button");
		
		JLabel athlete1NameLabel_2 = new JLabel("Athlete 1 Name");
		athlete1NameLabel_2.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel centerLabel_2 = new JLabel("Center");
		centerLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		centerLabel_2.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_athlete1Panel_2 = new GroupLayout(athlete1Panel_2);
		gl_athlete1Panel_2.setHorizontalGroup(
			gl_athlete1Panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 179, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_athlete1Panel_2.createSequentialGroup()
							.addGap(10)
							.addComponent(toggleButton_2))
						.addComponent(athlete1NameLabel_2, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(centerLabel_2, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_athlete1Panel_2.setVerticalGroup(
			gl_athlete1Panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(centerLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete1NameLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toggleButton_2)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		athlete1Panel_2.setLayout(gl_athlete1Panel_2);
		
		JPanel athlete1Panel_3 = new JPanel();
		
		JToggleButton toggleButton_3 = new JToggleButton("New toggle button");
		
		JLabel athlete1NameLabel_3 = new JLabel("Athlete 1 Name");
		athlete1NameLabel_3.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel centerLabel_3 = new JLabel("Center");
		centerLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		centerLabel_3.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_athlete1Panel_3 = new GroupLayout(athlete1Panel_3);
		gl_athlete1Panel_3.setHorizontalGroup(
			gl_athlete1Panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 179, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_athlete1Panel_3.createSequentialGroup()
							.addGap(10)
							.addComponent(toggleButton_3))
						.addComponent(athlete1NameLabel_3, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(centerLabel_3, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_athlete1Panel_3.setVerticalGroup(
			gl_athlete1Panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(centerLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete1NameLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toggleButton_3)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		athlete1Panel_3.setLayout(gl_athlete1Panel_3);
		
		JPanel athlete1Panel_4 = new JPanel();
		
		JToggleButton toggleButton_4 = new JToggleButton("New toggle button");
		
		JLabel athlete1NameLabel_4 = new JLabel("Athlete 1 Name");
		athlete1NameLabel_4.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel centerLabel_4 = new JLabel("Center");
		centerLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		centerLabel_4.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_athlete1Panel_4 = new GroupLayout(athlete1Panel_4);
		gl_athlete1Panel_4.setHorizontalGroup(
			gl_athlete1Panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 179, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_athlete1Panel_4.createSequentialGroup()
							.addGap(10)
							.addComponent(toggleButton_4))
						.addComponent(athlete1NameLabel_4, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(centerLabel_4, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_athlete1Panel_4.setVerticalGroup(
			gl_athlete1Panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(centerLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete1NameLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toggleButton_4)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		athlete1Panel_4.setLayout(gl_athlete1Panel_4);
		
		JPanel athlete1Panel_5 = new JPanel();
		
		JToggleButton toggleButton_5 = new JToggleButton("New toggle button");
		
		JLabel athlete1NameLabel_5 = new JLabel("Athlete 1 Name");
		athlete1NameLabel_5.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel centerLabel_5 = new JLabel("Center");
		centerLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		centerLabel_5.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setFont(new Font("Orbitron", Font.PLAIN, 12));
		GroupLayout gl_athlete1Panel_5 = new GroupLayout(athlete1Panel_5);
		gl_athlete1Panel_5.setHorizontalGroup(
			gl_athlete1Panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 179, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_athlete1Panel_5.createSequentialGroup()
							.addGap(10)
							.addComponent(toggleButton_5))
						.addComponent(athlete1NameLabel_5, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(centerLabel_5, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_athlete1Panel_5.setVerticalGroup(
			gl_athlete1Panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE)
				.addGroup(gl_athlete1Panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(centerLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete1NameLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toggleButton_5)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		athlete1Panel_5.setLayout(gl_athlete1Panel_5);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(athlete1Panel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(athlete1Panel_1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(athlete1Panel_2, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(athlete1Panel_3, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(athlete1Panel_4, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(athlete1Panel_5, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(athlete1Panel_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(athlete1Panel_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(athlete1Panel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(athlete1Panel_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(athlete1Panel_4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(athlete1Panel_5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(17))
		);
		
		JLabel centerLabel = new JLabel("Center");
		centerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		centerLabel.setFont(new Font("Orbitron", Font.PLAIN, 14));
		
		JLabel athlete1NameLabel = new JLabel("Athlete 1 Name");
		athlete1NameLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Orbitron", Font.PLAIN, 12));
		
		JToggleButton toggleButton = new JToggleButton("New toggle button");
		GroupLayout gl_athlete1Panel = new GroupLayout(athlete1Panel);
		gl_athlete1Panel.setHorizontalGroup(
			gl_athlete1Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_athlete1Panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_athlete1Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_athlete1Panel.createSequentialGroup()
							.addGap(10)
							.addComponent(toggleButton))
						.addComponent(athlete1NameLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(centerLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_athlete1Panel.setVerticalGroup(
			gl_athlete1Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_athlete1Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(centerLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(athlete1NameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toggleButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		athlete1Panel.setLayout(gl_athlete1Panel);
		panel.setLayout(gl_panel);
		frmTakeABye.getContentPane().setLayout(groupLayout);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
	}
}
