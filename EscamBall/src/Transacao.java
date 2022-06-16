import java.util.List;

public class Transacao {
    private String Criador;
    private String Receptor;
    private List<Jogador> GrupoCriador;
    private List<Jogador> GrupoReceptor;
    private boolean Contraproposta;
    private boolean Finalizada;

    public Transacao(String criador, String receptor, List<Jogador> grupoCriador, List<Jogador> grupoReceptor) {
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

    public List<Jogador> getGrupoCriador() {
        return GrupoCriador;
    }

    public List<Jogador> getGrupoReceptor() {
        return GrupoReceptor;
    }

    public boolean isContraproposta() {
        return Contraproposta;
    }

    public boolean isFinalizada() {
        return Finalizada;
    }
    //SET
    public void setGrupoCriador(List<Jogador> grupoCriador) {
        GrupoCriador = grupoCriador;
    }

    public void setGrupoReceptor(List<Jogador> grupoReceptor) {
        GrupoReceptor = grupoReceptor;
    }

    public void fazerContraproposta() {
        Contraproposta = true;
    }

    public void finalizar() {
        Finalizada = true;
    }
}
