package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private final static String URL = "jdbc:mysql://localhost:3306/studentmanagement";
    private final static String user = "root";
    private final static String pwd =  your_password;

    public static Connection getConnection()
    {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }

}

