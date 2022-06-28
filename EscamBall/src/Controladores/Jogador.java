package Controladores;

import java.io.Serializable;
import java.util.List;

public class Jogador implements Serializable {
    private int IdJogador;
    private int idTime;
    private String Nome;
    private int Idade;
    private Posicao Posicoes;
    private long Preco;
    private final Pontuacao Pontos;
    private String foto; // AINDA PRECISAMOS DECIDIR COMO SERÁ TRATADA A FOTO DO JOGADOR
    private int IdTime;

    public Jogador(String nome, int idade, Posicao posicoes, long preco, Pontuacao pontos, int time) {
        Nome = nome;
        Idade = idade;
        Posicoes = posicoes;
        Preco = preco;
        Pontos = pontos;
        IdTime = time;
    }
    //GET
    public String getNome() {
        return Nome;
    }

    public int getIdade() {
        return Idade;
    }

    public Posicao getPosicoes() {
        return Posicoes;
    }

    public long getPreco() {
        return Preco;
    }

    public Pontuacao getPontos() {
        return Pontos;
    }

    public int getIdJogador() {
        return IdJogador;
    }

    public int getIdTime() {
        return IdTime;
    }

    //SET
    public void setNome(String nome) {
        Nome = nome;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public void setPosicoes(Posicao posicoes) {
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

    public void setIdJogador(int idJogador) {
        IdJogador = idJogador;
    }

    public void setIdTime(int idTime) {
        IdTime = idTime;
    }

    public void resumo(){
        System.out.println("RESUMO ----");
        System.out.println(this.Nome);
        System.out.println(this.Pontos.getGeral());
    }
}
