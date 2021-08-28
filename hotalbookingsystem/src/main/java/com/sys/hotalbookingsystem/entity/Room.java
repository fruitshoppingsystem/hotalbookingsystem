package com.sys.hotalbookingsystem.entity;

import lombok.Data;

@Data
public class Room {
    private int roomId;
    private String roomType;
    private int roomFloor;
    private String roomOrientation;
    private String roomState;
}
