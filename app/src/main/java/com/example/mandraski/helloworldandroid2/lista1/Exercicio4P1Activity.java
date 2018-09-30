package com.example.mandraski.helloworldandroid2.lista1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mandraski.helloworldandroid2.R;

public class Exercicio4P1Activity extends AppCompatActivity {

    /**
     * Variaveis:
     */
    private EditText etNome, etRu;
    private Spinner spProfissao;
    private Button btMostrar;
    private String valorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio4_p1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Seta opcoes do `spinner` de experiencia do componente:
         */
        spProfissao = findViewById(R.id.spPratica1Exe4Profissao);
        String[] opcoes = getResources().getStringArray(R.array.profissao_p1_exercicio4);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opcoes);
        spProfissao.setAdapter(adapter);
        spProfissao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valorSpinner = spProfissao.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        /**
         * Liga variaveis com os componentes do xml:
         */
        etNome = findViewById(R.id.etPratica1Exe4Nome);
        etRu = findViewById(R.id.etPratica1Exe4Ru);
        btMostrar = findViewById(R.id.btPratica1Exe4Mostrar);
        btMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), etNome.getText() + ", " + etRu.getText() + ", "+ valorSpinner, Toast.LENGTH_LONG).show();
            }
        });

    }

}
