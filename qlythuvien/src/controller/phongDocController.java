package controller;

import java.util.List;
import model.Phongdoc;
import model.modelPhongDoc;

public class phongDocController {
    private static modelPhongDoc model = new modelPhongDoc();

    public static boolean handleAdd(Phongdoc p) {
        return model.them(p);
    }

    public static boolean handleUpdate(Phongdoc p) {
        return model.capNhat(p);
    }

    public static boolean handleDelete(String maPhongDoc) {
        return model.xoa(maPhongDoc);
    }

    public static List<Phongdoc> handleSearch(String keyword) {
        return model.timKiem(keyword);
    }

    public static List<Phongdoc> handleLoadAll() {
        return model.getAll();
    }
}
