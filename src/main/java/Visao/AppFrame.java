package main.java.Visao;


import main.java.Communication.EscamballService;
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
    private List<TransacaoModel> transacaoList;
    private List<JogadorModel> jogadoresPesquisa = new ArrayList<>();
    private JogadorModel jogadorDesejado;

    public AppFrame(int idTime, EscamballService client) {
        setContentPane(mainPanel);
        setTitle("Escamball");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);

        time = getInformacoes(idTime, client);
        try {

            transacaoList = new ArrayList<>();
            for(TransacaoModel t: client.BuscaListaDeTransacoes(idTime)){
                if(t.isTransacaoFinalizada()==false){
                    transacaoList.add(t);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SetInformacoes(time, transacaoList, client);
        fazerPropostaButton.setEnabled(false);

        sairButton.addActionListener(e -> {
            dispose();
            LoginFrame login = new LoginFrame(new EscamballService());
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
                    JogadorModel j = time.getJogadores().get(index);
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
                    InfosTransacao info = new InfosTransacao(idTime, tr.getTransacaoId(), client);

                }
            }
        });

        pesquisaButton.addActionListener(e -> {
            String nomePesquisado = textField1.getText();
            if(!nomePesquisado.equals("")){
                List<JogadorModel> jogadores;
                try {
                    jogadores = client.BuscaJogadoresPeloNome(nomePesquisado);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                jogadoresPesquisa = new ArrayList<>();
                for(JogadorModel j : jogadores){
                    if(j.getTime().getTimeId()!=idTime){
                        jogadoresPesquisa.add(j);
                    }
                }
                listaPesquisa(idTime, jogadoresPesquisa);
            }
        });
        pesquisaButton1.addActionListener(e -> {
            String posicaoPesquisada = (String) comboBox1.getSelectedItem();

            List<JogadorModel> jogadores;
            try {
                jogadores = client.BuscaJogadorPelaPosicao(posicaoPesquisada.toUpperCase());
                System.out.println(posicaoPesquisada.toUpperCase());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            jogadoresPesquisa = new ArrayList<>();
            for(JogadorModel j : jogadores){
                if(j.getTime().getTimeId()!=idTime){
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

                    System.out.println(jogadorDesejado.getTime().getTimeId());
                    System.out.println(jogadorDesejado.getJogadorId());
                    System.out.println(jogadorDesejado.getNomeJogador());

                }
            }
        });
        fazerPropostaButton.addActionListener(e->{
            if(time.getJogadores()!=null){
                final JComboBox comboBox = new JComboBox<>();
                for( JogadorModel j : time.getJogadores()){
                    comboBox.addItem(j.getNomeJogador());
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
                    JogadorModel jogadorProposto = time.getJogadores().get(comboBox.getSelectedIndex());

                    System.out.println(jogadorProposto.getNomeJogador());
                    System.out.println(jogadorProposto.getTime().getTimeId());
                    System.out.println(jogadorProposto.getJogadorId());

                    try
                    {
                        TransacaoModel t = client.CadastroTransacao(jogadorProposto.getTime().getTimeId(),
                                jogadorDesejado.getTime().getTimeId(),
                                jogadorProposto.getJogadorId(), jogadorDesejado.getJogadorId());
                        if(t==null)
                        {
                            JOptionPane.showMessageDialog(null, "Transação não registrada");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Transação Registrada");
                            dispose();
                            AppFrame app = new AppFrame(idTime, new EscamballService());
                        }
                    }
                    catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

    }

    private void listaPesquisa(int idTime, List<JogadorModel> lista){
        DefaultListModel<String> listaPesquisa = new DefaultListModel<>();
        for(JogadorModel j : lista){
            if(j.getTime().getTimeId()!=idTime){
                listaPesquisa.addElement(
                    "<html>" +
                        "<center>" +
                            "Jogador: " + j.getNomeJogador() +
                            "<br />" +
                            "Preço: " + j.getPrecoJogador() +
                            "<br />" +
                            "Geral: " + j.getGeral() +
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

    private TimeModel getInformacoes(int idTime, EscamballService client) {
        try{
            TimeModel time = client.BuscaTimePeloId(idTime);
            List<JogadorModel> jogadores =  client.ListaDeJogadoresTime(idTime);
            time.setJogadores(jogadores);
            return time;
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    private void SetInformacoes(TimeModel t, List<TransacaoModel> transacaoModelList, EscamballService client) {
        InitialPage(t);
        JogadoresPage(t);
        PropostasPage(transacaoModelList,client);
    }

    private void InitialPage(TimeModel t) {
        String numeroJogadores = "0 jogadores";
        if (t.getJogadores() != null) {
            numeroJogadores = (t.getJogadores().size() + (t.getJogadores().size() == 1 ? " jogador" : " jogadores"));
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

    private void PropostasPage(List<TransacaoModel> transacaoList, EscamballService client) {
        DefaultListModel<String> modelPropostas = new DefaultListModel<>();
        if (transacaoList != null) {
            for (TransacaoModel tr : transacaoList) {

                JogadorModel jogadorDesejadoOutroTime;
                JogadorModel jogadorOferecidoOutroTime;
                try{
                    jogadorDesejadoOutroTime = client.BuscaJogadorPeloId(tr.getJogadorDesejadoId());
                    jogadorOferecidoOutroTime = client.BuscaJogadorPeloId(tr.getJogadorOferecidoId());
                }catch(IOException ex){
                    throw new RuntimeException(ex);
                }
                if((tr.isTransacaoFinalizada()==false)){
                    modelPropostas.addElement(
                            "<html>" +
                                    "<center>" +
                                    "Proposta recebida" +
                                    "<br />Jogador de interesse da outra equipe: <b>" + jogadorDesejadoOutroTime.getNomeJogador() + "</b>" +
                                    "<br />Jogador oferecido: <b>" + jogadorOferecidoOutroTime.getNomeJogador() + "</b>" +
                                    "<hr>" +
                                    "</center>" +
                                    "</html>"
                    );
                }
            }
        }
        ofertasList.setModel(modelPropostas);
        revalidate();
    }
    private JTable TabelaJogadores(TimeModel t) {
        String[] colunas = {"Nome", "Posição", "Idade", "Geral"};
        Object[][] dados = new Object[0][4];
        if (t.getJogadores() != null) {
            if (t.getJogadores().size() > 0) {
                dados = new Object[t.getJogadores().size()][4];
                for (int i = 0; i < t.getJogadores().size(); i++) {
                    JogadorModel j = t.getJogadores().get(i);
                    dados[i] = new Object[]{j.getNomeJogador(), j.getPosicao(), j.getIdadeJogador(), j.getGeral()};
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
