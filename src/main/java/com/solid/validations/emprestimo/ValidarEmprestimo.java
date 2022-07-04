package com.solid.validations.emprestimo;

import com.solid.models.EmprestimoLivro;

public interface ValidarEmprestimo {
    void validar(EmprestimoLivro emprestimoLivro) throws RuntimeException;
}
