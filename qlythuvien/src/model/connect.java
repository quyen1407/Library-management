package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
    private static final String URL = "jdbc:mysql://localhost:3306/qlythuvien"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "2004"; 

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy driver MySQL: " + e.getMessage());
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
