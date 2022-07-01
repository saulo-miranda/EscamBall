package Visao;

import Controladores.Jogador;

import javax.swing.*;

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

    public InformacoesJogador(Jogador jogador){
        this.setContentPane(mainPanel);
        this.pack();

        nomeJogadorLabel.setText(jogador.getNome());
        precoJogadorLabel.setText(String.valueOf(jogador.getPreco()));
        idadeJogadorLabel.setText(String.valueOf(jogador.getIdade()));

        String posicao = null;
        if(jogador.getPosicoes().isAtacante()){
            posicao = "Atacante";
        } else if (jogador.getPosicoes().isGoleiro()) {
            posicao = "Goleiro";
        } else if(jogador.getPosicoes().isMeioCampista()){
            posicao = "Meio";
        }else if(jogador.getPosicoes().isZagueiro()){
            posicao = "Defensor";
        }

        posicaoLabel.setText(posicao);

        defesaLabel.setText(String.valueOf(jogador.getPontos().getDefesa()));
        ataqueLabel.setText(String.valueOf(jogador.getPontos().getAtaque()));
        fisicoLabel.setText(String.valueOf(jogador.getPontos().getFisico()));
        geralLabel.setText(String.valueOf(jogador.getPontos().getGeral()));

        okButton.addActionListener(e ->{
            dispose();
        });

    }

}
