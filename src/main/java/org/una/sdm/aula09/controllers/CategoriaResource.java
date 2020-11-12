package org.una.sdm.aula09.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.sdm.aula09.domain.Categoria;
import org.una.sdm.aula09.domain.Produto;
import org.una.sdm.aula09.services.interfaces.CategoriaServiceAPI;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaServiceAPI categoriaService;


    @GetMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Categoria> get(@PathVariable(name = "id") Long id) {

        Categoria categoria = categoriaService.get(id);
        return ResponseEntity.ok(categoria);
    }


    @GetMapping
    public @ResponseBody
    HttpEntity<List<Categoria>> findAll() {

        List<Categoria> categorias = categoriaService.findAll();

        if(categorias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        for(Categoria categoria: categorias) {
            categoria.add(linkTo(methodOn(CategoriaResource.class).getProdutosByCategoria(categoria.getId()))
                    .withRel("produtos")
            );
        }

        return ResponseEntity.ok(categorias);
    }


    @GetMapping(value = "/{id}/produtos")
    public @ResponseBody
    List<Produto> getProdutosByCategoria(@PathVariable(name = "id") Long id) {

        Categoria categoria = categoriaService.get(id);
        return categoria.getProdutos();
    }


    @PostMapping
    public Categoria create(@RequestBody Categoria categoria){

        return categoriaService.create(categoria);
    }


}
