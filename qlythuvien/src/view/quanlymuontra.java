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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.DocGia;
import model.Book;
import model.MuonTra;
import model.modelDocGia;
import model.modelbook;
import controller.muonTraController;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class quanlymuontra extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtmamuon;
    private JTextField txttensach;
    private JTextField txtsoluong;
    private JTextField txtgiatien;
    private JTextField txttrangthai;
    private JTextField txtghichu;
    private JTextField txttimkiem;
    private JTable table;
    private JComboBox<String> cbbmadocgia;
    private JComboBox<String> cbbmasach;
    private JSpinner spngaymuon;
    private JSpinner spngaydukientra;
    private JSpinner spngaytra;
    private muonTraController controller;
    private modelDocGia docGiaModel;
    private modelbook bookModel;

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
                    quanlymuontra frame = new quanlymuontra();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public quanlymuontra() {
        controller = new muonTraController();
        docGiaModel = new modelDocGia();
        bookModel = new modelbook();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1215, 716);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Sidebar menu
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 0, 203, 677);
        panel_2.setLayout(null);
        panel_2.setBackground(new Color(203, 192, 255));
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
        lblNewLabel_4_1_1_1_1.setBounds(32, 0, 150, 37);
        panel_3_2_1_1_1.add(lblNewLabel_4_1_1_1_1);

        JPanel panel_3_2_1_1_1_1 = new JPanel();
        panel_3_2_1_1_1_1.setLayout(null);
        panel_3_2_1_1_1_1.setBackground(new Color(192, 192, 192));
        panel_3_2_1_1_1_1.setBounds(0, 267, 203, 37);
        panel_2.add(panel_3_2_1_1_1_1);

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

        // Header panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(202, 0, 997, 62);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblQunLMn = new JLabel("QUẢN LÝ MƯỢN TRẢ");
        lblQunLMn.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblQunLMn.setBounds(10, 11, 203, 36);
        panel.add(lblQunLMn);

        RoundedButton btnlichsu = new RoundedButton("LỊCH SỬ", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        btnlichsu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 lichsumuontra tra = new lichsumuontra();
                 tra.setVisible(true);
                 dispose();
        	}
        });
        ImageIcon historyIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\history.png");
        Image scaledHistory = historyIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnlichsu.setIcon(new ImageIcon(scaledHistory));
        btnlichsu.setForeground(Color.WHITE);
        btnlichsu.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnlichsu.setBounds(830, 11, 89, 36);
        panel.add(btnlichsu);

        RoundedButton btnlammoi = new RoundedButton("", new Color(255, 255, 255), new Color(255, 255, 255), new Color(220, 220, 220), 20);
        btnlammoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadTableData();
                clearInputFields();
            }
        });
        ImageIcon refreshIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\refresh.png");
        Image scaledRefresh = refreshIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        btnlammoi.setIcon(new ImageIcon(scaledRefresh));
        btnlammoi.setToolTipText("Làm mới danh sách");
        btnlammoi.setBounds(929, 11, 40, 40);
        panel.add(btnlammoi);

        // Input fields
        JLabel lblNewLabel_1_2 = new JLabel("Mã Phiếu Mượn");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2.setBounds(213, 89, 116, 27);
        contentPane.add(lblNewLabel_1_2);

        txtmamuon = new JTextField();
        txtmamuon.setColumns(10);
        txtmamuon.setBounds(326, 92, 186, 24);
        contentPane.add(txtmamuon);

        JLabel lblNewLabel_1_2_1 = new JLabel("Mã Độc Giả");
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1.setBounds(213, 142, 116, 27);
        contentPane.add(lblNewLabel_1_2_1);

        cbbmadocgia = new JComboBox<String>();
        cbbmadocgia.setFont(new Font("Tahoma", Font.ITALIC, 14));
        cbbmadocgia.setEditable(true);
        cbbmadocgia.setBackground(Color.WHITE);
        cbbmadocgia.setBounds(326, 146, 186, 24);
        contentPane.add(cbbmadocgia);

        JLabel lblNewLabel_1_2_1_1 = new JLabel("Mã Sách");
        lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_1.setBounds(213, 198, 116, 27);
        contentPane.add(lblNewLabel_1_2_1_1);

        cbbmasach = new JComboBox<String>();
        cbbmasach.setFont(new Font("Tahoma", Font.ITALIC, 14));
        cbbmasach.setEditable(true);
        cbbmasach.setBackground(Color.WHITE);
        cbbmasach.setBounds(326, 198, 186, 24);
        contentPane.add(cbbmasach);

        JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Tên Sách");
        lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_1_1.setBounds(213, 255, 116, 27);
        contentPane.add(lblNewLabel_1_2_1_1_1);

        txttensach = new JTextField();
        txttensach.setColumns(10);
        txttensach.setBounds(326, 258, 186, 24);
        contentPane.add(txttensach);

        JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Số Lượng");
        lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_1_1_1.setBounds(546, 89, 116, 27);
        contentPane.add(lblNewLabel_1_2_1_1_1_1);

        txtsoluong = new JTextField();
        txtsoluong.setColumns(10);
        txtsoluong.setBounds(672, 89, 186, 24);
        contentPane.add(txtsoluong);

        JLabel lblNewLabel_1_2_1_1_1_1_1 = new JLabel("Giá Tiền");
        lblNewLabel_1_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_1_1_1_1.setBounds(546, 145, 116, 27);
        contentPane.add(lblNewLabel_1_2_1_1_1_1_1);

        txtgiatien = new JTextField();
        txtgiatien.setColumns(10);
        txtgiatien.setBounds(672, 145, 186, 24);
        contentPane.add(txtgiatien);

        JLabel lblNewLabel_1_2_7 = new JLabel("Ngày Mượn Sách");
        lblNewLabel_1_2_7.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_7.setBounds(546, 198, 126, 27);
        contentPane.add(lblNewLabel_1_2_7);

        spngaymuon = new JSpinner();
        spngaymuon.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
        spngaymuon.setEditor(new JSpinner.DateEditor(spngaymuon, "dd-MM-yyyy HH:mm:ss"));
        spngaymuon.setBounds(672, 201, 186, 24);
        contentPane.add(spngaymuon);

        JLabel lblNewLabel_1_2_7_1 = new JLabel("Ngày Dự Kiến Trả");
        lblNewLabel_1_2_7_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_7_1.setBounds(546, 255, 126, 27);
        contentPane.add(lblNewLabel_1_2_7_1);

        spngaydukientra = new JSpinner();
        spngaydukientra.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
        spngaydukientra.setEditor(new JSpinner.DateEditor(spngaydukientra, "dd-MM-yyyy HH:mm:ss"));
        spngaydukientra.setBounds(672, 258, 186, 24);
        contentPane.add(spngaydukientra);

        JLabel lblNewLabel_1_2_1_1_1_1_2 = new JLabel("Ngày Trả Sách");
        lblNewLabel_1_2_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_1_1_1_2.setBounds(887, 89, 116, 27);
        contentPane.add(lblNewLabel_1_2_1_1_1_1_2);

        spngaytra = new JSpinner();
        spngaytra.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
        spngaytra.setEditor(new JSpinner.DateEditor(spngaytra, "dd-MM-yyyy HH:mm:ss"));
        spngaytra.setBounds(1013, 92, 176, 24);
        contentPane.add(spngaytra);

        JLabel lblNewLabel_1_2_1_1_1_1_1_1 = new JLabel("Trạng Thái");
        lblNewLabel_1_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_1_1_1_1_1.setBounds(887, 145, 84, 27);
        contentPane.add(lblNewLabel_1_2_1_1_1_1_1_1);

        txttrangthai = new JTextField();
        txttrangthai.setColumns(10);
        txttrangthai.setBounds(1013, 145, 176, 24);
        contentPane.add(txttrangthai);

        JLabel lblNewLabel_1_2_1_1_1_1_1_1_1 = new JLabel("Ghi Chú");
        lblNewLabel_1_2_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_1_1_1_1_1_1.setBounds(887, 198, 84, 27);
        contentPane.add(lblNewLabel_1_2_1_1_1_1_1_1_1);

        txtghichu = new JTextField();
        txtghichu.setColumns(10);
        txtghichu.setBounds(1013, 198, 176, 24);
        contentPane.add(txtghichu);

        // Buttons
        RoundedButton btnmuon = new RoundedButton("MƯỢN", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        ImageIcon borrowIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\borrow.png");
        Image scaledBorrow = borrowIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnmuon.setIcon(new ImageIcon(scaledBorrow));
        btnmuon.setForeground(Color.WHITE);
        btnmuon.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnmuon.setBounds(294, 293, 103, 40);
        contentPane.add(btnmuon);

        RoundedButton btntra = new RoundedButton("TRẢ", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        ImageIcon returnIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\return.png");
        Image scaledReturn = returnIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btntra.setIcon(new ImageIcon(scaledReturn));
        btntra.setForeground(Color.WHITE);
        btntra.setFont(new Font("Tahoma", Font.BOLD, 13));
        btntra.setBounds(432, 293, 103, 40);
        contentPane.add(btntra);

        RoundedButton btncapnhat = new RoundedButton("CẬP NHẬT", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        ImageIcon updateIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\updating.png");
        Image scaledUpdate = updateIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btncapnhat.setIcon(new ImageIcon(scaledUpdate));
        btncapnhat.setForeground(Color.WHITE);
        btncapnhat.setFont(new Font("Tahoma", Font.BOLD, 13));
        btncapnhat.setBounds(567, 293, 126, 40);
        contentPane.add(btncapnhat);

        RoundedButton btntimkiem = new RoundedButton("TÌM KIẾM", new Color(135, 206, 250), new Color(135, 206, 250), new Color(173, 216, 255), 20);
        ImageIcon searchIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\seach.png");
        Image scaledSearch = searchIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btntimkiem.setIcon(new ImageIcon(scaledSearch));
        btntimkiem.setForeground(Color.WHITE);
        btntimkiem.setFont(new Font("Tahoma", Font.BOLD, 13));
        btntimkiem.setBounds(726, 293, 126, 40);
        contentPane.add(btntimkiem);

        txttimkiem = new JTextField();
        txttimkiem.setColumns(10);
        txttimkiem.setBounds(862, 296, 251, 32);
        contentPane.add(txttimkiem);

        // Table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(204, 344, 994, 333);
        contentPane.add(scrollPane);

        String[] columnNames = {"Mã Phiếu Mượn", "Mã Độc Giả", "Mã Sách", "Tên Sách", "Số Lượng", "Giá Tiền", "Ngày Mượn", "Ngày Dự Kiến Trả", "Ngày Trả Sách", "Trạng Thái", "Ghi Chú"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);

        // Populate ComboBoxes
        loadComboBoxData();

        // Load initial table data
        loadTableData();

        // Button Actions
        btnmuon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    MuonTra mt = createMuonTraFromInput();
                    mt.setTrangThai("Đang mượn");
                    mt.setNgayTraSach(null); // No return date when borrowing

                    // Get book information
                    String maSach = mt.getMaSach();
                    int soLuongMuon = mt.getSoLuong();
                    Book book = null;
                    for (Book b : bookModel.getAll()) {
                        if (b.getMaSach().equals(maSach)) {
                            book = b;
                            break;
                        }
                    }

                    // Check if book exists
                    if (book == null) {
                        JOptionPane.showMessageDialog(null, "Sách không tồn tại!");
                        return;
                    }

                    // Check if enough quantity is available
                    if (book.getSoLuong() < soLuongMuon) {
                        JOptionPane.showMessageDialog(null, "Số lượng sách không đủ để mượn! Chỉ còn " + book.getSoLuong() + " cuốn.");
                        return;
                    }

                    // Decrease the book quantity
                    int originalQuantity = book.getSoLuong();
                    book.setSoLuong(originalQuantity - soLuongMuon);

                    // Update the book in modelbook
                    if (bookModel.capNhat(book)) {
                        // Add the borrowing record
                        if (controller.handleAdd(mt)) {
                            JOptionPane.showMessageDialog(null, "Thêm phiếu mượn thành công!");
                            loadTableData();
                            clearInputFields();

                            // Update quanlysach
                            updateBookQuantityInQuanLySach(maSach, book.getSoLuong());
                        } else {
                            // If adding the borrowing record fails, restore the book quantity
                            book.setSoLuong(originalQuantity);
                            bookModel.capNhat(book);
                            JOptionPane.showMessageDialog(null, "Thêm phiếu mượn thất bại!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Cập nhật số lượng sách thất bại!");
                    }
                }
            }
        });

        btntra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maPhieuMuon = txtmamuon.getText().trim();
                if (maPhieuMuon.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập mã phiếu mượn!");
                    return;
                }
                MuonTra mt = createMuonTraFromInput();
                mt.setTrangThai("Đã trả");
                Date ngayTraSach = (Date) spngaytra.getValue();
                mt.setNgayTraSach(ngayTraSach);

                // Get book information
                String maSach = mt.getMaSach();
                int soLuongTra = mt.getSoLuong();
                Book book = null;
                for (Book b : bookModel.getAll()) {
                    if (b.getMaSach().equals(maSach)) {
                        book = b;
                        break;
                    }
                }

                if (book == null) {
                    JOptionPane.showMessageDialog(null, "Sách không tồn tại!");
                    return;
                }

                // Increase the book quantity
                int originalQuantity = book.getSoLuong();
                book.setSoLuong(originalQuantity + soLuongTra);

                // Update the book in modelbook
                if (bookModel.capNhat(book)) {
                    // Calculate fine if overdue
                    Date ngayDuKienTra = (Date) spngaydukientra.getValue();
                    double giaTien = mt.getGiaTien();
                    long overdueDays = 0;
                    double fine = 0.0;
                    if (ngayTraSach.after(ngayDuKienTra)) {
                        long diffInMillies = ngayTraSach.getTime() - ngayDuKienTra.getTime();
                        overdueDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                        if (overdueDays > 0) {
                            fine = giaTien * overdueDays;
                        }
                    }

                    // Update the borrowing record
                    if (controller.handleUpdate(mt)) {
                        String billMessage = "Trả sách thành công!\n";
                        if (overdueDays > 0) {
                            billMessage += String.format("Sách trả muộn %d ngày.\nTiền phạt: %.2f VND (%.2f VND/ngày x %d ngày)",
                                    overdueDays, fine, giaTien, overdueDays);
                        } else {
                            billMessage += "Sách được trả đúng hạn, không có tiền phạt.";
                        }
                        JOptionPane.showMessageDialog(null, billMessage);
                        loadTableData();
                        clearInputFields();

                        // Update quanlysach
                        updateBookQuantityInQuanLySach(maSach, book.getSoLuong());
                    } else {
                        // If updating the borrowing record fails, restore the book quantity
                        book.setSoLuong(originalQuantity);
                        bookModel.capNhat(book);
                        JOptionPane.showMessageDialog(null, "Trả sách thất bại!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật số lượng sách thất bại!");
                }
            }
        });

        btncapnhat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    MuonTra mt = createMuonTraFromInput();
                    if (controller.handleUpdate(mt)) {
                        JOptionPane.showMessageDialog(null, "Cập nhật phiếu mượn thành công!");
                        loadTableData();
                        clearInputFields();
                    } else {
                        JOptionPane.showMessageDialog(null, "Cập nhật phiếu mượn thất bại!");
                    }
                }
            }
        });

        btntimkiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String keyword = txttimkiem.getText().trim();
                loadTableData(keyword);
            }
        });

        // Table Selection Listener
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                    int selectedRow = table.getSelectedRow();
                    txtmamuon.setText(table.getValueAt(selectedRow, 0).toString());
                    cbbmadocgia.setSelectedItem(table.getValueAt(selectedRow, 1).toString());
                    cbbmasach.setSelectedItem(table.getValueAt(selectedRow, 2).toString());
                    txttensach.setText(table.getValueAt(selectedRow, 3).toString());
                    txtsoluong.setText(table.getValueAt(selectedRow, 4).toString());
                    txtgiatien.setText(table.getValueAt(selectedRow, 5).toString());
                    txttrangthai.setText(table.getValueAt(selectedRow, 9).toString());
                    txtghichu.setText(table.getValueAt(selectedRow, 10).toString());
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        spngaymuon.setValue(sdf.parse(table.getValueAt(selectedRow, 6).toString()));
                        spngaydukientra.setValue(sdf.parse(table.getValueAt(selectedRow, 7).toString()));
                        String ngayTra = table.getValueAt(selectedRow, 8).toString();
                        if (!ngayTra.isEmpty()) {
                            spngaytra.setValue(sdf.parse(ngayTra));
                        } else {
                            spngaytra.setValue(new Date());
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Auto-fill book name when selecting book code
        cbbmasach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedMaSach = (String) cbbmasach.getSelectedItem();
                if (selectedMaSach != null) {
                    for (Book book : bookModel.getAll()) {
                        if (book.getMaSach().equals(selectedMaSach)) {
                            txttensach.setText(book.getTenSach());
                            break;
                        }
                    }
                }
            }
        });
    }

    private void loadComboBoxData() {
        // Populate cbbmadocgia
        cbbmadocgia.addItem("");
        for (DocGia dg : docGiaModel.getAll()) {
            cbbmadocgia.addItem(dg.getMaDocGia());
        }

        // Populate cbbmasach
        cbbmasach.addItem("");
        for (Book book : bookModel.getAll()) {
            cbbmasach.addItem(book.getMaSach());
        }
    }

    private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        for (MuonTra mt : controller.handleLoadAll()) {
            Object[] row = {
                mt.getMaPhieuMuon(),
                mt.getMaDocGia(),
                mt.getMaSach(),
                mt.getTenSach(),
                mt.getSoLuong(),
                mt.getGiaTien(),
                mt.getNgayMuon() != null ? sdf.format(mt.getNgayMuon()) : "",
                mt.getNgayDuKienTra() != null ? sdf.format(mt.getNgayDuKienTra()) : "",
                mt.getNgayTraSach() != null ? sdf.format(mt.getNgayTraSach()) : "",
                mt.getTrangThai(),
                mt.getGhiChu()
            };
            model.addRow(row);
        }
    }

    private void loadTableData(String keyword) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        for (MuonTra mt : controller.handleSearch(keyword)) {
            Object[] row = {
                mt.getMaPhieuMuon(),
                mt.getMaDocGia(),
                mt.getMaSach(),
                mt.getTenSach(),
                mt.getSoLuong(),
                mt.getGiaTien(),
                mt.getNgayMuon() != null ? sdf.format(mt.getNgayMuon()) : "",
                mt.getNgayDuKienTra() != null ? sdf.format(mt.getNgayDuKienTra()) : "",
                mt.getNgayTraSach() != null ? sdf.format(mt.getNgayTraSach()) : "",
                mt.getTrangThai(),
                mt.getGhiChu()
            };
            model.addRow(row);
        }
    }

    private MuonTra createMuonTraFromInput() {
        MuonTra mt = new MuonTra();
        mt.setMaPhieuMuon(txtmamuon.getText().trim());
        mt.setMaDocGia(cbbmadocgia.getSelectedItem().toString());
        mt.setMaSach(cbbmasach.getSelectedItem().toString());
        mt.setTenSach(txttensach.getText().trim());
        try {
            mt.setSoLuong(Integer.parseInt(txtsoluong.getText().trim()));
        } catch (NumberFormatException e) {
            mt.setSoLuong(0);
        }
        try {
            mt.setGiaTien(Double.parseDouble(txtgiatien.getText().trim()));
        } catch (NumberFormatException e) {
            mt.setGiaTien(0.0);
        }
        mt.setNgayMuon((Date) spngaymuon.getValue());
        mt.setNgayDuKienTra((Date) spngaydukientra.getValue());
        mt.setNgayTraSach((Date) spngaytra.getValue());
        mt.setTrangThai(txttrangthai.getText().trim());
        mt.setGhiChu(txtghichu.getText().trim());
        return mt;
    }

    private boolean validateInput() {
        if (txtmamuon.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mã phiếu mượn không được để trống!");
            return false;
        }
        if (cbbmadocgia.getSelectedItem() == null || cbbmadocgia.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn mã độc giả!");
            return false;
        }
        if (cbbmasach.getSelectedItem() == null || cbbmasach.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn mã sách!");
            return false;
        }
        if (txttensach.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên sách không được để trống!");
            return false;
        }
        try {
            int soLuong = Integer.parseInt(txtsoluong.getText().trim());
            if (soLuong <= 0) {
                JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0!");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Số lượng phải là số hợp lệ!");
            return false;
        }
        try {
            double giaTien = Double.parseDouble(txtgiatien.getText().trim());
            if (giaTien < 0) {
                JOptionPane.showMessageDialog(null, "Giá tiền không được âm!");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Giá tiền phải là số hợp lệ!");
            return false;
        }
        Date ngayMuon = (Date) spngaymuon.getValue();
        Date ngayDuKienTra = (Date) spngaydukientra.getValue();
        if (ngayMuon.after(ngayDuKienTra)) {
            JOptionPane.showMessageDialog(null, "Ngày mượn phải trước hoặc bằng ngày dự kiến trả!");
            return false;
        }
        return true;
    }

    private void clearInputFields() {
        txtmamuon.setText("");
        cbbmadocgia.setSelectedIndex(0);
        cbbmasach.setSelectedIndex(0);
        txttensach.setText("");
        txtsoluong.setText("");
        txtgiatien.setText("");
        spngaymuon.setValue(new Date());
        spngaydukientra.setValue(new Date());
        spngaytra.setValue(new Date());
        txttrangthai.setText("");
        txtghichu.setText("");
    }

    private void updateBookQuantityInQuanLySach(String maSach, int newQuantity) {
        quanlysach.updateBookQuantity(maSach, newQuantity);
    }
}