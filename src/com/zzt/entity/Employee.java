package com.zzt.entity;

import com.zzt.tool.DataBirth;

public class Employee extends People {
	private static Employee employee = new Employee();
	
	public static Employee getEmployee()
	{
		return employee;
	}
	
	private String birthday;
	private String advantage;
	private String position;

	private  Employee() {
	}

	public Employee(String birthday, String advantage, String position) {
		super();
		this.birthday = birthday;
		this.advantage = advantage;
		this.position = position;
	}

	public String getBirthday() {
		this.birthday = DataBirth.DataBirth(this.getIdNumber());
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = DataBirth.DataBirth(this.getIdNumber());
	}

	public String getAdvantage() {
		return advantage;
	}

	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
