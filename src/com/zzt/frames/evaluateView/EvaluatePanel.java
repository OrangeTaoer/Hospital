package com.zzt.frames.evaluateView;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import javax.swing.JFrame;

import com.zzt.entity.Problem;
import com.zzt.entity.ProblemModel;
import com.zzt.tool.GetDataClass;

public class EvaluatePanel extends javax.swing.JPanel {

	private String modelID = "3";
	private String filenameModel;
	private List<ProblemModel> problemModels;
	// 获取模板
	private ProblemModel pbmt;
	
	private List<Problem> problems2; // 该模板的问题
	
	private ButtonGroup[] bgs;
	private JRadioButton[] jrbs; 
	private Integer[] scores = {5 ,3 , 1};//定义A:5分，B:3分，C：1分
	private int lengths;
	private int high = 200 ; // 为所要设置的 panel根据问题的数量设置动态大小，使之大小适当
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new EvaluatePanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public EvaluatePanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		dataInit();
		
		guiInit();
		
		try {
			this.setPreferredSize(new java.awt.Dimension(539, high));
			this.setLayout(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void dataInit()
	{
		//初始化要用到的变量
		lengths = 0 ;
		 String modelID = "5";
		List<ProblemModel> problemModels = GetDataClass
				.getDataProblemModelClass();
		boolean flag = false;//判断pbmt是否为已有模板
		// 获取模板
		for (ProblemModel t : problemModels) {
			if (t.getId().equals(modelID)) {
				pbmt = t;
				flag = true; // 若执行到此步，则代表为已有模板
				break;
			}
		}
		if(!flag)
		{
			JOptionPane.showMessageDialog(null, "该模板为不可用模板");
			return;
		}		
		problems2 = pbmt.getProblemss();
		if(problems2.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "该模板不存在问题，请重新选择模板，或者为进入模板管理为该模板添加问题");
		}
	}
	
	private void guiInit()
	{
		lengths = problems2.size();
		//若无问题存在在模板中，则跳出
		if( lengths == 0 )
		{
			return ;
		}
		
		bgs = new ButtonGroup[lengths];
		JLabel[] jbs = new JLabel[lengths];
		jrbs = new JRadioButton[3];//定义三个单选
		
		int x = 50;// 动态控件组距离左边框距离
		int w = 350;// 动态标题及单选按钮宽
		int h = 45;// 动态单选按钮高
		
		for(int i = 0 ; i < lengths ; i ++ )
		{
			Problem t = problems2.get(i);
			bgs[i] = new ButtonGroup(); 
			jbs[i] = new JLabel("第"+ ( i + 1 ) + "题:" + t.getTitle());
			jbs[i].setForeground(Color.red);
			jbs[i].setBounds(x, 5 + i * 120, w , h);
			this.add(jbs[i]);
			jbs[i].revalidate();
			
			jrbs[0] = new JRadioButton("A." + t.getOptions1());
			jrbs[0].setBounds(x, 35 + i * 120, w, h);
			jrbs[0].setActionCommand("q"+i);
			jrbs[0].addActionListener(new ActionListener(){ 
				@Override
				public void actionPerformed(ActionEvent ae) {
					firstActionPerformed(ae);					
				}});
			bgs[i].add(jrbs[0]);
			this.add(jrbs[0]);
			
			jrbs[1] = new JRadioButton("B." + t.getOptions2());
			jrbs[1].setBounds(x, 65 + i * 120, w, h);
			jrbs[1].setActionCommand("q"+i);
			jrbs[1].addActionListener(new ActionListener(){ 
				@Override
				public void actionPerformed(ActionEvent ae) {
					secondActionPerformed(ae);
				}});
			bgs[i].add(jrbs[1]);
			this.add(jrbs[1]);
			
			jrbs[2] = new JRadioButton("C." + t.getOptions3());
			jrbs[2].setBounds(x, 95 + i * 120, w, h);
			jrbs[2].setActionCommand("q"+i);
			jrbs[2].addActionListener(new ActionListener(){ 
				@Override
				public void actionPerformed(ActionEvent ae) {
					thirdActionPerformed(ae);					
				}});
			bgs[i].add(jrbs[2]);
			this.add(jrbs[2]);
			if(i == lengths - 1 )
			{
				high = 95 + i * 120 + h ;
			}
		}
		repaint();
	}
	 Map<String,Integer> rs=new HashMap<String,Integer>();
	public void firstActionPerformed(ActionEvent arg0) { 
		JRadioButton jb=(JRadioButton) arg0.getSource();  
		String ac=jb.getActionCommand();
		rs.put(ac,scores[0]);
	}	
	public void secondActionPerformed(ActionEvent arg0) { 
		JRadioButton jb=(JRadioButton) arg0.getSource();  
		String ac=jb.getActionCommand();
		rs.put(ac,scores[1]);
	}	
	public void thirdActionPerformed(ActionEvent arg0) { 
		JRadioButton jb=(JRadioButton) arg0.getSource();  
		String ac=jb.getActionCommand();
		rs.put(ac,scores[2]);
	}	
}
