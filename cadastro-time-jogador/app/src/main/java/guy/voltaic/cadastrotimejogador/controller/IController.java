package guy.voltaic.cadastrotimejogador.controller;

import java.sql.SQLException;
import java.util.List;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
import java.sql.SQLException;
import java.util.List;

public interface IController<T> {
    void inserir(T obj) throws SQLException;
    void atualizar(T obj) throws SQLException;
    void deletar(T obj) throws SQLException;
    T procurarUm(T obj) throws SQLException;
    List<T> procurarTodos() throws SQLException;
}

