package com.solid.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class EmprestimoLivro {

    private String id;

    private Cliente cliente;
    private Livro livro;

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucao;

    private BigDecimal valor;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public static BigDecimal geraValorEmprestimo(EmprestimoLivro emprestimoLivro) {
        int dias = (int) ChronoUnit.DAYS.between(emprestimoLivro.getDataEmprestimo(), emprestimoLivro.getDataDevolucao());

        return emprestimoLivro.getLivro().getValorDiario().multiply(BigDecimal.valueOf(dias));
    }
}
