package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.exception.StudentNotFound;
import com.example.model.Student;
import com.example.util.DBConnection;

public class StudentDaoImplementation implements StudentDao{

    @Override
    public boolean saveStudent(Student s) {

        try(Connection connection = DBConnection.getConnection())
        {
            String query = "insert into student values(?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,s.getId());
            statement.setString(2,s.getName());
            statement.setInt(3,s.getAge());
            statement.setString(4,s.getEmail());
            statement.execute();
            return true;     
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Student findStudent(int id) {

        String query = "select * from student where id = ?";
        Student s = null;
        try(Connection connection = DBConnection.getConnection())
        {
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
                s= new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
            else
                throw new StudentNotFound("Student with id " + id + " not found");
            return s;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return s;
    }

    public List<Student> findAll(){

        String query = "select * from student";
        List<Student> students= new ArrayList<>();

        try(Connection connection = DBConnection.getConnection())
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                Student s= new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
                students.add(s);
            }

            return students;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return students;

    }

    public boolean modifyStudent(int id,Student student){

        Student s = findStudent(id);

        if(s!=null)
        {
            String query = "update student set name = ?, age = ?, email = ? where id = ?";

            try(Connection connection = DBConnection.getConnection()){
                
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(4, id);
                statement.setString(1,student.getName());
                statement.setInt(2,student.getAge());
                statement.setString(3, student.getEmail());
                statement.executeUpdate();
                return true; 

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {

        Student s = findStudent(id);
        String query = "delete from student where id = ?";

        if(s!=null)
        {
            try(Connection connection = DBConnection.getConnection()){

                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1,id);
                statement.executeUpdate();
                return true;

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return false;
    }

}
