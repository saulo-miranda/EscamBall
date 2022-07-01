package Visao;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import Comunicacao.TCPCliente;
import Controladores.Time;

public class CadastroTimes extends JFrame {
    private JButton cadastreSeButton;
    private JPanel panel1;
    private JTextField nomeTextField;
    private JTextField nomeDoTimeTextField;
    private JTextField loginTextField;
    private JPasswordField PasswordField;
    private JPasswordField ConfirmPasswordField;
    private JLabel DangerPasswordLabel;

    public CadastroTimes(TCPCliente clientSocket){
        super("Escamball - Cadastre-se");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        cadastreSeButton.addActionListener(e -> {
            if(!ConfirmaSenhas()){
                JOptionPane.showMessageDialog(null, "As senhas divergem");
            } else if ((nomeTextField.getText().equals("")
                    || nomeDoTimeTextField.getText().equals("")
                    || loginTextField.getText().equals("")
                    || new String(PasswordField.getPassword()).equals("")
                    || new String(ConfirmPasswordField.getPassword()).equals(""))) {
                JOptionPane.showMessageDialog(null, "Os campos estão vazios. Preencha todos por favor.");

            } else {
                try {
                    Time time = new Time(nomeTextField.getText(),
                            nomeDoTimeTextField.getText(),
                            loginTextField.getText(),
                            String.valueOf(PasswordField.getPassword()));
                    Time retorno = clientSocket.ComunicacaoCadastro(time);
                    toBack();
                    setVisible(false);
                    EscamballAppGUI app = new EscamballAppGUI();
                    app.setSize(800,600);
                    app.setVisible(true);
                    app.toFront();
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }


        });
    }

    private boolean ConfirmaSenhas(){
        String senhaEntrada = String.valueOf(PasswordField.getPassword());
        String senhaConfirmacao = String.valueOf(ConfirmPasswordField.getPassword());
        return Objects.equals(senhaEntrada, senhaConfirmacao);
    }

}