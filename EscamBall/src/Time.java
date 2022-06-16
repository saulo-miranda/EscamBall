import java.util.ArrayList;
import java.util.List;

public class Time {
    private String Nome;
    private List<Jogador> Elenco;

    public Time(String nome){
        this.Nome = nome;
        this.Elenco = new ArrayList<Jogador>();
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

    public boolean adicionarJogador(String nome, int idade, List<String> posicoes, long preco, int ataque, int defesa, int fisico){
         return Elenco.add(new Jogador(nome, idade, posicoes, preco, ataque, defesa, fisico));
    }

    public boolean removerJogador(Jogador jogador){
        return Elenco.remove(jogador);
    }
    public List<Jogador> buscarJogadorMeuTime(String nome){
        return Elenco.stream().filter(x -> x.getNome() == nome).toList();
    }
}
