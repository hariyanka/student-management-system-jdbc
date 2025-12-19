package com.example.service;

import java.util.List;

import com.example.model.Student;

public interface StudentService {    
    boolean addStudent(Student s);
    Student getStudentById(int id);
    List<Student> getAllStudents();
    boolean updateStudent(int id, Student student);
    boolean removeStudent(int id);
}
