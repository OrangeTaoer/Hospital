package com.zzt.service.impl;

import com.zzt.dao.impl.AdminDaoImpl;
import com.zzt.entity.Admin;
import com.zzt.service.AdminService;

public class AdminServiceImpl implements AdminService {

	private static AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
	private AdminServiceImpl(){
		
	}
	public static AdminServiceImpl getAdminServiceImpl()
	{
		return adminServiceImpl;
	}
	private AdminDaoImpl adminDaoImpl = AdminDaoImpl.getAdminDaoImpl();
	
	@Override
	public boolean isRegister(String acNumber) {
		return adminDaoImpl.isRegister(acNumber);
	}

	@Override
	public void registerAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDaoImpl.registerAdmin(admin);
	}

	@Override
	public boolean isLogin(String acNumber, String password) {
		// TODO Auto-generated method stub
		return adminDaoImpl.isLogin(acNumber, password);
		}

	@Override
	public Admin loginAdmin(String acNumber) {
		// TODO Auto-generated method stub
		return adminDaoImpl.loginAdmin(acNumber);
	}



}
