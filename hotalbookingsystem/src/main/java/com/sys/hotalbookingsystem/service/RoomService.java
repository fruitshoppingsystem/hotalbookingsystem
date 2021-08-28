package com.sys.hotalbookingsystem.service;

import com.sys.hotalbookingsystem.entity.Room;

import java.util.List;

public interface RoomService {
    void addRoom(Room room);
    void deleteRoom(int roomId);
    void updateRoom(Room room);
    List<Room> selectAllRooms();
    List<Room> selectRoomByState(String roomState);
}
