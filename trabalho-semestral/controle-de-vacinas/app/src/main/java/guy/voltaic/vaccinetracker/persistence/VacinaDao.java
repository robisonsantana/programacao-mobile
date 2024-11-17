package guy.voltaic.vaccinetracker.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import guy.voltaic.vaccinetracker.model.Vacina;
import guy.voltaic.vaccinetracker.model.VacinaAdulto;
import guy.voltaic.vaccinetracker.model.VacinaInfantil;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class VacinaDao implements ICRUDDao<Vacina> {

    private final SQLiteDatabase database;

    public VacinaDao(SQLiteDatabase database) {
        this.database = database;
    }

    @Override
    public void insert(Vacina vacina) throws SQLException {
        ContentValues values = new ContentValues();
        values.put("nome", vacina.getNome());
        values.put("dataAplicacao", vacina.getDataAplicacao());
        values.put("lote", vacina.getLote());
        values.put("responsavelAplicacao", vacina.getResponsavelAplicacao());

        values.put("tipo", vacina.getClass().getSimpleName());
        if (vacina instanceof VacinaInfantil) {
            VacinaInfantil vacinaInfantil = (VacinaInfantil) vacina;
            values.put("idadeAplicacao", vacinaInfantil.getIdadeAplicacao());
        } else if (vacina instanceof VacinaAdulto) {
            VacinaAdulto vacinaAdulto = (VacinaAdulto) vacina;
            values.put("necessitaReforco", vacinaAdulto.isNecessitaReforco() ? 1 : 0);
        }

        database.insert("Vacina", null, values);
    }

    @Override
    public int update(Vacina vacina) throws SQLException {
        ContentValues values = new ContentValues();
        values.put("nome", vacina.getNome());
        values.put("dataAplicacao", vacina.getDataAplicacao());
        values.put("lote", vacina.getLote());
        values.put("responsavelAplicacao", vacina.getResponsavelAplicacao());

        values.put("tipo", vacina.getClass().getSimpleName());
        if (vacina instanceof VacinaInfantil) {
            VacinaInfantil vacinaInfantil = (VacinaInfantil) vacina;
            values.put("idadeAplicacao", vacinaInfantil.getIdadeAplicacao());
        } else if (vacina instanceof VacinaAdulto) {
            VacinaAdulto vacinaAdulto = (VacinaAdulto) vacina;
            values.put("necessitaReforco", vacinaAdulto.isNecessitaReforco() ? 1 : 0);
        }

        return database.update("Vacina", values, "id = ?", new String[]{String.valueOf(vacina.getId())});
    }

    @Override
    public void delete(Vacina vacina) throws SQLException {
        database.delete("Vacina", "id = ?", new String[]{String.valueOf(vacina.getId())});
    }

    @SuppressLint("Range")
    @Override
    public Vacina findOne(int id) throws SQLException {
        Cursor cursor = database.query("Vacina", null, "id = ?", new String[]{String.valueOf(id)},
                null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String dataAplicacao = cursor.getString(cursor.getColumnIndex("dataAplicacao"));
            String lote = cursor.getString(cursor.getColumnIndex("lote"));
            String responsavelAplicacao = cursor.getString(cursor.getColumnIndex("responsavelAplicacao"));
            String tipo = cursor.getString(cursor.getColumnIndex("tipo"));

            Vacina vacina = null;

            if ("VacinaInfantil".equals(tipo)) {
                vacina = new VacinaInfantil();
                ((VacinaInfantil) vacina).setIdadeAplicacao(cursor.getInt(cursor.getColumnIndex("idadeAplicacao")));
            } else if ("VacinaAdulto".equals(tipo)) {
                vacina = new VacinaAdulto();
                ((VacinaAdulto) vacina).setNecessitaReforco(cursor.getInt(cursor.getColumnIndex("necessitaReforco")) > 0);
            }

            vacina.setId(id);
            vacina.setNome(nome);
            vacina.setDataAplicacao(dataAplicacao);
            vacina.setLote(lote);
            vacina.setResponsavelAplicacao(responsavelAplicacao);

            cursor.close();
            return vacina;
        }

        return null;
    }

    @SuppressLint("Range")
    @Override
    public List<Vacina> findAll() throws SQLException {
        List<Vacina> vacinas = new ArrayList<>();
        Cursor cursor = database.query("Vacina", null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                String dataAplicacao = cursor.getString(cursor.getColumnIndex("dataAplicacao"));
                String lote = cursor.getString(cursor.getColumnIndex("lote"));
                String responsavelAplicacao = cursor.getString(cursor.getColumnIndex("responsavelAplicacao"));
                String tipo = cursor.getString(cursor.getColumnIndex("tipo"));

                Vacina vacina = null;

                if ("VacinaInfantil".equals(tipo)) {
                    vacina = new VacinaInfantil();
                    ((VacinaInfantil) vacina).setIdadeAplicacao(cursor.getInt(cursor.getColumnIndex("idadeAplicacao")));
                } else if ("VacinaAdulto".equals(tipo)) {
                    vacina = new VacinaAdulto();
                    ((VacinaAdulto) vacina).setNecessitaReforco(cursor.getInt(cursor.getColumnIndex("necessitaReforco")) > 0);
                }

                vacina.setId(cursor.getInt(cursor.getColumnIndex("id")));
                vacina.setNome(nome);
                vacina.setDataAplicacao(dataAplicacao);
                vacina.setLote(lote);
                vacina.setResponsavelAplicacao(responsavelAplicacao);

                vacinas.add(vacina);
            } while (cursor.moveToNext());

            cursor.close();
        }

        return vacinas;
    }
}




