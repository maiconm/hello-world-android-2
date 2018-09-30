package com.example.mandraski.helloworldandroid2.lista1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.mandraski.helloworldandroid2.R;

public class Pratica1Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratica1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btExercicio1P1).setOnClickListener(this);
        findViewById(R.id.btExercicio2P1).setOnClickListener(this);
        findViewById(R.id.btExercicio3P1).setOnClickListener(this);
        findViewById(R.id.btExercicio4P1).setOnClickListener(this);
        findViewById(R.id.btExercicio5P1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();

        if (i == R.id.btExercicio1P1) {
            startActivity(new Intent(this, Exercicio1P1Activity.class));
        }

        if (i == R.id.btExercicio2P1) {
            startActivity(new Intent(this, Exercicio1P1Activity.class));
        }

        if (i == R.id.btExercicio3P1) {
            startActivity(new Intent(this, Exercicio1P1Activity.class));
        }

        if (i == R.id.btExercicio4P1) {
            startActivity(new Intent(this, Exercicio1P1Activity.class));
        }

        if (i == R.id.btExercicio5P1) {
            startActivity(new Intent(this, Exercicio1P1Activity.class));
        }

    }
}
