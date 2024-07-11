package org.rdutta.assignment.business.dto;

import java.sql.Date;
import java.util.UUID;

public class RoomReservation {
    private UUID room_id;
    private UUID guest_id;
    private String room_name;
    private String room_number;
    private String firstname;
    private String lastname;
    private Date reservation_date;

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

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    @Override
    public String toString() {
        return "RoomReservation{" +
                "room_id=" + room_id +
                ", guest_id=" + guest_id +
                ", room_name='" + room_name + '\'' +
                ", room_number='" + room_number + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", reservation_date=" + reservation_date +
                '}';
    }
}
