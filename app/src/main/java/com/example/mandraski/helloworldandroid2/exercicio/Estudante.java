package com.example.mandraski.helloworldandroid2.exercicio;

public class Estudante {

    private long id;
    private String nome;
    private String matricula;

    public Estudante(long id, String nome, String matricula) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
