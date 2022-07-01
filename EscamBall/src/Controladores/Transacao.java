package Controladores;

import java.io.Serializable;
import java.util.List;

public class Transacao implements Serializable {
    private int IdTransacao;
    private int Criador;
    private int Receptor;
    private Jogador GrupoCriador;
    private Jogador GrupoReceptor;
    private boolean Contraproposta;
    private boolean Finalizada;

    public Transacao(int criador, int receptor, Jogador grupoCriador, Jogador grupoReceptor) {
        Criador = criador;
        Receptor = receptor;
        GrupoCriador = grupoCriador;
        GrupoReceptor = grupoReceptor;
        Contraproposta = false;
        Finalizada = false;
    }
    //GET
    public int getCriador() {
        return Criador;
    }

    public int getReceptor() {
        return Receptor;
    }

    public Jogador getGrupoCriador() {
        return GrupoCriador;
    }

    public Jogador getGrupoReceptor() {
        return GrupoReceptor;
    }

    public boolean isContraproposta() {
        return Contraproposta;
    }

    public boolean isFinalizada() {
        return Finalizada;
    }

    public int getIdTransacao() {
        return IdTransacao;
    }

    //SET
    public void setGrupoCriador(Jogador grupoCriador) {
        GrupoCriador = grupoCriador;
    }

    public void setGrupoReceptor(Jogador grupoReceptor) {
        GrupoReceptor = grupoReceptor;
    }

    public void setIdTransacao(int idTransacao) {
        IdTransacao = idTransacao;
    }

    public void setCriador(int criador) {
        Criador = criador;
    }

    public void setReceptor(int receptor) {
        Receptor = receptor;
    }

    public void setFinalizada(boolean finalizada) {
        Finalizada = finalizada;
    }
}
