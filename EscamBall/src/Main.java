import Controladores.*;
import Comunicacao.*;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
        TCPServidor server = new TCPServidor();
        server.comunicacao();
        /*
            Persistencia p = new Persistencia("dado1.db");
            p.criarTabela();
            Controladores.Transacao t = new Controladores.Transacao(1,2,p.recuperarJogador(1), p.recuperarJogador(136));
            p.inserirTransacao(t);
            p.alterarTransacao(t, true);

            Controladores.Transacao transacao = p.recuperarTransacao(1);
            transacao.getGrupoCriador().resumo();
            Controladores.Time cruzeiro = p.recuperarTime(2);
            System.out.println(cruzeiro.getLogin());
            List<Controladores.Transacao> historico = p.historicoTransacoes(cruzeiro);
            for(Controladores.Transacao tr: historico){
                System.out.println(tr.getIdTransacao());
            }
            p.recuperarElenco(cruzeiro);
            for(Controladores.Jogador jo: cruzeiro.getElenco()){
                jo.resumo();
            }


 */
        }
}