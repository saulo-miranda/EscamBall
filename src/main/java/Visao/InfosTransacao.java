package main.java.Visao;

import main.java.Communication.EscamballService;
import main.java.Models.JogadorModel;
import main.java.Models.TransacaoModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

    public InfosTransacao(int idTime, int idTransacao, EscamballService client) {
        setContentPane(mainPanel);
        setTitle("Troca");
        setSize(700, 750);
        setVisible(true);

        try {
            tr = client.RecuperaTransacaoPeloId(idTransacao);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (tr != null) {

            JogadorModel jogadorOferecido;
            JogadorModel jogadorDesejado;

            try
            {
                jogadorOferecido = client.BuscaJogadorPeloId(tr.getJogadorOferecidoId());
                jogadorDesejado = client.BuscaJogadorPeloId(tr.getJogadorDesejadoId());
            }
            catch(IOException ex)
            {
                throw new RuntimeException(ex);
            }

            SetInfos(jogadorOferecido, jogadorDesejado);
        }

        recusarButton.addActionListener(e -> {
            try {
                TransacaoModel transacao = client.RespostaTransacao(idTransacao, false);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
            AppFrame appFrame = new AppFrame(idTime, new EscamballService());
        });

        aceitarButton.addActionListener(e -> {
            try {
                TransacaoModel transacao = client.RespostaTransacao(idTransacao, true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
            AppFrame appFrame = new AppFrame(idTime, new EscamballService());
        });

    }

    private void SetInfos(JogadorModel jP, JogadorModel jD) {
        versusJogadores.setText(
                "<html>" +
                        "<center>" +
                        "Jogador Oferecido: " + jP.getNomeJogador() +
                        "<br />" +
                        "Jogador Desejado: " + jD.getNomeJogador() +
                        "</center>" +
                        "</html>"
        );
        setImage(imgJgA);
        setImage(imgJgB);

        nomeJgA.setText(jP.getNomeJogador());
        nomeJgB.setText(jD.getNomeJogador());

        idadeJgA.setText(String.valueOf(jP.getIdadeJogador()));
        idadeJgB.setText(String.valueOf(jD.getIdadeJogador()));

        precoJgA.setText(String.valueOf(jP.getPrecoJogador()));
        precoJgB.setText(String.valueOf(jD.getPrecoJogador()));

        posicaoJgA.setText(jP.getPosicao());
        posicaoJgB.setText(jD.getPosicao());

        defesaJgA.setText(String.valueOf(jP.getDefesa()));
        defesaJgB.setText(String.valueOf(jD.getDefesa()));

        ataqueJgA.setText(String.valueOf(jP.getAtaque()));
        ataqueJgB.setText(String.valueOf(jD.getAtaque()));

        fisicoJgA.setText(String.valueOf(jP.getFisico()));
        fisicoJgB.setText(String.valueOf(jD.getFisico()));

        geralJgA.setText(String.valueOf(jP.getGeral()));
        geralJgB.setText(String.valueOf(jD.getGeral()));
    }

    private void setImage(JLabel imagemJogador) {
        try {
            BufferedImage img = ImageIO.read(new File("src/main/java/Visao/Assets/defautPlayer.png"));
            ImageIcon logo = new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            imagemJogador.setText("");
            imagemJogador.setIcon(logo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
