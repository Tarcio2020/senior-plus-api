package org.example.seniorplus.repository;

import org.example.seniorplus.domain.Idoso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IdosoRepository extends MongoRepository<Idoso, String> {
}
