package guy.voltaic.vaccinetracker.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE = "VACINAS.DB";
    private static final int DATABASE_VERSION = 2;

    private static final String CREATE_TABLE_VACINA =
            "CREATE TABLE Vacina (" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT NOT NULL, " +
                    "dataAplicacao TEXT NOT NULL, " +
                    "lote TEXT NOT NULL, " +
                    "responsavelAplicacao TEXT NOT NULL, " +
                    "tipo TEXT NOT NULL, " +
                    "idadeAplicacao INTEGER, " +
                    "necessitaReforco INTEGER);";

    private static final String CREATE_TABLE_USUARIO =
            "CREATE TABLE Usuario (" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT NOT NULL, " +
                    "dataNascimento TEXT NOT NULL, " +
                    "email TEXT NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DatabaseHelper", "onCreate chamado");
        db.execSQL(CREATE_TABLE_VACINA);
        db.execSQL(CREATE_TABLE_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("DatabaseHelper", "onUpgrade chamado - Versão antiga: " + oldVersion + ", nova versão: " + newVersion);
        if (newVersion > oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS Usuario");
            db.execSQL("DROP TABLE IF EXISTS Vacina");
            onCreate(db);
        }
    }
}


