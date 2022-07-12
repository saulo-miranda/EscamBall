package Visao;

import Controladores.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class AppFrame extends JFrame{
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
    private List<Transacao> transacaoList;

    public AppFrame (){
        setContentPane(mainPanel);
        setTitle("Escamball");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900,600);
        setVisible(true);

        Time t = SetTime();
        SetInformacoes(t);

        sairButton.addActionListener(e->{
            dispose();
            LoginFrame login = new LoginFrame();
        });

        adicionaJogador.addActionListener(e->{
            CadastroJogador cj = new CadastroJogador(t);
        });

        tableJogadores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable table = (JTable) e.getSource();
                if(e.getClickCount()==2){
                    int index = table.getSelectedRow();
                    Jogador j = t.getElenco().get(index);
                    InformacoesJogador info = new InformacoesJogador(j);

                }
            }
        });
        ofertasList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList) e.getSource();
                if(e.getClickCount()==2){
                    int index = list.locationToIndex(e.getPoint());
                    Transacao tr = transacaoList.get(index);
                    InfosTransacao info = new InfosTransacao(tr.getGrupoReceptor(),tr.getGrupoCriador());
                }
            }
        });
    }

    private void SetInformacoes(Time t){
        InitialPage(t);
        JogadoresPage(t);
        PropostasPage();
    }

    private void InitialPage(Time t){
        String numeroJogadores = (t.getElenco().size() + (t.getElenco().size() == 1 ? " jogador" : " jogadores"));
        String formattedText =
                "<html>" +
                        "<center>" +
                            "Olá " + t.getNomeDono() +"!" +
                            "<br />" +
                            "Seu time é o " + t.getNomeTime() +
                            "<br />" +
                            "Atualmente, a equipe conta com " + numeroJogadores + " no elenco!" +
                        "</center>" +
                        "</html>";
        timeDonoLabel.setText(formattedText);
        try {
            BufferedImage img = ImageIO.read(new File("EscamBall/src/Visao/Assets/logoApp.png"));
            ImageIcon logo = new ImageIcon(img.getScaledInstance(70,70,Image.SCALE_SMOOTH));
            imageLabel.setIcon(logo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void JogadoresPage(Time t){
        tableJogadores = TabelaJogadores(t);
        jogadoresPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        tabelaScrollPane = new JScrollPane(tableJogadores);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 2;
        c.gridy = 0;
        jogadoresPanel.add(jogadoresLabel,c);

        c.ipady = 100;
        c.ipadx = 700;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.0;
        c.gridwidth = 5;
        c.gridx = 0;
        c.gridy = 2;
        jogadoresPanel.add(tabelaScrollPane,c);

        c.ipady = 0;
        c.weightx = 0.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(10,0,0,0);
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 2;
        jogadoresPanel.add(adicionaJogador,c);
    }

    private void PropostasPage(){
        transacaoList = new ArrayList<>();
        transacaoList.add(SetTransacao());
        transacaoList.add(SetTransacao());
        DefaultListModel<String> modelPropostas = new DefaultListModel<>();
        for (Transacao tr: transacaoList)
            modelPropostas.addElement(
                    "<html>" +
                            "<center>" +
                            "Proposta recebida" +
                            "<br />Jogador de interesse da outra equipe: <b>" + tr.getGrupoReceptor().getNome() + "</b>" +
                            "<br />Jogador oferecido: <b>" + tr.getGrupoCriador().getNome() + "</b>" +
                            "<hr>" +
                            "</center>" +
                            "</html>"
            );
        ofertasList.setModel(modelPropostas);

    }
    private void MercadoPage(){

    }

    private Transacao SetTransacao(){
        //TODO: Chamada do banco
        Posicao p = new Posicao(false, false, false, true);
        Pontuacao pontuacaoVJ = new Pontuacao(87, 70, 85);
        Pontuacao pontuacaoKB = new Pontuacao(95, 67, 91);
        Jogador vj = new Jogador("Vinícius Júnior", 22, p, 17000000, pontuacaoVJ, 1);
        vj.setFoto("https://static-wp-tor15-prd.torcedores.com/wp-content/uploads/2021/11/design-sem-nome-19-4-590x393.jpg");
        Jogador kb = new Jogador("Karim Benzema", 35, p, 2000000, pontuacaoKB, 2);
        kb.setFoto("https://assets.goal.com/v3/assets/bltcc7a7ffd2fbf71f5/blt26a86a71ffb66bc4/624e9adb05f4f102cf5b86be/Karim_Benzema_Real_Madrid_2021-22.jpg");
        return new Transacao(1,2,vj,kb);
    }

    private Time SetTime(){
        //TODO: Chamada do banco
        Time t;
        try {
            t = new Time("Arthur", "Real Madrid", "arthur", "3503");
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
        Posicao p = new Posicao(false, false, false, true);
        Pontuacao pontuacaoVJ = new Pontuacao(87, 70, 85);
        Pontuacao pontuacaoKB = new Pontuacao(95, 67, 91);
        Jogador vj = new Jogador("Vinícius Júnior", 22, p, 17000000, pontuacaoVJ, t.getIdTime());
        vj.setFoto("https://static-wp-tor15-prd.torcedores.com/wp-content/uploads/2021/11/design-sem-nome-19-4-590x393.jpg");
        Jogador kb = new Jogador("Karim Benzema", 35, p, 2000000, pontuacaoKB, t.getIdTime());
        kb.setFoto("https://assets.goal.com/v3/assets/bltcc7a7ffd2fbf71f5/blt26a86a71ffb66bc4/624e9adb05f4f102cf5b86be/Karim_Benzema_Real_Madrid_2021-22.jpg");
        t.addJogador(vj);
        t.addJogador(kb);
        return t;
    }

    private JTable TabelaJogadores(Time t){
        String[] colunas = {"Nome", "Posição", "Idade", "Geral"};
        Object[][] dados = new Object[0][4];
        if(t.getElenco().size() > 0){
            dados = new Object[t.getElenco().size()][4];
            for(int i = 0; i<t.getElenco().size(); i++) {
                Jogador j = t.getElenco().get(i);
                String posicao = j.getPosicoes().isGoleiro() ?
                        "Goleiro" :
                        (j.getPosicoes().isZagueiro() ?
                                "Defensor" :
                                (j.getPosicoes().isMeioCampista() ?
                                        "Meia" :
                                        "Atacante"));
                dados[i] = new Object[]{j.getNome(), posicao, j.getIdade(), j.getPontos().getGeral()};
            }
        }

        return new JTable(dados, colunas){
            @Serial
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
}
