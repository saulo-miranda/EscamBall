package Visao;

import Comunicacao.TCPCliente;
import Controladores.Jogador;
import Controladores.Pontuacao;
import Controladores.Posicao;
import Controladores.Time;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CadastroJogador extends JFrame {
    private JPanel mainPanel;
    private JTextField Nome;
    private JTextField Idade;
    private JTextField Preco;
    private JComboBox Posicao;
    private JTextField Defesa;
    private JTextField Ataque;
    private JTextField Fisico;
    private JButton cadastreButton;

    public CadastroJogador(Time time, TCPCliente clientSocket){
        super("Escamball - Novo Jogador");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        cadastreButton.addActionListener(e -> {

            String posicaoString = (String) Posicao.getSelectedItem();
            if(Nome.getText().equals("")
            || Idade.getText().equals("")
            || Preco.getText().equals("")
            || Defesa.getText().equals("")
            || Ataque.getText().equals("")
            || Fisico.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Os campos estão vazios. Preencha todos por favor.");
            }
            else{
                Posicao posicao = null;
                if(posicaoString.equals("Goleiro")){
                    posicao = new Posicao(true, false, false,false);
                }
                else if(posicaoString.equals("Defensor")){
                    posicao = new Posicao(false,true,false,false);
                }
                else if(posicaoString.equals("Meio")){
                    posicao = new Posicao(false,false,true,false);
                }
                else{
                    posicao = new Posicao(false,true,false,true);
                }
                int ataque = Integer.valueOf(Ataque.getText());
                int defesa = Integer.valueOf(Defesa.getText());
                int fisico = Integer.valueOf(Fisico.getText());
                int idade = Integer.valueOf(Idade.getText());
                long preco = Integer.valueOf(Preco.getText());
                Pontuacao pontos = new Pontuacao(ataque,defesa,fisico);

                Jogador jogador = new Jogador(Nome.getText(), idade,posicao, preco, pontos ,time.getIdTime());

                try {
                    Jogador retorno = clientSocket.ComunicacaoNovoJogador(jogador);

                    time.addJogador(retorno);

                    System.out.println(time.getElenco());

                    toBack();
                    setVisible(false);
                    App app = new App(time);
                    app.setSize(800,600);
                    app.setVisible(true);
                    app.toFront();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }
}