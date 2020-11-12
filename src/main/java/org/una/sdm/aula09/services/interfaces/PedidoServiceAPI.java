package org.una.sdm.aula09.services.interfaces;

import org.una.sdm.aula09.domain.Pedido;

import java.util.List;

public interface PedidoServiceAPI {

    public Pedido get(Long id);

    public List<Pedido> findAll();

    public Pedido create(Pedido pedido);

    public void update(Pedido pedido);

    public void remove(Long id);
}
