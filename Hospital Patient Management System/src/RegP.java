import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class RegP extends JFrame {

	private JPanel contentPane;
	private JTextField textRegNo;
	private JTable table;
	private JButton btnSearch;
	private JButton btnDocBook;
	private JButton button;
	
	private Connection myCon;
	private Statement myStmt;
	private ResultSet myRs;
	private PreparedStatement preparedStmt;
	
	private int reg;
	private JLabel lblPatientRegisteredName;
	private JTextField textName;
	private String nme;
	private String newdoc;
	private String st;
	private String prevdoc;
	private String depart;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegP frame = new RegP();
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
	public RegP() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegP.class.getResource("/Flag_of_the_Red_Cross.svg.png")));
		
		try {
			myCon = DriverManager.getConnection("jdbc:mysql://123.0.0.1:3306/inventory","root","pass");
			myStmt = myCon.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initComponents();
		createEvents();
		
	}

	private void initComponents() {
		
		setTitle("[Registered Patient]    Shreyas Hospitals .......we garnish Lives");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(110, 100, 1115, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterRegistrationNumber = new JLabel("Enter Registration Number :");
		
		textRegNo = new JTextField();
		textRegNo.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnSearch = new JButton("Search");
		
		btnDocBook = new JButton("");
		
		btnDocBook.setIcon(new ImageIcon(RegP.class.getResource("/logo_doctorsbooking - Copy.PNG")));
		
		button = new JButton("<~~ Back");
		
		lblPatientRegisteredName = new JLabel("Patient Registered Name :");
		
		textName = new JTextField();
		textName.setColumns(10);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEnterRegistrationNumber)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textRegNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblPatientRegisteredName)
					.addGap(18)
					.addComponent(textName, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(btnSearch)
					.addContainerGap(176, Short.MAX_VALUE))
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(button)
					.addGap(484)
					.addComponent(btnDocBook, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterRegistrationNumber)
						.addComponent(textRegNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPatientRegisteredName)
						.addComponent(btnSearch))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDocBook, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(button)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
	}

	private void createEvents() {
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nme = textName.getText();
				
				try {
					myRs=myStmt.executeQuery("select * from patient where name='"+nme+"'");
					table.setModel(DbUtils.resultSetToTableModel(myRs));
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnDocBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					myRs=myStmt.executeQuery("select cd from patient where name='"+nme+"'");
					while(myRs.next())
						depart = myRs.getString("cd");
					myRs=myStmt.executeQuery("select name from doctor where dept='"+depart+"' and status='in'");
					while(myRs.next())
						newdoc = myRs.getString("name");
					
					if(newdoc.compareTo("")!=0){
						JOptionPane.showMessageDialog(null, "Appointment Confirmed to"+newdoc);
						myStmt.executeUpdate("update patient set doc='"+newdoc+"' where name='"+nme+"'");
						
					}
					else{
						JOptionPane.showMessageDialog(null, "No Doctors available!!");
					}
					/*
					myRs=myStmt.executeQuery("select * from patient where name='"+nme+"'");
					while(myRs.next())
						prevdoc = myRs.getString("doc");
					/*System.out.println(prevdoc);
					if(prevdoc.compareToIgnoreCase("")==0){
						System.out.println(prevdoc);
						
						myRs=myStmt.executeQuery("select cd from patient where name='"+nme+"'");
						while(myRs.next())
							depart = myRs.getString("cd");
						myRs=myStmt.executeQuery("select name from doctor where dept='"+depart+"' and status='in'");
						while(myRs.next())
							newdoc = myRs.getString("name");
						
						if(newdoc.compareTo("")==0){
							JOptionPane.showMessageDialog(null, "No Doctors available!!");
						}
						else
						JOptionPane.showMessageDialog(null, "Appointment Confirmed to"+newdoc);
						
						
					}
					//else
					{
					myRs=myStmt.executeQuery("select status from doctor where name='"+prevdoc+"'");
					while(myRs.next())
						st = myRs.getString("status");
					if(st.compareTo("in")==0){
						JOptionPane.showMessageDialog(null, "Appointment Confirmed to"+prevdoc);
					}
					else{
						
						myRs=myStmt.executeQuery("select dept from doctor where name='"+prevdoc+"'");
						while(myRs.next())
							depart = myRs.getString("dept");
						myRs=myStmt.executeQuery("select name from doctor where dept='"+depart+"' and status='in'");
						while(myRs.next())
							newdoc = myRs.getString("name");
						
						if(newdoc.compareTo("")==0){
							JOptionPane.showMessageDialog(null, "No Doctors available!!");
						}
						else
						JOptionPane.showMessageDialog(null, "Appointment Confirmed to"+newdoc);
						
					}
			}*/
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RealHome.main(null);
				dispose();
			}
		});
		
		
	}
}
