package org.una.sdm.aula09.domain.builders;

import org.una.sdm.aula09.domain.Categoria;
import org.una.sdm.aula09.domain.Produto;

import java.util.List;

public class CategoriaBuilder {

    private Categoria categoria = new Categoria();

    public CategoriaBuilder id(Long id){
        categoria.setId(id);
        return this;
    }

    public CategoriaBuilder nome(String nome){
        categoria.setNome(nome);
        return this;
    }

    public CategoriaBuilder produtos(List<Produto> produtos){
        categoria.setProdutos(produtos);
        return this;
    }

    public Categoria build() {
        return categoria;
    }
}
