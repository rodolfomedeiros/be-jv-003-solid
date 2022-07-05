package com.solid.services;

import com.solid.models.EmprestimoLivro;
import com.solid.repositories.EmprestimoLivroRepository;
import com.solid.validations.devolucao.ValidarDevolucao;

import java.util.List;

public class DevolucaoEmprestimoService {

    private List<ValidarDevolucao> validarDevolucaos;

    private EmprestimoLivroRepository emprestimoLivroRepository;

    public DevolucaoEmprestimoService(EmprestimoLivroRepository emprestimoLivroRepository, List<ValidarDevolucao> validarDevolucaos) {
        this.emprestimoLivroRepository = emprestimoLivroRepository;
        this.validarDevolucaos = validarDevolucaos;
    }

    public void devolucaoEmprestimo(EmprestimoLivro emprestimoLivro) {
        for (ValidarDevolucao validarDevolucao : validarDevolucaos) {
            try {
                validarDevolucao.validar(emprestimoLivro);
            } catch (RuntimeException e) {

            }
        }

        emprestimoLivroRepository.deletar(emprestimoLivro.getId());

        System.out.println("Devolução realizada com sucesso!");
    }
}
