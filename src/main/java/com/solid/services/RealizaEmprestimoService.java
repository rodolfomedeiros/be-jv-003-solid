package com.solid.services;

import com.solid.models.*;
import com.solid.repositories.EmprestimoLivroRepository;
import com.solid.validations.emprestimo.ValidarEmprestimo;

import java.util.List;

public class RealizaEmprestimoService {

    private List<ValidarEmprestimo> validarEmprestimos;
    private EmprestimoLivroRepository emprestimoLivroRepository;

    public RealizaEmprestimoService(EmprestimoLivroRepository emprestimoLivroRepository, List<ValidarEmprestimo> validarEmprestimos){
        this.validarEmprestimos = validarEmprestimos;
        this.emprestimoLivroRepository = emprestimoLivroRepository;
    }

    public void realizaEmprestimo(EmprestimoLivro emprestimoLivro){
        for (ValidarEmprestimo validarEmprestimo : validarEmprestimos) {
            try {
                validarEmprestimo.validar(emprestimoLivro);
            } catch (RuntimeException e) {
                System.out.println("Não foi possível realizar o empréstimo!!!");
                System.out.println("Motivo: "+e.getMessage());
                System.out.println("Tente novamente...");
                return;
            }
        }

        emprestimoLivro.setValor(EmprestimoLivro.geraValorEmprestimo(emprestimoLivro));

        emprestimoLivroRepository.inserir(emprestimoLivro);
    }
}
