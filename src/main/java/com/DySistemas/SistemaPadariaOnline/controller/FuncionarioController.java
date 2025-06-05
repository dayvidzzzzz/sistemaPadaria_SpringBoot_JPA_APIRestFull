package com.DySistemas.SistemaPadariaOnline.controller;

import com.DySistemas.SistemaPadariaOnline.dto.FuncionarioDto;
import com.DySistemas.SistemaPadariaOnline.model.Funcionario;
import com.DySistemas.SistemaPadariaOnline.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/padaria/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<Funcionario> criarFuncionario(@Valid @RequestBody FuncionarioDto funcionarioDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(funcionarioService.salvar(funcionarioDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(funcionarioService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFuncionario(@PathVariable int id) {
        funcionarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(
            @PathVariable int id,
            @Valid @RequestBody FuncionarioDto funcionarioDto) {
        return ResponseEntity.ok(funcionarioService.updateFuncionario(id, funcionarioDto));
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        return ResponseEntity.ok(funcionarioService.listarFuncionarios());
    }
}
