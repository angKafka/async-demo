package org.rdutta.tutorial.interface_training;

import java.util.UUID;

public interface Airport {
    public final UUID airportToken = UUID.randomUUID();
    UUID registerPlainByUUID(UUID plain_UID);
    Boolean isPlanValid(UUID plain_UID);
    String showFlightDetails();
}
