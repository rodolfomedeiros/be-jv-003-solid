package com.solid.validations.emprestimo;

import com.solid.models.EmprestimoLivro;
import com.solid.models.Livro;

public class ValidarLivro implements ValidarEmprestimo {

    @Override
    public void validar(EmprestimoLivro emprestimoLivro) throws RuntimeException {
        final Livro livro = emprestimoLivro.getLivro();

        if(livro == null) throw new RuntimeException("Livro não inserido!");
        if(livro.getNome().isBlank()) throw new RuntimeException("Nome do livro inválido!");
    }
}
