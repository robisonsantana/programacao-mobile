package guy.voltaic.cadastrotimejogador.controller;

import guy.voltaic.cadastrotimejogador.model.Jogador;
import guy.voltaic.cadastrotimejogador.persistence.JogadorDao;

import java.sql.SQLException;
import java.util.List;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class JogadorController implements IController<Jogador> {
    private final JogadorDao jDao;

    public JogadorController(JogadorDao jDao) {
        this.jDao = jDao;
    }

    @Override
    public void inserir(Jogador jogador) throws SQLException {
        if(jDao.open() == null) {
            jDao.open();
        }
        jDao.insert(jogador);
        System.out.println("Jogador inserido: " + jogador);
        jDao.close();
    }

    @Override
    public void atualizar(Jogador jogador) throws SQLException {
        if(jDao.open() == null) {
            jDao.open();
        }
        jDao.update(jogador);
        System.out.println("Jogador inserido: " + jogador);
        jDao.close();
    }

    @Override
    public void deletar(Jogador jogador) throws SQLException {
        if(jDao.open() == null) {
            jDao.open();
        }
        jDao.delete(jogador);
        System.out.println("Jogador inserido: " + jogador);
        jDao.close();
    }

    @Override
    public Jogador procurarUm(Jogador jogador) throws SQLException {
        if(jDao.open() == null) {
            jDao.open();
        }
        return jDao.findOne(jogador);
    }

    @Override
    public List<Jogador> procurarTodos() throws SQLException {
        if(jDao.open() == null) {
            jDao.open();
        }
        return jDao.findAll();
    }
}

