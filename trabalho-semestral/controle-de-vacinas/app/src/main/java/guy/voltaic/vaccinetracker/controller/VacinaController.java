package guy.voltaic.vaccinetracker.controller;

import java.sql.SQLException;
import java.util.List;

import guy.voltaic.vaccinetracker.model.Vacina;
import guy.voltaic.vaccinetracker.persistence.VacinaDao;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class VacinaController implements IRegistroVacina {

    private final VacinaDao vacinaDao;

    public VacinaController(VacinaDao vacinaDao) {
        this.vacinaDao = vacinaDao;
    }

    @Override
    public void inserir(Vacina vacina) throws SQLException {
        vacinaDao.insert(vacina);
        System.out.println("Vacina inserida: " + vacina);
    }

    @Override
    public void atualizar(Vacina vacina) throws SQLException {
        vacinaDao.update(vacina);
        System.out.println("Vacina atualizada: " + vacina);
    }

    @Override
    public void deletar(Vacina vacina) throws SQLException {
        vacinaDao.delete(vacina);
        System.out.println("Vacina deletada: " + vacina);
    }

    @Override
    public Vacina procurarUm(int id) throws SQLException {
        return vacinaDao.findOne(id);
    }

    @Override
    public List<Vacina> procurarTodos() throws SQLException {
        return vacinaDao.findAll();
    }
}




