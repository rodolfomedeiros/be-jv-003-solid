package com.solid.models;

import java.math.BigDecimal;

public abstract class Livro {

    private String nome;

    public Livro(){};

    public Livro(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract BigDecimal getValorDiario();
}
