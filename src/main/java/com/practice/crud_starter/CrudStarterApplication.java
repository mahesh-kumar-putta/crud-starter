package com.practice.crud_starter;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.practice.crud_starter.dao.StudentDAO;
import com.practice.crud_starter.entity.Student;

@SpringBootApplication
public class CrudStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudStarterApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner print(StudentDAO studentDAO) {
		
		return runner ->{
			//createStudent(studentDAO);
			
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//readAll(studentDAO);
			//readByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);
		};
		
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting students.........");
		
		int rowsEffected = studentDAO.deleteAll();
		
		System.out.println("number of rows deleted is "+rowsEffected);
		
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 4;
		studentDAO.delete(studentId);
		System.out.println("student deleted whose id is "+studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int studentId = 2;
		System.out.println("Retrieve student details whose id is "+studentId);
		Student student = studentDAO.findByID(studentId);
		System.out.println("student details before update are "+student);
		
		student.setFirstName("hamesh");
		System.out.println("Updating student details");
		studentDAO.updateStudent(student);
		System.out.println("Updated student details "+student);
	}

	private void readByLastName(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findByLastName("kumar");
		
		for(Student student:studentList) {
			System.out.println(student);
		}	}

	private void readAll(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		
		for(Student student:studentList) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
System.out.println("Creating student object");
		
		Student student = new Student("nahesh","kumar","nahesh@kumar.com");
		
		System.out.println("Saving student");
		studentDAO.save(student);
		
		System.out.println("saved student. Generated id is "+student.getId());
		
		System.out.println("Reading student details");
		
		System.out.println("Inserted student details are : "+studentDAO.findByID(student.getId()));
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating student object");
		
		Student student1 = new Student("mahesh","kumar","mahesh@kumar.com");
		Student student2 = new Student("rahesh","kumar","rahesh@kumar.com");		
		Student student3 = new Student("sahesh","kumar","sahesh@kumar.com");
		
		System.out.println("Saving student");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);


	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student object");
		
		Student student = new Student("mahesh","kumar","mahesh@kumar.com");
		
		System.out.println("Saving student");
		studentDAO.save(student);
		
		System.out.println("saved student. Generated id is "+student.getId());
		
	}
	
}
