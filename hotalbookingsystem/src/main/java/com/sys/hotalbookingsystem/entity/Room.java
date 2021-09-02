package com.sys.hotalbookingsystem.entity;

import lombok.Data;

@Data
public class Room {
    private int roomId;
    private String roomType;
    private int roomFloor;
    private String roomOrientation;
    private String roomState;

    public Room(int roomId, String roomType, int roomFloor, String roomOrientation, String roomState) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomFloor = roomFloor;
        this.roomOrientation = roomOrientation;
        this.roomState = roomState;
    }

    public Room(int roomId, String roomType, int roomFloor, String roomOrientation) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomFloor = roomFloor;
        this.roomOrientation = roomOrientation;
    }
}
