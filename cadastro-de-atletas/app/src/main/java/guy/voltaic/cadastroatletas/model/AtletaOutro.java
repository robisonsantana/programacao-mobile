package guy.voltaic.cadastroatletas.model;

import androidx.annotation.NonNull;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class AtletaOutro extends Atleta {
    private String academia;
    private String recordeSegundos;

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public String getRecordeSegundos() {
        return recordeSegundos;
    }

    public void setRecordeSegundos(String recordeSegundos) {
        this.recordeSegundos = recordeSegundos;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + ", Academia: " + academia + ", Recorde (segundos): " + recordeSegundos;
    }
}

