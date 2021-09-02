package com.sys.hotalbookingsystem.controller;

import com.sys.hotalbookingsystem.entity.Order;
import com.sys.hotalbookingsystem.entity.Room;
import com.sys.hotalbookingsystem.entity.User;
import com.sys.hotalbookingsystem.service.OrderService;
import com.sys.hotalbookingsystem.service.RoomService;
import com.sys.hotalbookingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;

    @RequestMapping("/unsubscribe")
    @ResponseBody
    public Boolean unsubscribe(int oId){
        orderService.updateState(oId, "申请退订");
        return true;
    }
    @RequestMapping("/unsubscribeR")
    @ResponseBody
    public Boolean unsubscribeR(int oId){
        orderService.updateState(oId, "已退款");
        return true;
    }
    @RequestMapping("/addOrder")
    @ResponseBody
    public int addOrder(String uEmail, Date aTime, Date lTime, int uNum, int dayNum, int totalPrise, String roomType){
        User user = userService.selectUserByEmail(uEmail);
        String uName = user.getUName();
        String uPhone = user.getUPhone();
        String uIDCard = user.getUIDCard();
        Order order = new Order(uEmail, aTime, lTime, uNum, dayNum, totalPrise, roomType, uName, uPhone, uIDCard, "已预定");
        orderService.addOrder(order);
        int oId = orderService.selectMaxId();
        return oId;
    }

    @RequestMapping("/paySuccess")
    @ResponseBody
    public Boolean paySuccess(int oId){
        orderService.updateState(oId,"已支付");
        return true;
    }

    @RequestMapping("/addROrder")
    @ResponseBody
    public Boolean addROrder(int rId,Date aTime, Date lTime, int uNum, int dayNum, int totalPrise, String roomType, String uName, String uPhone, String uIDCard){
        Order order = new Order(aTime, lTime, uNum, dayNum, totalPrise, roomType, uName, uPhone, uIDCard, "已支付",rId);
        orderService.addROrder(order);
        return true;
    }

    @RequestMapping("/checkIn")
    @ResponseBody
    public Boolean checkIn(int oId, int roomId){
        Room room = roomService.selectRoomById(roomId);
        int roomFloor = room.getRoomFloor();
        orderService.checkIn(oId, roomId, roomFloor);
        orderService.updateState(oId, "已入住");
        roomService.updateState(roomId, "有客");
        return true;
    }

    @RequestMapping("/checkOut")
    @ResponseBody
    public Boolean checkOut(int oId){
        Order order = orderService.selectOrderById(oId);
        int roomId = order.getRoomId();
        roomService.updateState(roomId, "空闲");
        orderService.updateState(oId, "已退房");
        return true;
    }
}
