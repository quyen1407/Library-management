package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AuthController;
import controller.admincontroller;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingUtilities;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtemail;
    private JPasswordField txtmatkhau;
    private boolean isEmailPlaceholder = true;
    private boolean isPasswordPlaceholder = true;

    // Lớp RoundedButton để tạo nút bo góc
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

            // Thêm MouseListener để theo dõi hover
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

            // Xác định màu nền dựa trên trạng thái
            Color currentColor = backgroundColor;
            if (getModel().isPressed() || isMouseOver) {
                currentColor = hoverClickColor;
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
                login frame = new login();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 944, 564);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // JLabel chứa ảnh
        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setBounds(-46, -20, 188, 150);
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\login\\assets\\images\\main_top.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
        lblNewLabel.setIcon(new ImageIcon(scaledImage));
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\icon\\login.png"));
        lblNewLabel_1.setBounds(152, 128, 360, 303);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("ĐĂNG NHẬP");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(254, 64, 158, 41);
        contentPane.add(lblNewLabel_1_1);

        // Icon cho Email
        JLabel lblEmailIcon = new JLabel();
        ImageIcon emailIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\icon\\email.png");
        Image scaledEmailIcon = emailIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lblEmailIcon.setIcon(new ImageIcon(scaledEmailIcon));
        lblEmailIcon.setBounds(550, 173, 20, 35);
        contentPane.add(lblEmailIcon);

        // Trường nhập Email
        txtemail = new JTextField();
        txtemail.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        txtemail.setBackground(new Color(220, 220, 220));
        txtemail.setForeground(Color.GRAY);
        txtemail.setText("Email của bạn");
        txtemail.setBounds(575, 173, 315, 35);
        txtemail.setColumns(10);
        txtemail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (isEmailPlaceholder) {
                    txtemail.setText("");
                    txtemail.setForeground(Color.BLACK);
                    isEmailPlaceholder = false;
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtemail.getText().isEmpty()) {
                    txtemail.setText("Email của bạn");
                    txtemail.setForeground(Color.GRAY);
                    isEmailPlaceholder = true;
                }
            }
        });
        contentPane.add(txtemail);

        // Icon cho Mật khẩu
        JLabel lblPasswordIcon = new JLabel();
        ImageIcon passwordIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\icon\\password.png");
        Image scaledPasswordIcon = passwordIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lblPasswordIcon.setIcon(new ImageIcon(scaledPasswordIcon));
        lblPasswordIcon.setBounds(550, 238, 20, 35);
        contentPane.add(lblPasswordIcon);

        // Trường nhập Mật khẩu
        txtmatkhau = new JPasswordField();
        txtmatkhau.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        txtmatkhau.setBackground(new Color(220, 220, 220));
        txtmatkhau.setForeground(Color.GRAY);
        txtmatkhau.setText("Mật khẩu của bạn");
        txtmatkhau.setBounds(575, 238, 315, 35);
        txtmatkhau.setColumns(10);
        txtmatkhau.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (isPasswordPlaceholder) {
                    txtmatkhau.setText("");
                    txtmatkhau.setForeground(Color.BLACK);
                    isPasswordPlaceholder = false;
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(txtmatkhau.getPassword()).isEmpty()) {
                    txtmatkhau.setText("Mật khẩu của bạn");
                    txtmatkhau.setForeground(Color.GRAY);
                    isPasswordPlaceholder = true;
                }
            }
        });
        contentPane.add(txtmatkhau);

        // Checkbox để xem mật khẩu
        JCheckBox chckbxShowPassword = new JCheckBox("Hiển thị mật khẩu");
        chckbxShowPassword.setBackground(new Color(255, 255, 255));
        chckbxShowPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
        chckbxShowPassword.setForeground(new Color(0, 0, 0));
        chckbxShowPassword.setBounds(575, 280, 150, 23);
        chckbxShowPassword.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtmatkhau.setEchoChar((char)0); // Hiển thị mật khẩu rõ ràng
                } else {
                    txtmatkhau.setEchoChar('•'); // Ẩn mật khẩu bằng dấu •
                }
            }
        });
        contentPane.add(chckbxShowPassword);

        // Nút Đăng Nhập với hiệu ứng bo góc
        RoundedButton btndangnhap = new RoundedButton(
            "ĐĂNG NHẬP",
            new Color(128, 0, 255), // Màu nền mặc định
            new Color(128, 0, 255), // Màu viền
            new Color(153, 51, 255), // Màu khi hover/click
            40 // Bán kính bo góc
        );
        btndangnhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                String user = txtemail.getText().trim();
                String pass = new String(txtmatkhau.getPassword()).trim();

                // Kiểm tra placeholder
                if (isEmailPlaceholder) {
                    user = "";
                   
                }
                if (isPasswordPlaceholder) {
                    pass = "";
                  
                }
                System.out.println("Email: '" + user + "', Password: '" + pass + "'");
                // Kiểm tra dữ liệu rỗng
                if (user.isEmpty() && pass.isEmpty()) {
                    
                    JOptionPane.showMessageDialog(null, "Email và mật khẩu không được bỏ trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                } else if (user.isEmpty()) {
                    
                    JOptionPane.showMessageDialog(null, "Email không được bỏ trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                } else if (pass.isEmpty()) {
                   
                    JOptionPane.showMessageDialog(null, "Mật khẩu không được bỏ trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!user.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    
                    JOptionPane.showMessageDialog(null, "Email không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Thử đăng nhập với tư cách quản trị viên trước
                try {
         
                    boolean successAdmin = admincontroller.handleLoginadmin(user, pass);
                    if (successAdmin) {
                        
                        JOptionPane.showMessageDialog(null, "Đăng nhập quản trị viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        menuadmin menu = new menuadmin();
                        menu.setVisible(true);
                        dispose();
                        return;
                    }
                } catch (Exception ex) {
                   
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Lỗi khi đăng nhập quản trị viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }

                // Nếu không phải quản trị viên, thử đăng nhập với tư cách người dùng
                try {
                    
                    boolean successUser = AuthController.handleLogin(user, pass);
                    if (successUser) {
                       
                        JOptionPane.showMessageDialog(null, "Đăng nhập người dùng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        menuuser menu = new menuuser();
                        menu.setVisible(true);
                        dispose();
                    } else {
                       
                        JOptionPane.showMessageDialog(null, "Mật khẩu không đúng!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                   
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Lỗi khi đăng nhập người dùng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btndangnhap.setForeground(Color.WHITE);
        btndangnhap.setFont(new Font("Tahoma", Font.BOLD, 14));
        btndangnhap.setBounds(558, 320, 348, 41);
        contentPane.add(btndangnhap);

        // Nhãn "Bạn chưa có tài khoản?" và "Đăng Ký"
        JLabel lblNewLabel_2 = new JLabel("Bạn chưa có tài khoản?");
        lblNewLabel_2.setForeground(new Color(128, 0, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(627, 373, 132, 14);
        contentPane.add(lblNewLabel_2);

        JLabel lbldangky = new JLabel("Đăng Ký");
        lbldangky.setForeground(new Color(128, 0, 255));
        lbldangky.setFont(new Font("Tahoma", Font.BOLD, 12));
        lbldangky.setBounds(762, 373, 88, 14);
        lbldangky.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                register loginFrame = new register();
                loginFrame.setVisible(true);
                dispose();
            }
        });
        contentPane.add(lbldangky);

        // Quản lý tiêu điểm
        SwingUtilities.invokeLater(() -> {
            contentPane.requestFocusInWindow();
            txtemail.setFocusable(true);
            txtmatkhau.setFocusable(true);
        });
    }
}