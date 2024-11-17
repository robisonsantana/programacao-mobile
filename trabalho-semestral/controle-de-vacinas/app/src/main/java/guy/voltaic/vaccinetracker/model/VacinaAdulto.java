package guy.voltaic.vaccinetracker.model;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class VacinaAdulto extends Vacina {
    private boolean necessitaReforco;

    public boolean isNecessitaReforco() {
        return necessitaReforco;
    }

    public void setNecessitaReforco(boolean necessitaReforco) {
        this.necessitaReforco = necessitaReforco;
    }

    @Override
    public String calcularIntervaloProximaDose() {
        return necessitaReforco ? "Reforço necessário em 1 ano." : "Dose única.";
    }
}

