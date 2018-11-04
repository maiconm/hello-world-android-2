package com.example.mandraski.helloworldandroid2.exercicio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class EstudanteDAO {
    private SQLiteDatabase database;
    private SQLiteOpenHelper dbhelper;
    private String[] colunas = {
                                    DatabaseHelper.COL_ID,
                                    DatabaseHelper.COLNOME,
                                    DatabaseHelper.COLMATRICULA
                                };

    public EstudanteDAO(Context context) {
        this.dbhelper = new DatabaseHelper(context);
    }

    public void open() throws SQLiteException {
        database = dbhelper.getReadableDatabase();
    }

    public void close() {
        dbhelper.close();
    }

    private Estudante cursorToEstudante(Cursor cursor) {
        Estudante estudante =
                new Estudante(
                        cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2));
        return estudante;
    }

    public Estudante CriarEstudante(String nome, String matricula) {
        ContentValues valores = new ContentValues();
        valores.put(DatabaseHelper.COLNOME, nome);
        valores.put(DatabaseHelper.COLMATRICULA, matricula);
        long insertId = database.insert(DatabaseHelper.TABELA_ESTUDANTE,
                                        null,
                                        valores);
        Cursor cursor = database.query(DatabaseHelper.TABELA_ESTUDANTE,
                                        colunas,
                                        DatabaseHelper.COL_ID + " = " + insertId,
                                        null,
                                        null,
                                        null,
                                        null);
        cursor.moveToFirst();
        Estudante novoEstudante = cursorToEstudante(cursor);
        cursor.close();
        return novoEstudante;
    }

    public void excluirEstudante(Estudante estudante) {
        long id = estudante.getId();
        database.delete(DatabaseHelper.TABELA_ESTUDANTE,
                DatabaseHelper.COL_ID  + " = " +  id,
                null);
    }

    public List<Estudante> getAllEstudantes() {
        List<Estudante> estudantes = new ArrayList<>();
        Cursor cursor = database.query(DatabaseHelper.TABELA_ESTUDANTE,
                                        colunas,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Estudante estudante = cursorToEstudante(cursor);
            estudantes.add(estudante);
            cursor.moveToNext();
        }
        cursor.close();
        return estudantes;
    }

    public String getData() {
        String[] colunas = new String[] {DatabaseHelper.COL_ID, DatabaseHelper.COLNOME, DatabaseHelper.COLMATRICULA};
        Cursor cursor = database.query(DatabaseHelper.TABELA_ESTUDANTE,
                                       colunas,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null);
        String resultado = "";
        int iid = cursor.getColumnIndex(DatabaseHelper.COL_ID);
        int inome = cursor.getColumnIndex(DatabaseHelper.COLNOME);
        int imatricula = cursor.getColumnIndex(DatabaseHelper.COLMATRICULA);

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            resultado = resultado + cursor.getString(iid) + " " +
                                    cursor.getString(inome) + " " +
                                    cursor.getString(imatricula) + "\n";
        }
        return resultado;
    }

}
