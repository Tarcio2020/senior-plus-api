package org.example.seniorplus.repository;

import org.example.seniorplus.domain.Cuidador;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CuidadorRepository extends MongoRepository<Cuidador, String> {
}
