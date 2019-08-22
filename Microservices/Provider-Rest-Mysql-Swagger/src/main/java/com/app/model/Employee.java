package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee_rest")
public class Employee {

	@Id
	@GeneratedValue(generator = "emp")
	@GenericGenerator(name="emp",strategy = "increment")
	private Integer empId;
	private String empName;
	private Double empSal;



}
