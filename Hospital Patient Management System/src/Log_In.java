
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import org.omg.CORBA.SystemException;

import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Log_In extends Home 
{
	private JTextField tFuser;
	private JPasswordField pFpass;
	private JButton btnLogin;
	private JButton btnAdminLogin;
	private JInternalFrame internalFrame;
	GroupLayout groupLayout_1;
	private JButton btnDoctorsPortal;
	
	private Connection myCon;
	private Statement myStmt;
	private int loginfo;
	private ResultSet myRs;
	private String pass;
	private String user;
		
	//public SP_Inventory_Control frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Log_In frame = new Log_In();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Log_In() throws Exception
	{	
		myCon = DriverManager.getConnection("jdbc:mysql://123.0.0.1:3306/inventory","root","pass");
		myStmt = myCon.createStatement();
		
		setResizable(false);
		initComponents(0);
		createEvents();		
	}
	//////////////////////////////////////////////////////////////////////////////////
	//Initializing Components.......
	///////////////////////////////////////////////////////////////////////////////// 
	
	private void initComponents(int x) {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 200, 530, 295);
		setTitle("Shreyas Hospitals .......we garnish Lives");
		
		loginfo=x;
		if(loginfo==0){
			internalFrame = new JInternalFrame("Staff Login *****");
			btnAdminLogin = new JButton("Admin Login");
			user = "Staff";
			try {
				
				myRs = myStmt.executeQuery("select hospital from passwords where type = 2");
				while(myRs.next())
				pass = myRs.getString("hospital");
								
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			
			
		}else if (loginfo==1){
			internalFrame = new JInternalFrame("Admin Login *****");
			btnAdminLogin = new JButton("Exit");
			user = "admin";
			try {
				
				myRs = myStmt.executeQuery("select hospital from passwords where type = 1");
				while(myRs.next())
				pass = myRs.getString("hospital");
								
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else{
			
			internalFrame = new JInternalFrame("Doctor's Portal *****");
			btnDoctorsPortal.setVisible(false);
				
		}
		
		
		internalFrame.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		internalFrame.setVisible(true);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(internalFrame, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(internalFrame, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
		);
		
		JLabel lblUsername = new JLabel("Username :");
		
		JLabel lblPassword = new JLabel("Password : ");
		
		tFuser = new JTextField();
		tFuser.setColumns(10);
		pFpass = new JPasswordField();
		
		btnLogin = new JButton("Sign In");
		

		btnDoctorsPortal = new JButton("Doctor's Portal");
		
	
		
		groupLayout_1 = new GroupLayout(internalFrame.getContentPane());
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addGroup(groupLayout_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGap(108)
							.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPassword)
								.addGroup(groupLayout_1.createSequentialGroup()
									.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(2)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(pFpass, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
								.addComponent(tFuser, 224, 224, 224)))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnDoctorsPortal)
							.addGap(18)
							.addComponent(btnAdminLogin)
							.addGap(50)))
					.addGap(10)
					.addComponent(btnLogin)
					.addGap(18))
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addGap(66)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tFuser, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(pFpass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnDoctorsPortal)
						.addComponent(btnAdminLogin))
					.addGap(54))
		);
		internalFrame.getContentPane().setLayout(groupLayout_1);
		getContentPane().setLayout(groupLayout);

	}
	
	///////////////////////////////////////////////////////////////////////////////////
	
	/////////////////////////////////////////////////////////////////////////////////////
	private void createEvents() {
		// TODO Auto-generated method stub
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				if(((tFuser.getText()).compareToIgnoreCase(user) == 0)&&((pFpass.getText()).compareToIgnoreCase(pass) == 0)){
				Home.main(null);
					dispose();
				}
			
				else {
				tFuser.setText("Oop!! Enter username correctly!!");
				}
				}
		});
		
		
		
		
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				loginfo = 1;
				internalFrame.dispose();
				initComponents(loginfo);
				createEventsAdmin();
			}
		});
		
		btnDoctorsPortal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
			
				loginfo = 2;
				internalFrame.dispose();
				initComponents(loginfo);
							
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {				
						String duser =tFuser.getText();
						String dpass =pFpass.getText();
						
						try {
							int count = 0;
							
							myRs = myStmt.executeQuery("select * from doctor");
							while(myRs.next()){
								if((duser.compareToIgnoreCase(myRs.getString("username")) == 0)&&(dpass).compareToIgnoreCase(myRs.getString("username")) == 0){
									DrPort call = new DrPort(duser);
								//	DrPort.main(null);
									dispose();
									count =1;
									}
							}
							if(count == 0)
									tFuser.setText("Oop!! Enter username correctly!!");
											
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		
		
		
	}
	
	private void createEventsAdmin() {
		// TODO Auto-generated method stub
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				if(((tFuser.getText()).compareToIgnoreCase(user) == 0)&&((pFpass.getText()).compareToIgnoreCase(pass) == 0)){
					int response= JOptionPane.showConfirmDialog(null, "Do you want to change Staff Login?");
					if(response==0){
						
						String newpass = JOptionPane.showInputDialog("Enter the new Password for Staff.");
						try {
							myStmt.executeUpdate("update passwords set hospital ='"+newpass+"' where type = 2");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					AdminSec.main(null);
					dispose();
				}
			
				else {
				tFuser.setText("Oop!! Enter username correctly!!");
				}
				}
		});
		
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				JOptionPane.showMessageDialog(null, "Good Day !!");	
				dispose();
					
				}
		});
		
		btnDoctorsPortal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	

				loginfo = 2;
				internalFrame.dispose();
				initComponents(loginfo);
		}
	});
	
	}
	
	
}
