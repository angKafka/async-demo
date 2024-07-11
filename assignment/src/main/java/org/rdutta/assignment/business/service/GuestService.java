package org.rdutta.assignment.business.service;

import org.rdutta.assignment.entities.Guest;

import java.util.List;
import java.util.UUID;

public interface GuestService {
    void saveGuest(Guest guest);
    Guest findByEmail(String email);
    List<Guest> findAll();
    Guest findByGuestId(UUID guest_id);
    void updateGuest(Guest guest);
    void deleteGuestByGuestUID(UUID guest_id);
}
