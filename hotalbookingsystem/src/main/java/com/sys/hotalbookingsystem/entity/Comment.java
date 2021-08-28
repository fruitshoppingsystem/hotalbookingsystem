package com.sys.hotalbookingsystem.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Comment {
    private int cId;
    private String uEmail;
    private int roomId;
    private Date cTime;
    private String cContent;
    private String uName;
    private String roomType;
}
