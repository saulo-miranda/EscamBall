import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;

public class Time implements Serializable{
    private String Nome;
    private final List<Jogador> Elenco;

    private String NomeDono;
    private String Login;
    private String Senha;

    public Time(String nome, String nomeDono, String login, String senha){
        this.Nome = nome;
        this.Elenco = new ArrayList<>();
        NomeDono = nomeDono;
        Login = login;
        Senha = senha;
    }
    //GET

    public String getNomeDono() {
        return NomeDono;
    }

    public String getLogin() {
        return Login;
    }

    public String getSenha() {
        return Senha;
    }

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

    public boolean adicionarJogador(String nome, int idade, Posicao posicoes, long preco, Pontuacao pontos){
         return Elenco.add(new Jogador(nome, idade, posicoes, preco,pontos));
    }

    public boolean removerJogador(Jogador jogador){
        return Elenco.remove(jogador);
    }
    public List<Jogador> buscarJogadorMeuTime(String nome){
        return Elenco.stream().filter(x -> Objects.equals(x.getNome(), nome)).toList();
    }
}
