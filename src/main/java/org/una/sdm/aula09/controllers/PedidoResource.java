package org.una.sdm.aula09.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.sdm.aula09.domain.Pedido;
import org.una.sdm.aula09.services.interfaces.PedidoServiceAPI;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoServiceAPI service;


    @GetMapping("/{id}")
    @ResponseBody  HttpEntity<Object> get(@PathVariable(name = "id") Long id) {

        Pedido pedido = service.get(id);

        pedido.add(linkTo(methodOn(PedidoResource.class).getItems(pedido.getId()))
                .withRel("items")
        );

        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/{id}/items")
    @ResponseBody  HttpEntity<Object> getItems(@PathVariable(name = "id") Long id) {

        Pedido pedido = service.get(id);
        return ResponseEntity.ok(pedido.getItems());
    }


    @GetMapping
    @ResponseBody HttpEntity<Object> findAll() {

        List<Pedido> pedidos = service.findAll();

        if(pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pedidos);
    }


    @PostMapping
    @ResponseBody HttpEntity<Object> create(@RequestBody Pedido pedido){

        pedido = service.create(pedido);
        return ResponseEntity.ok(pedido);
    }


    @PutMapping("/{id}")
    @ResponseBody  HttpEntity<Object> update(@PathVariable(name = "id") Long id,
                                             @RequestBody Pedido pedido) {
        pedido.setId(id);
        service.update(pedido);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    @ResponseBody  HttpEntity<Object> remove(@PathVariable(name = "id") Long id) {

        service.remove(id);
        return ResponseEntity.noContent().build();
    }

}
