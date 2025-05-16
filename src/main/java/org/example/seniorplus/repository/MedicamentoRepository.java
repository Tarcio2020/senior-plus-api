package org.example.seniorplus.repository;

import org.example.seniorplus.domain.Cuidador;
import org.example.seniorplus.domain.Medicamento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicamentoRepository extends MongoRepository<Medicamento, String> {
}
