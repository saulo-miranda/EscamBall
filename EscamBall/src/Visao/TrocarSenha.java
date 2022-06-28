package Visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrocarSenha extends JFrame{
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JPasswordField passwordField3;
    private JButton trocarButton;
    private JLabel TrocarSenhaLabel;
    private JPanel TrocarSenhaPanel;

    public TrocarSenha(){
        super("Escamball - Trocar Senha");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(TrocarSenhaPanel);
        this.pack();
        trocarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toBack();
                setVisible(false);
                //App app = new App();
                //app.setSize(800,600);
                //app.setVisible(true);
                //app.toFront();
            }
        });
    }

    public static void main(String args[]){
        JFrame frame = new TrocarSenha();
        frame.setSize(800,600);
        frame.setVisible(true);
    }
}
