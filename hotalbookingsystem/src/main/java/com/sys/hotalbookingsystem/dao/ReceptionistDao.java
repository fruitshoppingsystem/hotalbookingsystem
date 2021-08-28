package com.sys.hotalbookingsystem.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("ReceptionistDao")
@Mapper
public interface ReceptionistDao {
    int findReceptionistById(int rId);
    String selectPasswordById(int rId);
}
