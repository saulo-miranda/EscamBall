package main.java.Visao;

import main.java.Communication.GrpcClient;
import main.java.Models.*;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.*;
import java.awt.*;
import java.util.Locale;
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

    public CadastroJogador(int idTime, GrpcClient client) {
        setContentPane(mainPanel);
        setTitle("Escamball - Novo Jogador");
        setSize(700, 500);
        setVisible(true);
        this.SetNumericos();


        cadastreButton.addActionListener(e -> {
            String posicaoString = (String) Posicao.getSelectedItem();
            if (Objects.equals(Nome.getText(), "") || Objects.equals(Idade.getText(), "")
                    || Objects.equals(Preco.getText(), "") || Objects.equals(Defesa.getText(), "")
                    || Objects.equals(Ataque.getText(), "") || Objects.equals(Fisico.getText(), ""))
                JOptionPane.showMessageDialog(null, "Os campos estão vazios. Preencha todos por favor.");
            else {
                PosicaoModel posicao = switch (requireNonNull(posicaoString)) {
                    case "Goleiro" -> new PosicaoModel(true, false, false, false);
                    case "Defensor" -> new PosicaoModel(false, true, false, false);
                    case "Meio" -> new PosicaoModel(false, false, true, false);
                    case "Atacante" -> new PosicaoModel(false, false, false, true);
                    default -> new PosicaoModel(false, false, false, false);
                };
                int ataque = Integer.parseInt(Ataque.getText());
                int defesa = Integer.parseInt(Defesa.getText());
                int fisico = Integer.parseInt(Fisico.getText());
                int idade = Integer.parseInt(Idade.getText());
                long preco = Integer.parseInt(Preco.getText());
                PontuacaoModel pontos = new PontuacaoModel(ataque, defesa, fisico);

                JogadorModel jogador = new JogadorModel(idTime, Nome.getText(), idade, posicao, preco, pontos);
                client.CadastroJogador(jogador);
                dispose();
                AppFrame app = new AppFrame(idTime, client);
            }
        });
    }

    private void SetJTextFieldNumerico(JTextField tf) {
        ((AbstractDocument) tf.getDocument()).setDocumentFilter(new DocumentFilter() {
            final Pattern regEx = Pattern.compile("\\d*");

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                Matcher matcher = regEx.matcher(text);
                if (!matcher.matches()) {
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
    }

    private void SetNumericos() {
        SetJTextFieldNumerico(Idade);
        SetJTextFieldNumerico(Preco);
        SetJTextFieldNumerico(Defesa);
        SetJTextFieldNumerico(Ataque);
        SetJTextFieldNumerico(Fisico);
    }

}