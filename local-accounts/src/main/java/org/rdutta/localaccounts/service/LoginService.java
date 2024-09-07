package org.rdutta.localaccounts.service;

import lombok.RequiredArgsConstructor;
import org.rdutta.localaccounts.dao.auth_dao.SigninDao;
import org.rdutta.localaccounts.dto.auth_dto.LoginRequest;
import org.rdutta.localaccounts.repository.UserRepository;
import org.rdutta.localaccounts.utilities.features.auth.Token;
import org.rdutta.localaccounts.utilities.features.messages.ErrorMessages;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements SigninDao {
    private final AuthenticationManager authenticationManager;
    private final Token jwtService;
    private final UsersService customerService;
    private final UserRepository userRepository;



    @Override
    public String login(LoginRequest loginForm) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginForm.email(),
                        loginForm.password()
                )
        );
        var user = userRepository.findByEmail(loginForm.email())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        if(jwtToken != null) {
            return jwtToken;
        }
        return ErrorMessages.USERNAME_PASSWORD_MISMATCH;
    }
}
