package com.DySistemas.SistemaPadariaOnline.controller;

import com.DySistemas.SistemaPadariaOnline.dto.EncomendaDto;
import com.DySistemas.SistemaPadariaOnline.model.Encomenda;
import com.DySistemas.SistemaPadariaOnline.service.EmcomendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/padaria/encomenda")
public class EncomendaController {

    private final EmcomendaService emcomendaService;

    public EncomendaController(EmcomendaService emcomendaService) {
        this.emcomendaService = emcomendaService;
    }

    @PostMapping
    public ResponseEntity<Encomenda> salvarEncomenda(@RequestBody EncomendaDto encomendaDto){
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(emcomendaService.
                        salvar(encomendaDto));
    }

    @GetMapping
    public ResponseEntity<List<Encomenda>> listarEncomenda(){
        return ResponseEntity.ok(emcomendaService.listaEncomendas());
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Encomenda> buscarEncomenda(@PathVariable int id){
        return ResponseEntity.
                status(HttpStatus.FOUND)
                .body(emcomendaService.buscar(id));
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> excluirEncomenda(@PathVariable int id){
        emcomendaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
