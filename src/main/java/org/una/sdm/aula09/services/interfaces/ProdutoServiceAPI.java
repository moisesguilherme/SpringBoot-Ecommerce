package org.una.sdm.aula09.services.interfaces;

import org.una.sdm.aula09.domain.Produto;

import java.util.List;

public interface ProdutoServiceAPI {

    public Produto get(Long id);

    public List<Produto> findAll();

    public Produto create(Produto Produto);

    public void update(Produto Produto);

    public void remove(Long id);
}
