package org.example.seniorplus.repository;

import org.example.seniorplus.domain.Exercicio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExercicioRepository extends MongoRepository<Exercicio, String> {
}
