package com.example.mandraski.helloworldandroid2.lista3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.mandraski.helloworldandroid2.R;

public class Pratica3Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratica3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btExercicio1P3).setOnClickListener(this);
        findViewById(R.id.btExercicio2P3).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btExercicio1P3) {
            startActivity(new Intent(this, Exercicio1P3Activity.class));
        }
        if (i == R.id.btExercicio2P3) {
            startActivity(new Intent(this, Exercicio2P3Activity.class));
        }
    }
}
