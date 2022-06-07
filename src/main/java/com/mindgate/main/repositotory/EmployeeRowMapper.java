package com.mindgate.main.repositotory;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.pojo.Employee;



public class EmployeeRowMapper implements RowMapper<Employee> {
	@Override
	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
		int employeeId = resultSet.getInt("employee_id");
		String name = resultSet.getString("name");
		double salary = resultSet.getDouble("salary");

		Employee employee = new Employee(employeeId, name, salary);
		return employee;
	} 

}
