
package model;

import java.util.Date;

public class MuonTra {
    private String maPhieuMuon;
    private String maDocGia;
    private String maSach;
    private String tenSach;
    private int soLuong;
    private double giaTien;
    private Date ngayMuon;
    private Date ngayDuKienTra;
    private Date ngayTraSach;
    private String trangThai;
    private String ghiChu;

    // Constructor
    public MuonTra() {}

    // Getters and Setters
    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayDuKienTra() {
        return ngayDuKienTra;
    }

    public void setNgayDuKienTra(Date ngayDuKienTra) {
        this.ngayDuKienTra = ngayDuKienTra;
    }

    public Date getNgayTraSach() {
        return ngayTraSach;
    }

    public void setNgayTraSach(Date ngayTraSach) {
        this.ngayTraSach = ngayTraSach;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
