package Visao;

import Comunicacao.TCPCliente;
import Controladores.Jogador;
import Controladores.Time;
import Controladores.Transacao;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class App extends JFrame {
    private TCPCliente clientSocket;
    private JPanel mainPanel;
    private JTabbedPane Tables;
    private JPanel PropostasPanel;
    private JPanel JogadoresPanel;
    private JPanel MercadoPanel;
    private JPanel PerfilPanel;
    private JButton adicionarNovoJogadorButton;
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
    private JLabel BoasVindasLabel;
    private JLabel LoginLabel;

    private List<Jogador> jogadoresPesquisados;
    private Jogador jogadorEscolhido;

    public App(Time time){
        super("Escamball");

        clientSocket = new TCPCliente();
        fazerPropostaButton.setEnabled(false);
        recusarButton.setEnabled(false);
        aceitarButton.setEnabled(false);

        BoasVindasLabel.setText("Olá "+time.getNomeDono());
        LoginLabel.setText("Seu time é o: "+time.getLogin());

        Iterator<Jogador> it = time.getElenco().iterator();
        DefaultListModel model = new DefaultListModel();
        while(it.hasNext()){
            model.addElement(it.next().getNome());
        }
        Lista.setModel(model);
        revalidate();
        List<Transacao> transacoes = null;
        try {
            transacoes = clientSocket.ComunicaBuscaTransacoes(time);
            DefaultListModel modelPropostas = new DefaultListModel();
            for (Transacao t: transacoes){
                if(t.getGrupoReceptor().getIdTime() == time.getIdTime()){
                    modelPropostas.addElement("Proposta: Jogador "+ t.getGrupoReceptor().getNome() + " por: "+ t.getGrupoCriador().getNome());
                }
            }
            listPropostas.setModel(modelPropostas);
            revalidate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        clientSocket = new TCPCliente();

        List<Transacao> finalTransacoes = transacoes;
        listPropostas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList)e.getSource();
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    Jogador jogadorEscolhido = finalTransacoes.get(index).getGrupoCriador();
                    InformacoesJogador info = new InformacoesJogador(jogadorEscolhido);
                    info.setSize(400,400);
                    info.setVisible(true);
                    recusarButton.setEnabled(true);
                    aceitarButton.setEnabled(true);
                }
            }
        });




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
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    Jogador jogadorEscolhido = time.getElenco().get(index);
                    InformacoesJogador info = new InformacoesJogador(jogadorEscolhido);
                    info.setSize(400,400);
                    info.setVisible(true);
                }
            }
        });

        pesquisaButton.addActionListener(e -> {
            if(pesquisaJogadorField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Preencha a pesquisa.");
            }
            else{
                try {
                    jogadoresPesquisados = new ArrayList<Jogador>(clientSocket.ComunicaPesquisaJogador(pesquisaJogadorField.getText()));
                    DefaultListModel modelPesquisa = new DefaultListModel();
                    for(Jogador j : jogadoresPesquisados){
                        if(j.getIdTime() != time.getIdTime()){
                            modelPesquisa.addElement("Jogador: "+j.getNome() + " - Preço: "+ j.getPreco());
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

        pesquisaButton1.addActionListener(e -> {
            String saidaCombobox = null;
            if(comboBox1.getSelectedItem().equals("Goleiro")){
                saidaCombobox = "goleiro";
            }else if(comboBox1.getSelectedItem().equals("Defensor")){
                saidaCombobox = "zagueiro";
            }else if(comboBox1.getSelectedItem().equals("Meio")){
                saidaCombobox = "meio_campo";
            }else if(comboBox1.getSelectedItem().equals("Atacante")){
                saidaCombobox = "atacante";
            }
            try {
                jogadoresPesquisados = new ArrayList<Jogador>(clientSocket.ComunicaPesquisaPosicao(saidaCombobox));
                DefaultListModel modelPesquisa = new DefaultListModel();
                for(Jogador j : jogadoresPesquisados){
                    if(j.getIdTime() != time.getIdTime()){
                        modelPesquisa.addElement("Jogador: "+j.getNome() + " - Preço: "+ j.getPreco());
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
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList)e.getSource();
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    jogadorEscolhido = jogadoresPesquisados.get(index);
                    fazerPropostaButton.setEnabled(true);
                }
            }
        });

        fazerPropostaButton.addActionListener(e -> {
            final JComboBox comboBox = new JComboBox<>();

            for( Jogador j : time.getElenco()){
                comboBox.addItem(j.getNome());
            }

            JOptionPane jop = new JOptionPane(comboBox, JOptionPane.QUESTION_MESSAGE,
                    JOptionPane.OK_CANCEL_OPTION);
            JDialog dialog = jop.createDialog("Jogador oferecido:");
            dialog.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentShown(ComponentEvent e) {
                    SwingUtilities.invokeLater(comboBox::requestFocusInWindow);
                }
            });
            dialog.setVisible(true);
            int result = (Integer) jop.getValue();
            dialog.dispose();

            if(result == JOptionPane.OK_OPTION){
                Jogador jogadorOferecido = time.getElenco().get(comboBox.getSelectedIndex());
                Transacao transacao = new Transacao(jogadorOferecido.getIdTime(), jogadorEscolhido.getIdTime(), jogadorOferecido, jogadorEscolhido);
                try {
                    clientSocket = new TCPCliente();
                    Transacao transacaoRecebida = clientSocket.ComunicaTransacao(transacao);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
    }

}
