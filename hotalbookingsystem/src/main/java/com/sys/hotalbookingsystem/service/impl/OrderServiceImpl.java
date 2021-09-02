package com.sys.hotalbookingsystem.service.impl;

import com.sys.hotalbookingsystem.dao.OrderDao;
import com.sys.hotalbookingsystem.entity.Order;
import com.sys.hotalbookingsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("OrderService")
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    @Override
    public void addROrder(Order order) {
        orderDao.addROrder(order);
    }

    @Override
    public void updateState(int oId, String oState) {
        orderDao.updateState(oId, oState);
    }

    @Override
    public void checkIn(int oId, int roomId, int roomFloor) {
        orderDao.checkIn(oId, roomId, roomFloor);
    }

    @Override
    public List<Order> selectUserOrders(String uEmail) {
        return orderDao.selectUserOrders(uEmail);
    }

    @Override
    public List<Order> selectReceptionistOrders(int rId) {
        return orderDao.selectReceptionistOrders(rId);
    }

    @Override
    public List<Order> selectNotReceptionistOrders() {
        return orderDao.selectNotReceptionistOrders();
    }

    @Override
    public List<Order> selectTypeOrders(String roomType) {
        return orderDao.selectTypeOrders(roomType);
    }

    @Override
    public List<Order> selectUnsubscribeOrder() {
        return orderDao.selectUnsubscribeOrder();
    }

    @Override
    public int selectMaxId() {
        return orderDao.selectMaxId();
    }

    @Override
    public Order selectOrderById(int oId) {
        return orderDao.selectOrderById(oId);
    }
}
