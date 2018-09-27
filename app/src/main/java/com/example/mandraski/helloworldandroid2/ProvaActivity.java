package com.example.mandraski.helloworldandroid2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ProvaActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView display;
    private String displayString = "";
    private String auxN1 = "";
    private double n1, n2;
    private String operacao = "";
    private double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.rbDec).setOnClickListener(this);
        findViewById(R.id.rbBin).setOnClickListener(this);
        findViewById(R.id.rbOctal).setOnClickListener(this);
        findViewById(R.id.rbHex).setOnClickListener(this);
        findViewById(R.id.rbHex).setOnClickListener(this);
        findViewById(R.id.btNumUm).setOnClickListener(this);
        findViewById(R.id.btNumDois).setOnClickListener(this);
        findViewById(R.id.btNumTres).setOnClickListener(this);
        findViewById(R.id.btNumQuatro).setOnClickListener(this);
        findViewById(R.id.btNumCinco).setOnClickListener(this);
        findViewById(R.id.btNumSeis).setOnClickListener(this);
        findViewById(R.id.btNumSete).setOnClickListener(this);
        findViewById(R.id.btNumOito).setOnClickListener(this);
        findViewById(R.id.btNumNove).setOnClickListener(this);
        findViewById(R.id.btNumZero).setOnClickListener(this);
        findViewById(R.id.btSoma).setOnClickListener(this);
        findViewById(R.id.btSubtracao).setOnClickListener(this);
        findViewById(R.id.btDivisao).setOnClickListener(this);
        findViewById(R.id.btMultiplicacao).setOnClickListener(this);
        findViewById(R.id.btInverte).setOnClickListener(this);
        findViewById(R.id.btIgual).setOnClickListener(this);
        findViewById(R.id.btPonto).setOnClickListener(this);
        findViewById(R.id.btClear).setOnClickListener(this);
        display = (TextView) findViewById(R.id.tvDisplay);
    }

    @Override
    public  void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btNumUm) {
            displayString += "1";
            display.setText(displayString);
        }

        if (i == R.id.btNumDois) {
            displayString += "2";
            display.setText(displayString);
        }

        if (i == R.id.btNumTres) {
            displayString += "3";
            display.setText(displayString);
        }

        if (i == R.id.btNumQuatro) {
            displayString += "4";
            display.setText(displayString);
        }

        if (i == R.id.btNumCinco) {
            displayString += "5";
            display.setText(displayString);
        }

        if (i == R.id.btNumSeis) {
            displayString += "6";
            display.setText(displayString);
        }

        if (i == R.id.btNumSete) {
            displayString += "7";
            display.setText(displayString);
        }

        if (i == R.id.btNumOito) {
            displayString += "8";
            display.setText(displayString);
        }

        if (i == R.id.btNumNove) {
            displayString += "9";
            display.setText(displayString);
        }

        if (i == R.id.btNumZero) {
            displayString += "0";
            display.setText(displayString);
        }

        if (i == R.id.btClear) {
            displayString = "";
            display.setText(displayString);
        }

        if (i == R.id.btPonto) {
            if (displayString.contains(".")) {
                return;
            }
            if (displayString == "") {
                displayString = "0.";
            } else {
                displayString += ".";
            }
            display.setText(displayString);
        }

        if (i == R.id.btSoma) {
            if (displayString != "") {
                if (auxN1 == "") {
                    n1 = Double.parseDouble(displayString);
                    auxN1 = displayString;
                } else {
                    n2 = Double.parseDouble(displayString);
                }
                operacao = "+";
                displayString = "";
                display.setText(displayString);
            }
        }

        if (i == R.id.btIgual) {
            if (displayString != "" || operacao != "") {
                switch (operacao) {
                    case "+":
                        operacao = "";
                        resultado = n1 + n2;
                        displayString = String.valueOf(resultado);
                        display.setText(displayString);
                        break;
                }
            }
        }
    }

}
