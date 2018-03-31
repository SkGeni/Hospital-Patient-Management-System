import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddDoc extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDoc frame = new AddDoc();
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
	public AddDoc() {
		setResizable(false);
		setTitle("[Doctor's Registration]   Shreyas Hospitals .......we garnish Lives");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblName = new JLabel("Name :");
		
		JLabel lblNewLabel = new JLabel("Department :");
		
		JLabel lblUsername = new JLabel("Username :");
		
		textName = new JTextField();
		textName.setColumns(10);
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox();
		
		comboBox.addItem("Anaesthesiology and Critical Care");
		comboBox.addItem("Cardiac Surgery");
		comboBox.addItem("Cardiology");
		comboBox.addItem("Dental Services");
		comboBox.addItem("Cosmetology");
		comboBox.addItem("Anaesthesiology & Critical care");	
		comboBox.addItem("Cardiac Surgery");
		comboBox.addItem("Cardiology");
		comboBox.addItem("Dental Services (including Sub-specialties)");	
		comboBox.addItem("Dermatology & Cosmetology");
		comboBox.addItem("Diabetology");
		comboBox.addItem("Emergency medical services");	
		comboBox.addItem("ENT");
		comboBox.addItem("Family medicine");
		comboBox.addItem("Gastroentrology");
		comboBox.addItem ("General & Laparoscopic surgery");
		comboBox.addItem("Internal medicine");
		comboBox.addItem("Laboratory Medicine");
		comboBox.addItem("Minimally Invasive Thoracic Surgery");	
		comboBox.addItem("Nephrology");
		comboBox.addItem("Neuro Surgery");	
		comboBox.addItem ("Neurology");
		comboBox.addItem ("Nutririon & Dietetics");
		comboBox.addItem ("Obstetrics and Gynecology");
		comboBox.addItem ("Oncology");	
		comboBox.addItem("Orthopaedic surgery & sports medicine");	
		comboBox.addItem ("Paediatrics");
		comboBox.addItem("Pathology");
		comboBox.addItem("Physiotherapy");
		comboBox.addItem("Plastic, Reconstructive, Microvascular & cosmetic Surgery");	
		comboBox.addItem("Psychiatry");
		comboBox.addItem ("Pulmonology & Critical Care");	
		comboBox.addItem("Radiodiagonosis and Imaging");	
		comboBox.addItem ("Rheumatology");	
		comboBox.addItem("Urology");

		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			private Connection myCon;
			private Statement myStmt;
			private ResultSet myRs;

			public void actionPerformed(ActionEvent arg0) {
				String selected = (String) comboBox.getSelectedItem();
				String nme = textName.getText();
				String unme = textUsername.getText();
				try {
					
					myCon = DriverManager.getConnection("jdbc:mysql://123.0.0.1:3306/inventory","root","pass");
					myStmt = myCon.createStatement();
					myStmt.executeUpdate("insert into doctor (name, dept, username) values ('"+nme+"', '"+selected+"', '"+unme+"')");
					AdminSec.main(null);
					dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
				
			}
		});
		
		JButton button = new JButton("<~~ Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminSec.main(null);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblName)
								.addComponent(lblUsername)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(button)))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textUsername)
							.addComponent(textName, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnRegister)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)))
					.addGap(29))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(textName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(lblUsername))
								.addComponent(textUsername, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegister)
						.addComponent(button))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
