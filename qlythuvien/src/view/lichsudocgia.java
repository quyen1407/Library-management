package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import model.DocGia;
import model.modelDocGia;

public class lichsudocgia extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txttimkiem;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTable detailTable;
    private DefaultTableModel detailTableModel;
    private modelDocGia model;

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

            addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    isMouseOver = true;
                    repaint();
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
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

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    lichsudocgia frame = new lichsudocgia();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public lichsudocgia() {
        model = new modelDocGia(); // Khởi tạo model

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 655);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBackground(new Color(255, 255, 204));
        panel.setBounds(10, 11, 914, 37);
        contentPane.add(panel);

        JLabel lblNewLabel = new JLabel("----------LỊCH SỬ ĐỘC GIẢ----------");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(330, 0, 308, 37);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(10, 59, 443, 461);
        contentPane.add(panel_1);

        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_2.setBounds(0, 0, 443, 42);
        panel_1.add(panel_2);

        JLabel lblNewLabel_1 = new JLabel("LỊCH SỬ");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(181, 0, 70, 42);
        panel_2.add(lblNewLabel_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(Color.WHITE);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBounds(0, 42, 443, 419);
        panel_1.add(scrollPane);

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[] {
            "Mã Độc Giả", "Họ Tên", "Giới Tính", "Ngày Sinh", "Địa Chỉ", "Email", "SĐT", "Ngày Làm Thẻ", "Ngày Hết Hạn"
        });
        table = new JTable(tableModel);
        table.setBackground(Color.WHITE);
        scrollPane.setViewportView(table);
        loadDataToTable();

        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String maDocGia = (String) tableModel.getValueAt(selectedRow, 0);
                    String hoTen = (String) tableModel.getValueAt(selectedRow, 1);
                    String gioiTinh = (String) tableModel.getValueAt(selectedRow, 2);
                    String ngaySinh = (String) tableModel.getValueAt(selectedRow, 3);
                    String diaChi = (String) tableModel.getValueAt(selectedRow, 4);
                    String email = (String) tableModel.getValueAt(selectedRow, 5);
                    String soDienThoai = (String) tableModel.getValueAt(selectedRow, 6);
                    String ngayLamThe = (String) tableModel.getValueAt(selectedRow, 7);
                    String ngayHetHan = (String) tableModel.getValueAt(selectedRow, 8);

                    detailTableModel.setRowCount(0);
                    detailTableModel.addRow(new Object[] {"Mã Độc Giả", maDocGia});
                    detailTableModel.addRow(new Object[] {"Họ Tên", hoTen});
                    detailTableModel.addRow(new Object[] {"Giới Tính", gioiTinh});
                    detailTableModel.addRow(new Object[] {"Ngày Sinh", ngaySinh});
                    detailTableModel.addRow(new Object[] {"Địa Chỉ", diaChi});
                    detailTableModel.addRow(new Object[] {"Email", email});
                    detailTableModel.addRow(new Object[] {"Số Điện Thoại", soDienThoai});
                    detailTableModel.addRow(new Object[] {"Ngày Làm Thẻ", ngayLamThe});
                    detailTableModel.addRow(new Object[] {"Ngày Hết Hạn", ngayHetHan});
                }
            }
        });

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setLayout(null);
        panel_1_1.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
        panel_1_1.setBackground(Color.WHITE);
        panel_1_1.setBounds(463, 59, 461, 461);
        contentPane.add(panel_1_1);

        JPanel panel_2_1 = new JPanel();
        panel_2_1.setLayout(null);
        panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_2_1.setBounds(0, 0, 461, 42);
        panel_1_1.add(panel_2_1);

        JLabel lblNewLabel_1_1 = new JLabel("CHI TIẾT");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(210, 0, 119, 42);
        panel_2_1.add(lblNewLabel_1_1);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBackground(Color.WHITE);
        scrollPane_1.getViewport().setBackground(Color.WHITE);
        scrollPane_1.setBounds(0, 42, 461, 419);
        panel_1_1.add(scrollPane_1);

        detailTableModel = new DefaultTableModel();
        detailTableModel.setColumnIdentifiers(new String[] {"Thông Tin", "Giá Trị"});
        detailTable = new JTable(detailTableModel);
        detailTable.setBackground(Color.WHITE);
        scrollPane_1.setViewportView(detailTable);

        txttimkiem = new JTextField();
        txttimkiem.setColumns(10);
        txttimkiem.setBounds(65, 547, 286, 32);
        contentPane.add(txttimkiem);

        // Rounded Button 1
        RoundedButton btntimkiem = new RoundedButton("TÌM KIẾM", new Color(135, 206, 250), new Color(135, 206, 250), new Color(173, 216, 255), 20);
        ImageIcon searchIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\seach.png");
        Image scaledSearch = searchIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btntimkiem.setIcon(new ImageIcon(scaledSearch));
        btntimkiem.setForeground(Color.BLACK);
        btntimkiem.setFont(new Font("Tahoma", Font.BOLD, 14));
        btntimkiem.setBounds(361, 545, 155, 37);
        btntimkiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleSearchDocGia();
            }
        });
        contentPane.add(btntimkiem);

        // Rounded Button 2
        RoundedButton btntrolai = new RoundedButton("TRỞ LẠI", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        ImageIcon backIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\back.png");
        Image scaledBack = backIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btntrolai.setIcon(new ImageIcon(scaledBack));
        btntrolai.setForeground(Color.BLACK);
        btntrolai.setFont(new Font("Tahoma", Font.BOLD, 14));
        btntrolai.setBounds(532, 545, 155, 37);
        btntrolai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quanlydocgia quanlydocgia = new quanlydocgia();
                quanlydocgia.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btntrolai);

        // Rounded Button 3
        RoundedButton btnlammoi = new RoundedButton("LÀM MỚI", new Color(255, 182, 193), new Color(255, 182, 193), new Color(255, 204, 153), 20);
        ImageIcon refreshIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\refresh.png");
        Image scaledRefresh = refreshIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnlammoi.setIcon(new ImageIcon(scaledRefresh));
        btnlammoi.setForeground(Color.BLACK);
        btnlammoi.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnlammoi.setBounds(701, 545, 155, 37);
        btnlammoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleRefresh();
            }
        });
        contentPane.add(btnlammoi);
    }

    private void handleSearchDocGia() {
        String keyword = txttimkiem.getText().trim();
        tableModel.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        for (DocGia dg : model.timKiem(keyword)) {
            tableModel.addRow(new Object[] {
                dg.getMaDocGia(),
                dg.getHoTen(),
                dg.getGioiTinh(),
                dg.getNgaySinh() != null ? sdf.format(dg.getNgaySinh()) : "",
                dg.getDiaChi(),
                dg.getEmail(),
                dg.getSoDienThoai(),
                dg.getNgayLamThe() != null ? sdf.format(dg.getNgayLamThe()) : "",
                dg.getNgayHetHan() != null ? sdf.format(dg.getNgayHetHan()) : ""
            });
        }
    }

    private void handleRefresh() {
        txttimkiem.setText("");
        tableModel.setRowCount(0);
        loadDataToTable();
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        for (DocGia dg : model.getAll()) {
            tableModel.addRow(new Object[] {
                dg.getMaDocGia(),
                dg.getHoTen(),
                dg.getGioiTinh(),
                dg.getNgaySinh() != null ? sdf.format(dg.getNgaySinh()) : "",
                dg.getDiaChi(),
                dg.getEmail(),
                dg.getSoDienThoai(),
                dg.getNgayLamThe() != null ? sdf.format(dg.getNgayLamThe()) : "",
                dg.getNgayHetHan() != null ? sdf.format(dg.getNgayHetHan()) : ""
            });
        }
    }
}