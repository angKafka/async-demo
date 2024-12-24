package org.rdutta.employee.utils;

public interface RetryStrategy {
    boolean shouldRetry(int attempt); // Determines if retry is needed after a failure
    long getRetryInterval(int attempt); // Time between retries (in milliseconds)
}
