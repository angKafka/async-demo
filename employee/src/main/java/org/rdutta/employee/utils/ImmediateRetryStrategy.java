package org.rdutta.employee.utils;

public class ImmediateRetryStrategy implements RetryStrategy {
    @Override
    public boolean shouldRetry(int attempt) {
        return attempt < 3; // Retry up to 3 times
    }

    @Override
    public long getRetryInterval(int attempt) {
        return 1000; // Retry every second
    }
}