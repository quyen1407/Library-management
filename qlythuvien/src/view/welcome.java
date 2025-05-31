package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class welcome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    // Lớp RoundedButton tùy chỉnh để tạo nút bo góc
    static class RoundedButton extends JButton {
        private Color backgroundColor;
        private Color borderColor;
        private Color hoverClickColor; // Màu khi hover hoặc click
        private int radius;
        private boolean isMouseOver; // Trạng thái hover

        public RoundedButton(String text, Color backgroundColor, Color borderColor, Color hoverClickColor, int radius) {
            super(text);
            this.backgroundColor = backgroundColor;
            this.borderColor = borderColor;
            this.hoverClickColor = hoverClickColor;
            this.radius = radius;
            this.isMouseOver = false;
            setContentAreaFilled(false); // Tắt nền mặc định
            setFocusPainted(false); // Tắt viền focus mặc định
            setBorderPainted(false); // Tắt viền mặc định

            // Thêm MouseListener để theo dõi hover
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    isMouseOver = true;
                    repaint(); // Vẽ lại để cập nhật màu
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    isMouseOver = false;
                    repaint(); // Vẽ lại để cập nhật màu
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Xác định màu nền dựa trên trạng thái
            Color currentColor = backgroundColor;
            if (getModel().isPressed() || isMouseOver) {
                currentColor = hoverClickColor; // Màu khi hover hoặc click
            }

            // Vẽ nền bo góc
            g2.setColor(currentColor);
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

            // Vẽ viền bo góc
            g2.setColor(borderColor);
            g2.setStroke(new java.awt.BasicStroke(2));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

            // Vẽ văn bản
            super.paintComponent(g);

            g2.dispose();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                welcome frame = new welcome();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public welcome() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 944, 564);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

       
        JLabel lblImage = new JLabel();
        lblImage.setBounds(-34, -11, 188, 155);
        contentPane.add(lblImage);

        
        ImageIcon originalIcon = new ImageIcon(
            "C:\\Users\\quyen\\OneDrive\\Máy tính\\login\\assets\\images\\main_top.png"
        );
        Image scaledImg = originalIcon.getImage()
            .getScaledInstance(lblImage.getWidth(),
                               lblImage.getHeight(),
                               Image.SCALE_SMOOTH);
        lblImage.setIcon(new ImageIcon(scaledImg));

        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\icon\\chat.png"));
        lblNewLabel.setBounds(87, 78, 377, 425);
        contentPane.add(lblNewLabel);

        // Tạo nhãn "CHÀO MỪNG"
        JLabel lblNewLabel_1 = new JLabel("CHÀO MỪNG");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(251, 26, 158, 41);
        contentPane.add(lblNewLabel_1);

        // Tạo nút ĐĂNG NHẬP với border radius 20px
        RoundedButton btndangnhap = new RoundedButton(
            "ĐĂNG NHẬP",
            new Color(128, 0, 255), // Màu nền mặc định
            new Color(128, 0, 255), // Màu viền
            new Color(153, 51, 255), // Màu khi hover/click (tím sáng hơn)
            40 // Đường kính 40px = bán kính 20px
        );
        btndangnhap.setForeground(Color.WHITE);
        btndangnhap.setFont(new Font("Tahoma", Font.BOLD, 14));
        btndangnhap.addActionListener(e -> {
        	login loginFrame = new login();
            loginFrame.setVisible(true);
            dispose(); 
        });
        btndangnhap.setBounds(513, 209, 377, 48);
        contentPane.add(btndangnhap);

        // Tạo nút ĐĂNG KÝ với border radius 20px
        RoundedButton btndangky = new RoundedButton(
            "ĐĂNG KÝ",
            new Color(192, 192, 192), // Màu nền mặc định
            Color.GRAY, // Màu viền
            new Color(211, 211, 211), // Màu khi hover/click (xám sáng hơn)
            40 // Đường kính 40px = bán kính 20px
        );
        btndangky.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		register loginFrame = new register();
                loginFrame.setVisible(true);
                dispose(); 
        	}
        });
        btndangky.setForeground(Color.BLACK);
        btndangky.setFont(new Font("Tahoma", Font.BOLD, 14));
        btndangky.setBounds(513, 288, 377, 48);
        contentPane.add(btndangky);
    }
}