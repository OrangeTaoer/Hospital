package com.zzt.dao.impl;

import java.util.List;

import com.zzt.dao.AdminDao;
import com.zzt.entity.Admin;
import com.zzt.tool.FilePathSet;
import com.zzt.tool.FileTool;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.IsLogin;
import com.zzt.tool.IsRegister;
import com.zzt.tool.JsonTool;
import com.zzt.tool.Register;

public class AdminDaoImpl implements AdminDao {

	//使用单例模式：
	private static AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
	
	private AdminDaoImpl(){
		
	}

	public static AdminDaoImpl getAdminDaoImpl()
	{
		return adminDaoImpl;
	}
	@Override
	public boolean isRegister(String acNumber) {
		boolean flag = true ;
		flag = IsRegister.AdminIsRegister(acNumber);
		return flag;
	}

	@Override
	public void registerAdmin(Admin admin) {
		Register.AdminRegister(admin);
		return;
	}

	@Override
	public boolean isLogin(String acNumber, String password) {
		boolean flag = true ;
		flag = IsLogin.AdminLogin(acNumber, password);
		return flag;
	}

	@Override
	public Admin loginAdmin(String acNumber) {
		Admin t = Admin.getAdmin();
		String path = FilePathSet.getAdminPath();
		String json = FileTool.readFile2(path);
		List<Admin> admins = JsonTool.ToAdminArray(json);
		if(admins == null || admins.isEmpty())
		{
			return null;
		}
		for(Admin t1 : admins)
		{
			if(t1.getAcNumber().equals(acNumber))
			{
				t = t1;
				break;
			}
		}
		return t;
	}


}
