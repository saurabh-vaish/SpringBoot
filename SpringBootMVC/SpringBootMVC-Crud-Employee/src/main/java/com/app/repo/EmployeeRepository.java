package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
