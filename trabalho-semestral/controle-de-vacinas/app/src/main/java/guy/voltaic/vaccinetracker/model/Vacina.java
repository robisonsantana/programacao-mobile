package guy.voltaic.vaccinetracker.model;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public abstract class Vacina {
    private int id;
    private String nomeVacina;
    private String dataAplicacao;
    private String lote;
    private String responsavelAplicacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nomeVacina;
    }

    public void setNome(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(String dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getResponsavelAplicacao() {
        return responsavelAplicacao;
    }

    public void setResponsavelAplicacao(String responsavelAplicacao) {
        this.responsavelAplicacao = responsavelAplicacao;
    }

    public abstract String calcularIntervaloProximaDose();

    @Override
    public String toString() {
        return "Vacina ID: " + id + "\n" +
                "Nome da Vacina: " + nomeVacina + "\n" +
                "Data de Aplicação: " + dataAplicacao + "\n" +
                "Lote: " + lote + "\n" +
                "Responsável pela Aplicação: " + responsavelAplicacao + "\n" +
                "------------------------------------------------------------------------------------\n";
    }
}

