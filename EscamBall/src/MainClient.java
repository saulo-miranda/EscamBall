import java.io.IOException;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args){
        TCPCliente client = new TCPCliente();
        client.comunicacao();
    }
}
