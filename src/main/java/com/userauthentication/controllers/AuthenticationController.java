package com.userauthentication.controllers;

import com.userauthentication.services.AuthenticationService;
import com.userauthentication.services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.userauthentication.utils.Constants.AUTHENTICATION;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<String> authenticateUser(@RequestHeader(AUTHENTICATION) String credentials) {
        authenticationService.authenticateUser(credentials);
        return ResponseEntity.ok("");
    }

}
