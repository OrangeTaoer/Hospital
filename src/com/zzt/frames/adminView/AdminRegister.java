package com.zzt.frames.adminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.WindowConstants;

import com.zzt.controller.impl.AdminControllerImpl;
import com.zzt.entity.Admin;
import com.zzt.tool.IsTextRight;
import com.zzt.tool.Md5;
import com.zzt.tool.Register;

import javax.swing.SwingUtilities;


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
public class AdminRegister extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JTextField sproblem;
	private JButton enter;
	private JTextField sanswer;
	private JPasswordField password2;
	private JPasswordField password1;
	private JTextField acNumber;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AdminRegister inst = new AdminRegister();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AdminRegister() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setTitle("管理员注册界面");
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setBounds(105, 67, 45, 20);
				jLabel1.setName("jLabel1");
				jLabel1.setText("账号");
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setBounds(105, 130, 45, 20);
				jLabel2.setName("jLabel2");
				jLabel2.setText("密码");
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setBounds(73, 186, 77, 35);
				jLabel3.setName("jLabel3");
				jLabel3.setText("确认密码");
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setBounds(73, 254, 75, 20);
				jLabel4.setName("jLabel4");
				jLabel4.setText("密保问题");
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setBounds(67, 318, 75, 20);
				jLabel5.setName("jLabel5");
				jLabel5.setText("密保答案");
			}
			{
				acNumber = new JTextField();
				getContentPane().add(acNumber);
				acNumber.setBounds(174, 64, 146, 27);
			}
			{
				password1 = new JPasswordField();
				getContentPane().add(password1);
				password1.setBounds(174, 127, 146, 27);
			}
			{
				password2 = new JPasswordField();
				getContentPane().add(password2);
				password2.setBounds(174, 190, 146, 27);
			}
			{
				sproblem = new JTextField();
				getContentPane().add(sproblem);
				sproblem.setBounds(174, 254, 146, 27);
			}
			{
				sanswer = new JTextField();
				getContentPane().add(sanswer);
				sanswer.setBounds(174, 315, 146, 27);
			}
			{
				enter = new JButton();
				getContentPane().add(enter);
				enter.setBounds(160, 373, 91, 55);
				enter.setName("enter");
				enter.setText("确认");
				enter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						enterActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(473, 511);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void enterActionPerformed(ActionEvent evt) {
		//获取账号密码用户名
		String acNumber1 = acNumber.getText();
		String password11 = new String(password1.getPassword());
		String password22 = new String(password2.getPassword());
		String sproblem1 = sproblem.getText();
		String sanswer1 = sanswer.getText();
		

		
		//判断能否成功注册
		boolean flag1 = true;
		boolean flag2 = true;
		flag1 = IsTextRight.isTextTrue(acNumber1, password11);
		
		if(sproblem1 == null || sproblem1.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "请输入您的密保问题");
			return;
		}
		
		if(sanswer1 == null || sanswer1.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "请输入您的密保答案");
			return;
		}
		if(!password11.equals(password22))
		{
			JOptionPane.showMessageDialog(null, "两次密码不一致，请重新输入！");
			return;
		}
		
		
		//使用Admin控制器判断
		AdminControllerImpl admincontroller = AdminControllerImpl.getAdminControllerImpl();
		flag2 = admincontroller.isRegister(acNumber1);
		if(flag1 && !flag2)
		{
			JOptionPane.showMessageDialog(null, "您的账号已被他人注册！请重新选择账号进行注册！");
		}
		if(flag1 && flag2)
		{
			Admin admin = Admin.getAdmin();
			admin.setAcNumber(acNumber1);
			//使用MD5加密算法对密码进行加密
			Md5 md5 = new Md5();
			try {
				String passwordencry = md5.EncoderByMd5(password11);
				admin.setPassword(passwordencry);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//
			
			admin.setProblem(sproblem1);
			admin.setSecuity(sanswer1);
			Register.AdminRegister(admin);
			JOptionPane.showMessageDialog(null, "注册成功");
			acNumber.setText("");
			password1.setText("");
			password2.setText("");
			sproblem.setText("");
			sanswer.setText("");
		}
	}

}
