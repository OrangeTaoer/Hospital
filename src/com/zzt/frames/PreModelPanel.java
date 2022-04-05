package com.zzt.frames;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

import com.zzt.entity.Problem;
import com.zzt.entity.ProblemModel;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.WriteDataClass;

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
public class PreModelPanel extends javax.swing.JPanel {

	/**
	 * 文件操作
	 */

	List<Problem> problems = GetDataClass.getDataProblemClass();
	List<ProblemModel> problemModels = GetDataClass
			.getDataProblemModelClass();
	private JTable jTable111;
	private JScrollPane EmployeeJSPane;
	private JButton find;
	private JTextField findAcNumber;
	private JLabel jLabel1;
	private JButton delete;
	private JButton add;
	private TableModel jTableModel;
	private JComboBox problemListID;
	private JLabel name = new JLabel();
	private JButton flush;
	private String modelID = "2";
	private ComboBoxModel problemListIDModel;
	private JLabel hhhhh;
	private List<Problem> problems2 ;
	// 获取模板
	private ProblemModel pbmt;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new PreModelPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public PreModelPanel() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(964, 737));
			this.setLayout(null);
			{
				add = new JButton();
				this.add(add);
				add.setText("\u589e\u52a0");
				add.setBounds(717, 572, 88, 64);
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
				delete.setBounds(723, 84, 82, 65);
				delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						deleteActionPerformed(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("\u9898\u76eeID");
				jLabel1.setBounds(413, 21, 69, 44);
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
				EmployeeJSPane.setBounds(34, 147, 769, 423);
				viewTable();
			}
			{
				flush = new JButton();
				this.add(flush);
				flush.setText("\u5237\u65b0");
				flush.setBounds(33, 84, 76, 65);
				flush.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						flushActionPerformed(evt);
					}
				});
			}
			{
				name = new JLabel();
				this.add(name);
				name.setText("\u6a21\u677f");
				name.setBounds(35, 41, 300, 31);
			}
			{

				problemListID = new JComboBox();
				this.add(problemListID);
				problemListID.setModel(problemListIDModel);
				problemListID.setBounds(521, 590, 107, 32);
			}
			{
				hhhhh = new JLabel();
				this.add(hhhhh);
				hhhhh.setText("\u95ee\u9898ID");
				hhhhh.setBounds(378, 583, 116, 46);
			}
			{
				jTable111 = new JTable();
				this.add(jTable111);
				jTable111.setModel(jTableModel);
				jTable111.setBounds(33, 151, 770, 147);
				viewTable();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void viewTable() {

		boolean flagView = true;
		String[] colNames = new String[] { "id", "题目", "类型" };
		int i = 0;
		List<String> problemID = new ArrayList<String>();
		problemModels = GetDataClass.getDataProblemModelClass();
		problems = GetDataClass.getDataProblemClass();

		int size1 = 0;
		// 判断是否为空，避免空指针异常
		if (problems != null && !problems.isEmpty()) {
			size1 = problems.size();
		}

		String[] addlis = new String[size1];
		int i2 = 0;
		for (Problem t : problems) {
			addlis[i2++] = t.getId();
		}
		// 更新可加问题列表
		problemListIDModel = new DefaultComboBoxModel(addlis);

		if (problemModels == null || problemModels.isEmpty()
				|| problems.isEmpty()) {
			flagView = false;
			JOptionPane.showMessageDialog(null, "该模板没有问题");
		}

		for (ProblemModel t : problemModels) {
			if (t.getId().equals(modelID)) {
				pbmt = t;
				break;
			}
		}
		
		problems2 = pbmt.getProblemss();
		
		
		List<Problem> delproblems2 = new ArrayList<Problem>();
		int size = 0;

		if (problems2 != null && !problems2.isEmpty()) {
			// 判断模板中的问题是否还存在，若问题已被删除，则需要删除模板中的问题
			for (Problem t1 : problems2) {
				boolean flagg = false; // 假设不存在
				for (Problem t2 : problems) {
					if (t1.getId().equals(t2.getId())) {
						flagg = true;
						break;
					}
				}
				if (!flagg) {
					delproblems2.add(t1);
				}
			}
		}
		for (Problem t3 : delproblems2) {
			problems2.remove(t3);
		}
		if(problems2 == null || problems2.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "该模板暂无问题!");
			return;
		}
		
		size = problems2.size();
		pbmt.setProblemss(problems2);
		//找到想要添加的模板的位置
		int cnt = 0 ;
		for (ProblemModel tm : problemModels) {
			if (!tm.getId().equals(pbmt.getId())) {
				cnt++;
			} else {
				break;
			}
		}
		problemModels.set(cnt, pbmt);
		WriteDataClass.writeDataProblemModel(problemModels);
		String[][] content = new String[size][colNames.length];

		// 设置Table内容
		if (size > 0 && !problems.isEmpty()) {
			for (Problem t : problems2) {
				content[i++] = new String[] { t.getId(), t.getTitle(),
						t.getType() };
			}
		}
		if (flagView) {
			jTableModel = new DefaultTableModel(content, colNames);
			// 设置为不可编辑！
			jTable111 = new JTable(jTableModel) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			// jTable111 = new JTable();
			EmployeeJSPane.setViewportView(jTable111);
			jTable111.setModel(jTableModel);

			// 添加到主界面
			jTable111.setFillsViewportHeight(true);
			jTable111.setRowSelectionAllowed(true); // 整行选择
			jTable111.setRowHeight(30);

			// 列设置：自定义绘制
			jTable111.getColumnModel().getColumn(0)
					.setCellRenderer(new IDColumnRender());
			repaint();
		} else {

			jTableModel = new DefaultTableModel(new String[][] {}, colNames);
			// 设置为不可编辑！
			jTable111 = new JTable(jTableModel) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			// jTable111 = new JTable();
			EmployeeJSPane.setViewportView(jTable111);
			jTable111.setModel(jTableModel);

			// 添加到主界面
			jTable111.setFillsViewportHeight(true);
			jTable111.setRowSelectionAllowed(true); // 整行选择
			jTable111.setRowHeight(30);

			// 列设置：自定义绘制
			jTable111.getColumnModel().getColumn(0)
					.setCellRenderer(new IDColumnRender());
			repaint();
		}

	}

	private void addActionPerformed(ActionEvent evt) {
		String getID = problemListID.getSelectedItem().toString();
		List<Problem> temp = pbmt.getProblemss();
		//判断是否为空
		if (temp == null || temp.isEmpty()) {
			temp = new ArrayList<Problem>();
		}
		//遍历problems找出想要添加哪一个id的问题
		for (Problem tx : problems) {
			if (getID.equals(tx.getId())) {
				temp.add(tx);
				break;
			}
		}
		pbmt.setProblemss(temp);
		int cnt = 0;
		//找到想要添加的模板的位置
		for (ProblemModel tm : problemModels) {
			if (!tm.getId().equals(pbmt.getId())) {
				cnt++;
			} else {
				break;
			}
		}
		problemModels.set(cnt, pbmt);
		WriteDataClass.writeDataProblemModel(problemModels);
		viewTable();
	}

	private void deleteActionPerformed(ActionEvent evt) {
		// 点 '删除' 按钮
		
		// 获取选中的行的索引
		int[] rows = jTable111.getSelectedRows();
		if (rows.length == 0) {
			JOptionPane.showMessageDialog(null, "您尚未选择想要删除的问题！");
			return;
		}

		// 弹出对话框确认
		int select = JOptionPane.showConfirmDialog(this, "是否确认删除?", "确认",
				JOptionPane.YES_NO_OPTION);
		if (select != 0)
			return; // 0号按钮是'确定'按钮

		for (int i = rows.length - 1; i >= 0; i--) {
			int row = rows[i];
			if(row<problems2.size())
			{
				problems2.remove(row);
			}
		}
		pbmt.setProblemss(problems2);
		problemModels = GetDataClass.getDataProblemModelClass();
		//找到想要添加的模板的位置
		int cnt = 0 ;
		for (ProblemModel tm : problemModels) {
			if (!tm.getId().equals(pbmt.getId())) {
				cnt++;
			} else {
				break;
			}
		}
		problemModels.set(cnt, pbmt);
		WriteDataClass.writeDataProblemModel(problemModels);
		viewTable();
	}

	boolean flag = false;



	private void flushActionPerformed(ActionEvent evt) {
		viewTable();
	}

	private void findActionPerformed(ActionEvent evt) {
		viewTable();
		String text = findAcNumber.getText();
		if (text == null || "".equals(text)) {
			JOptionPane.showMessageDialog(null, "请输入查询的id！");
			return;
		}
		boolean flag = false;
		String[] colNames = new String[] { "id", "题目", "类型" };

		String[][] content = new String[1][colNames.length];

		for (Problem t : problems2) {
			if (text.equals(t.getId())) {
				content[0] = new String[] { t.getId(), t.getTitle(),
						t.getType() };
				flag = true;
				break;
			}
		}

		jTableModel = new DefaultTableModel(content, colNames);

		jTable111.setModel(jTableModel);
		// 添加到主界面
		jTable111.setFillsViewportHeight(true);
		jTable111.setRowSelectionAllowed(true); // 整行选择
		jTable111.setRowHeight(30);

		// 列设置：自定义绘制
		jTable111.getColumnModel().getColumn(0)
				.setCellRenderer(new IDColumnRender());
		repaint();

		if (!flag) {
			JOptionPane.showMessageDialog(null, "查不到您所要查询的内容！");
			return;
		}
	}
	

}
