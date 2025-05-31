package view;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import model.Phongdoc;
import controller.phongDocController;

public class quanlyphongdoc extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtma;
    private JTextField txtsoluongnguoi;
    private JTextField txttimkiem;
    private JTable table;
    private JComboBox<String> cbbphong;
    private JComboBox<String> cbbtang;
    private JComboBox<String> cbbtrangthai;
    private JComboBox<String> cbbloaiphong;

    static class RoundedButton extends JButton {
        private Color backgroundColor;
        private Color borderColor;
        private Color hoverClickColor;
        private int radius;
        private boolean isMouseOver;

        public RoundedButton(String text, Color backgroundColor, Color borderColor, Color hoverClickColor, int radius) {
            super(text);
            this.backgroundColor = backgroundColor;
            this.borderColor = borderColor;
            this.hoverClickColor = hoverClickColor;
            this.radius = radius;
            this.isMouseOver = false;
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    isMouseOver = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    isMouseOver = false;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Color currentColor = backgroundColor;
            if (getModel().isPressed() || isMouseOver) {
                currentColor = hoverClickColor;
            }

            g2.setColor(currentColor);
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

            g2.setColor(borderColor);
            g2.setStroke(new java.awt.BasicStroke(2));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

            super.paintComponent(g);
            g2.dispose();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    quanlyphongdoc frame = new quanlyphongdoc();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public quanlyphongdoc() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1113, 716);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBackground(new Color(203, 192, 255));
        panel_2.setBounds(0, 0, 203, 699);
        contentPane.add(panel_2);

        JPanel panel_3 = new JPanel();
        panel_3.setLayout(null);
        panel_3.setBackground(new Color(203, 192, 255));
        panel_3.setBounds(0, 11, 203, 37);
        panel_2.add(panel_3);
        panel_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuadmin menu = new menuadmin();
                menu.setVisible(true);
                dispose();
            }
        });
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
        panel_3_2.setForeground(Color.BLACK);
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
        lblNewLabel_5.setForeground(Color.BLACK);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setBounds(23, 97, 77, 23);
        panel_2.add(lblNewLabel_5);

        JPanel panel_3_2_1 = new JPanel();
        panel_3_2_1.setLayout(null);
        panel_3_2_1.setBackground(new Color(203, 192, 255));
        panel_3_2_1.setBounds(0, 123, 203, 37);
        panel_2.add(panel_3_2_1);
        panel_3_2_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                quanlysach qlsach = new quanlysach();
                qlsach.setVisible(true);
                dispose();
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
        panel_3_2_1_1.setBackground(new Color(192, 192, 192));
        panel_3_2_1_1.setBounds(0, 171, 203, 37);
        panel_2.add(panel_3_2_1_1);

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
                quanlydocgia docgia = new quanlydocgia();
                docgia.setVisible(true);
                dispose();
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
                quanlymuontra muontra = new quanlymuontra();
                muontra.setVisible(true);
                dispose();
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
                quanlynhanvien nv = new quanlynhanvien();
                nv.setVisible(true);
                dispose();
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
                quanlytaikhoan tk = new quanlytaikhoan();
                tk.setVisible(true);
                dispose();
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
                welcome wl = new welcome();
                wl.setVisible(true);
                dispose();
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

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(203, 0, 894, 69);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("QUẢN LÝ PHÒNG ĐỌC");
        lblNewLabel.setBounds(38, 22, 203, 36);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));

        RoundedButton btnlammoi = new RoundedButton("", new Color(255, 255, 255), new Color(255, 255, 255), new Color(220, 220, 220), 20);
        btnlammoi.setToolTipText("Làm mới danh sách");
        btnlammoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlammoi.setBounds(813, 18, 40, 40);
        ImageIcon refreshIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\refresh.png");
        Image resizedIcon = refreshIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        btnlammoi.setIcon(new ImageIcon(resizedIcon));
        panel.add(btnlammoi);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
        panel_1.setBounds(245, 76, 806, 246);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Mã Phòng Đọc");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_1.setBounds(56, 26, 114, 24);
        panel_1.add(lblNewLabel_1);

        txtma = new JTextField();
        txtma.setBounds(173, 29, 175, 22);
        panel_1.add(txtma);
        txtma.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Trạng Thái Phòng");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_1_1.setBounds(410, 26, 129, 24);
        panel_1.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Phòng");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_1_2.setBounds(56, 102, 114, 24);
        panel_1.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Tầng");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_1_3.setBounds(56, 187, 114, 24);
        panel_1.add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_4 = new JLabel("Số Lượng Người");
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_1_4.setBounds(410, 102, 121, 24);
        panel_1.add(lblNewLabel_1_4);

        txtsoluongnguoi = new JTextField();
        txtsoluongnguoi.setColumns(10);
        txtsoluongnguoi.setBounds(541, 105, 175, 22);
        panel_1.add(txtsoluongnguoi);

        JLabel lblNewLabel_1_5 = new JLabel("Loại Phòng");
        lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_1_5.setBounds(424, 187, 114, 24);
        panel_1.add(lblNewLabel_1_5);

        cbbphong = new JComboBox<>();
        cbbphong.setFont(new Font("Tahoma", Font.ITALIC, 14));
        cbbphong.setBackground(new Color(255, 255, 255));
        cbbphong.setEditable(true);
        cbbphong.setModel(new DefaultComboBoxModel<>(new String[] {"<Trống>", "1", "2", "3", "4", "5", "6"}));
        cbbphong.setBounds(173, 105, 175, 22);
        panel_1.add(cbbphong);

        cbbtang = new JComboBox<>();
        cbbtang.setModel(new DefaultComboBoxModel<>(new String[] {"<Trống>", "1", "2", "3"}));
        cbbtang.setFont(new Font("Tahoma", Font.ITALIC, 14));
        cbbtang.setEditable(true);
        cbbtang.setBackground(Color.WHITE);
        cbbtang.setBounds(173, 190, 175, 22);
        panel_1.add(cbbtang);

        cbbtrangthai = new JComboBox<>();
        cbbtrangthai.setModel(new DefaultComboBoxModel<>(new String[] {"Còn Trống", "Đã Đủ"}));
        cbbtrangthai.setFont(new Font("Tahoma", Font.ITALIC, 14));
        cbbtrangthai.setEditable(true);
        cbbtrangthai.setBackground(Color.WHITE);
        cbbtrangthai.setBounds(541, 29, 175, 22);
        panel_1.add(cbbtrangthai);

        cbbloaiphong = new JComboBox<>();
        cbbloaiphong.setModel(new DefaultComboBoxModel<>(new String[] {"Thường", "Riêng Tư"}));
        cbbloaiphong.setFont(new Font("Tahoma", Font.ITALIC, 14));
        cbbloaiphong.setEditable(true);
        cbbloaiphong.setBackground(Color.WHITE);
        cbbloaiphong.setBounds(541, 190, 175, 22);
        panel_1.add(cbbloaiphong);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 255, 255));
        panel_4.setBounds(203, 333, 894, 69);
        contentPane.add(panel_4);
        panel_4.setLayout(null);

        RoundedButton btnthem = new RoundedButton("Thêm Phòng", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        btnthem.setText("THÊM PHÒNG");
        ImageIcon addIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\add.png");
        Image scaledAdd = addIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnthem.setIcon(new ImageIcon(scaledAdd));
        btnthem.setHorizontalAlignment(SwingConstants.LEFT);
        btnthem.setIconTextGap(8);
        btnthem.setForeground(Color.WHITE);
        btnthem.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnthem.setBounds(29, 15, 149, 43);
        panel_4.add(btnthem);

        RoundedButton btncapnhat = new RoundedButton("Cập Nhật", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        btncapnhat.setText("CẬP NHẬT");
        ImageIcon updateIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\updating.png");
        Image scaledUpdate = updateIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btncapnhat.setIcon(new ImageIcon(scaledUpdate));
        btncapnhat.setForeground(new Color(255, 255, 255));
        btncapnhat.setFont(new Font("Tahoma", Font.BOLD, 13));
        btncapnhat.setBounds(196, 15, 130, 43);
        panel_4.add(btncapnhat);

        RoundedButton btnxoa = new RoundedButton("Xóa Phòng", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        btnxoa.setText("XÓA PHÒNG");
        ImageIcon deleteIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\delete.png");
        Image scaledDelete = deleteIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnxoa.setIcon(new ImageIcon(scaledDelete));
        btnxoa.setForeground(new Color(255, 255, 255));
        btnxoa.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnxoa.setBounds(352, 15, 142, 43);
        panel_4.add(btnxoa);

        RoundedButton btntimkiem = new RoundedButton("Tìm Kiếm", new Color(135, 206, 250), new Color(135, 206, 250), new Color(173, 216, 255), 20);
        btntimkiem.setText("TÌM KIẾM");
        ImageIcon searchIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\seach.png");
        Image scaledSearch = searchIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btntimkiem.setIcon(new ImageIcon(scaledSearch));
        btntimkiem.setFont(new Font("Tahoma", Font.BOLD, 13));
        btntimkiem.setBounds(516, 15, 130, 43);
        panel_4.add(btntimkiem);

        txttimkiem = new JTextField();
        txttimkiem.setColumns(10);
        txttimkiem.setBounds(656, 23, 214, 32);
        panel_4.add(txttimkiem);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(203, 403, 894, 263);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"Mã Phòng Đọc", "Phòng", "Tầng", "Trạng Thái", "Số Lượng Người", "Loại Phòng"}
        ));
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    txtma.setText(table.getValueAt(selectedRow, 0).toString());
                    cbbphong.setSelectedItem(table.getValueAt(selectedRow, 1).toString());
                    cbbtang.setSelectedItem(table.getValueAt(selectedRow, 2).toString());
                    cbbtrangthai.setSelectedItem(table.getValueAt(selectedRow, 3).toString());
                    txtsoluongnguoi.setText(table.getValueAt(selectedRow, 4).toString());
                    cbbloaiphong.setSelectedItem(table.getValueAt(selectedRow, 5).toString());
                }
            }
        });
        scrollPane.setViewportView(table);

        // Load initial data
        loadTableData();

        // Add button action listeners
        btnthem.addActionListener(e -> handleAdd());
        btncapnhat.addActionListener(e -> handleUpdate());
        btnxoa.addActionListener(e -> handleDelete());
        btntimkiem.addActionListener(e -> handleSearch());
        btnlammoi.addActionListener(e -> {
            clearForm();
            loadTableData();
        });
    }

    private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows
        List<Phongdoc> list = phongDocController.handleLoadAll();
        for (Phongdoc p : list) {
            model.addRow(new Object[] {
                p.getMaPhongDoc(),
                p.getPhong(),
                p.getTang(),
                p.getTrangThai(),
                p.getSoLuongNguoi(),
                p.getLoaiPhong()
            });
        }
    }

    private void clearForm() {
        txtma.setText("");
        txtsoluongnguoi.setText("");
        cbbphong.setSelectedIndex(0);
        cbbtang.setSelectedIndex(0);
        cbbtrangthai.setSelectedIndex(0);
        cbbloaiphong.setSelectedIndex(0);
        txttimkiem.setText("");
    }

    private void handleAdd() {
        try {
            String maPhong = txtma.getText().trim();
            String phong = cbbphong.getSelectedItem().toString();
            String tang = cbbtang.getSelectedItem().toString();
            String trangThai = cbbtrangthai.getSelectedItem().toString();
            int soLuongNguoi = Integer.parseInt(txtsoluongnguoi.getText().trim());
            String loaiPhong = cbbloaiphong.getSelectedItem().toString();

            if (maPhong.isEmpty() || phong.equals("<Trống>") || tang.equals("<Trống>")) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Phongdoc p = new Phongdoc(maPhong, phong, tang, trangThai, soLuongNguoi, loaiPhong);
            if (phongDocController.handleAdd(p)) {
                JOptionPane.showMessageDialog(this, "Thêm phòng thành công!");
                clearForm();
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm phòng thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleUpdate() {
        try {
            String maPhong = txtma.getText().trim();
            String phong = cbbphong.getSelectedItem().toString();
            String tang = cbbtang.getSelectedItem().toString();
            String trangThai = cbbtrangthai.getSelectedItem().toString();
            int soLuongNguoi = Integer.parseInt(txtsoluongnguoi.getText().trim());
            String loaiPhong = cbbloaiphong.getSelectedItem().toString();

            if (maPhong.isEmpty() || phong.equals("<Trống>") || tang.equals("<Trống>")) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Phongdoc p = new Phongdoc(maPhong, phong, tang, trangThai, soLuongNguoi, loaiPhong);
            if (phongDocController.handleUpdate(p)) {
                JOptionPane.showMessageDialog(this, "Cập nhật phòng thành công!");
                clearForm();
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật phòng thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleDelete() {
        String maPhong = txtma.getText().trim();
        if (maPhong.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa phòng này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (phongDocController.handleDelete(maPhong)) {
                JOptionPane.showMessageDialog(this, "Xóa phòng thành công!");
                clearForm();
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa phòng thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void handleSearch() {
        String keyword = txttimkiem.getText().trim();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows
        List<Phongdoc> list = phongDocController.handleSearch(keyword);
        for (Phongdoc p : list) {
            model.addRow(new Object[] {
                p.getMaPhongDoc(),
                p.getPhong(),
                p.getTang(),
                p.getTrangThai(),
                p.getSoLuongNguoi(),
                p.getLoaiPhong()
            });
        }
    }
}