package guy.voltaic.cadastroatletas.control;

import java.util.ArrayList;
import java.util.List;
import guy.voltaic.cadastroatletas.model.*;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class ControleAtletaJuvenil implements ControleGenerico<AtletaJuvenil> {
    private List<AtletaJuvenil> atletasJuvenis = new ArrayList<>();

    @Override
    public void cadastrar(AtletaJuvenil atleta) {
        atletasJuvenis.add(atleta);
    }

    @Override
    public List<AtletaJuvenil> listar() {
        return new ArrayList<>(atletasJuvenis);
    }

    @Override
    public AtletaJuvenil buscar(String nome) {
        for (AtletaJuvenil atleta : atletasJuvenis) {
            if (atleta.getNome().equalsIgnoreCase(nome)) {
                return atleta;
            }
        }
        return null;
    }

    @Override
    public boolean remover(String nome) {
        AtletaJuvenil atleta = buscar(nome);
        if (atleta != null) {
            atletasJuvenis.remove(atleta);
            return true;
        }
        return false;
    }
}

