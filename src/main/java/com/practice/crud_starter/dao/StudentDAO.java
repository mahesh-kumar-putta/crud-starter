package com.practice.crud_starter.dao;

import java.util.List;

import com.practice.crud_starter.entity.Student;

public interface StudentDAO {

	void save(Student student);
	
	Student findByID(int id);
	
	List<Student> findAll();
	
	List<Student> findByLastName(String lastName);

	void updateStudent(Student student);
	
	void delete(int id);
	
	int deleteAll();
}
