package org.una.sdm.aula09.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.sdm.aula09.domain.Item;
import org.una.sdm.aula09.services.interfaces.ItemServiceAPI;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemResource {

    @Autowired
    private ItemServiceAPI service;


    @GetMapping("/{id}")
    @ResponseBody  HttpEntity<Object> get(@PathVariable(name = "id") Long id) {

        Item Item = service.get(id);
        return ResponseEntity.ok(Item);
    }


    @GetMapping
    @ResponseBody HttpEntity<Object> findAll() {

        List<Item> Items = service.findAll();

        if(Items.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(Items);
    }


    @PostMapping
    @ResponseBody HttpEntity<Object> create(@RequestBody Item item){

        item = service.create(item);
        return ResponseEntity.ok(item);
    }


    @PutMapping("/{id}")
    @ResponseBody  HttpEntity<Object> update(@PathVariable(name = "id") Long id,
                                             @RequestBody Item item) {
        item.setId(id);
        service.update(item);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    @ResponseBody  HttpEntity<Object> remove(@PathVariable(name = "id") Long id) {

        service.remove(id);
        return ResponseEntity.noContent().build();
    }

}
