package org.rdutta.assignment.feature;

import jakarta.transaction.Transactional;
import org.rdutta.assignment.business.dto.RoomReservation;
import org.rdutta.assignment.business.service.GuestService;
import org.rdutta.assignment.business.service.ReservationService;
import org.rdutta.assignment.business.service.RoomService;
import org.rdutta.assignment.entities.Guest;
import org.rdutta.assignment.entities.Reservation;
import org.rdutta.assignment.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BookingService implements GuestService, RoomService, ReservationService {
    private final BookingDAO bookingDAO;


    @Autowired
    public BookingService(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Transactional
    @Override
    public void saveGuest(Guest guest) {
        bookingDAO.saveGuest(guest);
    }

    @Override
    public Guest findByEmail(String email) {
        return bookingDAO.findByEmail(email);
    }

    @Override
    public List<Guest> findAll() {
        return bookingDAO.findAll();
    }

    @Override
    public Guest findByGuestId(UUID guest_id) {
        return bookingDAO.findByGuestId(guest_id);
    }

    @Transactional
    @Override
    public void updateGuest(Guest guest) {
        bookingDAO.updateGuest(guest);
    }

    @Transactional
    @Override
    public void deleteGuestByGuestUID(UUID guest_id) {
        bookingDAO.deleteGuestByGuestUID(guest_id);
    }

    @Transactional
    @Override
    public void create(Reservation reservation) {
        bookingDAO.create(reservation);
            // Update the room status to "Booked" and isEmptyRoom to false
            UUID roomId = reservation.getRoom_id();
            Room room = bookingDAO.getRoom(roomId);
            if(room.getRoom_id() != null) {
                room.setRoom_status("Booked");
                room.setEmptyRoom(false);
                bookingDAO.saveRoom(room);
            }
    }

    @Transactional
    @Override
    public void update(Reservation reservation) {
        bookingDAO.update(reservation);
    }

    @Transactional
    @Override
    public void deleteReservationByReservationUID(UUID reservation_id) {
        bookingDAO.deleteReservationByReservationUID(reservation_id);
    }

    @Override
    public Reservation getReservationByReservationDate(Date reservationDate) {
        return bookingDAO.getReservationByReservationDate(reservationDate);
    }

    @Transactional
    @Override
    public void saveRoom(Room room) {
        bookingDAO.saveRoom(room);
    }

    @Transactional
    @Override
    public void updateRoom(Room room) {
        bookingDAO.updateRoom(room);
    }

    @Transactional
    @Override
    public void deleteRoomByRoomUID(UUID room_id) {
        bookingDAO.deleteRoomByRoomUID(room_id);
    }

    @Override
    public Room getRoom(UUID roomId) {
        return  bookingDAO.getRoom(roomId);
    }

    @Override
    public List<Room> getAllRooms() {
        return bookingDAO.getAllRooms();
    }


    @Override
    public Reservation getReservationByReservationUID(UUID reservationUID) {
        Reservation reservation = bookingDAO.getReservationByReservationID(reservationUID);

        return reservation;
    }


    public RoomReservation getDetailsByReservationUID(UUID reservationId) {
        // Logic to fetch RoomReservation using the reservationId
        // This can involve fetching Reservation, Guest, and Room details from the database and constructing a RoomReservation object

        // Sample code to illustrate the idea
        Reservation reservation = bookingDAO.getReservationByReservationID(reservationId); // Assume this method fetches a Reservation by ID
        if (reservation == null) {
            return null;
        }
        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setRoom_id(reservation.getRoom_id());
        roomReservation.setGuest_id(reservation.getGuest_id());
        roomReservation.setRoom_name(bookingDAO.getRoom(reservation.getRoom_id()).getName());
        roomReservation.setRoom_number(String.valueOf(bookingDAO.getRoom(reservation.getRoom_id()).getRoom_number()));
        roomReservation.setFirstname(bookingDAO.findByGuestId(reservation.getGuest_id()).getFirst_name());
        roomReservation.setLastname(bookingDAO.findByGuestId(reservation.getGuest_id()).getLast_name());
        roomReservation.setReservation_date(reservation.getReservation_date());

        return roomReservation;
    }
}
