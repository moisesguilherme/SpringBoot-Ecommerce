package org.una.sdm.aula09.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.una.sdm.aula09.domain.Cliente;
import org.una.sdm.aula09.domain.Item;

import java.util.List;

@Repository
public interface ItemRepositoryJPA extends JpaRepository<Item, Long> {

}
