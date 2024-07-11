package org.rdutta.assignment.repositories;


import org.rdutta.assignment.entities.Reservation;

import java.sql.Date;
import java.util.UUID;

public interface ReservationDAO {
    void create(Reservation reservation);
    void update(Reservation reservation);
    void deleteReservationByReservationUID(UUID reservation_id);
    Reservation getReservationByReservationDate(Date reservationDate);
    Reservation getReservationByReservationID(UUID reservation_id);
}
