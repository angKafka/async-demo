package org.rdutta.localaccounts.utilities.features.time;

import java.util.concurrent.TimeUnit;

public interface TimeExpirationScheduler {
    final long VALIDITY = TimeUnit.MINUTES.toMillis(30);
}
