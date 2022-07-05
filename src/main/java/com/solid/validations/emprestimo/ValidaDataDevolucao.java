package com.solid.validations.emprestimo;

import com.solid.models.EmprestimoLivro;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidaDataDevolucao implements ValidarEmprestimo{
    public final static int MAX_PRAZO_DEVOLUCAO = 20;

    @Override
    public void validar(EmprestimoLivro emprestimoLivro) throws RuntimeException {
        final LocalDate data = emprestimoLivro.getDataDevolucao();

        if(data == null) emprestimoLivro.setDataDevolucao(
                LocalDate.from(emprestimoLivro.getDataEmprestimo()).plusDays(MAX_PRAZO_DEVOLUCAO));

        if (ChronoUnit.DAYS.between(emprestimoLivro.getDataEmprestimo(),data) > MAX_PRAZO_DEVOLUCAO){
            throw new RuntimeException("Data devolução inválida");
        }
    }
}
