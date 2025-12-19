# Student Management System (Java + MySQL)

## Description
This is a **Student Management System** developed using **Core Java** and **MySQL**.  
It allows managing student records with **Create, Read, Update, and Delete (CRUD)** operations.  
The project uses **JDBC** for database connectivity and follows a **layered architecture** (DAO, Service, Model) for clean code organization.

---

## Features
- Add new student records  
- View all student records  
- Update existing student details  
- Delete student records  
- MySQL database integration using JDBC  
- Console-based user interface  

---

## Tech Stack
- **Language:** Java (Core Java)  
- **Database:** MySQL  
- **Connectivity:** JDBC  
- **IDE:** Eclipse / IntelliJ IDEA (any Java IDE)

---

## Database Setup

Run the following steps to set up the database for the Student Management System:

1. **Create Database**  
Run the following SQL commands in your MySQL client:  
CREATE DATABASE student_db;  
USE student_db;

2. **Create Table**  
Run the following SQL command to create the `students` table:  
CREATE TABLE students (  
  id INT PRIMARY KEY AUTO_INCREMENT,  
  name VARCHAR(100) NOT NULL,  
  email VARCHAR(100) NOT NULL,  
  course VARCHAR(50) NOT NULL  
);

3. **Configure Database Connection**  
Update the `db.properties` file with your database credentials:  
db.url=jdbc:mysql://localhost:3306/student_db  
db.username=root  
db.password=your_password

---

## How to Run
1. Clone the repository using:  
git clone https://github.com/your-username/student-management-system-java.git

2. Open the project in your Java IDE.  
3. Add the MySQL JDBC Driver to the project classpath (if not using Maven).  
4. Run `Main.java` to start the console application.

---
