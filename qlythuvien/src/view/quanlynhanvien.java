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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import controller.nhanVienController;
import model.NhanVien;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JSpinner.DateEditor;

public class quanlynhanvien extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtmanv;
    private JTextField txttennv;
    private JTextField txtemail;
    private JTextField txtdiachi;
    private JTextField txtsdt;
    private JTextField txtluong;
    private JTextField txttimkiem;
    private JTable table;
    private JSpinner spngaysinh;
    private JSpinner spngaylamviec;
    private JComboBox<String> cbbchucvu;
    private nhanVienController controller;
    private DefaultTableModel tableModel;

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
                    quanlynhanvien frame = new quanlynhanvien();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public quanlynhanvien() {
        // Initialize controller
        controller = new nhanVienController();

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
        lblNewLabel_5.setBounds(23, 97, 77, 18);
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
        panel_3_2_1_1_1_1_1.setBackground(new Color(192, 192, 192));
        panel_3_2_1_1_1_1_1.setBounds(0, 315, 203, 37);
        panel_2.add(panel_3_2_1_1_1_1_1);

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
        panel.setBounds(202, 0, 895, 76);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblQunLNhn = new JLabel("QUẢN LÝ NHÂN VIÊN");
        lblQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblQunLNhn.setBounds(24, 22, 203, 36);
        panel.add(lblQunLNhn);

        RoundedButton btnlammoi = new RoundedButton("", new Color(255, 255, 255), new Color(255, 255, 255), new Color(220, 220, 220), 20);
        ImageIcon refreshIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\refresh.png");
        Image scaledRefresh = refreshIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        btnlammoi.setIcon(new ImageIcon(scaledRefresh));
        btnlammoi.setToolTipText("Làm mới danh sách");
        btnlammoi.setBounds(788, 16, 50, 50);
        panel.add(btnlammoi);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(203, 81, 894, 207);
        contentPane.add(panel_1);

        JLabel lblNewLabel_1_2 = new JLabel("Mã NV");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2.setBounds(10, 29, 70, 27);
        panel_1.add(lblNewLabel_1_2);

        txtmanv = new JTextField();
        txtmanv.setColumns(10);
        txtmanv.setBounds(90, 33, 176, 22);
        panel_1.add(txtmanv);

        JLabel lblNewLabel_1_1_1 = new JLabel("Tên NV");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1.setBounds(10, 90, 63, 27);
        panel_1.add(lblNewLabel_1_1_1);

        txttennv = new JTextField();
        txttennv.setColumns(10);
        txttennv.setBounds(90, 94, 176, 22);
        panel_1.add(txttennv);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Email");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1.setBounds(298, 90, 63, 27);
        panel_1.add(lblNewLabel_1_1_1_1);

        txtemail = new JTextField();
        txtemail.setColumns(10);
        txtemail.setBounds(414, 94, 176, 22);
        panel_1.add(txtemail);

        JLabel lblNewLabel_1_2_1 = new JLabel("Địa Chỉ");
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1.setBounds(298, 29, 70, 27);
        panel_1.add(lblNewLabel_1_2_1);

        txtdiachi = new JTextField();
        txtdiachi.setColumns(10);
        txtdiachi.setBounds(414, 33, 176, 22);
        panel_1.add(txtdiachi);

        JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Số Điện Thoại");
        lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_1_1.setBounds(298, 152, 110, 27);
        panel_1.add(lblNewLabel_1_2_1_1_1);

        txtsdt = new JTextField();
        txtsdt.setColumns(10);
        txtsdt.setBounds(414, 156, 176, 22);
        panel_1.add(txtsdt);

        JLabel lblNewLabel_1_2_1_2 = new JLabel("Ngày Làm Việc");
        lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_2.setBounds(606, 29, 110, 27);
        panel_1.add(lblNewLabel_1_2_1_2);

        JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Lương");
        lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_2_1.setBounds(606, 90, 70, 27);
        panel_1.add(lblNewLabel_1_2_1_2_1);

        txtluong = new JTextField();
        txtluong.setColumns(10);
        txtluong.setBounds(720, 94, 158, 22);
        panel_1.add(txtluong);

        JLabel lblNewLabel_1_2_1_2_1_1 = new JLabel("Chức Vụ");
        lblNewLabel_1_2_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_2_1_1.setBounds(606, 152, 70, 27);
        panel_1.add(lblNewLabel_1_2_1_2_1_1);

        JLabel lblNewLabel_1_2_1_1 = new JLabel("Ngày Sinh");
        lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_1.setBounds(10, 152, 77, 27);
        panel_1.add(lblNewLabel_1_2_1_1);

        spngaysinh = new JSpinner();
        spngaysinh.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
        DateEditor dateEditorSinh = new DateEditor(spngaysinh, "dd-MM-yyyy");
        spngaysinh.setEditor(dateEditorSinh);
        spngaysinh.setBounds(90, 157, 176, 22);
        panel_1.add(spngaysinh);

        cbbchucvu = new JComboBox<String>();
        cbbchucvu.setModel(new DefaultComboBoxModel<>(new String[] {"<Trống>", "Thủ Thư", "Nhân Viên Mượn - Trả", "Nhân Viên Phòng Đọc"}));
        cbbchucvu.setSelectedIndex(0);
        cbbchucvu.setFont(new Font("Tahoma", Font.ITALIC, 14));
        cbbchucvu.setEditable(true);
        cbbchucvu.setBackground(Color.WHITE);
        cbbchucvu.setBounds(719, 156, 159, 22);
        panel_1.add(cbbchucvu);

        spngaylamviec = new JSpinner();
        spngaylamviec.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
        DateEditor dateEditorLamViec = new DateEditor(spngaylamviec, "dd-MM-yyyy HH:mm");
        spngaylamviec.setEditor(dateEditorLamViec);
        spngaylamviec.setBounds(720, 33, 158, 22);
        panel_1.add(spngaylamviec);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 255, 255));
        panel_4.setBounds(202, 299, 895, 70);
        contentPane.add(panel_4);
        panel_4.setLayout(null);

        RoundedButton btnthem = new RoundedButton("THÊM", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        ImageIcon addIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\add.png");
        Image scaledAdd = addIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnthem.setIcon(new ImageIcon(scaledAdd));
        btnthem.setForeground(Color.WHITE);
        btnthem.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnthem.setBounds(10, 11, 133, 44);
        panel_4.add(btnthem);

        RoundedButton btncapnhat = new RoundedButton("CẬP NHẬT", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        ImageIcon updateIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\updating.png");
        Image scaledUpdate = updateIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btncapnhat.setIcon(new ImageIcon(scaledUpdate));
        btncapnhat.setForeground(Color.WHITE);
        btncapnhat.setFont(new Font("Tahoma", Font.BOLD, 13));
        btncapnhat.setBounds(172, 11, 140, 44);
        panel_4.add(btncapnhat);

        RoundedButton btnxoa = new RoundedButton("XÓA", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        ImageIcon deleteIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\delete.png");
        Image scaledDelete = deleteIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnxoa.setIcon(new ImageIcon(scaledDelete));
        btnxoa.setForeground(Color.WHITE);
        btnxoa.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnxoa.setBounds(340, 11, 133, 44);
        panel_4.add(btnxoa);

        RoundedButton btntimkiem = new RoundedButton("TÌM KIẾM", new Color(135, 206, 250), new Color(135, 206, 250), new Color(173, 216, 255), 20);
        ImageIcon searchIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\seach.png");
        Image scaledSearch = searchIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btntimkiem.setIcon(new ImageIcon(scaledSearch));
        btntimkiem.setForeground(Color.WHITE);
        btntimkiem.setFont(new Font("Tahoma", Font.BOLD, 13));
        btntimkiem.setBounds(500, 11, 124, 44);
        panel_4.add(btntimkiem);

        txttimkiem = new JTextField();
        txttimkiem.setColumns(10);
        txttimkiem.setBounds(634, 18, 251, 32);
        panel_4.add(txttimkiem);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(204, 371, 895, 306);
        contentPane.add(scrollPane);
        String[] columns = {"Mã NV", "Tên NV", "Ngày Sinh", "Địa Chỉ", "Ngày Làm Việc", "Email", "Lương", "Số Điện Thoại", "Chức Vụ"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);

       
        loadAllEmployees();

        
        btnthem.addActionListener(e -> handleAdd());
        btncapnhat.addActionListener(e -> handleUpdate());
        btnxoa.addActionListener(e -> handleDelete());
        btntimkiem.addActionListener(e -> handleSearch());
        btnlammoi.addActionListener(e -> handleRefresh());


        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    fillFormFromSelectedRow(selectedRow);
                }
            }
        });
    }

    private void loadAllEmployees() {
        tableModel.setRowCount(0); // Clear existing rows
        List<NhanVien> employees = controller.handleLoadAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        for (NhanVien nv : employees) {
            Object[] row = {
                nv.getMaNV(),
                nv.getTenNV(),
                nv.getNgaySinh() != null ? dateFormat.format(nv.getNgaySinh()) : "",
                nv.getDiaChi(),
                nv.getNgayLamViec() != null ? dateTimeFormat.format(nv.getNgayLamViec()) : "",
                nv.getEmail(),
                nv.getLuong(),
                nv.getSoDienThoai(),
                nv.getChucVu()
            };
            tableModel.addRow(row);
        }
    }

    private void handleAdd() {
        try {
            NhanVien nv = getEmployeeFromForm();
            if (nv == null) return;
            if (controller.handleAdd(nv)) {
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!");
                loadAllEmployees();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleUpdate() {
        try {
            NhanVien nv = getEmployeeFromForm();
            if (nv == null) return;
            if (controller.handleUpdate(nv)) {
                JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thành công!");
                loadAllEmployees();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleDelete() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên để xóa!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String maNV = (String) tableModel.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên " + maNV + "?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (controller.handleDelete(maNV)) {
                JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công!");
                loadAllEmployees();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void handleSearch() {
        String keyword = txttimkiem.getText().trim();
        tableModel.setRowCount(0); // Clear existing rows
        List<NhanVien> employees = controller.handleSearch(keyword);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        for (NhanVien nv : employees) {
            Object[] row = {
                nv.getMaNV(),
                nv.getTenNV(),
                nv.getNgaySinh() != null ? dateFormat.format(nv.getNgaySinh()) : "",
                nv.getDiaChi(),
                nv.getNgayLamViec() != null ? dateTimeFormat.format(nv.getNgayLamViec()) : "",
                nv.getEmail(),
                nv.getLuong(),
                nv.getSoDienThoai(),
                nv.getChucVu()
            };
            tableModel.addRow(row);
        }
        if (employees.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên nào!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void handleRefresh() {
        clearForm();
        loadAllEmployees();
        txttimkiem.setText("");
    }

    private NhanVien getEmployeeFromForm() {
        String maNV = txtmanv.getText().trim();
        String tenNV = txttennv.getText().trim();
        String diaChi = txtdiachi.getText().trim();
        String email = txtemail.getText().trim();
        String soDienThoai = txtsdt.getText().trim();
        String chucVu = cbbchucvu.getSelectedItem().toString();
        String luongStr = txtluong.getText().trim();

      
        if (maNV.isEmpty() || tenNV.isEmpty() || diaChi.isEmpty() || email.isEmpty() || soDienThoai.isEmpty() || chucVu.equals("<Trống>")) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        double luong;
        try {
            luong = Double.parseDouble(luongStr);
            if (luong < 0) {
                JOptionPane.showMessageDialog(this, "Lương phải là số không âm!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Lương phải là số hợp lệ!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return null;
        }

       
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return null;
        }

      
        if (!soDienThoai.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải có 10 chữ số!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        Date ngaySinh = (Date) spngaysinh.getValue();
        Date ngayLamViec = (Date) spngaylamviec.getValue();

        return new NhanVien(maNV, tenNV, ngaySinh, diaChi, ngayLamViec, email, luong, soDienThoai, chucVu);
    }

    private void fillFormFromSelectedRow(int rowIndex) {
        txtmanv.setText((String) tableModel.getValueAt(rowIndex, 0));
        txttennv.setText((String) tableModel.getValueAt(rowIndex, 1));
        txtdiachi.setText((String) tableModel.getValueAt(rowIndex, 3));
        txtemail.setText((String) tableModel.getValueAt(rowIndex, 5));
        txtluong.setText(String.valueOf(tableModel.getValueAt(rowIndex, 6)));
        txtsdt.setText((String) tableModel.getValueAt(rowIndex, 7));
        cbbchucvu.setSelectedItem(tableModel.getValueAt(rowIndex, 8));

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            String ngaySinhStr = (String) tableModel.getValueAt(rowIndex, 2);
            if (!ngaySinhStr.isEmpty()) {
                spngaysinh.setValue(dateFormat.parse(ngaySinhStr));
            }
            String ngayLamViecStr = (String) tableModel.getValueAt(rowIndex, 4);
            if (!ngayLamViecStr.isEmpty()) {
                spngaylamviec.setValue(dateTimeFormat.parse(ngayLamViecStr));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearForm() {
        txtmanv.setText("");
        txttennv.setText("");
        txtdiachi.setText("");
        txtemail.setText("");
        txtsdt.setText("");
        txtluong.setText("");
        cbbchucvu.setSelectedIndex(0);
        spngaysinh.setValue(new Date());
        spngaylamviec.setValue(new Date());
    }
}