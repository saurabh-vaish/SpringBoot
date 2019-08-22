package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeService {

	public Integer saveEmployee(Employee employee);

	public Integer updateEmployee(Employee employee);
	
	public Employee getEmployee(Integer eid);

	public void deleteEmployee(Integer eid);
	
	public List<Employee> getAll();
	
	boolean isPresent(Integer id);

}
