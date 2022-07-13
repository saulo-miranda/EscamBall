/*
 * Classe para criação automática do time ao criar a tabela,
 * evitando que seja preciso cadastrar times e jogadores
 * ao testar o sistema distribuído
 * */
package TimesPadroes;

import Controladores.Jogador;
import Controladores.Pontuacao;
import Controladores.Posicao;
import Controladores.Time;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.*;

public class TimesPadroes {
    private final Time RealMadrid;
    private final Time ParisSaintGermain;

    public TimesPadroes() {
        try {
            RealMadrid = new Time("Arthur", "Real Madrid", "arthur", "3503");
            RealMadrid.setElenco(geraElencoRealMadrid());
            ParisSaintGermain = new Time("Saulo", "Paris Saint Germain", "saulo", "3475");
            ParisSaintGermain.setElenco(geraElencoPSG());

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public Time getRealMadrid() {
        return RealMadrid;
    }

    public Time getParisSaintGermain() {
        return ParisSaintGermain;
    }

    private Posicao escolhePosicao(String pos){
        return switch (requireNonNull(pos)) {
            case "Goleiro" -> new Posicao(true, false, false, false);
            case "Defensor" -> new Posicao(false, true, false, false);
            case "Meio" -> new Posicao(false, false, true, false);
            case "Atacante" -> new Posicao(false, false, false, true);
            default -> new Posicao(false, false, false, false);
        };
    }
    private Pontuacao definePontuacao(int ataque, int defesa, int fisico){
        return new Pontuacao(ataque, defesa, fisico);
    }
    private Jogador novoJogador(String nome, int idade, String posicao,long preco, int ataque, int defesa, int fisico,int idTime){
        return new Jogador(nome, idade, escolhePosicao(posicao), preco, definePontuacao(ataque, defesa, fisico), idTime);
    }
    private List<Jogador> geraElencoRealMadrid(){
        int idTime = 1;
        List<Jogador> listReal = new ArrayList<>(12);
        listReal.add(novoJogador("Courtois", 30, "Goleiro", 60000, 20,95,85,idTime));
        listReal.add(novoJogador("Éder Militão", 24, "Defensor", 60000, 40,85,75,idTime));
        listReal.add(novoJogador("David Alaba", 30, "Defensor", 55000, 40,85,80,idTime));
        listReal.add(novoJogador("Ferland Mendy", 27, "Defensor", 40000, 60,75,80,idTime));
        listReal.add(novoJogador("Daniel Carvajal", 30, "Defensor", 18000, 65,70,75,idTime));
        listReal.add(novoJogador("Casemiro", 30, "Meio", 40000, 75,70,85,idTime));
        listReal.add(novoJogador("Modric", 36, "Meio", 10000, 80,55,70,idTime));
        listReal.add(novoJogador("Kroos", 32, "Meio", 20000, 80,65,65,idTime));
        listReal.add(novoJogador("Valverde", 23, "Atacante", 70000, 80,60,80,idTime));
        listReal.add(novoJogador("Benzema", 34, "Atacante", 30000, 70,55,78,idTime));
        listReal.add(novoJogador("Vini Jr", 22, "Atacante", 100000, 90,45,95,idTime));
        listReal.add(novoJogador("Rodrygo", 21, "Atacante", 60000, 95,40,95,idTime));

        return listReal;
    }

    private List<Jogador> geraElencoPSG(){
        int idTime = 2;

        List<Jogador> listPSG = new ArrayList<>(12);
        listPSG.add(novoJogador("Donnarumma", 23, "Goleiro", 50000, 20,95,85,idTime));
        listPSG.add(novoJogador("Marquinhos", 28, "Defensor", 70000, 40,85,75,idTime));
        listPSG.add(novoJogador("Kimpembe", 26, "Defensor", 40000, 40,85,80,idTime));
        listPSG.add(novoJogador("Sérgio Ramos", 36, "Defensor", 6000, 60,75,80,idTime));
        listPSG.add(novoJogador("Kurzawa", 29, "Defensor", 5000, 65,70,75,idTime));
        listPSG.add(novoJogador("Hakimi", 23, "Defensor", 65000, 75,70,85,idTime));
        listPSG.add(novoJogador("Paredes", 28, "Meio", 17000, 80,55,70,idTime));
        listPSG.add(novoJogador("Verratti", 29, "Meio", 50000, 80,65,65,idTime));
        listPSG.add(novoJogador("Wijnaldum", 31, "Meio", 18000, 80,60,80,idTime));
        listPSG.add(novoJogador("Neymar", 30, "Atacante", 75000, 95,55,78,idTime));
        listPSG.add(novoJogador("Messi", 35, "Atacante", 50000, 99,45,95,idTime));
        listPSG.add(novoJogador("Mbappé", 23, "Atacante", 160000, 95,40,95,idTime));

        return listPSG;
    }


}
