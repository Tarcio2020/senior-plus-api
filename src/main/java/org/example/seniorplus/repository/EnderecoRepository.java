package org.example.seniorplus.repository;

import org.example.seniorplus.domain.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnderecoRepository extends MongoRepository<Endereco, String> {
}
