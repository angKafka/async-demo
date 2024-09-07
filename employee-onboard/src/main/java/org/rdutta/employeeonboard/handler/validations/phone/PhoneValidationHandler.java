package org.rdutta.employeeonboard.handler.validations.phone;

import org.rdutta.employeeonboard.dto.UserRequest;
import org.rdutta.employeeonboard.exceptions.UserExceptions;
import org.rdutta.employeeonboard.handler.implmentation.AbstractUserHandler;
import org.rdutta.employeeonboard.messages.ErrorMessages;
import org.rdutta.employeeonboard.regex.PatternCheck;
import org.springframework.stereotype.Component;

@Component
public class PhoneValidationHandler extends AbstractUserHandler {
    @Override
    public void handle(UserRequest request) throws Exception {
        if (request.getPhone().matches(PatternCheck.PHONE_NUMBER_REGEX)) {
            throw new UserExceptions(ErrorMessages.PHONE_NUMBER_INVALID);
        }
        passToNext(request);
    }
}

