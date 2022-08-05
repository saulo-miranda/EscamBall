package main.java;


//import main.java.Visao.*;

import main.java.Communication.EscamballService;
import main.java.Models.TimeModel;

import javax.swing.*;
import java.io.IOException;


public class MainClient {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //LoginFrame lf = new LoginFrame();
        System.out.println("Hello World!");
        EscamballService escamballService = new EscamballService();
        try {
            //TimeModel t = escamballService.CadastroTime("z", "e", "56945", "e");
            //System.out.println(t.getTimeId());

            //JogadorModel j = escamballService.CadastroJogador("A", 12, 12, 12,12,12, "ATACANTE", 2);
            //System.out.println(j.getJogadorId());

            //TransacaoModel tr = escamballService.CadastroTransacao(1,2,2,4);
            //System.out.println(tr.getTransacaoId());

            //t = escamballService.RespostaTransacao(t.getTransacaoId(), true);

            //TransacaoModel t = escamballService.RecuperaTransacaoPeloId(1);

            /*
            System.out.println(t.getTransacaoId());
            System.out.println(t.getTimePropostaId());
            System.out.println(t.getTimeReceptorId());
            System.out.println(t.getJogadorOferecidoId());
            System.out.println(t.getJogadorDesejadoId());
            System.out.println(t.isTransacaoAceita());
            System.out.println(t.isTransacaoFinalizada());

             */

            TimeModel t = escamballService.RealizaLogin("arthur", "3503");

            //TimeModel t = escamballService.BuscaTimePeloId(-1);

            if(t==null){
               System.out.println("Time não encontrado");
            }

            if(t.getTimeId()==0){
                System.out.println("Time não encontrado");
            }
            else{
                System.out.println("Time Id: "+t.getTimeId());
                System.out.println("Nome Dono: "+t.getNomeDono());
                System.out.println("Nome Time: "+t.getNomeTime());
                System.out.println("Login: "+t.getLogin());
                System.out.println("Senha: "+t.getSenha());

            }


            /*
            JogadorModel j = escamballService.BuscaJogadorPeloId(2);
            if(j==null || j.getJogadorId() == 0)
            {
                System.out.println("Jogador não encontrado");
            }
            else{
                System.out.println("Id Jogador: " + j.getJogadorId());
                System.out.println("Nome Jogador: " + j.getNomeJogador());
                System.out.println("Posicao: " + j.getPosicao());
                System.out.println("Idade: " + j.getIdadeJogador());
                System.out.println("Ataque: " + j.getAtaque());
                System.out.println("Defesa: " + j.getDefesa());
                System.out.println("Fisico: " + j.getFisico());
                System.out.println("Geral: " + j.getFisico());

                System.out.println("--------TIME--------------");
                System.out.println("Time Id: "+j.getTime().getTimeId());
                System.out.println("Nome Dono: "+j.getTime().getNomeDono());
                System.out.println("Nome Time: "+j.getTime().getNomeTime());
                System.out.println("Login: "+j.getTime().getLogin());
                System.out.println("Senha: "+j.getTime().getSenha());

            }
*/
            /*
            List<JogadorModel> jogadorModelList = escamballService.BuscaJogadoresPeloNome("e");
            for(JogadorModel jog : jogadorModelList)
            {
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");


                System.out.println("Id Jogador: " + jog.getJogadorId());
                System.out.println("Nome Jogador: " + jog.getNomeJogador());
                System.out.println("Posicao: " + jog.getPosicao());
                System.out.println("Idade: " + jog.getIdadeJogador());
                System.out.println("Ataque: " + jog.getAtaque());
                System.out.println("Defesa: " + jog.getDefesa());
                System.out.println("Fisico: " + jog.getFisico());
                System.out.println("Geral: " + jog.getFisico());

                System.out.println("--------TIME--------------");
                System.out.println("Time Id: "+jog.getTime().getTimeId());
                System.out.println("Nome Dono: "+jog.getTime().getNomeDono());
                System.out.println("Nome Time: "+jog.getTime().getNomeTime());
                System.out.println("Login: "+jog.getTime().getLogin());
                System.out.println("Senha: "+jog.getTime().getSenha());
            }

             */

            //List<JogadorModel> jogadorModelList = escamballService.BuscaJogadorPelaPosicao("MEIA");
            /*
            List<JogadorModel> jogadorModelList = escamballService.ListaDeJogadoresTime(2);


            for(JogadorModel jog : jogadorModelList)
            {
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");


                System.out.println("Id Jogador: " + jog.getJogadorId());
                System.out.println("Nome Jogador: " + jog.getNomeJogador());
                System.out.println("Posicao: " + jog.getPosicao());
                System.out.println("Idade: " + jog.getIdadeJogador());
                System.out.println("Ataque: " + jog.getAtaque());
                System.out.println("Defesa: " + jog.getDefesa());
                System.out.println("Fisico: " + jog.getFisico());
                System.out.println("Geral: " + jog.getFisico());

                System.out.println("--------TIME--------------");
                System.out.println("Time Id: "+jog.getTime().getTimeId());
                System.out.println("Nome Dono: "+jog.getTime().getNomeDono());
                System.out.println("Nome Time: "+jog.getTime().getNomeTime());
                System.out.println("Login: "+jog.getTime().getLogin());
                System.out.println("Senha: "+jog.getTime().getSenha());
            }


             */
            /*
            List<TransacaoModel> transacaoModelList = escamballService.BuscaListaDeTransacoes(1);
            for(TransacaoModel t : transacaoModelList)
            {

                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");
                System.out.println("----------------------------------------------");

                System.out.println(t.getTransacaoId());
                System.out.println(t.getTimePropostaId());
                System.out.println(t.getTimeReceptorId());
                System.out.println(t.getJogadorOferecidoId());
                System.out.println(t.getJogadorDesejadoId());
                System.out.println(t.isTransacaoAceita());
                System.out.println(t.isTransacaoFinalizada());
            }

             */

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
