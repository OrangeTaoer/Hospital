package com.zzt.entity;

import com.zzt.tool.IDparse;

public class Patient extends People{
	private String name;
	private String idNumber;
	private String emPhNumber;
	private String emPerson;
	private String phNumber;
	private String gender;
	private String age;
	
	private static Patient patient = new Patient();
	
	public static Patient getPatient()
	{
		return patient;
	}
	
	
	private Patient() {
	}


	public Patient(String name, String idNumber, String emPhNumber,
			String emPerson, String phNumber, String gender, String age) {
		super();
		this.name = name;
		this.idNumber = idNumber;
		this.emPhNumber = emPhNumber;
		this.emPerson = emPerson;
		this.phNumber = phNumber;
		this.gender = gender;
		this.age = age;
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


	public String getEmPhNumber() {
		return emPhNumber;
	}


	public void setEmPhNumber(String emPhNumber) {
		this.emPhNumber = emPhNumber;
	}


	public String getEmPerson() {
		return emPerson;
	}


	public void setEmPerson(String emPerson) {
		this.emPerson = emPerson;
	}


	public String getPhNumber() {
		return phNumber;
	}


	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public static void setPatient(Patient patient) {
		Patient.patient = patient;
	}
	
	
}
