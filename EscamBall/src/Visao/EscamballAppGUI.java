package Visao;


import Comunicacao.TCPCliente;
import Controladores.Login;
import Controladores.Time;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EscamballAppGUI extends JFrame{
    private Login login;
    private Comunicacao.TCPCliente clientSocket;
    private JPanel mainPanel;
    private JTextField LoginTextField;
    private JLabel LoginLabel;
    private JPasswordField passwordField1;
    private JButton EntrarButton;
    private JLabel DangerLabel;
    private JButton CadastroButton;

    public EscamballAppGUI(){
        super("Escamball");
        clientSocket = new Comunicacao.TCPCliente();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        EntrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (new String(passwordField1.getPassword()).equals("") || LoginTextField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Os campos estão vazios. Preencha todos por favor.");
                }

                else {
                    login = new Login(LoginTextField.getText(), String.valueOf(passwordField1.getPassword()));
                    try{
                        Time time = clientSocket.ComunicacaoLogin(login);
                        if(time == null){
                            JOptionPane.showMessageDialog(null, "Login recusado, crie uma conta!");
                            dispose();
                            EscamballAppGUI escamballAppGUI = new EscamballAppGUI();
                            escamballAppGUI.setSize(800,600);
                            escamballAppGUI.setVisible(true);
                        }
                        else{
                            toBack();
                            setVisible(false);
                            App app = new App(time);
                            app.setSize(800,600);
                            app.setVisible(true);
                            app.toFront();
                        }
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
            }
        });

        CadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toBack();
                setVisible(false);
                CadastroTimes cadastro = new CadastroTimes(clientSocket);
                cadastro.setSize(800,600);
                cadastro.setVisible(true);
                cadastro.toFront();
            }
        });
    }

    public Login getLogin(){
        return this.login;
    }

}

