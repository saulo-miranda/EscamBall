package main.java.Visao;

import main.java.Communication.EscamballService;
import main.java.Models.TimeModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

public class LoginFrame extends JFrame {
    private JPanel mainPanel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton entrarButton;
    private JButton criarContaButton;

    public LoginFrame(EscamballService client) {
        this.ImageCSS();
        setTitle("Escamball - Login");
        setSize(400, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        criarContaButton.addActionListener(e -> {
            dispose();
            CadastroTimesFrame cadastro = new CadastroTimesFrame(client);
        });
        entrarButton.addActionListener(e -> {
            if (camposPreenchidos()) {
                String username = loginField.getText();
                String password = new String(passwordField.getPassword());

                TimeModel time = new TimeModel();

                try {
                    time = client.RealizaLogin(username, password);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if (time != null) {
                    dispose();
                    AppFrame app = new AppFrame(time.getTimeId(), client);
                } else {
                    JOptionPane.showMessageDialog(null, "Equipe não encontrada!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha os campos primeiro.");
            }
        });
    }

    private boolean camposPreenchidos() {
        if (loginField.getText().equals("") || loginField.getText().equals("Login")) {
            return false;
        }
        if (new String(passwordField.getPassword()).equals("") || new String(passwordField.getPassword()).equals("Senha")) {
            return false;
        }
        return true;
    }

    private void getPlaceholders(JTextField text) {
        String temp = text.getText();
        text.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                text.setText("");
                text.setForeground(Color.BLACK);

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (text.getText().isEmpty()) {
                    text.setForeground(Color.GRAY);
                    text.setText(temp);
                }
            }
        });
    }

    private void placeholderPassword(JPasswordField password) {
        password.setEchoChar((char) 0);
        String pass = String.valueOf(password.getPassword());
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                password.setText("");
                password.setEchoChar('\u2022');
                password.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                String temp = String.valueOf(password.getPassword());
                if (temp.isEmpty() || temp.equals(pass)) {
                    password.setText(pass);
                    password.setEchoChar((char) 0);
                    password.setForeground(Color.GRAY);
                }
            }
        });

    }

    public void ImageCSS() {
        mainPanel.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0));
        mainPanel.setOpaque(false);
        mainPanel.setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("src/main/java/Visao/Assets/Estadio.jpg")));
        setLayout(new FlowLayout());
        add(mainPanel);
        ButtonsCSS();
    }

    public void ButtonsCSS() {
        entrarButton.setOpaque(false);
        entrarButton.setContentAreaFilled(false);
        entrarButton.setBorderPainted(false);

        criarContaButton.setOpaque(false);
        criarContaButton.setContentAreaFilled(false);
        criarContaButton.setBorderPainted(false);

        loginField.setText("Login");
        passwordField.setText("Senha");

        this.getPlaceholders(loginField);
        this.placeholderPassword(passwordField);
    }

}
