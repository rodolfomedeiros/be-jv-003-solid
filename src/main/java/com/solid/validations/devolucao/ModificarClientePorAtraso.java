package com.solid.validations.devolucao;

import com.solid.models.EmprestimoLivro;

import java.time.LocalDate;

public class ModificarClientePorAtraso implements ValidarDevolucao{
    final static int MAX_ATRASOS = 3;

    @Override
    public void validar(EmprestimoLivro emprestimoLivro) {
        LocalDate devolucao = emprestimoLivro.getDataDevolucao();
        LocalDate atual = LocalDate.now();

        if(atual.isAfter(devolucao)) {
            emprestimoLivro.getCliente().setAtrasos(emprestimoLivro.getCliente().getAtrasos()+1);
        }
        if (emprestimoLivro.getCliente().getAtrasos() >= MAX_ATRASOS){
            emprestimoLivro.getCliente().setBloqueado(true);
            emprestimoLivro.getCliente().setBloqueadoAte(atual.plusMonths(1));
        }
    }
}
