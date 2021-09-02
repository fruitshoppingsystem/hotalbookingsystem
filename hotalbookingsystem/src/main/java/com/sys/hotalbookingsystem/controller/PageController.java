package com.sys.hotalbookingsystem.controller;

import com.sys.hotalbookingsystem.entity.*;
import com.sys.hotalbookingsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class PageController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReceptionistService receptionistService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CommentService commentService;
    @RequestMapping("/indexPage")
    public String indexPage(String uEmail, Model model){
        model.addAttribute("uEmail",uEmail);
        return "index";
    }
    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }
    @RequestMapping("/registerPage")
    public String registerPage(){
        return "register";
    }
    @RequestMapping("/userPage")
    public String userPage(String uEmail, Model model){
        model.addAttribute("uEmail",uEmail);
        User user = userService.selectUserByEmail(uEmail);
        model.addAttribute("user",user);
        String uSex = user.getUSex();
        if (uSex != null){
            model.addAttribute("uSex",uSex);
        }
        int uAge = user.getUAge();
        if (uSex != null){
            model.addAttribute("uAge",uAge);
        }
        List<Order> orders = orderService.selectUserOrders(uEmail);
        model.addAttribute("orders",orders);
        return "user";
    }
    @RequestMapping("/adminPage")
    public String adminPage(int aId, Model model){
        model.addAttribute("aId",aId);
        Admin admin = adminService.selectAdminById(aId);
        model.addAttribute("admin",admin);
        List<Room> rooms = roomService.selectAllRooms();
        model.addAttribute("rooms",rooms);
        List<Comment> comments = commentService.selectAllComment();
        model.addAttribute("comments",comments);
        List<Order> orders = orderService.selectUnsubscribeOrder();
        model.addAttribute("orders",orders);
        return "admin";
    }
    @RequestMapping("/receptionistPage")
    public String receptionistPage(int rId, Model model){
        model.addAttribute("rId",rId);
        String rName = receptionistService.selectNameById(rId);
        model.addAttribute("rName",rName);
        List<Order> myOrders = orderService.selectReceptionistOrders(rId);
        model.addAttribute("myOrders",myOrders);
        List<Order> userOrders = orderService.selectNotReceptionistOrders();
        model.addAttribute("useOrders",userOrders);
        List<Room> rooms = roomService.selectAllRooms();
        model.addAttribute("rooms",rooms);
        return "receptionist";
    }
    @RequestMapping("/addRoomPage")
    public String addRoomPage(int aId, Model model){
        model.addAttribute("aId", aId);
        return "addRoom";
    }
    @RequestMapping("/updateRoomPage")
    public String updateRoomPage(int roomId, int aId, Model model){
        model.addAttribute("roomId", roomId);
        Room room = roomService.selectRoomById(roomId);
        model.addAttribute("room", room);
        model.addAttribute("aId", aId);
        return "updateRoom";
    }
    @RequestMapping("/commentPage")
    public String commentPage(String uEmail, String uName,Integer roomId, String roomType, Model model){
        model.addAttribute("uEmail",uEmail);
        model.addAttribute("uName",uName);
        model.addAttribute("roomId",roomId);
        model.addAttribute("roomType",roomType);
        return "comment";
    }
    @RequestMapping("/reservation1Page")
    public String Reservation1Page(String roomType, Date aTime, Date lTime, int uNum, int dayNum, int price, String image, String href, Model model){
        model.addAttribute("roomType",roomType);
        model.addAttribute("aTime",aTime);
        model.addAttribute("lTime",lTime);
        model.addAttribute("uNum",uNum);
        model.addAttribute("dayNum",dayNum);
        model.addAttribute("price",price);
        model.addAttribute("image",image);
        model.addAttribute("href",href);
        return "reservation-1";
    }
    @RequestMapping("/reservation2Page")
    public String Reservation2Page(String roomType, Date aTime, Date lTime, int uNum, int dayNum, int price, String image, String href, Model model){
        model.addAttribute("roomType",roomType);
        model.addAttribute("aTime",aTime);
        model.addAttribute("lTime",lTime);
        model.addAttribute("uNum",uNum);
        model.addAttribute("dayNum",dayNum);
        model.addAttribute("price",price);
        model.addAttribute("image",image);
        model.addAttribute("href",href);
        return "reservation-2";
    }
    @RequestMapping("/reservation3Page")
    public String Reservation3Page(int oId, Model model){
        Order order = orderService.selectOrderById(oId);
        String uEmail = order.getUEmail();
        String uName = order.getUName();
        String uPhone = order.getUPhone();
        String uIDCard = order.getUIDCard();
        Date aTime = order.getATime();
        Date lTime = order.getLTime();
        String roomType = order.getRoomType();
        int uNum = order.getUNum();
        int dayNum = order.getDayNum();
        int price = order.getTotalPrise();
        model.addAttribute("oId",oId);
        model.addAttribute("roomType",roomType);
        model.addAttribute("aTime",aTime);
        model.addAttribute("lTime",lTime);
        model.addAttribute("uNum",uNum);
        model.addAttribute("dayNum",dayNum);
        model.addAttribute("price",price);
        model.addAttribute("uEmail",uEmail);
        model.addAttribute("uName",uName);
        model.addAttribute("uPhone",uPhone);
        model.addAttribute("uIDCard",uIDCard);
        return "reservation-3";
    }
    @RequestMapping("/checkInPage")
    public String checkInPage(int oId,int rId, Model model){
        model.addAttribute("oId",oId);
        Order order = orderService.selectOrderById(oId);
        String roomType = order.getRoomType();
        model.addAttribute("rId",rId);
        List<Integer> roomIds = roomService.selectRoomIdByType(roomType);
        model.addAttribute("roomIds",roomIds);
        return "checkIn";
    }
    @RequestMapping("/userCommentPage")
    public String userCommentPage(Model model){
        List<Comment> comments = commentService.selectAllComment();
        model.addAttribute("comments",comments);
        return "userComment";
    }
}
