package org.una.sdm.aula09.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.sdm.aula09.domain.Item;
import org.una.sdm.aula09.domain.Pedido;
import org.una.sdm.aula09.domain.Produto;
import org.una.sdm.aula09.exceptions.PedidoNotFoundException;
import org.una.sdm.aula09.exceptions.ProdutoNotFoundException;
import org.una.sdm.aula09.repositories.ItemRepositoryJPA;
import org.una.sdm.aula09.services.interfaces.ItemServiceAPI;
import org.una.sdm.aula09.services.interfaces.PedidoServiceAPI;
import org.una.sdm.aula09.services.interfaces.ProdutoServiceAPI;

import java.util.List;

@Service
public class ItemService implements ItemServiceAPI {

    @Autowired
    private ItemRepositoryJPA repositoryJPA;

    @Autowired
    private PedidoServiceAPI pedidoService;

    @Autowired
    private ProdutoServiceAPI produtoService;


    @Override
    @Transactional(readOnly = true)
    public Item get(Long id) {
        return repositoryJPA.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> findAll() {
        return repositoryJPA.findAll();
    }

    @Override
    @Transactional
    public Item create(Item item) {

        //validar se o objeto pedido e o objeto produto existem no item

        if(item.getPedido() == null || item.getPedido().getId() == null) {
            throw new PedidoNotFoundException("Item sem definição de pedido.");
        }

        if(item.getProduto() == null || item.getProduto().getId() == null) {
            throw new ProdutoNotFoundException("Item sem definição de produto.");
        }

        Pedido pedido = pedidoService.get(item.getPedido().getId());
        Produto produto = produtoService.get(item.getProduto().getId());

        if(item.getQuantidade() == null) {
            item.setQuantidade(1);
        }

        item.setTotal(item.getQuantidade() * produto.getPreco());

        item = repositoryJPA.saveAndFlush(item);

        pedido = pedidoService.get(pedido.getId());

        Double total = 0.0;
        for(Item it: pedido.getItems()) {
            total = total + it.getTotal();
        }

        pedido.setTotal(total);

        pedidoService.update(pedido);

        return item;
    }

    @Override
    @Transactional
    public void update(Item item) {
        repositoryJPA.save(item);
    }

    @Override
    @Transactional
    public void remove(Long id)  {
        repositoryJPA.deleteById(id);
    }
}
