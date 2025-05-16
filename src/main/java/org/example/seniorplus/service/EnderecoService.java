package org.example.seniorplus.service;

import org.example.seniorplus.domain.Endereco;
import org.example.seniorplus.repository.EnderecoRepository;
import org.example.seniorplus.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> getAllEndereco() {
        return enderecoRepository.findAll();
    }
    public Endereco getEnderecoById(String cpf) {
        return enderecoRepository.findById(cpf)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado com CPF: " + cpf));
    }

    public Endereco saveEndereco(Endereco obj) {
        return enderecoRepository.save(obj);
    }

    public void deleteEndereco(String cpf) {
        enderecoRepository.deleteById(cpf);
    }
}
