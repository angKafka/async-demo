package org.rdutta.employeeonboard.service;

import org.rdutta.employeeonboard.dao.Register;
import org.rdutta.employeeonboard.dto.UserRequest;
import org.rdutta.employeeonboard.handler.validations.email.EmailValidationHandler;
import org.rdutta.employeeonboard.handler.validations.phone.PhoneValidationHandler;
import org.rdutta.employeeonboard.handler.validations.username.UsernameValidationHandler;
import org.rdutta.employeeonboard.mapper.Mapper;
import org.rdutta.employeeonboard.model.User;
import org.rdutta.employeeonboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements Register {

    private final UserRepository userRepository;
    private final UsernameValidationHandler usernameValidationHandler;
    private final EmailValidationHandler emailValidationHandler;
    private final PhoneValidationHandler phoneValidationHandler;
    private final Mapper mapper;

    @Autowired
    public UserService(UserRepository userRepository,
                       UsernameValidationHandler usernameValidationHandler,
                       EmailValidationHandler emailValidationHandler,
                       PhoneValidationHandler phoneValidationHandler,
                       Mapper mapper) {
        this.userRepository = userRepository;
        this.usernameValidationHandler = usernameValidationHandler;
        this.emailValidationHandler = emailValidationHandler;
        this.phoneValidationHandler = phoneValidationHandler;
        this.mapper = mapper;
    }


    @Override
    public UUID createUser(UserRequest userRequest) throws Exception {
        // Setting up the chain
        usernameValidationHandler.setNext(emailValidationHandler);
        emailValidationHandler.setNext(phoneValidationHandler);

        // Starting the chain
        usernameValidationHandler.handle(userRequest);

        // If all handlers pass, create and save the user
        User user = mapper.toUser(userRequest);

        return userRepository.save(user).getUser_id();
    }
}

