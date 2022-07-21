package main.java.Models;

public class TransacaoModel {
    private int IdTransacao;
    private int idTimeProposta;
    private int idTimeReceptor;
    private JogadorModel jogadorProposto;
    private JogadorModel jogadorDesejado;
    private boolean Aceita;
    private boolean Finalizada;

    public TransacaoModel(int idTimeProposta, int idTimeReceptor, JogadorModel jogadorProposto, JogadorModel jogadorDesejado) {
        this.idTimeProposta = idTimeProposta;
        this.idTimeReceptor = idTimeReceptor;
        this.jogadorProposto = jogadorProposto;
        this.jogadorDesejado = jogadorDesejado;
        this.Aceita = false;
        this.Finalizada = false;
    }

    //Getters


    public int getIdTransacao() {
        return IdTransacao;
    }

    public int getIdTimeProposta() {
        return idTimeProposta;
    }

    public int getIdTimeReceptor() {
        return idTimeReceptor;
    }

    public JogadorModel getJogadorProposto() {
        return jogadorProposto;
    }

    public JogadorModel getJogadorDesejado() {
        return jogadorDesejado;
    }

    public boolean isAceita() {
        return Aceita;
    }

    public boolean isFinalizada() {
        return Finalizada;
    }

    //Setters


    public void setIdTransacao(int idTransacao) {
        IdTransacao = idTransacao;
    }

    public void setIdTimeProposta(int idTimeProposta) {
        this.idTimeProposta = idTimeProposta;
    }

    public void setIdTimeReceptor(int idTimeReceptor) {
        this.idTimeReceptor = idTimeReceptor;
    }

    public void setJogadorProposto(JogadorModel jogadorProposto) {
        this.jogadorProposto = jogadorProposto;
    }

    public void setJogadorDesejado(JogadorModel jogadorDesejado) {
        this.jogadorDesejado = jogadorDesejado;
    }

    public void setAceita(boolean aceita) {
        Aceita = aceita;
    }

    public void setFinalizada(boolean finalizada) {
        Finalizada = finalizada;
    }
}
