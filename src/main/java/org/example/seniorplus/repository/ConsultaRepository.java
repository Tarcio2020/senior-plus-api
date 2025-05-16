package org.example.seniorplus.repository;

import org.example.seniorplus.domain.Consulta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsultaRepository extends MongoRepository<Consulta, String> {
}
