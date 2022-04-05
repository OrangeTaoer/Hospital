package com.zzt.tool;

import java.util.List;

import com.zzt.entity.Admin;
import com.zzt.entity.Employee;
import com.zzt.entity.Patient;
import com.zzt.entity.Problem;
import com.zzt.entity.ProblemModel;
import com.zzt.entity.UserEvaluate;
import com.zzt.entity.build.Building;

public class WriteDataClass {
	
	
	//向文件中写入员工动态数组
	public static void writeDataEmployee(List<Employee> employees)
	{
		String json = JsonTool.ToEmployeeJson(employees);//调用工具类使动态数组转换成json文本
		String path = FilePathSet.getEmployeePath();     //调用工具类获取文件的相对路径
		if(json!=null && !"".equals(json))               //判断json是否为空，防止空指针异常
		{
			FileTool.saveFile2(path, json);              //向文件中写入json文本
		}
		return;
	}
	
	public static void writeDataPatient(List<Patient> patients)
	{
		String json = JsonTool.ToPatientJson(patients);
		String path = FilePathSet.getPatientPath();
		if(json!=null && !"".equals(json))
		{
			FileTool.saveFile2(path, json);
		}
		return ;
	}

	public static void writeDataProblem(List<Problem> problems) {
		String json = JsonTool.ToProblemJson(problems);
		String path = FilePathSet.getProblemPath();
		if(json!=null && !"".equals(json))
		{
			FileTool.saveFile2(path, json);
		}
		return ;
		
	}

	public static void writeDataProblemModel(List<ProblemModel> problemModels) {
		String json = JsonTool.ToProblemModelJson(problemModels);
		String path = FilePathSet.getProblemModelPath();
		if(json!=null && !"".equals(json))
		{
			FileTool.saveFile2(path, json);
		}
		return ;
	}

	public static void writeDataUserEvaluate(List<UserEvaluate> userEvaluates) {
		String json = JsonTool.ToUserEvaluateJson(userEvaluates);
		String path = FilePathSet.getUserEvaluatePath();
		if(json!=null && !"".equals(json))
		{
			FileTool.saveFile2(path, json);
		}
		return ;
	}

	public static void writeDataBuilding(List<Building> buildings) {
		String json = JsonTool.ToBuildingJson(buildings);
		String path = FilePathSet.getBuildingPath();
		if(json!=null && !"".equals(json))
		{
			FileTool.saveFile2(path, json);
		}
		return ;
	}

	public static void writeDataAdmin(List<Admin> admins) {
		String json = JsonTool.ToAdminJson(admins);
		String path = FilePathSet.getAdminPath();
		if(json!=null && !"".equals(json))
		{
			FileTool.saveFile2(path, json);
		}
		return ;
		
	}

}
