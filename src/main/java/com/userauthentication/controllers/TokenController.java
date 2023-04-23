package com.userauthentication.controllers;

import com.userauthentication.services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/tokens")
public class TokenController {

    private final TokenService tokenService;

    @GetMapping
    public ResponseEntity<Boolean> validateToken(@RequestHeader(AUTHORIZATION) String token) {
        return ResponseEntity.ok(tokenService.validateToken(token));
    }

}
