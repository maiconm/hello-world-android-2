package com.example.mandraski.helloworldandroid2.lista3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    private SQLiteDatabase database;
    private SQLiteOpenHelper dbhelper;
    private String[] colunas = {
            DatabaseHelperPessoa.COL_ID,
            DatabaseHelperPessoa.COLNOME,
            DatabaseHelperPessoa.COLIDADE,
            DatabaseHelperPessoa.COLPROFISSAO
    };

    public PessoaDAO(Context context) {
        this.dbhelper = new DatabaseHelperPessoa(context);
    }

    public void open() throws SQLiteException {
        database = dbhelper.getReadableDatabase();
    }

    public void close() {
        dbhelper.close();
    }

    private Pessoa cursorToPessoa(Cursor cursor) {
        Pessoa pessoa =
                new Pessoa(
                        cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                );
        return pessoa;
    }

    public Pessoa criarPessoa(String nome, String idade, String profissao) {
        ContentValues valores = new ContentValues();
        valores.put(DatabaseHelperPessoa.COLNOME, nome);
        valores.put(DatabaseHelperPessoa.COLIDADE, idade);
        valores.put(DatabaseHelperPessoa.COLPROFISSAO, profissao);
        long insertId = database.insert(DatabaseHelperPessoa.TABELA_PESSOA, null, valores);
        Cursor cursor = database.query(
                DatabaseHelperPessoa.TABELA_PESSOA, colunas,
                DatabaseHelperPessoa.COL_ID + " = " + insertId,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        Pessoa newPessoa = cursorToPessoa(cursor);
        cursor.close();
        return newPessoa;
    }

    public void excluirPessoa(Pessoa pessoa) {
        long id = pessoa.getId();
        database.delete(DatabaseHelperPessoa.TABELA_PESSOA,
                DatabaseHelperPessoa.COL_ID + " = " + id,
                null);
    }

    public List<Pessoa> getAllPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        Cursor cursor = database.query(DatabaseHelperPessoa.TABELA_PESSOA,
                colunas,
                null,
                null,
                null,
                null,
                null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Pessoa pessoa = cursorToPessoa(cursor);
            pessoas.add(pessoa);
            cursor.moveToNext();
        }
        cursor.close();
        return pessoas;
    }

    public String getData() {
        String[] colunas = new String[] {
                DatabaseHelperPessoa.COL_ID,
                DatabaseHelperPessoa.COLNOME,
                DatabaseHelperPessoa.COLIDADE,
                DatabaseHelperPessoa.COLPROFISSAO
        };
        Cursor cursor = database.query(DatabaseHelperPessoa.TABELA_PESSOA,
                colunas,
                null,
                null,
                null,
                null,
                null,
                null);
        String resultado = "";
        int iid = cursor.getColumnIndex(DatabaseHelperPessoa.COL_ID);
        int inome = cursor.getColumnIndex(DatabaseHelperPessoa.COLNOME);
        int iidade = cursor.getColumnIndex(DatabaseHelperPessoa.COLIDADE);
        int iprofissao = cursor.getColumnIndex(DatabaseHelperPessoa.COLPROFISSAO);

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            resultado = resultado + cursor.getString(iid) + " " +
                    cursor.getString(inome) + " " +
                    cursor.getString(iidade) + " " +
                    cursor.getString(iprofissao) + "\n";
        }
        return resultado;
    }

}
