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

	private JFrame frmStadium;
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
		frmStadium.setVisible(true);
	}
	
	public void closeWindow() {
		frmStadium.dispose();
	}
	
	public void finishedWindow() {
		environment.closeStadiumPage(this);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStadium = new JFrame();
		frmStadium.setTitle("Stadium");
		frmStadium.setBounds(100, 100, 450, 300);
		frmStadium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton backButton = new JButton("<");
		backButton.setFont(new Font("SimSun", Font.BOLD, 12));
		
		JPanel statPanel = new JPanel();
		statPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		
		JLabel welcomeLabel = new JLabel("Welcome to the Stadium!");
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_titlePanel = new GroupLayout(titlePanel);
		gl_titlePanel.setHorizontalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(welcomeLabel)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_titlePanel.setVerticalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(welcomeLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
		);
		titlePanel.setLayout(gl_titlePanel);
		
		JPanel match1Panel = new JPanel();
		match1Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel match2Panel = new JPanel();
		match2Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel team2Outcome = new JLabel("<outcome>");
		
		JButton team2StartButton = new JButton("Start Match");
		
		JLabel team2NameTitle = new JLabel("Team Name");
		team2NameTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel team2Name = new JLabel("<name>");
		
		JLabel team2Reward = new JLabel("<reward>");
		
		JLabel team2RewardTitle = new JLabel("Reward");
		team2RewardTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_match2Panel = new GroupLayout(match2Panel);
		gl_match2Panel.setHorizontalGroup(
			gl_match2Panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 92, Short.MAX_VALUE)
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addGap(1)
					.addComponent(team2StartButton, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addGap(18)
					.addComponent(team2Outcome)
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addGap(21)
					.addComponent(team2Reward)
					.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addGap(25)
					.addComponent(team2RewardTitle)
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addGap(25)
					.addComponent(team2Name)
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addGap(13)
					.addComponent(team2NameTitle)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_match2Panel.setVerticalGroup(
			gl_match2Panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 150, Short.MAX_VALUE)
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addGap(5)
					.addComponent(team2NameTitle)
					.addGap(8)
					.addComponent(team2Name)
					.addGap(7)
					.addComponent(team2RewardTitle)
					.addGap(4)
					.addComponent(team2Reward)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team2StartButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team2Outcome)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		match2Panel.setLayout(gl_match2Panel);
		
		JPanel match3Panel = new JPanel();
		match3Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel team3Outcome = new JLabel("<outcome>");
		
		JButton team3StartButton = new JButton("Start Match");
		
		JLabel team3NameTitle = new JLabel("Team Name");
		team3NameTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel team3Name = new JLabel("<name>");
		
		JLabel team3Reward = new JLabel("<reward>");
		
		JLabel team3RewardTitle = new JLabel("Reward");
		team3RewardTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_match3Panel = new GroupLayout(match3Panel);
		gl_match3Panel.setHorizontalGroup(
			gl_match3Panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 92, Short.MAX_VALUE)
				.addGap(0, 92, Short.MAX_VALUE)
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addGap(1)
					.addComponent(team3StartButton, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addGap(18)
					.addComponent(team3Outcome)
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addGap(21)
					.addComponent(team3Reward)
					.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addGap(25)
					.addComponent(team3RewardTitle)
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addGap(25)
					.addComponent(team3Name)
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addGap(13)
					.addComponent(team3NameTitle)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_match3Panel.setVerticalGroup(
			gl_match3Panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 150, Short.MAX_VALUE)
				.addGap(0, 150, Short.MAX_VALUE)
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addGap(5)
					.addComponent(team3NameTitle)
					.addGap(8)
					.addComponent(team3Name)
					.addGap(7)
					.addComponent(team3RewardTitle)
					.addGap(4)
					.addComponent(team3Reward)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team3StartButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team3Outcome)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		match3Panel.setLayout(gl_match3Panel);
		
		JPanel match4Panel = new JPanel();
		match4Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel team4Outcome = new JLabel("<outcome>");
		
		JButton team4StartButton = new JButton("Start Match");
		
		JLabel team4NameTitle = new JLabel("Team Name");
		team4NameTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel team4Name = new JLabel("<name>");
		
		JLabel team4Reward = new JLabel("<reward>");
		
		JLabel team4RewardTitle = new JLabel("Reward");
		team4RewardTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_match4Panel = new GroupLayout(match4Panel);
		gl_match4Panel.setHorizontalGroup(
			gl_match4Panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 92, Short.MAX_VALUE)
				.addGap(0, 92, Short.MAX_VALUE)
				.addGap(0, 92, Short.MAX_VALUE)
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addGap(1)
					.addComponent(team4StartButton, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addGap(18)
					.addComponent(team4Outcome)
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addGap(21)
					.addComponent(team4Reward)
					.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addGap(25)
					.addComponent(team4RewardTitle)
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addGap(25)
					.addComponent(team4Name)
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addGap(13)
					.addComponent(team4NameTitle)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_match4Panel.setVerticalGroup(
			gl_match4Panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 150, Short.MAX_VALUE)
				.addGap(0, 150, Short.MAX_VALUE)
				.addGap(0, 150, Short.MAX_VALUE)
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addGap(5)
					.addComponent(team4NameTitle)
					.addGap(8)
					.addComponent(team4Name)
					.addGap(7)
					.addComponent(team4RewardTitle)
					.addGap(4)
					.addComponent(team4Reward)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team4StartButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team4Outcome)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		match4Panel.setLayout(gl_match4Panel);
		GroupLayout groupLayout = new GroupLayout(frmStadium.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(backButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(statPanel, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(match1Panel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(match2Panel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(match3Panel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(match4Panel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(backButton)
						.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(match2Panel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(match1Panel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(match3Panel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(match4Panel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		
		JLabel team1NameTitle = new JLabel("Team Name");
		team1NameTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel team1RewardTitle = new JLabel("Reward");
		team1RewardTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel team1Name = new JLabel("<name>");
		
		JLabel team1Reward = new JLabel("<reward>");
		
		JButton team1StartButton = new JButton("Start Match");
		
		JLabel team1Outcome = new JLabel("<outcome>");
		GroupLayout gl_match1Panel = new GroupLayout(match1Panel);
		gl_match1Panel.setHorizontalGroup(
			gl_match1Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_match1Panel.createSequentialGroup()
					.addGroup(gl_match1Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_match1Panel.createSequentialGroup()
							.addGap(18)
							.addComponent(team1Outcome))
						.addGroup(gl_match1Panel.createSequentialGroup()
							.addGap(21)
							.addComponent(team1Reward))
						.addGroup(gl_match1Panel.createSequentialGroup()
							.addGap(25)
							.addComponent(team1RewardTitle))
						.addGroup(gl_match1Panel.createSequentialGroup()
							.addGap(25)
							.addComponent(team1Name))
						.addGroup(gl_match1Panel.createSequentialGroup()
							.addGap(13)
							.addComponent(team1NameTitle))
						.addComponent(team1StartButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_match1Panel.setVerticalGroup(
			gl_match1Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_match1Panel.createSequentialGroup()
					.addGap(5)
					.addComponent(team1NameTitle)
					.addGap(8)
					.addComponent(team1Name)
					.addGap(7)
					.addComponent(team1RewardTitle)
					.addGap(4)
					.addComponent(team1Reward)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team1StartButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team1Outcome)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		match1Panel.setLayout(gl_match1Panel);
		
		JLabel moneyLabel = new JLabel("Money: ");
		moneyLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel weekLabel = new JLabel("Week:");
		weekLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel pointsLabel = new JLabel("Points:");
		pointsLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel statsTotalLabel = new JLabel("StatTotal:");
		statsTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout gl_statPanel = new GroupLayout(statPanel);
		gl_statPanel.setHorizontalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statPanel.createSequentialGroup()
					.addComponent(moneyLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(statsTotalLabel, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
					.addGap(8))
		);
		gl_statPanel.setVerticalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(moneyLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addComponent(statsTotalLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
		);
		statPanel.setLayout(gl_statPanel);
		frmStadium.getContentPane().setLayout(groupLayout);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
	}
}
