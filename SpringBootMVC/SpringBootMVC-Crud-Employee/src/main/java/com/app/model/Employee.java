package com.app.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;


@Entity
@Table(name="employee_tab")
@Data
public class Employee {

	@Id
	@GeneratedValue(generator = "emp")
	@GenericGenerator(name = "emp",strategy = "increment")
	@Column(name="id")
	private Integer empId;
	
	@Column(name="name")
	private String empName;
	
	@Column(name="sal")
	private Double empSal;
	
	@Column(name="dept")
	private String empDept;    // dropdown
	
	@Column(name="gen")
	private String empGen;   // radiobutton
	
	@ElementCollection
	@CollectionTable(name="employee_prjs",
			joinColumns = @JoinColumn(name="eidFk")
	)
	@Column(name="prjs")
	private Set<String> empPrjs;   // checkBox


}
