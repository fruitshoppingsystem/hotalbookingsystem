package com.sys.hotalbookingsystem.service;

import com.sys.hotalbookingsystem.entity.User;

public interface UserService {
    void addUser(User user);
    int findUserByEmail(String uEmail);
    String selectPasswordByEmail(String uEmail);
    User selectUserByEmail(String uEmail);
    void updateUser(User user);
    void deleteUser(String uEmail);
}
