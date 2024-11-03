package guy.voltaic.cadastroatletas.control;

import java.util.List;

public interface ControleGenerico<T> {
    void cadastrar(T item);
    List<T> listar();
    T buscar(String nome);
    boolean remover(String nome);
}
