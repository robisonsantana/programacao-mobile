package guy.voltaic.cadastrotimejogador.controller;

import java.sql.SQLException;
import java.util.List;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public interface IController<T> {
    void inserir(T t) throws SQLException;
    void atualizar(T t) throws SQLException;
    void deletar(T t) throws SQLException;
    T procurarUm(T t) throws SQLException;
    List<T> procurarTodos() throws SQLException;
}
