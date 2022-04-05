package com.zzt.frames;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


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
public class BuildingManager extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JTree jTree;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BuildingManager inst = new BuildingManager();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BuildingManager() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(0, 102, 526, 501);
				{
					jTree = new JTree();
					
					jTree.setModel(new DefaultTreeModel(
							new DefaultMutableTreeNode("ҽԺ") {
								{
									DefaultMutableTreeNode node_1;
									node_1 = new DefaultMutableTreeNode("colors");
										node_1.add(new DefaultMutableTreeNode("blue"));
										node_1.add(new DefaultMutableTreeNode("\u53CD\u5012\u662F\u5927\u4E09"));
										node_1.add(new DefaultMutableTreeNode("red"));
										node_1.add(new DefaultMutableTreeNode("yellow"));
									add(node_1);
									node_1 = new DefaultMutableTreeNode("sports");
										node_1.add(new DefaultMutableTreeNode("basketball"));
										node_1.add(new DefaultMutableTreeNode("soccer"));
										node_1.add(new DefaultMutableTreeNode("football"));
										node_1.add(new DefaultMutableTreeNode("hockey"));
									add(node_1);
									node_1 = new DefaultMutableTreeNode("food");
										node_1.add(new DefaultMutableTreeNode("hot dogs"));
										node_1.add(new DefaultMutableTreeNode("pizza"));
										node_1.add(new DefaultMutableTreeNode("ravioli"));
										node_1.add(new DefaultMutableTreeNode("bananas"));
									add(node_1);
								}
							}
						));

					
					jScrollPane1.setViewportView(getJTree());
				}
			}
			pack();
			this.setSize(772, 795);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public JTree getJTree() {
		return jTree;
	}

}
