/*
 * Classe para criação automática do time ao criar a tabela,
 * evitando que seja preciso cadastrar times e jogadores
 * ao testar o sistema distribuído
 * */
package main.java.TimesPadroes;

import main.java.Models.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class TimesPadroes {
    private final TimeModel RealMadrid;
    private final TimeModel ParisSaintGermain;

    public TimesPadroes() {
        RealMadrid = new TimeModel("Arthur", "Real Madrid", "arthur", "3503");
        RealMadrid.setElenco(geraElencoRealMadrid());
        ParisSaintGermain = new TimeModel("Saulo", "Paris Saint Germain", "saulo", "3475");
        ParisSaintGermain.setElenco(geraElencoPSG());
    }

    public TimeModel getRealMadrid() {
        return RealMadrid;
    }

    public TimeModel getParisSaintGermain() {
        return ParisSaintGermain;
    }
    private PontuacaoModel definePontuacao(int ataque, int defesa, int fisico){
        return new PontuacaoModel(ataque, defesa, fisico);
    }
    private JogadorModel novoJogador(int idTime, String nome, int idade, PosicaoModel posicao,long preco, int ataque, int defesa, int fisico){
        return new JogadorModel(idTime, nome, idade, posicao, preco, definePontuacao(ataque, defesa, fisico));
    }

    public PosicaoModel recuperaPosicao(String pos){
        return switch (requireNonNull(pos)) {
            case "Goleiro" -> new PosicaoModel(true, false, false, false);
            case "Defensor" -> new PosicaoModel(false, true, false, false);
            case "Meio" -> new PosicaoModel(false, false, true, false);
            case "Atacante" -> new PosicaoModel(false, false, false, true);
            default -> new PosicaoModel(false, false, false, false);
        };
    }

    private List<JogadorModel> geraElencoRealMadrid(){
        int idTime = 1;
        List<JogadorModel> listReal = new ArrayList<>(12);
        listReal.add(novoJogador(idTime,"courtois", 30, recuperaPosicao("Goleiro"), 60000, 20,95,85));
        listReal.add(novoJogador(idTime,"eder militao", 24, recuperaPosicao("Defensor"), 60000, 40,85,75));
        listReal.add(novoJogador(idTime,"casemiro", 30, recuperaPosicao("Meio"), 40000, 75,70,85));
        listReal.add(novoJogador(idTime,"vini jr", 22, recuperaPosicao("Atacante"), 100000, 90,45,95));
        return listReal;
    }

    private List<JogadorModel> geraElencoPSG(){
        int idTime = 2;

        List<JogadorModel> listPSG = new ArrayList<>(12);
        listPSG.add(novoJogador(idTime,"donnarumma", 23, recuperaPosicao("Goleiro"), 50000, 20,95,85));
        listPSG.add(novoJogador(idTime,"sergio ramos", 36, recuperaPosicao("Defensor"), 6000, 60,75,80));
        listPSG.add(novoJogador(idTime,"verratti", 29, recuperaPosicao("Meio"), 50000, 80,65,65));
        listPSG.add(novoJogador(idTime,"neymar", 30, recuperaPosicao("Atacante"), 75000, 95,55,78));

        return listPSG;
    }


}