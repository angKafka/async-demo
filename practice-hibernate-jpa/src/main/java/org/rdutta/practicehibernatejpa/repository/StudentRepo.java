package org.rdutta.practicehibernatejpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.rdutta.practicehibernatejpa.dao.StudentDAO;
import org.rdutta.practicehibernatejpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class StudentRepo implements StudentDAO {
    private EntityManager em;

    @Autowired
    public StudentRepo(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public void save(Student student) {
        em.persist(student);
    }

    @Override
    public Student findById(UUID studentId) {
        return em.find(Student.class, studentId);
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = em.createQuery("FROM Student", Student.class).getResultList();
        return studentList;
    }

    @Override
    public List<Student> findByEmail(String email) {
        List<Student> studentList = em.createQuery("FROM Student WHERE email LIKE :email", Student.class)
                .setParameter("email", "%" + email + "%")
                .getResultList();
        return studentList;
    }

    @Transactional
    @Override
    public void update(Student student) {
        em.merge(student);
    }

    @Transactional
    @Override
    public void filterDelete(UUID studentId) {
        Student student = em.find(Student.class, studentId);
        em.remove(student);
    }

    @Transactional
    @Override
    public int deleteAtOnce() {
       int numberRowAffected = em.createQuery("DELETE FROM Student").executeUpdate();
       return numberRowAffected;
    }
}
