package com.zzt.controller;

import com.zzt.entity.Admin;

public interface AdminController {
	//×¢²á£º
	public abstract boolean isRegister(String acNumber);
	public abstract void registerAdmin(Admin admin);
	
	//µÇÂ¼:
	public abstract boolean isLogin(String acNumber,String password);
	public abstract Admin loginAdmin(String acNumber);
	

}
