package com.example.mandraski.helloworldandroid2.prova2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mandraski.helloworldandroid2.R;

public class ActionBarGenius extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_genius, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ranking:
                Toast.makeText(this, "implementar", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.aluno:
                if (!this.equals(GeniusAlunoActivity.class)) {
                    startActivity(new Intent(this, GeniusAlunoActivity.class));
                    return true;
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
