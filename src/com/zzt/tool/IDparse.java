package com.zzt.tool;

public class IDparse {
	public static String toAge(String idNumber)
	{
		return Integer.toString(2020 - Integer.parseInt(idNumber.substring(6, 10)));
	}
	
	public static String toGender(String idNumber)
	{
		int x = Integer.parseInt(idNumber.substring(16, 17));
		if( x % 2 == 1 )
		{
			return "ÄÐ";
		}else
		{
			return "Å®";
		}
	}

}
