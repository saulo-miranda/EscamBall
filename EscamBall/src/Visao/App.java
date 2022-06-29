package Visao;

import Controladores.Jogador;
import Controladores.Time;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

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
    private JList Lista;

    public App(Time time){
        super("Escamball");
        System.out.println(time.getElenco().isEmpty());

        /*
        * TODO: Mostrar lista de jogadores
        * */

        if(!time.getElenco().isEmpty()){
            Iterator<Jogador> it = time.getElenco().iterator();
            List<String> nomesJogadores = new ArrayList<String>();
            while(it.hasNext()){
                nomesJogadores.add(it.next().getNome());
            }
            Lista = new JList(nomesJogadores.toArray());
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        adicionarNovoJogadorButton.addActionListener(e -> {
            toBack();
            setVisible(false);
            CadastroJogador novoJogador = new CadastroJogador(time);
            novoJogador.setSize(800,600);
            novoJogador.setVisible(true);
            novoJogador.toFront();
        });
        alterarASenhaButton.addActionListener(e -> {
            toBack();
            setVisible(false);
            TrocarSenha novaSenha = new TrocarSenha();
            novaSenha.setSize(800,600);
            novaSenha.setVisible(true);
            novaSenha.toFront();
        });
        sairButton.addActionListener(e -> {
            dispose();
            EscamballAppGUI novoLogin = new EscamballAppGUI();
            novoLogin.setSize(800,600);
            novoLogin.setVisible(true);
        });
    }

}
