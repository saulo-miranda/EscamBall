package main.java.Visao;

import main.java.Communication.EscamballService;
import main.java.Models.JogadorModel;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public CadastroJogador(int idTime, EscamballService client) {
        setContentPane(mainPanel);
        setTitle("Escamball - Novo Jogador");
        setSize(700, 500);
        setVisible(true);
        this.SetNumericos();


        cadastreButton.addActionListener(e -> {
            String posicao = (String) Posicao.getSelectedItem();
            if (Objects.equals(Nome.getText(), "") || Objects.equals(Idade.getText(), "")
                    || Objects.equals(Preco.getText(), "") || Objects.equals(Defesa.getText(), "")
                    || Objects.equals(Ataque.getText(), "") || Objects.equals(Fisico.getText(), ""))
                JOptionPane.showMessageDialog(null, "Os campos estão vazios. Preencha todos por favor.");
            else {
                int ataque = Integer.parseInt(Ataque.getText());
                int defesa = Integer.parseInt(Defesa.getText());
                int fisico = Integer.parseInt(Fisico.getText());
                int idade = Integer.parseInt(Idade.getText());
                long preco = Integer.parseInt(Preco.getText());


                try {
                    JogadorModel j = client.CadastroJogador(Nome.getText(), idade, preco, ataque, defesa, fisico, posicao, idTime);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
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