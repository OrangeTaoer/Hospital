package com.zzt.tool;

import java.io.File;
import java.util.List;

import com.zzt.entity.Admin;
import com.zzt.entity.Employee;
import com.zzt.entity.Patient;

public class IsRegister {
	public static boolean AdminIsRegister(String acNumber)
	{
		String path = FilePathSet.getAdminPath();
		String json = FileTool.readFile2(path);
		List<Admin> admins = JsonTool.ToAdminArray(json);
		
		boolean flag = true;
		if(admins == null || admins.isEmpty())
		{
			return true;
		}
		for(Admin t : admins)
		{
			if(t.getAcNumber().equals(acNumber))
			{
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	
	public static boolean EmployeeIsRegister(String acNumber)
	{
		String path = FilePathSet.getEmployeePath();
		String json = FileTool.readFile2(path);
		if( json == null || "".equals(json))
		{
			return true;
		}
		List<Employee> employees = JsonTool.ToEmployeeArray(json);
		
		boolean flag = true;
		if(employees == null || employees.isEmpty())
		{
			
			return true;
		}
		for(Employee t : employees)
		{
			if(t.getAcNumber().equals(acNumber))
			{
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	
	public static boolean PatientIsRegister(String idNumber)
	{
		String path = FilePathSet.getPatientPath();
		String json = FileTool.readFile2(path);
		if( json == null || "".equals(json))
		{
			return true;
		}
		List<Patient> patients = JsonTool.ToPatientArray(json);
		
		boolean flag = true;
		if(patients == null || patients.isEmpty())
		{
			return true;
		}
		for(Patient t : patients)
		{
			if(t.getIdNumber() != null && (!"".equals(t.getIdNumber())))
			if(t.getIdNumber().equals(idNumber))
			{
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	

}
