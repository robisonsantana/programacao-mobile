package guy.voltaic.vendadeingressos.model;

public class Ingresso {
    private String codigoIdentificador;
    private float valor;

    public Ingresso(String codigoIdentificador, float valor) {
        this.codigoIdentificador = codigoIdentificador;
        this.valor = valor;
    }

    public float valorFinal(float taxaConveniencia) {
        return valor + taxaConveniencia;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public float getValor() {
        return valor;
    }
}
