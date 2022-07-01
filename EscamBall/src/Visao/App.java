package Visao;

import Comunicacao.TCPCliente;
import Controladores.Jogador;
import Controladores.Time;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class App extends JFrame {
    private TCPCliente clientSocket;
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
    private JTextField pesquisaJogadorField;
    private JLabel PesquisaNome;
    private JButton pesquisaButton;
    private JComboBox comboBox1;
    private JButton pesquisaButton1;
    private JList list1;
    private JButton fazerPropostaButton;

    public App(Time time){
        super("Escamball");

        clientSocket = new TCPCliente();

        Iterator<Jogador> it = time.getElenco().iterator();
        DefaultListModel model = new DefaultListModel();
        while(it.hasNext()){
            model.addElement(it.next().getNome());
        }
        Lista.setModel(model);
        revalidate();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        adicionarNovoJogadorButton.addActionListener(e -> {
            toBack();
            setVisible(false);
            CadastroJogador novoJogador = new CadastroJogador(time, clientSocket);
            novoJogador.setSize(800,600);
            novoJogador.setVisible(true);
            novoJogador.toFront();
        });
        alterarASenhaButton.addActionListener(e -> {
            toBack();
            setVisible(false);
            TrocarSenha novaSenha = new TrocarSenha(clientSocket);
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
        Lista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList)e.getSource();
                if (e.getClickCount() == 1) {
                    int index = list.locationToIndex(e.getPoint());
                    System.out.println(index);
                }
            }
        });
        pesquisaButton.addActionListener(e -> {
            if(pesquisaJogadorField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Preencha a pesquisa.");
            }
            else{
                try {
                    List<Jogador> jogadores = clientSocket.ComunicaPesquisaJogador(pesquisaJogadorField.getText());
                    Iterator<Jogador> itJog = jogadores.iterator();
                    DefaultListModel modelPesquisa = new DefaultListModel();
                    while(itJog.hasNext()){
                        modelPesquisa.addElement(itJog.next().getNome());
                    }
                    list1.setModel(modelPesquisa);
                    revalidate();
                    clientSocket = new TCPCliente();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

}
