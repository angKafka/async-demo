package org.rdutta.assignment.business.service;

import org.rdutta.assignment.entities.Room;

import java.util.List;
import java.util.UUID;

public interface RoomService {
    void saveRoom(Room room);
    void updateRoom(Room room);
    void deleteRoomByRoomUID(UUID room_id);
    Room getRoom(UUID roomId);
    List<Room> getAllRooms();
}
