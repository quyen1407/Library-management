package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class modelTaiKhoan {
    public boolean them(Taikhoan tk) {
        String sql = "INSERT INTO admin (email, password) VALUES (?, ?)";
        try (Connection conn = connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tk.getEmail());
            ps.setString(2, tk.getPassword());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean capNhat(Taikhoan tk) {
        String sql = "UPDATE admin SET email = ?, password = ? WHERE id = ?";
        try (Connection conn = connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tk.getEmail());
            ps.setString(2, tk.getPassword());
            ps.setInt(3, tk.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean xoa(int id) {
        String sql = "DELETE FROM admin WHERE id = ?";
        try (Connection conn = connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Taikhoan> timKiem(String keyword) {
        List<Taikhoan> list = new ArrayList<>();
        String sql = "SELECT * FROM admin WHERE CAST(id AS CHAR) LIKE ? OR email LIKE ? OR password LIKE ?";
        try (Connection conn = connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 3; i++) {
                ps.setString(i, "%" + keyword + "%");
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Taikhoan(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Taikhoan> getAll() {
        List<Taikhoan> list = new ArrayList<>();
        String sql = "SELECT * FROM admin";
        try (Connection conn = connect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Taikhoan(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void resetAutoIncrement() {
        String sqlMaxId = "SELECT MAX(id) FROM admin";
        String sqlReset = "ALTER TABLE admin AUTO_INCREMENT = ?";
        try (Connection conn = connect.getConnection()) {
            // Get the maximum ID
            PreparedStatement psMaxId = conn.prepareStatement(sqlMaxId);
            ResultSet rs = psMaxId.executeQuery();
            int maxId = 0;
            if (rs.next()) {
                maxId = rs.getInt(1);
            }
            rs.close();
            psMaxId.close();

            // Set auto-increment to maxId + 1
            PreparedStatement psReset = conn.prepareStatement(sqlReset);
            psReset.setInt(1, maxId + 1);
            psReset.executeUpdate();
            psReset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}