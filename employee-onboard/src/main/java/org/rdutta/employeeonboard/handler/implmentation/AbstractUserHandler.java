package org.rdutta.employeeonboard.handler.implmentation;

import org.rdutta.employeeonboard.dto.UserRequest;
import org.rdutta.employeeonboard.handler.UserHandler;

public abstract class AbstractUserHandler implements UserHandler {
    protected UserHandler nextHandler;

    @Override
    public void setNext(UserHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected void passToNext(UserRequest request) throws Exception {
        if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }
}
