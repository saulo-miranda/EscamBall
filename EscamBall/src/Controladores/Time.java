package Controladores;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;

public class Time implements Serializable{
    private int IdTime;
    private String NomeDono;
    private String NomeTime;
    private String Login;
    private String Senha;
    private List<Jogador> Elenco;

    public Time(String nomeDono, String nomeTime, String login, String senha) throws NoSuchAlgorithmException {
        this.NomeTime = nomeTime;
        this.NomeDono = nomeDono;
        this.Login = login;
        this.Senha = this.geraHashSenha(senha);
        this.Elenco = new ArrayList<>();
    }

    private String geraHashSenha(String senha) throws NoSuchAlgorithmException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = algorithm.digest(senha.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        return hexString.toString();
    }

    public String getNomeDono() {
        return NomeDono;
    }

    public void setNomeDono(String nomeDono) {
        NomeDono = nomeDono;
    }

    public String getNomeTime() {
        return NomeTime;
    }

    public void setNomeTime(String nomeTime) {
        NomeTime = nomeTime;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) throws NoSuchAlgorithmException {
        Senha = geraHashSenha(senha);
    }

    public List<Jogador> getElenco() {
        return Elenco;
    }

    public boolean adicionarJogador(String nome, int idade, Posicao posicoes, long preco, Pontuacao pontos, int idTime){
         return Elenco.add(new Jogador(nome, idade, posicoes, preco,pontos, idTime));
    }

    public boolean removerJogador(Jogador jogador){
        return Elenco.remove(jogador);
    }
    public List<Jogador> buscarJogadorMeuTime(String nome){
        return Elenco.stream().filter(x -> Objects.equals(x.getNome(), nome)).toList();
    }

    public int getIdTime() {
        return IdTime;
    }

    public void setIdTime(int idTime) {
        IdTime = idTime;
    }
    public void carregarElenco(List<Jogador> lista){
        this.Elenco = lista;
    }
}
