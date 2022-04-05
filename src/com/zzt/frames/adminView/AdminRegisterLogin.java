package com.zzt.frames.adminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.WindowConstants;


import com.zzt.controller.impl.AdminControllerImpl;
import com.zzt.entity.Admin;
import com.zzt.tool.IsTextRight;
import com.zzt.tool.Register;




public class AdminRegisterLogin extends javax.swing.JFrame {
	private JTextField acNumber;
	private JButton register;
	private JButton correctSecret;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JButton login;
	private JPasswordField password;

	public static void main(String[] args)
	{
		//***使用beautyeye的代码
		try
	    { 
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    } catch(Exception e)
	    { 
		 
	    } 
		//***使用beautyeye的代码
		
		AdminRegisterLogin inst = new AdminRegisterLogin();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
	public AdminRegisterLogin() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u7ba1\u7406\u5458\u754c\u9762");
			{
				acNumber = new JTextField();
				getContentPane().add(acNumber);
				acNumber.setBounds(150, 42, 258, 38);
			}
			{
				password = new JPasswordField();
				getContentPane().add(password);
				password.setBounds(150, 102, 258, 43);
			}
			{
				register = new JButton();
				getContentPane().add(register);
				register.setText("\u6ce8\u518c");
				register.setBounds(360, 242, 100, 62);
				register.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						registerActionPerformed(evt);
					}
				});
			}
			{
				login = new JButton();
				getContentPane().add(login);
				login.setText("\u767b\u5f55");
				login.setBounds(360, 178, 100, 64);
				login.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						loginActionPerformed(evt);
					}
				});
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u8d26\u53f7");
				jLabel2.setBounds(72, 38, 51, 41);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u5bc6\u7801");
				jLabel3.setBounds(72, 100, 51, 43);
			}
			{
				correctSecret = new JButton();
				getContentPane().add(correctSecret);
				correctSecret.setBounds(95, 182, 109, 60);
				correctSecret.setName("correctSecret");
				correctSecret.setText("忘记密码");
				correctSecret.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						correctSecretActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(526, 362);

		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	private void registerActionPerformed(ActionEvent evt) {
		AdminRegister inst = new AdminRegister();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
	private void loginActionPerformed(ActionEvent evt) {
		//获取登录的账号密码
		String acNumber1 = acNumber.getText();
		String password1 = new String(password.getPassword());

		//定义flag用来判断登录是否正常
		boolean flag1 = true;
		flag1 = IsTextRight.isTextTrue(acNumber1, password1);
		
		boolean flag2 = true;
		//使用Admin控制器判断
		AdminControllerImpl admincontroller = AdminControllerImpl.getAdminControllerImpl();
		flag2 = admincontroller.isLogin(acNumber1, password1);
		
		if(flag1)
		{
			if(flag2)
			{
				JOptionPane.showMessageDialog(null, "登陆成功！");
				AdminFrame inst = new AdminFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				dispose();
			}else
			{
				JOptionPane.showMessageDialog(null, "登陆失败！\n请检查账号和密码是否正确填写！");
			}
		}
		
	}
	
	private void correctSecretActionPerformed(ActionEvent evt) {
		AdminCorrectSecret inst = new AdminCorrectSecret();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

}
