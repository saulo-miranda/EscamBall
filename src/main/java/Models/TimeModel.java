package main.java.Models;

import java.util.List;

public class TimeModel {
    private int timeId;
    private String nomeDono;
    private String nomeTime;
    private String login;
    private String senha;
    private List<JogadorModel> jogadores;

    public TimeModel() {
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<JogadorModel> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<JogadorModel> jogadores) {
        this.jogadores = jogadores;
    }
}
