package org.rdutta.employee.utils;

public class ExponentialBackoffRetryStrategy implements RetryStrategy {
    @Override
    public boolean shouldRetry(int attempt) {
        return attempt < 5; // Retry up to 5 times
    }

    @Override
    public long getRetryInterval(int attempt) {
        return (long) Math.pow(2, attempt) * 1000; // Exponential backoff (1s, 2s, 4s, 8s, 16s...)
    }
}