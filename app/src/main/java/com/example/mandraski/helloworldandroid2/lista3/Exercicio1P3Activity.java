package com.example.mandraski.helloworldandroid2.lista3;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mandraski.helloworldandroid2.R;

import java.util.ArrayList;
import java.util.List;

public class Exercicio1P3Activity extends AppCompatActivity implements View.OnClickListener {
    public static List<Pessoa> pessoas = new ArrayList<>();

    private EditText nome, idade, cpf;
    private AlertDialog alerta;
    private AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio1_p3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        builder = new AlertDialog.Builder(this);

        nome = findViewById(R.id.etPratica3Exe1nome);
        idade = findViewById(R.id.etPratica3Exe1idade);
        cpf = findViewById(R.id.etPratica3Exe1cpf);

        findViewById(R.id.btPratica3Exe1cadastrar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btPratica3Exe1cadastrar) {
            if (!temCaposVazio()) {
                addPessoa();
            }
        }
    }

    private boolean temCaposVazio() {
        String campos = "";
        if (nome.getText().toString().isEmpty()) {
            campos += "nome";
        }
        if (idade.getText().toString().isEmpty()) {
            campos += " idade";
        }
        if (cpf.getText().toString().isEmpty()) {
            campos += " cpf";
        }
        if (!campos.equals("")){
            builder.setTitle("Atencao");
            builder.setMessage(campos + " estao vazios!");
            alerta = builder.create();
            alerta.show();
            return true;
        }
        return false;
    }

    private void addPessoa() {
        Pessoa pessoa = new Pessoa(nome.getText().toString(), idade.getText().toString(), cpf.getText().toString());
        pessoas.add(pessoa);
        Toast.makeText(this, pessoa.getNome() + " foi adicionada!", Toast.LENGTH_SHORT).show();
    }
}
