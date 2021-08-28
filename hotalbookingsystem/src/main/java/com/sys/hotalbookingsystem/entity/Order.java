package com.sys.hotalbookingsystem.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Order {
    private int oId;
    private String uEmail;
    private int roomId;
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
}
