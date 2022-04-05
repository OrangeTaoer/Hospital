package com.zzt.entity;

import com.zzt.entity.People;

public class Admin extends People {
	private String secuity;           //    密保答案
	private String problem;           //密保问题

	private static Admin admin = new Admin();
	
	public static Admin getAdmin()
	{
		return admin;
	}
	
	
	private  Admin() {
	}

	public Admin(String secuity, String problem) {
		super();
		this.secuity = secuity;
		this.problem = problem;
	}

	public String getSecuity() {
		return secuity;
	}

	public void setSecuity(String secuity) {
		this.secuity = secuity;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

}
