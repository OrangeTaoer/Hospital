package com.zzt.frames;

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
import com.zzt.entity.ProblemModel;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.WriteDataClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
public class AddProblemModel extends javax.swing.JFrame {
	private JTextField name;
	private JButton add;
	private JComboBox type;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddProblemModel inst = new AddProblemModel();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public AddProblemModel() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				name = new JTextField();
				getContentPane().add(name);
				name.setBounds(122, 30, 231, 47);
			}
			{
				ComboBoxModel typeModel = new DefaultComboBoxModel(
						new String[] { "A", "B", "C" });
				type = new JComboBox();
				getContentPane().add(type);
				type.setModel(typeModel);
				type.setBounds(122, 100, 231, 54);
			}
			{
				add = new JButton();
				getContentPane().add(add);
				add.setText("\u589e\u52a0\u6a21\u677f");
				add.setBounds(144, 193, 190, 60);
				add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addActionPerformed(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setBounds(34, 24, 82, 59);
				jLabel1.setName("jLabel1");
				jLabel1.setText("\u6a21\u677f\u540d\u79f0\uff1a");
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setBounds(34, 107, 91, 49);
				jLabel2.setName("jLabel2");
				jLabel2.setText("\u6a21\u677f\u7c7b\u578b\uff1a");
			}
			pack();
			this.setSize(488, 366);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	boolean flagg = false;
	private JLabel jLabel2;
	private JLabel jLabel1;

	private void addActionPerformed(ActionEvent evt) {
		String name1 = name.getText();
		String type1 = type.getSelectedItem().toString();

		ProblemModel t = ProblemModel.getProblemModel();
		t.setName(name1);
		t.setType(type1);

		List<ProblemModel> problemModels = new ArrayList<ProblemModel>();
		problemModels = GetDataClass.getDataProblemModelClass();
		int id = 0;
		if (!problemModels.isEmpty()) {
			for (int i = 0;; i++) {
				boolean flag = true;
				for (ProblemModel t1 : problemModels) {
					if (t1.getId().equals(Integer.toString(i))) {
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

		t.setId(Integer.toString(id));
		problemModels.add(t);
		JOptionPane.showMessageDialog(null, "增加成功！");
		flagg = true;
		WriteDataClass.writeDataProblemModel(problemModels);
	}

}
