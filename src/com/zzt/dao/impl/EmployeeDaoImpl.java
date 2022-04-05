package com.zzt.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.zzt.dao.EmployeeDao;
import com.zzt.entity.Employee;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.IsRegister;
import com.zzt.tool.WriteDataClass;

public class EmployeeDaoImpl implements EmployeeDao {

	// 使用单例模式：
	private static EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();

	private EmployeeDaoImpl() {

	}

	public static EmployeeDaoImpl getEmployeeDaoImpl() {
		return employeeDaoImpl;
	}

	//实现接口中的方法：
	//判断是否能够增加员工：
	@Override
	public boolean isAddEmployee(String acNumber) {
		return IsRegister.EmployeeIsRegister(acNumber);
	}
	
	//增加员工：
	@Override
	public void addEmploee(Employee employee) {
		List<Employee> employees = GetDataClass.getDataEmployeeClass();//利用tool层工具类读取Employee类的数据
		if (employees == null) {                   //判断读取到的employees是否为空，防止空指针异常
			employees = new ArrayList<Employee>(); //若为空，则先实例化
		}
		employees.add(employee);                   //往类中添加数据                    
		WriteDataClass.writeDataEmployee(employees);//向文件中写入数据
		return;  
	}
	
	
	//删除员工：
	@Override
	public void deleteEmployee(String acNumber) {
		List<Employee> employees = GetDataClass.getDataEmployeeClass();//利用tool层工具类读取Employee类的数据
		if (employees == null) {                     //判断读取到的employees是否为空，防止空指针异常
			employees = new ArrayList<Employee>();   //若为空，则先实例化
		}
		for (Employee t : employees) {
			if (t.getAcNumber().equals(acNumber)) {
				employees.remove(t);                  //查找员工，进行删除
			}
		}
		WriteDataClass.writeDataEmployee(employees); //利用工具层的类的静态方法将数据保存至文件
		return;
	}
	
	
	
	//修改员工：
	@Override
	public void correctEmployee(String id, Employee employee) {
		List<Employee> employees = GetDataClass.getDataEmployeeClass();//从文件中读取数据
		int i = 0;  //定义想要set类中元素的位置
		if (employees != null && !employees.isEmpty()) {//判断读取类是否为空，防止空指针异常
			for (Employee t : employees) {              
				if (t.getAcNumber().equals(id)) {
					employees.set(i, employee);         //找到想要set的元素，进行set（修改）
				}
				i++;                                  //随着遍历增加序号
			}
		}
		WriteDataClass.writeDataEmployee(employees);  //向文件写入数据
		return;
	}
	
	
	//查找员工
	@Override
	public Integer findEmployee(String acNumber, HashMap<String, Integer> hash) {
		//使用哈希表查找：时间复杂度O（1）
		if (hash.containsKey(acNumber)) { //判断哈希表的key是否存在
			return hash.get(acNumber);    //若存在则返回哈希值（元素在list中的序号）
		}
		return -1; // 代表不存在该位置
	}

	
	@Override
	public List<Employee> getEmployee() {
		return GetDataClass.getDataEmployeeClass();
	}

}
