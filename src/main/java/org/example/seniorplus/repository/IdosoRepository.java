package org.example.seniorplus.repository;

import org.example.seniorplus.domain.Idoso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IdosoRepository extends MongoRepository<Idoso, String> {

    // Encontrar idoso por nome (sem distinção de maiúsculas/minúsculas)
    List<Idoso> findByNomeIgnoreCase(String nome);

    // Encontrar idoso por email
    Optional<Idoso> findByEmail(String email);

    // Consultas personalizadas com @Query
    @Query("{'nome': {$regex: ?0, $options: 'i'}}")
    List<Idoso> searchByNome(String nome);

}