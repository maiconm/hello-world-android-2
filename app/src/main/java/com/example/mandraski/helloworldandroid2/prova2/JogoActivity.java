package com.example.mandraski.helloworldandroid2.prova2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mandraski.helloworldandroid2.R;

public class JogoActivity extends ActionBarGenius implements View.OnClickListener {
    private TextView tvLevel;
    private Button bt1, bt2, bt3, bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvLevel = findViewById(R.id.tvLevel);

        bt1 = findViewById(R.id.bt1);
        findViewById(R.id.bt1).setOnClickListener(this);
        bt2 = findViewById(R.id.bt2);
        findViewById(R.id.bt2).setOnClickListener(this);
        bt3 = findViewById(R.id.bt3);
        findViewById(R.id.bt3).setOnClickListener(this);
        bt4 = findViewById(R.id.bt4);
        findViewById(R.id.bt4).setOnClickListener(this);

        startTimer();

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();

        if (i == R.id.bt1) {

        }

        if (i == R.id.bt2) {

        }

        if (i == R.id.bt3) {

        }

        if (i == R.id.bt4) {

        }
    }

    public void startTimer() {
        CountDownTimer timer = new CountDownTimer(4000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "acabou", Toast.LENGTH_SHORT).show();
            }
        };
        timer.start();
    }
}
