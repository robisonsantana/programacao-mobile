package guy.voltaic.cadastroatletas.model;

import androidx.annotation.NonNull;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class AtletaJuvenil extends Atleta {
    private int anosDePratica;

    public int getAnosDePratica() {
        return anosDePratica;
    }

    public void setAnosDePratica(int anosDePratica) {
        this.anosDePratica = anosDePratica;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + ", Anos de Prática: " + anosDePratica;
    }
}

