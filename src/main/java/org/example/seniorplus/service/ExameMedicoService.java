package org.example.seniorplus.service;

import org.example.seniorplus.domain.ExameMedico;
import org.example.seniorplus.domain.Exercicio;
import org.example.seniorplus.repository.ExameMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameMedicoService {

    @Autowired
    private ExameMedicoRepository exameMedicoRepository;

    // Método para listar todos os medicamentos
    public List<ExameMedico> listarTodos() {
        return exameMedicoRepository.findAll();
    }

    // Método para buscar um medicamento por CPF
    public ExameMedico buscarPorCpf(String cpf) {
        return exameMedicoRepository.findById(cpf)
                .orElseThrow(() -> new RuntimeException("Medicamento não encontrado com o CPF: " + cpf));
    }

    // Método para salvar um novo medicamento
    public ExameMedico salvar(ExameMedico exameMedico) {
        try {
            return exameMedicoRepository.save(exameMedico);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o medicamento: " + e.getMessage());
        }
    }

    // Método para atualizar um medicamento existente
    public ExameMedico atualizar(String cpf, Exercicio exercicioAtualizado) {
        ExameMedico exameMedico = buscarPorCpf(cpf); // Reutiliza o método buscarPorCpf para verificar se existe
        try {


            // Salva as alterações no repositório
            return exameMedicoRepository.save(exameMedico);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar o medicamento com CPF: " + cpf + ". " + e.getMessage());
        }
    }

    public void deletar(String cpf) {
        ExameMedico exameMedico = buscarPorCpf(cpf); // Reutiliza o método buscarPorCpf para verificar se existe
        try {
            exameMedicoRepository.delete(exameMedico);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar o medicamento com CPF: " + cpf + ". " + e.getMessage());
        }
    }

}
