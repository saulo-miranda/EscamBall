package main.java.Models;

public class TransacaoModel {
    private int transacaoId;
    private int timePropostaId;
    private int timeReceptorId;
    private int jogadorOferecidoId;
    private int jogadorDesejadoId;
    private boolean transacaoAceita;
    private boolean transacaoFinalizada;

    public TransacaoModel() {}

    public int getTransacaoId() {
        return transacaoId;
    }

    public void setTransacaoId(int transacaoId) {
        this.transacaoId = transacaoId;
    }

    public int getTimePropostaId() {
        return timePropostaId;
    }

    public void setTimePropostaId(int timePropostaId) {
        this.timePropostaId = timePropostaId;
    }

    public int getTimeReceptorId() {
        return timeReceptorId;
    }

    public void setTimeReceptorId(int timeReceptorId) {
        this.timeReceptorId = timeReceptorId;
    }

    public int getJogadorOferecidoId() {
        return jogadorOferecidoId;
    }

    public void setJogadorOferecidoId(int jogadorOferecidoId) {
        this.jogadorOferecidoId = jogadorOferecidoId;
    }

    public int getJogadorDesejadoId() {
        return jogadorDesejadoId;
    }

    public void setJogadorDesejadoId(int jogadorDesejadoId) {
        this.jogadorDesejadoId = jogadorDesejadoId;
    }

    public boolean isTransacaoAceita() {
        return transacaoAceita;
    }

    public void setTransacaoAceita(boolean transacaoAceita) {
        this.transacaoAceita = transacaoAceita;
    }

    public boolean isTransacaoFinalizada() {
        return transacaoFinalizada;
    }

    public void setTransacaoFinalizada(boolean transacaoFinalizada) {
        this.transacaoFinalizada = transacaoFinalizada;
    }
}
