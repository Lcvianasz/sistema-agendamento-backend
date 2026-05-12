package com.example.agendamento.controller;

import com.example.agendamento.model.Servico;
import com.example.agendamento.service.ServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoService service;

    // ✅ Criar
    @PostMapping
    public ResponseEntity<Servico> criar(@RequestBody Servico servico) {
        return ResponseEntity.ok(service.criar(servico));
    }

    // ✅ Listar
    @GetMapping
    public ResponseEntity<List<Servico>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // ✅ Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // ✅ Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(@PathVariable Long id, @RequestBody Servico servico) {
        return ResponseEntity.ok(service.atualizar(id, servico));
    }

    // ✅ Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
