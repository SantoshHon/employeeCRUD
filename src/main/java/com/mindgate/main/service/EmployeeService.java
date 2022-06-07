package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.pojo.Employee;
import com.mindgate.main.repositotory.EmployeeRepository;
import com.mindgate.main.repositotory.EmployeeRepositoryInterface;

@Service

public class EmployeeService implements EmployeeServiceInterface {
	@Autowired
	private EmployeeRepositoryInterface employeeRepository;

	@Override
	public boolean addEmployee(Employee employee) {
		return employeeRepository.addEmployee(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeRepository.updateEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(int employeeid) {
		return employeeRepository.deleteEmployee(employeeid);
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		return employeeRepository.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.getAllEmployee();
	}

}
