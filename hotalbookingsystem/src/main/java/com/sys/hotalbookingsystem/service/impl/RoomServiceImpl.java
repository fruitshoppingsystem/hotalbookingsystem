package com.sys.hotalbookingsystem.service.impl;

import com.sys.hotalbookingsystem.dao.RoomDao;
import com.sys.hotalbookingsystem.entity.Room;
import com.sys.hotalbookingsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("RoomService")
@Transactional
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;
    @Override
    public void addRoom(Room room) {
        roomDao.addRoom(room);
    }

    @Override
    public void deleteRoom(int roomId) {
        roomDao.deleteRoom(roomId);
    }

    @Override
    public void updateRoom(Room room) {
        roomDao.updateRoom(room);
    }

    @Override
    public void updateState(int roomId, String roomState) {
        roomDao.updateState(roomId, roomState);
    }

    @Override
    public List<Room> selectAllRooms() {
        return roomDao.selectAllRooms();
    }

    @Override
    public List<Room> selectRoomByType(String roomType) {
        return roomDao.selectRoomByType(roomType);
    }

    @Override
    public List<Integer> selectRoomIdByType(String roomType) {
        return roomDao.selectRoomIdByType(roomType);
    }

    @Override
    public Room selectRoomById(int roomId) {
        return roomDao.selectRoomById(roomId);
    }

    @Override
    public String selectStateById(int roomId) {
        return roomDao.selectStateById(roomId);
    }

    @Override
    public int selectRoomNumByType(String roomType) {
        return roomDao.selectRoomNumByType(roomType);
    }
}
