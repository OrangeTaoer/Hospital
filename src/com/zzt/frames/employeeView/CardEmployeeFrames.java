package com.zzt.frames.employeeView;
import java.awt.CardLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.zzt.entity.Employee;
import com.zzt.frames.PatientPanel;
import com.zzt.frames.ProblemModelPanel;
import com.zzt.frames.ProblemPanel;
import com.zzt.frames.building.BuildingManage;
import com.zzt.frames.evaluateView.EvaluateManage;




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
public class CardEmployeeFrames extends javax.swing.JFrame {
	private JButton usersManager;
	private JButton judegManager;
	private JPanel cardPanel;
	private JTabbedPane userManager;
	private JTabbedPane evaluateManager;
	private JTabbedPane buildingsManager1;
	private PatientPanel patientPanel_IL;
	private JButton buildingsManager;
	private CardLayout cardPanelLayout;
	private JLabel jLabellabel;
	private JButton return11;
	private JLabel employeeName;
	private JLabel jLabel1;
	//登录的用户判断：
	private Employee employee;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CardEmployeeFrames inst = new CardEmployeeFrames();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public CardEmployeeFrames() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				usersManager = new JButton();
				getContentPane().add(usersManager);
				usersManager.setText("\u7528\u6237\u7ba1\u7406");
				usersManager.setBounds(0, 104, 89, 56);
				usersManager.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						usersManagerActionPerformed(evt);
					}
				});
			}
			{
				judegManager = new JButton();
				getContentPane().add(judegManager);
				judegManager.setText("\u8bc4\u4f30\u7ba1\u7406");
				judegManager.setBounds(0, 160, 89, 53);
				judegManager.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						judegManagerActionPerformed(evt);
					}
				});
			}
			{
				buildingsManager = new JButton();
				getContentPane().add(buildingsManager);
				buildingsManager.setText("\u697c\u5b87\u7ba1\u7406");
				buildingsManager.setBounds(0, 213, 89, 54);
				buildingsManager.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						buildingsManagerActionPerformed(evt);
					}
				});
			}
			{
				cardPanel = new JPanel();
				 cardPanelLayout = new CardLayout();
				cardPanel.setLayout(cardPanelLayout);
				
				getContentPane().add(cardPanel);
				cardPanel.setBounds(89, 74, 876, 769);
				{
					//添加卡片布局第一个大单位：员工管理
					userManager = new JTabbedPane();
					userManager.addTab("病患管理", new PatientPanel());
					cardPanel.add(userManager, "userManager");
					//添加卡片布局第二个大单位：评估管理
					evaluateManager = new JTabbedPane();
					evaluateManager.addTab("模板界面", new ProblemModelPanel());
					evaluateManager.addTab("问题界面", new ProblemPanel());
					evaluateManager.addTab("评估界面", new EvaluateManage());
					cardPanel.add(evaluateManager, "evaluateManager");
					
					
					//添加卡片布局第三个大单位：楼宇管理
					buildingsManager1 = new JTabbedPane();
					cardPanel.add(buildingsManager1, "buildingsManager1");
					buildingsManager1.addTab("楼宇管理", new BuildingManage());
					     
				}
				
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u5458\u5de5");
				jLabel1.setBounds(672, 22, 78, 67);
				jLabel1.setFont(new java.awt.Font("方正姚体",1,16));
			}
			{
				employeeName = new JLabel();
				getContentPane().add(employeeName);
				employeeName.setText("\u5458\u5de5\u59d3\u540d");
				employeeName.setBounds(756, 37, 89, 35);
				employeeName.setFont(new java.awt.Font("华文宋体",3,15));
			}
			{
				return11 = new JButton();
				getContentPane().add(return11);
				return11.setText("\u6ce8\u9500");
				return11.setBounds(869, 17, 79, 58);
				return11.setOpaque(false);
				return11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						return11ActionPerformed(evt);
					}
				});
			}
			{
				jLabellabel = new JLabel();
				getContentPane().add(jLabellabel);
				jLabellabel.setBounds(34, 29, 181, 33);
				jLabellabel.setName("jLabellabel");
			}
			pack();
			this.setSize(983, 890);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void usersManagerActionPerformed(ActionEvent evt) {
		cardPanelLayout.show(cardPanel, "userManager");
	}
	
	private void judegManagerActionPerformed(ActionEvent evt) {
		cardPanelLayout.show(cardPanel, "evaluateManager");
	}
	
	private void buildingsManagerActionPerformed(ActionEvent evt) {
		cardPanelLayout.show(cardPanel, "buildingsManager1");
	}
	
	private void return11ActionPerformed(ActionEvent evt) {
		int select = JOptionPane.showConfirmDialog(this, "是否确认关闭?", "确认", JOptionPane.YES_NO_OPTION);
		if(select != 0) return; // 0号按钮是'确定'按钮
		dispose();
	}

}
