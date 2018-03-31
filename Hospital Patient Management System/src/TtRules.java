import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TtRules extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TtRules frame = new TtRules();
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
	public TtRules() {
		setTitle("[Timmings $$ Rules ] Shreyas Hospitals .......we garnish Lives..");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TtRules.class.getResource("/Flag_of_the_Red_Cross.svg.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 951, 476);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnExit = new JMenu("Exit");
		menuBar.add(mnExit);
		
		JMenuItem menuItem = new JMenuItem("<~~ Back");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RealHome.main(null);
				dispose();
			}
		});
		mnExit.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TtRules.class.getResource("/doctor_sign_old.jpg")));
		
		JInternalFrame internalFrame = new JInternalFrame("Timmings");
		internalFrame.setVisible(true);
		
		JInternalFrame internalFrame_1 = new JInternalFrame("Rules to be followed..");
		internalFrame_1.setVisible(true);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(internalFrame, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
						.addComponent(internalFrame_1, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(internalFrame, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(internalFrame_1, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblKeepTheSurrounding = new JLabel("Keep the Surrounding CLEAN and GREEN !!");
		lblKeepTheSurrounding.setFont(new Font("Viner Hand ITC", Font.PLAIN, 17));
		
		JLabel lblGreenerTheSurrounding = new JLabel("Greener the Surrounding Greener is our LIFE...");
		lblGreenerTheSurrounding.setFont(new Font("Viner Hand ITC", Font.PLAIN, 17));
		
		JLabel lblDontMakeNoise = new JLabel("Don't make NOISE");
		lblDontMakeNoise.setFont(new Font("Viner Hand ITC", Font.PLAIN, 17));
		
		JLabel lblPunctualityIsThe = new JLabel("Punctuality is the key to Success.");
		lblPunctualityIsThe.setFont(new Font("Viner Hand ITC", Font.PLAIN, 18));
		GroupLayout groupLayout_1 = new GroupLayout(internalFrame_1.getContentPane());
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap(66, Short.MAX_VALUE)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout_1.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout_1.createSequentialGroup()
								.addGroup(groupLayout_1.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblGreenerTheSurrounding, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblKeepTheSurrounding, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE))
								.addGap(28))
							.addGroup(groupLayout_1.createSequentialGroup()
								.addComponent(lblDontMakeNoise, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
								.addGap(146)))
						.addGroup(Alignment.TRAILING, groupLayout_1.createSequentialGroup()
							.addComponent(lblPunctualityIsThe, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
							.addGap(77))))
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addGap(23)
					.addComponent(lblKeepTheSurrounding, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblGreenerTheSurrounding)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDontMakeNoise, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblPunctualityIsThe, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		internalFrame_1.getContentPane().setLayout(groupLayout_1);
		
		JLabel lblCasualityDepartment = new JLabel("Casuality Department :");
		
		JLabel lblAmTo = new JLabel("7:00 AM to 11:30 PM");
		
		JLabel lblOtDepartment = new JLabel("OT Department :");
		
		JLabel lblAmTo_1 = new JLabel("7:30 AM to 10:00 PM (whenever needed)");
		
		JLabel lblEmergencyDepartment = new JLabel("Emergency Department :");
		
		JLabel lblx = new JLabel("24x7 ");
		
		JLabel lblEmergencyPhoneNo = new JLabel("Emergency Phone No. :");
		
		JLabel lbltollfree = new JLabel("191 (toll-free)");
		
		JLabel lblDontEverBe = new JLabel("Don't EVER be time specific to SAVE Life.....");
		lblDontEverBe.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 24));
		GroupLayout groupLayout = new GroupLayout(internalFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCasualityDepartment)
								.addComponent(lblOtDepartment))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAmTo)
								.addComponent(lblAmTo_1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEmergencyDepartment)
								.addComponent(lblEmergencyPhoneNo))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbltollfree)
								.addComponent(lblx, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblDontEverBe, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCasualityDepartment, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAmTo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOtDepartment)
						.addComponent(lblAmTo_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmergencyDepartment)
						.addComponent(lblx, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmergencyPhoneNo)
						.addComponent(lbltollfree))
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addComponent(lblDontEverBe, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		internalFrame.getContentPane().setLayout(groupLayout);
		contentPane.setLayout(gl_contentPane);
	}
}