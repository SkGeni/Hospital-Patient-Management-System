import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class DocA extends JFrame {

	private JPanel contentPane;
	private JInternalFrame internalFrame;
	private JComboBox<String> comboBox;
	
	private Connection myCon;
	private Statement myStmt;
	private ResultSet myRs;
	private String depart;
	int i;
	private JButton btnNewButton;
	private JTable table;
	private PreparedStatement preparedStmt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocA frame = new DocA();
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
	public DocA() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DocA.class.getResource("/Flag_of_the_Red_Cross.svg.png")));
		
		
		try {
			myCon = DriverManager.getConnection("jdbc:mysql://123.0.0.1:3306/inventory","root","pass");
			myStmt = myCon.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setTitle("[Doctors IN] Shreyas Hospitals .......we garnish Lives..");
		
		initComponents();
		createEvents();
		
	}

	private void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(460, 100, 485, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		internalFrame = new JInternalFrame("Select Department");
		internalFrame.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		internalFrame.setVisible(true);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(internalFrame, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(internalFrame, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
		);
		
		comboBox = new JComboBox<String>();
		
		btnNewButton = new JButton("<~~ Back");
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout groupLayout = new GroupLayout(internalFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		internalFrame.getContentPane().setLayout(groupLayout);
		contentPane.setLayout(gl_contentPane);
		
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
				
	}

	private void createEvents() {

		comboBox.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				String selected =(String) comboBox.getSelectedItem();

				try {
					myRs = myStmt.executeQuery("select * from doctor where dept ='"+selected+"'");
					table.setModel(DbUtils.resultSetToTableModel(myRs));
					
					
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RealHome.main(null);
				dispose();
			}
		});


	}
}
