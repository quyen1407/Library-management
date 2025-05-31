package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
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
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.AuthController;

public class register extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtemail;
    private JPasswordField txtmatkhau;
    private static final String EMAIL_PLACEHOLDER = "Email của bạn";
    private static final String PASSWORD_PLACEHOLDER = "Mật khẩu của bạn";

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
        EventQueue.invokeLater(() -> {
            try {
                register frame = new register();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public register() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 944, 564);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setBounds(-46, -20, 188, 150);
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\login\\assets\\images\\main_top.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
        lblNewLabel.setIcon(new ImageIcon(scaledImage));
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\icon\\signup.png"));
        lblNewLabel_1.setBounds(167, 124, 340, 303);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("ĐĂNG KÝ");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(274, 72, 158, 41);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblEmailIcon = new JLabel();
        ImageIcon emailIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\icon\\email.png");
        Image scaledEmailIcon = emailIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lblEmailIcon.setIcon(new ImageIcon(scaledEmailIcon));
        lblEmailIcon.setBounds(510, 190, 20, 35);
        contentPane.add(lblEmailIcon);

        txtemail = new JTextField();
        txtemail.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        txtemail.setBackground(new Color(220, 220, 220));
        txtemail.setForeground(Color.GRAY);
        txtemail.setText(EMAIL_PLACEHOLDER);
        txtemail.setBounds(535, 190, 315, 35);
        txtemail.setColumns(10);
        txtemail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtemail.getText().equals(EMAIL_PLACEHOLDER)) {
                    txtemail.setText("");
                    txtemail.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtemail.getText().isEmpty()) {
                    txtemail.setText(EMAIL_PLACEHOLDER);
                    txtemail.setForeground(Color.GRAY);
                }
            }
        });
        contentPane.add(txtemail);

        JLabel lblPasswordIcon = new JLabel();
        ImageIcon passwordIcon = new ImageIcon("C:\\Users\\quyen\\OneDrive\\Máy tính\\icon\\password.png");
        Image scaledPasswordIcon = passwordIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lblPasswordIcon.setIcon(new ImageIcon(scaledPasswordIcon));
        lblPasswordIcon.setBounds(510, 255, 20, 35);
        contentPane.add(lblPasswordIcon);

        txtmatkhau = new JPasswordField();
        txtmatkhau.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        txtmatkhau.setBackground(new Color(220, 220, 220));
        txtmatkhau.setForeground(Color.GRAY);
        txtmatkhau.setText(PASSWORD_PLACEHOLDER);
        txtmatkhau.setBounds(535, 255, 315, 35);
        txtmatkhau.setColumns(10);
        txtmatkhau.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(txtmatkhau.getPassword()).equals(PASSWORD_PLACEHOLDER)) {
                    txtmatkhau.setText("");
                    txtmatkhau.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(txtmatkhau.getPassword()).isEmpty()) {
                    txtmatkhau.setText(PASSWORD_PLACEHOLDER);
                    txtmatkhau.setForeground(Color.GRAY);
                }
            }
        });
        contentPane.add(txtmatkhau);

        JCheckBox chckbxShowPassword = new JCheckBox("Hiển thị mật khẩu");
        chckbxShowPassword.setBackground(new Color(255, 255, 255));
        chckbxShowPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
        chckbxShowPassword.setForeground(new Color(0, 0, 0));
        chckbxShowPassword.setBounds(535, 300, 150, 23);
        chckbxShowPassword.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtmatkhau.setEchoChar((char)0);
                } else {
                    txtmatkhau.setEchoChar('•');
                }
            }
        });
        contentPane.add(chckbxShowPassword);

        RoundedButton btndangky = new RoundedButton(
            "ĐĂNG KÝ",
            new Color(128, 0, 255),
            new Color(128, 0, 255),
            new Color(153, 51, 255),
            40
        );
        btndangky.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = txtemail.getText().trim();
                String pass = new String(txtmatkhau.getPassword()).trim();

                // Xử lý placeholder
                if (user.equals(EMAIL_PLACEHOLDER)) {
                    user = "";
                }
                if (pass.equals(PASSWORD_PLACEHOLDER)) {
                    pass = "";
                }

                // Debug giá trị nhập vào
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

                // Kiểm tra định dạng email cơ bản
                if (!user.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    JOptionPane.showMessageDialog(null, "Email không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Gọi AuthController để đăng ký
                try {
                    boolean success = AuthController.handleRegister(user, pass);
                    System.out.println("Register result: " + success);
                    if (success) {
                        JOptionPane.showMessageDialog(null, "Đăng ký thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        // Chuyển về màn hình đăng nhập sau khi đăng ký thành công
                        login loginFrame = new login();
                        loginFrame.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Email đã tồn tại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    System.out.println("Error during registration: " + ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi đăng ký: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btndangky.setForeground(Color.WHITE);
        btndangky.setFont(new Font("Tahoma", Font.BOLD, 14));
        btndangky.setBounds(517, 340, 348, 41);
        contentPane.add(btndangky);

        JLabel lblNewLabel_2 = new JLabel("Bạn đã có tài khoản? ");
        lblNewLabel_2.setForeground(new Color(128, 0, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(591, 392, 125, 14);
        contentPane.add(lblNewLabel_2);

        SwingUtilities.invokeLater(() -> {
            txtemail.setFocusable(false);
            txtmatkhau.setFocusable(false);
            contentPane.requestFocusInWindow();
            txtemail.setFocusable(true);
            txtmatkhau.setFocusable(true);

            JLabel lbldangnhap = new JLabel("Đăng Nhập");
            lbldangnhap.setForeground(new Color(128, 0, 255));
            lbldangnhap.setFont(new Font("Tahoma", Font.BOLD, 12));
            lbldangnhap.setBounds(712, 392, 88, 14);
            lbldangnhap.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    login loginFrame = new login();
                    loginFrame.setVisible(true);
                    dispose();
                }
            });
            contentPane.add(lbldangnhap);
        });
    }
}