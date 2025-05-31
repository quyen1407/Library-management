package view;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.DocGia;
import controller.docGiaController;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class quanlydocgia extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtmadocgia;
    private JTextField txthvt;
    private JTextField txtdiachi;
    private JTextField txtemail;
    private JTextField txtsdt;
    private JTextField txttimkiem;
    private JTable table;
    private docGiaController controller;
    private JComboBox<String> cbbgioitinh;
    private JSpinner spngaysinh, spngaylamthe, spngayhethan;

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
                    quanlydocgia frame = new quanlydocgia();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public quanlydocgia() {
        controller = new docGiaController(); // Khởi tạo controller

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1113, 716);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel menu bên trái
        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBackground(new Color(203, 192, 255));
        panel_2.setBounds(0, 0, 203, 677);
        contentPane.add(panel_2);

        JPanel panel_3 = new JPanel();
        panel_3.setLayout(null);
        panel_3.setBackground(new Color(203, 192, 255));
        panel_3.setBounds(0, 11, 203, 37);
        panel_2.add(panel_3);
        panel_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuadmin menuadminn = new menuadmin();
                menuadminn.setVisible(true);
                dispose();
            }
        });

        JLabel lblNewLabel_4 = new JLabel("   Trang Chủ ");
        ImageIcon trangchu = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\house.png");
        Image trangchuu = trangchu.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        lblNewLabel_4.setIcon(new ImageIcon(trangchuu));
        lblNewLabel_4.setForeground(new Color(0, 0, 0));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
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
        lblNewLabel_4_1.setBounds(32, 0, 150, 37);
        panel_3_2.add(lblNewLabel_4_1);

        JLabel lblNewLabel_5 = new JLabel("Đặc Trưng");
        lblNewLabel_5.setForeground(Color.BLACK);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setBounds(23, 97, 77, 19);
        panel_2.add(lblNewLabel_5);

        JPanel panel_3_2_1 = new JPanel();
        panel_3_2_1.setLayout(null);
        panel_3_2_1.setBackground(new Color(203, 192, 255));
        panel_3_2_1.setBounds(0, 123, 203, 37);
        panel_2.add(panel_3_2_1);
        panel_3_2_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                quanlysach quanlysach = new quanlysach();
                quanlysach.setVisible(true);
                dispose();
            }
        });

        JLabel lblNewLabel_4_1_1 = new JLabel("Sách");
        ImageIcon sach = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\stack-of-books.png");
        Image sachh = sach.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        lblNewLabel_4_1_1.setIcon(new ImageIcon(sachh));
        lblNewLabel_4_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
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
                quanlyphongdoc quanlyphong = new quanlyphongdoc();
                quanlyphong.setVisible(true);
                dispose();
            }
        });

        JLabel lblNewLabel_4_1_1_1 = new JLabel("Phòng Đọc");
        ImageIcon originalIconReading = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\phongdoc.png");
        Image scaledReadingImage = originalIconReading.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        lblNewLabel_4_1_1_1.setIcon(new ImageIcon(scaledReadingImage));
        lblNewLabel_4_1_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4_1_1_1.setBounds(32, 0, 150, 37);
        panel_3_2_1_1.add(lblNewLabel_4_1_1_1);

        JPanel panel_3_2_1_1_1 = new JPanel();
        panel_3_2_1_1_1.setLayout(null);
        panel_3_2_1_1_1.setBackground(new Color(192, 192, 192));
        panel_3_2_1_1_1.setBounds(0, 219, 203, 37);
        panel_2.add(panel_3_2_1_1_1);

        JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Độc Giả");
        ImageIcon docgia = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\reading.png");
        Image docgiaa = docgia.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        lblNewLabel_4_1_1_1_1.setIcon(new ImageIcon(docgiaa));
        lblNewLabel_4_1_1_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_4_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
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
        lblNewLabel_4_1_1_1_1_1_3.setBounds(32, 0, 150, 37);
        panel_3_2_1_1_1_1_3.add(lblNewLabel_4_1_1_1_1_1_3);

        // Panel tiêu đề
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(202, 0, 895, 67);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblQunLc = new JLabel("QUẢN LÝ ĐỘC GIẢ");
        lblQunLc.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblQunLc.setBounds(10, 16, 203, 36);
        panel.add(lblQunLc);

        RoundedButton btnlichsu = new RoundedButton("LỊCH SỬ", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        btnlichsu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                      lichsudocgia docgia = new lichsudocgia();
                      docgia.setVisible(true);
                      dispose();
                  
        	}
        });
        ImageIcon historyIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\history.png");
        Image scaledHistory = historyIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnlichsu.setIcon(new ImageIcon(scaledHistory));
        btnlichsu.setForeground(Color.WHITE);
        btnlichsu.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnlichsu.setBounds(715, 16, 99, 36);
        panel.add(btnlichsu);

        RoundedButton btnlammoi = new RoundedButton("", new Color(255, 255, 255), new Color(255, 255, 255), new Color(220, 220, 220), 20);
        ImageIcon refreshIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\refresh.png");
        Image scaledRefresh = refreshIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        btnlammoi.setIcon(new ImageIcon(scaledRefresh));
        btnlammoi.setToolTipText("Làm mới danh sách");
        btnlammoi.setBounds(824, 16, 40, 40);
        panel.add(btnlammoi);

        // Panel nhập liệu
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBounds(204, 78, 362, 588);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1_2 = new JLabel("Mã Độc Giả");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2.setBounds(22, 42, 97, 27);
        panel_1.add(lblNewLabel_1_2);

        txtmadocgia = new JTextField();
        txtmadocgia.setColumns(10);
        txtmadocgia.setBounds(129, 45, 186, 24);
        panel_1.add(txtmadocgia);

        JLabel lblNewLabel_1_2_1 = new JLabel("Họ Và Tên");
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1.setBounds(22, 98, 97, 27);
        panel_1.add(lblNewLabel_1_2_1);

        txthvt = new JTextField();
        txthvt.setColumns(10);
        txthvt.setBounds(129, 101, 186, 24);
        panel_1.add(txthvt);

        JLabel lblNewLabel_1_2_2 = new JLabel("Giới Tính");
        lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_2.setBounds(22, 152, 97, 27);
        panel_1.add(lblNewLabel_1_2_2);

        JLabel lblNewLabel_1_2_3 = new JLabel("Ngày Sinh");
        lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_3.setBounds(22, 208, 97, 27);
        panel_1.add(lblNewLabel_1_2_3);

        JLabel lblNewLabel_1_2_4 = new JLabel("Địa Chỉ");
        lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_4.setBounds(22, 269, 97, 27);
        panel_1.add(lblNewLabel_1_2_4);

        txtdiachi = new JTextField();
        txtdiachi.setColumns(10);
        txtdiachi.setBounds(129, 272, 186, 24);
        panel_1.add(txtdiachi);

        JLabel lblNewLabel_1_2_5 = new JLabel("Email");
        lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_5.setBounds(22, 328, 97, 27);
        panel_1.add(lblNewLabel_1_2_5);

        txtemail = new JTextField();
        txtemail.setColumns(10);
        txtemail.setBounds(129, 331, 186, 24);
        panel_1.add(txtemail);

        JLabel lblNewLabel_1_2_6 = new JLabel("Số Điện Thoại");
        lblNewLabel_1_2_6.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_6.setBounds(22, 388, 97, 27);
        panel_1.add(lblNewLabel_1_2_6);

        txtsdt = new JTextField();
        txtsdt.setColumns(10);
        txtsdt.setBounds(129, 391, 186, 24);
        panel_1.add(txtsdt);

        JLabel lblNewLabel_1_2_7 = new JLabel("Ngày Làm Thẻ");
        lblNewLabel_1_2_7.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_7.setBounds(22, 448, 107, 27);
        panel_1.add(lblNewLabel_1_2_7);

        JLabel lblNewLabel_1_2_8 = new JLabel("Ngày Hết Hạn");
        lblNewLabel_1_2_8.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_8.setBounds(22, 511, 97, 27);
        panel_1.add(lblNewLabel_1_2_8);

        cbbgioitinh = new JComboBox<String>();
        cbbgioitinh.setModel(new DefaultComboBoxModel<>(new String[] {"<Trống>", "Nam", "Nữ"}));
        cbbgioitinh.setSelectedIndex(0);
        cbbgioitinh.setFont(new Font("Tahoma", Font.ITALIC, 14));
        cbbgioitinh.setEditable(true);
        cbbgioitinh.setBackground(Color.WHITE);
        cbbgioitinh.setBounds(129, 156, 186, 24);
        panel_1.add(cbbgioitinh);

        spngaysinh = new JSpinner();
        spngaysinh.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
        spngaysinh.setBounds(129, 213, 186, 24);
        panel_1.add(spngaysinh);

        spngaylamthe = new JSpinner();
        spngaylamthe.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
        spngaylamthe.setBounds(129, 448, 186, 24);
        panel_1.add(spngaylamthe);

        spngayhethan = new JSpinner();
        spngayhethan.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
        spngayhethan.setBounds(129, 516, 186, 24);
        panel_1.add(spngayhethan);

        // Panel bảng danh sách
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1_1.setBackground(new Color(255, 255, 255));
        panel_1_1.setBounds(574, 78, 513, 438);
        contentPane.add(panel_1_1);
        panel_1_1.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 493, 416);
        panel_1_1.add(scrollPane);

        // Khởi tạo JTable
        String[] columnNames = {"Mã Độc Giả", "Họ Tên", "Giới Tính", "Ngày Sinh", "Địa Chỉ", "Email", "SĐT", "Ngày Làm Thẻ", "Ngày Hết Hạn"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);

        // Nút Thêm
        RoundedButton btnthem = new RoundedButton("THÊM", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        ImageIcon addIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\add.png");
        Image scaledAdd = addIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnthem.setIcon(new ImageIcon(scaledAdd));
        btnthem.setForeground(Color.WHITE);
        btnthem.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnthem.setBounds(616, 545, 117, 40);
        contentPane.add(btnthem);

        // Nút Cập nhật
        RoundedButton btncapnhat = new RoundedButton("CẬP NHẬT", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        ImageIcon updateIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\updating.png");
        Image scaledUpdate = updateIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btncapnhat.setIcon(new ImageIcon(scaledUpdate));
        btncapnhat.setForeground(Color.WHITE);
        btncapnhat.setFont(new Font("Tahoma", Font.BOLD, 13));
        btncapnhat.setBounds(757, 545, 147, 40);
        contentPane.add(btncapnhat);

        // Nút Xóa
        RoundedButton btnxoa = new RoundedButton("XÓA", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        ImageIcon deleteIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\delete.png");
        Image scaledDelete = deleteIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnxoa.setIcon(new ImageIcon(scaledDelete));
        btnxoa.setForeground(Color.WHITE);
        btnxoa.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnxoa.setBounds(930, 545, 117, 40);
        contentPane.add(btnxoa);

        // Nút Tìm kiếm
        RoundedButton btntimkiem = new RoundedButton("TÌM KIẾM", new Color(135, 206, 250), new Color(135, 206, 250), new Color(173, 216, 255), 20);
        ImageIcon searchIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\seach.png");
        Image scaledSearch = searchIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btntimkiem.setIcon(new ImageIcon(scaledSearch));
        btntimkiem.setForeground(Color.WHITE);
        btntimkiem.setFont(new Font("Tahoma", Font.BOLD, 13));
        btntimkiem.setBounds(636, 595, 142, 40);
        contentPane.add(btntimkiem);

        txttimkiem = new JTextField();
        txttimkiem.setColumns(10);
        txttimkiem.setBounds(799, 599, 210, 30);
        contentPane.add(txttimkiem);

        // Tải danh sách độc giả khi khởi động
        loadTableData();

        // Sự kiện nút Thêm
        btnthem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    DocGia dg = createDocGiaFromInput();
                    if (controller.handleAdd(dg)) {
                        JOptionPane.showMessageDialog(null, "Thêm độc giả thành công!");
                        loadTableData();
                        clearInputFields();
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm độc giả thất bại!");
                    }
                }
            }
        });

        // Sự kiện nút Cập nhật
        btncapnhat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    DocGia dg = createDocGiaFromInput();
                    if (controller.handleUpdate(dg)) {
                        JOptionPane.showMessageDialog(null, "Cập nhật độc giả thành công!");
                        loadTableData();
                        clearInputFields();
                    } else {
                        JOptionPane.showMessageDialog(null, "Cập nhật độc giả thất bại!");
                    }
                }
            }
        });

        // Sự kiện nút Xóa
        btnxoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maDocGia = txtmadocgia.getText().trim();
                if (maDocGia.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập mã độc giả để xóa!");
                    return;
                }
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa độc giả này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    if (controller.handleDelete(maDocGia)) {
                        JOptionPane.showMessageDialog(null, "Xóa độc giả thành công!");
                        loadTableData();
                        clearInputFields();
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa độc giả thất bại!");
                    }
                }
            }
        });

        // Sự kiện nút Tìm kiếm
        btntimkiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String keyword = txttimkiem.getText().trim();
                loadTableData(keyword);
            }
        });

        // Sự kiện nút Làm mới
        btnlammoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadTableData();
                clearInputFields();
            }
        });

        // Sự kiện chọn dòng trong bảng
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                    int selectedRow = table.getSelectedRow();
                    txtmadocgia.setText(table.getValueAt(selectedRow, 0).toString());
                    txthvt.setText(table.getValueAt(selectedRow, 1).toString());
                    cbbgioitinh.setSelectedItem(table.getValueAt(selectedRow, 2).toString());
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        spngaysinh.setValue(sdf.parse(table.getValueAt(selectedRow, 3).toString()));
                        spngaylamthe.setValue(sdf.parse(table.getValueAt(selectedRow, 7).toString()));
                        spngayhethan.setValue(sdf.parse(table.getValueAt(selectedRow, 8).toString()));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    txtdiachi.setText(table.getValueAt(selectedRow, 4).toString());
                    txtemail.setText(table.getValueAt(selectedRow, 5).toString());
                    txtsdt.setText(table.getValueAt(selectedRow, 6).toString());
                }
            }
        });
    }

    // Tải dữ liệu vào bảng
    private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); 
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        for (DocGia dg : controller.handleLoadAll()) {
            Object[] row = {
                dg.getMaDocGia(),
                dg.getHoTen(),
                dg.getGioiTinh(),
                dg.getNgaySinh() != null ? sdf.format(dg.getNgaySinh()) : "",
                dg.getDiaChi(),
                dg.getEmail(),
                dg.getSoDienThoai(),
                dg.getNgayLamThe() != null ? sdf.format(dg.getNgayLamThe()) : "",
                dg.getNgayHetHan() != null ? sdf.format(dg.getNgayHetHan()) : ""
            };
            model.addRow(row);
        }
    }

    // Tải dữ liệu tìm kiếm vào bảng
    private void loadTableData(String keyword) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); 
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        for (DocGia dg : controller.handleSearch(keyword)) {
            Object[] row = {
                dg.getMaDocGia(),
                dg.getHoTen(),
                dg.getGioiTinh(),
                dg.getNgaySinh() != null ? sdf.format(dg.getNgaySinh()) : "",
                dg.getDiaChi(),
                dg.getEmail(),
                dg.getSoDienThoai(),
                dg.getNgayLamThe() != null ? sdf.format(dg.getNgayLamThe()) : "",
                dg.getNgayHetHan() != null ? sdf.format(dg.getNgayHetHan()) : ""
            };
            model.addRow(row);
        }
    }

    // Tạo đối tượng DocGia từ dữ liệu nhập
    private DocGia createDocGiaFromInput() {
        DocGia dg = new DocGia();
        dg.setMaDocGia(txtmadocgia.getText().trim());
        dg.setHoTen(txthvt.getText().trim());
        dg.setGioiTinh(cbbgioitinh.getSelectedItem().toString().equals("<Trống>") ? "" : cbbgioitinh.getSelectedItem().toString());
        dg.setNgaySinh((Date) spngaysinh.getValue());
        dg.setDiaChi(txtdiachi.getText().trim());
        dg.setEmail(txtemail.getText().trim());
        dg.setSoDienThoai(txtsdt.getText().trim());
        dg.setNgayLamThe((Date) spngaylamthe.getValue());
        dg.setNgayHetHan((Date) spngayhethan.getValue());
        return dg;
    }

    // Kiểm tra dữ liệu đầu vào
    private boolean validateInput() {
        if (txtmadocgia.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mã độc giả không được để trống!");
            return false;
        }
        if (txthvt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Họ tên không được để trống!");
            return false;
        }
        if (cbbgioitinh.getSelectedItem().toString().equals("<Trống>")) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính!");
            return false;
        }
        if (txtemail.getText().trim().isEmpty() || !txtemail.getText().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(null, "Email không hợp lệ!");
            return false;
        }
        if (txtsdt.getText().trim().isEmpty() || !txtsdt.getText().matches("^[0-9]{10}$")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại phải là 10 chữ số!");
            return false;
        }
        // Kiểm tra ngày làm thẻ và ngày hết hạn
        Date ngayLamThe = (Date) spngaylamthe.getValue();
        Date ngayHetHan = (Date) spngayhethan.getValue();
        if (ngayLamThe.after(ngayHetHan)) {
            JOptionPane.showMessageDialog(null, "Ngày làm thẻ phải nhỏ hơn hoặc bằng ngày hết hạn!");
            return false;
        }
        return true;
    }

    // Xóa các trường nhập liệu
    private void clearInputFields() {
        txtmadocgia.setText("");
        txthvt.setText("");
        cbbgioitinh.setSelectedIndex(0);
        spngaysinh.setValue(new Date());
        txtdiachi.setText("");
        txtemail.setText("");
        txtsdt.setText("");
        spngaylamthe.setValue(new Date());
        spngayhethan.setValue(new Date());
    }
}