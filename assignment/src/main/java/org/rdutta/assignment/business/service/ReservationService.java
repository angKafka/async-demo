package org.rdutta.assignment.business.service;

import org.rdutta.assignment.business.dto.RoomReservation;
import org.rdutta.assignment.entities.Reservation;

import java.sql.Date;
import java.util.UUID;

public interface ReservationService {
    void create(Reservation reservation);
    void update(Reservation reservation);
    void deleteReservationByReservationUID(UUID reservation_id);
    Reservation getReservationByReservationDate(Date reservationDate);
    Reservation getReservationByReservationUID(UUID reservationUID);
    RoomReservation getDetailsByReservationUID(UUID reservationId);
}
