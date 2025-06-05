package com.DySistemas.SistemaPadariaOnline.controller;

import com.DySistemas.SistemaPadariaOnline.dto.ClienteDto;
import com.DySistemas.SistemaPadariaOnline.model.Cliente;
import com.DySistemas.SistemaPadariaOnline.service.ClienteServise;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/padaria/cliente")
public class ClienteController {
    private final ClienteServise clienteService;

    public ClienteController(ClienteServise clienteServise) {
        this.clienteService = clienteServise;
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@Valid @RequestBody ClienteDto clienteDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteService.salvar(clienteDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable int id) {
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(
            @PathVariable int id,
            @Valid @RequestBody ClienteDto clienteDto) {
        return ResponseEntity.ok(clienteService.updateCliente(id, clienteDto));
    }
}
