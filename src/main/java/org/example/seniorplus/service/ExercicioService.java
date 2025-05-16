package org.example.seniorplus.service;

import org.example.seniorplus.domain.Exercicio;
import org.example.seniorplus.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {

        @Autowired
        private ExercicioRepository exercicioRepository;

        // Método para listar todos os medicamentos
        public List<Exercicio> listarTodos() {
            return exercicioRepository.findAll();
        }

        // Método para buscar um medicamento por CPF
        public Exercicio buscarPorCpf(String cpf) {
            return exercicioRepository.findById(cpf)
                    .orElseThrow(() -> new RuntimeException("Medicamento não encontrado com o CPF: " + cpf));
        }

        // Método para salvar um novo medicamento
        public Exercicio salvar(Exercicio exercicio) {
            try {
                return exercicioRepository.save(exercicio);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao salvar o medicamento: " + e.getMessage());
            }
        }

        // Método para atualizar um medicamento existente
        public Exercicio atualizar(String cpf, Exercicio exercicioAtualizado) {
            Exercicio exercicio = buscarPorCpf(cpf); // Reutiliza o método buscarPorCpf para verificar se existe
            try {


                // Salva as alterações no repositório
                return exercicioRepository.save(exercicio);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao atualizar o medicamento com CPF: " + cpf + ". " + e.getMessage());
            }
        }

        public void deletar(String cpf) {
            Exercicio exercicio = buscarPorCpf(cpf); // Reutiliza o método buscarPorCpf para verificar se existe
            try {
                exercicioRepository.delete(exercicio);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao deletar o medicamento com CPF: " + cpf + ". " + e.getMessage());
            }
        }
    }

