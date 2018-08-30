package br.com.cotrim.agenda.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlunoDAO extends SQLiteOpenHelper {

    private String dataBaseName = "Agenda";
    private int dataBaseVersion = 1;
    public AlunoDAO(Context context) {
        super(context, dataBaseName, null, dataBaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTableAlunos = "CREATE TABLE Alunos (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, endereco TEXT, telefone TEXT, site TEXT, nota REAL);";
        db.execSQL(sqlCreateTableAlunos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDropTableAlunos = "DROP TABLE IF EXISTS Alunos;";
        db.execSQL(sqlDropTableAlunos);
        onCreate(db);
    }
}
