package com.example.mandraski.helloworldandroid2.lista2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.mandraski.helloworldandroid2.R;

public class Pratica2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratica2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btExercicio1P2).setOnClickListener(this);
        findViewById(R.id.btExercicio2P2).setOnClickListener(this);
        findViewById(R.id.btExercicio3P2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();

        if (i == R.id.btExercicio1P2) {
            startActivity(new Intent(this, Exercicio1P2Activity.class));
        }

        if (i == R.id.btExercicio2P2) {

        }

        if (i == R.id.btExercicio2P2) {

        }
    }
}
