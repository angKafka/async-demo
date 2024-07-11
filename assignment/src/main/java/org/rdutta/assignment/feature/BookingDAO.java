package org.rdutta.assignment.feature;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.rdutta.assignment.entities.Guest;
import org.rdutta.assignment.entities.Reservation;
import org.rdutta.assignment.entities.Room;
import org.rdutta.assignment.repositories.GuestDAO;
import org.rdutta.assignment.repositories.ReservationDAO;
import org.rdutta.assignment.repositories.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class BookingDAO implements GuestDAO, ReservationDAO, RoomDAO {
    private final EntityManager em;

    @Autowired
    public BookingDAO(EntityManager em) {
        this.em = em;
    }
    @Override
    public void saveGuest(Guest guest) {
        em.persist(guest);
    }

    @Override
    public Guest findByEmail(String email) {
        TypedQuery<Guest> query = em.createQuery("FROM Guest WHERE email_address = :email", Guest.class);
        query.setParameter("email", email);
        //Execute Query
        Guest guestFound = query.getSingleResult();
        return guestFound;
    }

    @Override
    public List<Guest> findAll() {
        TypedQuery<Guest> query = em.createQuery("FROM Guest", Guest.class);

        //Execute Query
        List<Guest> guests = query.getResultList();
        return guests;
    }

    @Override
    public Guest findByGuestId(UUID guest_id) {
        Guest guest = em.find(Guest.class, guest_id);
        return guest;
    }

    @Override
    public void updateGuest(Guest guest) {
        em.merge(guest);
    }

    @Override
    public void deleteGuestByGuestUID(UUID guest_id) {
        Guest guest = em.find(Guest.class, guest_id);
        em.remove(guest);
    }

    @Override
    public void saveRoom(Room room) {
        em.persist(room);
    }

    @Override
    public void updateRoom(Room room) {
        em.merge(room);
    }

    @Override
    public void deleteRoomByRoomUID(UUID room_id) {
        Room room = em.find(Room.class, room_id);
        em.remove(room);
    }

    @Override
    public Room getRoom(UUID roomId) {
        TypedQuery<Room> query = em.createQuery("FROM Room WHERE room_id = :roomId", Room.class);
        query.setParameter("roomId", roomId);
        Room roomFound = query.getSingleResult();
        return roomFound;
    }

    @Override
    public List<Room> getAllRooms() {
        TypedQuery<Room> query = em.createQuery("FROM Room", Room.class);
        List<Room> rooms = query.getResultList();
        return rooms;
    }

    @Override
    public void create(Reservation reservation) {
        em.persist(reservation);
    }

    @Override
    public void update(Reservation reservation) {
        em.merge(reservation);
    }

    @Override
    public void deleteReservationByReservationUID(UUID reservation_id) {
        Reservation reservation = em.find(Reservation.class, reservation_id);
        em.remove(reservation);
    }

    @Override
    public Reservation getReservationByReservationDate(Date reservationDate) {
        TypedQuery<Reservation> query = em.createQuery("FROM Reservation WHERE reservation_date = :reservationDate", Reservation.class);
        query.setParameter("reservationDate", reservationDate);
        Reservation reservationFound = query.getSingleResult();
        return reservationFound;
    }

    @Override
    public Reservation getReservationByReservationID(UUID reservation_id) {
        Reservation reservation = em.find(Reservation.class, reservation_id);
        return reservation;
    }
}
