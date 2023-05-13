import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class SetupPage {

	private JFrame frame;
	private JTextField txtTeamNameHere;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupPage window = new SetupPage();
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
	public SetupPage() {
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
				ColumnSpec.decode("114px"),
				ColumnSpec.decode("147px"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				RowSpec.decode("53px"),
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("26px"),
				RowSpec.decode("58px"),
				RowSpec.decode("23px"),}));

		JLabel lblNewLabel = new JLabel("Game Setup");
		frame.getContentPane().add(lblNewLabel, "2, 2, center, top");

		txtTeamNameHere = new JTextField();
		txtTeamNameHere.setText("team name here");
		frame.getContentPane().add(txtTeamNameHere, "2, 4, fill, top");
		txtTeamNameHere.setColumns(10);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton, "2, 8, center, top");

		JSlider slider = new JSlider();
		slider.setMaximum(25);
		frame.getContentPane().add(slider, "2, 6, fill, top");
	}
}
