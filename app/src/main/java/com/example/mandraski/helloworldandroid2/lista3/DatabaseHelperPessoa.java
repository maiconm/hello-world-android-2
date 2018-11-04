package com.example.mandraski.helloworldandroid2.lista3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperPessoa extends SQLiteOpenHelper {

    static final  String DBNAME = "BANCO2";
    static final String TABELA_PESSOA = "Pessoa";
    static final String COL_ID = "id";
    static final String COLNOME = "nome";
    static final String COLIDADE = "idade";
    static final String COLPROFISSAO = "profissao";
    static final int DBVERSION = 1;

    public DatabaseHelperPessoa(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL = "CREATE TABLE " + TABELA_PESSOA + " (" + COL_ID + " INTEGER PRIMARY KEY, " + COLNOME + " TEXT, " + COLIDADE + " TEXT, " + COLPROFISSAO + " TEXT);";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL = "DROP TABLE IF EXISTS " + TABELA_PESSOA;
        db.execSQL(SQL);
    }
}
