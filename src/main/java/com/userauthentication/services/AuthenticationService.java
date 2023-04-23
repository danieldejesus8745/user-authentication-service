package com.userauthentication.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.userauthentication.utils.Constants.AUTHENTICATION;
import static com.userauthentication.utils.Constants.USER_AUTHENTICATION_ENDPOINT;
import static com.userauthentication.utils.Messages.MESSAGE_1;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final TokenService tokenService;

    public String authenticateUser(String credentials) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(USER_AUTHENTICATION_ENDPOINT))
                .header(AUTHENTICATION, credentials)
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return handlingResponse(response);
        } catch (InterruptedException | IOException exception) {
            log.error(exception.getMessage());
            throw new IllegalStateException(MESSAGE_1.getMessage());
        }
    }

    private String handlingResponse(HttpResponse<String> response) {
        if (response.statusCode() == 200) {
            return tokenService.createToken(response.body());
        }

        return response.body();
    }

}
