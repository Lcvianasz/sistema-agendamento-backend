package com.example.agendamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.agendamento.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
