//04jan2025
package com.gdu_springboot.springboot_demo.dao;

import com.gdu_springboot.springboot_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public class StudentDAOImp implements StudentDAO {
    private EntityManager em;

    public StudentDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Student student) {

        em.persist(student);
    }

    @Override
    @Transactional
    public void update(Student student) {
        em.merge(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        em.remove(em.contains(student) ? student : em.merge(student));
    }

    @Override
    public Student findById(int id)
    {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        return List.of();
    }

    @Override
    public List<Student> findByName(String name) {

        return List.of();
    }

    @Override
    public int deleteAll() {

        return 0;
    }

}
