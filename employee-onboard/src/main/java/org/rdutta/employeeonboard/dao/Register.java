package org.rdutta.employeeonboard.dao;

import org.rdutta.employeeonboard.dto.UserRequest;

import java.util.UUID;

public interface Register {
    UUID createUser(UserRequest userRequest) throws Exception;
}
