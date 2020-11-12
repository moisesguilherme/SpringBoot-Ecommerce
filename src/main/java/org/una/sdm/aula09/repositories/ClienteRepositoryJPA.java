package org.una.sdm.aula09.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.una.sdm.aula09.domain.Cliente;

@Repository
public interface ClienteRepositoryJPA extends JpaRepository<Cliente, Long> {

    @Query("select cliente from Cliente cliente where cliente.cpf = ?1")
    public Cliente findByCpf(String cpf);
}
