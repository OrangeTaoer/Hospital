package com.zzt.tool;

public class DataBirth {
	public static String DataBirth(String idNumber)
	{
		String birthday = null;
		if(idNumber == null || "".equals(idNumber))
		{
			return null;
		}
		
		if(idNumber.length() == 18)
		{
			 birthday = idNumber.substring(6, 14);
		}
		
		return birthday;
	}

}
