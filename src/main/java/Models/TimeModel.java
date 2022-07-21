package main.java.Models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

public class TimeModel {
    private int IdTime;
    private String NomeDono;
    private String NomeTime;
    private String Login;
    private String Senha;
    private List<JogadorModel> Elenco;

    public TimeModel(String nomeDono, String nomeTime, String login, String senha) {
        NomeDono = nomeDono;
        NomeTime = nomeTime;
        Login = login;
        try {
            Senha = geraHashSenha(senha);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    //Getters


    public int getIdTime() {
        return IdTime;
    }

    public String getNomeDono() {
        return NomeDono;
    }

    public String getNomeTime() {
        return NomeTime;
    }

    public String getLogin() {
        return Login;
    }

    public String getSenha() {
        return Senha;
    }

    public List<JogadorModel> getElenco() {
        return Elenco;
    }

    //Setters


    public void setIdTime(int idTime) {
        IdTime = idTime;
    }

    public void setNomeDono(String nomeDono) {
        NomeDono = nomeDono;
    }

    public void setNomeTime(String nomeTime) {
        NomeTime = nomeTime;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public void setElenco(List<JogadorModel> elenco) {
        Elenco = elenco;
    }

    //Extra Methods

    private String geraHashSenha(String senha) throws NoSuchAlgorithmException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = algorithm.digest(senha.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) hexString.append(String.format("%02X", 0xFF & b));
        return hexString.toString();
    }

    public void adicionaJogador(JogadorModel jogador){
        Elenco.add(jogador);
    }

    public boolean removeJogador(JogadorModel jogador){
        return Elenco.remove(jogador);
    }
    public List<JogadorModel> buscaJogador(String nome){
        return Elenco.stream().filter(x -> Objects.equals(x.getNome(), nome)).toList();
    }
}
