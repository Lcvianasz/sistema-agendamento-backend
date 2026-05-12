package com.example.agendamento.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendamentoRequestDTO {
    @NotNull(message = "A data e hora são obrigatórias")
    @Future(message = "A data deve ser no futuro")
    private LocalDateTime dataHora;

    @NotNull(message = "O clienteId é obrigatório")
    private Long clienteId;

    @NotNull(message = "O servicoId é obrigatório")
    private Long servicoId;
}
