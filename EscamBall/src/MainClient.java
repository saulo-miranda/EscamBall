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

        Scanner scanner = new Scanner(System.in);
        String nomeTime;
        String nomeDono;
        String login;
        System.out.print("Nome do time: ");
        nomeTime = scanner.next();
        System.out.print("Nome do dono do time: ");
        nomeDono = scanner.next();
        System.out.print("Login: ");
        login = scanner.next();

        final JPasswordField jpf = new JPasswordField();
        JOptionPane jop = new JOptionPane(jpf, JOptionPane.QUESTION_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION);
        JDialog dialog = jop.createDialog("Password:");
        dialog.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                SwingUtilities.invokeLater(jpf::requestFocusInWindow);
            }
        });
        dialog.setVisible(true);
        int result = (Integer) jop.getValue();
        dialog.dispose();
        char[] password = null;
        if (result == JOptionPane.OK_OPTION) {
            password = jpf.getPassword();
        }
        if (password != null) {
            Time time = new Time(nomeDono, nomeTime, login, Arrays.toString(password));

            TCPCliente client = new TCPCliente();
            client.ComunicacaoTimeTCP(time);
        }

        //TCPCliente client = new TCPCliente();
        //client.ComunicacaoTimeTCP(new Time(nomeTime));
    }
}
