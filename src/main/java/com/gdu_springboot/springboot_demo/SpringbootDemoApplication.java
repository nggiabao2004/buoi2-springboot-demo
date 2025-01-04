package com.gdu_springboot.springboot_demo;

import com.gdu_springboot.springboot_demo.dao.StudentDAO;
import com.gdu_springboot.springboot_demo.entity.Student;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	//04jan2025
	@Bean
	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner->{
			//bt1: ket noi database
			System.out.println("Connected Database");
			CreateStudent(studentDAO);
			//bt2: hien student
			System.out.println("Insert Student");
			ViewStudent(studentDAO);
			//bt3: update student
			UpdateStudent(studentDAO);
			ViewStudent(studentDAO);
			//bt4: delete student
			DeleteStudent(studentDAO);
			System.out.println("Deleted a Student in Database");
		};
	}

	private void ViewStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		System.out.println(student);
	}

	private void CreateStudent(StudentDAO studentDAO){
		Student student = new Student("Truong", "Tran", "truong123@gmail.com");
		studentDAO.save(student);
	}

	private void UpdateStudent(StudentDAO studentDAO){
		Student student = studentDAO.findById(1);
		student.setFirst_name("Hung");
		student.setLast_name("Nguyen");
		student.setEmail("hungnguyen@gmail.com");
		studentDAO.update(student);
	}

	private void DeleteStudent(StudentDAO studentDAO){
		Student student = studentDAO.findById(1);
		studentDAO.delete(student);
	}
}
