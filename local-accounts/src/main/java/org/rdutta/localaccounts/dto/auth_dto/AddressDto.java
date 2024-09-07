package org.rdutta.localaccounts.dto.auth_dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.rdutta.localaccounts.utilities.features.messages.ErrorMessages;
import org.rdutta.localaccounts.utilities.features.messages.ValidationMessages;
import org.rdutta.localaccounts.utilities.features.regex.Regex;

public record AddressDto(
        @NotNull(message = ErrorMessages.STREET_EMPTY)
        String street,
        @NotNull(message = ErrorMessages.CITY_EMPTY)
        String city,
        @NotNull(message = ErrorMessages.STATE_EMPTY)
        String state,
        @NotNull(message = ErrorMessages.ZIP_EMPTY)
        @Pattern(regexp = Regex.ZIPCODE_REGEX, message = ValidationMessages.PINCODE_IS_INVALID)
        String zipcode,
        @NotNull(message = ErrorMessages.COUNTRY_EMPTY)
        String country
) {
}
