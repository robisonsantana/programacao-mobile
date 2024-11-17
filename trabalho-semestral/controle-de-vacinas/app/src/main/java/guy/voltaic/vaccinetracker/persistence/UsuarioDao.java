package guy.voltaic.vaccinetracker.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import guy.voltaic.vaccinetracker.model.Usuario;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class UsuarioDao implements ICRUDDao<Usuario> {

    private final SQLiteDatabase database;

    public UsuarioDao(SQLiteDatabase database) {
        this.database = database;
    }

    @Override
    public void insert(Usuario usuario) throws SQLException {
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("dataNascimento", usuario.getDataNascimento());
        values.put("email", usuario.getEmail());

        database.insert("Usuario", null, values);
    }

    @Override
    public int update(Usuario usuario) throws SQLException {
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("dataNascimento", usuario.getDataNascimento());
        values.put("email", usuario.getEmail());

        return database.update("Usuario", values, "id = ?", new String[]{String.valueOf(usuario.getId())});
    }

    @Override
    public void delete(Usuario usuario) throws SQLException {
        database.delete("Usuario", "id = ?", new String[]{String.valueOf(usuario.getId())});
    }

    @SuppressLint("Range")
    @Override
    public Usuario findOne(int id) throws SQLException {
        Cursor cursor = database.query("Usuario", null, "id = ?", new String[]{String.valueOf(id)},
                null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            Usuario usuario = new Usuario();
            usuario.setId(cursor.getInt(cursor.getColumnIndex("id")));
            usuario.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            usuario.setDataNascimento(cursor.getString(cursor.getColumnIndex("dataNascimento")));
            usuario.setEmail(cursor.getString(cursor.getColumnIndex("email")));

            cursor.close();
            return usuario;
        }

        return null;
    }

    @SuppressLint("Range")
    @Override
    public List<Usuario> findAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        Cursor cursor = database.query("Usuario", null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Usuario usuario = new Usuario();
                usuario.setId(cursor.getInt(cursor.getColumnIndex("id")));
                usuario.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                usuario.setDataNascimento(cursor.getString(cursor.getColumnIndex("dataNascimento")));
                usuario.setEmail(cursor.getString(cursor.getColumnIndex("email")));

                usuarios.add(usuario);
            } while (cursor.moveToNext());

            cursor.close();
        }

        return usuarios;
    }
}

