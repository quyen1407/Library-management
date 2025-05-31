package model;

import java.util.Date;

public class DocGia {
    private String maDocGia;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String email;
    private String soDienThoai;
    private Date ngayLamThe;
    private Date ngayHetHan;

    // Constructor
    public DocGia(String maDocGia, String hoTen, String gioiTinh, Date ngaySinh, String diaChi, 
                  String email, String soDienThoai, Date ngayLamThe, Date ngayHetHan) {
        this.maDocGia = maDocGia;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.ngayLamThe = ngayLamThe;
        this.ngayHetHan = ngayHetHan;
    }

    // Default constructor
    public DocGia() {}

    
    public String getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgayLamThe() {
        return ngayLamThe;
    }

    public void setNgayLamThe(Date ngayLamThe) {
        this.ngayLamThe = ngayLamThe;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }
}