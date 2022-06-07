package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.pojo.Employee;
import com.mindgate.main.service.EmployeeServiceInterface;

@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("employeecrud")
public class EmployeeCRUDController {
	@Autowired
	private EmployeeServiceInterface employeeService;
	@RequestMapping(value="employee",method =RequestMethod.POST)
	public boolean addNewEmployee(@RequestBody Employee employee)
	{
		System.out.println("Object Recevied");
		System.out.println(employee);
		return employeeService.addEmployee(employee);
	}
	@RequestMapping(value="employee",method =RequestMethod.GET)
	public List<Employee>getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}
	
	@RequestMapping(value="employee/{employeeId}",method =RequestMethod.DELETE)
	public boolean deleteEmployee(@PathVariable int employeeId)
	{
		return employeeService.deleteEmployee(employeeId);
		
	}
	@RequestMapping(value="employee/{employeeId}",method =RequestMethod.GET)
	public Employee getEmployee(@PathVariable int employeeId)
	{
		return employeeService.getEmployeeByEmployeeId(employeeId);
		
	}
	@RequestMapping(value="employee",method =RequestMethod.PUT)
	public boolean updateEmployee(@RequestBody Employee employee)
	{
		return employeeService.updateEmployee(employee);
	}
	
	
}
