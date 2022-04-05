package com.zzt.frames;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.zzt.controller.impl.PatientControllerImpl;
import com.zzt.entity.Patient;
import com.zzt.frames.employeeView.AddPatient;
import com.zzt.tool.FileTool;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.IDparse;
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
public class PatientPanel extends javax.swing.JPanel {

	/**
	 * 文件操作
	 */
	List<Patient> patients = GetDataClass.getDataPatientClass();
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
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JButton correctEnter;
	private JTextField idNumber;
	private JButton flush;
	private JTextField emPersonPhNumber;
	private JTextField emPerson;
	private JTextField phNumber;
	private PatientControllerImpl patientControllerImpl;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new PatientPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public PatientPanel() {
		super();
		Controllerinit();
		initGUI();
	}

	private void Controllerinit() {
		// 实例化控制器：
		patientControllerImpl = PatientControllerImpl
				.getPatientControllerImpl();
	}

	private void initGUI() {
		try {

			this.setPreferredSize(new java.awt.Dimension(880, 687));
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
				EmployeeJSPane.setBounds(0, 65, 874, 341);
				{
					viewTable();
				}
			}
			{
				phNumber = new JTextField();
				this.add(phNumber);
				phNumber.setBounds(121, 466, 179, 48);
			}
			{
				emPerson = new JTextField();
				this.add(emPerson);
				emPerson.setBounds(468, 467, 188, 45);
			}
			{
				emPersonPhNumber = new JTextField();
				this.add(emPersonPhNumber);
				emPersonPhNumber.setBounds(468, 560, 188, 43);
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
				idNumber = new JTextField();
				this.add(idNumber);
				idNumber.setBounds(121, 560, 179, 43);
			}
			{
				correctEnter = new JButton();
				this.add(correctEnter);
				correctEnter.setText("\u786e\u5b9a");
				correctEnter.setBounds(744, 489, 76, 88);
				correctEnter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						correctEnterActionPerformed(evt);
					}
				});
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("\u8054\u7cfb\u7535\u8bdd");
				jLabel2.setBounds(30, 472, 73, 35);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("\u8eab\u4efd\u8bc1\u53f7\u7801");
				jLabel3.setBounds(27, 565, 96, 32);
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setText("\u7d27\u6025\u8054\u7cfb\u4eba");
				jLabel4.setBounds(363, 473, 93, 33);
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setText("\u7d27\u6025\u8054\u7cfb\u4eba\u7535\u8bdd");
				jLabel5.setBounds(350, 554, 134, 54);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void viewTable() {
		String[] colNames = new String[] { "姓名", "年龄", "性别", "联系电话", "紧急联系人",
				"紧急联系电话" };
		int i = 0;

		// 通过控制器控制视图
		patients = patientControllerImpl.query();

		//
		int size = patients.size();
		String[][] content = new String[size][colNames.length];
		if (patients != null && !patients.isEmpty()) {
			for (Patient t : patients) {
				content[i++] = new String[] { t.getName(), t.getAge(),
						t.getGender(), t.getPhNumber(), t.getEmPerson(),
						t.getEmPhNumber() };
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
		// jTable.setModel(jTableModel);

		// 添加到主界面
		jTable.setFillsViewportHeight(true);
		jTable.setRowSelectionAllowed(true); // 整行选择
		jTable.setRowHeight(30);

		// 列设置：自定义绘制
		jTable.getColumnModel().getColumn(0)
				.setCellRenderer(new IDColumnRender());
		jTable.setPreferredSize(new java.awt.Dimension(856, 315));

		repaint();
	}

	private void addActionPerformed(ActionEvent evt) {
		AddPatient inst = new AddPatient();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	private void deleteActionPerformed(ActionEvent evt) {
		// 点 '删除' 按钮
		patients = patientControllerImpl.query();
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
			if (row < patients.size())
				patients.remove(row);
		}
		WriteDataClass.writeDataPatient(patients);
		viewTable();
	}

	boolean flag = false;

	private void correctActionPerformed(ActionEvent evt) {
		// 点 '修改' 按钮
		patients = GetDataClass.getDataPatientClass();
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

	private void correctEnterActionPerformed(ActionEvent evt) {
		patients = patientControllerImpl.query();
		//
		int[] rows = jTable.getSelectedRows();
		if (!flag) {
			JOptionPane.showMessageDialog(null, "请先选择上方的修改键判断是否能够修改！");
			return;
		}

		//获取修改的信息
		String phNumber1 = phNumber.getText();
		String emPerson1 = emPerson.getText();
		String emPhNumber1 = emPersonPhNumber.getText();

		if (rows.length == 0) {
			return;
		}
		int row = rows[0];

		Patient t = Patient.getPatient();

		//获取姓名
		String name1 = (String) jTableModel.getValueAt(row, 0);
		
		String idNumber1 = idNumber.getText();
		String age = IDparse.toAge(idNumber1);
		String gender = IDparse.toAge(idNumber1);

		//包装成新的病人类
		t.setAge(age);
		t.setEmPerson(emPerson1);
		t.setEmPhNumber(emPhNumber1);
		t.setGender(gender);
		t.setIdNumber(idNumber1);
		t.setName(name1);
		t.setPhNumber(phNumber1);

		patientControllerImpl.correctPatient(name1, t);

		JOptionPane.showMessageDialog(null, "修改成功！");
		viewTable();
	}

	private void flushActionPerformed(ActionEvent evt) {
		viewTable();
	}

	private void findActionPerformed(ActionEvent evt) {
		String text = findAcNumber.getText();
		if (text == null || "".equals(text)) {
			JOptionPane.showMessageDialog(null, "请输入查询的姓名！");
			return;
		}
		boolean flag = false;
		String[] colNames = new String[] { "姓名", "年龄", "性别", "联系电话", "紧急联系人",
				"紧急联系电话" };


		
		//使用控制器查询
		List<Patient> patients2 = patientControllerImpl.findPatient(text);
		
		if(patients2 == null || patients.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "找不到该人！");
			return;
		}

		int size = patients2.size();
		int i = 0;
		String[][] content = new String[size][colNames.length];
		for (Patient t : patients2) {
				content[i++] = new String[] { t.getName(), t.getAge(),
						t.getGender(), t.getPhNumber(), t.getEmPerson(),
						t.getEmPhNumber() };
		}

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
}
