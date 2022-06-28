package Visao;

import javax.swing.*;
import java.awt.event.*;
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
                if(ConfirmaSenhas()){
                    /*
                    toBack();
                    setVisible(false);
                    EscamballAppGUI frame = new EscamballAppGUI();
                    frame.setSize(800,600);
                    frame.setVisible(true);
                    frame.toFront();
                    */
                }
                else{
                    DangerPasswordLabel.setText("As senhas digitadas não são iguais!");
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