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
		frmStadium.setBounds(100, 100, 600, 400);
		frmStadium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton backButton = new JButton("<");
		backButton.setFont(new Font("SimSun", Font.BOLD, 12));
		
		JPanel statPanel = new JPanel();
		statPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		
		JLabel welcomeLabel = new JLabel("Welcome to the Stadium!");
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_titlePanel = new GroupLayout(titlePanel);
		gl_titlePanel.setHorizontalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(welcomeLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_titlePanel.setVerticalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addComponent(welcomeLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		titlePanel.setLayout(gl_titlePanel);
		
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
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addGap(1)
					.addComponent(team4StartButton, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addGap(18)
					.addComponent(team4Outcome)
					.addContainerGap(63, Short.MAX_VALUE))
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addGap(21)
					.addComponent(team4Reward)
					.addContainerGap(66, Short.MAX_VALUE))
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addGap(25)
					.addComponent(team4RewardTitle)
					.addContainerGap(67, Short.MAX_VALUE))
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addGap(25)
					.addComponent(team4Name)
					.addContainerGap(74, Short.MAX_VALUE))
				.addGroup(gl_match4Panel.createSequentialGroup()
					.addGap(13)
					.addComponent(team4NameTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(55))
		);
		gl_match4Panel.setVerticalGroup(
			gl_match4Panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 294, Short.MAX_VALUE)
				.addGap(0, 294, Short.MAX_VALUE)
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
					.addContainerGap(162, Short.MAX_VALUE))
		);
		match4Panel.setLayout(gl_match4Panel);
		
		JPanel match3Panel = new JPanel();
		match3Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JButton team4StartButton_1 = new JButton("Start Match");
		
		JLabel team4Outcome_1 = new JLabel("<outcome>");
		
		JLabel team4Reward_1 = new JLabel("<reward>");
		
		JLabel team4RewardTitle_1 = new JLabel("Reward");
		team4RewardTitle_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel team4Name_1 = new JLabel("<name>");
		
		JLabel team4NameTitle_1 = new JLabel("Team Name");
		team4NameTitle_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_match3Panel = new GroupLayout(match3Panel);
		gl_match3Panel.setHorizontalGroup(
			gl_match3Panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 137, Short.MAX_VALUE)
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addGap(1)
					.addComponent(team4StartButton_1, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addGap(18)
					.addComponent(team4Outcome_1)
					.addContainerGap(63, Short.MAX_VALUE))
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addGap(21)
					.addComponent(team4Reward_1)
					.addContainerGap(66, Short.MAX_VALUE))
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addGap(25)
					.addComponent(team4RewardTitle_1)
					.addContainerGap(67, Short.MAX_VALUE))
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addGap(25)
					.addComponent(team4Name_1)
					.addContainerGap(74, Short.MAX_VALUE))
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addGap(13)
					.addComponent(team4NameTitle_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(55))
		);
		gl_match3Panel.setVerticalGroup(
			gl_match3Panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 296, Short.MAX_VALUE)
				.addGap(0, 294, Short.MAX_VALUE)
				.addGap(0, 294, Short.MAX_VALUE)
				.addGroup(gl_match3Panel.createSequentialGroup()
					.addGap(5)
					.addComponent(team4NameTitle_1)
					.addGap(8)
					.addComponent(team4Name_1)
					.addGap(7)
					.addComponent(team4RewardTitle_1)
					.addGap(4)
					.addComponent(team4Reward_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team4StartButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team4Outcome_1)
					.addContainerGap(162, Short.MAX_VALUE))
		);
		match3Panel.setLayout(gl_match3Panel);
		
		JPanel match2Panel = new JPanel();
		match2Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JButton team4StartButton_2 = new JButton("Start Match");
		
		JLabel team4Outcome_2 = new JLabel("<outcome>");
		
		JLabel team4Reward_2 = new JLabel("<reward>");
		
		JLabel team4RewardTitle_2 = new JLabel("Reward");
		team4RewardTitle_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel team4Name_2 = new JLabel("<name>");
		
		JLabel team4NameTitle_2 = new JLabel("Team Name");
		team4NameTitle_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_match2Panel = new GroupLayout(match2Panel);
		gl_match2Panel.setHorizontalGroup(
			gl_match2Panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 137, Short.MAX_VALUE)
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addGap(1)
					.addComponent(team4StartButton_2, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addGap(18)
					.addComponent(team4Outcome_2)
					.addContainerGap(63, Short.MAX_VALUE))
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addGap(21)
					.addComponent(team4Reward_2)
					.addContainerGap(66, Short.MAX_VALUE))
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addGap(25)
					.addComponent(team4RewardTitle_2)
					.addContainerGap(67, Short.MAX_VALUE))
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addGap(25)
					.addComponent(team4Name_2)
					.addContainerGap(74, Short.MAX_VALUE))
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addGap(13)
					.addComponent(team4NameTitle_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(55))
		);
		gl_match2Panel.setVerticalGroup(
			gl_match2Panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 296, Short.MAX_VALUE)
				.addGap(0, 294, Short.MAX_VALUE)
				.addGap(0, 294, Short.MAX_VALUE)
				.addGroup(gl_match2Panel.createSequentialGroup()
					.addGap(5)
					.addComponent(team4NameTitle_2)
					.addGap(8)
					.addComponent(team4Name_2)
					.addGap(7)
					.addComponent(team4RewardTitle_2)
					.addGap(4)
					.addComponent(team4Reward_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team4StartButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team4Outcome_2)
					.addContainerGap(162, Short.MAX_VALUE))
		);
		match2Panel.setLayout(gl_match2Panel);
		
		JPanel match1Panel = new JPanel();
		match1Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JButton team4StartButton_3 = new JButton("Start Match");
		
		JLabel team4Outcome_3 = new JLabel("<outcome>");
		
		JLabel team4Reward_3 = new JLabel("<reward>");
		
		JLabel team4RewardTitle_3 = new JLabel("Reward");
		team4RewardTitle_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel team4Name_3 = new JLabel("<name>");
		
		JLabel team4NameTitle_3 = new JLabel("Team Name");
		team4NameTitle_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_match1Panel = new GroupLayout(match1Panel);
		gl_match1Panel.setHorizontalGroup(
			gl_match1Panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 137, Short.MAX_VALUE)
				.addGroup(gl_match1Panel.createSequentialGroup()
					.addGap(1)
					.addComponent(team4StartButton_3, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_match1Panel.createSequentialGroup()
					.addGap(18)
					.addComponent(team4Outcome_3)
					.addContainerGap(63, Short.MAX_VALUE))
				.addGroup(gl_match1Panel.createSequentialGroup()
					.addGap(21)
					.addComponent(team4Reward_3)
					.addContainerGap(66, Short.MAX_VALUE))
				.addGroup(gl_match1Panel.createSequentialGroup()
					.addGap(25)
					.addComponent(team4RewardTitle_3)
					.addContainerGap(67, Short.MAX_VALUE))
				.addGroup(gl_match1Panel.createSequentialGroup()
					.addGap(25)
					.addComponent(team4Name_3)
					.addContainerGap(74, Short.MAX_VALUE))
				.addGroup(gl_match1Panel.createSequentialGroup()
					.addGap(13)
					.addComponent(team4NameTitle_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(55))
		);
		gl_match1Panel.setVerticalGroup(
			gl_match1Panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 296, Short.MAX_VALUE)
				.addGap(0, 294, Short.MAX_VALUE)
				.addGap(0, 294, Short.MAX_VALUE)
				.addGroup(gl_match1Panel.createSequentialGroup()
					.addGap(5)
					.addComponent(team4NameTitle_3)
					.addGap(8)
					.addComponent(team4Name_3)
					.addGap(7)
					.addComponent(team4RewardTitle_3)
					.addGap(4)
					.addComponent(team4Reward_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team4StartButton_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(team4Outcome_3)
					.addContainerGap(162, Short.MAX_VALUE))
		);
		match1Panel.setLayout(gl_match1Panel);
		GroupLayout groupLayout = new GroupLayout(frmStadium.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(backButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, Short.MAX_VALUE)
							.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(match1Panel, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(match2Panel, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(match3Panel, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(match4Panel, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
					.addGap(8))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
						.addComponent(backButton)
						.addComponent(statPanel, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(match4Panel, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
						.addComponent(match3Panel, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
						.addComponent(match2Panel, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
						.addComponent(match1Panel, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
					.addContainerGap())
		);
		
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
					.addContainerGap()
					.addComponent(moneyLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(statsTotalLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(154))
		);
		gl_statPanel.setVerticalGroup(
			gl_statPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(weekLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addComponent(moneyLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
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
