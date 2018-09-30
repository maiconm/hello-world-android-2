package com.example.mandraski.helloworldandroid2.lista2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mandraski.helloworldandroid2.R;

public class Exercicio1P2Activity extends AppCompatActivity {

    /**
     * Variaveis:
     */
    private Button btEnviar;
    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio1_p2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Ligacao das variaveis com os componentes do xml:
         */
        btEnviar = findViewById(R.id.btEnviarEx1P2);
        tvInfo = findViewById(R.id.tvTela1Ex1P2);
        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exercicio1P2Activity.this, Exercicio1P2Tela2Activity.class);
                intent.putExtra("tvTela1", tvInfo.getText().toString());
                startActivity(intent);
            }
        });

    }

}
