package com.zzt.service;

import java.util.HashMap;
import java.util.List;

import com.zzt.entity.Employee;

public interface EmployeeService {

	//判断是否能够增加员工：
	public abstract boolean isAddEmployee(String acNumber);
	
	//增加员工：
	public abstract void addEmploee(Employee employee);
	
	//删除员工：
	public abstract void deleteEmployee(String acNumber);
	
	//修改员工：
	public abstract void correctEmployee(String id,Employee employee);
	
	//查询员工：
	public abstract Integer findEmployee(String acNumber,HashMap<String,Integer> hash);
	
	//询问员工：即返回员工List
	public abstract List<Employee> getEmployee();

}
