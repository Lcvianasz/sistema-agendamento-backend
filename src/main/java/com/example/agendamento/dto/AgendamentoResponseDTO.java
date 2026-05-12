package com.example.agendamento.dto;

import com.example.agendamento.model.StatusAgendamento;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AgendamentoResponseDTO {
    private Long id;
    private LocalDateTime dataHora;

    private Long clienteId;
    private String clienteNome;

    private Long servicoId;
    private String servicoNome;

    private Double preco;

    private StatusAgendamento status;
}
