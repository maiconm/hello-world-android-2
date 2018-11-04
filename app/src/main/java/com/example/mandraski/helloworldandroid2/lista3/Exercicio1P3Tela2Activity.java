package com.example.mandraski.helloworldandroid2.lista3;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mandraski.helloworldandroid2.R;

import java.util.ArrayList;
import java.util.List;

public class Exercicio1P3Tela2Activity extends Navbar {

    private List<Pessoa> lista = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio1_p3_tela2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView lvListaPessoas = findViewById(R.id.lvPessoas);
        lista = Exercicio1P3Activity.getPessoas();
        ArrayAdapter<Pessoa> ad = new ArrayAdapter<Pessoa>(this, android.R.layout.simple_list_item_1, lista);

        lvListaPessoas.setAdapter(ad);

        lvListaPessoas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "nome: " + lista.get(position).getNome() + " idade: " +
                        lista.get(position).getIdade() + " cpf: " +
                        lista.get(position).getCpf(), Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

}
