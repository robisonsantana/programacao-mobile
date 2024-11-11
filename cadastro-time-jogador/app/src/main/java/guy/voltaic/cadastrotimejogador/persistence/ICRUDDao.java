package guy.voltaic.cadastrotimejogador.persistence;

import java.sql.SQLException;
import java.util.List;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public interface ICRUDDao<T> {
    void insert(T t) throws SQLException;
    int update(T t) throws SQLException;
    void delete(T t) throws SQLException;
    T findOne(T t) throws SQLException;
    List<T> findAll() throws SQLException;
}
