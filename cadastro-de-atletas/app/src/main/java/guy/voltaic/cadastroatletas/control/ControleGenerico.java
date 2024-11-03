package guy.voltaic.cadastroatletas.control;

import java.util.List;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public interface ControleGenerico<T> {
    void cadastrar(T item);
    List<T> listar();
    T buscar(String nome);
    boolean remover(String nome);
}
