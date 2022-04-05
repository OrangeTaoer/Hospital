package com.zzt.entity;

public class People {
	private String name;          //名字
	private String idNumber;      //身份证号码
	private String acNumber;      //账号
	private String password;      //密码
	private String phNumber;      //电话号码

	public People() {
	}

	public People(String name, String idNumber, String acNumber,
			String password, String phNumber) {
		super();
		this.name = name;
		this.idNumber = idNumber;
		this.acNumber = acNumber;
		this.password = password;
		this.phNumber = phNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getAcNumber() {
		return acNumber;
	}

	public void setAcNumber(String acNumber) {
		this.acNumber = acNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}

}
