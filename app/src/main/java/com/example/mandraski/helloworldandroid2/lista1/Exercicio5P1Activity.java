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
import android.widget.ListView;
import android.widget.Toast;

import com.example.mandraski.helloworldandroid2.R;

public class Exercicio5P1Activity extends AppCompatActivity {

    /**
     *Variaveis:
     */
    private EditText etNome, etRu;
    private ListView lvListaProfissao;
    private Button btMostrar;
    private String valorListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio5_p1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Ligacao das variaveis com os componentes do xml:
         */
        etNome = findViewById(R.id.etPratica1Exe5Nome);
        etRu = findViewById(R.id.etPratica1Exe5Ru);
        btMostrar = findViewById(R.id.btPratica1Exe5Mostrar);
        lvListaProfissao = findViewById(R.id.lvPratica1Exe5ListaProfissao);
        /**
         * Seta opcoes para o `ListView` do xml:
         */
        String[] opcoesListView = getResources().getStringArray(R.array.profissao_p1_exercicio4);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, opcoesListView);
        lvListaProfissao.setAdapter(adapter);
        /**
         * Pega valor do `ListView`:
         */
        lvListaProfissao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                valorListView = lvListaProfissao.getItemAtPosition(position).toString();
            }
        });
        /**
         * Ao clicar em mostrar, mostra toast com as informacoes dos inputs:
         */
        btMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), etNome.getText() + ", " + etRu.getText() + ", " + valorListView, Toast.LENGTH_LONG).show();
            }
        });


    }

}
