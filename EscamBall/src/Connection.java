import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Connection extends Thread{
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket clientSocket;
    private int contador;
    public Connection(Socket clientSocket, int contador) {
        try{
            this.clientSocket = clientSocket;
            this.contador = contador;
            this.out = new ObjectOutputStream(clientSocket.getOutputStream());
            this.in = new ObjectInputStream(clientSocket.getInputStream());
            this.ComunicacaoTimeTCP();
        }catch (IOException ignored){}
    }
    private void ComunicacaoTimeTCP() throws IOException {
        try {
            Time time = (Time) in.readObject();
            System.out.println("O cliente "+contador+" chegou! O time dele é o: "+time.getNome());
            out.writeObject(time);
            out.flush();
            System.out.printf("Eu respondi %s!\n", time.getNome());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            in.close();
            out.close();
            clientSocket.close();
        }
    }
}
