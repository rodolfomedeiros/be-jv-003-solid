package com.solid;

import com.solid.models.*;
import com.solid.repositories.EmprestimoLivroRepository;
import com.solid.services.DevolucaoEmprestimoService;
import com.solid.services.RealizaEmprestimoService;
import com.solid.validations.devolucao.GerarMultaPorAtraso;
import com.solid.validations.devolucao.ModificarClientePorAtraso;
import com.solid.validations.devolucao.ValidarDevolucao;
import com.solid.validations.emprestimo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Aplicacao {

    public static void main(String[] args) {
        EmprestimoLivroRepository emprestimoLivroRepository = new EmprestimoLivroRepository();

        Livro livro1 = new LivroCientifico();
        livro1.setNome("01 - Científico");
        Livro livro2 = new LivroLiteratura();
        livro2.setNome("02 - Literatura");

        Cliente cliente1 = new Cliente();
        cliente1.setEmail("cliente01@teste.com");
        cliente1.setNome("Cliente 01");
        cliente1.setTelefone("8499663-7549");

        Cliente cliente2 = new Cliente();
        cliente2.setEmail("cliente02@teste.com");
        cliente2.setNome("Cliente 02");
        cliente2.setTelefone("8499663-7549");

        // ----- Realizar Empréstimo -----

        List<ValidarEmprestimo> validarEmprestimos = new ArrayList<ValidarEmprestimo>();
        validarEmprestimos.add(new ValidarCliente());
        validarEmprestimos.add(new ValidarLivro());
        validarEmprestimos.add(new ValidaDataDevolucao());
        validarEmprestimos.add(new ValidarClienteEmprestimos());

        RealizaEmprestimoService realizar =
                new RealizaEmprestimoService(emprestimoLivroRepository, validarEmprestimos);


        // -- novo empréstimo --

        EmprestimoLivro em1 = new EmprestimoLivro();
        em1.setId(UUID.randomUUID().toString());
        em1.setCliente(cliente1);
        em1.setLivro(livro1);
        em1.setDataEmprestimo(LocalDate.of(2022, 01, 01));
        em1.setDataDevolucao(LocalDate.of(2022, 01, 20));

        realizar.realizaEmprestimo(em1);

        // ---- Devolução Empréstimo ----

        List<ValidarDevolucao> validaDataDevolucaos = new ArrayList<>();
        validaDataDevolucaos.add(new ModificarClientePorAtraso());
        validaDataDevolucaos.add(new GerarMultaPorAtraso());

        DevolucaoEmprestimoService devolucao= new DevolucaoEmprestimoService(emprestimoLivroRepository, validaDataDevolucaos);

        EmprestimoLivro em2 = emprestimoLivroRepository.buscar(em1.getId()).get();

        devolucao.devolucaoEmprestimo(em2);
    }
}
