package org.example.seniorplus.service;

import org.example.seniorplus.domain.Idoso;
import org.example.seniorplus.repository.IdosoRepository;
import org.example.seniorplus.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdosoService {

    @Autowired
    private IdosoRepository repository;

    public List<Idoso> buscarTodos() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar lista de idosos: " + e.getMessage());
        }
    }

    public Idoso buscarPorCpf(String cpf) {
        try {
            Optional<Idoso> obj = repository.findById(cpf);
            return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado com CPF: " + cpf));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar idoso com CPF: " + cpf + " - " + e.getMessage());
        }
    }

    public Idoso criar(Idoso obj) {
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro de integridade ao salvar o idoso: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o idoso: " + e.getMessage());
        }
    }

    public Idoso atualizar(String cpf, Idoso novoIdoso) {
        try {
            Idoso existente = buscarPorCpf(cpf);

            existente.setNome(novoIdoso.getNome());
            existente.setRg(novoIdoso.getRg());
            existente.setEmail(novoIdoso.getEmail());
            existente.setDataNascimento(novoIdoso.getDataNascimento());
            existente.setTelefone(novoIdoso.getTelefone());
            existente.setPeso(novoIdoso.getPeso());
            existente.setAltura(novoIdoso.getAltura());
            existente.setTipoSanguineo(novoIdoso.getTipoSanguineo());
            existente.setObservacao(novoIdoso.getObservacao());
            existente.setEnderecos(novoIdoso.getEnderecos());

            return repository.save(existente);
        } catch (ObjectNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar idoso com CPF: " + cpf + " - " + e.getMessage());
        }
    }


    public void deletar(String cpf) {
        try {
            buscarPorCpf(cpf); // garante que existe
            repository.deleteById(cpf);
        } catch (ObjectNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar idoso com CPF: " + cpf + " - " + e.getMessage());
        }
    }
}
