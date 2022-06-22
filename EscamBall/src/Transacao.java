import java.util.List;

public class Transacao {
    private String Criador;
    private String Receptor;
    private Jogador GrupoCriador;
    private Jogador GrupoReceptor;
    private boolean Contraproposta;
    private boolean Finalizada;

    public Transacao(String criador, String receptor, Jogador grupoCriador, Jogador grupoReceptor) {
        Criador = criador;
        Receptor = receptor;
        GrupoCriador = grupoCriador;
        GrupoReceptor = grupoReceptor;
        Contraproposta = false;
        Finalizada = false;
    }
    //GET
    public String getCriador() {
        return Criador;
    }

    public String getReceptor() {
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
    //SET
    public void setGrupoCriador(Jogador grupoCriador) {
        GrupoCriador = grupoCriador;
    }

    public void setGrupoReceptor(Jogador grupoReceptor) {
        GrupoReceptor = grupoReceptor;
    }

    public void fazerContraproposta() {
        Contraproposta = true;
    }

    public void finalizar() {
        Finalizada = true;
    }
}
