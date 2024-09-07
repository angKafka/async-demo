package org.rdutta.employeeonboard.regex;

public interface PatternCheck {
    final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    final String PHONE_NUMBER_REGEX = "^(\\+?[0-9]{10})?$";

}
