package com.sys.hotalbookingsystem.controller;

import com.sys.hotalbookingsystem.entity.Admin;
import com.sys.hotalbookingsystem.entity.Order;
import com.sys.hotalbookingsystem.entity.Room;
import com.sys.hotalbookingsystem.service.OrderService;
import com.sys.hotalbookingsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/addRoom")
    @ResponseBody
    public Boolean addRoom(int roomId, String roomType, int roomFloor, String roomOrientation){
        Room room = new Room(roomId, roomType, roomFloor, roomOrientation, "空闲");
        roomService.addRoom(room);
        return true;
    }
    @RequestMapping("/updateRoom")
    @ResponseBody
    public Boolean updateRoom(int roomId, String roomType, int roomFloor, String roomOrientation){
        Room room = new Room(roomId, roomType, roomFloor, roomOrientation);
        roomService.updateRoom(room);
        return true;
    }
    @RequestMapping("/deleteRoom")
    @ResponseBody
    public Boolean deleteRoom(int roomId){
        if (roomService.selectStateById(roomId).equals("空闲")){
            roomService.deleteRoom(roomId);
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("/selectTypeRoom")
    @ResponseBody
    public Boolean selectTypeRoom(String roomType, Date aTime, Date lTime){
        int o = 0;
        int num = roomService.selectRoomNumByType(roomType);
        List<Order> orders = orderService.selectTypeOrders(roomType);
        for (Order order : orders) {
            if (order.getATime().compareTo(lTime) < 0 && order.getLTime().compareTo(aTime) > 0) {
                o = o + 1;
            }
        }
        return num - o > 0;
    }
}
