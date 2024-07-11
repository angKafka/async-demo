package org.rdutta.assignment.entities;

import jakarta.persistence.*;


import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "RESERVATION_ID")
    private UUID reservation_id;
    @Column(name = "ROOM_ID")
    private UUID room_id;
    @Column(name = "GUEST_ID")
    private UUID guest_id;
    @Column(name = "RESERVATION_DATE")
    private Date reservation_date;

    public UUID getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(UUID reservation_id) {
        this.reservation_id = reservation_id;
    }

    public UUID getRoom_id() {
        return room_id;
    }

    public void setRoom_id(UUID room_id) {
        this.room_id = room_id;
    }

    public UUID getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(UUID guest_id) {
        this.guest_id = guest_id;
    }

    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservation_id=" + reservation_id +
                ", room_id=" + room_id +
                ", guest_id=" + guest_id +
                ", reservation_date=" + reservation_date +
                '}';
    }
}
