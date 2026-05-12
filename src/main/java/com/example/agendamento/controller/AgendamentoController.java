package com.example.agendamento.controller;

import com.example.agendamento.model.Agendamento;
import com.example.agendamento.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.agendamento.dto.AgendamentoRequestDTO;
import com.example.agendamento.dto.AgendamentoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
@Tag(name = "Agendamentos", description = "Gerenciamento de agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    @PostMapping
    @Operation(summary = "Criar um novo agendamento")
    public ResponseEntity<AgendamentoResponseDTO> criar(@RequestBody @Valid AgendamentoRequestDTO dto){
        return  ResponseEntity.ok(service.criar(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos os agendamentos")
    public ResponseEntity<List<AgendamentoResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }
}
