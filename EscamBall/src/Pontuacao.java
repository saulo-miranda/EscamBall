import java.io.Serializable;

public class Pontuacao implements Serializable {
    private long IdPontuacao;
    private int Geral;
    private int Ataque;
    private int Defesa;
    private int Fisico;

    public Pontuacao(int ataque, int defesa, int fisico){
        this.Ataque = ataque;
        this.Defesa = defesa;
        this.Fisico = fisico;
        setGeral();
    }
    //Get

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
    //Set

    public void setIdPontuacao(long idPontuacao) {
        IdPontuacao = idPontuacao;
    }

    public void setGeral() {
        Geral = (Ataque + Defesa + Fisico)/3;
    }

    public void setAtaque(int ataque) {
        Ataque = ataque;
        setGeral();
    }

    public void setDefesa(int defesa) {
        Defesa = defesa;
        setGeral();
    }

    public void setFisico(int fisico) {
        Fisico = fisico;
        setGeral();
    }
}
