package org.rdutta.employeeonboard.mapper;

import org.rdutta.employeeonboard.dto.UserRequest;
import org.rdutta.employeeonboard.model.User;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    public User toUser(UserRequest request) {
        return User.builder()
                .firstname(request.getFirstname())
                .surname(request.getSurname())
                .username(request.getUsername())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();
    }
}
