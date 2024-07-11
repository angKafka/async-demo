package org.rdutta.assignment.controller;

import jakarta.persistence.EntityManager;
import org.rdutta.assignment.business.dto.RoomReservation;
import org.rdutta.assignment.business.service.GuestService;
import org.rdutta.assignment.business.service.ReservationService;
import org.rdutta.assignment.business.service.RoomService;
import org.rdutta.assignment.entities.Guest;
import org.rdutta.assignment.entities.Reservation;
import org.rdutta.assignment.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private final GuestService guestService;
    private final ReservationService reservationService;
    private final RoomService roomService;
    @Autowired
    public BookingController(GuestService guestService, ReservationService reservationService, RoomService roomService, EntityManager entityManager) {
        this.guestService = guestService;
        this.reservationService = reservationService;
        this.roomService = roomService;
    }

    // Guest endpoints
    @PostMapping("/guests/add")
    public ResponseEntity<Void> createGuest(@RequestBody Guest guest) {
        guestService.saveGuest(guest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/guests/{email}")
    public ResponseEntity<Guest> getGuestByEmail(@PathVariable String email) {
        Guest guest = guestService.findByEmail(email);
        return ResponseEntity.ok(guest);
    }

    @GetMapping("/guests/all")
    public ResponseEntity<List<Guest>> getAllGuests() {
        List<Guest> guests = guestService.findAll();
        return ResponseEntity.ok(guests);
    }

    @PutMapping("/guests/edit")
    public ResponseEntity<Void> updateGuest(@RequestBody Guest guest) {
        guestService.updateGuest(guest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/guests/{guestId}")
    public ResponseEntity<Void> deleteGuest(@PathVariable UUID guestId) {
        guestService.deleteGuestByGuestUID(guestId);
        return ResponseEntity.ok().build();
    }

    // Reservation endpoints
    @PostMapping("/reservations/add")
    public ResponseEntity<Void> createReservation(@RequestBody Reservation reservation) {
        reservationService.create(reservation);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/reservations/edit")
    public ResponseEntity<Void> updateReservation(@RequestBody Reservation reservation) {
        reservationService.update(reservation);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/reservations/{reservationId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable UUID reservationId) {
        reservationService.deleteReservationByReservationUID(reservationId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/reservations/filter")
    public ResponseEntity<Reservation> getReservationByDate(@RequestParam Date reservationDate) {
        Reservation reservation = reservationService.getReservationByReservationDate(reservationDate);
        return ResponseEntity.ok(reservation);
    }

    // Room endpoints
    @PostMapping("/rooms/add")
    public ResponseEntity<Void> createRoom(@RequestBody Room room) {
        roomService.saveRoom(room);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/rooms/edit")
    public ResponseEntity<Void> updateRoom(@RequestBody Room room) {
        roomService.updateRoom(room);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/rooms/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable UUID roomId) {
        roomService.deleteRoomByRoomUID(roomId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rooms/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable UUID roomId) {
        Room room = roomService.getRoom(roomId);
        return ResponseEntity.ok(room);
    }

    @GetMapping("/rooms/all")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/reservations/{reservation_id}")
    public ResponseEntity<RoomReservation> getReservationByReservationUUID(@PathVariable("reservation_id") UUID reservation_id) {
        if(reservation_id == null) {
           return null;
        }
        RoomReservation reservation = reservationService.getDetailsByReservationUID(reservation_id);
        return ResponseEntity.ok(reservation);
    }
}

