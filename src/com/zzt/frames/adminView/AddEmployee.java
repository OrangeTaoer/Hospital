package com.zzt.frames.adminView;
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
public class AddEmployee extends javax.swing.JFrame {
	private JTextField acNumber;
	private JPasswordField password1;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JComboBox positionName;
	private JButton employeeRegister;
	private JTextField advantage;
	private JTextField name;
	private JTextField idNumber;
	private JPasswordField password2;


	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddEmployee inst = new AddEmployee();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AddEmployee() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u589e\u52a0\u5458\u5de5");
			{
				acNumber = new JTextField();
				getContentPane().add(acNumber);
				acNumber.setBounds(143, 41, 229, 35);
			}
			{
				password1 = new JPasswordField();
				getContentPane().add(password1);
				password1.setBounds(143, 96, 229, 38);
			}
			{
				password2 = new JPasswordField();
				getContentPane().add(password2);
				password2.setBounds(143, 159, 229, 39);
			}
			{
				idNumber = new JTextField();
				getContentPane().add(idNumber);
				idNumber.setBounds(143, 277, 229, 39);
			}
			{
				name = new JTextField();
				getContentPane().add(name);
				name.setBounds(143, 219, 229, 36);
			}
			{
				advantage = new JTextField();
				getContentPane().add(advantage);
				advantage.setBounds(143, 395, 229, 44);
			}
			{
				employeeRegister = new JButton();
				getContentPane().add(employeeRegister);
				employeeRegister.setText("\u6ce8\u518c");
				employeeRegister.setBounds(157, 480, 145, 48);
				employeeRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						employeeRegisterActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel positionNameModel = 
					new DefaultComboBoxModel(
							new String[] { "医生","护士","护工" });
				positionName = new JComboBox();
				getContentPane().add(positionName);
				positionName.setModel(positionNameModel);
				positionName.setBounds(143, 336, 229, 39);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8d26\u53f7");
				jLabel1.setBounds(75, 40, 50, 37);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u5bc6\u7801");
				jLabel2.setBounds(75, 90, 50, 49);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u5bc6\u7801");
				jLabel3.setBounds(75, 159, 46, 33);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u59d3\u540d");
				jLabel4.setBounds(75, 219, 41, 41);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u8eab\u4efd\u8bc1\u53f7");
				jLabel5.setBounds(67, 277, 73, 39);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u804c\u4f4d");
				jLabel6.setBounds(75, 336, 56, 45);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("\u4f18\u52bf");
				jLabel7.setBounds(75, 402, 65, 45);
			}
			pack();
			this.setSize(485, 618);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void employeeRegisterActionPerformed(ActionEvent evt) {
		String acNumber1 = acNumber.getText();
		String password11 = new String(password1.getPassword());
		String password21 = new String(password2.getPassword());
		String name1 = name.getText();
		String idNumber1 = idNumber.getText();
		String position1 = positionName.getSelectedItem().toString();
		String advantage1 = advantage.getText();
		
		if(!password11.equals(password21))
		{
			JOptionPane.showMessageDialog(null, "两次输入的密码不一致");
			return ;
		}
		
		if(idNumber1.length() != 18)
		{
			JOptionPane.showMessageDialog(null, "身份证号不规范！");
			return;
		}
		
		boolean flag = true;
		
		flag = IsRegister.EmployeeIsRegister(acNumber1);
		if(!flag)
		{
			JOptionPane.showMessageDialog(null, "账号重复，请更换账号");
			return;
		}
		
		Employee employee = Employee.getEmployee();
		employee.setAcNumber(acNumber1);
		employee.setPassword(password21);
		employee.setName(name1);
		employee.setIdNumber(idNumber1);
		employee.setPosition(position1);
		employee.setAdvantage(advantage1);
		JOptionPane.showMessageDialog(null, "注册成功！");
		Register.EmployeeRegister(employee);
		acNumber.setText("");
		password1.setText(null);
		password2.setText(null);
		name.setText("");
		idNumber.setText("");
		advantage.setText("");
	}

}
