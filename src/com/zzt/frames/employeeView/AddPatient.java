package com.zzt.frames.employeeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.zzt.entity.Employee;
import com.zzt.entity.Patient;
import com.zzt.tool.IDparse;
import com.zzt.tool.IsRegister;
import com.zzt.tool.Register;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class AddPatient extends javax.swing.JFrame {
	private JButton employeeRegister;
	private JTextField name;
	private JTextField emPerson;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel1;
	private JTextField emPhNumber;
	private JTextField phNumber;
	private JTextField idNumber;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddPatient inst = new AddPatient();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AddPatient() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u589e\u52a0\u75c5\u60a3\u754c\u9762");
			{
				idNumber = new JTextField();
				getContentPane().add(idNumber);
				idNumber.setBounds(150, 108, 229, 39);
			}
			{
				name = new JTextField();
				getContentPane().add(name);
				name.setBounds(150, 48, 229, 36);
			}
			{
				employeeRegister = new JButton();
				getContentPane().add(employeeRegister);
				employeeRegister.setText("\u6ce8\u518c");
				employeeRegister.setBounds(123, 378, 145, 48);
				employeeRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						employeeRegisterActionPerformed(evt);
					}
				});
			}
			{
				phNumber = new JTextField();
				getContentPane().add(phNumber);
				phNumber.setBounds(150, 169, 229, 38);
			}
			{
				emPerson = new JTextField();
				getContentPane().add(emPerson);
				emPerson.setBounds(150, 234, 229, 39);
			}
			{
				emPhNumber = new JTextField();
				getContentPane().add(emPhNumber);
				emPhNumber.setBounds(150, 298, 229, 37);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u59d3\u540d");
				jLabel1.setBounds(78, 44, 45, 40);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u8eab\u4efd\u8bc1\u53f7");
				jLabel2.setBounds(47, 94, 70, 55);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u7535\u8bdd\u53f7\u7801");
				jLabel3.setBounds(43, 168, 82, 38);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u7d27\u6025\u8054\u7cfb\u4eba");
				jLabel4.setBounds(39, 227, 86, 52);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u7d27\u6025\u8054\u7cfb\u4eba\u7535\u8bdd");
				jLabel5.setBounds(21, 302, 111, 29);
			}
			pack();
			this.setSize(438, 544);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void employeeRegisterActionPerformed(ActionEvent evt) {
		String name1 = name.getText();
		String idNumber1 = idNumber.getText();
		String phNumber1 = phNumber.getText();
		String emPerson1 = emPerson.getText();
		String emPhNumber1 = emPhNumber.getText();

		
		
		if(idNumber1.length() != 18)
		{
			JOptionPane.showMessageDialog(null, "身份证号不规范！");
			return;
		}
		
		boolean flag = true;
		String filename = "C://e//Hospital_System//data//patient.txt";
		
		flag = IsRegister.PatientIsRegister(idNumber1);
		if(!flag)
		{
			JOptionPane.showMessageDialog(null, "账号重复，请更换账号");
			return;
		}
		
		Patient t = Patient.getPatient();
	
		t.setName(name1);
		t.setIdNumber(idNumber1);
		t.setEmPhNumber(emPhNumber1);
		t.setEmPerson(emPerson1);
		t.setPhNumber(phNumber1);
		t.setGender(IDparse.toGender(idNumber1));
		t.setAge(IDparse.toAge(idNumber1));
		JOptionPane.showMessageDialog(null, "注册成功！");
		Register.PatientRegister(t);
		
		//重设文本框:
		emPerson.setText("");
		emPhNumber.setText("");
		idNumber.setText("");
		name.setText("");
		phNumber.setText("");
		
		
	}

}
