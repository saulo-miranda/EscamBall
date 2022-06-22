import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.Console;
import java.io.IOException;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Cadastro cadastro = new Cadastro();
        TCPCliente client = new TCPCliente();
        client.ComunicacaoTimeTCP(cadastro.getCadastroInicial());
    }
}
