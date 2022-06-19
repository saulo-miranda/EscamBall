import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPCliente {
    private Socket socket;
    private int serverPort;
    private DataInputStream in;
    private DataOutputStream out;

    public TCPCliente(){
        try{
            this.serverPort = 7896;
            this.socket = new Socket("127.0.0.1",serverPort);
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public DataInputStream getIn() {
        return in;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    public void comunicacao(){
        try {
            System.out.println("Time");

            Pontuacao pontos = new Pontuacao(1,2,1);
            List<String> posicoes = new ArrayList<String>();
            posicoes.add("Meia");
            posicoes.add("Técnico");
            Time newTime = new Time("Cruzeiro");
            newTime.adicionarJogador("Thiago Neves", 34, posicoes, 210, pontos);
            ArrayList<Object> times = new ArrayList<>();
            times.add(newTime);
            Empacotamento.serializacao(times, "dados.dat");

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
