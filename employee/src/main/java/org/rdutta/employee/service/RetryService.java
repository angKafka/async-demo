package org.rdutta.employee.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RetryService {
    int maxAttempts = 3;

    public boolean attemptRetry(Runnable operation) {
        int attempt = 0;
        while (attempt < maxAttempts) {
            try {
                attempt++;
                log.info("Attempt {} of {}...", attempt, maxAttempts);
                operation.run(); // Attempt the operation

                log.info("Operation succeeded on attempt {}", attempt);
                return true; // If successful, return true
            } catch (Exception e) {
                log.error("Operation failed on attempt {}: {}", attempt, e.getMessage());

                if (attempt == maxAttempts) {
                    log.error("Max attempts reached. Operation failed.");
                    return false; // If max attempts reached, return false
                }

                // Optionally, add a delay before retrying
                try {
                    Thread.sleep(1000); // 1 second delay between retries (can adjust as needed)
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    log.error("Retry attempt interrupted");
                }
            }
        }
        return false;
    }
}
