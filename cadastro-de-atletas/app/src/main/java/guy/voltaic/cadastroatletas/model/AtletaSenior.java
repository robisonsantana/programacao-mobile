package guy.voltaic.cadastroatletas.model;

import androidx.annotation.NonNull;

public class AtletaSenior extends Atleta {
    private String temProblemasCardiacos;

    public String getTemProblemasCardiacos() {
        return temProblemasCardiacos;
    }

    public void setTemProblemasCardiacos(String temProblemasCardiacos) {
        this.temProblemasCardiacos = temProblemasCardiacos;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + ", Problemas Cardíacos: " + temProblemasCardiacos;
    }
}

