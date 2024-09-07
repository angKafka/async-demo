package org.rdutta.localaccounts.controller;

import jakarta.validation.Valid;
import org.rdutta.localaccounts.dto.auth_dto.LoginRequest;
import org.rdutta.localaccounts.dto.auth_dto.UsersDto;
import org.rdutta.localaccounts.service.LoginService;
import org.rdutta.localaccounts.service.UserSignUpImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthRestController {

    private final UserSignUpImplementation signUpImplementation;
    private final LoginService loginService;
    @Autowired
    public AuthRestController(UserSignUpImplementation signUpImplementation,LoginService loginService) {
        this.signUpImplementation = signUpImplementation;
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateAndGetToken(@RequestBody @Valid LoginRequest loginForm){
        return new ResponseEntity<>(loginService.login(loginForm), HttpStatus.OK);
    }

    @PostMapping(path = "/signup")
    public ResponseEntity<UUID> signup(@RequestBody @Valid UsersDto dto) {
        UUID userId = signUpImplementation.saveUserRecord(dto);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }
}