package com.example.mandraski.helloworldandroid2.exercicio;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mandraski.helloworldandroid2.R;

import java.util.List;

public class sqlActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView sqlResults;
    private EditText etNome, etMatricula;
    private EstudanteDAO estDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        estDAO = new EstudanteDAO(getApplicationContext());
        estDAO.open();

        sqlResults = findViewById(R.id.sqlResults);
        etNome = findViewById(R.id.etNome);
        etMatricula = findViewById(R.id.etMatricula);


        findViewById(R.id.btGravarSql).setOnClickListener(this);
        findViewById(R.id.btSelect).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btGravarSql) {
            estDAO.CriarEstudante(etNome.getText().toString(), etMatricula.getText().toString());
            Toast.makeText(this, etNome.getText().toString() + " gravado com sucesso!", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.btSelect) {
            List<Estudante> ests = estDAO.getAllEstudantes();
            Toast.makeText(this, "tem " + ests.size(), Toast.LENGTH_SHORT).show();
            for (Estudante est : ests) {
                sqlResults.setText(String.valueOf(est.getNome() + "\n"));
            }

        }
    }
}
