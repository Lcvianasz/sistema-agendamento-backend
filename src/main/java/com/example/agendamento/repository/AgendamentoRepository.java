package com.example.agendamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.agendamento.model.Agendamento;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    boolean existsByDataHora(LocalDateTime dataHora);
}
