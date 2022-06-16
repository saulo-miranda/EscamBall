import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPCliente {
    private Socket socket;
    private int serverPort;

    public TCPCliente(Socket socket, int serverPort){
        this.socket = socket;
        this.serverPort = serverPort;
    }

    public Socket getSocket() { return socket; }
    public int getServerPort() {return serverPort;}

    public void setSocket(Socket s) { socket = s; }
    public void setServerPort(int serverPort) { this.serverPort = serverPort;}

    public void comunicacao(){
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            System.out.println("Eu sou um cliente!");
            System.out.println("PING...");
            out.writeUTF("PING!");
            String data = in.readUTF();
            System.out.println(data);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(socket!=null)
                try {
                    socket.close();
                } catch (IOException ignored) {}
        }
    }

}
