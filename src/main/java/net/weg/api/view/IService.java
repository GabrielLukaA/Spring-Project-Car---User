package net.weg.api.view;

import net.weg.api.model.dto.IDTO;

import java.util.Collection;

public interface IService<T,ID> {

    void cadastrar(IDTO dto) throws Exception;

    void editar(IDTO dto) throws Exception;
    void deletar(ID id);

    T buscarUm(ID id);

    Collection<T> buscarTodos();


}
