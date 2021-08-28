package com.sys.hotalbookingsystem.dao;

import com.sys.hotalbookingsystem.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RoomDao")
@Mapper
public interface RoomDao {
    void addRoom(Room room);
    void deleteRoom(int roomId);
    void updateRoom(Room room);
    List<Room> selectAllRooms();
    List<Room> selectRoomByState(String roomState);
}
