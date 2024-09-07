package org.rdutta.localaccounts.utilities.features.regex;

public interface Regex {
    final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    final String PHONE_REGEX = "^(\\\\+91|91|0)?[6-9]\\\\d{9}$";
    final String ZIPCODE_REGEX = "^[1-9]{1}[0-9]{2}\\\\s{0,1}[0-9]{3}$";
}
