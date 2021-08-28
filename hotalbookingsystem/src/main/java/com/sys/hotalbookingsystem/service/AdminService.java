package com.sys.hotalbookingsystem.service;

import com.sys.hotalbookingsystem.entity.Admin;

public interface AdminService {
    int findAdminById(int aId);
    String selectPasswordById(int aId);
    Admin selectAdminById(int aId);
}
