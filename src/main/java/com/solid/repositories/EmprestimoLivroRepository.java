package com.solid.repositories;

import com.solid.models.Cliente;
import com.solid.models.EmprestimoLivro;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmprestimoLivroRepository implements Repository<EmprestimoLivro, String> {

    private Map<String, EmprestimoLivro> emprestimos;

    public List<EmprestimoLivro> buscaPorCliente(String email) {
        return emprestimos
                .values()
                .stream()
                .filter(emprestimoLivro -> emprestimoLivro.getCliente().getEmail().compareTo(email) == 0)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmprestimoLivro> buscar(String key) {
        return Optional.ofNullable(emprestimos.get(key));
    }

    @Override
    public boolean inserir(EmprestimoLivro instancia) {
        emprestimos.put(instancia.getId(), instancia);
        return true;
    }

    @Override
    public boolean atualizar(EmprestimoLivro instancia) {
        emprestimos.put(instancia.getId(), instancia);
        return true;
    }

    @Override
    public Optional<EmprestimoLivro> deletar(String key) {
        return Optional.ofNullable(emprestimos.remove(key));
    }
}
