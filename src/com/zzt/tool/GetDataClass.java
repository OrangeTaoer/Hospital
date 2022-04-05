package com.zzt.tool;

import java.util.ArrayList;
import java.util.List;

import com.zzt.entity.Admin;
import com.zzt.entity.Employee;
import com.zzt.entity.Patient;
import com.zzt.entity.Problem;
import com.zzt.entity.ProblemModel;
import com.zzt.entity.UserEvaluate;
import com.zzt.entity.build.Bed;
import com.zzt.entity.build.BuildFloor;
import com.zzt.entity.build.Building;
import com.zzt.entity.build.Room;

public class GetDataClass {

	//从文件中获取员工list
	public static List<Employee> getDataEmployeeClass ()
	{
		List<Employee> employees = new ArrayList<Employee>();//首先定义并实例化员工类的动态数组
		String path = FilePathSet.getEmployeePath(); //然后获取员工类的相对路径
		String json = FileTool.readFile2(path);      //然后获取员工类存入文件中的json文本
		if(json != null && !"".equals(json))         //判断json文本是否为空，防止空指针异常
		employees = JsonTool.ToEmployeeArray(json);  //利用工具类将json转为员工类的动态数组
		return employees;                            //返回员工类
	}
	
	public static List<Problem> getDataProblemClass ()
	{
		List<Problem> patients = new ArrayList<Problem>();
		String path = FilePathSet.getProblemPath();
		String json = FileTool.readFile2(path);
		
		
		if(json != null && !"".equals(json))
		patients = JsonTool.ToProblemArray(json);
		
		return patients;
	}
	
	public static List<Patient> getDataPatientClass ()
	{
		List<Patient> patients = new ArrayList<Patient>();
		String path = FilePathSet.getPatientPath();
		String json = FileTool.readFile2(path);
		
		
		if(json != null && !"".equals(json))
		patients = JsonTool.ToPatientArray(json);
		
		return patients;
	}

	public static List<ProblemModel> getDataProblemModelClass() {
        List<ProblemModel> patients = new ArrayList<ProblemModel>();
		String filename = FilePathSet.getProblemModelPath();
		String json = FileTool.readFile2(filename);
		if(json != null && !"".equals(json))
		patients = JsonTool.ToPatientModelArray(json);
		return patients;
	}

	public static List<UserEvaluate> getDataUserEvaluate() {
        List<UserEvaluate> patients = new ArrayList<UserEvaluate>();
        String filename = FilePathSet.getUserEvaluatePath();
		String json = FileTool.readFile2(filename);
		if(json != null && !"".equals(json))
		patients = JsonTool.ToUserEvaluateArray(json);
		return patients;
	}

	public static List<Building> getDataBuildingClass() {
		List<Building> patients = new ArrayList<Building>();
		String filename = FilePathSet.getBuildingPath();
		String json = FileTool.readFile2(filename);
		if(json != null && !"".equals(json))
		patients = JsonTool.ToBuildingArray(json);
		return patients;
	}
	
	public static List<Bed> getDataBedClass() {
		List<Bed> beds2 = new ArrayList<Bed>();
		
		List <Building> buildings = GetDataClass.getDataBuildingClass();
		if(buildings != null && !buildings.isEmpty())
		{
			for(Building t : buildings)
			{
				List<BuildFloor> buildfloors = t.getBuildFloors();
				if(buildfloors != null && !buildfloors.isEmpty())
				{
					for(BuildFloor bf : buildfloors)
					{
						List<Room> rooms = bf.getRooms();
						if(rooms != null && !rooms.isEmpty())
						{
							for(Room rm : rooms)
							{
								List<Bed> beds = rm.getBeds();
								if(beds != null && !beds.isEmpty())
								{
									for(Bed bd : beds)
									{
										beds2.add(bd);
									}
								}
							}
						}
					}
				}
			}
		}
		
		return beds2;
	}

	public static List<Admin> getDataAdminClass() {
		List<Admin> patients = new ArrayList<Admin>();
		String filename = FilePathSet.getAdminPath();
		String json = FileTool.readFile2(filename);
		if(json != null && !"".equals(json))
		patients = JsonTool.ToAdminArray(json);
		return patients;
	}
	
}
