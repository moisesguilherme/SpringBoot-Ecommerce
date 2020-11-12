package org.una.sdm.aula09.services.interfaces;

import org.una.sdm.aula09.domain.Cliente;

import java.util.List;

public interface ClienteServiceAPI {

    public Cliente get(Long id);

    public List<Cliente> findAll();

    public Cliente create(Cliente Cliente);

    public void update(Cliente Cliente);

    public void remove(Long id);
}
