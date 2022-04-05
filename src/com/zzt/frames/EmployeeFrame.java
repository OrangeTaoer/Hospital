package com.zzt.frames;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import javax.swing.ImageIcon;
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

import com.zzt.entity.Employee;
import com.zzt.entity.Patient;
import com.zzt.frames.employeeView.AddPatient;
import com.zzt.tool.FileTool;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.IDparse;
import com.zzt.tool.JsonTool;
import com.zzt.tool.WriteDataClass;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class EmployeeFrame extends javax.swing.JFrame {
	private JLabel manager;
	private JButton delete;
	private JTable jTable;
	private JButton add;
	private JCheckBox jCBox;
	private JTable jtable;
	private JScrollPane EmployeeJSPane;
	private TableModel jTableModel = 
		new DefaultTableModel();
	private JTextField idNumber;
	private JTextField emPhNumber;
	private JTextField emPerson;
	private JTextField phNumber;
	private JTextField findacNumber;
	private JButton find;
	private JLabel jLabel1;
	private JButton correctCorrect;
	private JButton correct;
	private JButton flush;

	/**
	 * 文件操作
	 */
	List<Patient> patients = GetDataClass.getDataPatientClass();
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EmployeeFrame inst = new EmployeeFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public EmployeeFrame() {
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
				manager.setText("\u5458\u5de5\u754c\u9762");
				manager.setBounds(814, 18, 118, 45);
			}
			{
				EmployeeJSPane = new JScrollPane();
				getContentPane().add(EmployeeJSPane);
				EmployeeJSPane.setBounds(209, 143, 706, 244);
				{
					String[] colNames = new String[]{"姓名","年龄","性别","联系电话","紧急联系人","紧急联系电话"};
					String filename = "C://e//Hospital_System//data//patient.txt";
					String pajson = FileTool.readFile2(filename);
					int size = patients.size();
					String[][] content = new String[size][colNames.length];
					if(!pajson.isEmpty())
					{
					   int i = 0 ;
						for(Patient t : patients)
						{
							content[i++] = new String[]{t.getName(),t.getAge(),t.getGender(),t.getPhNumber(),t.getEmPerson(),t.getEmPhNumber()};
						}
					}
					
					 jTableModel = 
						new DefaultTableModel(
								content,
								colNames);
					//设置为不可编辑！
					 jTable = new JTable(jTableModel){
							@Override
							public boolean isCellEditable(int row, int column)
							{
								return false;
							}			
						};
					 
//					jTable = new JTable();
					EmployeeJSPane.setViewportView(jTable);
//					jTable.setModel(jTableModel);
					
					// 添加到主界面		
					jTable.setFillsViewportHeight(true);		
					jTable.setRowSelectionAllowed(true); // 整行选择
					jTable.setRowHeight(30);	
					
					// 列设置：自定义绘制
					jTable.getColumnModel().getColumn(0).setCellRenderer(new IDColumnRender());
					//jTable.getColumnModel().getColumn(5).setPreferredWidth(140); // 该列的宽度	
					repaint();
				}
			}
			{
				add = createToolButton("添加", "ic_add.png" );
				getContentPane().add(add);
				add.setText("\u6dfb\u52a0");
				add.setBounds(208, 92, 91, 52);
				add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addActionPerformed(evt);
					}
				});
			}
			{
				delete = createToolButton("删除", "ic_delete.png" );
				getContentPane().add(delete);
				delete.setText("\u5220\u9664");
				delete.setBounds(296, 92, 91, 52);
				delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						deleteActionPerformed(evt);
					}
				});
			}
			{
				flush = new JButton();
				getContentPane().add(flush);
				flush.setText("\u5237\u65b0");
				flush.setBounds(825, 424, 91, 61);
				flush.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						flushActionPerformed(evt);
					}
				});
			}
			{
				correct = createToolButton("编辑", "ic_edit.png" );
				getContentPane().add(correct);
				correct.setText("\u4fee\u6539");
				correct.setBounds(386, 92, 91, 52);
				correct.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						CorrectActionPerformed(evt);
					}
				});
			}
			{
				correctCorrect = new JButton();
				getContentPane().add(correctCorrect);
				correctCorrect.setText("\u786e\u5b9a");
				correctCorrect.setBounds(832, 541, 83, 84);
				correctCorrect.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						correctCorrectActionPerformed(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u59d3\u540d\uff1a");
				jLabel1.setBounds(573, 97, 45, 20);
			}
			{
				find = new JButton();
				getContentPane().add(find);
				find.setText("\u67e5\u8be2");
				find.setBounds(820, 87, 80, 41);
				find.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						findActionPerformed(evt);
					}
				});
			}
			{
				findacNumber = new JTextField();
				getContentPane().add(findacNumber);
				findacNumber.setBounds(634, 91, 167, 33);
			}
			{
				phNumber = new JTextField();
				getContentPane().add(phNumber);
				phNumber.setText("\u7535\u8bdd\u53f7\u7801\uff1a");
				phNumber.setBounds(261, 413, 228, 47);
			}
			{
				emPerson = new JTextField();
				getContentPane().add(emPerson);
				emPerson.setText("\u7d27\u6025\u8054\u7cfb\u4eba\uff1a");
				emPerson.setBounds(547, 412, 228, 49);
			}
			{
				emPhNumber = new JTextField();
				getContentPane().add(emPhNumber);
				emPhNumber.setText("\u7d27\u6025\u8054\u7cfb\u7535\u8bdd\uff1a");
				emPhNumber.setBounds(267, 517, 228, 45);
			}
			{
				idNumber = new JTextField();
				getContentPane().add(idNumber);
				idNumber.setText("\u8eab\u4efd\u8bc1\u53f7\u7801");
				idNumber.setBounds(556, 518, 228, 44);
			}
			pack();
			this.setSize(973, 714);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void viewTable()
	{
		
		if(patients == null || patients.isEmpty())
		{
			return ;
		}
		
		String[] colNames = new String[]{"姓名","年龄","性别","联系电话","紧急联系人","紧急联系电话"};
		String[][] content = new String[0][0];
		List<Patient> patients = GetDataClass.getDataPatientClass();
		if(patients != null && !patients.isEmpty())
		{
			int size = patients.size();
			content = new String[size][colNames.length];
			
		   int i = 0 ;
			for(Patient t : patients)
			{
				content[i++] = new String[]{t.getName(),t.getAge(),t.getGender(),t.getPhNumber(),t.getEmPerson(),t.getEmPhNumber()};
			}
		}
		 jTableModel = 
			new DefaultTableModel(
					content,
					colNames);
		//设置为不可编辑！
		 jTable = new JTable(jTableModel){
				@Override
				public boolean isCellEditable(int row, int column)
				{
					return false;
				}			
			};
		 
//		jTable = new JTable();
		EmployeeJSPane.setViewportView(jTable);
//		jTable.setModel(jTableModel);
		
		// 添加到主界面		
		jTable.setFillsViewportHeight(true);		
		jTable.setRowSelectionAllowed(true); // 整行选择
		jTable.setRowHeight(30);	
		
		// 列设置：自定义绘制
		jTable.getColumnModel().getColumn(0).setCellRenderer(new IDColumnRender());
		//jTable.getColumnModel().getColumn(5).setPreferredWidth(140); // 该列的宽度	
		repaint();
	}
	
	private void addActionPerformed(ActionEvent evt) {
		AddPatient inst = new AddPatient();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
	private void deleteActionPerformed(ActionEvent evt) {
		// 点 '删除' 按钮
		patients = GetDataClass.getDataPatientClass();
		// 获取选中的行的索引
		int[] rows = jTable.getSelectedRows();
		if(rows.length == 0)
		{
			JOptionPane.showMessageDialog(null, "您尚未选择想要删除的用户！");
			return;
		}
				
		// 弹出对话框确认
		int select = JOptionPane.showConfirmDialog(this, "是否确认删除?", "确认", JOptionPane.YES_NO_OPTION);
		if(select != 0) return; // 0号按钮是'确定'按钮

		
		for(int i= rows.length-1; i>=0; i--)
		{
			int row = rows[i];
			if(row < patients.size())
			patients.remove(row);
		}
		WriteDataClass.writeDataPatient(patients);
		viewTable();
	}
	

	
	private void flushActionPerformed(ActionEvent evt) {
		viewTable();
	}
	
	private void findActionPerformed(ActionEvent evt) {
		String text = findacNumber.getText();
		if(text == null || "".equals(text))
		{
			JOptionPane.showMessageDialog(null, "请输入查询的姓名！");
			return;
		}
		boolean flag = false;
		String[] colNames = new String[]{"姓名","年龄","性别","联系电话","紧急联系人","紧急联系电话"};
		int i = 0 ;
		for(Patient t : patients)
		{
			if(text.equals(t.getName()))
			i ++ ;
		}
		String[][] content = new String[i][colNames.length];
		
		i = 0 ;
		
		for(Patient t : patients)
		{
			if(text.equals(t.getName()))
			{
				content[i++] = new String[]{t.getName(),t.getAge(),t.getGender(),t.getPhNumber(),t.getEmPerson(),t.getEmPhNumber()};
				flag = true;
			}
		}
		jTableModel = 
			new DefaultTableModel(
					content,
					colNames);
		jTable = new JTable();
		EmployeeJSPane.setViewportView(jTable);
		jTable.setModel(jTableModel);
		
		// 添加到主界面		
		jTable.setFillsViewportHeight(true);		
		jTable.setRowSelectionAllowed(true); // 整行选择
		jTable.setRowHeight(30);	
		
		// 列设置：自定义绘制
		jTable.getColumnModel().getColumn(0).setCellRenderer(new IDColumnRender());
		jTable.getColumnModel().getColumn(5).setPreferredWidth(140); // 该列的宽度	
		jTable.setPreferredSize(new java.awt.Dimension(727, 217));
		repaint();
		if(!flag)
		{
			JOptionPane.showMessageDialog(null, "查不到您所要查询的内容！");
			return ;
		}
		
	}
	boolean flag = false;
	private void CorrectActionPerformed(ActionEvent evt) {
		// 点 '删除' 按钮
		patients = GetDataClass.getDataPatientClass();
		// 获取选中的行的索引
		int[] rows = jTable.getSelectedRows();
		if(rows.length == 0)
		{
			JOptionPane.showMessageDialog(null, "您尚未选择想要修改的用户！");
			return;
		}
		if(rows.length > 1)
		{
			JOptionPane.showMessageDialog(null, "一次仅允许修改一个用户！");
			return;
		}
		flag = true;
		JOptionPane.showMessageDialog(null, "请在显示框下方进行修改！");
		return;
	}
	
	private void correctCorrectActionPerformed(ActionEvent evt) {
		patients = GetDataClass.getDataPatientClass();
		//
		int[] rows = jTable.getSelectedRows();
		if(!flag)
		{
			JOptionPane.showMessageDialog(null, "请先选择上方的修改键判断是否能够修改！");
			return;
		}
		
		
		String phNumber1 = phNumber.getText();
		String emPerson1 = emPerson.getText();
		String emPhNumber1 = emPhNumber.getText();
		
		if(rows.length == 0 )
		{
			return;
		}
		int row = rows[0];
		
		Patient t =  Patient.getPatient();

		String name1 = (String)jTableModel.getValueAt(row, 0);
		String idNUmber1 = idNumber.getText();
		String age = IDparse.toAge(idNUmber1);
		String gender = IDparse.toAge(idNUmber1);
		
		t.setAge(age);
		t.setEmPerson(emPerson1);
		t.setEmPhNumber(emPhNumber1);
		t.setGender(gender);
		t.setIdNumber(idNUmber1);
		t.setName(name1);
		t.setPhNumber(phNumber1);

		patients.set(row, t);

		JOptionPane.showMessageDialog(null, "修改成功！");
		WriteDataClass.writeDataPatient(patients);
		viewTable();
	}
	
	
	protected JButton createToolButton(String text, String icon)
	{
		// 图标
		String imagePath = "/icons/" + icon;
		URL imageURL = getClass().getResource(imagePath);

		// 创建按钮
		JButton button = new JButton(text);
		//button.setActionCommand(action);
		button.setToolTipText(text);
		button.setIcon(new ImageIcon(imageURL));
		button.setFocusPainted(false);
		return button;
	}
	
}



