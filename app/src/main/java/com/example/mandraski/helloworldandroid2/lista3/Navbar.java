package com.example.mandraski.helloworldandroid2.lista3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.mandraski.helloworldandroid2.R;
import com.example.mandraski.helloworldandroid2.lista2.Exercicio3P2Tela2Activity;

public class Navbar extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_ex1_pratica_3, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addPessoa:
                if (!this.equals(Exercicio3P2Tela2Activity.class)) {
                    startActivity(new Intent(this, Exercicio1P3Activity.class));
                    return true;
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
