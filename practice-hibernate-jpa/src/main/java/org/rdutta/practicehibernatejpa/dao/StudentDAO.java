package org.rdutta.practicehibernatejpa.dao;

import org.rdutta.practicehibernatejpa.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDAO {
    void save(Student student);
    Student findById(UUID studentId);
    List<Student> findAll();
    List<Student> findByEmail(String email);
    void update(Student student);
    void filterDelete(UUID studentId);
    int deleteAtOnce();
}
