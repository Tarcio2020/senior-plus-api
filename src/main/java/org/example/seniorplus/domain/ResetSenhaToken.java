package org.example.seniorplus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "reset_senha_tokens")
public class ResetSenhaToken {

    @Id
    private String id;

    private String token;


    private Usuario usuario;

    private LocalDateTime dataExpiracao;

    private boolean utilizado;

    public static ResetSenhaToken gerarToken(Usuario usuario) {
        ResetSenhaToken resetToken = new ResetSenhaToken();
        resetToken.setToken(UUID.randomUUID().toString());
        resetToken.setUsuario(usuario);
        resetToken.setDataExpiracao(LocalDateTime.now().plusHours(24));
        resetToken.setUtilizado(false);
        return resetToken;
    }

    public boolean isExpirado() {
        return LocalDateTime.now().isAfter(dataExpiracao);
    }
} 