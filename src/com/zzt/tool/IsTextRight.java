package com.zzt.tool;

import javax.swing.JOptionPane;

public class IsTextRight {
	public static boolean isTextTrue(String acNumber ,String password){
		boolean flag = true;
		
		if(acNumber == null || "".equals(acNumber))
		{
			JOptionPane.showMessageDialog(null, "ÇëÊäÈëÄúµÄÕËºÅ");
			flag = false;
		}else if(password == null || "".equals(password))
		{
			JOptionPane.showMessageDialog(null, "ÇëÊäÈëÄúµÄÃÜÂë");
			flag = false;
		}
		return flag;
	}
}
