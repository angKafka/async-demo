package org.rdutta.assignment.repositories;


import org.rdutta.assignment.entities.Room;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface RoomDAO {
    void saveRoom(Room room);
    void updateRoom(Room room);
    void deleteRoomByRoomUID(UUID room_id);
    Room getRoom(UUID roomId);
    List<Room> getAllRooms();
}
