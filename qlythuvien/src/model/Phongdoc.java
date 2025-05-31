package model;

public class Phongdoc {
    private String maPhongDoc;
    private String phong;
    private String tang;
    private String trangThai;
    private int soLuongNguoi;
    private String loaiPhong;

    public Phongdoc(String maPhongDoc, String phong, String tang, String trangThai, int soLuongNguoi, String loaiPhong) {
        this.maPhongDoc = maPhongDoc;
        this.phong = phong;
        this.tang = tang;
        this.trangThai = trangThai;
        this.soLuongNguoi = soLuongNguoi;
        this.loaiPhong = loaiPhong;
    }

    // Getters
    public String getMaPhongDoc() {
        return maPhongDoc;
    }

    public String getPhong() {
        return phong;
    }

    public String getTang() {
        return tang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public int getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    // Setters
    public void setMaPhongDoc(String maPhongDoc) {
        this.maPhongDoc = maPhongDoc;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public void setTang(String tang) {
        this.tang = tang;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setSoLuongNguoi(int soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }
}
