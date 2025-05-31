package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class modelPhongDoc {

    public boolean them(Phongdoc phong) {
        String sql = "INSERT INTO phongdoc (maphongdoc, phong, tang, trangthai, soluongnguoi, loaiphong) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, phong.getMaPhongDoc());
            ps.setString(2, phong.getPhong());
            ps.setString(3, phong.getTang());
            ps.setString(4, phong.getTrangThai());
            ps.setInt(5, phong.getSoLuongNguoi());
            ps.setString(6, phong.getLoaiPhong());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean capNhat(Phongdoc phong) {
        String sql = "UPDATE phongdoc SET phong=?, tang=?, trangthai=?, soluongnguoi=?, loaiphong=? WHERE maphongdoc=?";
        try (Connection conn = connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, phong.getPhong());
            ps.setString(2, phong.getTang());
            ps.setString(3, phong.getTrangThai());
            ps.setInt(4, phong.getSoLuongNguoi());
            ps.setString(5, phong.getLoaiPhong());
            ps.setString(6, phong.getMaPhongDoc());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean xoa(String maPhongDoc) {
        String sql = "DELETE FROM phongdoc WHERE maphongdoc=?";
        try (Connection conn = connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maPhongDoc);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Phongdoc> timKiem(String keyword) {
        List<Phongdoc> list = new ArrayList<>();
        String sql = "SELECT * FROM phongdoc WHERE maphongdoc LIKE ? OR phong LIKE ? OR tang LIKE ? OR trangthai LIKE ? OR CAST(soluongnguoi AS CHAR) LIKE ? OR loaiphong LIKE ?";
        try (Connection conn = connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 6; i++) {
                ps.setString(i, "%" + keyword + "%");
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Phongdoc(
                        rs.getString("maphongdoc"),
                        rs.getString("phong"),
                        rs.getString("tang"),
                        rs.getString("trangthai"),
                        rs.getInt("soluongnguoi"),
                        rs.getString("loaiphong")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Phongdoc> getAll() {
        List<Phongdoc> list = new ArrayList<>();
        String sql = "SELECT * FROM phongdoc";
        try (Connection conn = connect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Phongdoc(
                        rs.getString("maphongdoc"),
                        rs.getString("phong"),
                        rs.getString("tang"),
                        rs.getString("trangthai"),
                        rs.getInt("soluongnguoi"),
                        rs.getString("loaiphong")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
