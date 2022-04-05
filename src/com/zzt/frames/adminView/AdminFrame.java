package com.zzt.frames.adminView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.zzt.controller.impl.EmployeeControllerImpl;
import com.zzt.entity.Employee;
import com.zzt.frames.IDColumnRender;
import com.zzt.tool.FileTool;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.JsonTool;
import com.zzt.tool.WriteDataClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class AdminFrame extends javax.swing.JFrame {
	private JLabel manager;
	private JButton delete;
	private JTable jTable;
	private JButton add;
	private JCheckBox jCBox;
	private JTable jtable;
	private JScrollPane EmployeeJSPane;
	private TableModel jTableModel = new DefaultTableModel();
	private JTextField correctAdvantage;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JButton return11;
	private JTextField findacNumber;
	private JButton find;
	private JLabel jLabel1;
	private JButton correctCorrect;
	private JPasswordField correctPassword2;
	private JPasswordField correctPassword1;
	private JComboBox correctPosition;
	private JTextField correctIdNumber;
	private JTextField correctName;
	private JButton Correct;
	private JButton flush;
	private JComboBox positionName;
	// 使用哈希表这一数据结构，在显示数据（遍历数据）时候
	// 将Employee的唯一id作为哈希表的键值，将其在List中的序号作为哈希值
	// 在查询操作中可将时间复杂度由O(n)级别降到O(1)级别
	private Map hash;
	// 控制器控制视图
	private EmployeeControllerImpl employeeControllerImpl;

	/**
	 * 文件操作
	 */
	List<Employee> employees = GetDataClass.getDataEmployeeClass();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AdminFrame inst = new AdminFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public AdminFrame() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			{
				this.setSize(623, 545);
			}
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("\u533b\u9662\u7ba1\u7406\u7cfb\u7edf");
			getContentPane().setLayout(null);
			{
				manager = new JLabel();
				getContentPane().add(manager);
				manager.setText("\u7ba1\u7406\u5458\u754c\u9762");
				manager.setBounds(704, 12, 118, 45);
			}
			{
				EmployeeJSPane = new JScrollPane();
				getContentPane().add(EmployeeJSPane);
				EmployeeJSPane.setBounds(144, 137, 706, 244);
				{
					// 使用控制器更新数据
					employeeControllerImpl = EmployeeControllerImpl
							.getEmployeeControllerImpl();
					employees = employeeControllerImpl.getEmployee();

					viewTable("全部");
				}
			}
			{
				add = new JButton();
				getContentPane().add(add);
				add.setText("\u6dfb\u52a0");
				add.setBounds(144, 78, 90, 60);
				add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addActionPerformed(evt);
					}
				});
			}
			{
				delete = new JButton();
				getContentPane().add(delete);
				delete.setText("\u5220\u9664");
				delete.setBounds(234, 78, 90, 60);
				delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						deleteActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel positionNameModel = new DefaultComboBoxModel(
						new String[] { "全部", "医生", "护士", "护工" });
				positionName = new JComboBox();
				getContentPane().add(positionName);
				positionName.setModel(positionNameModel);
				positionName.setBounds(35, 89, 108, 50);
				positionName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						positionNameActionPerformed(evt);
					}
				});

			}
			{
				flush = new JButton();
				getContentPane().add(flush);
				flush.setText("\u5237\u65b0");
				flush.setBounds(35, 135, 90, 61);
				flush.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						flushActionPerformed(evt);
					}
				});
			}
			{
				Correct = new JButton();
				getContentPane().add(Correct);
				Correct.setText("\u4fee\u6539");
				Correct.setBounds(323, 78, 90, 60);
				Correct.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						CorrectActionPerformed(evt);
					}
				});
			}
			{
				correctName = new JTextField();
				getContentPane().add(correctName);
				correctName.setBounds(186, 433, 96, 45);
			}
			{
				correctIdNumber = new JTextField();
				getContentPane().add(correctIdNumber);
				correctIdNumber.setBounds(402, 433, 302, 45);
			}
			{
				ComboBoxModel correctPositionModel = new DefaultComboBoxModel(
						new String[] { "医生", "护士", "护工" });
				correctPosition = new JComboBox();
				getContentPane().add(correctPosition);
				correctPosition.setModel(correctPositionModel);
				correctPosition.setBounds(186, 497, 96, 42);
			}
			{
				correctAdvantage = new JTextField();
				getContentPane().add(correctAdvantage);
				correctAdvantage.setBounds(186, 561, 96, 42);
			}
			{
				correctPassword1 = new JPasswordField();
				getContentPane().add(correctPassword1);
				correctPassword1.setBounds(402, 497, 302, 42);
			}
			{
				correctPassword2 = new JPasswordField();
				getContentPane().add(correctPassword2);
				correctPassword2.setBounds(402, 561, 302, 42);
			}
			{
				correctCorrect = new JButton();
				getContentPane().add(correctCorrect);
				correctCorrect.setText("\u786e\u5b9a");
				correctCorrect.setBounds(774, 486, 83, 84);
				correctCorrect.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						correctCorrectActionPerformed(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u767b\u5f55\u540d");
				jLabel1.setBounds(448, 97, 45, 20);
			}
			{
				find = new JButton();
				getContentPane().add(find);
				find.setText("\u67e5\u8be2");
				find.setBounds(694, 83, 80, 41);
				find.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						findActionPerformed(evt);
					}
				});
			}
			{
				findacNumber = new JTextField();
				getContentPane().add(findacNumber);
				findacNumber.setBounds(505, 91, 167, 33);
			}
			{
				return11 = new JButton();
				getContentPane().add(return11);
				return11.setText("\u6ce8\u9500");
				return11.setBounds(805, 12, 83, 59);
				return11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						return11ActionPerformed(evt);
					}
				});
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u59d3\u540d");
				jLabel2.setBounds(121, 436, 49, 39);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u804c\u4f4d");
				jLabel3.setBounds(121, 503, 41, 31);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u4e13\u957f");
				jLabel4.setBounds(121, 568, 41, 35);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u8eab\u4efd\u8bc1\u53f7");
				jLabel5.setBounds(316, 439, 74, 33);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u5bc6\u7801");
				jLabel6.setBounds(316, 503, 56, 31);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("\u5bc6\u7801");
				jLabel7.setBounds(316, 571, 44, 27);
			}
			pack();
			this.setSize(926, 684);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	// 更新界面函数：
	private void viewTable(String x) {
		employees = employeeControllerImpl.getEmployee(); // 使用控制器获取employees类
		List<Employee> doctors = new ArrayList<Employee>();// 实例化另一个要显示的类
		// 判断是否为空，防止空指针异常
		if (employees == null || employees.isEmpty()) {
			return;
		}
		// 哈希表初始化
		hash = new HashMap<String, Integer>();
		Integer i = 0;
		for (Employee t : employees) {
			hash.put(t.getAcNumber(), i++);
			if (x.equals(t.getPosition())) {
				doctors.add(t);
			}
		}
		String[] colNames = new String[] { "登录名", "姓名", "出生日期", "职称", "专长",
				"身份证" };
		int size = doctors.size();
		if (size == 0 && !x.equals("全部")) {
			JOptionPane.showMessageDialog(null, "暂无" + x + "名单！");
			return;
		}
		if (x.equals("全部")) {
			doctors = employees;
			size = employees.size();
		}
		String[][] content = new String[size][colNames.length];
		int i1 = 0;
		for (Employee t : doctors) {
			content[i1++] = new String[] { t.getAcNumber(), t.getName(),
					t.getBirthday(), t.getPosition(), t.getAdvantage(),
					t.getIdNumber() };
		}
		jTableModel = new DefaultTableModel(content, colNames);// 更新模板

		jTable = new JTable(jTableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;// 实现以使table不可编辑
			}
		};
		EmployeeJSPane.setViewportView(jTable);
		// 添加到主界面
		jTable.setFillsViewportHeight(true);
		jTable.setRowSelectionAllowed(true); // 整行选择
		jTable.setRowHeight(30);

		// 列设置：自定义绘制
		jTable.getColumnModel().getColumn(0)
				.setCellRenderer(new IDColumnRender());// 使用自己写的单元格
		jTable.getColumnModel().getColumn(5).setPreferredWidth(140); // 设置该列的宽度
		jTable.setPreferredSize(new java.awt.Dimension(727, 217));// 设置尺寸
		repaint();// 防止部件部分显示
	}

	private void addActionPerformed(ActionEvent evt) {
		AddEmployee inst = new AddEmployee();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
		employees = employeeControllerImpl.getEmployee();
		viewTable("全部");
	}

	private void deleteActionPerformed(ActionEvent evt) {
		// 点 '删除' 按钮
		employees = employeeControllerImpl.getEmployee();
		// 获取选中的行的索引
		int[] rows = jTable.getSelectedRows();
		if (rows.length == 0) {
			JOptionPane.showMessageDialog(null, "您尚未选择想要删除的用户！");
			return;
		}

		// 弹出对话框确认
		int select = JOptionPane.showConfirmDialog(this, "是否确认删除?", "确认",
				JOptionPane.YES_NO_OPTION);
		if (select != 0) {
			return;
		} // 0号按钮是'确定'按钮

		for (int i = rows.length - 1; i >= 0; i--) {
			int row = rows[i];
			if (row < employees.size())
				employees.remove(row);
		}
		WriteDataClass.writeDataEmployee(employees);
		viewTable("全部");
	}

	private void positionNameActionPerformed(ActionEvent evt) {
		employees = employeeControllerImpl.getEmployee();
		String x = positionName.getSelectedItem().toString();
		viewTable(x);
	}

	private void flushActionPerformed(ActionEvent evt) {
		employees = employeeControllerImpl.getEmployee();
		String x = positionName.getSelectedItem().toString();
		viewTable(x);
	}

	private void findActionPerformed(ActionEvent evt) {
		String text = findacNumber.getText();
		if (text == null || "".equals(text)) {
			JOptionPane.showMessageDialog(null, "请输入查询的登录名！");
			return;
		}
		boolean flag = false;

		// 使用哈希表数据结构，将查询的时间复杂度从o(n)降到O(1)级别
		Integer t1 = employeeControllerImpl.findEmployee(text,
				(HashMap<String, Integer>) hash);
		Employee t = employees.get(t1);
		String[] colNames = new String[] { "登录名", "姓名", "出生日期", "职称", "专长",
				"身份证" };
		String[][] content = new String[1][colNames.length];
		content[0] = new String[] { t.getAcNumber(), t.getName(),
				t.getBirthday(), t.getPosition(), t.getAdvantage(),
				t.getIdNumber() };
		jTableModel = new DefaultTableModel(content, colNames);
		jTable = new JTable();
		EmployeeJSPane.setViewportView(jTable);
		jTable.setModel(jTableModel);

		// 添加到主界面
		jTable.setFillsViewportHeight(true);
		jTable.setRowSelectionAllowed(true); // 整行选择
		jTable.setRowHeight(30);

		// 列设置：自定义绘制
		jTable.getColumnModel().getColumn(0)
				.setCellRenderer(new IDColumnRender());
		jTable.getColumnModel().getColumn(5).setPreferredWidth(140); // 该列的宽度
		jTable.setPreferredSize(new java.awt.Dimension(727, 217));
		repaint();
	}

	boolean flag = false;

	private void CorrectActionPerformed(ActionEvent evt) {
		// 点 '删除' 按钮
		employees = GetDataClass.getDataEmployeeClass();
		// 获取选中的行的索引
		int[] rows = jTable.getSelectedRows();
		if (rows.length == 0) {
			JOptionPane.showMessageDialog(null, "您尚未选择想要修改的用户！");
			return;
		}
		if (rows.length > 1) {
			JOptionPane.showMessageDialog(null, "一次仅允许修改一个用户！");
			return;
		}
		flag = true;
		JOptionPane.showMessageDialog(null, "请在显示框下方进行修改！");
		return;
	}

	private void correctCorrectActionPerformed(ActionEvent evt) {
		// 点 '修改' 按钮
		employees = GetDataClass.getDataEmployeeClass();
		// 获取选中的行的索引
		int[] rows = jTable.getSelectedRows();

		if (!flag) {
			JOptionPane.showMessageDialog(null, "请先选择上方的修改键判断是否能够修改！");
			return;
		}
		String name = correctName.getText();
		String idNumber = correctIdNumber.getText();
		String password1 = new String(correctPassword1.getPassword());
		String password2 = new String(correctPassword2.getPassword());
		String position = correctPosition.getSelectedItem().toString();
		String advantage = correctAdvantage.getText();
		if (!password1.equals(password2)) {
			JOptionPane.showMessageDialog(null, "两次输入的密码不一致！请重新输入");
			return;
		}
		if (idNumber.length() != 18) {
			JOptionPane.showMessageDialog(null, "身份证号不规范！请重新输入");
			return;
		}
		if (rows.length == 0) {
			return;
		}
		int row = rows[0];

		Employee t = Employee.getEmployee();
		// 获取选中的id值
		String id = (String) jTableModel.getValueAt(row, 0);
		// 设置相应的员工数据
		t.setAcNumber(id);
		t.setAdvantage(advantage);
		t.setIdNumber(idNumber);
		t.setName(name);
		t.setPassword(password2);
		t.setPosition(position);
		// 调用控制器来修改底层数据
		employeeControllerImpl.correctEmployee(id, t);
		JOptionPane.showMessageDialog(null, "修改成功！");
		correctName.setText("");
		correctIdNumber.setText("");
		correctPassword1.setText(null);
		correctPassword2.setText(null);
		correctAdvantage.setText("");
		viewTable("全部");
	
	}

	private void return11ActionPerformed(ActionEvent evt) {
		int select = JOptionPane.showConfirmDialog(this, "是否确认关闭?", "确认",
				JOptionPane.YES_NO_OPTION);
		if (select != 0)
			return; // 0号按钮是'确定'按钮
		dispose();
	}

}
