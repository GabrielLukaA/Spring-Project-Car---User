package net.weg.api.repository;

import java.util.Set;

public interface ICRUD<T, ID> extends AutoCloseable {
    void inserir(T obj);

    void atualizar(T obj);

    void deletar(ID id);

    T buscarUm(ID id);

    Set<T> buscarTodos();

}
