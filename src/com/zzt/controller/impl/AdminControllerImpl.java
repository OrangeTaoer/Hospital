package com.zzt.controller.impl;

import com.zzt.controller.AdminController;
import com.zzt.entity.Admin;
import com.zzt.service.impl.*;

public class AdminControllerImpl implements AdminController{

	private static AdminControllerImpl adminControllerImpl = new AdminControllerImpl();
	
	public AdminControllerImpl()
	{
		
	}
	
	public static AdminControllerImpl getAdminControllerImpl()
	{
		return adminControllerImpl;
	}
	
	private AdminServiceImpl adminServiceImpl = AdminServiceImpl.getAdminServiceImpl();
	
	
	@Override
	public boolean isRegister(String acNumber) {
		// TODO Auto-generated method stub
		return adminServiceImpl.isRegister(acNumber);
	}

	@Override
	public void registerAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminServiceImpl.registerAdmin(admin);
	}

	@Override
	public boolean isLogin(String acNumber, String password) {
		// TODO Auto-generated method stub
		return adminServiceImpl.isLogin(acNumber, password);
	}

	@Override
	public Admin loginAdmin(String acNumber) {
		// TODO Auto-generated method stub
		return adminServiceImpl.loginAdmin(acNumber);
	}

}
