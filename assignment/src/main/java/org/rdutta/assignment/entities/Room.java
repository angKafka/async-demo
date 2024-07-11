package org.rdutta.assignment.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ROOM_ID")
    private UUID room_id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ROOM_NUMBER")
    private char room_number;
    @Column(name = "ROOM_STATUS")
    private String room_status;
    @Column(name = "BED_INFO")
    private char bed_info;
    private boolean isEmptyRoom;

    public UUID getRoom_id() {
        return room_id;
    }

    public void setRoom_id(UUID room_id) {
        this.room_id = room_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getRoom_number() {
        return room_number;
    }

    public void setRoom_number(char room_number) {
        this.room_number = room_number;
    }

    public char getBed_info() {
        return bed_info;
    }

    public void setBed_info(char bed_info) {
        this.bed_info = bed_info;
    }

    public boolean isEmptyRoom() {
        return isEmptyRoom;
    }

    public void setEmptyRoom(boolean emptyRoom) {
        isEmptyRoom = emptyRoom;
    }

    public String getRoom_status() {
        return room_status;
    }

    public void setRoom_status(String room_status) {
        this.room_status = room_status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", name='" + name + '\'' +
                ", room_number=" + room_number +
                ", room_status=" + room_status +
                ", bed_info=" + bed_info +
                '}';
    }
}
