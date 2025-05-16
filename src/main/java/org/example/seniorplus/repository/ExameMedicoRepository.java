package org.example.seniorplus.repository;

import org.example.seniorplus.domain.ExameMedico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExameMedicoRepository extends MongoRepository<ExameMedico, String> {
}
