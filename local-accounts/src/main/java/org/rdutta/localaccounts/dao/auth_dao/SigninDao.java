package org.rdutta.localaccounts.dao.auth_dao;

import org.rdutta.localaccounts.dto.auth_dto.LoginRequest;

public interface SigninDao {
    String login(LoginRequest loginForm);
}
