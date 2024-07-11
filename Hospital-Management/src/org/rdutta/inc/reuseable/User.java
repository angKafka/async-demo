package org.rdutta.inc.reuseable;

import java.util.UUID;

public interface User {
    public UUID getId();
    public String getName();
    public String getEmail();
    public String getPhone();

    public boolean isValid();

    public String generateBadgeNumber();
}
