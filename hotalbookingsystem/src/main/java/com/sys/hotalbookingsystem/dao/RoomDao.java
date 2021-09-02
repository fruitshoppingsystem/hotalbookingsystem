package com.sys.hotalbookingsystem.dao;

import com.sys.hotalbookingsystem.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RoomDao")
@Mapper
public interface RoomDao {
    void addRoom(Room room);
    void deleteRoom(int roomId);
    void updateRoom(Room room);
    void updateState(@Param("roomId")int roomId, @Param("roomState")String roomState);
    List<Room> selectAllRooms();
    List<Room> selectRoomByType(String roomType);
    List<Integer> selectRoomIdByType(String roomType);
    Room selectRoomById(int roomId);
    String selectStateById(int roomId);
    int selectRoomNumByType(String roomType);
}
