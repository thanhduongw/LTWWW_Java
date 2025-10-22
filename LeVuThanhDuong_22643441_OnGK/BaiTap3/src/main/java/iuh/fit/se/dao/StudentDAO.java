package iuh.fit.se.dao;

import iuh.fit.se.model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
    Student findById(String id);
    List<Student> findByClassName(String className);
    boolean add(Student student);
    boolean update(Student student);
    boolean delete(String id);
}
