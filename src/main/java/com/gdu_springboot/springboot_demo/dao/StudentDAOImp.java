//04jan2025
package com.gdu_springboot.springboot_demo.dao;

import com.gdu_springboot.springboot_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
        TypedQuery<Student> query = em.createQuery("select s from Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByName(String name) {
        TypedQuery<Student> query= em.createQuery("select s from Student s where s.first_name = :theName", Student.class);
        query.setParameter("theName", name);
        return query.getResultList();
    }

    @Override
    @Transactional
    public int deleteAll() {
        //int numRows= em.createQuery("delete from Student", Student.class).getResultList().size();
        int numRows= em.createQuery("delete from Student").executeUpdate();
        return numRows;
    }

}
