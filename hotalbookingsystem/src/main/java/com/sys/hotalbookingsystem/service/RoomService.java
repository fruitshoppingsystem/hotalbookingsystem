package com.sys.hotalbookingsystem.service;

import com.sys.hotalbookingsystem.entity.Room;

import java.util.List;

public interface RoomService {
    void addRoom(Room room);
    void deleteRoom(int roomId);
    void updateRoom(Room room);
    void updateState(int roomId, String roomState);
    List<Room> selectAllRooms();
    List<Room> selectRoomByType(String roomType);
    List<Integer> selectRoomIdByType(String roomType);
    Room selectRoomById(int roomId);
    String selectStateById(int roomId);
    int selectRoomNumByType(String roomType);
}
