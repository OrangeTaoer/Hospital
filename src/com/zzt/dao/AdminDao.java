package com.zzt.dao;

import java.util.List;

import com.zzt.entity.Admin;

public interface AdminDao {
	//×¢²á£º
	public abstract boolean isRegister(String acNumber);
	public abstract void registerAdmin(Admin admin);
	
	//µÇÂ¼:
	public abstract boolean isLogin(String acNumber,String password);
	public abstract Admin loginAdmin(String acNumber);
	
}
