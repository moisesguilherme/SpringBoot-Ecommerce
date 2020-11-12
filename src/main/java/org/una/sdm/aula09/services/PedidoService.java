package org.una.sdm.aula09.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.sdm.aula09.domain.Pedido;
import org.una.sdm.aula09.exceptions.PedidoNotFoundException;
import org.una.sdm.aula09.repositories.PedidoRepositoryJPA;
import org.una.sdm.aula09.services.interfaces.PedidoServiceAPI;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PedidoService implements PedidoServiceAPI {

    @Autowired
    private PedidoRepositoryJPA repositoryJPA;

    @Override
    @Transactional(readOnly = true)
    public Pedido get(Long id) {

        try {
            return repositoryJPA.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new PedidoNotFoundException("Pedido não existe.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> findAll() {
        return repositoryJPA.findAll();
    }

    @Override
    @Transactional
    public Pedido create(Pedido pedido) {
        pedido.setStatus(Pedido.Status.ABERTO);
        return repositoryJPA.save(pedido);
    }

    @Override
    @Transactional
    public void update(Pedido pedido) {
        repositoryJPA.save(pedido);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        repositoryJPA.deleteById(id);
    }
}
