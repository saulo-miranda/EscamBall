package main.java.Visao;

import main.java.Models.JogadorModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

    public InformacoesJogador(JogadorModel jogador) {
        this.setContentPane(mainPanel);
        setTitle(jogador.getNomeJogador());
        setSize(300, 450);
        setVisible(true);

        nomeJogadorLabel.setText(jogador.getNomeJogador());
        precoJogadorLabel.setText(String.valueOf(jogador.getPrecoJogador()));
        idadeJogadorLabel.setText(String.valueOf(jogador.getIdadeJogador()));
        posicaoLabel.setText(jogador.getPosicao());

        defesaLabel.setText(String.valueOf(jogador.getDefesa()));
        ataqueLabel.setText(String.valueOf(jogador.getAtaque()));
        fisicoLabel.setText(String.valueOf(jogador.getFisico()));
        geralLabel.setText(String.valueOf(jogador.getGeral()));

        try {
            BufferedImage img = ImageIO.read(new File("src/main/java/Visao/Assets/defautPlayer.png"));
            ImageIcon logo = new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            imagemJogador.setText("");
            imagemJogador.setIcon(logo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        okButton.addActionListener(e -> dispose());

    }

}
