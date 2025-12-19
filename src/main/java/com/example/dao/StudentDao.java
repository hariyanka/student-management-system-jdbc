package com.example.dao;

import java.util.List;

import com.example.model.Student;

public interface StudentDao {

    boolean saveStudent(Student s);
    Student findStudent(int id);
    List<Student> findAll();
    boolean modifyStudent(int id, Student student);
    boolean delete(int id);

}
