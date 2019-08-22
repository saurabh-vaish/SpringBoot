package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Employee;
import com.app.repo.EmployeeRepository;
import com.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repo;

	@Transactional
	public Integer saveEmployee(Employee employee) {
		Employee p = repo.save(employee);
		return p.getEmpId();
	}

	@Transactional
	public Employee updateEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Transactional
	public void deleteEmployee(Integer id) {
			repo.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> emp = repo.findById(id);
		if(emp.isPresent())
		{
			return emp.get();
		}
		else return null;
	} 

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

}
