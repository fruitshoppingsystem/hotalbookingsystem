package com.sys.hotalbookingsystem.service.impl;

import com.sys.hotalbookingsystem.dao.UserDao;
import com.sys.hotalbookingsystem.entity.User;
import com.sys.hotalbookingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public int findUserByEmail(String uEmail) {
        return userDao.findUserByEmail(uEmail);
    }

    @Override
    public String selectPasswordByEmail(String uEmail) {
        return userDao.selectPasswordByEmail(uEmail);
    }
}
