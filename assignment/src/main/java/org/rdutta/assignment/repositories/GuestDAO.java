package org.rdutta.assignment.repositories;

import org.rdutta.assignment.entities.Guest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface GuestDAO {
    void saveGuest(Guest guest);
    Guest findByEmail(String email);
    List<Guest> findAll();
    Guest findByGuestId(UUID guest_id);
    void updateGuest(Guest guest);
    void deleteGuestByGuestUID(UUID guest_id);
}
