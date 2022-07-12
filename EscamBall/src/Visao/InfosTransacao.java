package Visao;

import Controladores.Jogador;
import Controladores.Posicao;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

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

    public InfosTransacao(Jogador jP, Jogador jR){
        setContentPane(mainPanel);
        setTitle("Troca");
        setSize(700,750);
        setVisible(true);
        SetInfos(jP, jR);
    }

    private void SetInfos(Jogador jP, Jogador jR){
        versusJogadores.setText(jP.getNome() + " x " + jR.getNome());

        setImage(imgJgA, jP);
        setImage(imgJgB, jR);

        nomeJgA.setText(jP.getNome());
        nomeJgB.setText(jR.getNome());

        idadeJgA.setText(String.valueOf(jP.getIdade()));
        idadeJgB.setText(String.valueOf(jR.getIdade()));

        precoJgA.setText(String.valueOf(jP.getPreco()));
        precoJgB.setText(String.valueOf(jR.getPreco()));

        posicaoJgA.setText(Posicao(jP.getPosicoes()));
        posicaoJgB.setText(Posicao(jR.getPosicoes()));

        defesaJgA.setText(String.valueOf(jP.getPontos().getDefesa()));
        defesaJgB.setText(String.valueOf(jR.getPontos().getDefesa()));

        ataqueJgA.setText(String.valueOf(jP.getPontos().getAtaque()));
        ataqueJgB.setText(String.valueOf(jR.getPontos().getAtaque()));

        fisicoJgA.setText(String.valueOf(jP.getPontos().getFisico()));
        fisicoJgB.setText(String.valueOf(jR.getPontos().getFisico()));

        geralJgA.setText(String.valueOf(jR.getPontos().getGeral()));
        geralJgB.setText(String.valueOf(jR.getPontos().getGeral()));

    }

    private void setImage(JLabel imagemJogador, Jogador jogador){
        try {
            BufferedImage img = ImageIO.read(new File("EscamBall/src/Visao/Assets/defautPlayer.png"));
            ImageIcon logo = new ImageIcon(img.getScaledInstance(100,100, Image.SCALE_SMOOTH));
            imagemJogador.setText("");
            imagemJogador.setIcon(logo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(jogador.getFoto() != null && !jogador.getFoto().equals("")){
            String urlLink = jogador.getFoto();
            try {
                URL url = new URL(urlLink);
                BufferedImage img = ImageIO.read(url);
                Image imagemMenor = img.getScaledInstance(127, 85, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(imagemMenor);
                imagemJogador.setText("");
                imagemJogador.setIcon(icon);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String Posicao(Posicao p){
        return (p.isGoleiro() ? "Goleiro" :
                    (p.isZagueiro() ? "Defensor" :
                        (p.isMeioCampista() ? "Meia" :
                                                "Atacante")));
    }

}
