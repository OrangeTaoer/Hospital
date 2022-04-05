package com.zzt.controller.impl;

import java.util.List;

import com.zzt.controller.PatientController;
import com.zzt.entity.Patient;
import com.zzt.service.impl.PatientServiceImpl;

public class PatientControllerImpl implements PatientController {

	//µ¥ÀýÄ£Ê½
	private static PatientControllerImpl patientControllerImpl = new PatientControllerImpl();
	
	private PatientControllerImpl(){
		
	}
	public static PatientControllerImpl getPatientControllerImpl()
	{
		return patientControllerImpl;
	}
	
	private PatientServiceImpl patientServiceImpl = PatientServiceImpl.getPatientServiceImpl();
	
	@Override
	public boolean isRegister(String idNumber) {
		return patientServiceImpl.isRegister(idNumber);
	}

	@Override
	public void addPatient(Patient patient) {
		patientServiceImpl.addPatient(patient);
	}

	@Override
	public void deletePatient(String id) {
		patientServiceImpl.deletePatient(id);
	}

	@Override
	public void correctPatient(String id, Patient patient) {
		patientServiceImpl.correctPatient(id, patient);
	}

	@Override
	public List<Patient> findPatient(String name) {
		return patientServiceImpl.findPatient(name);
	}
	@Override
	public List<Patient> query() {
		return patientServiceImpl.query();
	}

}
