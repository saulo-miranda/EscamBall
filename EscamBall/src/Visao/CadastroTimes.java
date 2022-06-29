package Visao;

import javax.swing.*;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
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

    public CadastroTimes(){
        super("Escamball - Cadastre-se");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        cadastreSeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!ConfirmaSenhas()){
                    JOptionPane.showMessageDialog(null, "As senhas divergem");
                } else if ((nomeTextField.getText().equals("")
                        || nomeDoTimeTextField.getText().equals("")
                        || loginTextField.getText().equals("")
                        || new String(PasswordField.getPassword()).equals("")
                        || new String(ConfirmPasswordField.getPassword()).equals(""))) {
                    JOptionPane.showMessageDialog(null, "Os campos estão vazios. Preencha todos por favor.");

                } else {
                    /*
                    * TODO: Comunicação com o server
                    * */
                    try {
                        Time time = new Time(nomeTextField.getText(),
                                nomeDoTimeTextField.getText(),
                                loginTextField.getText(),
                                String.valueOf(PasswordField.getPassword()));
                        toBack();
                        setVisible(false);
                        App app = new App(time);
                        app.setSize(800,600);
                        app.setVisible(true);
                        app.toFront();
                    } catch (NoSuchAlgorithmException ex) {
                        throw new RuntimeException(ex);
                    }
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