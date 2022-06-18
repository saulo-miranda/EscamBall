import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection extends Thread{
    private DataInputStream in;
    private DataOutputStream out;
    private Socket clientSocket;
    private int contador;
    public Connection(Socket clientSocket, int contador) {
        try{
            this.clientSocket = clientSocket;
            this.contador = contador;
            this.in = new DataInputStream(clientSocket.getInputStream());
            this.out = new DataOutputStream(clientSocket.getOutputStream());
            this.start();
        }catch (IOException ignored){}
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public DataInputStream getIn() {
        return in;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public int getContador() {
        return contador;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    @Override
    public void run(){
        try {
            String data = in.readUTF();
            System.out.println("O cliente "+contador+" chegou! Ele disse "+data);
            out.writeUTF("PONG");
            System.out.println("Eu respondi PONG!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                clientSocket.close();
            }catch(IOException ignored) {}
        }
    }

}