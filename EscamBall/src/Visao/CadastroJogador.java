package Visao;

import Controladores.Jogador;
import Controladores.Pontuacao;
import Controladores.Posicao;
import Controladores.Time;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.*;

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

    public CadastroJogador(Time t){
        setContentPane(mainPanel);
        setTitle("Escamball - Novo Jogador");
        setSize(700,500);
        setVisible(true);
        this.SetNumericos();


        cadastreButton.addActionListener(e -> {
            String posicaoString = (String) Posicao.getSelectedItem();
            if(Objects.equals(Nome.getText(), "") || Objects.equals(Idade.getText(), "")
            || Objects.equals(Preco.getText(), "") || Objects.equals(Defesa.getText(), "")
            || Objects.equals(Ataque.getText(), "") || Objects.equals(Fisico.getText(), ""))
                JOptionPane.showMessageDialog(null, "Os campos estão vazios. Preencha todos por favor.");
            else{
                Posicao posicao = switch (requireNonNull(posicaoString)) {
                    case "Goleiro" -> new Posicao(true, false, false, false);
                    case "Defensor" -> new Posicao(false, true, false, false);
                    case "Meio" -> new Posicao(false, false, true, false);
                    case "Atacante" -> new Posicao(false, false, false, true);
                    default -> new Posicao(false, false, false, false);
                };
                int ataque = Integer.parseInt(Ataque.getText());
                int defesa = Integer.parseInt(Defesa.getText());
                int fisico = Integer.parseInt(Fisico.getText());
                int idade = Integer.parseInt(Idade.getText());
                long preco = Integer.parseInt(Preco.getText());
                Pontuacao pontos = new Pontuacao(ataque,defesa,fisico);

                Jogador jogador = new Jogador(Nome.getText(), idade,posicao, preco, pontos ,t.getIdTime());
                //TODO: Cadastro do jogador

                dispose();
            }
        });
    }

    private void SetJTextFieldNumerico(JTextField tf){
        ((AbstractDocument)tf.getDocument()).setDocumentFilter(new DocumentFilter(){
            final Pattern regEx = Pattern.compile("\\d*");
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                Matcher matcher = regEx.matcher(text);
                if(!matcher.matches()){
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
    }
    private void SetNumericos(){
        SetJTextFieldNumerico(Idade);
        SetJTextFieldNumerico(Preco);
        SetJTextFieldNumerico(Defesa);
        SetJTextFieldNumerico(Ataque);
        SetJTextFieldNumerico(Fisico);
    }
}