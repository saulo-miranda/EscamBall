import java.io.Serializable;
import java.util.List;

public class Jogador implements Serializable {
    private String Nome;
    private int Idade;
    private List<String> Posicoes;
    private long Preco;
    private final Pontuacao Pontos;
    private String foto; // AINDA PRECISAMOS DECIDIR COMO SERÁ TRATADA A FOTO DO JOGADOR

    public Jogador(String nome, int idade, List<String> posicoes, long preco, Pontuacao pontos) {
        Nome = nome;
        Idade = idade;
        Posicoes = posicoes;
        Preco = preco;
        Pontos = pontos;
    }
    //GET
    public String getNome() {
        return Nome;
    }

    public int getIdade() {
        return Idade;
    }

    public List<String> getPosicoes() {
        return Posicoes;
    }

    public long getPreco() {
        return Preco;
    }

    public Pontuacao getPontos() {
        return Pontos;
    }
    //SET

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public void setPosicoes(List<String> posicoes) {
        Posicoes = posicoes;
    }

    public void setPreco(long preco) {
        Preco = preco;
    }

    public void setPontosAtaque(int ataque) {
        Pontos.setAtaque(ataque);
    }

    public void setPontosDefesa(int defesa) {
        Pontos.setDefesa(defesa);
    }

    public void setPontosFisico(int fisico) {
        Pontos.setFisico(fisico);
    }
}
