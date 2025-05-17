package org.example.seniorplus.service;

import lombok.RequiredArgsConstructor;
import org.example.seniorplus.domain.Role;
import org.example.seniorplus.domain.Usuario;
import org.example.seniorplus.dto.AuthenticationResponse;
import org.example.seniorplus.exception.AuthenticationException;
import org.example.seniorplus.repository.UsuarioRepository;
import org.example.seniorplus.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(Usuario request) {
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new AuthenticationException("Email já cadastrado");
        }

        var usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setCpf(request.getCpf());
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        usuario.setRole(Role.ROLE_USER);

        usuarioRepository.save(usuario);
        return jwtService.generateToken(usuario);
    }

    public AuthenticationResponse authenticate(String email, String senha) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, senha)
            );
            var usuario = usuarioRepository.findByEmail(email)
                    .orElseThrow(() -> new AuthenticationException("Usuário não encontrado"));
            return jwtService.generateToken(usuario);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Email ou senha inválidos");
        }
    }
}