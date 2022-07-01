package Comunicacao;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import Controladores.*;

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
            System.out.printf("Estou enviando o time: %s\n", time.getNomeTime());
            out.writeObject(time);
            out.flush();

            System.out.println("Enviado");

            Time timeRecebido = (Time) in.readObject();
            System.out.printf("Recebi o time: %s\n", timeRecebido.getNomeTime());
            System.out.printf("Dono: %s\n", timeRecebido.getNomeDono());
            System.out.printf("Login: %s\n", timeRecebido.getLogin());
            System.out.printf("Senha: %s\n", timeRecebido.getSenha());

            System.out.println("End Client");

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
            in.close();
            client.close();
        }
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
    public Time ComunicacaoLogin(Login login) throws IOException {
        try {
            System.out.printf("Estou enviando o cliente "+login.getLogin()+"\n");
            Requisicao requisicao = new Requisicao(Parametros.LOGIN,  login);

            out.writeObject(requisicao);
            out.flush();

            System.out.println("Enviado");

            Time recebido = (Time) in.readObject();
            return recebido;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            out.close();
            in.close();
            client.close();
        }
    }

    public Time ComunicacaoCadastro(Time time) throws IOException {
        try {
            System.out.printf("Estou cadastrando o time "+time.getNomeTime()+"\n");
            Requisicao requisicao = new Requisicao(Parametros.CADASTRO,  time);
            out.writeObject(requisicao);
            out.flush();

            System.out.println("Enviado");

            Time recebido = (Time) in.readObject();
            return recebido;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            out.close();
            in.close();
            client.close();
        }
    }
    public Jogador ComunicacaoNovoJogador(Jogador jogador) throws IOException {
        try{
            System.out.println("Estou cadastrando o jogador: "+ jogador.getNome());
            Requisicao requisicao = new Requisicao(Parametros.NOVO_JOGADOR,  jogador);
            out.writeObject(requisicao);
            out.flush();

            System.out.println("Enviado");

            Jogador recebido = (Jogador) in.readObject();
            return recebido;

        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            out.close();
            in.close();
            client.close();
        }
    }

    public List<Jogador> ComunicaPesquisaJogador(String nome) throws IOException, ClassNotFoundException {
        try {
            Requisicao requisicao = new Requisicao(Parametros.BUSCA_NOME, nome);
            out.writeObject(requisicao);
            out.flush();

            System.out.println("Enviado");
            List<Jogador> recebido = (List<Jogador>) in.readObject();
            return recebido;
        } finally {
            out.close();
            in.close();
            client.close();
        }
    }

    public Transacao ComunicaTransacao(Transacao transacao) throws IOException, ClassNotFoundException {
        try{
            Requisicao requisicao = new Requisicao(Parametros.TRANSACAO, transacao);
            out.writeObject(requisicao);
            out.flush();
            System.out.println("Enviado");
            Transacao recebido = (Transacao) in.readObject();
            return recebido;
        }finally {
            in.close();
            out.close();
            client.close();
        }
    }
    public Jogador ComunicaBuscaPorId(int idJogador) throws IOException, ClassNotFoundException {
        try{
            Requisicao requisicao = new Requisicao(Parametros.BUSCA_ID, idJogador);
            out.writeObject(requisicao);
            out.flush();
            System.out.println("Enviado");
            Jogador recebido = (Jogador) in.readObject();
            return recebido;
        }finally {
            in.close();
            out.close();
            client.close();
        }
    }

}
