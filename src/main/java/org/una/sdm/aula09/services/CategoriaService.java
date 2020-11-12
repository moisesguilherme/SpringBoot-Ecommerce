package org.una.sdm.aula09.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.sdm.aula09.domain.Categoria;
import org.una.sdm.aula09.exceptions.CategoriaException;
import org.una.sdm.aula09.exceptions.CategoriaNotFoundException;
import org.una.sdm.aula09.exceptions.CategoriaWithSameNameException;
import org.una.sdm.aula09.repositories.CategoriaRepositoryJPA;
import org.una.sdm.aula09.services.interfaces.CategoriaServiceAPI;

import java.util.List;

@Service
public class CategoriaService implements CategoriaServiceAPI {

    @Autowired
    private CategoriaRepositoryJPA repositoryJPA;

    @Transactional(readOnly = true)
    public Categoria get(Long id){

        try {
            Categoria categoria = repositoryJPA.findById(id).get();
            return categoria;
        } catch (Exception ex) {
            throw new CategoriaNotFoundException(String.format("Categoria não existe com esse id: %s ", id));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {

        return repositoryJPA.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Categoria create(Categoria categoria) {

        Categoria categoriaBuscada = repositoryJPA.findByNome(categoria.getNome());
        if(categoriaBuscada != null) {
            throw new CategoriaWithSameNameException("Não é possível cadastrar duas categorias com o mesmo nome.");
        }
        return repositoryJPA.save(categoria);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Categoria categoria) {
        repositoryJPA.save(categoria);
    }

    @Override
    @Transactional(readOnly = false)
    public void remove(Long id) {
        repositoryJPA.deleteById(id);
    }

}
