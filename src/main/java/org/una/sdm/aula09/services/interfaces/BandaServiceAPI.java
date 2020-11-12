package org.una.sdm.aula09.services.interfaces;

import org.una.sdm.aula09.domain.Banda;
import org.una.sdm.aula09.domain.Categoria;

import java.util.List;

public interface BandaServiceAPI {

    public Banda get(Long id);

    public List<Banda> findAll();

    public Banda create(Banda banda);

    public void update(Banda banda);

    public void remove(Long id);
}
