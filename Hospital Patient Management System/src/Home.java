import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.ComponentOrientation;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;

public class Home extends RealHome {

	private JPanel contentPane;
	JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/doctor_sign_old.jpg")));
		
		initComponents();
		createEvents();
		
	}
	
private void initComponents() {
		
		setTitle("[HOME] Shreyas Hospitals .......we garnish Lives..");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 100, 592, 449);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{566, 0};
		gbl_contentPane.rowHeights = new int[]{401, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel_1 = new JLabel("");
		
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/SDOH-Vital-Sign.jpg")));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

	}
	

	private void createEvents() {
	
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RealHome.main(null);
				dispose();
			}
		});
		
	}
}
