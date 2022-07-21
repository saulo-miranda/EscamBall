package main.java.Models;

public class PontuacaoModel {
    private long IdPontuacao;
    private int Geral;
    private int Ataque;
    private int Defesa;
    private int Fisico;

    public PontuacaoModel(int ataque, int defesa, int fisico) {
        Ataque = ataque;
        Defesa = defesa;
        Fisico = fisico;
        Geral = (ataque+defesa+fisico)/3;
    }

    //Getters


    public long getIdPontuacao() {
        return IdPontuacao;
    }

    public int getGeral() {
        return Geral;
    }

    public int getAtaque() {
        return Ataque;
    }

    public int getDefesa() {
        return Defesa;
    }

    public int getFisico() {
        return Fisico;
    }

    //Setters


    public void setIdPontuacao(long idPontuacao) {
        IdPontuacao = idPontuacao;
    }

    public void setGeral(int geral) {
        Geral = geral;
    }

    public void setAtaque(int ataque) {
        Ataque = ataque;
    }

    public void setDefesa(int defesa) {
        Defesa = defesa;
    }

    public void setFisico(int fisico) {
        Fisico = fisico;
    }
}
