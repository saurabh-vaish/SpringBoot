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
@Table(name="student_rest")
public class Student {

	@Id
	@GeneratedValue(generator = "stu")
	@GenericGenerator(name = "stu",strategy = "increment")
	private Integer sid;
	
	private String sname;
	
	private String scourse;
	
	private Double sfee; 
	
}
