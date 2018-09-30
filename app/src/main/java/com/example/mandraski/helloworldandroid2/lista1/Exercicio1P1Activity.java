package com.example.mandraski.helloworldandroid2.lista1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.mandraski.helloworldandroid2.R;

public class Exercicio1P1Activity extends AppCompatActivity {
    private TextView textoA, textoB;
    private Button btInverte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio1_p1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textoA = findViewById(R.id.etTextoA);
        textoB = findViewById(R.id.etTextoB);
        btInverte = findViewById(R.id.btInverter);


        /**
         * Ao clicar em inverter, os textos dos inputs trocam de lugar:
         */
        btInverte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux = textoA.getText().toString();
                textoA.setText(textoB.getText());
                textoB.setText(aux);
            }
        });
    }
}
