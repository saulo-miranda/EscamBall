import Comunicacao.TCPCliente;
import Visao.EscamballAppGUI;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class MainClient {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        //Controladores.Cadastro cadastro = new Controladores.Cadastro();
        //TCPCliente client = new TCPCliente();
        //client.ComunicacaoTimeTCP(cadastro.getCadastroInicial());
        EscamballAppGUI escamballAppGUI = new EscamballAppGUI();
        escamballAppGUI.setSize(800,600);
        escamballAppGUI.setVisible(true);
    }
}
