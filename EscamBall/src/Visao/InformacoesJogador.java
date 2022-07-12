package Visao;

import Controladores.Jogador;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class InformacoesJogador extends JFrame {
    private JLabel nomeJogadorLabel;
    private JLabel precoJogadorLabel;
    private JLabel idadeJogadorLabel;
    private JLabel posicaoLabel;
    private JLabel defesaLabel;
    private JLabel ataqueLabel;
    private JLabel fisicoLabel;
    private JLabel geralLabel;
    private JPanel mainPanel;
    private JButton okButton;
    private JLabel imagemJogador;

    public InformacoesJogador(Jogador jogador){
        this.setContentPane(mainPanel);
        setTitle(jogador.getNome());
        setSize(300,450);
        setVisible(true);

        nomeJogadorLabel.setText(jogador.getNome());
        precoJogadorLabel.setText(String.valueOf(jogador.getPreco()));
        idadeJogadorLabel.setText(String.valueOf(jogador.getIdade()));

        String posicao = jogador.getPosicoes().isGoleiro() ?
                "Goleiro" :
                jogador.getPosicoes().isZagueiro() ?
                        "Defensor" :
                        jogador.getPosicoes().isMeioCampista() ?
                                "Meia" :
                                "Atacante";

        posicaoLabel.setText(posicao);

        defesaLabel.setText(String.valueOf(jogador.getPontos().getDefesa()));
        ataqueLabel.setText(String.valueOf(jogador.getPontos().getAtaque()));
        fisicoLabel.setText(String.valueOf(jogador.getPontos().getFisico()));
        geralLabel.setText(String.valueOf(jogador.getPontos().getGeral()));

        try {
            BufferedImage img = ImageIO.read(new File("EscamBall/src/Visao/Assets/defautPlayer.png"));
            ImageIcon logo = new ImageIcon(img.getScaledInstance(100,100,Image.SCALE_SMOOTH));
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

        okButton.addActionListener(e -> dispose());

    }

}
