import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
            TCPServidor server = new TCPServidor();
            server.comunicacao();
        /*
            Persistencia p = new Persistencia("dado.db");
            p.criarTabela();
            p.inserirPontuacao(new Pontuacao(29, 76,15));
            Pontuacao po = p.recuperarPontuacao(2);
            System.out.println(po.getDefesa());*/
        }
}