package com.zzt.service.impl;

import java.util.List;

import com.zzt.dao.impl.PatientDaoImpl;
import com.zzt.entity.Patient;
import com.zzt.service.PatientService;
import com.zzt.tool.GetDataClass;

public class PatientServiceImpl implements PatientService{

	//µ¥ÀýÄ£Ê½
	private static PatientServiceImpl patientServiceImpl = new PatientServiceImpl();
	private PatientServiceImpl(){
		
	}
	public static PatientServiceImpl getPatientServiceImpl()
	{
		return patientServiceImpl;
	}
	
	private PatientDaoImpl patientDaoImpl = new PatientDaoImpl();
	
	@Override
	public boolean isRegister(String idNumber) {
		return patientDaoImpl.isRegister(idNumber);
	}

	@Override
	public void addPatient(Patient patient) {
		patientDaoImpl.addPatient(patient);
	}

	@Override
	public void deletePatient(String id) {
		patientDaoImpl.deletePatient(id);
	}

	@Override
	public void correctPatient(String id, Patient patient) {
		patientDaoImpl.correctPatient(id, patient);
	}

	@Override
	public List<Patient> findPatient(String name) {
		return patientDaoImpl.findPatient(name);
	}
	@Override
	public List<Patient> query() {
		return GetDataClass.getDataPatientClass();
	}
	
}
