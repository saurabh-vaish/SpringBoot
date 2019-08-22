package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface EmployeeService {

	public Integer saveEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(Integer id);
	public Employee getOneEmployee(Integer id);
	public List<Employee> getAllEmployees();
	
}
