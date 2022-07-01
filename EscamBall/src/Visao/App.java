package Visao;

import Comunicacao.TCPCliente;
import Controladores.Jogador;
import Controladores.Time;
import Controladores.Transacao;

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
    private JList listPropostas;
    private JButton recusarButton;
    private JButton aceitarButton;
    private JTextField idDeseja;
    private JTextField idJogadorTime;

    public App(Time time){
        super("Escamball");

        clientSocket = new TCPCliente();

        Iterator<Jogador> it = time.getElenco().iterator();
        DefaultListModel model = new DefaultListModel();
        while(it.hasNext()){
            Jogador jogador = it.next();
            model.addElement(jogador.getNome() + " - "+ jogador.getIdJogador());
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
                        Jogador jogador = itJog.next();
                        if(jogador.getIdTime() != time.getIdTime()){
                            modelPesquisa.addElement(jogador.getNome() + " - "+ String.valueOf(jogador.getIdJogador()));
                        }
                    }
                    list1.setModel(modelPesquisa);
                    revalidate();
                    clientSocket = new TCPCliente();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        fazerPropostaButton.addActionListener(e -> {
            if(idDeseja.getText().equals("")|| idJogadorTime.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe os ids");
            }
            else{
                try {
                    int idJogador = Integer.valueOf(idDeseja.getText());
                    int idJogadorTime = Integer.valueOf(this.idJogadorTime.getText());
                    Jogador jogadorDesejado = clientSocket.ComunicaBuscaPorId(idJogador);
                    clientSocket = new TCPCliente();
                    Jogador jogadorOferecido = clientSocket.ComunicaBuscaPorId(idJogadorTime);
                    Transacao transacao = new Transacao(jogadorOferecido.getIdTime(), jogadorDesejado.getIdTime(), jogadorOferecido, jogadorDesejado);
                    clientSocket = new TCPCliente();
                    Transacao transacaoRecebida = clientSocket.ComunicaTransacao(transacao);
                    clientSocket = new TCPCliente();
                    System.out.println(transacaoRecebida.getCriador());
                    System.out.println(transacaoRecebida.getReceptor());
                    System.out.println("Jogador oferecido: " + transacao.getGrupoCriador().getNome());

                    System.out.println("Jogador desejado: " + transacao.getGrupoReceptor().getNome());


                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

}
