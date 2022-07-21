package main.java.Visao;

import main.java.Communication.GrpcClient;
import main.java.Models.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;

public class InfosTransacao extends JFrame {
    private JPanel mainPanel;
    private JLabel versusJogadores;
    private JLabel infosGerais;
    private JLabel imgJgA;
    private JLabel imgJgB;
    private JLabel nomesLabel;
    private JButton recusarButton;
    private JButton aceitarButton;
    private JLabel nomeJgA;
    private JLabel nomeJgB;
    private JLabel idadeJgA;
    private JLabel idadeJgB;
    private JLabel precoJgA;
    private JLabel precoJgB;
    private JLabel posicaoJgA;
    private JLabel posicaoJgB;
    private JLabel defesaJgA;
    private JLabel defesaJgB;
    private JLabel ataqueJgA;
    private JLabel ataqueJgB;
    private JLabel fisicoJgA;
    private JLabel fisicoJgB;
    private JLabel geralJgA;
    private JLabel geralJgB;
    private TransacaoModel tr;

    public InfosTransacao(int idTime, int idTransacao, GrpcClient client) {
        setContentPane(mainPanel);
        setTitle("Troca");
        setSize(700, 750);
        setVisible(true);

        client.RecuperaTransacaoPeloId(idTransacao);
        if (client.getTransacao() != null) {
            tr = client.getTransacao();
            SetInfos(tr.getJogadorProposto(), tr.getJogadorDesejado());
        }

        recusarButton.addActionListener(e -> {
            client.RespostaTransacao(idTransacao, false);
            dispose();
            AppFrame appFrame = new AppFrame(idTime, new GrpcClient(3403));
        });

        aceitarButton.addActionListener(e -> {
            client.RespostaTransacao(idTransacao, true);
            dispose();
            AppFrame appFrame = new AppFrame(idTime, new GrpcClient(3403));
        });

    }

    private void SetInfos(JogadorModel jP, JogadorModel jD) {
        versusJogadores.setText(
                "<html>" +
                        "<center>" +
                        "Jogador Oferecido: " + jP.getNome() +
                        "<br />" +
                        "Jogador Desejado: " + jD.getNome() +
                        "</center>" +
                        "</html>"
        );

        setImage(imgJgA, jP);
        setImage(imgJgB, jD);

        nomeJgA.setText(jP.getNome());
        nomeJgB.setText(jD.getNome());

        idadeJgA.setText(String.valueOf(jP.getIdade()));
        idadeJgB.setText(String.valueOf(jD.getIdade()));

        precoJgA.setText(String.valueOf(jP.getPreco()));
        precoJgB.setText(String.valueOf(jD.getPreco()));

        posicaoJgA.setText(Posicao(jP.getPosicao()));
        posicaoJgB.setText(Posicao(jD.getPosicao()));

        defesaJgA.setText(String.valueOf(jP.getPontos().getDefesa()));
        defesaJgB.setText(String.valueOf(jD.getPontos().getDefesa()));

        ataqueJgA.setText(String.valueOf(jP.getPontos().getAtaque()));
        ataqueJgB.setText(String.valueOf(jD.getPontos().getAtaque()));

        fisicoJgA.setText(String.valueOf(jP.getPontos().getFisico()));
        fisicoJgB.setText(String.valueOf(jD.getPontos().getFisico()));

        geralJgA.setText(String.valueOf(jP.getPontos().getGeral()));
        geralJgB.setText(String.valueOf(jD.getPontos().getGeral()));

    }

    private void setImage(JLabel imagemJogador, JogadorModel jogador) {
        try {
            BufferedImage img = ImageIO.read(new File("src/main/java/Visao/Assets/defautPlayer.png"));
            ImageIcon logo = new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            imagemJogador.setText("");
            imagemJogador.setIcon(logo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String Posicao(PosicaoModel p) {
        return (p.isGoleiro() ? "Goleiro" :
                (p.isZagueiro() ? "Defensor" :
                        (p.isMeioCampista() ? "Meia" :
                                "Atacante")));
    }

}
