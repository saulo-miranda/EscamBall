package main.java;

import main.java.Communication.GrpcClient;
import main.java.Visao.*;

import javax.swing.*;


public class MainClient {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        LoginFrame lf = new LoginFrame(new GrpcClient(3403));
    }
}
