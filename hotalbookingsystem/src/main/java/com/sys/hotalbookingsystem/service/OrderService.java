package com.sys.hotalbookingsystem.service;

import com.sys.hotalbookingsystem.entity.Order;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);
    void addROrder(Order order);
    void updateState(int oId, String oState);
    void checkIn(int oId, int roomId, int roomFloor);
    List<Order> selectUserOrders(String uEmail);
    List<Order> selectReceptionistOrders(int rId);
    List<Order> selectNotReceptionistOrders();
    List<Order> selectTypeOrders(String roomType);
    List<Order> selectUnsubscribeOrder();
    int selectMaxId();
    Order selectOrderById(int oId);
}
