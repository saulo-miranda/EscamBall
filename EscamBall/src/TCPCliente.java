import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPCliente {
    private Socket client;
    private int serverPort;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public TCPCliente(){
        try{
            this.serverPort = 7896;
            this.client = new Socket("127.0.0.1",serverPort);
            this.in = new ObjectInputStream(client.getInputStream());
            this.out = new ObjectOutputStream(client.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void ComunicacaoTimeTCP(Time time) throws IOException {
        try{
            System.out.printf("Estou enviando o time: %s\n", time.getNome());
            out.writeObject(time);
            out.flush();

            System.out.println("Enviado");

            Time timeRecebido = (Time) in.readObject();
            System.out.printf("Recebi o time: %s\n", timeRecebido.getNome());

            System.out.println("End Client");

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
            in.close();
            client.close();
        }
    }
    public Time testeNovoTime(){
        return new Time("Teste FC");
    }

    public Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }
}
