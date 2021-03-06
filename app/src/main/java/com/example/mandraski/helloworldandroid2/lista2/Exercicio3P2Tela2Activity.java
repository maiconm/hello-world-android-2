package com.example.mandraski.helloworldandroid2.lista2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mandraski.helloworldandroid2.Manifest;
import com.example.mandraski.helloworldandroid2.R;

import java.util.ArrayList;
import java.util.List;

public class Exercicio3P2Tela2Activity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    private ListView nomesList;
    private List<String> nomes = new ArrayList<>();
    private String numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio3_p2_tela2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nomesList = findViewById(R.id.lvPratica2Exe3);

        nomes = Exercicio3P2Activity.nomes;

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nomes);

        nomesList.setAdapter(ad);

        nomesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                numero = Exercicio3P2Activity.telefones.get(position);
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + numero));
                startActivity(i);
            }
        });

    }

}
