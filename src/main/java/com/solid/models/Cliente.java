package com.solid.models;

import java.time.LocalDate;

public class Cliente {

    private String nome;
    private String email;
    private String telefone;
    private int emprestimos;
    private int atrasos;
    private boolean bloqueado;
    private LocalDate bloqueadoAte;

    public Cliente(){};

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(int emprestimos) {
        this.emprestimos = emprestimos;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public LocalDate getBloqueadoAte() {
        return bloqueadoAte;
    }

    public void setBloqueadoAte(LocalDate bloqueadoAte) {
        this.bloqueadoAte = bloqueadoAte;
    }

    public int getAtrasos() {
        return atrasos;
    }

    public void setAtrasos(int atrasos) {
        this.atrasos = atrasos;
    }
}
