package com.gdu_springboot.springboot_demo;

import com.gdu_springboot.springboot_demo.dao.StudentDAO;
import com.gdu_springboot.springboot_demo.entity.Student;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			//System.out.println("Connected Database");
			//CreateStudent(studentDAO); //Xung dot, gay ERROR o bt5

			//bt2: hien student
			//System.out.println("Insert Student");
			//ViewStudent(studentDAO);

			//bt3: update student
			//UpdateStudent(studentDAO);
			//ViewStudent(studentDAO);

			//bt4: delete student
			//DeleteStudent(studentDAO);
			//System.out.println("Deleted a Student in Database");

			//bt5: viewAll students
			//ViewAllStudent(studentDAO);

			//bt6: viewStudentByName
			//ViewStudentsByName(studentDAO);

			//bt7: deleteAll students
			DeleteAll(studentDAO);
			System.out.println("Delete All Students");
		};
	}

	private void ViewStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		System.out.println(student);
	}

	private void CreateStudent(StudentDAO studentDAO){
		Student student1 = new Student("Truong", "Tran", "ngtruong@gmail.com");
		studentDAO.save(student1);
		Student student2 = new Student("An", "Le", "an@gmail.com");
		studentDAO.save(student2);
		Student student3 = new Student("Hung", "Tran", "hung@gmail.com");
		studentDAO.save(student3);
		Student student4 = new Student("Binh", "Phan", "binh@gmail.com");
		studentDAO.save(student4);
		Student student5 = new Student("Truong", "Vu", "truongvu@gmail.com");
		studentDAO.save(student5);
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

	private void ViewAllStudent(StudentDAO studentDAO){
		List<Student> students = studentDAO.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void ViewStudentsByName(StudentDAO studentDAO){
		List<Student> students = studentDAO.findByName("Truong");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void DeleteAll(StudentDAO studentDAO){
		int num= studentDAO.deleteAll();
		System.out.println("Deleted "+ num + " student(s)");
	}
}
