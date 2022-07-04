package com.solid.validations.emprestimo;

import com.solid.models.EmprestimoLivro;

import java.time.LocalDate;

public class ValidaDataDevolucao implements ValidarEmprestimo{
    public final static int MAX_PRAZO_DEVOLUCAO = 20;

    @Override
    public void validar(EmprestimoLivro emprestimoLivro) throws RuntimeException {
        final LocalDate data = emprestimoLivro.getDataDevolucao();

        if(data == null) emprestimoLivro.setDataDevolucao(
                LocalDate.from(emprestimoLivro.getDataEmprestimo()).plusDays(MAX_PRAZO_DEVOLUCAO));
    }
}
