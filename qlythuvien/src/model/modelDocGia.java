package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class modelDocGia {
    private Connection conn;

    public modelDocGia() {
        try {
            conn = connect.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<DocGia> getAll() {
        List<DocGia> list = new ArrayList<>();
        String sql = "SELECT * FROM docgia";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DocGia dg = new DocGia();
                dg.setMaDocGia(rs.getString("madocgia"));
                dg.setHoTen(rs.getString("hoten"));
                dg.setGioiTinh(rs.getString("gioitinh"));
                dg.setNgaySinh(rs.getDate("ngaysinh"));
                dg.setDiaChi(rs.getString("diachi"));
                dg.setEmail(rs.getString("email"));
                dg.setSoDienThoai(rs.getString("sodienthoai"));
                dg.setNgayLamThe(rs.getTimestamp("ngaylamthe"));
                dg.setNgayHetHan(rs.getTimestamp("ngayhethan"));
                list.add(dg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean them(DocGia dg) {
        String sql = "INSERT INTO docgia (madocgia, hoten, gioitinh, ngaysinh, diachi, email, sodienthoai, ngaylamthe, ngayhethan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dg.getMaDocGia());
            ps.setString(2, dg.getHoTen());
            ps.setString(3, dg.getGioiTinh());
            ps.setDate(4, dg.getNgaySinh() != null ? new java.sql.Date(dg.getNgaySinh().getTime()) : null);
            ps.setString(5, dg.getDiaChi());
            ps.setString(6, dg.getEmail());
            ps.setString(7, dg.getSoDienThoai());
            ps.setTimestamp(8, dg.getNgayLamThe() != null ? new java.sql.Timestamp(dg.getNgayLamThe().getTime()) : null);
            ps.setTimestamp(9, dg.getNgayHetHan() != null ? new java.sql.Timestamp(dg.getNgayHetHan().getTime()) : null);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean capNhat(DocGia dg) {
        String sql = "UPDATE docgia SET hoten = ?, gioitinh = ?, ngaysinh = ?, diachi = ?, email = ?, sodienthoai = ?, ngaylamthe = ?, ngayhethan = ? WHERE madocgia = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dg.getHoTen());
            ps.setString(2, dg.getGioiTinh());
            ps.setDate(3, dg.getNgaySinh() != null ? new java.sql.Date(dg.getNgaySinh().getTime()) : null);
            ps.setString(4, dg.getDiaChi());
            ps.setString(5, dg.getEmail());
            ps.setString(6, dg.getSoDienThoai());
            ps.setTimestamp(7, dg.getNgayLamThe() != null ? new java.sql.Timestamp(dg.getNgayLamThe().getTime()) : null);
            ps.setTimestamp(8, dg.getNgayHetHan() != null ? new java.sql.Timestamp(dg.getNgayHetHan().getTime()) : null);
            ps.setString(9, dg.getMaDocGia());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean xoa(String maDocGia) {
        String sql = "DELETE FROM docgia WHERE madocgia = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maDocGia);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<DocGia> timKiem(String keyword) {
        List<DocGia> list = new ArrayList<>();
        String sql = "SELECT * FROM docgia WHERE madocgia LIKE ? OR hoten LIKE ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            String searchPattern = "%" + keyword + "%";
            ps.setString(1, searchPattern);
            ps.setString(2, searchPattern);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DocGia dg = new DocGia();
                    dg.setMaDocGia(rs.getString("madocgia"));
                    dg.setHoTen(rs.getString("hoten"));
                    dg.setGioiTinh(rs.getString("gioitinh"));
                    dg.setNgaySinh(rs.getDate("ngaysinh"));
                    dg.setDiaChi(rs.getString("diachi"));
                    dg.setEmail(rs.getString("email"));
                    dg.setSoDienThoai(rs.getString("sodienthoai"));
                    dg.setNgayLamThe(rs.getTimestamp("ngaylamthe"));
                    dg.setNgayHetHan(rs.getTimestamp("ngayhethan"));
                    list.add(dg);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}