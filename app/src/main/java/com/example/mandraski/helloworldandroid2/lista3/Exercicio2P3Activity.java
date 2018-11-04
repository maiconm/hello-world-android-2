package com.example.mandraski.helloworldandroid2.lista3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mandraski.helloworldandroid2.R;

import java.util.List;

public class Exercicio2P3Activity extends AppCompatActivity implements View.OnClickListener {
    private EditText nome, idade, profissao;
    private AlertDialog alerta;
    private AlertDialog.Builder builder;
    private PessoaDAO pessoaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio2_p3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pessoaDAO = new PessoaDAO(this);
        pessoaDAO.open();

        builder = new AlertDialog.Builder(this);

        nome = findViewById(R.id.etPratica3Exe2nome);
        idade = findViewById(R.id.etPratica3Exe2idade);
        profissao = findViewById(R.id.etPratica3Exe2profissao);

        findViewById(R.id.btPratica3Exe2Inserir).setOnClickListener(this);
        findViewById(R.id.btPratica3Exe2Deletar).setOnClickListener(this);
        findViewById(R.id.btPratica3Exe2Mostrar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btPratica3Exe2Inserir) {
            if (!temCamposVazio()) {
                criarPessoa();
            }
        }
        if (i == R.id.btPratica3Exe2Deletar) {
            if (!temCamposVazio()) {
                deletarPessoa();
            }
        }
        if (i == R.id.btPratica3Exe2Mostrar) {
            startActivity(new Intent(this, Exercicio2P3Tela2Activity.class));
        }
    }

    private boolean temCamposVazio() {
        String campos = "";
        if (nome.getText().toString().isEmpty()) {
            campos += "nome";
        }
        if (idade.getText().toString().isEmpty()) {
            campos += " idade";
        }
        if (profissao.getText().toString().isEmpty()) {
            campos += " profissao";
        }
        if (!campos.equals("")){
            builder.setTitle("Atencao");
            builder.setMessage(campos + " estao vazios!");
            alerta = builder.create();
            alerta.show();
            return true;
        }
        return false;
    }

    private void criarPessoa() {
        String nomePessoa = nome.getText().toString();
        String idadePessoa = idade.getText().toString();
        String profissaoPessoa = profissao.getText().toString();
        pessoaDAO.criarPessoa(nomePessoa, idadePessoa, profissaoPessoa);
        Toast.makeText(this, nomePessoa + " criado com sucesso!", Toast.LENGTH_SHORT).show();
    }

    private void deletarPessoa() {
        boolean deletou = false;
        Pessoa pessoa = new Pessoa(nome.getText().toString(),
                idade.getText().toString(),
                profissao.getText().toString());
        List<Pessoa> pessoas = pessoaDAO.getAllPessoas();
        for (int j = 0; j <= pessoas.size(); j++) {
            if (pessoas.get(j).getNome().equals(pessoa.getNome())) {
                pessoaDAO.excluirPessoa(pessoas.get(j));
                Toast.makeText(this, pessoa.getNome() + " excluido com sucesso!", Toast.LENGTH_SHORT).show();
                deletou = true;
                break;
            }
        }
        if (!deletou) {
            Toast.makeText(this, pessoa.getNome() + " nao encontrado!", Toast.LENGTH_SHORT).show();
        }
    }
}
