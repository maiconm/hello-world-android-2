package com.example.mandraski.helloworldandroid2.prova_02;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.mandraski.helloworldandroid2.R;

public class MenuInicialActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btJogar).setOnClickListener(this);
        findViewById(R.id.btSobre).setOnClickListener(this);
        findViewById(R.id.btRank).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btSobre) {
            startActivity(new Intent(this, Sobre.class));
        }

        if (i == R.id.btJogar) {
            startActivity(new Intent(this, Genius.class));
        }

        if (i == R.id.btRank) {
            startActivity(new Intent(this, Ranking.class));
        }
    }

}
