package com.example.agendamento.service;

import com.example.agendamento.model.Agendamento;
import com.example.agendamento.model.Cliente;
import com.example.agendamento.model.Servico;
import com.example.agendamento.repository.ClienteRepository;
import com.example.agendamento.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.agendamento.repository.AgendamentoRepository;
import com.example.agendamento.dto.AgendamentoRequestDTO;
import com.example.agendamento.dto.AgendamentoResponseDTO;
import com.example.agendamento.model.StatusAgendamento;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final ClienteRepository clienteRepository;
    private final ServicoRepository servicoRepository;

    public AgendamentoResponseDTO criar(AgendamentoRequestDTO dto){
        validarHorario(dto.getDataHora());

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Servico servico = servicoRepository.findById(dto.getServicoId())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        Agendamento agendamento = Agendamento.builder()
                .dataHora(dto.getDataHora())
                .cliente(cliente)
                .servico(servico)
                .status(StatusAgendamento.AGENDADO)
                .build();

        Agendamento salvo = agendamentoRepository.save(agendamento);

        return toResponseDTO(salvo);
    }

    private void validarHorario(java.time.LocalDateTime dataHora) {
        boolean existe = agendamentoRepository.existsByDataHora(dataHora);

        if (existe) {
            throw new RuntimeException("Já existe um agendamento para esse horário");
        }
    }


    public List<AgendamentoResponseDTO> listar(){
        return agendamentoRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    private AgendamentoResponseDTO toResponseDTO(Agendamento agendamento) {
        return AgendamentoResponseDTO.builder()
                .id(agendamento.getId())
                .dataHora(agendamento.getDataHora())
                .clienteId(agendamento.getCliente().getId())
                .clienteNome(agendamento.getCliente().getNome())
                .servicoId(agendamento.getServico().getId())
                .servicoNome(agendamento.getServico().getNome())
                .preco(agendamento.getServico().getPreco())
                .status(agendamento.getStatus())
                .build();
    }
}
