package com.zzt.frames;

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
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.zzt.entity.Problem;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.WriteDataClass;

public class AddProblem extends javax.swing.JFrame {
	private JTextField title;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JButton add;
	private JTextField options3;
	private JTextField options2;
	private JTextField options1;
	private JComboBox type;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddProblem inst = new AddProblem();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public AddProblem() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				title = new JTextField();
				getContentPane().add(title);
				title.setBounds(165, 45, 213, 41);
			}
			{
				ComboBoxModel typeModel = new DefaultComboBoxModel(
						new String[] { "A", "B", "C" });
				type = new JComboBox();
				getContentPane().add(type);
				type.setModel(typeModel);
				type.setBounds(165, 119, 213, 46);
			}
			{
				options1 = new JTextField();
				getContentPane().add(options1);
				options1.setBounds(165, 196, 213, 51);
			}
			{
				options2 = new JTextField();
				getContentPane().add(options2);
				options2.setBounds(165, 281, 213, 47);
			}
			{
				options3 = new JTextField();
				getContentPane().add(options3);
				options3.setBounds(165, 369, 213, 49);
			}
			{
				add = new JButton();
				getContentPane().add(add);
				add.setText("\u589e\u52a0");
				add.setBounds(173, 446, 95, 49);
				add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addActionPerformed(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setBounds(92, 47, 55, 36);
				jLabel1.setName("jLabel1");
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setBounds(92, 119, 50, 46);
				jLabel2.setName("jLabel2");
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setBounds(90, 201, 68, 46);
				jLabel3.setName("jLabel3");
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setBounds(90, 286, 60, 42);
				jLabel4.setName("jLabel4");
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setBounds(90, 373, 68, 40);
				jLabel5.setName("jLabel5");
			}
			pack();
			this.setSize(495, 562);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addActionPerformed(ActionEvent evt) {
		String title1 = title.getText();
		String type1 = type.getSelectedItem().toString();
		String an1 = options1.getText();
		String an2 = options2.getText();
		String an3 = options3.getText();

		List<Problem> problems = new ArrayList<Problem>();
		problems = GetDataClass.getDataProblemClass();
		int id = 0;
		if (!problems.isEmpty()) {
			for (int i = 0;; i++) {
				boolean flag = true;
				for (Problem t : problems) {
					if (t.getId().equals(Integer.toString(i))) {
						flag = false;
						break;
					}
				}
				if (flag) {
					id = i;
					break;
				}
			}
		}
		Problem t = Problem.getProblem();
		t.setId(Integer.toString(id));
		t.setTitle(title1);
		t.setType(type1);
		t.setOptions1(an1);
		t.setOptions2(an2);
		t.setOptions3(an3);
		problems.add(t);
		JOptionPane.showMessageDialog(null, "增加成功！");
		WriteDataClass.writeDataProblem(problems);

		title.setText("");
		options1.setText("");
		options2.setText("");
		options3.setText("");

	}

}
