package org.rdutta.crm.custom_exceptions;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound() {
        super();
    }

    public EmployeeNotFound(String message) {
        super(message);
    }

    public EmployeeNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFound(Throwable cause) {
        super(cause);
    }

    protected EmployeeNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
