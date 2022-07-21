package main.java.Models;

public class JogadorModel {
    private int IdTime;
    private int IdJogador;
    private String Nome;
    private int Idade;
    private PosicaoModel Posicao;
    private long Preco;
    private PontuacaoModel Pontos;
    private String foto;

    public JogadorModel(int idTime, String nome, int idade, PosicaoModel posicao, long preco, PontuacaoModel pontos) {
        IdTime = idTime;
        Nome = nome;
        Idade = idade;
        Posicao = posicao;
        Preco = preco;
        Pontos = pontos;
    }

    //Getters


    public int getIdTime() {
        return IdTime;
    }

    public int getIdJogador() {
        return IdJogador;
    }

    public String getNome() {
        return Nome;
    }

    public int getIdade() {
        return Idade;
    }

    public PosicaoModel getPosicao() {
        return Posicao;
    }

    public long getPreco() {
        return Preco;
    }

    public PontuacaoModel getPontos() {
        return Pontos;
    }

    public String getFoto() {
        return foto;
    }

    //Setters


    public void setIdTime(int idTime) {
        IdTime = idTime;
    }

    public void setIdJogador(int idJogador) {
        IdJogador = idJogador;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public void setPosicao(PosicaoModel posicao) {
        Posicao = posicao;
    }

    public void setPreco(long preco) {
        Preco = preco;
    }

    public void setPontos(PontuacaoModel pontos) {
        Pontos = pontos;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
