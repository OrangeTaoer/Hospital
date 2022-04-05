package com.zzt.frames.evaluateView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.zzt.entity.Employee;
import com.zzt.entity.Patient;
import com.zzt.entity.Problem;
import com.zzt.entity.ProblemModel;
import com.zzt.entity.UserEvaluate;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.WriteDataClass;

public class EvaluateManage extends javax.swing.JPanel {
	private JComboBox patient;
	private JComboBox modelName;
	private JScrollPane jScrollPane1;
	private JButton close;
	private JTable evaluate2;
	private JButton start;
	private List<Patient> patients;
	private List<ProblemModel> problemModels;
	private int sizepatient = 0;
	private int sizeproblemModel = 0;
	private String[] patientss = new String[] {};
	private String[] problemModelss = new String[] {};
	private Employee employeeLogin;
	private TableModel evaluate2Model;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new EvaluateManage());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public EvaluateManage() {
		super();
		initGUI();
	}

	private void initGUI() {
		employeeInit();
		dataInit();
		if (patients != null && !patients.isEmpty()) {
			sizepatient = patients.size();
			patientss = new String[sizepatient];
			int cnt = 0;
			for (Patient t : patients) {
				patientss[cnt++] = t.getName();
			}
		}

		if (problemModels != null && !problemModels.isEmpty()) {
			sizeproblemModel = problemModels.size();
			problemModelss = new String[sizeproblemModel];
			int cnt = 0;
			for (ProblemModel t : problemModels) {
				problemModelss[cnt++] = t.getName();
			}

		}

		try {
			this.setPreferredSize(new java.awt.Dimension(704, 770));
			this.setLayout(null);
			{
				ComboBoxModel patientModel = new DefaultComboBoxModel(patientss);
				patient = new JComboBox();
				this.add(patient);
				patient.setModel(patientModel);
				patient.setBounds(42, 70, 122, 37);
			}
			{
				ComboBoxModel modelNameModel = new DefaultComboBoxModel(
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
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(0, 146, 704, 368);
				evaluate2 = new JTable();
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

	private void dataInit() {
		patients = GetDataClass.getDataPatientClass();
		problemModels = GetDataClass.getDataProblemModelClass();
	}

	private void tableInit() {
		dataInit();
		String[] colNames = { "姓名", "性别", "模板名称", "模板类型", "时间", "评估人", "建议" };

		// 首先从文件中读出所有评估信息：
		List<UserEvaluate> userEvaluates1 = new ArrayList<UserEvaluate>();
		userEvaluates1 = GetDataClass.getDataUserEvaluate();

		// 计算所有该员工的评估信息的大小并且保存：
		int size = 0;
		for (UserEvaluate t : userEvaluates1) {
			if (t.getEvaluator().getName().equals(employeeLogin.getName())) {
				size++;
			}
		}
		String[][] content = new String[size][7];
		int i = 0;
		for (UserEvaluate t : userEvaluates1) {
			if (t.getEvaluator().getName().equals(employeeLogin.getName())) {
				content[i++] = new String[] { t.getPatientName(),
						t.getPatientGender(), t.getProblemModel().getName(),
						t.getProblemModel().getType(), t.getTime(),
						t.getEvaluator().getName(), t.getSuggest() };
			}
		}

		{
			evaluate2Model = new DefaultTableModel(content, colNames);
			jScrollPane1.setViewportView(evaluate2);
			evaluate2.setModel(evaluate2Model);
			evaluate2.getColumnModel().getColumn(4).setPreferredWidth(140);
		}

	}

	private void employeeInit() {
		employeeLogin = Employee.getEmployee();
		employeeLogin.setAcNumber("1111");
		employeeLogin.setName("你是谁");
		employeeLogin.setPassword("kkkk");
	}

	private void startActionPerformed(ActionEvent evt) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStringParse = sdf.format(Calendar.getInstance().getTime());
		String patientname = patient.getSelectedItem().toString();
		String problemModelname = modelName.getSelectedItem().toString();
		String patientgender = new String();
		String modelType = new String();
		for (Patient t : patients) {
			if (patientname.equals(t.getName())) {
				patientgender = t.getGender();
			}
		}

		for (ProblemModel t : problemModels) {
			if (problemModelname.equals(t.getName())) {
				modelType = t.getType();
			}
		}

		EvaluateFrame inst = new EvaluateFrame();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	// 评估界面
	public class EvaluateFrame extends javax.swing.JFrame {
		private JScrollPane jScrollPane1;
		private JButton return111;
		private JLabel jLabel3;
		private JLabel jLabel2;
		private JLabel jLabel1;
		private Map<String, Integer> points;

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
						jLabel1.setFont(new java.awt.Font("黑体", 2, 20));
					}
					{
						jLabel2 = new JLabel();
						getContentPane().add(jLabel2);
						jLabel2.setText("\u5de5\u4f5c\u4eba\u5458");
						jLabel2.setBounds(283, 19, 99, 50);
						jLabel2.setFont(new java.awt.Font("黑体", 2, 20));
					}
					{
						jLabel3 = new JLabel();
						getContentPane().add(jLabel3);
						jLabel3.setText(employeeLogin.getName());
						jLabel3.setBounds(374, 12, 91, 64);
						jLabel3.setFont(new java.awt.Font("黑体", 1, 20));
						// jLabel3.setBackground(Color.BLUE);
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
				// add your error handling code here
				e.printStackTrace();
			}
		}

		private void return111ActionPerformed(ActionEvent evt) {
			// 弹出对话框确认
			int select = JOptionPane.showConfirmDialog(this, "是否确认注销?", "确认",
					JOptionPane.YES_NO_OPTION);
			if (select != 0)
				return; // 0号按钮是'确定'按钮
			dispose();
		}

		public class EvaluatePanel extends javax.swing.JPanel {

			private String modelID = "2";
			private String filenameModel;
			private List<ProblemModel> problemModels;
			// 获取模板
			private ProblemModel pbmt;

			private List<Problem> problems2; // 该模板的问题

			private ButtonGroup[] bgs;
			private JRadioButton[] jrbs;
			private Integer[] scores = { 5, 3, 1 };// 定义A:5分，B:3分，C：1分
			private int lengths;
			private int high = 200; // 为所要设置的 panel根据问题的数量设置动态大小，使之大小适当
			private JButton btnSubmit; // 设置提交按钮

			public EvaluatePanel() {
				super();
				initGUI();
			}

			private void initGUI() {
				dataInit();

				guiInit();

				try {
					this.setPreferredSize(new java.awt.Dimension(539,
							high + 100));
					this.setLayout(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private void dataInit() {
				// 初始化要用到的变量
				lengths = 0;
				List<ProblemModel> problemModels = GetDataClass
						.getDataProblemModelClass();
				boolean flag = false;// 判断pbmt是否为已有模板
				// 获取模板
				for (ProblemModel t : problemModels) {
					if (t.getId().equals(modelID)) {
						pbmt = t;
						flag = true; // 若执行到此步，则代表为已有模板
						break;
					}
				}
				if (!flag) {
					JOptionPane.showMessageDialog(null, "该模板为不可用模板");
					return;
				}
				problems2 = pbmt.getProblemss();
				if (problems2.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"该模板不存在问题，请重新选择模板，或者为进入模板管理为该模板添加问题");
				}
			}

			private void guiInit() {
				lengths = problems2.size();
				// 若无问题存在在模板中，则跳出
				if (lengths == 0) {
					return;
				}

				bgs = new ButtonGroup[lengths];
				JLabel[] jbs = new JLabel[lengths];
				jrbs = new JRadioButton[3];// 定义三个单选

				int x = 50;// 动态控件组距离左边框距离
				int w = 350;// 动态标题及单选按钮宽
				int h = 45;// 动态单选按钮高

				for (int i = 0; i < lengths; i++) {
					Problem t = problems2.get(i);
					bgs[i] = new ButtonGroup();
					jbs[i] = new JLabel("第" + (i + 1) + "题:" + t.getTitle());
					jbs[i].setForeground(Color.red);
					jbs[i].setBounds(x, 5 + i * 120, w, h);
					this.add(jbs[i]);
					jbs[i].revalidate();

					jrbs[0] = new JRadioButton("A." + t.getOptions1());
					jrbs[0].setBounds(x, 35 + i * 120, w, h);
					jrbs[0].setActionCommand("q" + i);
					jrbs[0].addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent ae) {
							firstActionPerformed(ae);
						}
					});
					bgs[i].add(jrbs[0]);
					this.add(jrbs[0]);

					jrbs[1] = new JRadioButton("B." + t.getOptions2());
					jrbs[1].setBounds(x, 65 + i * 120, w, h);
					jrbs[1].setActionCommand("q" + i);
					jrbs[1].addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent ae) {
							secondActionPerformed(ae);
						}
					});
					bgs[i].add(jrbs[1]);
					this.add(jrbs[1]);

					jrbs[2] = new JRadioButton("C." + t.getOptions3());
					jrbs[2].setBounds(x, 95 + i * 120, w, h);
					jrbs[2].setActionCommand("q" + i);
					jrbs[2].addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent ae) {
							thirdActionPerformed(ae);
						}
					});
					bgs[i].add(jrbs[2]);
					this.add(jrbs[2]);
					if (i == lengths - 1) {
						high = 95 + i * 120 + h;
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

			Map<String, Integer> rs = new HashMap<String, Integer>();

			public void firstActionPerformed(ActionEvent arg0) {
				JRadioButton jb = (JRadioButton) arg0.getSource();
				String ac = jb.getActionCommand();
				rs.put(ac, scores[0]);
			}

			public void secondActionPerformed(ActionEvent arg0) {
				JRadioButton jb = (JRadioButton) arg0.getSource();
				String ac = jb.getActionCommand();
				rs.put(ac, scores[1]);
			}

			public void thirdActionPerformed(ActionEvent arg0) {
				JRadioButton jb = (JRadioButton) arg0.getSource();
				String ac = jb.getActionCommand();
				rs.put(ac, scores[2]);
			}

			private JButton getBtnSubmit() {
				if (btnSubmit == null) {
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
				int r = 0;
				for (Integer value : rs.values()) {
					r += value;
				}
				JOptionPane.showMessageDialog(this, "您的评估分数是=" + r);

				EvaluateSuggest inst = new EvaluateSuggest();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				dispose();
			}

		}

	}

	// 输入建议界面

	public class EvaluateSuggest extends javax.swing.JFrame {
		private JLabel jLabel1;
		private JTextField suggest;
		private JButton enter;

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
				// add your error handling code here
				e.printStackTrace();
			}
		}

		private void enterActionPerformed(ActionEvent evt) {

			// 获取工作人员的意见：
			String suggestText = suggest.getText();
			if (suggestText == null || suggestText.isEmpty()) {
				JOptionPane.showMessageDialog(null, "输入建议不能为空！");
				return;
			}

			// 获得确切时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStringParse = sdf.format(Calendar.getInstance()
					.getTime());
			// 获取病人姓名
			String patientname = patient.getSelectedItem().toString();

			Patient patientTemp = Patient.getPatient();
			// 获取模板信息
			String problemModelname = modelName.getSelectedItem().toString();
			ProblemModel modelTemp = ProblemModel.getProblemModel();

			for (Patient t : patients) {
				if (patientname.equals(t.getName())) {
					patientTemp = t;
				}
			}

			for (ProblemModel t : problemModels) {
				if (problemModelname.equals(t.getName())) {
					modelTemp = t;
				}
			}
			// 获取员姓名
			String EmployeeName = employeeLogin.getName();

			// 生成评估类
			UserEvaluate userEvaluate = UserEvaluate.getUserEvaluate();
			userEvaluate.setTime(dateStringParse);
			userEvaluate.setSuggest(suggestText);
			userEvaluate.setProblemModel(modelTemp);
			userEvaluate.setPatientName(patientname);
			userEvaluate.setEvaluator(employeeLogin);
			userEvaluate.setPatientGender(patientTemp.getGender());
			List<UserEvaluate> userEvaluates = GetDataClass
					.getDataUserEvaluate();
			userEvaluates.add(userEvaluate);
			WriteDataClass.writeDataUserEvaluate(userEvaluates);

			JOptionPane.showMessageDialog(null, "建议成功！");
			tableInit();
			dispose();
		}

	}
}
