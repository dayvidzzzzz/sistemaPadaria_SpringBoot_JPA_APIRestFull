package com.DySistemas.SistemaPadariaOnline.controller;

import com.DySistemas.SistemaPadariaOnline.dto.ItemDto;
import com.DySistemas.SistemaPadariaOnline.model.Item;
import com.DySistemas.SistemaPadariaOnline.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/padaria/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Item> salvarItem(@RequestBody ItemDto itemDto){
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(itemService.salvar(itemDto));
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Item> buscarItem(@PathVariable int id){
        return ResponseEntity.
                status(HttpStatus.FOUND).
                body(itemService.buscar(id));
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> excluirItem(@PathVariable int id){
        itemService.excluir(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }
}
