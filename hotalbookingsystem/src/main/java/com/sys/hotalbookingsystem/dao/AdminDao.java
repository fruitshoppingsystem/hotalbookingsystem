package com.sys.hotalbookingsystem.dao;

import com.sys.hotalbookingsystem.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("AdminDao")
@Mapper
public interface AdminDao {
    int findAdminById(int aId);
    String selectPasswordById(int aId);
    Admin selectAdminById(int aId);
}
