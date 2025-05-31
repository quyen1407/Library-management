package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import controller.bookcontroller;
import model.Book;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class quanlysach extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtmasach; 
    private JTextField txttensach; 
    private JTextField txttheloai; 
    private JTextField txtsoluong; 
    private JTextField txtnxb; 
    private JTextField txttacgia; 
    private JTextField txtgiatien; 
    private JTextField txtvitri; 
    private JTextField txttimkiem; 
    private JSpinner spngayxb; 
    private JTable table; 
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
            g2.setStroke(new java.awt.BasicStroke(1));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

            super.paintComponent(g);
            g2.dispose();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    quanlysach frame = new quanlysach(); 
                    frame.setVisible(true); 
                } catch (Exception e) {
                    e.printStackTrace(); 
                }
            }
        });
    }

    public quanlysach() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setBounds(100, 100, 1113, 716); 
        setLocationRelativeTo(null); 
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255)); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 

        setContentPane(contentPane);
        contentPane.setLayout(null); 

        ImageIcon originalIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\AddNewBookIcons\\icons8_Books_52px_1.png");
        Image image = originalIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);

        JLabel lblNewLabel = new JLabel("Quản Lý Sách");
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setIcon(resizedIcon);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel.setBounds(553, 11, 200, 43);
        contentPane.add(lblNewLabel);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(203, 192, 255));
        panel_2.setLayout(null);
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
        panel_3_2.setForeground(new Color(0, 0, 0));
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
        lblNewLabel_5.setForeground(new Color(0, 0, 0));
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setBounds(23, 97, 77, 16);
        panel_2.add(lblNewLabel_5);

        JPanel panel_3_2_1 = new JPanel();
        panel_3_2_1.setLayout(null);
        panel_3_2_1.setBackground(new Color(192,192,192));
        panel_3_2_1.setBounds(0, 123, 203, 37);
        panel_2.add(panel_3_2_1);

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
        panel_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                quanlyphongdoc quanlyphongdoc = new quanlyphongdoc();
                quanlyphongdoc.setVisible(true);
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
        panel_3_2_1_1_1_1_1.setBackground(new Color(203, 192, 255));
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
        panel_3_2_1_1_1_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                quanlynhanvien nv = new quanlynhanvien();
                nv.setVisible(true);
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
        panel_3_2_1_1_1_1_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                quanlytaikhoan tk = new quanlytaikhoan();
                tk.setVisible(true);
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
        panel.setBackground(new Color(255, 0, 0));
        panel.setBounds(527, 54, 222, 6);
        contentPane.add(panel);
        panel_3_2_1_1_1_1_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                welcome wl = new welcome();
                wl.setVisible(true);
                dispose();
            }
        });

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(203, 80, 894, 207);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1_2 = new JLabel("Mã Sách");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2.setBounds(10, 29, 70, 27);
        panel_1.add(lblNewLabel_1_2);

        txtmasach = new JTextField();
        txtmasach.setColumns(10);
        txtmasach.setBounds(90, 33, 176, 22);
        panel_1.add(txtmasach);

        JLabel lblNewLabel_1_1_1 = new JLabel("Tên Sách");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1.setBounds(10, 90, 63, 27);
        panel_1.add(lblNewLabel_1_1_1);

        txttensach = new JTextField();
        txttensach.setColumns(10);
        txttensach.setBounds(90, 94, 176, 22);
        panel_1.add(txttensach);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Thể Loại");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1.setBounds(10, 152, 63, 27);
        panel_1.add(lblNewLabel_1_1_1_1);

        txttheloai = new JTextField();
        txttheloai.setColumns(10);
        txttheloai.setBounds(90, 156, 176, 22);
        panel_1.add(txttheloai);

        JLabel lblNewLabel_1_2_1 = new JLabel("Số Lượng\r\n");
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1.setBounds(298, 29, 70, 27);
        panel_1.add(lblNewLabel_1_2_1);

        txtsoluong = new JTextField();
        txtsoluong.setColumns(10);
        txtsoluong.setBounds(414, 33, 176, 22);
        panel_1.add(txtsoluong);

        JLabel lblNewLabel_1_2_1_1 = new JLabel("Ngày Xuất Bản\r\n");
        lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_1.setBounds(298, 90, 110, 27);
        panel_1.add(lblNewLabel_1_2_1_1);

        JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Nhà Xuất Bản\r\n");
        lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_1_1.setBounds(298, 152, 110, 27);
        panel_1.add(lblNewLabel_1_2_1_1_1);

        txtnxb = new JTextField();
        txtnxb.setColumns(10);
        txtnxb.setBounds(414, 156, 176, 22);
        panel_1.add(txtnxb);

        txttacgia = new JTextField();
        txttacgia.setBounds(702, 33, 176, 22);
        panel_1.add(txttacgia);
        txttacgia.setColumns(10);

        JLabel lblNewLabel_1_2_1_2 = new JLabel("Tác Giả\r\n\r\n");
        lblNewLabel_1_2_1_2.setBounds(622, 29, 70, 27);
        panel_1.add(lblNewLabel_1_2_1_2);
        lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Giá Tiền\r\n");
        lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_2_1.setBounds(622, 90, 70, 27);
        panel_1.add(lblNewLabel_1_2_1_2_1);

        txtgiatien = new JTextField();
        txtgiatien.setColumns(10);
        txtgiatien.setBounds(702, 94, 176, 22);
        panel_1.add(txtgiatien);

        JLabel lblNewLabel_1_2_1_2_1_1 = new JLabel("Vị Trí");
        lblNewLabel_1_2_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1_2_1_1.setBounds(622, 152, 70, 27);
        panel_1.add(lblNewLabel_1_2_1_2_1_1);

        txtvitri = new JTextField();
        txtvitri.setColumns(10);
        txtvitri.setBounds(702, 156, 176, 22);
        panel_1.add(txtvitri);

        spngayxb = new JSpinner();
        spngayxb.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spngayxb, "dd/MM/yyyy HH:mm");
        spngayxb.setEditor(dateEditor);
        spngayxb.setBounds(414, 95, 176, 22);
        panel_1.add(spngayxb);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 255, 255));
        panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_4.setBounds(203, 298, 894, 57);
        contentPane.add(panel_4);
        panel_4.setLayout(null);

        RoundedButton btnthem = new RoundedButton("THÊM", new Color(221, 160, 221), new Color(50, 50, 50), new Color(238, 130, 238), 20);
        ImageIcon addIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\add.png");
        Image scaledAdd = addIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnthem.setIcon(new ImageIcon(scaledAdd));
        btnthem.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnthem.setBounds(10, 11, 109, 35);
        panel_4.add(btnthem);

        RoundedButton btnsua = new RoundedButton("CẬP NHẬT", new Color(221, 160, 221), new Color(50, 50, 50), new Color(238, 130, 238), 20);
        ImageIcon updateIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\updating.png");
        Image scaledUpdate = updateIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnsua.setIcon(new ImageIcon(scaledUpdate));
        btnsua.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnsua.setBounds(145, 11, 134, 35);
        panel_4.add(btnsua);

        RoundedButton btnxoa = new RoundedButton("XÓA", new Color(221, 160, 221), new Color(50, 50, 50), new Color(238, 130, 238), 20);
        ImageIcon deleteIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\delete.png");
        Image scaledDelete = deleteIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnxoa.setIcon(new ImageIcon(scaledDelete));
        btnxoa.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnxoa.setBounds(305, 11, 109, 35);
        panel_4.add(btnxoa);

        RoundedButton btnlammoi = new RoundedButton("LÀM MỚI", new Color(221, 160, 221), new Color(50, 50, 50), new Color(238, 130, 238), 20);
        ImageIcon refreshIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\refresh.png");
        Image scaledRefresh = refreshIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnlammoi.setIcon(new ImageIcon(scaledRefresh));
        btnlammoi.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnlammoi.setBounds(430, 11, 122, 35);
        panel_4.add(btnlammoi);

        RoundedButton btntimkiem = new RoundedButton("TÌM KIẾM", new Color(255, 127, 80), new Color(50, 50, 50), new Color(255, 99, 71), 20);
        ImageIcon searchIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\seach.png");
        Image scaledSearch = searchIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btntimkiem.setIcon(new ImageIcon(scaledSearch));
        btntimkiem.setFont(new Font("Tahoma", Font.BOLD, 12));
        btntimkiem.setBounds(562, 11, 140, 35);
        panel_4.add(btntimkiem);

        txttimkiem = new JTextField();
        txttimkiem.setBounds(712, 13, 172, 30);
        panel_4.add(txttimkiem);
        txttimkiem.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(203, 366, 894, 311);
        contentPane.add(scrollPane);

        String[] columns = {"Mã Sách", "Tên Sách", "Thể Loại", "Số Lượng", "Ngày XB", "NXB", "Tác Giả", "Giá Tiền", "Vị Trí"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);
                
        RoundedButton btnlichsu = new RoundedButton("LỊCH SỬ", new Color(255, 204, 153), new Color(50, 50, 50), new Color(255, 182, 115), 20);
        ImageIcon historyIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\history.png");
        Image scaledHistory = historyIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnlichsu.setIcon(new ImageIcon(scaledHistory));
        btnlichsu.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnlichsu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lichsusach lichsusach = new lichsusach();
                lichsusach.setVisible(true);
                dispose();
            }
        });
        btnlichsu.setBounds(962, 26, 109, 34);
        contentPane.add(btnlichsu);

        loadDataToTable();

        btnthem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleAddBook();
            }
        });

        btnsua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleUpdateBook();
            }
        });

        btnxoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleDeleteBook();
            }
        });

        btnlammoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearInputs();
            }
        });

        btntimkiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleSearchBook();
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow(); 
                if (row >= 0) {
                    txtmasach.setText(tableModel.getValueAt(row, 0).toString());
                    txttensach.setText(tableModel.getValueAt(row, 1).toString());
                    txttheloai.setText(tableModel.getValueAt(row, 2).toString());
                    txtsoluong.setText(tableModel.getValueAt(row, 3).toString());
                    try {
                        spngayxb.setValue(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(tableModel.getValueAt(row, 4).toString()));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    txtnxb.setText(tableModel.getValueAt(row, 5).toString());
                    txttacgia.setText(tableModel.getValueAt(row, 6).toString());
                    txtgiatien.setText(tableModel.getValueAt(row, 7).toString());
                    txtvitri.setText(tableModel.getValueAt(row, 8).toString());
                }
            }
        });
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0); 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        for (Book book : bookcontroller.handleLoadAll()) {
            tableModel.addRow(new Object[]{
                book.getMaSach(),
                book.getTenSach(),
                book.getTheLoai(),
                book.getSoLuong(),
                sdf.format(book.getNgayXuatBan()),
                book.getNhaXuatBan(),
                book.getTacGia(),
                book.getGiaTien(),
                book.getViTri()
            });
        }
    }

    private void handleAddBook() {
        try {
            String maSach = txtmasach.getText().trim();
            String tenSach = txttensach.getText().trim();
            String theLoai = txttheloai.getText().trim();
            int soLuong = Integer.parseInt(txtsoluong.getText().trim());
            Date ngayXuatBan = (Date) spngayxb.getValue();
            String nhaXuatBan = txtnxb.getText().trim();
            String tacGia = txttacgia.getText().trim();
            double giaTien = Double.parseDouble(txtgiatien.getText().trim());
            String viTri = txtvitri.getText().trim();

            if (maSach.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mã sách không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if ( tenSach.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tên sách không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Book book = new Book(maSach, tenSach, theLoai, soLuong, ngayXuatBan, nhaXuatBan, tacGia, giaTien, viTri);
            if (bookcontroller.handleAdd(book)) {
                JOptionPane.showMessageDialog(this, "Thêm sách thành công!");
                loadDataToTable();
                clearInputs();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sách thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleUpdateBook() {
        try {
            String maSach = txtmasach.getText().trim();
            String tenSach = txttensach.getText().trim();
            String theLoai = txttheloai.getText().trim();
            int soLuong = Integer.parseInt(txtsoluong.getText().trim());
            Date ngayXuatBan = (Date) spngayxb.getValue();
            String nhaXuatBan = txtnxb.getText().trim();
            String tacGia = txttacgia.getText().trim();
            double giaTien = Double.parseDouble(txtgiatien.getText().trim());
            String viTri = txtvitri.getText().trim();

            if (maSach.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Lỗi Cập Nhật", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if ( tenSach.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Lỗi Cập Nhật", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Book book = new Book(maSach, tenSach, theLoai, soLuong, ngayXuatBan, nhaXuatBan, tacGia, giaTien, viTri);
            if (bookcontroller.handleUpdate(book)) {
                JOptionPane.showMessageDialog(this, "Cập nhật sách thành công!");
                loadDataToTable();
                clearInputs();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật sách thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleDeleteBook() {
        String maSach = txtmasach.getText().trim();
        if (maSach.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sách này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (bookcontroller.handleDelete(maSach)) {
                JOptionPane.showMessageDialog(this, "Xóa sách thành công!");
                loadDataToTable();
                clearInputs();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa sách thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void handleSearchBook() {
        String keyword = txttimkiem.getText().trim();
        tableModel.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        for (Book book : bookcontroller.handleSearch(keyword)) {
            tableModel.addRow(new Object[]{
                book.getMaSach(),
                book.getTenSach(),
                book.getTheLoai(),
                book.getSoLuong(),
                sdf.format(book.getNgayXuatBan()),
                book.getNhaXuatBan(),
                book.getTacGia(),
                book.getGiaTien(),
                book.getViTri()
            });
        }
    }

    private void clearInputs() {
        txtmasach.setText("");
        txttensach.setText("");
        txttheloai.setText("");
        txtsoluong.setText("");
        spngayxb.setValue(new Date());
        txtnxb.setText("");
        txttacgia.setText("");
        txtgiatien.setText("");
        txtvitri.setText("");
        txttimkiem.setText("");
        loadDataToTable();
    }

	public static void updateBookQuantity(String maSach, int newQuantity) {
		// TODO Auto-generated method stub
		
	}
}