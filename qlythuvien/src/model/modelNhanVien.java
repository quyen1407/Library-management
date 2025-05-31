package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class modelNhanVien {
    // Assume connect class exists
    private connect connect = new connect();

    // Add employee
    public boolean them(NhanVien nv) {
        String sql = "INSERT INTO nhanvien (manv, tennv, ngaysinh, diachi, ngaylamviec, email, luong, sodienthoai, chucvu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getTenNV());
            ps.setDate(3, nv.getNgaySinh() != null ? new java.sql.Date(nv.getNgaySinh().getTime()) : null);
            ps.setString(4, nv.getDiaChi());
            ps.setTimestamp(5, nv.getNgayLamViec() != null ? new java.sql.Timestamp(nv.getNgayLamViec().getTime()) : null);
            ps.setString(6, nv.getEmail());
            ps.setDouble(7, nv.getLuong());
            ps.setString(8, nv.getSoDienThoai());
            ps.setString(9, nv.getChucVu());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update employee
    public boolean capNhat(NhanVien nv) {
        String sql = "UPDATE nhanvien SET tennv = ?, ngaysinh = ?, diachi = ?, ngaylamviec = ?, email = ?, luong = ?, sodienthoai = ?, chucvu = ? WHERE manv = ?";
        try (Connection conn = connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nv.getTenNV());
            ps.setDate(2, nv.getNgaySinh() != null ? new java.sql.Date(nv.getNgaySinh().getTime()) : null);
            ps.setString(3, nv.getDiaChi());
            ps.setTimestamp(4, nv.getNgayLamViec() != null ? new java.sql.Timestamp(nv.getNgayLamViec().getTime()) : null);
            ps.setString(5, nv.getEmail());
            ps.setDouble(6, nv.getLuong());
            ps.setString(7, nv.getSoDienThoai());
            ps.setString(8, nv.getChucVu());
            ps.setString(9, nv.getMaNV());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete employee
    public boolean xoa(String maNV) {
        String sql = "DELETE FROM nhanvien WHERE manv = ?";
        try (Connection conn = connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maNV);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Search employees by keyword (searches in manv, tennv, email)
    public List<NhanVien> timKiem(String keyword) {
        List<NhanVien> result = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien WHERE manv LIKE ? OR tennv LIKE ? OR email LIKE ?";
        try (Connection conn = connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            String searchTerm = "%" + keyword + "%";
            ps.setString(1, searchTerm);
            ps.setString(2, searchTerm);
            ps.setString(3, searchTerm);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("manv"));
                nv.setTenNV(rs.getString("tennv"));
                nv.setNgaySinh(rs.getDate("ngaysinh"));
                nv.setDiaChi(rs.getString("diachi"));
                nv.setNgayLamViec(rs.getTimestamp("ngaylamviec"));
                nv.setEmail(rs.getString("email"));
                nv.setLuong(rs.getDouble("luong"));
                nv.setSoDienThoai(rs.getString("sodienthoai"));
                nv.setChucVu(rs.getString("chucvu"));
                result.add(nv);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Load all employees
    public List<NhanVien> getAll() {
        List<NhanVien> result = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien";
        try (Connection conn = connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("manv"));
                nv.setTenNV(rs.getString("tennv"));
                nv.setNgaySinh(rs.getDate("ngaysinh"));
                nv.setDiaChi(rs.getString("diachi"));
                nv.setNgayLamViec(rs.getTimestamp("ngaylamviec"));
                nv.setEmail(rs.getString("email"));
                nv.setLuong(rs.getDouble("luong"));
                nv.setSoDienThoai(rs.getString("sodienthoai"));
                nv.setChucVu(rs.getString("chucvu"));
                result.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}