package com.solid.validations.emprestimo;

import com.solid.models.Cliente;
import com.solid.models.EmprestimoLivro;

public class ValidarCliente implements ValidarEmprestimo {
    @Override
    public void validar(EmprestimoLivro emprestimoLivro) throws RuntimeException {
        final Cliente cliente = emprestimoLivro.getCliente();

        if (cliente == null) throw new RuntimeException("cliente não inserido");
        if (cliente.getEmail().isBlank()) throw new RuntimeException("Email do cliente inválido");
        if (cliente.getNome().isBlank()) throw new RuntimeException("Nome do cliente é inválido");
        if (cliente.getTelefone().isBlank()) throw new RuntimeException("Telefone do cliente inválido");
    }
}
