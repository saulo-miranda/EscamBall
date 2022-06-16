import java.io.IOException;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args){
        try {
            int serverPort = 7896;
            Socket socket = new Socket("127.0.0.1",serverPort);
            TCPCliente client = new TCPCliente(socket, serverPort);
            client.comunicacao();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
