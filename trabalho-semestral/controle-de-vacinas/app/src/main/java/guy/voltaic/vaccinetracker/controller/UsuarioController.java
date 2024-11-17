package guy.voltaic.vaccinetracker.controller;

import java.sql.SQLException;
import java.util.List;

import guy.voltaic.vaccinetracker.model.Usuario;
import guy.voltaic.vaccinetracker.persistence.UsuarioDao;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class UsuarioController {

    private final UsuarioDao usuarioDao;

    public UsuarioController(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public void inserirUsuario(Usuario usuario) throws SQLException {
        usuarioDao.insert(usuario);
        System.out.println("Usuário inserido: " + usuario);
    }

    public int atualizarUsuario(Usuario usuario) throws SQLException {
        return usuarioDao.update(usuario);
    }

    public void deletarUsuario(Usuario usuario) throws SQLException {
        usuarioDao.delete(usuario);
        System.out.println("Usuário deletado: " + usuario);
    }

    public Usuario procurarUsuarioPorId(int id) throws SQLException {
        return usuarioDao.findOne(id);
    }

    public List<Usuario> procurarTodosUsuarios() throws SQLException {
        return usuarioDao.findAll();
    }
}
