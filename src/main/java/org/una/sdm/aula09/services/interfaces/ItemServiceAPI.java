package org.una.sdm.aula09.services.interfaces;

import org.una.sdm.aula09.domain.Item;

import java.util.List;

public interface ItemServiceAPI {

    public Item get(Long id);

    public List<Item> findAll();

    public Item create(Item item);

    public void update(Item item);

    public void remove(Long id);
}
