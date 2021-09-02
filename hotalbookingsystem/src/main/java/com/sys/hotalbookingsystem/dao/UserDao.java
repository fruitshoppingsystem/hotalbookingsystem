package com.sys.hotalbookingsystem.dao;

import com.sys.hotalbookingsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
@Mapper
public interface UserDao {
    void addUser(User user);
    int findUserByEmail(String uEmail);
    String selectPasswordByEmail(String uEmail);
    User selectUserByEmail(String uEmail);
    void updateUser(User user);
    void deleteUser(String uEmail);
}
