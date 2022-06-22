public class Posicao {
    private boolean Goleiro;
    private boolean Zagueiro;
    private boolean LateralEsquerdo;
    private boolean LateralDireito;
    private boolean Volante;
    private boolean MeioCampista;
    private boolean PontaEsquerda;
    private boolean PontaDireita;
    private boolean Atacante;

    public Posicao(boolean g, boolean z, boolean le, boolean ld, boolean v, boolean m, boolean pe, boolean pd, boolean a){
        Goleiro = g;
        Zagueiro = z;
        LateralEsquerdo = le;
        LateralDireito = ld;
        Volante = v;
        MeioCampista = m;
        PontaEsquerda = pe;
        PontaDireita = pd;
        Atacante = a;
    }

    public boolean isGoleiro() {
        return Goleiro;
    }

    public boolean isZagueiro() {
        return Zagueiro;
    }

    public boolean isLateralEsquerdo() {
        return LateralEsquerdo;
    }

    public boolean isLateralDireito() {
        return LateralDireito;
    }

    public boolean isVolante() {
        return Volante;
    }

    public boolean isMeioCampista() {
        return MeioCampista;
    }

    public boolean isPontaEsquerda() {
        return PontaEsquerda;
    }

    public boolean isPontaDireita() {
        return PontaDireita;
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

    public void setLateralEsquerdo(boolean lateralEsquerdo) {
        LateralEsquerdo = lateralEsquerdo;
    }

    public void setLateralDireito(boolean lateralDireito) {
        LateralDireito = lateralDireito;
    }

    public void setVolante(boolean volante) {
        Volante = volante;
    }

    public void setMeioCampista(boolean meioCampista) {
        MeioCampista = meioCampista;
    }

    public void setPontaEsquerda(boolean pontaEsquerda) {
        PontaEsquerda = pontaEsquerda;
    }

    public void setPontaDireita(boolean pontaDireita) {
        PontaDireita = pontaDireita;
    }

    public void setAtacante(boolean atacante) {
        Atacante = atacante;
    }
}
