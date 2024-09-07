package org.rdutta.employeeonboard.handler.validations.email;

import org.rdutta.employeeonboard.dto.UserRequest;
import org.rdutta.employeeonboard.exceptions.UserExceptions;
import org.rdutta.employeeonboard.handler.implmentation.AbstractUserHandler;
import org.rdutta.employeeonboard.messages.ErrorMessages;
import org.rdutta.employeeonboard.regex.PatternCheck;
import org.rdutta.employeeonboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailValidationHandler extends AbstractUserHandler {
    private final UserRepository userRepository;

    @Autowired
    public EmailValidationHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void handle(UserRequest request) throws Exception {
        if (!isValidEmail(request.getEmail())) {
            throw new UserExceptions(ErrorMessages.EMAIL_FORMAT_INVALID);
        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserExceptions(ErrorMessages.EMAIL_ALREADY_EXISTS);
        }
        passToNext(request);
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches(PatternCheck.EMAIL_REGEX);
    }
}
