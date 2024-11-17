package guy.voltaic.vaccinetracker.model;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class VacinaInfantil extends Vacina {
    private int idadeAplicacao;

    public int getIdadeAplicacao() {
        return idadeAplicacao;
    }

    public void setIdadeAplicacao(int idadeAplicacao) {
        this.idadeAplicacao = idadeAplicacao;
    }

    @Override
    public String calcularIntervaloProximaDose() {
        return "Consultar calendário infantil para o próximo intervalo.";
    }
}

