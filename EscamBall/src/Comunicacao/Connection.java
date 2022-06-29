package Comunicacao;

import java.io.*;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import Controladores.*;
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
            //this.ComunicacaoTimeTCP();
            //this.Login();
            this.start();
        }catch (IOException ignored){}
    }
    public void run(){
        try {
            Requisicao requisicao = (Requisicao) in.readObject();
            switch (requisicao.getParametro()){
                case LOGIN:
                    this.Login();
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
    private void Login() throws IOException, NoSuchAlgorithmException {
        try{
            Time time = new Time("Ronaldo", "Cruzeiro", "ronaldoCruzeiro", "123456");
            Login login = (Login) in.readObject();
            System.out.printf("O cliente "+contador+" chegou! O Login é: "+login.getLogin()+"\n");
            if(login.getLogin().equals(time.getLogin()) && login.getSenha().equals(time.getSenha())){
                out.writeObject(time);
            } else{
                out.writeObject(null);
            }
            out.flush();
        }catch (ClassNotFoundException | NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }finally {
            in.close();
            out.close();
            clientSocket.close();
        }
    }
    /*
    private void ComunicacaoTimeTCP() throws IOException {
        try {
            Time time = (Time) in.readObject();
            System.out.println("O cliente "+contador+" chegou! O time dele é o: "+time.getNomeTime());
            out.writeObject(time);
            out.flush();
            System.out.printf("Eu respondi %s!\n", time.getNomeTime());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            in.close();
            out.close();
            clientSocket.close();
        }
    }
    private void ComunicacaoTimeTCP() throws IOException {
        try {
            Time time = (Time) in.readObject();
            System.out.println("O cliente "+contador+" chegou! O time dele é o: "+time.getNomeTime());
            out.writeObject(time);
            out.flush();
            System.out.printf("Eu respondi %s!\n", time.getNomeTime());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            in.close();
            out.close();
            clientSocket.close();
        }
    }*/
}
