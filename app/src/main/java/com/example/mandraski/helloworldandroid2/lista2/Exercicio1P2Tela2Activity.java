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

public class Exercicio1P2Tela2Activity extends AppCompatActivity {

    /**
     * Variaveis:
     */
    private TextView tvRecebe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio1_p2_tela2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvRecebe = findViewById(R.id.tvRecebeEx1P2);
        Intent i = getIntent();
        String dados = i.getStringExtra("tvTela1");
        tvRecebe.setText(dados);

    }

}
