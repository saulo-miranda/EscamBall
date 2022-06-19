import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Time {
    private String Nome;
    private final List<Jogador> Elenco;

    public Time(String nome){
        this.Nome = nome;
        this.Elenco = new ArrayList<>();
    }
    //GET
    public String getNome() {
        return Nome;
    }

    public List<Jogador> getElenco() {
        return Elenco;
    }
    //SET
    public void setNome(String nome) {
        Nome = nome;
    }

    public boolean adicionarJogador(String nome, int idade, List<String> posicoes, long preco, Pontuacao pontos){
         return Elenco.add(new Jogador(nome, idade, posicoes, preco,pontos));
    }

    public boolean removerJogador(Jogador jogador){
        return Elenco.remove(jogador);
    }
    public List<Jogador> buscarJogadorMeuTime(String nome){
        return Elenco.stream().filter(x -> Objects.equals(x.getNome(), nome)).toList();
    }
}
