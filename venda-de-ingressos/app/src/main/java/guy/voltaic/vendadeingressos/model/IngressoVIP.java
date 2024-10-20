package guy.voltaic.vendadeingressos.model;

public class IngressoVIP extends Ingresso {
    private String funcaoDesempenhada;

    public IngressoVIP(String codigoIdentificador, float valor, String funcaoDesempenhada) {
        super(codigoIdentificador, valor);
        this.funcaoDesempenhada = funcaoDesempenhada;
    }

    @Override
    public float valorFinal(float taxaConveniencia) {
        return super.valorFinal(taxaConveniencia) * 1.18f; // Acrescenta 18% para ingressos VIP
    }

    public String getFuncaoDesempenhada() {
        return funcaoDesempenhada;
    }
}
