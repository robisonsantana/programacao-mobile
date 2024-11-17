package guy.voltaic.vaccinetracker.controller;

import java.util.List;
import guy.voltaic.vaccinetracker.model.Vacina;

import java.sql.SQLException;
import java.util.List;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public interface IRegistroVacina {

    void inserir(Vacina vacina) throws SQLException;
    void atualizar(Vacina vacina) throws SQLException;
    void deletar(Vacina vacina) throws SQLException;
    Vacina procurarUm(int id) throws SQLException;
    List<Vacina> procurarTodos() throws SQLException;
}



