package com.example.mandraski.helloworldandroid2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.mandraski.helloworldandroid2.exercicio.sqlActivity;
import com.example.mandraski.helloworldandroid2.lista1.Pratica1Activity;
import com.example.mandraski.helloworldandroid2.lista2.Pratica2Activity;
import com.example.mandraski.helloworldandroid2.lista3.Pratica3Activity;
import com.example.mandraski.helloworldandroid2.lista4.LightsaberActivity;
import com.example.mandraski.helloworldandroid2.prova.ProvaActivity;
import com.example.mandraski.helloworldandroid2.prova2.GeniusActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

public class ListaActivity extends ActionBarMain implements View.OnClickListener {

    public static FirebaseAuth mAuth;
    public static GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // pega instancias de autenticacao do firebase:
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // [END config_signin]

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();

        // listener do botao do xml, para verificar quando o usuario clica:
        findViewById(R.id.btProva).setOnClickListener(this);
        findViewById(R.id.btLista1).setOnClickListener(this);
        findViewById(R.id.btLista2).setOnClickListener(this);
        findViewById(R.id.btLista3).setOnClickListener(this);
        findViewById(R.id.exercicio1).setOnClickListener(this);
        findViewById(R.id.btProva2).setOnClickListener(this);
        findViewById(R.id.btLista4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();

        if (i == R.id.btLista1) {
            startActivity(new Intent(this, Pratica1Activity.class));
        }

        if (i == R.id.btLista2) {
            startActivity(new Intent(this, Pratica2Activity.class));
        }

        if (i == R.id.btProva) {
            startActivity(new Intent(this, ProvaActivity.class));
        }

        if (i == R.id.btLista3) {
            startActivity(new Intent(this, Pratica3Activity.class));
        }

        if (i == R.id.exercicio1) {
            startActivity(new Intent(this, sqlActivity.class));
        }

        if (i == R.id.btProva2) {
            startActivity(new Intent(this, GeniusActivity.class));
        }

        if (i == R.id.btLista4) {
            startActivity(new Intent(this, LightsaberActivity.class));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        signOut();
    }

    public static void signOut() {
        mAuth.signOut();
        mGoogleSignInClient.signOut();
    }

}
