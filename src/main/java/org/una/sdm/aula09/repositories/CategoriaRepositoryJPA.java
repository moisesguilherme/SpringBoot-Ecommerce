package org.una.sdm.aula09.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.sdm.aula09.domain.Categoria;

@Repository
public interface CategoriaRepositoryJPA extends JpaRepository<Categoria, Long> {

    public Categoria findByNome(String nome);
}
