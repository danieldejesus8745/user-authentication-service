package com.userauthentication.services;

import com.userauthentication.entities.Token;
import com.userauthentication.repositories.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

    public String createToken(String userEmail) {
        Token token = new Token();
        token.setToken(UUID.randomUUID());
        token.setEmail(userEmail);
        token.setExpiration(System.currentTimeMillis() + 1200000);
        return tokenRepository.save(token).getToken().toString();
    }

    public boolean validateToken(String token) {
        Token tokenFound = tokenRepository.findByToken(UUID.fromString(token)).orElse(null);

        if (Objects.isNull(tokenFound)) return false;

        if (!isValidToken(tokenFound.getExpiration())) tokenRepository.deleteById(tokenFound.getId());

        return isValidToken(tokenFound.getExpiration());
    }

    private boolean isValidToken(long expiration) {
        return System.currentTimeMillis() < expiration;
    }

}
