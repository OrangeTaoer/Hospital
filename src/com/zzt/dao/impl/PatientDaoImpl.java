package com.zzt.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.zzt.dao.PatientDao;
import com.zzt.entity.Employee;
import com.zzt.entity.Patient;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.IsRegister;
import com.zzt.tool.WriteDataClass;

public class PatientDaoImpl implements PatientDao {

	
private static PatientDaoImpl patientDaoImpl = new PatientDaoImpl();
	
	public PatientDaoImpl(){
		
	}

	public static PatientDaoImpl getPatientDaoImpl()
	{
		return patientDaoImpl;
	}
	
	
	@Override
	public boolean isRegister(String idNumber) {
		return IsRegister.PatientIsRegister(idNumber);
	}

	@Override
	public void addPatient(Patient patient) {
		List<Patient> patients = GetDataClass.getDataPatientClass();
		if(patients == null )
		{
			patients = new ArrayList<Patient>();
		}
		patients.add(patient);
		WriteDataClass.writeDataPatient(patients);
		return;
	}

	@Override
	public void deletePatient(String id) {
		List<Patient> patients = GetDataClass.getDataPatientClass();
		if(patients == null || patients.isEmpty())
		{
			return;
		}
		for(Patient t : patients)
		{
			if(id.equals(t.getIdNumber()))
			{
				patients.remove(t);
			}
		}
		WriteDataClass.writeDataPatient(patients);
		return;
	}

	@Override
	public void correctPatient(String id ,Patient patient) {
		// TODO Auto-generated method stub
		List<Patient> patients = GetDataClass.getDataPatientClass();
		int i = 0 ;
		if(patients != null && !patients.isEmpty())
		{
			for(Patient t : patients)
			{
				if(t.getName().equals(id))
				{
					patients.set(i, patient);
					break;
				}
				i ++ ;
			}
		}
		WriteDataClass.writeDataPatient(patients);
		return;
	}

	@Override
	public List<Patient> findPatient(String name) {
		Patient t = Patient.getPatient();
		List<Patient> patients2 = new ArrayList<Patient>();
		List<Patient> patients = GetDataClass.getDataPatientClass();
		if(patients != null && !patients.isEmpty())
		{
			for(Patient m : patients)
			{
				if(m.getName().equals(name))
				{
					patients2.add(m);
				}
			}
		}
		return patients2;
	}

	@Override
	public List<Patient> query() {
		return GetDataClass.getDataPatientClass();
	}

}
