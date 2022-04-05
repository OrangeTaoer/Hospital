package com.zzt.controller.impl;

import java.util.HashMap;
import java.util.List;

import com.zzt.controller.EmployeeController;
import com.zzt.entity.Employee;
import com.zzt.service.impl.AdminServiceImpl;
import com.zzt.service.impl.EmployeeServiceImpl;

public class EmployeeControllerImpl implements EmployeeController {

	private static EmployeeControllerImpl employeeControllerImpl = new EmployeeControllerImpl();

	public EmployeeControllerImpl() {

	}

	public static EmployeeControllerImpl getEmployeeControllerImpl() {
		return employeeControllerImpl;
	}

	private EmployeeServiceImpl employeeServiceImpl = EmployeeServiceImpl
			.getEmployeeServiceImpl();

	@Override
	public boolean isAddEmployee(String acNumber) {
		return employeeServiceImpl.isAddEmployee(acNumber);
	}

	@Override
	public void addEmploee(Employee employee) {
		employeeServiceImpl.addEmploee(employee);
	}

	@Override
	public void deleteEmployee(String acNumber) {
		employeeServiceImpl.deleteEmployee(acNumber);
	}

	@Override
	public void correctEmployee(String id,Employee employee) {
		employeeServiceImpl.correctEmployee(id,employee);
	}

	@Override
	public Integer findEmployee(String acNumber, HashMap<String, Integer> hash) {
		return employeeServiceImpl.findEmployee(acNumber, hash);
	}

	@Override
	public List<Employee> getEmployee() {
		return employeeServiceImpl.getEmployee();
	}

}
