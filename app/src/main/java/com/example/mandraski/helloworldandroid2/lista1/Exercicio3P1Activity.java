package com.example.mandraski.helloworldandroid2.lista1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mandraski.helloworldandroid2.R;

public class Exercicio3P1Activity extends AppCompatActivity {

    /**
     * Variaveis:
     */
    private Spinner spExperiencia;
    private EditText etNome, etTelefone, etEndereco;
    private CheckBox cbDesenvolvimento, cbInfraestrutura, cbGestao;
    private RadioGroup rgSexo;
    private TextView tvResult;
    private Button btMostrarDados;
    private String valorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio3_p1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Seta opcoes do `spinner` de experiencia do componente:
         */
        spExperiencia = (Spinner) findViewById(R.id.spPratica1Exe3Experiencia);
        String[] opcoes = getResources().getStringArray(R.array.experiencia_p1_exercicio3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opcoes);
        spExperiencia.setAdapter(adapter);
        /**
         * Pega valor do spinner:
         */
        spExperiencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valorSpinner = spExperiencia.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        /**
         * Ligacao das variaveis com os componentes do xml:
         */
        etNome = findViewById(R.id.etPratica1Exe3Nome);
        etTelefone = findViewById(R.id.etPratica1Exe3Telefone);
        etEndereco = findViewById(R.id.etPratica1Exe3Endereco);
        cbDesenvolvimento = findViewById(R.id.cbPratica1Exe3OpcaoDesenvolvimento);
        cbInfraestrutura = findViewById(R.id.cbPratica1Exe3OpcaoInfraestrutura);
        cbGestao = findViewById(R.id.cbPratica1Exe3OpcaoGestao);
        rgSexo = findViewById(R.id.rgPratica1Exe3Sexo);
        tvResult = findViewById(R.id.tvPratica1Exe3Result);
        btMostrarDados = findViewById(R.id.btPratica1Exe3MostrarDados);
        /**
         * Ao clicar em mostrar dados:
         */
        btMostrarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * verifica quais checkboexes estao selecionados, entao
                 * eh adicionado na variavel `areasInteresse`:
                 */
                String areasInteresse = "";
                if (cbDesenvolvimento.isChecked()) {
                    areasInteresse += " desenvolvimento,";
                }
                if (cbInfraestrutura.isChecked()) {
                    areasInteresse += " infraestrutura,";
                }
                if (cbGestao.isChecked()) {
                    areasInteresse += " gestao,";
                }
                /**
                 * entao, pega o valor do radio button selecionado:
                 */
                int opcaoSexo = rgSexo.getCheckedRadioButtonId();
                String sexo = "";
                switch (opcaoSexo) {
                    case R.id.rbPratica1Exe3Feminino:
                        sexo = "feminino";
                        break;
                    case R.id.rbPratica1Exe3Masculino:
                        sexo = "masculino";
                        break;
                }
                tvResult.setText(etNome.getText() + ", " + etTelefone.getText() + ", " + etEndereco.getText() + ", " + areasInteresse + " " + sexo + ", " + valorSpinner + ".");
            }
        });

    }

}
