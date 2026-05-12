package com.example.agendamento.service;

import com.example.agendamento.model.Servico;
import com.example.agendamento.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository repository;

    public Servico criar(Servico servico) {
        return repository.save(servico);
    }

    public List<Servico> listar() {
        return repository.findAll();
    }

    public Servico buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
    }

    public Servico atualizar(Long id, Servico servico) {
        Servico existente = buscarPorId(id);

        existente.setNome(servico.getNome());
        existente.setPreco(servico.getPreco());
        existente.setDuracaoMinutos(servico.getDuracaoMinutos());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        Servico servico = buscarPorId(id);
        repository.delete(servico);
    }
}
