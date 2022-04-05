package com.zzt.frames.adminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;


import com.zzt.controller.impl.AdminControllerImpl;
import com.zzt.entity.Admin;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.Md5;
import com.zzt.tool.WriteDataClass;

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
public class AdminCorrectSecret extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel sproblem;
	private JLabel jLabel5;
	private JButton enter3;
	private JTextField password2;
	private JTextField password1;
	private JLabel jLabel6;
	private JButton enter2;
	private JTextField sanswer;
	private JButton enter1;
	private JTextField acNumber;
	private String ac;
	private List<Admin> admins;

	private String san;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AdminCorrectSecret inst = new AdminCorrectSecret();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AdminCorrectSecret() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u91cd\u7f6e\u5bc6\u7801\u754c\u9762");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setBounds(22, 23, 138, 49);
				jLabel1.setName("jLabel1");
				jLabel1.setText("\u901a\u8fc7\u5bc6\u4fdd\u91cd\u7f6e\u5bc6\u7801\uff1a");
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setBounds(70, 232, 75, 20);
				jLabel2.setName("jLabel2");
				jLabel2.setText("\u5bc6\u4fdd\u95ee\u9898\uff1a");
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setBounds(70, 98, 78, 33);
				jLabel3.setName("jLabel3");
				jLabel3.setText("\u91cd\u7f6e\u8d26\u53f7\uff1a");
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setBounds(70, 316, 75, 20);
				jLabel4.setName("jLabel4");
				jLabel4.setText("\u5bc6\u4fdd\u7b54\u6848\uff1a");
			}
			{
				acNumber = new JTextField();
				getContentPane().add(acNumber);
				acNumber.setBounds(160, 101, 225, 27);
			}
			{
				enter1 = new JButton();
				getContentPane().add(enter1);
				enter1.setBounds(216, 140, 94, 56);
				enter1.setName("enter1");
				enter1.setText("\u786e\u5b9a");
				enter1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						enter1ActionPerformed(evt);
					}
				});
			}
			{
				sproblem = new JLabel();
				getContentPane().add(sproblem);
				sproblem.setBounds(157, 232, 332, 40);
			}
			{
				sanswer = new JTextField();
				getContentPane().add(sanswer);
				sanswer.setBounds(157, 313, 321, 30);
			}
			{
				enter2 = new JButton();
				getContentPane().add(enter2);
				enter2.setBounds(216, 372, 94, 62);
				enter2.setName("enter2");
				enter2.setText("\u786e\u5b9a");
				enter2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						enter2ActionPerformed(evt);
					}
				});
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setBounds(70, 470, 50, 31);
				jLabel5.setName("jLabel5");
				jLabel5.setText("\u5bc6\u7801\uff1a");
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setBounds(68, 519, 77, 41);
				jLabel6.setName("jLabel6");
				jLabel6.setText("\u91cd\u590d\u5bc6\u7801\uff1a");
			}
			{
				password1 = new JTextField();
				getContentPane().add(password1);
				password1.setBounds(157, 472, 321, 29);
			}
			{
				password2 = new JTextField();
				getContentPane().add(password2);
				password2.setBounds(157, 526, 321, 27);
			}
			{
				enter3 = new JButton();
				getContentPane().add(enter3);
				enter3.setBounds(216, 577, 88, 54);
				enter3.setName("enter3");
				enter3.setText("\u786e\u5b9a");
				enter3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						enter3ActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(527, 684);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	
	boolean flag1 = false;
	boolean flag2 = false;
	private void enter1ActionPerformed(ActionEvent evt) {
		ac = acNumber.getText();
		admins = GetDataClass.getDataAdminClass();
		if(ac == null || ac.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "请输入您要重置密码的账号！");
			return;
		}
		if(admins == null || admins.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "找不到您的账号");
			return;
		}
		for(Admin t : admins)
		{
			if(ac.equals(t.getAcNumber()))
			{
				JOptionPane.showMessageDialog(null, "请输入密保修改密码");
				sproblem.setText(t.getProblem());
				flag1 = true;
			}
		}
	}
	
	private void enter2ActionPerformed(ActionEvent evt) {
		if(!flag1)
		{
			JOptionPane.showMessageDialog(null, "请先确定账号是否输入正确！");
			return;
		}
		san = sanswer.getText();
		
		for(Admin t : admins)
		{
			if(ac.equals(t.getAcNumber()))
			{
				if(san.equals(t.getSecuity()))
				{
					JOptionPane.showMessageDialog(null, "密保输入正确！请在下方输入密码进行更改！");
					flag2 = true ;
					return;
				}
			}
		}
		if(!flag2)
		{
			JOptionPane.showMessageDialog(null, "密保输入错误，请重新输入！");
			return;
		}
	}
	
	private void enter3ActionPerformed(ActionEvent evt) {
		if(!flag1)
		{
			JOptionPane.showMessageDialog(null, "请先确定账号是否输入正确！");
			return;
		}else if(!flag2)
		{
			JOptionPane.showMessageDialog(null, "请先确定密保是否输入正确！");
			return;
		}
		
		String pass1 = password1.getText();
		String pass2 = password2.getText();
		
		if(!pass1.equals(pass2))
		{
			JOptionPane.showMessageDialog(null, "两次输入的密码不一致");
			password1.setText("");
			password2.setText("");
		}
		
		if(pass1 == null || pass1.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "输入密码不能为空！");
		}
		Admin admin = Admin.getAdmin();
		Md5 md5 = new Md5();
		int i = 0 ;
		for(Admin t : admins)
		{
			if(ac.equals(t.getAcNumber()))
			{
				admin = t ;
				try {
					admin.setPassword(md5.EncoderByMd5(pass1));
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				admins.set(i, admin);
				JOptionPane.showMessageDialog(null, "密码重置成功，请重新登陆！");
			}
			i ++ ;
		}
		WriteDataClass.writeDataAdmin(admins);
		
	}

}
