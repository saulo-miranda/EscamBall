package main.java.Visao;

import main.java.Communication.GrpcClient;
import main.java.Models.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class AppFrame extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane content;
    private JPanel inicioPanel;
    private JPanel jogadoresPanel;
    private JPanel ofertasPanel;
    private JPanel mercadoPanel;
    private JLabel imageLabel;
    private JLabel timeDonoLabel;
    private JLabel bemVindoLabel;
    private JButton sairButton;
    private JTable tableJogadores;
    private JLabel jogadoresLabel;
    private JScrollPane tabelaScrollPane;
    private JButton adicionaJogador;
    private JList<String> ofertasList;
    private JTextField textField1;
    private JButton pesquisaButton;
    private JComboBox comboBox1;
    private JButton pesquisaButton1;
    private JList list1;
    private JButton fazerPropostaButton;
    private final TimeModel time;
    private List<TransacaoModel> transacaoList=new ArrayList<>();
    private List<JogadorModel> jogadoresPesquisa = new ArrayList<>();
    private JogadorModel jogadorDesejado;

    public AppFrame(int idTime, GrpcClient client) {
        setContentPane(mainPanel);
        setTitle("Escamball");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);


        time = getInformacoes(idTime, client);
        client.BuscaListaDeTransacoes(idTime);
        transacaoList = client.getTransacoes();
        if(transacaoList != null){
            for(TransacaoModel t : transacaoList){
                System.out.println("\n\n\n\nLISTA TRANSFERÊNCIAS -> "+t.getIdTimeProposta());
            }
        }
        SetInformacoes(time, transacaoList);
        fazerPropostaButton.setEnabled(false);

        sairButton.addActionListener(e -> {
            dispose();
            LoginFrame login = new LoginFrame(new GrpcClient(3403));
        });

        adicionaJogador.addActionListener(e -> {
            dispose();
            CadastroJogador cj = new CadastroJogador(idTime, client);
        });

        tableJogadores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable table = (JTable) e.getSource();
                if (e.getClickCount() == 2) {
                    int index = table.getSelectedRow();
                    JogadorModel j = time.getElenco().get(index);
                    InformacoesJogador info = new InformacoesJogador(j);
                }
            }
        });
        ofertasList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList) e.getSource();
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    TransacaoModel tr = transacaoList.get(index);
                    dispose();
                    InfosTransacao info = new InfosTransacao(idTime, tr.getIdTransacao(), client);
                }
            }
        });

        pesquisaButton.addActionListener(e -> {
            String nomePesquisado = textField1.getText();
            if(!nomePesquisado.equals("")){
                client.BuscaJogadoresPeloNome(nomePesquisado);
                jogadoresPesquisa = new ArrayList<>();
                for(JogadorModel j : client.getJogadores()){
                    if(j.getIdTime()!=idTime){
                        jogadoresPesquisa.add(j);
                    }
                }
                listaPesquisa(idTime, jogadoresPesquisa);
            }
        });
        pesquisaButton1.addActionListener(e -> {
            String posicaoPesquisada = (String) comboBox1.getSelectedItem();
            client.BuscaJogadorPelaPosicao(posicaoPesquisada);
            jogadoresPesquisa = new ArrayList<>();
            for(JogadorModel j : client.getJogadores()){
                if(j.getIdTime()!=idTime){
                    jogadoresPesquisa.add(j);
                }
            }
            listaPesquisa(idTime, jogadoresPesquisa);
        });
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList)e.getSource();
                if(e.getClickCount()==2){
                    fazerPropostaButton.setEnabled(true);
                    int i = list.locationToIndex(e.getPoint());
                    jogadorDesejado = jogadoresPesquisa.get(i);
                }
            }
        });
        fazerPropostaButton.addActionListener(e->{
            if(time.getElenco()!=null){
                final JComboBox comboBox = new JComboBox<>();
                for( JogadorModel j : time.getElenco()){
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
                    JogadorModel jogadorProposto = time.getElenco().get(comboBox.getSelectedIndex());
                    client.CadastroTransacao(idTime, jogadorDesejado.getIdTime(), jogadorProposto.getIdJogador(), jogadorDesejado.getIdJogador());
                }
            }
        });

    }

    private void listaPesquisa(int idTime, List<JogadorModel> lista){
        DefaultListModel<String> listaPesquisa = new DefaultListModel<>();
        for(JogadorModel j : lista){
            if(j.getIdTime()!=idTime){
                listaPesquisa.addElement(
                    "<html>" +
                        "<center>" +
                            "Jogador: " + j.getNome() +
                            "<br />" +
                            "Preço: " + j.getPreco() +
                            "<br />" +
                            "Geral: " + j.getPontos().getGeral() +
                            "<br />" +
                            "<hr>" +
                        "</center>" +
                    "</html>"
                );
            }
        }
        list1.setModel(listaPesquisa);
        revalidate();
    }

    private TimeModel getInformacoes(int idTime, GrpcClient client) {
        client.BuscaTimePeloId(idTime);
        TimeModel time = client.getTimeModel();
        client.ListaDeJogadoresTime(idTime);
        time.setElenco(client.getJogadores());
        return time;
    }

    private void SetInformacoes(TimeModel t, List<TransacaoModel> transacaoModelList) {
        InitialPage(t);
        JogadoresPage(t);
        PropostasPage(transacaoModelList);
    }

    private void InitialPage(TimeModel t) {
        String numeroJogadores = "0 jogadores";
        if (t.getElenco() != null) {
            numeroJogadores = (t.getElenco().size() + (t.getElenco().size() == 1 ? " jogador" : " jogadores"));
        }
        String formattedText =
                "<html>" +
                        "<center>" +
                        "Olá " + t.getNomeDono() + "!" +
                        "<br />" +
                        "Seu time é o " + t.getNomeTime() +
                        "<br />" +
                        "Atualmente, a equipe conta com " + numeroJogadores + " no elenco!" +
                        "</center>" +
                        "</html>";
        timeDonoLabel.setText(formattedText);
        try {
            BufferedImage img = ImageIO.read(new File("src/main/java/Visao/Assets/logoApp.png"));
            ImageIcon logo = new ImageIcon(img.getScaledInstance(70, 70, Image.SCALE_SMOOTH));
            imageLabel.setIcon(logo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void JogadoresPage(TimeModel t) {
        tableJogadores = TabelaJogadores(t);
        jogadoresPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        tabelaScrollPane = new JScrollPane(tableJogadores);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 2;
        c.gridy = 0;
        jogadoresPanel.add(jogadoresLabel, c);

        c.ipady = 100;
        c.ipadx = 700;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.0;
        c.gridwidth = 5;
        c.gridx = 0;
        c.gridy = 2;
        jogadoresPanel.add(tabelaScrollPane, c);

        c.ipady = 0;
        c.weightx = 0.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(10, 0, 0, 0);
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 2;
        jogadoresPanel.add(adicionaJogador, c);
    }

    private void PropostasPage(List<TransacaoModel> transacaoList) {
        DefaultListModel<String> modelPropostas = new DefaultListModel<>();
        if (transacaoList != null) {
            for (TransacaoModel tr : transacaoList) {
                modelPropostas.addElement(
                        "<html>" +
                                "<center>" +
                                "Proposta recebida" +
                                "<br />Jogador de interesse da outra equipe: <b>" + tr.getJogadorDesejado().getNome() + "</b>" +
                                "<br />Jogador oferecido: <b>" + tr.getJogadorProposto().getNome() + "</b>" +
                                "<hr>" +
                                "</center>" +
                                "</html>"
                );
            }
        }
        ofertasList.setModel(modelPropostas);
        revalidate();
    }
    private JTable TabelaJogadores(TimeModel t) {
        String[] colunas = {"Nome", "Posição", "Idade", "Geral"};
        Object[][] dados = new Object[0][4];
        if (t.getElenco() != null) {
            if (t.getElenco().size() > 0) {
                dados = new Object[t.getElenco().size()][4];
                for (int i = 0; i < t.getElenco().size(); i++) {
                    JogadorModel j = t.getElenco().get(i);
                    String posicao = j.getPosicao().isGoleiro() ?
                            "Goleiro" :
                            (j.getPosicao().isZagueiro() ?
                                    "Defensor" :
                                    (j.getPosicao().isMeioCampista() ?
                                            "Meia" :
                                            "Atacante"));
                    dados[i] = new Object[]{j.getNome(), posicao, j.getIdade(), j.getPontos().getGeral()};
                }
            }
        }

        return new JTable(dados, colunas) {
            @Serial
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

}
