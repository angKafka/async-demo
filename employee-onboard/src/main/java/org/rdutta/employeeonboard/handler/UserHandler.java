package org.rdutta.employeeonboard.handler;

import org.rdutta.employeeonboard.dto.UserRequest;

public interface UserHandler {
    void handle(UserRequest request) throws Exception;
    void setNext(UserHandler nextHandler);
}
