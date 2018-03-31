import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class DrPort extends JFrame {

	private JPanel contentPane;
	private JButton btnChangePassword;
	
	private Connection myCon;
	private Statement myStmt;
	private ResultSet myRs;
	private ResultSet myR;
	private PreparedStatement preparedStmt;
	private JMenuBar menuBar;
	private JMenu mnStatus;
	private JMenuItem mntmDictorIn;
	private JMenuItem mntmDoctorOut;
	private String yeh;
	private JMenuItem mntmExit;
	private JTable table;
	private JMenuItem mntmRefresh;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DrPort(String a) throws SQLException{
		setTitle("[Doctor's PORTAL] Shreyas Hospitals .......we garnish Lives..");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DrPort.class.getResource("/doctor_sign_old.jpg")));
		setVisible(true);
		myCon = DriverManager.getConnection("jdbc:mysql://123.0.0.1:3306/inventory","root","pass");
		myStmt = myCon.createStatement();
		initComponents(a);
		createEvents(a);
	}

	private void initComponents(String a) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 505);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnStatus = new JMenu("Status");
		menuBar.add(mnStatus);
		
		mntmDictorIn = new JMenuItem("Dictor IN");
		
		mnStatus.add(mntmDictorIn);
		
		mntmDoctorOut = new JMenuItem("Doctor Out");
		mnStatus.add(mntmDoctorOut);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnStatus.add(mntmExit);
		
		mntmRefresh = new JMenuItem("Refresh");
		mntmRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DrPort dr =new DrPort(a);
					dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		menuBar.add(mntmRefresh);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPatientList = new JLabel(" Patient List");
		lblPatientList.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		
		btnChangePassword = new JButton("Change Password");
		
		btnChangePassword.setIcon(new ImageIcon(DrPort.class.getResource("/emblem_system.png")));

		try {
			
			preparedStmt = myCon.prepareStatement("select name from doctor where username =?");
			preparedStmt.setString(1, a );
			myRs = preparedStmt.executeQuery();
			while(myRs.next())
			yeh = myRs.getString("name");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JScrollPane scrollPane =  new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(btnChangePassword, GroupLayout.DEFAULT_SIZE, 1126, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1126, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(523, Short.MAX_VALUE)
					.addComponent(lblPatientList, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(481))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(btnChangePassword, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPatientList)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		try{
			myRs=myStmt.executeQuery("select * from patient where doc='"+yeh+"'");
			table.setModel(DbUtils.resultSetToTableModel(myRs));
			
		}catch(SQLException el) {
			el.printStackTrace();
		}
		
		
	}

	private void createEvents(String a) {
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String newuser;
				String user= JOptionPane.showInputDialog("Enter the existing password :");
				if (user.compareToIgnoreCase(a)==0){
					
					newuser= JOptionPane.showInputDialog("Enter the new password :");
					try {
							preparedStmt=myCon.prepareStatement("update doctor set username=? where username=?");
							preparedStmt.setString   (1, newuser);
						    preparedStmt.setString(2, user);
						    preparedStmt.executeUpdate();
						  	JOptionPane.showMessageDialog(null, "Password Updated Successfully !!");
						
						
					} catch (SQLException e) {
							e.printStackTrace();
					}
				}	
			}
		});
		
		mntmDictorIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					preparedStmt=myCon.prepareStatement("update doctor set status=? where username=?");
					preparedStmt.setString   (1, "in");
				    preparedStmt.setString(2, a);
				    preparedStmt.executeUpdate();
			
				} catch (SQLException e1) {
					e1.printStackTrace();
			}
			}
		});
		
		mntmDoctorOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					preparedStmt=myCon.prepareStatement("update doctor set status=? where username=?");
					preparedStmt.setString   (1, "out");
				    preparedStmt.setString(2, a);
				    preparedStmt.executeUpdate();
			
				} catch (SQLException e1) {
					e1.printStackTrace();
			}
			}
		});
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Log_In.main(null);
				dispose();
			}
		});
		
		
		
		
	}
}
