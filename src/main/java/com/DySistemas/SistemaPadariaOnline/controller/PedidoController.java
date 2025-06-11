package com.DySistemas.SistemaPadariaOnline.controller;

import com.DySistemas.SistemaPadariaOnline.dto.PedidoDto;
import com.DySistemas.SistemaPadariaOnline.model.Pedido;
import com.DySistemas.SistemaPadariaOnline.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/padaria/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> salvarPedido(@RequestBody PedidoDto pedidoDto){
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(pedidoService.
                        salvar(pedidoDto));
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> excluirPedido(@PathVariable int id){
        pedidoService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Pedido> buscarPedido(@PathVariable int id){
        return ResponseEntity.
                status(HttpStatus.FOUND).
                body(pedidoService.buscar(id));
    }
}
