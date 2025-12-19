package com.example.main;

import java.util.Scanner;

import com.example.model.Student;
import com.example.service.StudentService;
import com.example.service.StudentServiceImplementation;

public class App 
{
    private static Scanner sc = new Scanner(System.in);
    private static StudentService service = new StudentServiceImplementation();
    public static void main( String[] args )
    {

        while(true)
        {
            System.out.println("1.add student");
            System.out.println("2.find by id");
            System.out.println("3.find all students");
            System.out.println("4.modify student data");
            System.out.println("5.Delete by id");
            System.out.println("10.exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("id: ");
                    int id = sc.nextInt();
                    System.out.print("enter name: ");
                    String name = sc.next();
                    System.out.print("age: ");
                    int age = sc.nextInt();
                    System.out.print("email: ");
                    String email = sc.next();

                    System.out.println(service.addStudent(new Student(id,name,age,email)) ? "student added sucessfully" : "student not added");

                    break;

                case 2:
                    System.out.print("enter id: ");
                    id = sc.nextInt();
                    Student s = service.getStudentById(id);
                    if(s!=null)
                        System.out.println(s);
                    else
                        System.out.println("not found");
                    break;

                case 3:
                    System.out.println(service.getAllStudents().isEmpty() ? "no records" : service.getAllStudents());
                    break;

                case 4:
                    System.out.print("enter id: ");
                    id=sc.nextInt();
                    System.out.print("modified name: ");
                    name = sc.next();
                    System.out.print("modified age: ");
                    age = sc.nextInt();
                    System.out.print("modified email: ");
                    email = sc.next();

                    System.out.println(service.updateStudent(id, new Student(id, name, age, email)) ? "updated" : "failed");

                    break;

                case 5:
                    System.out.print("id: ");
                    id=sc.nextInt();
                    System.out.println(service.removeStudent(id)? "removed" : "failed");
                    break;

                case 10:
                    System.out.println("exited...");
                    System.exit(0);
                default:
                    break;
            }
        }

        

        
    }
}
