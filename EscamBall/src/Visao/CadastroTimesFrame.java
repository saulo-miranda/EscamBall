package Visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CadastroTimesFrame extends JFrame {
    private JPanel mainPanel;
    private JTextField nomeField;
    private JTextField nomeTimeField;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton cadastrarButton;
    private JButton jaPossuoUmaContaButton;

    public CadastroTimesFrame(){
        ImageCSS();
        setTitle("Escamball - Cadastro");
        setSize(400,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        jaPossuoUmaContaButton.addActionListener(e->{
            dispose();
            LoginFrame login = new LoginFrame();
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
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        mainPanel.setOpaque(false);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("EscamBall/src/Visao/Assets/Estadio.jpg")));
        setLayout(new FlowLayout());
        add(mainPanel);
        ButtonsCSS();
    }
    public void ButtonsCSS(){
        cadastrarButton.setOpaque(false);
        cadastrarButton.setContentAreaFilled(false);
        cadastrarButton.setBorderPainted(false);

        jaPossuoUmaContaButton.setOpaque(false);
        jaPossuoUmaContaButton.setContentAreaFilled(false);
        jaPossuoUmaContaButton.setBorderPainted(false);

        nomeField.setText("Seu nome");
        nomeTimeField.setText("Nome do seu time");
        loginField.setText("Login");

        passwordField.setText("Senha");
        confirmPasswordField.setText("Confirme a Senha");
        placeholderPassword(passwordField);
        placeholderPassword(confirmPasswordField);

        this.getPlaceholders(nomeField);
        this.getPlaceholders(nomeTimeField);
        this.getPlaceholders(loginField);

    }

}
