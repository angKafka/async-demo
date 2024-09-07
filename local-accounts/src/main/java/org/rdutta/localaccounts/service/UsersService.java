package org.rdutta.localaccounts.service;

import org.rdutta.localaccounts.dao.auth_dao.Login;
import org.rdutta.localaccounts.entities.sso.Users;
import org.rdutta.localaccounts.repository.UserRepository;
import org.rdutta.localaccounts.utilities.features.messages.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService implements Login {

    private final UserRepository userRepository;

    @Autowired
    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> users = userRepository.findByEmail(email);
        if (users.isPresent()) {
            Users usersObj = users.get();
            return User.builder()
                    .username(usersObj.getUsername())
                    .password(usersObj.getPassword())
                    .build();
        } else {
            throw new UsernameNotFoundException(ErrorMessages.USERNAME_NOT_FOUND);
        }
    }
}