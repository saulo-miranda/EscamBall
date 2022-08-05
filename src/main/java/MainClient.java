package main.java;


//import main.java.Visao.*;

import main.java.Communication.EscamballService;
import main.java.Visao.LoginFrame;

import javax.swing.*;


public class MainClient {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        EscamballService escamballService = new EscamballService();
        LoginFrame lf = new LoginFrame(escamballService);
    }
}
