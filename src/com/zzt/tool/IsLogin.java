package com.zzt.tool;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.zzt.entity.Admin;
import com.zzt.entity.Employee;

public class IsLogin {
	public static boolean AdminLogin(String acNumber,String password)
	{
		boolean flag = false;
		String path = FilePathSet.getAdminPath();
		File file = new File(path);
		
		String json = FileTool.readFile2(path);
		List<Admin> admins = JsonTool.ToAdminArray(json);
		
		
		if(admins == null || admins.isEmpty())
		{
			return false;
		}
		
		for(Admin t : admins)
		{
			if(t.getAcNumber().equals(acNumber))
			{
				Md5 md5 = new Md5();
				try {
					if(t.getPassword().equals(md5.EncoderByMd5(password))){
						flag = true;
					}
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return flag;
	}
	
	
	public static boolean EmployeeLogin(String acNumber,String password)
	{
		boolean flag = false;
		String path = FilePathSet.getEmployeePath();	
		String json = FileTool.readFile2(path);
		List<Employee> employees = JsonTool.ToEmployeeArray(json);
		
		
		if(employees == null || employees.isEmpty())
		{
			return false;
		}
		
		for(Employee t : employees)
		{
			if(t.getAcNumber().equals(acNumber))
			{
				if(t.getPassword().equals(password)){
					flag = true;
				}
			}
		}
		
		return flag;
	}

}
