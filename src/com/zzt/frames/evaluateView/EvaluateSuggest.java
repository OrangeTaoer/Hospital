package com.zzt.frames.evaluateView;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class EvaluateSuggest extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JTextField suggest;
	private JButton enter;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EvaluateSuggest inst = new EvaluateSuggest();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
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
		String text = suggest.getText();
		
		
	}

}
