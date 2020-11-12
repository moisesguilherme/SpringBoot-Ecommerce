package org.una.sdm.aula09.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.sdm.aula09.domain.Banda;
import org.una.sdm.aula09.domain.Categoria;
import org.una.sdm.aula09.domain.Produto;
import org.una.sdm.aula09.services.interfaces.BandaServiceAPI;
import org.una.sdm.aula09.services.interfaces.CategoriaServiceAPI;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/bandas")
public class BandaResource {

    @Autowired
    private BandaServiceAPI bandaService;

    @GetMapping
    public @ResponseBody
    HttpEntity<List<Banda>> findAll() {

        List<Banda> bandas = bandaService.findAll();

        if(bandas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(bandas);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Banda> get(@PathVariable(name = "id") Long id) {

        Banda banda = bandaService.get(id);
        return ResponseEntity.ok(banda);
    }

    @PostMapping
    public @ResponseBody
    HttpEntity<Banda> create(@RequestBody Banda banda) {

        banda = bandaService.create(banda);
        return ResponseEntity.ok(banda);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Banda> update(@PathVariable(name = "id") Long id,
            @RequestBody Banda banda) {

        banda.setId(id);
        bandaService.update(banda);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Banda> remove(@PathVariable(name = "id") Long id) {

        bandaService.remove(id);
        return ResponseEntity.ok().build();
    }
}
