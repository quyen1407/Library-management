package controller;

import model.modeladmin;

public class admincontroller {
    private static modeladmin modeladmin = new modeladmin(); // tránh đặt trùng tên với class

    public admincontroller() {
    	modeladmin = new modeladmin();
    }

    // Hàm xử lý đăng nhập với email và password
    public static boolean handleLoginadmin(String email, String password) {
        return modeladmin.adminlogin(email, password);
    }
}
