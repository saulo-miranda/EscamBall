import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        try {
            int serverPort = 7896;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            TCPServidor server = new TCPServidor(listenSocket, serverPort, 1);
            server.comunicacao();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}