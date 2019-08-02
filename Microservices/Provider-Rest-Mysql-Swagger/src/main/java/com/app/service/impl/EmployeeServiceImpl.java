package com.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.exception.EmployeeNotFoundException;
import com.app.model.Employee;
import com.app.repo.EmployeeRepository;
import com.app.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {


	@Autowired
	private EmployeeRepository repo;
	
	
	@Transactional
	public Integer saveEmployee(Employee emp) {
		return repo.save(emp).getEmpId();
	}


	@Transactional
	public Integer updateEmployee(Employee emp) {
		return repo.save(emp).getEmpId();
	}

	
	@Transactional(readOnly = true)
	public boolean isPresent(Integer id)
	{
		return repo.existsById(id);
	}
	
	
	
	@Transactional(readOnly = true)
	public Employee getEmployee(Integer eid) {
		Optional<Employee> s= repo.findById(eid);
		if(s.isPresent()) {
			return s.get();
		}
		else throw new EmployeeNotFoundException("No Employee Found With Given Id");
	}

	
	@Transactional
	public void deleteEmployee(Integer eid) {
		try {
			repo.deleteById(eid);
		}
		catch(Exception e)
		{
			throw new EmployeeNotFoundException("No Employee Found With Given Id");
		}
	}

	
	@Transactional(readOnly = true)
	public List<Employee> getAll() {
		List<Employee> list = repo.findAll();
		
		
		if(list!=null && !list.isEmpty())
		{
				// sorting Employee based on names  using collections
				/* 
				Collections.sort(list,new Comparator<Employee>() {
					@Override
					public int compare(Employee e1, Employee e2) {
						return e1.getEmpName().compareTo(e2.getEmpName());
					}
				});
				
				*/
						
				// using streams
				return list.stream()
						.sorted((e1,e2)->e1.getEmpName().compareTo(e2.getEmpName()))	// sorting based on names in asc
						.collect(Collectors.toList());								// collect as list from stream
		}
		else return list;
	}

}
