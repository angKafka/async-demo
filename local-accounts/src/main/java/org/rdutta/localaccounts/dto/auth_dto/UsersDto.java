package org.rdutta.localaccounts.dto.auth_dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.rdutta.localaccounts.utilities.features.messages.ErrorMessages;
import org.rdutta.localaccounts.utilities.features.messages.ValidationMessages;

import static org.rdutta.localaccounts.utilities.features.regex.Regex.*;

import java.time.LocalDateTime;
import java.util.List;

public record UsersDto(
        @NotNull(message = ErrorMessages.FIRSTNAME_EMPTY)
        String firstName,
        @NotNull(message = ErrorMessages.LASTNAME_EMPTY)
        String lastName,
        @NotNull(message = ErrorMessages.USERNAME_EMPTY)
        String username,
        @NotNull(message = ErrorMessages.PASSWORD_EMPTY)
        String password,
        @NotNull(message = ErrorMessages.EMAIL_EMPTY)
        @Pattern(regexp = EMAIL_REGEX, message = ValidationMessages.EMAIL_IS_NOT_VALID)
        String email,
        @NotNull(message = ErrorMessages.PHONE_EMPTY)
        @Pattern(regexp = PHONE_REGEX, message = ValidationMessages.PHONE_NUMBER_IS_NOT_VALID)
        String phone,
        String role,
        List<AddressDto> addresses,
        LocalDateTime dob,
        LocalDateTime created_At
) {
}
