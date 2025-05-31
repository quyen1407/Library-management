package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class modelbook {
    public boolean them(Book book) {
        String sql = "INSERT INTO sach(masach, tensach, theloai, soluong, ngayxuatban, nhaxuatban, tacgia, giatien, vitri) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        // Kiểm tra giá trị ngayXuatBan trước khi lưu
      //.out.println("Trước khi lưu vào CSDL: " + new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(book.getNgayXuatBan()));
        
        try (Connection conn = connect.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, book.getMaSach());
            ps.setString(2, book.getTenSach());
            ps.setString(3, book.getTheLoai());
            ps.setInt(4, book.getSoLuong());
            // Chuyển Date thành Timestamp để lưu cả ngày và giờ
            ps.setTimestamp(5, new java.sql.Timestamp(book.getNgayXuatBan().getTime()));
            ps.setString(6, book.getNhaXuatBan());
            ps.setString(7, book.getTacGia());
            ps.setDouble(8, book.getGiaTien());
            ps.setString(9, book.getViTri());
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
           //     System.out.println("Thêm sách thành công: " + book.getMaSach());
                return true;
            } else {
           //     System.out.println("Không có bản ghi nào được thêm.");
                return false;
            }
        } catch (SQLException e) {
          //  System.out.println("Lỗi thêm sách: " + e.getMessage());
            e.printStackTrace(); // In stack trace để dễ debug
            return false;
        }
    }

    public boolean capNhat(Book book) {
        String sql = "UPDATE sach SET tensach=?, theloai=?, soluong=?, ngayxuatban=?, nhaxuatban=?, tacgia=?, giatien=?, vitri=? WHERE masach=?";

        // Kiểm tra giá trị ngayXuatBan trước khi cập nhật
      //  System.out.println("Trước khi cập nhật vào CSDL: " + new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(book.getNgayXuatBan()));
        
        try (Connection conn = connect.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, book.getTenSach());
            ps.setString(2, book.getTheLoai());
            ps.setInt(3, book.getSoLuong());
            // Sử dụng Timestamp để lưu cả ngày và giờ
            ps.setTimestamp(4, new java.sql.Timestamp(book.getNgayXuatBan().getTime()));
            ps.setString(5, book.getNhaXuatBan());
            ps.setString(6, book.getTacGia());
            ps.setDouble(7, book.getGiaTien());
            ps.setString(8, book.getViTri());
            ps.setString(9, book.getMaSach());
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
//                System.out.println("Cập nhật sách thành công: " + book.getMaSach());
                return true;
            } else {
//                System.out.println("Không có bản ghi nào được cập nhật.");
                return false;
            }
        } catch (SQLException e) {
//            System.out.println("Lỗi cập nhật sách: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean xoa(String maSach) {
        String sql = "DELETE FROM sach WHERE masach = ?";

        try (Connection conn = connect.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maSach);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
//                System.out.println("Xóa sách thành công: " + maSach);
                return true;
            } else {
//                System.out.println("Không có bản ghi nào được xóa.");
                return false;
            }
        } catch (SQLException e) {
//            System.out.println("Lỗi xóa sách: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Book> timKiem(String keyword) {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM sach WHERE masach LIKE ? OR tensach LIKE ? OR theloai LIKE ? OR CAST(soluong AS CHAR) LIKE ? OR DATE_FORMAT(ngayxuatban, '%d/%m/%Y %H:%i') LIKE ? OR nhaxuatban LIKE ? OR tacgia LIKE ? OR CAST(giatien AS CHAR) LIKE ? OR vitri LIKE ?";

        try (Connection conn = connect.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            // Gán giá trị keyword cho tất cả các tham số trong câu truy vấn
            for (int i = 1; i <= 9; i++) {
                ps.setString(i, "%" + keyword + "%");
            }
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Lấy giá trị ngày và giờ từ cột ngayxuatban
                java.sql.Timestamp timestamp = rs.getTimestamp("ngayxuatban");
                Date ngayXuatBan = (timestamp != null) ? new Date(timestamp.getTime()) : new Date(0);

                list.add(new Book(
                    rs.getString("masach"),
                    rs.getString("tensach"),
                    rs.getString("theloai"),
                    rs.getInt("soluong"),
                    ngayXuatBan, // Truyền Date với cả ngày và giờ
                    rs.getString("nhaxuatban"),
                    rs.getString("tacgia"),
                    rs.getDouble("giatien"),
                    rs.getString("vitri")
                ));

                // Log để kiểm tra giá trị ngayXuatBan
//                System.out.println("Ngày xuất bản từ tìm kiếm: " + new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(ngayXuatBan));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi tìm kiếm sách: " + e.getMessage());
            e.printStackTrace();
        }

        return list;
    }

    public List<Book> getAll() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM sach";

        try (Connection conn = connect.getConnection(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // Lấy giá trị ngày và giờ từ cột ngayxuatban
                java.sql.Timestamp timestamp = rs.getTimestamp("ngayxuatban");
                Date ngayXuatBan = (timestamp != null) ? new Date(timestamp.getTime()) : new Date(0);

                list.add(new Book(
                    rs.getString("masach"),
                    rs.getString("tensach"),
                    rs.getString("theloai"),
                    rs.getInt("soluong"),
                    ngayXuatBan, // Truyền Date với cả ngày và giờ
                    rs.getString("nhaxuatban"),
                    rs.getString("tacgia"),
                    rs.getDouble("giatien"),
                    rs.getString("vitri")
                ));

                // Log để kiểm tra giá trị ngayXuatBan
                //System.out.println("Ngày xuất bản từ CSDL: " + new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(ngayXuatBan));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi lấy tất cả sách: " + e.getMessage());
            e.printStackTrace();
        }

        return list;
    }
}