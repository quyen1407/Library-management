
package controller;

import java.util.List;
import model.MuonTra;
import model.modelMuonTra;

public class muonTraController {
    private modelMuonTra model;

    public muonTraController() {
        model = new modelMuonTra();
    }

    public List<MuonTra> handleLoadAll() {
        return model.getAll();
    }

    public boolean handleAdd(MuonTra mt) {
        return model.them(mt);
    }

    public boolean handleUpdate(MuonTra mt) {
        return model.capNhat(mt);
    }

    public boolean handleDelete(String maPhieuMuon) {
        return model.xoa(maPhieuMuon);
    }

    public List<MuonTra> handleSearch(String keyword) {
        return model.timKiem(keyword);
    }
}
