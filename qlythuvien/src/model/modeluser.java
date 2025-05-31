package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class modeluser {
	public boolean login(String ten, String matkhau) {
        String sql = "SELECT * FROM user WHERE ten = ? AND matkhau = ?";

        try (Connection conn = connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ten);
            stmt.setString(2, matkhau);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true nếu có tài khoản hợp lệ

        } catch (SQLException e) {
            System.out.println("Lỗi đăng nhập: " + e.getMessage());
            return false;
        }
    }

    public boolean register(String ten, String matkhau) {
        String sql = "INSERT INTO user(ten, matkhau) VALUES (?, ?)";

        try (Connection conn = connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ten);
            stmt.setString(2, matkhau);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.out.println("Lỗi đăng ký: " + e.getMessage());
            return false;
        }
    }
}
