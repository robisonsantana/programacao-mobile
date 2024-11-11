package guy.voltaic.cadastrotimejogador.controller;

import guy.voltaic.cadastrotimejogador.model.Time;
import guy.voltaic.cadastrotimejogador.persistence.TimeDao;

import java.sql.SQLException;
import java.util.List;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class TimeController implements IController<Time> {

    private final TimeDao tDao;

    public TimeController(TimeDao tDao) {
        this.tDao = tDao;
    }

    @Override
    public void inserir(Time time) throws SQLException {
        if(tDao.open() == null) {
            tDao.open();
        }
        tDao.insert(time);
        System.out.println("Time inserido: " + time);
        tDao.close();
    }

    @Override
    public void atualizar(Time time) throws SQLException {
        if(tDao.open() == null) {
            tDao.open();
        }
        tDao.update(time);
        System.out.println("Time atualizado: " + time);
        tDao.close();
    }

    @Override
    public void deletar(Time time) throws SQLException {
        if(tDao.open() == null) {
            tDao.open();
        }
        tDao.delete(time);
        System.out.println("Time deletado: " + time);
        tDao.close();
    }

    @Override
    public Time procurarUm(Time time) throws SQLException {
        if(tDao.open() == null) {
            tDao.open();
        }
        return tDao.findOne(time);
    }

    @Override
    public List<Time> procurarTodos() throws SQLException {
        if(tDao.open() == null) {
            tDao.open();
        }
        return tDao.findAll();
    }
}
