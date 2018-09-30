package com.example.mandraski.helloworldandroid2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
// Implemente o `View.OnClickListener`:
public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    // varivel para pegar os dados do usuario:
    private FirebaseAuth mAuth;
    // varivel para enviar dados para fazer o login:
    private GoogleSignInClient mGoogleSignInClient;
    // chama componente de login:
    private static final int RC_SIGN_IN = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // pega instancias de autenticacao do firebase:
        mAuth = FirebaseAuth.getInstance();


        // Configura o Google Sign In
        // Configura o sign-in para requisitar o perfil e o email do usuario.
        // Perfil basico e ID sao inclusos no DEFAULT_SIGN_IN:
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Constroi um GoogleSignInClient com as opcoes especificadas pelo gso:
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // listener do botao do xml, para verificar quando o usuario clica:
        findViewById(R.id.btnGoogle).setOnClickListener(this);

    }

    // quando detectar o click do usuario no botao (ja configurano - linha 51)
    // chama o metodo de login:
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btnGoogle) {
            signIn();
        }
    }

    // metodo de login:
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Abrir outra activity:
            Intent i = new Intent(MainActivity.this, ListaActivity.class);
            startActivity(i);

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show();
        }
    }
}
