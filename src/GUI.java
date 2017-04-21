import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//creates the gui and sets the size
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*creates the button group and the buttons. a button group means that only one
		can be pressed at once*/
		ButtonGroup difficulty = new ButtonGroup();
		JRadioButton rdbtnMild = new JRadioButton("Mild");		
		JRadioButton rdbtnModerate = new JRadioButton("Moderate");		
		JRadioButton rdbtnSpicy = new JRadioButton("Spicy");
		
		//adds all the buttons to the group
		difficulty.add(rdbtnMild);
		difficulty.add(rdbtnModerate);
		difficulty.add(rdbtnSpicy);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblDareRoulette = new JLabel("Dare Roulette");
		lblDareRoulette.setForeground(Color.BLACK);
		lblDareRoulette.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JRadioButton rdbtnAdult = new JRadioButton("Adult");
		
		JButton btnCreateDare = new JButton("Create Dare");
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JRadioButton rdbtnCustomDaresOnly = new JRadioButton("Custom Dares Only");
		
		JButton btnGenerateDare = new JButton("Generate Dare");
		btnGenerateDare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JTextPane txtpnDare = new JTextPane();
		txtpnDare.setBackground(Color.LIGHT_GRAY);
		txtpnDare.setText("No dare yet!");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnAdult)
								.addComponent(lblOptions, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnSpicy)
								.addComponent(lblDifficulty)
								.addComponent(rdbtnMild)
								.addComponent(rdbtnModerate)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnReset, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnCreateDare, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(rdbtnCustomDaresOnly, Alignment.LEADING)))
							.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(txtpnDare, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
									.addGap(52))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(btnGenerateDare)
									.addGap(94))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(108)
							.addComponent(lblDareRoulette)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(lblDifficulty)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnMild)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnModerate)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnSpicy)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblOptions)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnAdult)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnCustomDaresOnly)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCreateDare)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReset))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDareRoulette)
							.addGap(17)
							.addComponent(btnGenerateDare)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtpnDare, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
