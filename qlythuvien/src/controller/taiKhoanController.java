package controller;

import model.Taikhoan;
import model.modelTaiKhoan;
import java.util.List;

public class taiKhoanController {
    private static modelTaiKhoan model = new modelTaiKhoan();

    public static boolean handleAdd(Taikhoan tk) {
        return model.them(tk);
    }

    public static boolean handleUpdate(Taikhoan tk) {
        return model.capNhat(tk);
    }

    public static boolean handleDelete(int id) {
        return model.xoa(id);
    }

    public static List<Taikhoan> handleSearch(String keyword) {
        return model.timKiem(keyword);
    }

    public static List<Taikhoan> handleLoadAll() {
        return model.getAll();
    }
 // New method to reset auto-increment
    public static void handleResetAutoIncrement() {
        model.resetAutoIncrement();
    }
}