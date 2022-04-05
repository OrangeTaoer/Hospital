package com.zzt.frames.employeeView;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.zzt.controller.impl.EmployeeControllerImpl;
import com.zzt.controller.impl.PatientControllerImpl;
import com.zzt.entity.Employee;
import com.zzt.entity.Patient;
import com.zzt.entity.Problem;
import com.zzt.entity.ProblemModel;
import com.zzt.entity.UserEvaluate;
import com.zzt.frames.PatientPanel;
import com.zzt.frames.ProblemModelPanel;
import com.zzt.frames.ProblemPanel;
import com.zzt.frames.adminView.AdminRegisterLogin;
import com.zzt.frames.building.BedManage;
import com.zzt.frames.building.BuildingManage;
import com.zzt.frames.building.SpecialFacilityManage;
import com.zzt.frames.evaluateView.EvaluateManage;
import com.zzt.frames.evaluateView.EvaluateManage.EvaluateFrame;
import com.zzt.frames.evaluateView.EvaluateManage.EvaluateSuggest;
import com.zzt.frames.evaluateView.EvaluateManage.EvaluateFrame.EvaluatePanel;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.IsLogin;
import com.zzt.tool.IsTextRight;
import com.zzt.tool.WriteDataClass;

public class EmployeeLogin extends javax.swing.JFrame {
	private JTextField acNumber;
	private JButton login;
	private JButton jump;
	private JPasswordField password;
	private List<Employee> employees;
	//登录的用户判断：
	private Employee employeeLogin;

	private JLabel jLabel2;
	private JLabel jLabel1;
	private JLabel jLabel3;
	private JLabel employeeName;
	private ProblemModel pbmt;
	private int pointsss;
	
	//使用控制器间接控制视图
	private EmployeeControllerImpl  employeeControllerImpl; 
	private PatientControllerImpl patientControllerImpl;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//***使用beautyeye的代码
				try
			    { 
			        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			    } catch(Exception e)
			    { 
				 
			    } 
				//***使用beautyeye的代码
				EmployeeLogin inst = new EmployeeLogin();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public EmployeeLogin() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u5458\u5de5\u767b\u5f55\u754c\u9762");
			{
				acNumber = new JTextField();
				getContentPane().add(acNumber);
				acNumber.setBounds(126, 59, 267, 37);
				repaint();
			}
			{
				password = new JPasswordField();
				getContentPane().add(password);
				password.setBounds(126, 123, 267, 34);
				repaint();
			}
			{
				login = new JButton();
				getContentPane().add(login);
				login.setText("\u767b\u5f55");
				login.setBounds(182, 184, 81, 53);
				login.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						loginActionPerformed(evt);
					}
				});
				repaint();
			}
			{
				jump = new JButton();
				getContentPane().add(jump);
				jump.setText("\u7ba1\u7406\u5458\u9009\u9879");
				jump.setBounds(0, 257, 129, 44);
				jump.setMargin(new java.awt.Insets(0, 0, 0, 0));
				jump.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jumpActionPerformed(evt);
					}
				});
				repaint();
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8d26\u53f7");
				jLabel1.setBounds(64, 60, 57, 35);
				repaint();
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u5bc6\u7801");
				jLabel2.setBounds(64, 123, 57, 41);
				repaint();
			}
			
			pack();
			this.setSize(472, 348);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jumpActionPerformed(ActionEvent evt) {
		dispose();
		AdminRegisterLogin inst = new AdminRegisterLogin();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
	private void loginActionPerformed(ActionEvent evt) {
		//获取登录的员工登录的账号密码
         String acNumber1 = acNumber.getText();
         String password1 = new String(password.getPassword());
         //判断账号密码的格式是否正确
         boolean flag1 = IsTextRight.isTextTrue(acNumber1, password1);
         if(!flag1)
         {
        	 return;
         }
         boolean flag2 = IsLogin.EmployeeLogin(acNumber1, password1);
         if(flag2)
         {
        	 JOptionPane.showMessageDialog(null, "登陆成功");
        	 employees = GetDataClass.getDataEmployeeClass();
        	 //判断登录的用户是谁
        	 for(Employee t : employees)
        	 {
        		 if(t.getAcNumber().equals(acNumber1))
        		 {
        			 employeeLogin = t ;
        			 break;
        		 }
        	 }
        	 //打开员工管理的界面
        	 CardEmployeeFrames inst = new CardEmployeeFrames();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				dispose();
         }else
         {
        	 JOptionPane.showMessageDialog(null, "登陆失败，请检查账号密码！");
         }
	}
	
	//总的员工界面:
	
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
		private JButton return11;
		private JLabel jLabellabel;
		
		public CardEmployeeFrames() {
			super();
			initGUI();
		}
		
		private void initGUI() {
			try {
				this.setTitle("员工界面");
				setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				getContentPane().setLayout(null);
				{
					jLabellabel = new JLabel();
					getContentPane().add(jLabellabel);
					jLabellabel.setBounds(34, 29, 181, 33);
					jLabellabel.setName("jLabellabel");
					jLabellabel.setText("东软颐养管理系统");
				}
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
					cardPanel = new JPanel();              //实例化使用卡片布局的面板
					 cardPanelLayout = new CardLayout();   //实例化卡片布局
					cardPanel.setLayout(cardPanelLayout);  //在panel上放置卡片布局
					
					getContentPane().add(cardPanel);
					cardPanel.setBounds(89, 74, 876, 769);
					
					//卡片布局的设计
					{
						//添加卡片布局第一个大单位：员工管理
						userManager = new JTabbedPane();
						userManager.addTab("病患管理", new PatientPanel());
						userManager.addTab("床位管理", new BedManage());
						userManager.addTab("稀有设备管理", new SpecialFacilityManage());
						
						cardPanel.add(userManager, "userManager");
						//添加卡片布局第二个大单位：评估管理
						evaluateManager = new JTabbedPane();
						evaluateManager.addTab("模板界面", new ProblemModelPanel());
						evaluateManager.addTab("问题界面", new ProblemPanel());
						evaluateManager.addTab("评估界面", new EvaluateManage());
						cardPanel.add(evaluateManager, "evaluateManager");
						
						
						//添加卡片布局第三个大单位：楼宇管理
						buildingsManager1 = new JTabbedPane();
						buildingsManager1.addTab("楼宇管理", new BuildingManage());
						cardPanel.add(buildingsManager1, "buildingsManager1");
						
						     
					}
					
				}
				{
					jLabel3 = new JLabel();
					getContentPane().add(jLabel3);
					jLabel3.setText("员工姓名");
					jLabel3.setBounds(672, 22, 78, 67);
				}
				{
					employeeName = new JLabel();
					getContentPane().add(employeeName);
					String name = employeeLogin.getName();
					employeeName.setText(name);
					employeeName.setBounds(790, 40, 89, 35);
					employeeinit();
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
				repaint();
				
				pack();
				this.setSize(983, 890);
			} catch (Exception e) {
			    //add your error handling code here
				e.printStackTrace();
			}
		}
		
		private void employeeinit()
		{
			String name1 = employeeLogin.getName();
			Label labelName = new Label();
			getContentPane().add(labelName);
			jLabel1.setText(name1);
			jLabel1.setBounds(64, 60, 57, 35);
			
		}
		
		//跳转卡片布局功能实现：
		private void usersManagerActionPerformed(ActionEvent evt) {
			cardPanelLayout.show(cardPanel, "userManager");       //跳转用户管理卡片布局
		}
		
		private void judegManagerActionPerformed(ActionEvent evt) {
			cardPanelLayout.show(cardPanel, "evaluateManager");   //跳转评估管理卡片布局
		}
		
		private void buildingsManagerActionPerformed(ActionEvent evt) {
			cardPanelLayout.show(cardPanel, "buildingsManager1"); //跳转楼宇管理卡片布局
		}

	}
	
	private void return11ActionPerformed(ActionEvent evt) {
		int select = JOptionPane.showConfirmDialog(this, "是否确认关闭?", "确认", JOptionPane.YES_NO_OPTION);
		if(select != 0) return; // 0号按钮是'确定'按钮
		this.dispose();
	}

	
	
	//评估界面：
	public class EvaluateManage extends javax.swing.JPanel {
		private JComboBox patient;
		private JComboBox modelName;
		private JScrollPane jScrollPane1;
		private JButton close;
		private JTable evaluate2;
		private JButton start;
		private List<Patient> patients;
		private List<ProblemModel> problemModels;
		private int sizepatient = 0 ;
		private int  sizeproblemModel = 0 ;
		private String[] patientss = new String[]{};
		private String[] problemModelss = new String[]{};
		private JButton flush;
		
		private String modelID;

		
		public EvaluateManage() {
			super();
			initGUI();
		}
		
		private void initGUI() {
//			employeeInit();
			dataInit();
			if(patients != null && !patients.isEmpty())
			{
				sizepatient = patients.size();
				patientss = new String[sizepatient];
				int cnt = 0 ;
				for(Patient t : patients)
				{
					patientss[cnt ++ ] = t.getName();
				}
			}
			
			if(problemModels != null && !problemModels.isEmpty())
			{
				sizeproblemModel = problemModels.size();
				problemModelss = new String[sizeproblemModel];
				int cnt = 0;
				for(ProblemModel t : problemModels)
				{
					problemModelss[cnt ++] = t.getName();
				}
				
			}
			
			try {
				this.setPreferredSize(new java.awt.Dimension(704, 770));
				this.setLayout(null);
				{
					ComboBoxModel patientModel = 
						new DefaultComboBoxModel(
								patientss);
					patient = new JComboBox();
					this.add(patient);
					patient.setModel(patientModel);
					patient.setBounds(42, 70, 122, 37);
				}
				{
					ComboBoxModel modelNameModel = 
						new DefaultComboBoxModel(
								problemModelss);
					modelName = new JComboBox();
					this.add(modelName);
					modelName.setModel(modelNameModel);
					modelName.setBounds(207, 70, 125, 37);
				}
				{
					start = new JButton();
					this.add(start);
					start.setText("\u5f00\u59cb\u8bc4\u4f30");
					start.setBounds(383, 55, 110, 58);
					start.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							startActionPerformed(evt);
						}
					});
				}
				{
					flush = new JButton();
					this.add(flush);
					flush.setText("刷新");
					flush.setBounds(500, 55, 110, 58);
					flush.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							flushActionPerformed(evt);
						}
					});
				}
				{
					jScrollPane1 = new JScrollPane();
					this.add(jScrollPane1);
					jScrollPane1.setBounds(0, 146, 704, 368);
				}
				tableInit();
				{
					close = new JButton();
					this.add(close);
					close.setText("\u5173\u95ed");
					close.setBounds(529, 556, 91, 63);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		protected void flushActionPerformed(ActionEvent evt) {
			tableInit();
			dataInit();
			
			if(patients != null && !patients.isEmpty())
			{
				sizepatient = patients.size();
				patientss = new String[sizepatient];
				int cnt = 0 ;
				for(Patient t : patients)
				{
					patientss[cnt ++ ] = t.getName();
				}
			}
			
			if(problemModels != null && !problemModels.isEmpty())
			{
				sizeproblemModel = problemModels.size();
				problemModelss = new String[sizeproblemModel];
				int cnt = 0;
				for(ProblemModel t : problemModels)
				{
					problemModelss[cnt ++] = t.getName();
				}
				
			}
			
			//复选框更新：
			ComboBoxModel patientModel = 
				new DefaultComboBoxModel(
						patientss);
			patient.setModel(patientModel);
			
			
			
			ComboBoxModel modelNameModel = 
				new DefaultComboBoxModel(
						problemModelss);
			modelName.setModel(modelNameModel);
			
			
		}

		private void dataInit()
		{
			patients = GetDataClass.getDataPatientClass();
			problemModels = GetDataClass.getDataProblemModelClass();
		}
		
		private void tableInit()
		{
			{
				String[] colNames = {"姓名","性别","模板名称","模板类型","时间","评估人","分数","建议"};
				
				//首先从文件中读出所有评估信息：
				List<UserEvaluate> userEvaluates1 = new ArrayList<UserEvaluate>();
				userEvaluates1 = GetDataClass.getDataUserEvaluate();
				
				//计算所有该员工的评估信息的大小并且保存：
				int size = 0 ;
				for(UserEvaluate t : userEvaluates1)
				{
					if(t.getEvaluator().getName().equals(employeeLogin.getName()))
					{
						size ++ ;
					}
				}
				String[][] content = new String[size][8];
				int i = 0 ;
				
				//然后将评估列表按照分数排序：
				Collections.sort(userEvaluates1);
				
				for(UserEvaluate t : userEvaluates1)
				{
					if(t.getEvaluator().getName().equals(employeeLogin.getName()))
					{
						content[i ++ ] = new String[]{t.getPatientName(),t.getPatientGender(),t.getProblemModel().getName(),t.getProblemModel().getType(),t.getTime(),t.getEvaluator().getName(),t.getPoints().toString(),t.getSuggest()};
					}
				}
				
				
				
				{
					TableModel evaluate2Model = 
						new DefaultTableModel(
								content,
								colNames);
					evaluate2 = new JTable();
					jScrollPane1.setViewportView(evaluate2);
					evaluate2.setModel(evaluate2Model);
					evaluate2.getColumnModel().getColumn(4).setPreferredWidth(140);
				}
			}
		}
		
		
		private void startActionPerformed(ActionEvent evt) {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStringParse = sdf.format(Calendar.getInstance().getTime());
			String patientname = patient.getSelectedItem().toString();
			String problemModelname = modelName.getSelectedItem().toString();
			String patientgender = new String();
			String modelType = new String();
			
			for(Patient t : patients)
			{
				if(patientname.equals(t.getName()))
				{
					patientgender = t.getGender();
				}
			}
			
			for(ProblemModel t : problemModels)
			{
				if(problemModelname.equals(t.getName()))
				{
					modelType = t.getType();
				}
			}
			
			EvaluateFrame inst = new EvaluateFrame();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
			
			
			
		}

		//评估界面
		public class EvaluateFrame extends javax.swing.JFrame {
			private JScrollPane jScrollPane1;
			private JButton return111;
			private JLabel jLabel3;
			private JLabel jLabel2;
			private JLabel jLabel1;
			private  Map<String,Integer> points;


			
			public EvaluateFrame() {
				super();
				initGUI();
			}
			
			private void initGUI() {
				try {
					setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					getContentPane().setLayout(null);
					{
						jScrollPane1 = new JScrollPane(new EvaluatePanel());
						getContentPane().add(jScrollPane1);
						jScrollPane1.setBounds(0, 55, 556, 588);
						{
							jLabel1 = new JLabel();
							getContentPane().add(jLabel1);
							jLabel1.setText("\u8bc4\u4f30\u754c\u9762");
							jLabel1.setBounds(7, 12, 189, 62);
							
						}
						{
							jLabel2 = new JLabel();
							getContentPane().add(jLabel2);
							jLabel2.setText("\u5de5\u4f5c\u4eba\u5458");
							jLabel2.setBounds(283, 19, 99, 50);
							
						}
						{
							jLabel3 = new JLabel();
							getContentPane().add(jLabel3);
							jLabel3.setText(employeeLogin.getName());
							jLabel3.setBounds(374, 12, 91, 64);
							//jLabel3.setBackground(Color.BLUE);
							jLabel3.setForeground(Color.blue);
						}
						{
							return111 = new JButton();
							getContentPane().add(return111);
							return111.setText("\u6ce8\u9500");
							return111.setBounds(468, 19, 70, 39);
							return111.setOpaque(false);
							return111.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									return111ActionPerformed(evt);
								}
							});
						}
					}
					pack();
					this.setSize(574, 690);
				} catch (Exception e) {
				    //add your error handling code here
					e.printStackTrace();
				}
			}
			
			private void return111ActionPerformed(ActionEvent evt) {
				// 弹出对话框确认
				int select = JOptionPane.showConfirmDialog(this, "是否确认注销?", "确认", JOptionPane.YES_NO_OPTION);
				if(select != 0) return; // 0号按钮是'确定'按钮
				dispose();
			}

			public class EvaluatePanel extends javax.swing.JPanel {

				
				private String filenameModel;
				private List<ProblemModel> problemModels;
				// 获取模板
//				private ProblemModel pbmt;
				
				private List<Problem> problems2; // 该模板的问题
				
				private ButtonGroup[] bgs;
				private JRadioButton[] jrbs; 
				private Integer[] scores = {5 ,3 , 1};//定义A:5分，B:3分，C：1分
				private int lengths;
				private int high = 200 ; // 为所要设置的 panel根据问题的数量设置动态大小，使之大小适当
				private JButton btnSubmit; //设置提交按钮

				
				
				
				public EvaluatePanel() {
					super();
					initGUI();
				}
				
				private void initGUI() {
					dataInit();
					
					guiInit();
					
					try {
						this.setPreferredSize(new java.awt.Dimension(539, high + 100 ));//动态设置panel的高度
						this.setLayout(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				private void dataInit()
				{
					//初始化要用到的变量
					lengths = 0 ;
					List<ProblemModel> problemModels = GetDataClass
							.getDataProblemModelClass();
					boolean flag = false;//判断pbmt是否为已有模板
					// 获取模板
					for (ProblemModel t : problemModels) {
						if (t.getName().equals(modelName.getSelectedItem().toString())) {
							pbmt = t;
							flag = true; // 若执行到此步，则代表为已有模板
							break;
						}
					}
					if(!flag)
					{
						JOptionPane.showMessageDialog(null, "该模板为不可用模板");
						return;
					}		
					problems2 = pbmt.getProblemss();
					if(problems2 == null  ||problems2.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "该模板不存在问题，请重新选择模板，或者为进入模板管理为该模板添加问题");
						return;
					}
				}
				
				private void guiInit()
				{
					if(problems2 == null || problems2.isEmpty())
					{
						return;
					}
					lengths = problems2.size();
					//若无问题存在在模板中，则跳出
					if( lengths == 0 )
					{
						return ;
					}
					
					bgs = new ButtonGroup[lengths];
					JLabel[] jbs = new JLabel[lengths];
					jrbs = new JRadioButton[3];//定义三个单选
					
					int x = 50;// 动态控件组距离左边框距离
					int w = 350;// 动态标题及单选按钮宽
					int h = 45;// 动态单选按钮高
					
					for(int i = 0 ; i < lengths ; i ++ )
					{
						Problem t = problems2.get(i);
						bgs[i] = new ButtonGroup(); 
						jbs[i] = new JLabel("第"+ ( i + 1 ) + "题:" + t.getTitle());
						jbs[i].setForeground(Color.red);
						jbs[i].setBounds(x, 5 + i * 120, w , h);
						this.add(jbs[i]);
						jbs[i].revalidate();
						
						jrbs[0] = new JRadioButton("A." + t.getOptions1());
						jrbs[0].setBounds(x, 35 + i * 120, w, h);
						jrbs[0].setActionCommand("q"+i);
						jrbs[0].addActionListener(new ActionListener(){ 
							@Override
							public void actionPerformed(ActionEvent ae) {
								firstActionPerformed(ae);					
							}});
						bgs[i].add(jrbs[0]);
						this.add(jrbs[0]);
						
						jrbs[1] = new JRadioButton("B." + t.getOptions2());
						jrbs[1].setBounds(x, 65 + i * 120, w, h);
						jrbs[1].setActionCommand("q"+i);
						jrbs[1].addActionListener(new ActionListener(){ 
							@Override
							public void actionPerformed(ActionEvent ae) {
								secondActionPerformed(ae);
							}});
						bgs[i].add(jrbs[1]);
						this.add(jrbs[1]);
						
						jrbs[2] = new JRadioButton("C." + t.getOptions3());
						jrbs[2].setBounds(x, 95 + i * 120, w, h);
						jrbs[2].setActionCommand("q"+i);
						jrbs[2].addActionListener(new ActionListener(){ 
							@Override
							public void actionPerformed(ActionEvent ae) {
								thirdActionPerformed(ae);					
							}});
						bgs[i].add(jrbs[2]);
						this.add(jrbs[2]);
						if(i == lengths - 1 )
						{
							high = 95 + i * 120 + h ;
						}
					}
					
					btnSubmit = new JButton();
					btnSubmit.setText("\u63d0\u4ea4");
					btnSubmit.setBounds(250, high, 100, 100);
					btnSubmit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ae) {
							btnSubmitActionPerformed(ae);
						}
					});
					
					this.add(btnSubmit);
					repaint();
				}
				
				
				Map<String,Integer> calculatePoints = new HashMap<String,Integer>(); 
				public void firstActionPerformed(ActionEvent arg0) { 
					JRadioButton jb=(JRadioButton) arg0.getSource();  //强转类型
					String ac=jb.getActionCommand();                  //获取文本
					calculatePoints.put(ac,scores[0]);                //放入哈希表
				}	
				
				public void secondActionPerformed(ActionEvent arg0) { 
					JRadioButton jb=(JRadioButton) arg0.getSource();  
					String ac=jb.getActionCommand();
					calculatePoints.put(ac,scores[1]);
				}	
				public void thirdActionPerformed(ActionEvent arg0) { 
					JRadioButton jb=(JRadioButton) arg0.getSource();  
					String ac=jb.getActionCommand();
					calculatePoints.put(ac,scores[2]);
				}	
				private JButton getBtnSubmit() {
					if(btnSubmit == null) {
						btnSubmit = new JButton();
						btnSubmit.setText("\u63d0\u4ea4");
						btnSubmit.setBounds(309, high, 64, 24);
						btnSubmit.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae) {
								btnSubmitActionPerformed(ae);
							}
						});
					}
					return btnSubmit;
				}
				
				private void btnSubmitActionPerformed(ActionEvent ae) {
					
					//遍历哈希表以求最终评估分数：
					for(Integer value:calculatePoints.values())
					{
						pointsss+=value;                
					}
					//与员工交互以告诉评估分数来书写建议：
					JOptionPane.showMessageDialog(this,"评估分数是="+pointsss); 

					//
					EvaluateSuggest inst = new EvaluateSuggest();
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
					dispose();
				}
				
			}
			

		}
		
		//输入建议界面
		
		public class EvaluateSuggest extends javax.swing.JFrame {
			private JLabel jLabel1;
			private JTextField suggest;
			private JButton enter;

			/**
			* Auto-generated main method to display this JFrame
			*/

			
			public EvaluateSuggest() {
				super();
				initGUI();
			}
			
			private void initGUI() {
				try {
					setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					getContentPane().setLayout(null);
					{
						jLabel1 = new JLabel();
						getContentPane().add(jLabel1);
						jLabel1.setText("\u8bf7\u8f93\u5165\u60a8\u7684\u8bc4\u4f30\u6216\u8005\u5efa\u8bae");
						jLabel1.setBounds(57, 54, 219, 48);
					}
					{
						suggest = new JTextField();
						getContentPane().add(suggest);
						suggest.setBounds(98, 137, 212, 46);
					}
					{
						enter = new JButton();
						getContentPane().add(enter);
						enter.setText("\u786e\u8ba4");
						enter.setBounds(140, 226, 78, 42);
						enter.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								enterActionPerformed(evt);
							}
						});
					}
					pack();
					this.setSize(445, 365);
				} catch (Exception e) {
				    //add your error handling code here
					e.printStackTrace();
				}
			}
			
			private void enterActionPerformed(ActionEvent evt) {
				
				//获取工作人员的意见：
				String suggestText = suggest.getText();
				if(suggestText == null || suggestText.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "输入建议不能为空！");
					return ;
				}
				
				//获得确切时间
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStringParse = sdf.format(Calendar.getInstance().getTime());
				//获取病人姓名
				String patientname = patient.getSelectedItem().toString();
				
				Patient patientTemp = Patient.getPatient();
				//获取模板信息
				String problemModelname = modelName.getSelectedItem().toString();
				ProblemModel modelTemp = ProblemModel.getProblemModel();
				
				for(Patient t : patients)
				{
					if(patientname.equals(t.getName()))
					{
						patientTemp = t;
					}
				}
				
				for(ProblemModel t : problemModels)
				{
					if(problemModelname.equals(t.getName()))
					{
						modelTemp = t;
					}
				}
				//获取员姓名
				String EmployeeName = employeeLogin.getName();
				
				//生成评估类
				UserEvaluate userEvaluate = UserEvaluate.getUserEvaluate();
				userEvaluate.setTime(dateStringParse);
				userEvaluate.setSuggest(suggestText);
				userEvaluate.setProblemModel(modelTemp);
				userEvaluate.setPatientName(patientname);
				userEvaluate.setEvaluator(employeeLogin);
				userEvaluate.setPatientGender(patientTemp.getGender());
				userEvaluate.setPoints(pointsss);
				List<UserEvaluate> userEvaluates = GetDataClass.getDataUserEvaluate();
				userEvaluates.add(userEvaluate);
				WriteDataClass.writeDataUserEvaluate(userEvaluates);
				JOptionPane.showMessageDialog(null, "建议成功！");
				tableInit();
				dispose();
			}
		}
	}
	
	

}
