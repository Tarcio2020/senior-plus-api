package org.example.seniorplus.repository;

import org.example.seniorplus.domain.Imagem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ImagemRepository extends MongoRepository<Imagem, Long> {
    List<Imagem> findAllById(String cpf);
}
