package com.sys.hotalbookingsystem.service.impl;

import com.sys.hotalbookingsystem.dao.AdminDao;
import com.sys.hotalbookingsystem.entity.Admin;
import com.sys.hotalbookingsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("AdminService")
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public int findAdminById(int aId) {
        return adminDao.findAdminById(aId);
    }

    @Override
    public String selectPasswordById(int aId) {
        return adminDao.selectPasswordById(aId);
    }

    @Override
    public Admin selectAdminById(int aId) {
        return adminDao.selectAdminById(aId);
    }
}
