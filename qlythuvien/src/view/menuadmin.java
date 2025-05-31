package view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class menuadmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lbloaddulieusach;
    private JLabel lbloaddulieusach_1;
    private JLabel lbloaddulieusach_2;
    private JLabel lbloaddulieusach_3;
    private JLabel lbloaddulieusach_4;
    private CustomChartPanel chartPanel; // Sử dụng lớp tùy chỉnh để vẽ biểu đồ

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                menuadmin frame = new menuadmin();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public menuadmin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1113, 716);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(147, 112, 219));
        panel.setBounds(0, 0, 1097, 48);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\icons8_menu_48px_1.png"));
        lblNewLabel.setBounds(10, 5, 40, 38);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(55, 9, 4, 32);
        panel.add(panel_1);
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Quản Lý Thư Viện");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(80, 5, 135, 38);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(886, 9, 44, 34);
        panel.add(lblNewLabel_2);

        ImageIcon originalIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\male_user_50px.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(46, 34, Image.SCALE_SMOOTH);
        lblNewLabel_2.setIcon(new ImageIcon(scaledImage));

        JLabel lblNewLabel_3 = new JLabel("Chào Mừng, Admin");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_3.setBounds(939, 13, 135, 30);
        panel.add(lblNewLabel_3);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(203, 192, 255));
        panel_2.setBounds(0, 48, 203, 633);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(224, 255, 255));
        panel_3.setBounds(0, 11, 203, 37);
        panel_2.add(panel_3);
        panel_3.setLayout(null);

        JLabel lblNewLabel_4 = new JLabel("   Trang Chủ ");
        ImageIcon trangchu = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\house.png");
        Image trangchuu = trangchu.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        lblNewLabel_4.setIcon(new ImageIcon(trangchuu));
        lblNewLabel_4.setForeground(new Color(0, 0, 0));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4.setBackground(Color.RED);
        lblNewLabel_4.setBounds(32, 0, 150, 37);
        panel_3.add(lblNewLabel_4);

        JPanel panel_3_2 = new JPanel();
        panel_3_2.setLayout(null);
        panel_3_2.setBackground(new Color(203, 192, 255));
        panel_3_2.setBounds(0, 49, 203, 37);
        panel_2.add(panel_3_2);

        JLabel lblNewLabel_4_1 = new JLabel("Bảng Thông Tin");
        ImageIcon thongtin = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\signboard.png");
        Image thongtinn = thongtin.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        lblNewLabel_4_1.setIcon(new ImageIcon(thongtinn));
        lblNewLabel_4_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4_1.setBackground(Color.RED);
        lblNewLabel_4_1.setBounds(32, 0, 150, 37);
        panel_3_2.add(lblNewLabel_4_1);

        JLabel lblNewLabel_5 = new JLabel("Đặc Trưng");
        lblNewLabel_5.setBounds(23, 97, 77, 19);
        panel_2.add(lblNewLabel_5);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setForeground(new Color(0, 0, 0));

        JPanel panel_3_2_1 = new JPanel();
        panel_3_2_1.setLayout(null);
        panel_3_2_1.setBackground(new Color(203, 192, 255));
        panel_3_2_1.setBounds(0, 123, 203, 37);
        panel_2.add(panel_3_2_1);
        panel_3_2_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    quanlysach quanlysach = new quanlysach();
                    quanlysach.setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Không thể mở quanlysach: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel lblNewLabel_4_1_1 = new JLabel("Sách");
        ImageIcon sach = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\stack-of-books.png");
        Image sachh = sach.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        lblNewLabel_4_1_1.setIcon(new ImageIcon(sachh));
        lblNewLabel_4_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4_1_1.setBackground(Color.RED);
        lblNewLabel_4_1_1.setBounds(32, 0, 150, 37);
        panel_3_2_1.add(lblNewLabel_4_1_1);

        JPanel panel_3_2_1_1 = new JPanel();
        panel_3_2_1_1.setLayout(null);
        panel_3_2_1_1.setBackground(new Color(203, 192, 255));
        panel_3_2_1_1.setBounds(0, 171, 203, 37);
        panel_2.add(panel_3_2_1_1);
        panel_3_2_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    quanlyphongdoc quanlyphong = new quanlyphongdoc();
                    quanlyphong.setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Không thể mở quanlyphongdoc: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel lblNewLabel_4_1_1_1 = new JLabel("Phòng Đọc");
        ImageIcon originalIconReading = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\phongdoc.png");
        Image scaledReadingImage = originalIconReading.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        lblNewLabel_4_1_1_1.setIcon(new ImageIcon(scaledReadingImage));
        lblNewLabel_4_1_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4_1_1_1.setBackground(Color.RED);
        lblNewLabel_4_1_1_1.setBounds(32, 0, 150, 37);
        panel_3_2_1_1.add(lblNewLabel_4_1_1_1);

        JPanel panel_3_2_1_1_1 = new JPanel();
        panel_3_2_1_1_1.setLayout(null);
        panel_3_2_1_1_1.setBackground(new Color(203, 192, 255));
        panel_3_2_1_1_1.setBounds(0, 219, 203, 37);
        panel_2.add(panel_3_2_1_1_1);
        panel_3_2_1_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    quanlydocgia docgia = new quanlydocgia();
                    docgia.setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Không thể mở quanlydocgia: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Độc Giả");
        ImageIcon docgia = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\reading.png");
        Image docgiaa = docgia.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        lblNewLabel_4_1_1_1_1.setIcon(new ImageIcon(docgiaa));
        lblNewLabel_4_1_1_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_4_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4_1_1_1_1.setBackground(Color.RED);
        lblNewLabel_4_1_1_1_1.setBounds(32, 0, 150, 37);
        panel_3_2_1_1_1.add(lblNewLabel_4_1_1_1_1);

        JPanel panel_3_2_1_1_1_1 = new JPanel();
        panel_3_2_1_1_1_1.setLayout(null);
        panel_3_2_1_1_1_1.setBackground(new Color(203, 192, 255));
        panel_3_2_1_1_1_1.setBounds(0, 267, 203, 37);
        panel_2.add(panel_3_2_1_1_1_1);
        panel_3_2_1_1_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    quanlymuontra muontra = new quanlymuontra();
                    muontra.setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Không thể mở quanlymuontra: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Mượn Trả");
        ImageIcon muontra = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\muontra.png");
        Image muontraa = muontra.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        lblNewLabel_4_1_1_1_1_1.setIcon(new ImageIcon(muontraa));
        lblNewLabel_4_1_1_1_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_4_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4_1_1_1_1_1.setBackground(Color.RED);
        lblNewLabel_4_1_1_1_1_1.setBounds(32, 0, 150, 37);
        panel_3_2_1_1_1_1.add(lblNewLabel_4_1_1_1_1_1);

        JPanel panel_3_2_1_1_1_1_1 = new JPanel();
        panel_3_2_1_1_1_1_1.setLayout(null);
        panel_3_2_1_1_1_1_1.setBackground(new Color(203, 192, 255));
        panel_3_2_1_1_1_1_1.setBounds(0, 315, 203, 37);
        panel_2.add(panel_3_2_1_1_1_1_1);
        panel_3_2_1_1_1_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    quanlynhanvien nv = new quanlynhanvien();
                    nv.setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Không thể mở quanlynhanvien: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("Nhân Viên");
        ImageIcon nhanvien = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\staff.png");
        Image nhanvienn = nhanvien.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        lblNewLabel_4_1_1_1_1_1_1.setIcon(new ImageIcon(nhanvienn));
        lblNewLabel_4_1_1_1_1_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_4_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4_1_1_1_1_1_1.setBackground(Color.RED);
        lblNewLabel_4_1_1_1_1_1_1.setBounds(32, 0, 150, 37);
        panel_3_2_1_1_1_1_1.add(lblNewLabel_4_1_1_1_1_1_1);

        JPanel panel_3_2_1_1_1_1_2 = new JPanel();
        panel_3_2_1_1_1_1_2.setLayout(null);
        panel_3_2_1_1_1_1_2.setBackground(new Color(203, 192, 255));
        panel_3_2_1_1_1_1_2.setBounds(0, 363, 203, 37);
        panel_2.add(panel_3_2_1_1_1_1_2);
        panel_3_2_1_1_1_1_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    quanlytaikhoan tk = new quanlytaikhoan();
                    tk.setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Không thể mở quanlytaikhoan: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel lblNewLabel_4_1_1_1_1_1_2 = new JLabel("Tài Khoản");
        ImageIcon tk = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\account.png");
        Image tkk = tk.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        lblNewLabel_4_1_1_1_1_1_2.setIcon(new ImageIcon(tkk));
        lblNewLabel_4_1_1_1_1_1_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_4_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4_1_1_1_1_1_2.setBackground(Color.RED);
        lblNewLabel_4_1_1_1_1_1_2.setBounds(32, 0, 150, 37);
        panel_3_2_1_1_1_1_2.add(lblNewLabel_4_1_1_1_1_1_2);

        JPanel panel_3_2_1_1_1_1_3 = new JPanel();
        panel_3_2_1_1_1_1_3.setLayout(null);
        panel_3_2_1_1_1_1_3.setBackground(new Color(203, 192, 255));
        panel_3_2_1_1_1_1_3.setBounds(0, 411, 203, 37);
        panel_2.add(panel_3_2_1_1_1_1_3);
        panel_3_2_1_1_1_1_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    welcome wl = new welcome();
                    wl.setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Không thể mở welcome: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel lblNewLabel_4_1_1_1_1_1_3 = new JLabel("Đăng Xuất");
        ImageIcon danguat = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\logout.png");
        Image dangxuatt = danguat.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        lblNewLabel_4_1_1_1_1_1_3.setIcon(new ImageIcon(dangxuatt));
        lblNewLabel_4_1_1_1_1_1_3.setForeground(new Color(0, 0, 0));
        lblNewLabel_4_1_1_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4_1_1_1_1_1_3.setBackground(Color.RED);
        lblNewLabel_4_1_1_1_1_1_3.setBounds(32, 0, 150, 37);
        panel_3_2_1_1_1_1_3.add(lblNewLabel_4_1_1_1_1_1_3);

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new MatteBorder(12, 0, 0, 0, (Color) new Color(255, 0, 0)));
        panel_4.setBounds(238, 104, 189, 104);
        contentPane.add(panel_4);
        panel_4.setLayout(null);

        lbloaddulieusach = new JLabel("");
        lbloaddulieusach.setIcon(new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\icons8_Book_Shelf_50px.png"));
        lbloaddulieusach.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbloaddulieusach.setBounds(45, 29, 97, 64);
        panel_4.add(lbloaddulieusach);

        JLabel lblNewLabel_6 = new JLabel("SÁCH");
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\icons8_Book_26px.png"));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_6.setBounds(284, 71, 80, 27);
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel_6_1 = new JLabel("ĐỘC GIẢ");
        lblNewLabel_6_1.setIcon(new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\icons8_Read_Online_26px.png"));
        lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_6_1.setBounds(586, 71, 135, 27);
        contentPane.add(lblNewLabel_6_1);

        JPanel panel_4_1 = new JPanel();
        panel_4_1.setLayout(null);
        panel_4_1.setBorder(new MatteBorder(12, 0, 0, 0, (Color) new Color(255, 0, 0)));
        panel_4_1.setBounds(551, 104, 189, 104);
        contentPane.add(panel_4_1);

        lbloaddulieusach_1 = new JLabel("");
        lbloaddulieusach_1.setIcon(new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\icons8_Conference_26px.png"));
        lbloaddulieusach_1.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbloaddulieusach_1.setBounds(45, 29, 97, 64);
        panel_4_1.add(lbloaddulieusach_1);

        JLabel lblNewLabel_6_2 = new JLabel("PHÒNG ĐỌC ");
        lblNewLabel_6_2.setIcon(new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\icons8_Library_26px_1.png"));
        lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_6_2.setBounds(886, 71, 141, 27);
        contentPane.add(lblNewLabel_6_2);

        JPanel panel_4_2 = new JPanel();
        panel_4_2.setLayout(null);
        panel_4_2.setBorder(new MatteBorder(12, 0, 0, 0, (Color) new Color(255, 0, 0)));
        panel_4_2.setBounds(859, 104, 189, 104);
        contentPane.add(panel_4_2);

        lbloaddulieusach_2 = new JLabel("");
        lbloaddulieusach_2.setIcon(new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\icons8_List_of_Thumbnails_50px.png"));
        lbloaddulieusach_2.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbloaddulieusach_2.setBounds(45, 29, 97, 64);
        panel_4_2.add(lbloaddulieusach_2);

        JPanel panel_4_3 = new JPanel();
        panel_4_3.setLayout(null);
        panel_4_3.setBorder(new MatteBorder(12, 0, 0, 0, (Color) new Color(255, 0, 0)));
        panel_4_3.setBounds(320, 306, 189, 104);
        contentPane.add(panel_4_3);

        lbloaddulieusach_3 = new JLabel("");
        lbloaddulieusach_3.setIcon(new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\icons8_Book_26px.png"));
        lbloaddulieusach_3.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbloaddulieusach_3.setBounds(45, 29, 97, 64);
        panel_4_3.add(lbloaddulieusach_3);

        JLabel lblNewLabel_6_3 = new JLabel("SỐ SÁCH ĐÃ MƯỢN");
        lblNewLabel_6_3.setIcon(new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\icons8_Book_26px.png"));
        lblNewLabel_6_3.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_6_3.setBounds(319, 268, 190, 27);
        contentPane.add(lblNewLabel_6_3);

        JPanel panel_4_4 = new JPanel();
        panel_4_4.setLayout(null);
        panel_4_4.setBorder(new MatteBorder(12, 0, 0, 0, (Color) new Color(255, 0, 0)));
        panel_4_4.setBounds(320, 513, 189, 104);
        contentPane.add(panel_4_4);

        lbloaddulieusach_4 = new JLabel("");
        lbloaddulieusach_4.setIcon(new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\icons8_Sell_26px.png"));
        lbloaddulieusach_4.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbloaddulieusach_4.setBounds(45, 29, 97, 64);
        panel_4_4.add(lbloaddulieusach_4);

        JLabel lblNewLabel_6_4 = new JLabel("SỐ SÁCH ĐÃ TRẢ");
        lblNewLabel_6_4.setIcon(new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\icons8_Sell_50px.png"));
        lblNewLabel_6_4.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_6_4.setBounds(306, 484, 214, 27);
        contentPane.add(lblNewLabel_6_4);

        // Thêm panel biểu đồ tùy chỉnh
        chartPanel = new CustomChartPanel();
        chartPanel.setBackground(new Color(255, 255, 255));
        chartPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        chartPanel.setBounds(624, 268, 414, 358);
        contentPane.add(chartPanel);

        // Tải dữ liệu và cập nhật biểu đồ
        loadBookCountFromDatabase();
    }

    // Lớp tùy chỉnh để vẽ biểu đồ
    private class CustomChartPanel extends JPanel {
        private int[] data = new int[5]; // Lưu trữ dữ liệu: [sách, độc giả, phòng đọc, sách đã mượn, sách đã trả]
        private String[] categories = {"Sách", "Độc Giả", "Phòng Đọc", "Sách Đã Mượn", "Sách Đã Trả"};

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();
            int barWidth = width / categories.length / 2; // Chiều rộng của mỗi thanh
            int maxValue = getMaxValue(); // Giá trị lớn nhất để tính tỷ lệ
            int padding = 20;

            // Vẽ nhãn trục X
            g2d.setFont(new Font("Arial", Font.PLAIN, 12));
            for (int i = 0; i < categories.length; i++) {
                int x = i * (width / categories.length) + barWidth / 2;
                g2d.drawString(categories[i], x - g2d.getFontMetrics().stringWidth(categories[i]) / 2, height - 5);
            }

            // Vẽ các thanh
            for (int i = 0; i < data.length; i++) {
                int barHeight = (int) ((data[i] * 1.0 / maxValue) * (height - padding * 2));
                int x = i * (width / data.length) + barWidth / 2;
                int y = height - padding - barHeight;
                g2d.setColor(getColor(i));
                g2d.fillRect(x, y, barWidth, barHeight);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, y, barWidth, barHeight); // Viền thanh
            }

            // Vẽ nhãn giá trị trên mỗi thanh
            g2d.setColor(Color.BLACK);
            for (int i = 0; i < data.length; i++) {
                int x = i * (width / data.length) + barWidth / 2;
                int y = height - padding - (int) ((data[i] * 1.0 / maxValue) * (height - padding * 2)) - 5;
                g2d.drawString(String.valueOf(data[i]), x - g2d.getFontMetrics().stringWidth(String.valueOf(data[i])) / 2, y);
            }
        }

        private int getMaxValue() {
            int max = 0;
            for (int value : data) {
                if (value > max) max = value;
            }
            return max > 0 ? max : 1; // Tránh chia cho 0
        }

        private Color getColor(int index) {
            switch (index) {
                case 0: return new Color(255, 99, 132);  // Sách
                case 1: return new Color(54, 162, 235);  // Độc Giả
                case 2: return new Color(255, 206, 86);  // Phòng Đọc
                case 3: return new Color(75, 192, 192);  // Sách Đã Mượn
                case 4: return new Color(153, 102, 255); // Sách Đã Trả
                default: return Color.GRAY;
            }
        }

        public void updateData(int[] newData) {
            System.arraycopy(newData, 0, data, 0, Math.min(newData.length, data.length));
            repaint(); // Cập nhật lại biểu đồ
        }
    }

    private void loadBookCountFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/qlythuvien";
        String username = "root";
        String password = "2004";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            String query = "SELECT COUNT(*) FROM sach";
            resultSet = statement.executeQuery(query);
            int bookCount = 0;
            if (resultSet.next()) {
                bookCount = resultSet.getInt(1);
                lbloaddulieusach.setText(String.valueOf(bookCount));
            } else {
                lbloaddulieusach.setText("0");
            }

            query = "SELECT COUNT(*) FROM docgia";
            resultSet = statement.executeQuery(query);
            int readerCount = 0;
            if (resultSet.next()) {
                readerCount = resultSet.getInt(1);
                lbloaddulieusach_1.setText(String.valueOf(readerCount));
            } else {
                lbloaddulieusach_1.setText("0");
            }

            query = "SELECT COUNT(*) FROM phongdoc";
            resultSet = statement.executeQuery(query);
            int roomCount = 0;
            if (resultSet.next()) {
                roomCount = resultSet.getInt(1);
                lbloaddulieusach_2.setText(String.valueOf(roomCount));
            } else {
                lbloaddulieusach_2.setText("0");
            }

            query = "SELECT COUNT(*) FROM muontra WHERE trangthai = 'Đang mượn'";
            resultSet = statement.executeQuery(query);
            int borrowedCount = 0;
            if (resultSet.next()) {
                borrowedCount = resultSet.getInt(1);
                lbloaddulieusach_3.setText(String.valueOf(borrowedCount));
            } else {
                lbloaddulieusach_3.setText("0");
            }

            query = "SELECT COUNT(*) FROM muontra WHERE trangthai = 'Đã trả'";
            resultSet = statement.executeQuery(query);
            int returnedCount = 0;
            if (resultSet.next()) {
                returnedCount = resultSet.getInt(1);
                lbloaddulieusach_4.setText(String.valueOf(returnedCount));
            } else {
                lbloaddulieusach_4.setText("0");
            }

            // Cập nhật dữ liệu cho biểu đồ
            int[] data = {bookCount, readerCount, roomCount, borrowedCount, returnedCount};
            chartPanel.updateData(data);

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy driver JDBC của MySQL!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi cơ sở dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}