package com.example.mandraski.helloworldandroid2.exercicio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    static final  String DBNAME = "BANCO";
    static final String TABELA_ESTUDANTE = "Estudante";
    static final String COL_ID = "id";
    static final String COLNOME = "nome";
    static final String COLMATRICULA = "matricula";
    static final int DBVERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL = "CREATE TABLE " + TABELA_ESTUDANTE + " (" + COL_ID + " INTEGER PRIMARY KEY, " + COLNOME + " TEXT, " + COLMATRICULA + " TEXT);";
        db.execSQL(SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL  = "DROP TABLE IF EXISTS " + TABELA_ESTUDANTE;
        db.execSQL(SQL);
    }
}
