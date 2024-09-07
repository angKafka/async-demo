package org.rdutta.localaccounts.dao.auth_dao;

import org.rdutta.localaccounts.dto.auth_dto.UsersDto;

import java.util.UUID;

public interface Signup {
    UUID saveUserRecord(UsersDto dto);
}
