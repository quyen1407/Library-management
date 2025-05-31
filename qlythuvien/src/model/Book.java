package model;

import java.util.Date;

public class Book {
    private String maSach;
    private String tenSach;
    private String theLoai;
    private int soLuong;
    private Date ngayXuatBan;
    private String nhaXuatBan;
    private String tacGia;
    private double giaTien;
    private String viTri;

    public Book(String maSach, String tenSach, String theLoai, int soLuong, Date ngayXuatBan,
                String nhaXuatBan, String tacGia, double giaTien, String viTri) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.soLuong = soLuong;
        this.ngayXuatBan = ngayXuatBan;
        this.nhaXuatBan = nhaXuatBan;
        this.tacGia = tacGia;
        this.giaTien = giaTien;
        this.viTri = viTri;
    }

    // Getters
    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public Date getNgayXuatBan() {
        return ngayXuatBan;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public String getTacGia() {
        return tacGia;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public String getViTri() {
        return viTri;
    }

    // Setters
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setNgayXuatBan(Date ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
}
