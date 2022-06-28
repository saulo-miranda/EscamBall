package Visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroJogador extends JFrame {
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton cadastreButton;

    public CadastroJogador(){
        super("Escamball - Novo JogadorModel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        cadastreButton.addActionListener(new ActionListener() {
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
        JFrame frame = new CadastroJogador();
        frame.setSize(800,600);
        frame.setVisible(true);
    }
}