package guy.voltaic.cadastrotimejogador.persistence;

import java.sql.SQLException;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public interface ITimeDao {

    public TimeDao open() throws SQLException;
    public void close();
}
