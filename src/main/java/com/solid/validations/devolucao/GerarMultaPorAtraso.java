package com.solid.validations.devolucao;

import com.solid.models.EmprestimoLivro;

import java.time.LocalDate;

public class GerarMultaPorAtraso implements ValidarDevolucao{

    double MULTA_POR_DIA = 0.05;
    double MAX_MULTA_POR_DIA = 0.20;

    @Override
    public void validar(EmprestimoLivro emprestimoLivro) {
        final LocalDate devolucao = emprestimoLivro.getDataDevolucao();
        final LocalDate atual = LocalDate.now();

    }
}
