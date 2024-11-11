package guy.voltaic.cadastrotimejogador.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class GenericDao extends SQLiteOpenHelper {

    private static final String DATABASE = "FUTEBOL.DB";
    private static final int DATABASE_VER = 1;
    private static final String CREATE_TABLE_JOGADOR =
            "CREATE TABLE Jogador ( " +
                "id INT NOT NULL PRIMARY KEY, " +
                "nome VARCHAR(20) NOT NULL, " +
                "dataNasc CHAR(9) NOT NULL, " +
                "altura VARCHAR(5) NOT NULL, " +
                "peso VARCHAR(5) NOT NULL, " +
                "time VARCHAR(20) NOT NULL);";

    private static final String CREATE_TABLE_TIME =
            "CREATE TABLE Time ( " +
                    "codigo INT NOT NULL PRIMARY KEY, " +
                    "nome VARCHAR(20) NOT NULL, " +
                    "cidade VARCHAR(20) NOT NULL);";

    public GenericDao(Context context) {
        super(context, DATABASE, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_TIME);
        sqLiteDatabase.execSQL(CREATE_TABLE_JOGADOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int antigaVersao, int novaVersao) {
        if(novaVersao > antigaVersao) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS time");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS jogador");
            onCreate(sqLiteDatabase);
        }
    }
}
