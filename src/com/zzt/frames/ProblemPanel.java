package com.zzt.frames;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.zzt.entity.Patient;
import com.zzt.entity.Problem;
import com.zzt.tool.FileTool;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.IDparse;
import com.zzt.tool.WriteDataClass;

public class ProblemPanel extends javax.swing.JPanel {

	/**
	 * 文件操作
	 */
	List<Problem> problems = GetDataClass.getDataProblemClass();
	private JTable jTable;
	private JScrollPane EmployeeJSPane;
	private JButton find;
	private JTextField findAcNumber;
	private JLabel jLabel1;
	private JButton correct;
	private JButton delete;
	private JButton add;
	private TableModel jTableModel;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JButton explain;
	private JComboBox type;
	private JTextField op3;
	private JTextField op2;
	private JTextField op1;
	private JTextField title;
	private JButton correctEnter;
	private JButton flush;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ProblemPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public ProblemPanel() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(860, 727));
			this.setLayout(null);
			{
				add = new JButton();
				this.add(add);
				add.setText("\u589e\u52a0");
				add.setBounds(0, 0, 88, 65);
				add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addActionPerformed(evt);
					}
				});
			}
			{
				delete = new JButton();
				this.add(delete);
				delete.setText("\u5220\u9664");
				delete.setBounds(88, 0, 82, 65);
				delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						deleteActionPerformed(evt);
					}
				});
			}
			{
				correct = new JButton();
				this.add(correct);
				correct.setText("\u4fee\u6539");
				correct.setBounds(170, 0, 76, 65);
				correct.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						correctActionPerformed(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("\u59d3\u540d");
				jLabel1.setBounds(431, 21, 51, 44);
			}
			{
				findAcNumber = new JTextField();
				this.add(findAcNumber);
				findAcNumber.setBounds(494, 30, 191, 27);
			}
			{
				find = new JButton();
				this.add(find);
				find.setText("\u67e5\u8be2");
				find.setBounds(714, 0, 70, 65);
				find.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						findActionPerformed(evt);
					}
				});
			}
			{
				EmployeeJSPane = new JScrollPane();
				this.add(EmployeeJSPane);
				EmployeeJSPane.setBounds(33, 110, 772, 390);
				{
					viewTable();
				}
			}
			{
				flush = new JButton();
				this.add(flush);
				flush.setText("\u5237\u65b0");
				flush.setBounds(246, 0, 76, 65);
				flush.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						flushActionPerformed(evt);
					}
				});
			}
			{
				correctEnter = new JButton();
				this.add(correctEnter);
				correctEnter.setText("\u786e\u5b9a");
				correctEnter.setBounds(755, 563, 76, 88);
				correctEnter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						correctEnterActionPerformed(evt);
					}
				});
			}
			{
				title = new JTextField();
				this.add(title);
				title.setBounds(77, 529, 225, 47);
			}
			{
				op1 = new JTextField();
				this.add(op1);
				op1.setBounds(425, 523, 240, 40);
			}
			{
				op2 = new JTextField();
				this.add(op2);
				op2.setBounds(425, 586, 240, 45);
			}
			{
				op3 = new JTextField();
				this.add(op3);
				op3.setBounds(425, 651, 240, 48);
			}
			{
				ComboBoxModel typeModel = new DefaultComboBoxModel(
						new String[] { "A", "B", "C" });
				type = new JComboBox();
				this.add(type);
				type.setModel(typeModel);
				type.setBounds(77, 604, 223, 42);
			}
			{
				explain = new JButton();
				this.add(explain);
				explain.setText("\u8be6\u60c5");
				explain.setBounds(322, 0, 72, 65);
				explain.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						explainActionPerformed(evt);
					}
				});
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setBounds(6, 536, 65, 32);
				jLabel2.setName("jLabel2");
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setBounds(6, 615, 53, 31);
				jLabel3.setName("jLabel3");
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setBounds(362, 532, 60, 20);
				jLabel4.setName("jLabel4");
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setBounds(362, 596, 60, 20);
				jLabel5.setName("jLabel5");
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6);
				jLabel6.setBounds(362, 664, 60, 20);
				jLabel6.setName("jLabel6");
			}
			{
				jTable = new JTable();
				this.add(jTable);
				jTable.setModel(jTableModel);
				jTable.setBounds(36, 132, 769, 363);
				viewTable();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void viewTable() {
		String[] colNames = new String[] { "id", "题目", "类型" };
		int i = 0;
		problems = GetDataClass.getDataProblemClass();
		int size = problems.size();
		String[][] content = new String[size][colNames.length];
		if (!problems.isEmpty()) {
			for (Problem t : problems) {
				content[i++] = new String[] { t.getId(), t.getTitle(),
						t.getType() };
			}
		}

		jTableModel = new DefaultTableModel(content, colNames);
		// 设置为不可编辑！
		jTable = new JTable(jTableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// jTable = new JTable();
		EmployeeJSPane.setViewportView(jTable);
		jTable.setModel(jTableModel);

		// 添加到主界面
		jTable.setFillsViewportHeight(true);
		jTable.setRowSelectionAllowed(true); // 整行选择
		jTable.setRowHeight(30);

		// 列设置：自定义绘制
		jTable.getColumnModel().getColumn(0)
				.setCellRenderer(new IDColumnRender());

		repaint();
	}

	private void addActionPerformed(ActionEvent evt) {
		AddProblem inst = new AddProblem();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	private void deleteActionPerformed(ActionEvent evt) {
		// 点 '删除' 按钮
		problems = GetDataClass.getDataProblemClass();
		// 获取选中的行的索引
		int[] rows = jTable.getSelectedRows();
		if (rows.length == 0) {
			JOptionPane.showMessageDialog(null, "您尚未选择想要删除的用户！");
			return;
		}

		// 弹出对话框确认
		int select = JOptionPane.showConfirmDialog(this, "是否确认删除?", "确认",
				JOptionPane.YES_NO_OPTION);
		if (select != 0)
			return; // 0号按钮是'确定'按钮

		for (int i = rows.length - 1; i >= 0; i--) {
			int row = rows[i];
			if (row < problems.size())
				problems.remove(row);
		}
		WriteDataClass.writeDataProblem(problems);
		viewTable();
	}

	boolean flag = false;

	private void correctActionPerformed(ActionEvent evt) {
		// 点 '修改' 按钮
		problems = GetDataClass.getDataProblemClass();
		// 获取选中的行的索引
		int[] rows = jTable.getSelectedRows();
		if (rows.length == 0) {
			JOptionPane.showMessageDialog(null, "您尚未选择想要修改的问题！");
			return;
		}
		if (rows.length > 1) {
			JOptionPane.showMessageDialog(null, "一次仅允许修改一个问题！");
			return;
		}
		flag = true;
		JOptionPane.showMessageDialog(null, "请在显示框下方进行修改！");
		return;
	}

	private void correctEnterActionPerformed(ActionEvent evt) {
		problems = GetDataClass.getDataProblemClass();
		//
		int[] rows = jTable.getSelectedRows();
		if (!flag) {
			JOptionPane.showMessageDialog(null, "请先选择上方的修改键判断是否能够修改！");
			return;
		}
		if (rows.length != 1) {
			JOptionPane.showMessageDialog(null, "请重新选择！");
			return;
		}
		int row = rows[0];

		Problem t = Problem.getProblem();

		String title1 = title.getText();
		String type1 = type.getSelectedItem().toString();
		String an1 = op1.getText();
		String an2 = op2.getText();
		String an3 = op3.getText();
		t.setTitle(title1);
		t.setType(type1);
		t.setOptions1(an1);
		t.setOptions2(an2);
		t.setOptions3(an3);

		problems.set(row, t);

		JOptionPane.showMessageDialog(null, "修改成功！");
		title.setText("");
		op1.setText("");
		op2.setText("");
		op3.setText("");
		WriteDataClass.writeDataProblem(problems);
		viewTable();
	}

	private void flushActionPerformed(ActionEvent evt) {
		viewTable();
	}

	private void findActionPerformed(ActionEvent evt) {
		String text = findAcNumber.getText();
		if (text == null || "".equals(text)) {
			JOptionPane.showMessageDialog(null, "请输入查询的id！");
			return;
		}
		boolean flag = false;
		String[] colNames = new String[] { "id", "题目", "类型" };

		String[][] content = new String[1][colNames.length];

		for (Problem t : problems) {
			if (text.equals(t.getId())) {
				content[0] = new String[] { t.getId(), t.getTitle(),
						t.getType() };
				flag = true;
				break;
			}
		}

		jTableModel = new DefaultTableModel(content, colNames);

		jTable.setModel(jTableModel);
		// 添加到主界面
		jTable.setFillsViewportHeight(true);
		jTable.setRowSelectionAllowed(true); // 整行选择
		jTable.setRowHeight(30);

		// 列设置：自定义绘制
		jTable.getColumnModel().getColumn(0)
				.setCellRenderer(new IDColumnRender());
		jTable.setPreferredSize(new java.awt.Dimension(675, 325));
		repaint();

		if (!flag) {
			JOptionPane.showMessageDialog(null, "查不到您所要查询的内容！");
			return;
		}
	}

	private void explainActionPerformed(ActionEvent evt) {

		// 点 '详情' 按钮
		problems = GetDataClass.getDataProblemClass();
		// 获取选中的行的索引
		int[] rows = jTable.getSelectedRows();
		if (rows.length == 0) {
			JOptionPane.showMessageDialog(null, "您尚未选择想要修改的问题！");
			return;
		}
		if (rows.length > 1) {
			JOptionPane.showMessageDialog(null, "一次仅允许查看一个问题！");
			return;
		}
		String id = jTable.getValueAt(rows[0], 0).toString();
		Problem temp = Problem.getProblem();
		for (Problem t : problems) {
			if (id.equals(t.getId())) {
				temp = t;
			}
		}
		JOptionPane.showMessageDialog(null, temp.getTitle() + "\n" + "A."
				+ temp.getOptions1() + "\n" + "B." + temp.getOptions2() + "\n"
				+ "C." + temp.getOptions3());
	}

}
