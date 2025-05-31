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
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;
import controller.taiKhoanController; // Import controller
import model.Taikhoan; // Import model
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class quanlytaikhoan extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtgmail;
    private JTextField txtmatkhau;
    private JTextField txttimkiem;
    private JTable table;

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
                    quanlytaikhoan frame = new quanlytaikhoan();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public quanlytaikhoan() {
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
        panel_3_2_1_1_1_1_2.setBackground(new Color(192, 192, 192));
        panel_3_2_1_1_1_1_2.setBounds(0, 363, 203, 37);
        panel_2.add(panel_3_2_1_1_1_1_2);

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
        panel.setBounds(202, 0, 895, 71);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblQunLTi = new JLabel("QUẢN LÝ TÀI KHOẢN");
        lblQunLTi.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblQunLTi.setBounds(350, 11, 203, 49);
        panel.add(lblQunLTi);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(248, 81, 812, 162);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1_1 = new JLabel("Gmail");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel_1_1.setBounds(41, 30, 48, 24);
        panel_1.add(lblNewLabel_1_1);

        txtgmail = new JTextField();
        txtgmail.setText((String) null);
        txtgmail.setColumns(10);
        txtgmail.setBounds(136, 33, 175, 22);
        panel_1.add(txtgmail);

        JLabel lblNewLabel_1_2 = new JLabel("Mật Khẩu");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel_1_2.setBounds(41, 102, 76, 24);
        panel_1.add(lblNewLabel_1_2);

        txtmatkhau = new JTextField();
        txtmatkhau.setText((String) null);
        txtmatkhau.setColumns(10);
        txtmatkhau.setBounds(136, 105, 175, 22);
        panel_1.add(txtmatkhau);

        RoundedButton btnthem = new RoundedButton("THÊM", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        ImageIcon addIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\add.png");
        Image scaledAdd = addIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnthem.setIcon(new ImageIcon(scaledAdd));
        btnthem.setForeground(Color.WHITE);
        btnthem.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnthem.setBounds(406, 102, 121, 36);
        panel_1.add(btnthem);

        RoundedButton btnxoa = new RoundedButton("XÓA", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        ImageIcon deleteIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\delete.png");
        Image scaledDelete = deleteIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnxoa.setIcon(new ImageIcon(scaledDelete));
        btnxoa.setForeground(Color.WHITE);
        btnxoa.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnxoa.setBounds(537, 102, 125, 36);
        panel_1.add(btnxoa);

        RoundedButton btnlammoi = new RoundedButton("LÀM MỚI", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        ImageIcon refreshIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\updating.png");
        Image scaledRefresh = refreshIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnlammoi.setIcon(new ImageIcon(scaledRefresh));
        btnlammoi.setForeground(Color.WHITE);
        btnlammoi.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnlammoi.setBounds(672, 102, 130, 36);
        panel_1.add(btnlammoi);

        RoundedButton btntimkiem = new RoundedButton("", new Color(135, 206, 250), new Color(135, 206, 250), new Color(173, 216, 255), 20);
        ImageIcon searchIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\seach.png");
        Image scaledSearch = searchIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btntimkiem.setIcon(new ImageIcon(scaledSearch));
        btntimkiem.setBounds(431, 30, 89, 36);
        panel_1.add(btntimkiem);

        txttimkiem = new JTextField();
        txttimkiem.setColumns(10);
        txttimkiem.setBounds(544, 32, 197, 31);
        panel_1.add(txttimkiem);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(248, 254, 812, 412);
        contentPane.add(scrollPane);

        // Initialize JTable with DefaultTableModel
        String[] columnNames = {"ID", "Gmail", "Mật Khẩu"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);

        // Load initial data
        loadTableData();

        btnthem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtgmail.getText().trim();
                String password = txtmatkhau.getText().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ email và mật khẩu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

              
                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
                if (!email.matches(emailRegex)) {
                    JOptionPane.showMessageDialog(null, "Email không hợp lệ! Vui lòng nhập email đúng định dạng (ví dụ: example@domain.com).", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Taikhoan tk = new Taikhoan(0, email, password);
                boolean result = taiKhoanController.handleAdd(tk);
                if (result) {
                    JOptionPane.showMessageDialog(null, "Thêm tài khoản thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm tài khoản thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }

                // Refresh table and clear inputs
                loadTableData();
                clearInputs();
            }
        });

        btnxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một tài khoản để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int id = (int) tableModel.getValueAt(selectedRow, 0);
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa tài khoản này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    boolean result = taiKhoanController.handleDelete(id);
                    if (result) {
                        JOptionPane.showMessageDialog(null, "Xóa tài khoản thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                        taiKhoanController.handleResetAutoIncrement(); // Reset auto-increment after deletion
                        loadTableData();
                        clearInputs();
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa tài khoản thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

      
        btnlammoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearInputs();
                loadTableData();
            }
        });

        // Add action listener for "Tìm kiếm" button
        btntimkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = txttimkiem.getText().trim();
                List<Taikhoan> result = taiKhoanController.handleSearch(keyword);
                updateTable(result);
            }
        });

        // Add selection listener for table
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                    int selectedRow = table.getSelectedRow();
                    
                    txtgmail.setText((String) tableModel.getValueAt(selectedRow, 1));
                    txtmatkhau.setText((String) tableModel.getValueAt(selectedRow, 2));
                }
            }
        });
    }

    // Method to load all accounts into the table
    private void loadTableData() {
        List<Taikhoan> accounts = taiKhoanController.handleLoadAll();
        updateTable(accounts);
    }

    // Method to update table with list of accounts
    private void updateTable(List<Taikhoan> accounts) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0); // Clear existing rows
        for (Taikhoan tk : accounts) {
            Object[] row = {tk.getId(), tk.getEmail(), tk.getPassword()};
            tableModel.addRow(row);
        }
    }

    // Method to clear input fields
    private void clearInputs() {
       
        txtgmail.setText("");
        txtmatkhau.setText("");
        txttimkiem.setText("");
    }
}