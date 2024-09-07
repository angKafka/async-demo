package org.rdutta.employeeonboard.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.rdutta.employeeonboard.dto.UserRequest;
import org.rdutta.employeeonboard.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<UUID> createUser(@RequestBody @Valid UserRequest request) throws Exception {
        UUID userId = userService.createUser(request);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }
}
