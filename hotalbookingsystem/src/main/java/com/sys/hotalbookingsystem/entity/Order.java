package com.sys.hotalbookingsystem.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Order {
    private int oId;
    private String uEmail;
    private int roomId;
    private int rId;
    private Date aTime;
    private Date lTime;
    private int uNum;
    private int dayNum;
    private int totalPrise;
    private String roomType;
    private int roomFloor;
    private String uName;
    private String uPhone;
    private String uIDCard;
    private String oState;

    public Order(String uEmail, Date aTime, Date lTime, int uNum, int dayNum, int totalPrise, String roomType, String uName, String uPhone, String uIDCard, String oState) {
        this.uEmail = uEmail;
        this.aTime = aTime;
        this.lTime = lTime;
        this.uNum = uNum;
        this.dayNum = dayNum;
        this.totalPrise = totalPrise;
        this.roomType = roomType;
        this.uName = uName;
        this.uPhone = uPhone;
        this.uIDCard = uIDCard;
        this.oState = oState;
    }

    public Order(int oId, String uEmail, Date aTime, Date lTime, int uNum, int dayNum, int totalPrise, String roomType, String uName, String uPhone, String uIDCard, String oState) {
        this.oId = oId;
        this.uEmail = uEmail;
        this.aTime = aTime;
        this.lTime = lTime;
        this.uNum = uNum;
        this.dayNum = dayNum;
        this.totalPrise = totalPrise;
        this.roomType = roomType;
        this.uName = uName;
        this.uPhone = uPhone;
        this.uIDCard = uIDCard;
        this.oState = oState;
    }

    public Order(int oId, String uEmail, int roomId, Date aTime, Date lTime, int uNum, int dayNum, int totalPrise, String roomType, int roomFloor, String uName, String uPhone, String uIDCard, String oState) {
        this.oId = oId;
        this.uEmail = uEmail;
        this.roomId = roomId;
        this.aTime = aTime;
        this.lTime = lTime;
        this.uNum = uNum;
        this.dayNum = dayNum;
        this.totalPrise = totalPrise;
        this.roomType = roomType;
        this.roomFloor = roomFloor;
        this.uName = uName;
        this.uPhone = uPhone;
        this.uIDCard = uIDCard;
        this.oState = oState;
    }

    public Order(Date aTime, Date lTime, int uNum, int dayNum, int totalPrise, String roomType, String uName, String uPhone, String uIDCard, String oState, int rId) {
        this.aTime = aTime;
        this.lTime = lTime;
        this.uNum = uNum;
        this.dayNum = dayNum;
        this.totalPrise = totalPrise;
        this.roomType = roomType;
        this.uName = uName;
        this.uPhone = uPhone;
        this.uIDCard = uIDCard;
        this.oState = oState;
        this.rId = rId;
    }
}
