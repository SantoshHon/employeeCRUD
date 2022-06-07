package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.pojo.Employee;

public interface EmployeeServiceInterface {
	public boolean addEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int employeeid);
	public Employee getEmployeeByEmployeeId(int employeeId);
	public List<Employee>getAllEmployee();

}
