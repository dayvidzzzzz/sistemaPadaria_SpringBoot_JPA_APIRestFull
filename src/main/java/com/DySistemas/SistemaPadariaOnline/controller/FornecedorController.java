package com.DySistemas.SistemaPadariaOnline.controller;

import com.DySistemas.SistemaPadariaOnline.dto.FornecedorDto;
import com.DySistemas.SistemaPadariaOnline.model.Fornecedor;
import com.DySistemas.SistemaPadariaOnline.service.FornecedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/padaria/fornecedor ")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    public ResponseEntity<Fornecedor> salvarFornecedor(@RequestBody FornecedorDto fornecedorDto){
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(fornecedorService.salvar(fornecedorDto));
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Fornecedor> buscarFornecedor(@PathVariable int id){
        return ResponseEntity.
                status(HttpStatus.FOUND).
                body(fornecedorService.buscar(id));
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> excluirFornecedor(@PathVariable int id){
        fornecedorService.excluir(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

    @PatchMapping("/{Id}")
    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable int id,
                                             @RequestBody FornecedorDto fornecedorDto){
        return ResponseEntity.
                status(HttpStatus.UPGRADE_REQUIRED).
                body(fornecedorService.update(id, fornecedorDto));
    }
}
