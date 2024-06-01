package com.practice.crud_starter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practice.crud_starter.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	
	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student findByID(int id) {
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY firstName DESC",Student.class);
		return query.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:lastName",Student.class);
		query.setParameter("lastName", lastName);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void updateStudent(Student student) {
		
		Student rows = entityManager.merge(student);
		System.out.println("updated object is "+student);
		
	}

	@Override
	@Transactional
	public void delete(int id) {

		Student student = findByID(id);
		System.out.println("Removing student "+student);
		entityManager.remove(student);
	}

	@Override
	@Transactional
	public int deleteAll() {
		int rowsEffected = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		
		return rowsEffected;
	}

}
