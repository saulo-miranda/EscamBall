package Comunicacao;

import java.io.*;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import Controladores.*;
public class Connection extends Thread{
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket clientSocket;
    private int contador;

    private Persistencia persistencia;
    public Connection(Socket clientSocket, int contador, Persistencia p) {
        try{
            this.clientSocket = clientSocket;
            this.contador = contador;
            this.out = new ObjectOutputStream(clientSocket.getOutputStream());
            this.in = new ObjectInputStream(clientSocket.getInputStream());
            this.persistencia = p;
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
                    this.Login(requisicao.getValue());
                    break;
                case CADASTRO:
                    this.Cadastro(requisicao.getValue());
                    break;
                case NOVO_JOGADOR:
                    this.NovoJogador(requisicao.getValue());
                    break;
                case TRANSACAO:
                    this.NovaTransacao(requisicao.getValue());
                    break;
                case BUSCA_NOME:
                    this.NovaBuscaNome(requisicao.getValue());
                    break;
                case BUSCA_POSICAO:
                    this.NovaBuscaPosicao(requisicao.getValue());
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

    private void Login(Object value) throws IOException {
        try{
            Login login = (Login) value;
            System.out.println(" Login Connection: "+login.getSenha());
            Time time = persistencia.recuperarTimePorLogin(login.getLogin());
            System.out.println(" Login Connection: "+time.getSenha());
            persistencia.recuperarElenco(time);
            System.out.printf("O cliente "+contador+" chegou! O Login é: "+login.getLogin()+"\n");
            if(login.getLogin().equals(time.getLogin()) && login.getSenha().equals(time.getSenha())){
                out.writeObject(time);
            } else{
                out.writeObject(null);
            }
            out.flush();
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }finally {
            in.close();
            out.close();
            clientSocket.close();
        }
    }

    private void Cadastro(Object value) throws IOException, NoSuchAlgorithmException {
        try{
            Time time = (Time) value;
            int insert = persistencia.inserirTime(time);

            if(insert > 0){
                System.out.printf("O time "+ time.getNomeTime()+" foi inserido com sucesso!");
                out.writeObject(time);
            } else{
                out.writeObject(null);
            }
            out.flush();
        } finally {
            in.close();
            out.close();
            clientSocket.close();
        }
    }

    private void NovoJogador(Object value) throws IOException, NoSuchAlgorithmException {
        try{
            Jogador jogador = (Jogador) value;
            int insert = persistencia.inserirJogador(jogador);
            if(insert > 0){
                System.out.printf("O jogador "+ jogador.getNome()+" foi inserido com sucesso!");
                out.writeObject(jogador);
            } else{
                out.writeObject(null);
            }
            out.flush();
        } finally {
            in.close();
            out.close();
            clientSocket.close();
        }
    }

    private void NovaTransacao(Object value) throws IOException, NoSuchAlgorithmException {
        try{
            Transacao transacao = (Transacao) value;
            int insert = persistencia.inserirTransacao(transacao);
            if(insert > 0){
                System.out.printf("A transacao com ID = "+ insert +" foi inserido com sucesso!");
                out.writeObject(insert);
            } else{
                out.writeObject(null);
            }
            out.flush();
        } finally {
            in.close();
            out.close();
            clientSocket.close();
        }
    }

    private void NovaBuscaNome(Object value) throws IOException, NoSuchAlgorithmException {
        try{
            String nome = (String) value;
            List<Jogador> busca = persistencia.recuperarJogadorPeloNome(nome);
            if(busca != null){
                System.out.printf("A busca pelo jogador "+ nome+" foi efetuada com sucesso!");
                out.writeObject(busca);
            } else{
                out.writeObject(null);
            }
            out.flush();
        } finally {
            in.close();
            out.close();
            clientSocket.close();
        }
    }

    private void NovaBuscaPosicao(Object value) throws IOException, NoSuchAlgorithmException {
        try{
            String posicao = (String) value;
            List<Jogador> busca = persistencia.recuperarJogadorPelaPosicao(posicao);
            if(busca != null){
                System.out.printf("A busca pelo jogador "+ posicao+" foi efetuada com sucesso!");
                out.writeObject(busca);
            } else{
                out.writeObject(null);
            }
            out.flush();
        } finally {
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
