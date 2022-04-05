package com.zzt.service.impl;

import java.util.HashMap;
import java.util.List;

import com.zzt.dao.impl.EmployeeDaoImpl;
import com.zzt.entity.Employee;
import com.zzt.service.EmployeeService;
import com.zzt.tool.IsRegister;

public class EmployeeServiceImpl implements EmployeeService {

	private static EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
	
	private EmployeeServiceImpl()
	{
		
	}
	public static  EmployeeServiceImpl getEmployeeServiceImpl()
	{
		return employeeServiceImpl;
	}
	
	private EmployeeDaoImpl employeeDaoImpl= EmployeeDaoImpl.getEmployeeDaoImpl();
	
	
	@Override
	public boolean isAddEmployee(String acNumber) {
		return employeeDaoImpl.isAddEmployee(acNumber);
	}

	@Override
	public void addEmploee(Employee employee) {
		employeeDaoImpl.addEmploee(employee);
	}

	@Override
	public void deleteEmployee(String acNumber) {
		// TODO Auto-generated method stub

		employeeDaoImpl.deleteEmployee(acNumber);
	}

	@Override
	public void correctEmployee(String id,Employee employee) {
		// TODO Auto-generated method stub

		employeeDaoImpl.correctEmployee(id,employee);
	}

	@Override
	public Integer findEmployee(String acNumber, HashMap<String, Integer> hash) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.findEmployee(acNumber, hash);
	}

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return employeeDaoImpl.getEmployee();
	}

}
