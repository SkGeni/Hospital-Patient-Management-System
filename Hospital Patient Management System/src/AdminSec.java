import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;



public class AdminSec extends JFrame {

	private JPanel contentPane;
	private Connection myCon;
	private Statement myStmt;
	private ResultSet myRs;
	private JTable table;
	private int sel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSec frame = new AdminSec();
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
	public AdminSec() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminSec.class.getResource("/emblem_system.png")));
		
		try {
			myCon = DriverManager.getConnection("jdbc:mysql://123.0.0.1:3306/inventory","root","pass");
			myStmt = myCon.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		setTitle("[Admin Portal]   Shreyas Hospitals .......we garnish Lives");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 938, 526);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSignOut = new JMenuItem("Sign Out");
		mntmSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Log_In.main(null);
				dispose();
			}
		});
		
		JMenuItem mntmAddDoctor = new JMenuItem("Add Doctor");
		mntmAddDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddDoc.main(null);
				
			}
		});
		mnFile.add(mntmAddDoctor);
		
		JMenuItem mntmRemoveDoctor = new JMenuItem("Remove Doctor");
		mntmRemoveDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String remdoc = JOptionPane.showInputDialog("Enter the name of the doctor :");
				try {
					myStmt.executeUpdate("delete from doctor where name ='"+remdoc+"'");
					JOptionPane.showMessageDialog(null, remdoc+" fired Out!!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		mnFile.add(mntmRemoveDoctor);
		mnFile.add(mntmSignOut);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminSec.class.getResource("/admin_login.gif")));
		
		JComboBox<String> comboBox = new JComboBox();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addComponent(comboBox, 0, 889, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
					.addGap(0))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(338, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
					.addGap(250))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
		);
		
		contentPane.setLayout(gl_contentPane);
		comboBox.addItem("Select Information");
		comboBox.addItem("Patient's Information");
		comboBox.addItem("Doctor's Information");
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sel = comboBox.getSelectedIndex();
		
		if (sel==1){
			try{
				myRs=myStmt.executeQuery("select * from patient");
				table = new JTable();
				scrollPane.setViewportView(table);
				
				table.setModel(DbUtils.resultSetToTableModel(myRs));
				
				
			}catch(SQLException el) {
				el.printStackTrace();
			}
			
		}
		else if(sel==2){
			
			try{
		//		table.dis
				myRs=myStmt.executeQuery("select * from doctor");
				table = new JTable();
				scrollPane.setViewportView(table);
				
				table.setModel(DbUtils.resultSetToTableModel(myRs));
				
			}catch(SQLException el) {
				el.printStackTrace();
			}
			
		}
	}
		});		
	}
}

