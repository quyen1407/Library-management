package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class modeladmin {

    
    public boolean adminlogin(String email, String password) {
        String sql = "SELECT * FROM admin WHERE email = ? AND password = ?";

        try (Connection conn = connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Lỗi đăng nhập: " + e.getMessage());
            return false;
        }
    }

    
}
