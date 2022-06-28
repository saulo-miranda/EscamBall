import java.net.*;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {

            Persistencia p = new Persistencia("dado1.db");
            p.criarTabela();
            Transacao t = new Transacao(1,2,p.recuperarJogador(1), p.recuperarJogador(136));
            p.inserirTransacao(t);
            p.alterarTransacao(t, true);

            Transacao transacao = p.recuperarTransacao(1);
            transacao.getGrupoCriador().resumo();
            Time cruzeiro = p.recuperarTime(2);
            System.out.println(cruzeiro.getLogin());
            List<Transacao> historico = p.historicoTransacoes(cruzeiro);
            for(Transacao tr: historico){
                System.out.println(tr.getIdTransacao());
            }
            p.recuperarElenco(cruzeiro);
            for(Jogador jo: cruzeiro.getElenco()){
                jo.resumo();
            }

        }
}