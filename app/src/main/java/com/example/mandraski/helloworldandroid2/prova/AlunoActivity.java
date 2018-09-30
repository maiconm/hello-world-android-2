package com.example.mandraski.helloworldandroid2.prova;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.mandraski.helloworldandroid2.R;

public class AlunoActivity extends OpcoesMenuCalc {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}
