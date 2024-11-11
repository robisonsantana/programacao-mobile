package guy.voltaic.cadastrotimejogador.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guy.voltaic.cadastrotimejogador.model.Jogador;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class JogadorDao implements IJogadorDao, ICRUDDao<Jogador> {

    private final Context context;
    private GenericDao gDao;
    private SQLiteDatabase database;

    public JogadorDao(Context context) {
        this.context = context;
    }

    @Override
    public void insert(Jogador jogador) throws SQLException {
        ContentValues contentValues = getContentValues(jogador);
        database.insert("Jogador", null, contentValues);
    }

    private static ContentValues getContentValues(Jogador jogador) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", jogador.getId());
        contentValues.put("nome", jogador.getNome());
        contentValues.put("dataNasc", jogador.getDataNasc());
        contentValues.put("altura", jogador.getAltura());
        contentValues.put("peso", jogador.getPeso());
        contentValues.put("time", jogador.getTime());
        contentValues.put("id", jogador.getTime());
        contentValues.put("codigo_time", jogador.getTime());

        return contentValues;
    }

    @Override
    public int update(Jogador jogador) throws SQLException {
        ContentValues contentValues = getContentValues(jogador);
        int retorno = database.update("Jogador", contentValues, "codigo = " + jogador.getId(), null);
        return retorno;
    }

    @Override
    public void delete(Jogador jogador) throws SQLException {
        database.delete("Jogador", "codigo = " + jogador.getId(), null);
    }

    @SuppressLint("Range")
    @Override
    public Jogador findOne(Jogador jogador) throws SQLException {
        String sql = "SELECT * FROM jogador WHERE id = " + jogador.getId();
        Cursor cursor = database.rawQuery(sql, null);
        if(cursor != null) {
            cursor.moveToFirst();
        }
        if(!cursor.isAfterLast()) {
            jogador.setId(cursor.getInt(cursor.getColumnIndex("id")));
            jogador.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            jogador.setAltura(cursor.getFloat(cursor.getColumnIndex("altura")));
            jogador.setPeso(cursor.getFloat(cursor.getColumnIndex("peso")));
            jogador.setDataNasc(cursor.getString(cursor.getColumnIndex("dataNasc")));
            jogador.setTime(cursor.getString(cursor.getColumnIndex("time")));
        }
        cursor.close();
        return jogador;
    }

    @SuppressLint("Range")
    @Override
    public List<Jogador> findAll() throws SQLException {
        List<Jogador> jogadores = new ArrayList<>();
        String sql = "SELECT * FROM jogador";
        Cursor cursor = database.rawQuery(sql, null);
        if(cursor != null) {
            cursor.moveToFirst();
        }
        while(!cursor.isAfterLast()) {
            Jogador jogador = new Jogador();
            jogador.setId(cursor.getInt(cursor.getColumnIndex("id")));
            jogador.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            jogador.setAltura(cursor.getFloat(cursor.getColumnIndex("altura")));
            jogador.setPeso(cursor.getFloat(cursor.getColumnIndex("peso")));
            jogador.setDataNasc(cursor.getString(cursor.getColumnIndex("dataNasc")));
            jogador.setTime(cursor.getString(cursor.getColumnIndex("time")));

            jogadores.add(jogador);
            cursor.moveToNext();
        }
        cursor.close();
        return jogadores;
    }

    @Override
    public JogadorDao open() throws SQLException {
        gDao = new GenericDao(context);
        database = gDao.getWritableDatabase();
        return this;
    }

    @Override
    public void close() {
        gDao.close();
    }
}
