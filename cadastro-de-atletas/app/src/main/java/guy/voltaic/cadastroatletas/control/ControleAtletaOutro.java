package guy.voltaic.cadastroatletas.control;

import java.util.ArrayList;
import java.util.List;
import guy.voltaic.cadastroatletas.model.*;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class ControleAtletaOutro implements ControleGenerico<AtletaOutro> {
    private List<AtletaOutro> atletasOutros = new ArrayList<>();

    @Override
    public void cadastrar(AtletaOutro atleta) {
        atletasOutros.add(atleta);
    }

    @Override
    public List<AtletaOutro> listar() {
        return new ArrayList<>(atletasOutros);
    }

    @Override
    public AtletaOutro buscar(String nome) {
        for (AtletaOutro atleta : atletasOutros) {
            if (atleta.getNome().equalsIgnoreCase(nome)) {
                return atleta;
            }
        }
        return null;
    }

    @Override
    public boolean remover(String nome) {
        AtletaOutro atleta = buscar(nome);
        if (atleta != null) {
            atletasOutros.remove(atleta);
            return true;
        }
        return false;
    }
}
