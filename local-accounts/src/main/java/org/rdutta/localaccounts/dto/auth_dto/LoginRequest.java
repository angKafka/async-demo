package org.rdutta.localaccounts.dto.auth_dto;

public record LoginRequest(
        String email,
        String password
) {
}
