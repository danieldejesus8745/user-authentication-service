package com.userauthentication.controllers;

import com.userauthentication.services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.userauthentication.utils.Constants.TOKEN;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/tokens")
public class TokenController {

    private final TokenService tokenService;

    @GetMapping
    public ResponseEntity<Boolean> validateToken(@PathVariable(TOKEN) String token) {
        return ResponseEntity.ok(tokenService.validateToken(token));
    }

}
