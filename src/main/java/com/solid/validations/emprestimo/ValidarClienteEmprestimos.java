package com.solid.validations.emprestimo;

import com.solid.models.Cliente;
import com.solid.models.EmprestimoLivro;

public class ValidarClienteEmprestimos implements ValidarEmprestimo{

    int MAX_EMPRESTIMO_POR_CLIENTE = 2;

    @Override
    public void validar(EmprestimoLivro emprestimoLivro) throws RuntimeException {
        final Cliente cliente = emprestimoLivro.getCliente();

        if(cliente.getEmprestimos() >= MAX_EMPRESTIMO_POR_CLIENTE) throw new RuntimeException("Quantidade máxima de empréstimos atingida!");
        else cliente.setEmprestimos(cliente.getEmprestimos()+1);
    }
}
