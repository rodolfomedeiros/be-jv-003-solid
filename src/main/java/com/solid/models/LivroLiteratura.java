package com.solid.models;

import java.math.BigDecimal;

public class LivroLiteratura extends Livro{

    @Override
    public BigDecimal getValorDiario() {
        return new BigDecimal(3.00);
    }
}
