package org.example.seniorplus.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.example.seniorplus.domain.Usuario;
import org.example.seniorplus.dto.AuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final org.example.seniorplus.service.AuthenticationService authenticationService;

    @Operation(summary = "Autenticar usuário e obter token JWT", security = @SecurityRequirement(name = "BearerAuth")) // <- ignora JWT
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Usuario request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @Operation(summary = "Autenticar usuário e obter token JWT", security = @SecurityRequirement(name = "BearerAuth")) // <- ignora JWT
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody Map<String, String> request) {
        return ResponseEntity.ok(authenticationService.authenticate(
                request.get("email"),
                request.get("senha")
        ));
    }
} 