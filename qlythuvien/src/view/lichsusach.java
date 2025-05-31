package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.bookcontroller;
import model.Book;
import view.lichsudocgia.RoundedButton;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class lichsusach extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txttimkiem;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTable detailTable;
    private DefaultTableModel detailTableModel;

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
                    lichsusach frame = new lichsusach();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public lichsusach() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 655);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBackground(new Color(255, 255, 204));
        panel.setBounds(10, 11, 914, 37);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("----------LỊCH SỬ----------");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(362, 0, 218, 37);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
        panel_1.setBounds(10, 59, 443, 461);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 0, 443, 42);
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("LỊCH SỬ ");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(181, 0, 70, 42);
        panel_2.add(lblNewLabel_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 42, 443, 419);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.getViewport().setBackground(Color.WHITE);
        panel_1.add(scrollPane);

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[] {
            "Mã Sách", "Tên Sách", "Thể Loại", "Số Lượng", "Ngày XB", "NXB", "Tác Giả", "Giá Tiền", "Vị Trí"
        });
        table = new JTable(tableModel);
        table.setBackground(Color.WHITE);
        scrollPane.setViewportView(table);
        loadDataToTable();

        // Thêm listener để xử lý khi chọn dòng
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        // Lấy tất cả dữ liệu từ dòng được chọn
                        String maSach = (String) tableModel.getValueAt(selectedRow, 0); // Mã Sách
                        String tenSach = (String) tableModel.getValueAt(selectedRow, 1); // Tên Sách
                        String theLoai = (String) tableModel.getValueAt(selectedRow, 2); // Thể Loại
                        String soLuong = String.valueOf(tableModel.getValueAt(selectedRow, 3)); // Số Lượng
                        String ngayXB = (String) tableModel.getValueAt(selectedRow, 4); // Ngày XB
                        String nxb = (String) tableModel.getValueAt(selectedRow, 5); // NXB
                        String tacGia = (String) tableModel.getValueAt(selectedRow, 6); // Tác Giả
                        String giaTien = String.valueOf(tableModel.getValueAt(selectedRow, 7)); // Giá Tiền
                        String viTri = (String) tableModel.getValueAt(selectedRow, 8); // Vị Trí

                        // Cập nhật bảng chi tiết với dữ liệu theo hàng dọc
                        detailTableModel.setRowCount(0); // Xóa dữ liệu cũ
                        detailTableModel.addRow(new Object[] {"Ngày Nhập", ngayXB});
                        detailTableModel.addRow(new Object[] {"Tên Người Nhập", tenSach});
                        detailTableModel.addRow(new Object[] {"ID Người Nhập", maSach});
                        detailTableModel.addRow(new Object[] {"Mã Sản Phẩm", soLuong});
                        detailTableModel.addRow(new Object[] {"Tên Sản Phẩm", theLoai});
                        detailTableModel.addRow(new Object[] {"Loại Sản Phẩm", nxb});
                        detailTableModel.addRow(new Object[] {"Loại Sản Phẩm", tacGia});
                        detailTableModel.addRow(new Object[] {"Trạng Thái", viTri});
                        detailTableModel.addRow(new Object[] {"Giá", giaTien});
                        detailTableModel.addRow(new Object[] {"Số Lượng", "1"}); // Giả định giá trị "Số Lượng" = 1
                        detailTableModel.addRow(new Object[] {"Mã Nhà Phân Phối", "1"}); // Giả định giá trị "Mã Nhà Phân Phối" = 1
                    }
                }
            }
        });

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBackground(new Color(255, 255, 255));
        panel_1_1.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
        panel_1_1.setBounds(463, 59, 461, 461);
        contentPane.add(panel_1_1);
        panel_1_1.setLayout(null);

        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBounds(0, 0, 461, 42);
        panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1_1.add(panel_2_1);
        panel_2_1.setLayout(null);

        JLabel lblNewLabel_1_1 = new JLabel("CHI TIẾT");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(210, 0, 119, 42);
        panel_2_1.add(lblNewLabel_1_1);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 42, 461, 419);
        scrollPane_1.setBackground(Color.WHITE);
        scrollPane_1.getViewport().setBackground(Color.WHITE);
        panel_1_1.add(scrollPane_1);

        detailTableModel = new DefaultTableModel();
        detailTableModel.setColumnIdentifiers(new String[] {"Thông Tin", "Giá Trị"});
        detailTable = new JTable(detailTableModel);
        detailTable.setBackground(Color.WHITE);
        scrollPane_1.setViewportView(detailTable);

        txttimkiem = new JTextField();
        txttimkiem.setBounds(59, 547, 286, 32);
        contentPane.add(txttimkiem);
        txttimkiem.setColumns(10);

        RoundedButton btntimkiem = new RoundedButton("TÌM KIẾM", new Color(135, 206, 250), new Color(135, 206, 250), new Color(173, 216, 255), 20);
        ImageIcon searchIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\seach.png");
        Image scaledSearch = searchIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btntimkiem.setIcon(new ImageIcon(scaledSearch));
        btntimkiem.setForeground(Color.WHITE);
        btntimkiem.setFont(new Font("Tahoma", Font.BOLD, 14));
        btntimkiem.setBounds(361, 545, 155, 37);
        btntimkiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleSearchBook();
            }
        });
        btntimkiem.setFont(new Font("Tahoma", Font.BOLD, 14));
        btntimkiem.setBounds(365, 543, 155, 37);
        btntimkiem.setForeground(Color.BLACK);
        contentPane.add(btntimkiem);

        RoundedButton btntrolai = new RoundedButton("TRỞ LẠI", new Color(147, 112, 219), new Color(147, 112, 219), new Color(186, 152, 255), 20);
        ImageIcon backIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\iconmenu\\adminIcons\\back.png");
        Image scaledBack = backIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btntrolai.setIcon(new ImageIcon(scaledBack));
        btntrolai.setForeground(Color.WHITE);
        btntrolai.setFont(new Font("Tahoma", Font.BOLD, 14));
        btntrolai.setBounds(532, 545, 155, 37);
        btntrolai.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		  quanlysach quanlysach = new quanlysach();
        		  quanlysach.setVisible(true);
                  dispose();
        	}
        });
        btntrolai.setFont(new Font("Tahoma", Font.BOLD, 14));
        btntrolai.setBounds(537, 543, 155, 37);
        btntrolai.setForeground(Color.BLACK);
        contentPane.add(btntrolai);

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

    private void handleRefresh() {
        txttimkiem.setText(""); 
        tableModel.setRowCount(0); 
        loadDataToTable(); // Tải lại toàn bộ dữ liệu
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0); 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // Định dạng ngày và giờ
        for (Book book : bookcontroller.handleLoadAll()) { // Lấy danh sách sách
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
}