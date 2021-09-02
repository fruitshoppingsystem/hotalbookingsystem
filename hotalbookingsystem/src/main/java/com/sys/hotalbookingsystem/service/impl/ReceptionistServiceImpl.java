package com.sys.hotalbookingsystem.service.impl;

import com.sys.hotalbookingsystem.dao.ReceptionistDao;
import com.sys.hotalbookingsystem.service.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ReceptionistService")
@Transactional
public class ReceptionistServiceImpl implements ReceptionistService {
    @Autowired
    private ReceptionistDao receptionistDao;
    @Override
    public int findReceptionistById(int rId) {
        return receptionistDao.findReceptionistById(rId);
    }

    @Override
    public String selectPasswordById(int rId) {
        return receptionistDao.selectPasswordById(rId);
    }

    @Override
    public String selectNameById(int rId) {
        return receptionistDao.selectNameById(rId);
    }
}
