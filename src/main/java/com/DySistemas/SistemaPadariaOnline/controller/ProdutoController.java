package com.DySistemas.SistemaPadariaOnline.controller;

import com.DySistemas.SistemaPadariaOnline.dto.ProdutoDto;
import com.DySistemas.SistemaPadariaOnline.model.Produto;
import com.DySistemas.SistemaPadariaOnline.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/padaria/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody ProdutoDto produtoDto){
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(produtoService.
                        salvar(produtoDto));
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable int id){
        return ResponseEntity.
                status(HttpStatus.FOUND).
                body(produtoService.buscar(id));
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable int id){
        produtoService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{Id}")
    public ResponseEntity<Produto> upgradeProduto(@PathVariable int id,
                                           @RequestBody ProdutoDto produtoDto){
        return ResponseEntity.
                status(HttpStatus.UPGRADE_REQUIRED).
                body(produtoService.update(id, produtoDto));
    }
}
