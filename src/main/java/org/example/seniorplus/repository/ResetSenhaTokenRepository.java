package org.example.seniorplus.repository;


import org.example.seniorplus.domain.ResetSenhaToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResetSenhaTokenRepository extends MongoRepository<ResetSenhaToken, String> {
    Optional<ResetSenhaToken> findByToken(String token);
    void deleteByUsuarioId(String usuarioId);
} 