

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class NewP extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtfname;
	private JTextField txtmname;
	private JTextField txtAge;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFAddress;
	private JTextField txtmno;
	private JTextField txtemail;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnOthers;
	private JButton button;
	private JButton btnRegister;
	private Date date;
	private String name;
	private String fname;
	private String mname;
	private int age;
	private String address;
	private String mno;
	private String email;
	private String sex;
	private String bg;
	private String sym;
	private String suffer;
	private String cd;
	private String med;
	private int reg;
		
	private Connection myCon;
	private Statement myStmt;
	private ResultSet myRs;
	private PreparedStatement preparedStmt;
	
	private String din;
	private JTextField textBg;
	private JTextField textsuffer;
	private JTextArea textMed;
	private JTextArea textSym;
	private JComboBox<String> comboBoxDept;
	private JComboBox<String> comboBoxDoc;
	//private JComboBox<String> comboBox;
	//private JComboBox comboBox;
	private JTextField textField;
	private JTextField textField_1;
	
	private String selecteddoc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewP frame = new NewP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public NewP() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewP.class.getResource("/doctor_sign_old.jpg")));
		
		myCon = DriverManager.getConnection("jdbc:mysql://123.0.0.1:3306/inventory","root","pass");
		myStmt = myCon.createStatement();
		Date date = new Date();
		din = date.toString();
		initComponents();
		createEvents();
		
		
	}

	private void initComponents() {
		
		setTitle("[Registration FORM]   Shreyas Hospitals .......we garnish Lives");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(230, 80, 967, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JInternalFrame inttFr = new JInternalFrame("Medical Information");
		inttFr.setVisible(true);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 557, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(inttFr, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE)
						.addComponent(inttFr, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblBloodGroup = new JLabel("Blood Group :");
		
		textBg = new JTextField();
		textBg.setColumns(10);
		
		JLabel lblSymptomps = new JLabel("Symptomps :");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblSufferingFrom = new JLabel("Suffering From:");
		
		textsuffer = new JTextField();
		textsuffer.setColumns(10);
		
		JLabel lblMedicalHistory = new JLabel("Medical History :");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		comboBoxDept = new JComboBox();
		
		
		JLabel lblPhoto = new JLabel("New label");
		lblPhoto.setIcon(new ImageIcon(NewP.class.getResource("/hospital_2476209b.jpg")));
		
		comboBoxDoc = new JComboBox();
		comboBoxDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(inttFr.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblBloodGroup)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textBg, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSymptomps)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSufferingFrom)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textsuffer, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMedicalHistory)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblPhoto, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxDept, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxDoc, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBloodGroup)
						.addComponent(textBg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSymptomps)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSufferingFrom)
						.addComponent(textsuffer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMedicalHistory)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxDept, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxDoc, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(lblPhoto, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		textMed = new JTextArea();
		scrollPane_1.setViewportView(textMed);
		
		textSym = new JTextArea();
		scrollPane.setViewportView(textSym);
		inttFr.getContentPane().setLayout(groupLayout);
		
		JLabel lblNewPatient = new JLabel("~:  New Patient Registration Form  :~");
		lblNewPatient.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		
		JLabel lblName = new JLabel(" Full Name :");
		
		txtname = new JTextField();
		txtname.setColumns(10);
		
		JLabel lblDate = new JLabel("New label");
		
		JLabel lblFathersName = new JLabel("Father's Name :");
		
		txtfname = new JTextField();
		txtfname.setColumns(10);
		
		JLabel lblMothersName = new JLabel("Mother's Name :");
		
		txtmname = new JTextField();
		txtmname.setColumns(10);
		
		JLabel lblAge = new JLabel("Age :");
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex :");
		
		rdbtnMale = new JRadioButton("Male");
		
		rdbtnMale.setSelected(true);
		buttonGroup.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		
		rdbtnOthers = new JRadioButton("Others");
		buttonGroup.add(rdbtnOthers);
		
		JLabel lblAddress = new JLabel("Address :");
		
		textFAddress = new JTextField();
		textFAddress.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile No. :");
		
		txtmno = new JTextField();
		txtmno.setColumns(10);
		
		JLabel lblEmailAddress = new JLabel("e-mail address :");
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		
		JLabel lblwithoutStdCode = new JLabel("(without STD code)");
		
		btnRegister = new JButton("Register");
		
		button = new JButton("<~~ Back");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(356, Short.MAX_VALUE)
					.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(132))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblEmailAddress)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtemail, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
							.addGap(141))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblMobileNo)
								.addContainerGap())
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblAddress)
									.addContainerGap())
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblAge)
										.addContainerGap())
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblName)
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
													.addGroup(gl_panel.createSequentialGroup()
														.addGap(38)
														.addComponent(lblNewPatient)
														.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE))
													.addGroup(gl_panel.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtname, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))))
											.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
													.addComponent(lblMothersName)
													.addComponent(lblFathersName)
													.addGroup(gl_panel.createSequentialGroup()
														.addGap(20)
														.addComponent(button)))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
													.addComponent(txtfname, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
													.addGroup(gl_panel.createSequentialGroup()
														.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
														.addGap(42)
														.addComponent(lblSex)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(rdbtnMale)
														.addGap(18)
														.addComponent(rdbtnFemale)
														.addGap(18)
														.addComponent(rdbtnOthers))
													.addComponent(txtmname, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
													.addGroup(gl_panel.createSequentialGroup()
														.addComponent(txtmno, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblwithoutStdCode))
													.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
														.addComponent(btnRegister)
														.addComponent(textFAddress, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)))))
										.addGap(79)))))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewPatient)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDate)
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(txtname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFathersName)
						.addComponent(txtfname, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMothersName)
						.addComponent(txtmname, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAge)
						.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSex)
						.addComponent(rdbtnMale)
						.addComponent(rdbtnFemale)
						.addComponent(rdbtnOthers))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textFAddress, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddress))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(15)
							.addComponent(lblMobileNo))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtmno, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblwithoutStdCode))))
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmailAddress)
						.addComponent(txtemail, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegister)
						.addComponent(button))
					.addGap(36))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		comboBoxDept.addItem("Anaesthesiology and Critical Care");
		comboBoxDept.addItem("Cardiac Surgery");
		comboBoxDept.addItem("Cardiology");
		comboBoxDept.addItem("Dental Services");
		comboBoxDept.addItem("Cosmetology");
		comboBoxDept.addItem("Anaesthesiology & Critical care");	
		comboBoxDept.addItem("Cardiac Surgery");
		comboBoxDept.addItem("Cardiology");
		comboBoxDept.addItem("Dental Services (including Sub-specialties)");	
		comboBoxDept.addItem("Dermatology & Cosmetology");
		comboBoxDept.addItem("Diabetology");
		comboBoxDept.addItem("Emergency medical services");	
		comboBoxDept.addItem("ENT");
		comboBoxDept.addItem("Family medicine");
		comboBoxDept.addItem("Gastroentrology");
		comboBoxDept.addItem ("General & Laparoscopic surgery");
		comboBoxDept.addItem("Internal medicine");
		comboBoxDept.addItem("Laboratory Medicine");
		comboBoxDept.addItem("Minimally Invasive Thoracic Surgery");	
		comboBoxDept.addItem("Nephrology");
		comboBoxDept.addItem("Neuro Surgery");	
		comboBoxDept.addItem ("Neurology");
		comboBoxDept.addItem ("Nutririon & Dietetics");
		comboBoxDept.addItem ("Obstetrics and Gynecology");
		comboBoxDept.addItem ("Oncology");	
		comboBoxDept.addItem("Orthopaedic surgery & sports medicine");	
		comboBoxDept.addItem ("Paediatrics");
		comboBoxDept.addItem("Pathology");
		comboBoxDept.addItem("Physiotherapy");
		comboBoxDept.addItem("Plastic, Reconstructive, Microvascular & cosmetic Surgery");	
		comboBoxDept.addItem("Psychiatry");
		comboBoxDept.addItem ("Pulmonology & Critical Care");	
		comboBoxDept.addItem("Radiodiagonosis and Imaging");	
		comboBoxDept.addItem ("Rheumatology");	
		comboBoxDept.addItem("Urology");

		
	}

	private void createEvents() {
		
		comboBoxDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					String depart = (String) comboBoxDept.getSelectedItem();
					myRs = myStmt.executeQuery("select * from doctor where dept='"+depart+"' and status ='in'");
					while(myRs.next()){
						comboBoxDoc.addItem(myRs.getString("name"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				name = txtname.getText();
				fname = txtfname.getText();
				mname = txtmname.getText();
				age = Integer.parseInt(txtAge.getText());
				address = textFAddress.getText();
				email = txtemail.getText();
				mno = txtmno.getText();
				bg= textBg.getText();
				sym=textSym.getText();
				suffer=textsuffer.getText();
				cd=(String) comboBoxDept.getSelectedItem();
				med=textMed.getText();
				selecteddoc = (String) comboBoxDoc.getSelectedItem();
				
				if(rdbtnMale.isSelected())
					sex="Male";
				else if(rdbtnFemale.isSelected())
					sex="Female";
				else sex = "Others";
				
				
				String personal = "insert into patient (doe, name, fname, mname, age, sex, address, mno, email, bg, sym, suffer, cd, med, doc) values ('"+din+"', '"+name+"', '"+fname+"', '"+mname+"', '"+age+"', '"+sex+"', '"+address+"', '"+mno+"', '"+email+"', '"+bg+"', '"+sym+"', '"+suffer+"', '"+cd+"', '"+med+"', '"+selecteddoc+"')";
				try
				{
					myStmt.executeUpdate(personal);
					myRs=myStmt.executeQuery("select * from patient where name ='"+name+"'");
					while(myRs.next()){
						reg = myRs.getInt("Reg.no");
						}
					JOptionPane.showMessageDialog(null, "Registered Successfully !!\n Registration ID : "+reg);
				//	comboBoxDoc.
					RealHome.main(null);
					dispose();
				} catch (SQLException e) 
				{
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