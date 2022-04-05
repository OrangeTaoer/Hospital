package com.zzt.entity.build;

import com.zzt.entity.Patient;

public class Bed {
	private String name;
	private String expalin;
	private String position;
	private boolean isRegister;
	private String starttime;
	private String endtime;
	private String state;
	private Patient patient;
	private String num;

	private static Bed bed = new Bed();
	
	public static Bed getBed()
	{
		return bed;
	}
	
	private Bed()
	{
		
	}
	public Bed(String name, String expalin, String position,
			boolean isRegister, String starttime, String endtime, String state,
			Patient patient, String num) {
		super();
		this.name = name;
		this.expalin = expalin;
		this.position = position;
		this.isRegister = isRegister;
		this.starttime = starttime;
		this.endtime = endtime;
		this.state = state;
		this.patient = patient;
		this.num = num;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpalin() {
		return expalin;
	}

	public void setExpalin(String expalin) {
		this.expalin = expalin;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean isRegister() {
		return isRegister;
	}

	public void setRegister(boolean isRegister) {
		this.isRegister = isRegister;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	
}
