import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class GamePage {

	private JFrame frame;

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
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("131px"),
				ColumnSpec.decode("91px"),
				ColumnSpec.decode("89px"),
				ColumnSpec.decode("57px"),
				ColumnSpec.decode("46px"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				RowSpec.decode("51px"),
				RowSpec.decode("23px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),}));
		
		JLabel lblNewLabel = new JLabel("Money:");
		frame.getContentPane().add(lblNewLabel, "6, 2, fill, top");
		
		JLabel lblNewLabel_1 = new JLabel("Season:");
		frame.getContentPane().add(lblNewLabel_1, "2, 2, left, top");
		
		JButton btnNewButton = new JButton("Market");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarketPage.main(null);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton, "2, 4, right, top");
		
		JButton btnNewButton_1 = new JButton("Stadium");
		frame.getContentPane().add(btnNewButton_1, "2, 6, right, top");
		
		JButton btnNewButton_2 = new JButton("Team/Inventory");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton_2, "2, 8, right, top");
		
		JButton btnNewButton_3 = new JButton("Rest");
		frame.getContentPane().add(btnNewButton_3, "4, 4, fill, top");
	}
}
