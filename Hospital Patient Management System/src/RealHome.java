import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class RealHome extends JFrame {

	private JPanel contentPane;
	private AbstractButton btnDocAva;
	private AbstractButton btnNewPatient;
	private AbstractButton btnRegisteredPatients;
	private AbstractButton btnSignOut;
	private JButton btnTimeTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealHome frame = new RealHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RealHome() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RealHome.class.getResource("/hospital_2476209b.jpg")));
		
		initComponents();
		createEvents();
		
			}

	private void initComponents() {

		setTitle("[HOME] Shreyas Hospitals .......we garnish Lives..");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 120, 535, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JInternalFrame internalFrame = new JInternalFrame("Welcome");
		contentPane.add(internalFrame, BorderLayout.CENTER);

		btnDocAva = new JButton("Doctor's Availability");
		
		btnNewPatient = new JButton("New Patients");
		

		btnRegisteredPatients = new JButton("Registered Patients");
		
		btnSignOut = new JButton("Sign Out");
		
		btnSignOut.setFont(new Font("SimSun-ExtB", Font.PLAIN, 11));
		
		btnTimeTable = new JButton("Time - Table and Rules");
		
		GroupLayout groupLayout = new GroupLayout(internalFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSignOut))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewPatient, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
								.addComponent(btnDocAva, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
								.addComponent(btnRegisteredPatients, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
								.addComponent(btnTimeTable, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE))))
					.addGap(64))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(btnDocAva, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewPatient, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRegisteredPatients, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnTimeTable, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(btnSignOut, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addContainerGap())
		);
		internalFrame.getContentPane().setLayout(groupLayout);
		internalFrame.setVisible(true);


	}

	private void createEvents() {
		
		btnDocAva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DocA.main(null);
				dispose();
			}
		});
		
		btnNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewP.main(null);
				dispose();
			}
		});
		
		btnRegisteredPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegP.main(null);
				dispose();
			}
		});

		
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Log_In.main(null);
				dispose();
			}
		});
		
		btnTimeTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TtRules.main(null);
				dispose();
			}
		});
		
		
	}
}
