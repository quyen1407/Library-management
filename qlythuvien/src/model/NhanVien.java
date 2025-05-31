package model;

import java.util.Date;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private Date ngaySinh;
    private String diaChi;
    private Date ngayLamViec;
    private String email;
    private double luong;
    private String soDienThoai;
    private String chucVu;

    // Default constructor
    public NhanVien() {
    }

    // Full constructor
    public NhanVien(String maNV, String tenNV, Date ngaySinh, String diaChi, Date ngayLamViec, 
                    String email, double luong, String soDienThoai, String chucVu) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.ngayLamViec = ngayLamViec;
        this.email = email;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.chucVu = chucVu;
    }

    // Getters and Setters
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayLamViec() {
        return ngayLamViec;
    }

    public void setNgayLamViec(Date ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
}