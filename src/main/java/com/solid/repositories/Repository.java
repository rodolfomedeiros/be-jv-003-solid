package com.solid.repositories;

import java.util.Optional;

public interface Repository<T, K> {
    Optional<T> buscar(K key);
    boolean inserir(T instancia);
    boolean atualizar(T instancia);
    Optional<T> deletar(K key);
}
