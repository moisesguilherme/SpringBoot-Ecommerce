package org.una.sdm.aula09.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.sdm.aula09.controllers.mappers.ProdutoMapper;
import org.una.sdm.aula09.controllers.representations.ProdutoRepresentation;
import org.una.sdm.aula09.domain.Categoria;
import org.una.sdm.aula09.domain.Produto;
import org.una.sdm.aula09.domain.builders.CategoriaBuilder;
import org.una.sdm.aula09.domain.builders.ProdutoBuilder;
import org.una.sdm.aula09.services.interfaces.ProdutoServiceAPI;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoServiceAPI produtoService;


    @GetMapping(value = "/{id}")
    public @ResponseBody
    Produto get(@PathVariable(name = "id") Long id) {

        return produtoService.get(id);
    }


    @GetMapping
    public @ResponseBody
    HttpEntity<Object> findAll() {

        List<Produto> produtos = produtoService.findAll();

        if(produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(produtos);
    }


    @PostMapping
    public Produto create(@RequestBody ProdutoRepresentation representation){

        Produto produto = ProdutoMapper.inbound(representation);
        return produtoService.create(produto);
    }

    @PutMapping
    public void update(@PathVariable(name = "id") Long id,
                          @RequestBody Produto Produto){

        produtoService.update(Produto);
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable(name = "id") Long id) {

        produtoService.remove(id);
    }

}
