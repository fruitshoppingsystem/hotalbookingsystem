package com.sys.hotalbookingsystem.dao;

import com.sys.hotalbookingsystem.entity.Receptionist;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("ReceptionistDao")
@Mapper
public interface ReceptionistDao {
    int findReceptionistById(int rId);
    String selectPasswordById(int rId);
    String selectNameById(int rId);
}
