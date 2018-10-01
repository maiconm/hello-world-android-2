package com.example.mandraski.helloworldandroid2.lista2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mandraski.helloworldandroid2.R;

import java.util.ArrayList;
import java.util.List;

public class Exercicio3P2Activity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Variaveis:
     */
    private EditText nome, telefone;
    public static List<String> nomes = new ArrayList<>();
    public static List<String> telefones = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio3_p2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btExercicio3Pratica2).setOnClickListener(this);
        nome = findViewById(R.id.etPratica2Exe3Nome);
        telefone = findViewById(R.id.etPratica2Exe3Telefone);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();

        if (i == R.id.btExercicio3Pratica2) {
            nomes.add(nome.getText().toString());
            telefones.add(telefone.getText().toString());
            startActivity(new Intent(this, Exercicio3P2Tela2Activity.class));
        }
    }
}
