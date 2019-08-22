package com.app.service;

import java.util.List;

import com.app.model.Student;

public interface IStudentService {

	public Integer saveStudent(Student s);

	public Integer updateStudent(Student s);
	
	public Student getStudent(Integer sid);

	public void deleteStudent(Integer sid);
	
	public List<Student> getAll();

	public List<Student> saveAllStudent(List<Student> s);
}
