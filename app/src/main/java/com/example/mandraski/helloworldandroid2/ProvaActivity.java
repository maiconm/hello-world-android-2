package com.example.mandraski.helloworldandroid2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ProvaActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup rgConversaoNumerica;
    private RadioButton dec;
    private TextView display;
    private String displayString = "";
    private String operacao = "";
    private String conversao = "decimal";
    private double n1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova);
        Toolbar toolbar = findViewById(R.id.toolbar);
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
        findViewById(R.id.btExp).setOnClickListener(this);
        findViewById(R.id.btRaiz).setOnClickListener(this);
        display = findViewById(R.id.tvDisplay);
        rgConversaoNumerica = findViewById(R.id.rgConversaoNum);
        dec = findViewById(R.id.rbDec);

    }

    @Override
    public  void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btNumUm) {
            rbDecToggle();
            displayString += "1";
            display.setText(displayString);
        }

        if (i == R.id.btNumDois) {
            rbDecToggle();
            displayString += "2";
            display.setText(displayString);
        }

        if (i == R.id.btNumTres) {
            rbDecToggle();
            displayString += "3";
            display.setText(displayString);
        }

        if (i == R.id.btNumQuatro) {
            rbDecToggle();
            displayString += "4";
            display.setText(displayString);
        }

        if (i == R.id.btNumCinco) {
            rbDecToggle();
            displayString += "5";
            display.setText(displayString);
        }

        if (i == R.id.btNumSeis) {
            rbDecToggle();
            displayString += "6";
            display.setText(displayString);
        }

        if (i == R.id.btNumSete) {
            rbDecToggle();
            displayString += "7";
            display.setText(displayString);
        }

        if (i == R.id.btNumOito) {
            rbDecToggle();
            displayString += "8";
            display.setText(displayString);
        }

        if (i == R.id.btNumNove) {
            rbDecToggle();
            displayString += "9";
            display.setText(displayString);
        }

        if (i == R.id.btNumZero) {
            rbDecToggle();
            displayString += "0";
            display.setText(displayString);
        }

        if (i == R.id.btClear) {
            rbDecToggle();
            displayString = "";
            display.setText(displayString);
        }

        if (i == R.id.btPonto) {
            rbDecToggle();
            if (displayString.contains(".")) {
                return;
            }
            if (displayString.equals("")) {
                displayString = "0.";
            } else {
                displayString += ".";
            }
            display.setText(displayString);
        }

        if (i == R.id.btSoma) {
            rbDecToggle();
            if (!displayString.equals("")) {
                n1 = Double.parseDouble(displayString);
                operacao = "+";
                displayString = "";
                display.setText(displayString);
            }
        }

        if (i == R.id.btSubtracao) {
            rbDecToggle();
            if (!displayString.equals("")) {
                n1 = Double.parseDouble(displayString);
                operacao = "-";
                displayString = "";
                display.setText(displayString);
            }
        }

        if (i == R.id.btMultiplicacao) {
            rbDecToggle();
            if (!displayString.equals("")) {
                n1 = Double.parseDouble(displayString);
                operacao = "x";
                displayString = "";
                display.setText(displayString);
            }
        }

        if (i == R.id.btDivisao) {
            rbDecToggle();
            if (!displayString.equals("")) {
                n1 = Double.parseDouble(displayString);
                operacao = "/";
                displayString = "";
                display.setText(displayString);
            }
        }

        if (i == R.id.btRaiz) {
            rbDecToggle();
            if (!displayString.equals("")) {
                n1 = Double.parseDouble(displayString);
                displayString = String.valueOf(Math.sqrt(n1));
                display.setText(displayString);
            }
        }

        if (i == R.id.btInverte) {
            rbDecToggle();
            if (!displayString.equals("")) {
                n1 = Double.parseDouble(displayString);
                if (n1 < 0) {
                    displayString = displayString.substring(1);
                } else {
                    displayString = "-" + displayString;
                }
                display.setText(displayString);
            }
        }

        if (i == R.id.btExp) {
            rbDecToggle();
            if (!displayString.equals("")) {
                n1 = Double.parseDouble(displayString);
                operacao = "exp";
                displayString = "";
                display.setText(displayString);
            }
        }

        if (i == R.id.btIgual) {
            rbDecToggle();
            if (!displayString.equals("") || !operacao.equals("")) {
                switch (operacao) {

                    case "+":
                        double n2 = Double.parseDouble(0 + displayString);
                        operacao = "";
                        displayString = String.valueOf(n1 + n2);
                        display.setText(displayString);
                        break;

                    case "-":
                        n2 = Double.parseDouble(0 + displayString);
                        operacao = "";
                        displayString = String.valueOf(n1 - n2);
                        display.setText(displayString);
                        break;

                    case "x":
                        n2 = Double.parseDouble(0 + displayString);
                        operacao = "";
                        displayString = String.valueOf(n1 * n2);
                        display.setText(displayString);
                        break;

                    case "/":
                        n2 = Double.parseDouble(0 + displayString);
                        operacao = "";
                        displayString = String.valueOf(n1 / n2);
                        display.setText(displayString);
                        break;

                    case "exp":
                        n2 = Double.parseDouble(0 + displayString);
                        operacao = "";
                        displayString = String.valueOf(Math.pow(n1, n2));
                        display.setText(displayString);
                        break;
                    default:
                }
            }
        }

        switch (rgConversaoNumerica.getCheckedRadioButtonId()) {

            case R.id.rbDec:
                if (!displayString.equals("")) {
                    if (!conversao.equals("decimal")) {
                        displayString = String.valueOf(Integer.parseInt(displayString, 16));
                        display.setText(displayString);
                        conversao = "decimal";
                        break;
                    }
                    break;
                }
                break;

            case R.id.rbBin:
                if (!displayString.equals("")) {
                    if (!conversao.equals("bin")) {
                        displayString = String.valueOf(Integer.toBinaryString(Integer.valueOf(displayString)));
                        display.setText(displayString);
                        conversao = "bin";
                        break;
                    }
                    break;
                }
                break;

            case R.id.rbOctal:
                if (!displayString.equals("")) {
                    if (!conversao.equals("octal")) {
                        displayString = String.valueOf(Integer.toOctalString(Integer.valueOf(displayString)));
                        display.setText(displayString);
                        conversao = "octal";
                        break;
                    }
                    break;
                }
                break;

            case R.id.rbHex:
                if (!displayString.equals("")) {
                    if (!conversao.equals("hex")) {
                        displayString = String.valueOf(Integer.toHexString(Integer.valueOf(displayString)));
                        display.setText(displayString);
                        conversao = "hex";
                        break;
                    }
                    break;
                }
                break;
        }
    }

    private void rbDecToggle() {
        int radioButton = rgConversaoNumerica.getCheckedRadioButtonId();
        if (radioButton != R.id.rbDec) {
            dec.toggle();
            displayString = "";
            display.setText(displayString);
        }
    }
}
