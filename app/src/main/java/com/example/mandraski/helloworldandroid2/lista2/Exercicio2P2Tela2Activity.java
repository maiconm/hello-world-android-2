package com.example.mandraski.helloworldandroid2.lista2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.mandraski.helloworldandroid2.R;

public class Exercicio2P2Tela2Activity extends AppCompatActivity {

    /**
     * Variaveis
     */
    private TextView tvNome, tvRu, tvCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio2_p2_tela2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // link do componente com a variavel:
        tvNome = findViewById(R.id.tvPratica2Exe2Nome);
        tvRu = findViewById(R.id.tvPratica2Exe2Ru);
        tvCurso = findViewById(R.id.tvPratica2Exe2Curso);
        // pega conteudo do intent da outra tela, e seta na variavel
        // ligada ao componente:
        Intent i = getIntent();
        String nome = i.getStringExtra("nome");
        String ru = i.getStringExtra("ru");
        String curso = i.getStringExtra("curso");
        tvNome.setText(nome);
        tvRu.setText(ru);
        tvCurso.setText(curso);

    }

}
