package org.example.seniorplus.repository;

import org.example.seniorplus.domain.Dieta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DietaRepository extends MongoRepository<Dieta, String> {
}
