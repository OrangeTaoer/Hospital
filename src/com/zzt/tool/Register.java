package com.zzt.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.zzt.entity.Admin;
import com.zzt.entity.Employee;
import com.zzt.entity.Patient;

public class Register {
	
	public static void AdminRegister(Admin admin){
		String path = FilePathSet.getAdminPath();
		String json1 = FileTool.readFile2(path);
		List<Admin> admins = new ArrayList<Admin>();
			admins = JsonTool.ToAdminArray(json1);
		admins.add(admin);
		String json2 = JsonTool.ToAdminJson(admins);
		FileTool.saveFile2(path, json2);
	}
	
	public static void EmployeeRegister(Employee employee){
		String path = FilePathSet.getEmployeePath();
		String json1 = FileTool.readFile2(path);
		List<Employee> employees = new ArrayList<Employee>();
		employees = JsonTool.ToEmployeeArray(json1);
		employees.add(employee);
		String json2 = JsonTool.ToEmployeeJson(employees);
		FileTool.saveFile2(path, json2);
	}

	public static void PatientRegister(Patient t) {
		String path = FilePathSet.getPatientPath();
		String json1 = FileTool.readFile2(path);
		List<Patient> patients = new ArrayList<Patient>();
		patients = JsonTool.ToPatientArray(json1);
		patients.add(t);
		String json2 = JsonTool.ToPatientJson(patients);
		FileTool.saveFile2(path, json2);
	}

}
