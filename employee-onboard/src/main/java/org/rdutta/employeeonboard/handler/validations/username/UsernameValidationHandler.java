package org.rdutta.employeeonboard.handler.validations.username;

import org.rdutta.employeeonboard.dto.UserRequest;
import org.rdutta.employeeonboard.exceptions.UserExceptions;
import org.rdutta.employeeonboard.handler.implmentation.AbstractUserHandler;
import org.rdutta.employeeonboard.messages.ErrorMessages;
import org.rdutta.employeeonboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsernameValidationHandler extends AbstractUserHandler {

    private final UserRepository userRepository;

    @Autowired
    public UsernameValidationHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void handle(UserRequest request) throws Exception {
        if(userRepository.findByUsername(request.getUsername()).isPresent()){
            throw new UserExceptions(ErrorMessages.USERNAME_ALREADY_EXISTS);
        }

        passToNext(request);
    }
}
