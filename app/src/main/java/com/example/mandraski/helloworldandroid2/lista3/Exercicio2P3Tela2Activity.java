package com.example.mandraski.helloworldandroid2.lista3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mandraski.helloworldandroid2.R;

import java.util.ArrayList;
import java.util.List;

public class Exercicio2P3Tela2Activity extends AppCompatActivity {
    private PessoaDAO pessoaDAO;
    private List<Pessoa> pessoas = new ArrayList<>();
    private ListView lvPessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio2_p3_tela2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pessoaDAO = new PessoaDAO(this);
        pessoaDAO.open();

        pessoas = pessoaDAO.getAllPessoas();

        lvPessoas = findViewById(R.id.lvPessoas2);

        ArrayAdapter<Pessoa> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pessoas);
        lvPessoas.setAdapter(ad);


        lvPessoas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "nome: " + pessoas.get(position).getNome() +
                                " idade: " + pessoas.get(position).getIdade() +
                                " profissao: " + pessoas.get(position).getProfissao(), Toast.LENGTH_SHORT
                ).show();
            }
        });

    }

}
