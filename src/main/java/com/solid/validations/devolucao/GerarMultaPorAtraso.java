package com.solid.validations.devolucao;

import com.solid.models.EmprestimoLivro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GerarMultaPorAtraso implements ValidarDevolucao{

    double MULTA_POR_DIA = 0.05;
    double MAX_MULTA_POR_DIA = 0.20;

    @Override
    public void validar(EmprestimoLivro emprestimoLivro) {
        final LocalDate devolucao = emprestimoLivro.getDataDevolucao();
        final LocalDate atual = LocalDate.now();

        BigDecimal multaTotal = new BigDecimal(0.0);
        int diasAtrasos = 0;

        if (atual.isAfter(devolucao)){
            diasAtrasos = (int) ChronoUnit.DAYS.between(devolucao, atual);
            BigDecimal multa = new BigDecimal(diasAtrasos * MULTA_POR_DIA);
            multaTotal = multa.max(new BigDecimal(MAX_MULTA_POR_DIA));
        }

        BigDecimal valorOld = emprestimoLivro.getValor();
        BigDecimal valorPorAtraso = multaTotal.multiply(valorOld);
        emprestimoLivro.getValor().add(valorPorAtraso);
    }
}
