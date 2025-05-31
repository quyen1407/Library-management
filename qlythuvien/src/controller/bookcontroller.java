package controller;

import java.util.List;
import model.Book;
import model.modelbook;

public class bookcontroller {
    private static modelbook modelbook = new modelbook();

    public static boolean handleAdd(Book b) {
        return modelbook.them(b);
    }

    public static boolean handleUpdate(Book b) {
        return modelbook.capNhat(b);
    }

    public static boolean handleDelete(String maSach) {
        return modelbook.xoa(maSach);
    }

    public static List<Book> handleSearch(String keyword) {
        return modelbook.timKiem(keyword);
    }

    public static List<Book> handleLoadAll() {
        return modelbook.getAll();
    }

	public boolean them(java.awt.print.Book b) {
		// TODO Auto-generated method stub
		return false;
	}
}
