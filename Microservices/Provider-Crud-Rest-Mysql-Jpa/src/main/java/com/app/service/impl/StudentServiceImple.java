package com.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.exception.StudentNotFoundException;
import com.app.model.Student;
import com.app.repo.StudentRepository;
import com.app.service.IStudentService;

@Service
public class StudentServiceImple implements IStudentService {


	@Autowired
	private StudentRepository repo;
	
	
	@Transactional
	public Integer saveStudent(Student s) {
		return repo.save(s).getSid();
	}

	
	@Transactional
	public List<Student> saveAllStudent(List<Student> s) {
		return repo.saveAll(s);
	}

	
	@Transactional
	public Integer updateStudent(Student s) {
		return repo.save(s).getSid();
	}

	
	@Transactional(readOnly = true)
	public Student getStudent(Integer sid) {
		Optional<Student> s= repo.findById(sid);
		if(s.isPresent()) {
			return s.get();
		}
		else throw new StudentNotFoundException("No Student Found With Given Id");
	}

	
	@Transactional
	public void deleteStudent(Integer sid) {
		try {
			repo.deleteById(sid);
		}
		catch(Exception e)
		{
			throw new StudentNotFoundException("No Student Found With Given Id");
		}
	}

	
	@Transactional(readOnly = true)
	public List<Student> getAll() {
		List<Student> list = repo.findAll();
		
		
		if(list!=null && !list.isEmpty())
		{
				// sorting student based on names  using collections
				/* 
				Collections.sort(list,new Comparator<Student>() {
					@Override
					public int compare(Student o1, Student o2) {
						return o1.getSname().compareTo(o2.getSname());
					}
				});
				
				*/
						
				// using streams
				return list.stream()
						.sorted((s1,s2)->s1.getSname().compareTo(s2.getSname()))	// sorting based on names in asc
						.collect(Collectors.toList());								// collect as list from stream
		}
		else return list;
	}

}
