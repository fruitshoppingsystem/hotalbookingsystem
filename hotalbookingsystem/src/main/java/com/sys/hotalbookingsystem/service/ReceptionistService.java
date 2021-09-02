package com.sys.hotalbookingsystem.service;

public interface ReceptionistService {
    int findReceptionistById(int rId);
    String selectPasswordById(int rId);
    String selectNameById(int rId);
}
