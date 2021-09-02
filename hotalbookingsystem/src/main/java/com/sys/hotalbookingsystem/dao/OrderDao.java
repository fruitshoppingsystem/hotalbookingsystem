package com.sys.hotalbookingsystem.dao;

import com.sys.hotalbookingsystem.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("OrderDao")
@Mapper
public interface OrderDao {
    void addOrder(Order order);
    void addROrder(Order order);
    void updateState(@Param("oId")int oId, @Param("oState")String oState);
    void checkIn(@Param("oId")int oId, @Param("roomId")int roomId, @Param("roomFloor")int roomFloor);
    List<Order> selectUserOrders(String uEmail);
    List<Order> selectReceptionistOrders(int rId);
    List<Order> selectNotReceptionistOrders();
    List<Order> selectTypeOrders(String roomType);
    List<Order> selectUnsubscribeOrder();
    int selectMaxId();
    Order selectOrderById(int oId);
}
