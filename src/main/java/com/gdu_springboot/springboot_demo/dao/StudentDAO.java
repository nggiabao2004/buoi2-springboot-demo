//04jan2025
package com.gdu_springboot.springboot_demo.dao;

import com.gdu_springboot.springboot_demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    void update(Student student);
    void delete(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByName(String name);
    int deleteAll();
}
