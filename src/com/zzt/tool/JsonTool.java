package com.zzt.tool;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.zzt.entity.Admin;
import com.zzt.entity.Employee;
import com.zzt.entity.Patient;
import com.zzt.entity.Problem;
import com.zzt.entity.ProblemModel;
import com.zzt.entity.UserEvaluate;
import com.zzt.entity.build.Building;

public class JsonTool {
	
	public static List<Admin> ToAdminArray(String adminJson)
	{
		List<Admin> admins = new ArrayList<Admin>();
		if(!adminJson.isEmpty())
		{
			admins = JSON.parseArray(adminJson, Admin.class);
		}
		return admins;
	}
	
	public static String ToAdminJson(List<Admin> admins)
	{
		String json = new String();
		if(!admins.isEmpty()) json = JSON.toJSONString(admins);
		return json;
	}
	
	public static List<Employee> ToEmployeeArray(String employeeJson)
	{
		List<Employee> employees = new ArrayList<Employee>();
		if(!employeeJson.isEmpty())
		{
			employees =	JSON.parseArray(employeeJson, Employee.class);
		}
		return employees;
	}
	
	public static String ToEmployeeJson(List<Employee> employees)
	{
		String json = new String();
		if(!employees.isEmpty())  json = JSON.toJSONString(employees);
		return json;
	}
	
	public static String ToPatientJson(List<Patient> patients)
	{
		String json = new String();
		if(!patients.isEmpty())  json = JSON.toJSONString(patients);
		return json;
	}

	public static List<Patient> ToPatientArray(String json) {
		List<Patient> patients = new ArrayList<Patient>();
		if(!json.isEmpty())
		{
			patients =	JSON.parseArray(json, Patient.class);
		}
		return patients;
	}

	public static List<Problem> ToProblemArray(String json) {
		List<Problem> patients = new ArrayList<Problem>();
		if(!json.isEmpty())
		{
			patients =	JSON.parseArray(json, Problem.class);
		}
		return patients;
	}

	public static String ToProblemJson(List<Problem> problems) {
		String json = new String();
		if(!problems.isEmpty())  json = JSON.toJSONString(problems);
		return json;
	}

	public static List<ProblemModel> ToPatientModelArray(String json) {
		List<ProblemModel> patients = new ArrayList<ProblemModel>();
		if(!json.isEmpty())
		{
			patients =	JSON.parseArray(json, ProblemModel.class);
		}
		return patients;
	}

	public static String ToProblemModelJson(List<ProblemModel> problemModels) {
		String json = new String();
		if(!problemModels.isEmpty())  json = JSON.toJSONString(problemModels);
		return json;
	}

	public static List<UserEvaluate> ToUserEvaluateArray(String json) {
		List<UserEvaluate> patients = new ArrayList<UserEvaluate>();
		if(!json.isEmpty())
		{
			patients =	JSON.parseArray(json, UserEvaluate.class);
		}
		return patients;
	}

	public static String ToUserEvaluateJson(List<UserEvaluate> userEvaluates) {
		String json = new String();
		if(!userEvaluates.isEmpty())  json = JSON.toJSONString(userEvaluates);
		return json;
	}

	public static String ToBuildingJson(List<Building> buildings) {
		String json = new String();
		if(!buildings.isEmpty())  json = JSON.toJSONString(buildings);
		return json;
	}

	public static List<Building> ToBuildingArray(String json) {
		List<Building> patients = new ArrayList<Building>();
		if(!json.isEmpty())
		{
			patients =	JSON.parseArray(json, Building.class);
		}
		return patients;
	}
	
}
