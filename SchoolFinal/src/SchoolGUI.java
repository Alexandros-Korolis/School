import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class SchoolGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitle;
	private JTextField textFieldFname;
	private JTextField textFieldLname;
	private JTextField textFieldBirth;
	private JTextField textFieldGender;
	private JTextField textFieldAddress;
	private JTextField textFieldFnameGr;
	private JTextField textFieldCourseGr;
	private JTextField textFieldGrade;
	private JTextField textFieldLnameGr;
	private JTextField textFieldFnameSearch;
	private JTextField textFieldLnameSearch;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchoolGUI frame = new SchoolGUI();
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
	public SchoolGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(155, 91, 5, 5);
		contentPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(140, 91, 5, 5);
		contentPane.add(tabbedPane_1);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(10, 0, 714, 490);
		contentPane.add(tabbedPane_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_2.addTab("Καταχώρηση μαθημάτων", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Τιτλος μαθήματος :");
		lblNewLabel.setBounds(27, 39, 148, 13);
		panel_1.add(lblNewLabel);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(182, 36, 96, 19);
		panel_1.add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		JButton btnTitleSave = new JButton("Save");
		btnTitleSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String title = textFieldTitle.getText();
				
				Course course = new Course(title);
				
				course.save();
			}
		});
		btnTitleSave.setBounds(182, 95, 96, 21);
		panel_1.add(btnTitleSave);
		
		JPanel panel = new JPanel();
		tabbedPane_2.addTab("Καταχώρηση μαθητών", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Όνομα :");
		lblNewLabel_1.setBounds(33, 31, 93, 13);
		panel.add(lblNewLabel_1);
		
		textFieldFname = new JTextField();
		textFieldFname.setBounds(211, 28, 96, 19);
		panel.add(textFieldFname);
		textFieldFname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Επίθετο :");
		lblNewLabel_2.setBounds(33, 68, 135, 13);
		panel.add(lblNewLabel_2);
		
		textFieldLname = new JTextField();
		textFieldLname.setBounds(211, 65, 96, 19);
		panel.add(textFieldLname);
		textFieldLname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ημε/νια Γέννησης :");
		lblNewLabel_3.setBounds(33, 108, 125, 13);
		panel.add(lblNewLabel_3);
		
		textFieldBirth = new JTextField();
		textFieldBirth.setBounds(211, 105, 96, 19);
		panel.add(textFieldBirth);
		textFieldBirth.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Φύλο :");
		lblNewLabel_4.setBounds(35, 149, 133, 13);
		panel.add(lblNewLabel_4);
		
		textFieldGender = new JTextField();
		textFieldGender.setBounds(211, 146, 96, 19);
		panel.add(textFieldGender);
		textFieldGender.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Διεύθυνση :");
		lblNewLabel_5.setBounds(33, 189, 145, 13);
		panel.add(lblNewLabel_5);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(211, 186, 96, 19);
		panel.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		JButton btnSaveStudent = new JButton("Save");
		btnSaveStudent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String onoma = textFieldFname.getText();
				String eponimo = textFieldLname.getText();
				String birthDate = textFieldBirth.getText();
				String gender = textFieldGender.getText();
				String address = textFieldAddress.getText();
				
				Student student = new Student(onoma,eponimo,birthDate,gender,address);
				student.saveStudent();
				
			}
		});
		btnSaveStudent.setBounds(211, 245, 96, 21);
		panel.add(btnSaveStudent);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_2.addTab("Καταχώρηση βαθμών", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Όνομα Μαθητή :");
		lblNewLabel_6.setBounds(33, 36, 114, 13);
		panel_2.add(lblNewLabel_6);
		
		textFieldFnameGr = new JTextField();
		textFieldFnameGr.setBounds(157, 33, 96, 19);
		panel_2.add(textFieldFnameGr);
		textFieldFnameGr.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Μάθημα :");
		lblNewLabel_7.setBounds(33, 107, 115, 13);
		panel_2.add(lblNewLabel_7);
		
		textFieldCourseGr = new JTextField();
		textFieldCourseGr.setBounds(157, 104, 96, 19);
		panel_2.add(textFieldCourseGr);
		textFieldCourseGr.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Βαθμός :");
		lblNewLabel_8.setBounds(33, 145, 129, 13);
		panel_2.add(lblNewLabel_8);
		
		textFieldGrade = new JTextField();
		textFieldGrade.setBounds(157, 142, 96, 19);
		panel_2.add(textFieldGrade);
		textFieldGrade.setColumns(10);
		
		JButton btnSaveGrade = new JButton("Save");
		btnSaveGrade.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String onoma = textFieldFnameGr.getText();
				String eponimo = textFieldLnameGr.getText();
				String mathima = textFieldCourseGr.getText();
				String vathmos = textFieldGrade.getText();
				float grade = Float.parseFloat(vathmos);
				
				Student student = new Student(onoma,eponimo);
				Course course = new Course(mathima);
				Grade gradefinal = new Grade(student,course,grade);
				
				gradefinal.insertGrade();
				
			}
		});
		btnSaveGrade.setBounds(157, 171, 96, 21);
		panel_2.add(btnSaveGrade);
		
		JLabel lblNewLabel_9 = new JLabel("Επώνυμο Μαθητή :");
		lblNewLabel_9.setBounds(33, 70, 114, 13);
		panel_2.add(lblNewLabel_9);
		
		textFieldLnameGr = new JTextField();
		textFieldLnameGr.setBounds(157, 67, 96, 19);
		panel_2.add(textFieldLnameGr);
		textFieldLnameGr.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_2.addTab("Βαθμολογίες Μαθητή", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Όνομα Μαθητή :");
		lblNewLabel_10.setBounds(27, 25, 127, 13);
		panel_3.add(lblNewLabel_10);
		
		textFieldFnameSearch = new JTextField();
		textFieldFnameSearch.setBounds(222, 22, 134, 19);
		panel_3.add(textFieldFnameSearch);
		textFieldFnameSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String onoma = textFieldFnameSearch.getText();
				String eponimo = textFieldLnameSearch.getText();
				
				Student student = new Student(onoma,eponimo);
				HashMap<String, String> titleGradeFinal = student.searchStudentGrades();
				
				for(String key : titleGradeFinal.keySet()) // prospelasi 
				{
					textArea.append(key+" "+titleGradeFinal.get(key)+"\n");
					System.out.println( key+" "+titleGradeFinal.get(key));
					
				}			
				
			}
		});
		btnSearch.setBounds(222, 86, 134, 21);
		panel_3.add(btnSearch);
		
		JLabel lblNewLabel_11 = new JLabel("Επώνυμο Μαθητή :");
		lblNewLabel_11.setBounds(27, 54, 151, 13);
		panel_3.add(lblNewLabel_11);
		
		textFieldLnameSearch = new JTextField();
		textFieldLnameSearch.setBounds(222, 51, 134, 19);
		panel_3.add(textFieldLnameSearch);
		textFieldLnameSearch.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(37, 131, 243, 123);
		panel_3.add(textArea);
		
		
	}
}
