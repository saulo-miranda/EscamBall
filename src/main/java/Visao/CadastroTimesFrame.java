package main.java.Visao;


import main.java.Communication.EscamballService;
import main.java.Models.TimeModel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CadastroTimesFrame extends JFrame {
    private JPanel mainPanel;
    private JTextField nomeField;
    private JTextField nomeTimeField;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton cadastrarButton;
    private JButton jaPossuoUmaContaButton;

    public CadastroTimesFrame(EscamballService client) {
        ImageCSS();
        setTitle("Escamball - Cadastro");
        setSize(400, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        cadastrarButton.addActionListener(e -> {
            if (!camposPreenchidos()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            } else if (!confirmacaoSenha()) {
                JOptionPane.showMessageDialog(null, "As senhas diferem!");
            } else {
                String nome = nomeField.getText();
                String nomeTime = nomeTimeField.getText();
                String login = loginField.getText();
                String senha = new String(passwordField.getPassword());

                TimeModel time = new TimeModel();

                try {
                    time = client.CadastroTime(nome, nomeTime, login, senha);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if (time!=null) {
                    dispose();
                    AppFrame app = new AppFrame(time.getTimeId(), client);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Informações de time já cadastradas");
                }
            }

        });

        jaPossuoUmaContaButton.addActionListener(e -> {
            dispose();
            LoginFrame login = new LoginFrame(client);
        });
    }

    private boolean camposPreenchidos() {
        String nome = nomeField.getText();
        String nomeTime = nomeTimeField.getText();
        String login = loginField.getText();
        String senha = new String(passwordField.getPassword());
        String confirmaSenha = new String(confirmPasswordField.getPassword());
        if (nome.equals("") || nomeTime.equals("") || login.equals("") || senha.equals("") || confirmaSenha.equals("")) {
            return false;
        }
        return true;
    }

    private boolean confirmacaoSenha() {
        String senha = new String(passwordField.getPassword());
        String confirmaSenha = new String(confirmPasswordField.getPassword());
        if (!senha.equals(confirmaSenha)) {
            return false;
        }
        return true;
    }

    public void ImageCSS() {
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        mainPanel.setOpaque(false);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("src/main/java/Visao/Assets/Estadio.jpg")));
        setLayout(new FlowLayout());
        add(mainPanel);
    }

}
