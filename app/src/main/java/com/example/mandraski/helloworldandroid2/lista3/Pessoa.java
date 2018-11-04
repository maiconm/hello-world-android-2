package com.example.mandraski.helloworldandroid2.lista3;

public class Pessoa {
    private long id;
    private String nome;
    private String idade;
    private String cpf;

    public Pessoa (long id, String nome, String idade, String cpf) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public Pessoa (String nome, String idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
