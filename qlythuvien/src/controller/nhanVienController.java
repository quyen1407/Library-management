package controller;

import model.NhanVien;
import model.modelNhanVien;
import java.util.List;

public class nhanVienController {
    private modelNhanVien model;

    public nhanVienController() {
        model = new modelNhanVien();
    }

    public boolean handleAdd(NhanVien nv) {
        return model.them(nv);
    }

    public boolean handleUpdate(NhanVien nv) {
        return model.capNhat(nv);
    }

    public boolean handleDelete(String maNV) {
        return model.xoa(maNV);
    }

    public List<NhanVien> handleSearch(String keyword) {
        return model.timKiem(keyword);
    }

    public List<NhanVien> handleLoadAll() {
        return model.getAll();
    }
}