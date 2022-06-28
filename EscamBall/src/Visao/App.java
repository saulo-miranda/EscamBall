package Visao;

import Controladores.Time;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane Tables;
    private JPanel PropostasPanel;
    private JPanel JogadoresPanel;
    private JPanel MercadoPanel;
    private JPanel PerfilPanel;
    private JButton adicionarNovoJogadorButton;
    private JTextField textField1;
    private JButton trocarLoginButton;
    private JButton alterarASenhaButton;
    private JButton sairButton;

    public App(Time time){
        super("Escamball");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        adicionarNovoJogadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toBack();
                setVisible(false);
                CadastroJogador novoJogador = new CadastroJogador();
                novoJogador.setSize(800,600);
                novoJogador.setVisible(true);
                novoJogador.toFront();
            }
        });
        alterarASenhaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toBack();
                setVisible(false);
                TrocarSenha novaSenha = new TrocarSenha();
                novaSenha.setSize(800,600);
                novaSenha.setVisible(true);
                novaSenha.toFront();
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                dispose();
                EscamballAppGUI novoLogin = new EscamballAppGUI();
                novoLogin.setSize(800,600);
                novoLogin.setVisible(true);
                */
            }
        });
    }

}
