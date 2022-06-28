public class Posicao {

    private int IdPosicao;
    private boolean Goleiro;
    private boolean Zagueiro;
    private boolean MeioCampista;
    private boolean Atacante;

    public Posicao(boolean g, boolean z, boolean m, boolean a){
        Goleiro = g;
        Zagueiro = z;
        MeioCampista = m;
        Atacante = a;
    }
    public boolean isGoleiro() {
        return Goleiro;
    }

    public boolean isZagueiro() {
        return Zagueiro;
    }

    public boolean isMeioCampista() {
        return MeioCampista;
    }

    public boolean isAtacante() {
        return Atacante;
    }

    public void setGoleiro(boolean goleiro) {
        Goleiro = goleiro;
    }

    public void setZagueiro(boolean zagueiro) {
        Zagueiro = zagueiro;
    }

    public void setMeioCampista(boolean meioCampista) {
        MeioCampista = meioCampista;
    }
    public void setAtacante(boolean atacante) {
        Atacante = atacante;
    }

    public int getIdPosicao() {
        return IdPosicao;
    }

    public void setIdPosicao(int idPosicao) {
        IdPosicao = idPosicao;
    }
}
