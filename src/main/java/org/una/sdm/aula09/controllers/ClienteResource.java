package org.una.sdm.aula09.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.sdm.aula09.domain.Cliente;
import org.una.sdm.aula09.services.interfaces.ClienteServiceAPI;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteServiceAPI service;


    @GetMapping("/{id}")
    @ResponseBody  HttpEntity<Object> get(@PathVariable(name = "id") Long id) {

        Cliente cliente = service.get(id);
        return ResponseEntity.ok(cliente);
    }


    @GetMapping
    @ResponseBody HttpEntity<Object> findAll() {

        List<Cliente> clientes = service.findAll();

        if(clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(clientes);
    }


    @PostMapping
    @ResponseBody HttpEntity<Object> create(@RequestBody Cliente cliente){

        cliente = service.create(cliente);
        return ResponseEntity.ok(cliente);
    }


    @PutMapping("/{id}")
    @ResponseBody  HttpEntity<Object> update(@PathVariable(name = "id") Long id,
                                             @RequestBody Cliente cliente) {
        cliente.setId(id);
        service.update(cliente);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    @ResponseBody  HttpEntity<Object> remove(@PathVariable(name = "id") Long id) {

        service.remove(id);
        return ResponseEntity.noContent().build();
    }

}
