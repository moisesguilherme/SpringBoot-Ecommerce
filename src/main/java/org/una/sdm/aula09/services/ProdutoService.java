package org.una.sdm.aula09.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.sdm.aula09.domain.Produto;
import org.una.sdm.aula09.exceptions.CategoriaNotFoundException;
import org.una.sdm.aula09.repositories.ProdutoRepositoryJPA;
import org.una.sdm.aula09.services.interfaces.CategoriaServiceAPI;
import org.una.sdm.aula09.services.interfaces.ProdutoServiceAPI;

import java.util.List;

@Service
public class ProdutoService implements ProdutoServiceAPI {

    @Autowired
    private ProdutoRepositoryJPA repositoryJPA;

    @Autowired
    private CategoriaServiceAPI categoriaService;


    @Transactional(readOnly = true)
    public Produto get(Long id){
        return repositoryJPA.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Produto> findAll() {
        return repositoryJPA.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Produto create(Produto produto) {

        if(produto.getCategoria() == null || produto.getCategoria().getId() == null) {
            throw new CategoriaNotFoundException("Produto deve ter sua respectiva categoria.");
        }
        categoriaService.get(produto.getCategoria().getId());
        return repositoryJPA.save(produto);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Produto Produto) {
        repositoryJPA.save(Produto);
    }

    @Override
    @Transactional(readOnly = false)
    public void remove(Long id) {
        repositoryJPA.deleteById(id);
    }

}
