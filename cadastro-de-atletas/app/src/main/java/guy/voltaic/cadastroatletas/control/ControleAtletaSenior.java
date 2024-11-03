package guy.voltaic.cadastroatletas.control;

import java.util.ArrayList;
import java.util.List;
import guy.voltaic.cadastroatletas.model.*;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class ControleAtletaSenior implements ControleGenerico<AtletaSenior> {
    private List<AtletaSenior> atletasSeniores = new ArrayList<>();

    @Override
    public void cadastrar(AtletaSenior atleta) {
        atletasSeniores.add(atleta);
    }

    @Override
    public List<AtletaSenior> listar() {
        return new ArrayList<>(atletasSeniores);
    }

    @Override
    public AtletaSenior buscar(String nome) {
        for (AtletaSenior atleta : atletasSeniores) {
            if (atleta.getNome().equalsIgnoreCase(nome)) {
                return atleta;
            }
        }
        return null;
    }

    @Override
    public boolean remover(String nome) {
        AtletaSenior atleta = buscar(nome);
        if (atleta != null) {
            atletasSeniores.remove(atleta);
            return true;
        }
        return false;
    }
}

