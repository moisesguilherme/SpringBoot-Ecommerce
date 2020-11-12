package org.una.sdm.aula09.domain.builders;

import org.una.sdm.aula09.domain.Categoria;
import org.una.sdm.aula09.domain.Produto;

public class ProdutoBuilder {

    private Produto produto = new Produto();

    public ProdutoBuilder id(Long id){
        produto.setId(id);
        return this;
    }

    public ProdutoBuilder nome(String nome){
        produto.setNome(nome);
        return this;
    }

    public ProdutoBuilder preco(Double preco){
        produto.setPreco(preco);
        return this;
    }

    public ProdutoBuilder categoria(Categoria categoria){
        produto.setCategoria(categoria);
        return this;
    }

    public Produto build() {
        return produto;
    }
}
