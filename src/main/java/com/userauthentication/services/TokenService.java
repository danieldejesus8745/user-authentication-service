package com.userauthentication.services;

import com.userauthentication.entities.Token;
import com.userauthentication.repositories.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

    public String createToken(String body) {
        Token token = new Token();
        token.setToken(UUID.randomUUID());
        token.setEmail(body);
        token.setExpiration(System.currentTimeMillis() + 1200000);
        return tokenRepository.save(token).getToken().toString();
    }

}
