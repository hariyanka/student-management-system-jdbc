package com.example.service;

import java.util.List;

import com.example.dao.StudentDao;
import com.example.dao.StudentDaoImplementation;
import com.example.model.Student;

public class StudentServiceImplementation implements StudentService{

    private StudentDao dao= new StudentDaoImplementation();

    @Override
    public boolean addStudent(Student s) {
        return dao.saveStudent(s);
    }

    public Student getStudentById(int id){
        return dao.findStudent(id);
    }

    public List<Student> getAllStudents(){
        return dao.findAll();
    }

    @Override
    public boolean updateStudent(int id, Student student) {

        return dao.modifyStudent(id, student);
    }

    @Override
    public boolean removeStudent(int id) {
        return dao.delete(id);
    }

    


}
