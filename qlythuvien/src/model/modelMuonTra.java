
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class modelMuonTra {
    private Connection conn;

    public modelMuonTra() {
        try {
            conn = connect.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MuonTra> getAll() {
        List<MuonTra> list = new ArrayList<>();
        String sql = "SELECT * FROM muontra";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                MuonTra mt = new MuonTra();
                mt.setMaPhieuMuon(rs.getString("maphieumuon"));
                mt.setMaDocGia(rs.getString("madocgia"));
                mt.setMaSach(rs.getString("masach"));
                mt.setTenSach(rs.getString("tensach"));
                mt.setSoLuong(rs.getInt("soluong"));
                mt.setGiaTien(rs.getDouble("giatien"));
                mt.setNgayMuon(rs.getTimestamp("ngaymuon"));
                mt.setNgayDuKienTra(rs.getTimestamp("ngaydukientra"));
                mt.setNgayTraSach(rs.getTimestamp("ngaytrasach"));
                mt.setTrangThai(rs.getString("trangthai"));
                mt.setGhiChu(rs.getString("ghichu"));
                list.add(mt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean them(MuonTra mt) {
        String sql = "INSERT INTO muontra (maphieumuon, madocgia, masach, tensach, soluong, giatien, ngaymuon, ngaydukientra, ngaytrasach, trangthai, ghichu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, mt.getMaPhieuMuon());
            ps.setString(2, mt.getMaDocGia());
            ps.setString(3, mt.getMaSach());
            ps.setString(4, mt.getTenSach());
            ps.setInt(5, mt.getSoLuong());
            ps.setDouble(6, mt.getGiaTien());
            ps.setTimestamp(7, mt.getNgayMuon() != null ? new java.sql.Timestamp(mt.getNgayMuon().getTime()) : null);
            ps.setTimestamp(8, mt.getNgayDuKienTra() != null ? new java.sql.Timestamp(mt.getNgayDuKienTra().getTime()) : null);
            ps.setTimestamp(9, mt.getNgayTraSach() != null ? new java.sql.Timestamp(mt.getNgayTraSach().getTime()) : null);
            ps.setString(10, mt.getTrangThai());
            ps.setString(11, mt.getGhiChu());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean capNhat(MuonTra mt) {
        String sql = "UPDATE muontra SET madocgia = ?, masach = ?, tensach = ?, soluong = ?, giatien = ?, ngaymuon = ?, ngaydukientra = ?, ngaytrasach = ?, trangthai = ?, ghichu = ? WHERE maphieumuon = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, mt.getMaDocGia());
            ps.setString(2, mt.getMaSach());
            ps.setString(3, mt.getTenSach());
            ps.setInt(4, mt.getSoLuong());
            ps.setDouble(5, mt.getGiaTien());
            ps.setTimestamp(6, mt.getNgayMuon() != null ? new java.sql.Timestamp(mt.getNgayMuon().getTime()) : null);
            ps.setTimestamp(7, mt.getNgayDuKienTra() != null ? new java.sql.Timestamp(mt.getNgayDuKienTra().getTime()) : null);
            ps.setTimestamp(8, mt.getNgayTraSach() != null ? new java.sql.Timestamp(mt.getNgayTraSach().getTime()) : null);
            ps.setString(9, mt.getTrangThai());
            ps.setString(10, mt.getGhiChu());
            ps.setString(11, mt.getMaPhieuMuon());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean xoa(String maPhieuMuon) {
        String sql = "DELETE FROM muontra WHERE maphieumuon = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maPhieuMuon);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<MuonTra> timKiem(String keyword) {
        List<MuonTra> list = new ArrayList<>();
        String sql = "SELECT * FROM muontra WHERE maphieumuon LIKE ? OR madocgia LIKE ? OR masach LIKE ? OR tensach LIKE ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            String searchPattern = "%" + keyword + "%";
            ps.setString(1, searchPattern);
            ps.setString(2, searchPattern);
            ps.setString(3, searchPattern);
            ps.setString(4, searchPattern);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    MuonTra mt = new MuonTra();
                    mt.setMaPhieuMuon(rs.getString("maphieumuon"));
                    mt.setMaDocGia(rs.getString("madocgia"));
                    mt.setMaSach(rs.getString("masach"));
                    mt.setTenSach(rs.getString("tensach"));
                    mt.setSoLuong(rs.getInt("soluong"));
                    mt.setGiaTien(rs.getDouble("giatien"));
                    mt.setNgayMuon(rs.getTimestamp("ngaymuon"));
                    mt.setNgayDuKienTra(rs.getTimestamp("ngaydukientra"));
                    mt.setNgayTraSach(rs.getTimestamp("ngaytrasach"));
                    mt.setTrangThai(rs.getString("trangthai"));
                    mt.setGhiChu(rs.getString("ghichu"));
                    list.add(mt);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
