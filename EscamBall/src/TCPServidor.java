import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServidor {
    private ServerSocket listenSocket;
    private Socket clientSocket;
    private int serverPort;
    private int contador;


    public TCPServidor(ServerSocket listenSocket, int serverPort, int contador) {
        this.listenSocket = listenSocket;
        this.clientSocket = null;
        this.serverPort = serverPort;
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public int getServerPort() {
        return serverPort;
    }

    public ServerSocket getListenSocket() {
        return listenSocket;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void setListenSocket(ServerSocket listenSocket) {
        this.listenSocket = listenSocket;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public void comunicacao(){
        try{
            System.out.println("Eu sou o servidor, e estou rodando!");
            while(true) {
                System.out.println("Esperando...");
                clientSocket = listenSocket.accept();
                System.out.println("Aceitei o cliente "+contador);
                Connection c = new Connection(clientSocket,contador);
                contador++;
            }
        }catch (IOException ignored){}
        finally {
            try{
                listenSocket.close();
                clientSocket.close();
            } catch (IOException ignored) {}
        }
    }
}
