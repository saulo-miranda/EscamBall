package Controladores;

import java.io.Serializable;

public class Requisicao implements Serializable {
    Parametros parametro;
    Object value;

    public Requisicao(Parametros parametro, Object value) {
        this.parametro = parametro;
        this.value = value;
    }

    public Parametros getParametro() {
        return parametro;
    }

    public void setParametro(Parametros parametro) {
        this.parametro = parametro;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
