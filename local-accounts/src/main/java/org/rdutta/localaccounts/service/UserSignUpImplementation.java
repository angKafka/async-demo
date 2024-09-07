package org.rdutta.localaccounts.service;

import jakarta.transaction.Transactional;
import org.rdutta.localaccounts.dao.auth_dao.Signup;
import org.rdutta.localaccounts.dto.auth_dto.UsersDto;
import org.rdutta.localaccounts.entities.sso.Users;
import org.rdutta.localaccounts.exceptions.UserExceptions;
import org.rdutta.localaccounts.repository.UserRepository;
import org.rdutta.localaccounts.utilities.features.mapper.UsersMapper;
import org.rdutta.localaccounts.utilities.features.messages.ValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserSignUpImplementation implements Signup {

    private final UserRepository userRepository;
    private final UsersMapper usersMapper;
    @Autowired
    public UserSignUpImplementation(UserRepository userRepository, UsersMapper usersMapper) {
        this.userRepository = userRepository;
        this.usersMapper = usersMapper;
    }

    @Transactional
    @Override
    public UUID saveUserRecord(UsersDto dto) {
        Users user = usersMapper.toUsers(dto);
        if (userRepository.existsByEmail(dto.email())) {
            throw new UserExceptions(ValidationMessages.EMAIL_ALREADY_EXISTS);
        }

        return  userRepository.save(user).getUserId();
    }
}
