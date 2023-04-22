package com.userauthentication.controllers;

import com.userauthentication.services.AuthenticationService;
import com.userauthentication.services.TokenService;
import com.userauthentication.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

import static com.userauthentication.utils.Constants.AUTHENTICATION;
import static com.userauthentication.utils.Messages.MESSAGE_2;
import static com.userauthentication.utils.Messages.MESSAGE_3;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

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
