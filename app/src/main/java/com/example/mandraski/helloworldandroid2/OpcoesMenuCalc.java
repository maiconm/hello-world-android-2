package com.example.mandraski.helloworldandroid2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class OpcoesMenuCalc extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_calc, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.abCalc:
                if (!this.equals(ProvaActivity.class)) {
                    startActivity(new Intent(this, ProvaActivity.class));
                    return true;
                }
                return true;

            case R.id.abHistorico:
                if (!this.equals(HistoricoActivity.class)) {
                    startActivity(new Intent(this, HistoricoActivity.class));
                    return true;
                }
                return true;

             default:
                 return super.onOptionsItemSelected(item);
        }
    }
}
