import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUI {

	private JFrame frame;
	private String customDare;
	Sound bang, click;
	DareRoulette dR;

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
		dR = new DareRoulette(false, 1);
		bang = new Sound("resources/shot.wav",false,0f);
		click = new Sound("resources/click.wav",false,0f);
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
		//mild is the default selection
		rdbtnMild.setSelected(true);
		rdbtnMild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dR.setDifficulty(1);
				System.out.println(dR.getDifficulty());
			}
		});
		JRadioButton rdbtnModerate = new JRadioButton("Moderate");		
		rdbtnModerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dR.setDifficulty(2);
				System.out.println(dR.getDifficulty());
			}
		});
		JRadioButton rdbtnSpicy = new JRadioButton("Spicy");
		rdbtnSpicy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dR.setDifficulty(3);
				System.out.println(dR.getDifficulty());
			}
		});
		
		//adds all the buttons to the group
		difficulty.add(rdbtnMild);
		difficulty.add(rdbtnModerate);
		difficulty.add(rdbtnSpicy);
		
		//difficulty label
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		//main header label "dare roulette"
		JLabel lblDareRoulette = new JLabel("Dare Roulette");
		lblDareRoulette.setForeground(Color.BLACK);
		lblDareRoulette.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		//options label
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		//when they press the adult button, it changes the setting of the game
		JRadioButton rdbtnAdult = new JRadioButton("Adult");
		rdbtnAdult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dR.setAdult(!dR.isAdult());
			}
		});
		
		//allows you to create a custom dare
		JButton btnCreateDare = new JButton("Create Dare");
		btnCreateDare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String o = JOptionPane.showInputDialog("Come up with a dare!");
				dR.customDare(o);
			}
		});
		
		//allows you to set the game to be in or not in custom mode
		JRadioButton rdbtnCustomDaresOnly = new JRadioButton("Custom Dares Only");
		rdbtnCustomDaresOnly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dR.setCustom(!dR.isCustom());	
				System.out.println(dR.isCustom());
			}
		});
		
		//resets all settings
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dR.reset();
				rdbtnAdult.setSelected(false);
				rdbtnMild.setSelected(true);
				rdbtnCustomDaresOnly.setSelected(false);
			}
		});
		
		//creates the text pane where dares will be displayed
		JTextPane txtpnDare = new JTextPane();
		txtpnDare.setBackground(Color.LIGHT_GRAY);
		txtpnDare.setText("No dare yet!");
		
		//allows you to generate a dare based on the settings selected in the game
		JButton btnGenerateDare = new JButton("Generate Dare");
		btnGenerateDare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dare current = dR.retrieveDare();
				if (current == null) {
					txtpnDare.setText("You can't use only custom dares if you haven't created any!"
							+ "Click the 'Create Dare' button to start making up dares!");
				} else {
					//now time to determine if the dare gets returned
					Random rand = new Random();
					int probability = current.getDifficulty() + 1;
					if(rand.nextInt(probability) == 0){
						bang.playSound();
						txtpnDare.setText(current.getPhrase());
					}
					else{
						click.playSound();
						txtpnDare.setText("No dare returned...you got lucky!");
					}
				}
			}
		});
		
		/* I don't know what this stuff is, it's automatically generated. looks smart tho.
		It seems to create the layout */
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
