package controller;

import model.DocGia;
import model.modelDocGia;
import java.util.List;

public class docGiaController {
    private modelDocGia model;

    public docGiaController() {
        model = new modelDocGia();
    }

    public List<DocGia> handleLoadAll() {
        return model.getAll();
    }

    public boolean handleAdd(DocGia dg) {
        return model.them(dg);
    }

    public boolean handleUpdate(DocGia dg) {
        return model.capNhat(dg);
    }

    public boolean handleDelete(String maDocGia) {
        return model.xoa(maDocGia);
    }

    public List<DocGia> handleSearch(String keyword) {
        return model.timKiem(keyword);
    }
}