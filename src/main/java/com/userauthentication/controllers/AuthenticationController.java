package com.userauthentication.controllers;

import com.userauthentication.services.AuthenticationService;
import com.userauthentication.services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.userauthentication.utils.Constants.AUTHENTICATION;
import static com.userauthentication.utils.Messages.MESSAGE_2;
import static com.userauthentication.utils.Messages.MESSAGE_3;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> authenticateUser(@RequestHeader(AUTHENTICATION) String credentials) {
        String response = authenticationService.authenticateUser(credentials);

        if (response.equals(MESSAGE_2.getMessage())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MESSAGE_2.getMessage());
        }

        if (response.equals(MESSAGE_3.getMessage())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(MESSAGE_3.getMessage());
        }

        return ResponseEntity.ok(response);
    }

}
