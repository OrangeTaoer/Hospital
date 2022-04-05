package com.zzt.controller;

import java.util.List;

import com.zzt.entity.Patient;

public interface PatientController {
	//判断病人是否已经注册
	public abstract boolean isRegister(String idNumber);
	
	//增加病人
	public abstract void addPatient(Patient patient);
	
	//删除病人
	public abstract void deletePatient(String id);
	
	//修改病人信息
	public abstract void correctPatient(String id ,Patient patient);

	//查询病人
	public abstract List<Patient> findPatient(String name);
	
	//询问病人
	public abstract List<Patient> query();

}
