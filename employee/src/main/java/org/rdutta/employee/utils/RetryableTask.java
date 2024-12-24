package org.rdutta.employee.utils;

public abstract class RetryableTask {

    private final RetryStrategy retryStrategy;

    public RetryableTask(RetryStrategy retryStrategy) {
        this.retryStrategy = retryStrategy;
    }

    // Template method to execute the task
    public void execute() {
        int attempt = 0;
        while (retryStrategy.shouldRetry(attempt)) {
            try {
                performTask(); // Perform the task that may fail
                break; // Exit loop if task succeeds
            } catch (Exception e) {
                attempt++;
                handleFailure(e, attempt);
                try {
                    Thread.sleep(retryStrategy.getRetryInterval(attempt)); // Wait before retrying
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    // Abstract method for the task implementation (to be provided by subclasses)
    protected abstract void performTask() throws Exception;

    // Handling failure (optional customization)
    protected void handleFailure(Exception e, int attempt) {
        System.out.println("Retrying attempt " + attempt + " due to: " + e.getMessage());
    }
}