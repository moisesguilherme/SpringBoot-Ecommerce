package org.una.sdm.aula09.services.interfaces;

import org.una.sdm.aula09.domain.Categoria;

import java.util.List;

public interface CategoriaServiceAPI {

    public Categoria get(Long id);

    public List<Categoria> findAll();

    public Categoria create(Categoria categoria);

    public void update(Categoria categoria);

    public void remove(Long id);
}
