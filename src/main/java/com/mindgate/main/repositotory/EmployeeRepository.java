package com.mindgate.main.repositotory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.pojo.Employee;
@Repository
public class EmployeeRepository implements EmployeeRepositoryInterface{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String INSERT_EMPLOYEE = "INSERT INTO employee_details(employee_id,name,salary) VALUES(SEQ_EMPLOYEE_DETAILS.nextval, ?,?)";
	private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee_details ORDER BY employee_id";
	private static final String SELECT_SINGLE_EMPLOYEE = "SELECT * FROM employee_details WHERE employee_id = ?";
	private static final String UPDATE_EMPLOYEE = "UPDATE employee_details SET name = ? , salary = ? "
			+ "	WHERE employee_id = ?";
	private static final String DELETE_EMPLOYEE = "DELETE employee_details WHERE employee_id = ?";

	private int resultCount;

	public EmployeeRepository() {
	}

	@Override
	public boolean addEmployee(Employee employee) {
		System.out.println("inserting new employee into database");
		System.out.println(employee);

		Object[] args = { employee.getName(), employee.getSalary() };

		resultCount = jdbcTemplate.update(INSERT_EMPLOYEE, args);

		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> allEmployees = jdbcTemplate.query(SELECT_ALL_EMPLOYEES, new EmployeeRowMapper());
		return allEmployees;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		Object[] args = { employeeId };
		Employee employee = jdbcTemplate.queryForObject(SELECT_SINGLE_EMPLOYEE , new EmployeeRowMapper(), args);
		return employee;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Object[] args = { employee.getName(), employee.getSalary(), employee.getEmployeeId() };
		resultCount = jdbcTemplate.update(UPDATE_EMPLOYEE, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		Object[] args = { employeeId };
		resultCount = jdbcTemplate.update(DELETE_EMPLOYEE, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

}
