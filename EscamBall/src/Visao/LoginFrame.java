package Visao;

import Controladores.Time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.security.NoSuchAlgorithmException;

public class LoginFrame extends JFrame {
    private JPanel mainPanel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton entrarButton;
    private JButton criarContaButton;
    private JLabel labelTest;

    public LoginFrame(){
        this.ImageCSS(); /*Caso queira usar um background com imagem, descomente esta linha e comente a seguinte*/
        //this.ContentCSS();
        setTitle("Escamball - Login");
        setSize(400,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        criarContaButton.addActionListener(e->{
            dispose();
            CadastroTimesFrame cadastro = new CadastroTimesFrame();
        });
        entrarButton.addActionListener(e->{
            dispose();
            AppFrame app = new AppFrame();
        });
    }

    private void getPlaceholders(JTextField text) {
        String temp = text.getText();
        text.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                text.setText("");
                text.setForeground(Color.WHITE);

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
    private void placeholderPassword(JPasswordField password){
        password.setEchoChar((char)0);
        String pass = String.valueOf(password.getPassword());
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                password.setText("");
                password.setEchoChar('\u2022');
                password.setForeground(Color.WHITE);
            }
            @Override
            public void focusLost(FocusEvent e) {
                String temp = String.valueOf(password.getPassword());
                if (temp.isEmpty()||temp.equals(pass)) {
                    password.setText(pass);
                    password.setEchoChar((char)0);
                    password.setForeground(Color.GRAY);
                }
            }
        });

    }

    public void ImageCSS(){

        mainPanel.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0));
        mainPanel.setOpaque(false);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("EscamBall/src/Visao/Assets/Estadio.jpg")));
        setLayout(new FlowLayout());
        add(mainPanel);
        ButtonsCSS();
    }
    public void ContentCSS(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        mainPanel.setBackground(Color.DARK_GRAY);
        ButtonsCSS();
        setContentPane(mainPanel);
    }

    public void ButtonsCSS(){
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
