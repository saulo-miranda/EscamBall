import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String nomeTime;
        System.out.print("Nome do time: ");
        nomeTime = scanner.next();

        TCPCliente client = new TCPCliente();
        client.ComunicacaoTimeTCP(new Time(nomeTime));
    }
}
