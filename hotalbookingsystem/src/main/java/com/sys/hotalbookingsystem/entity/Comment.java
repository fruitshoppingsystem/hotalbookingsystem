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

    public Comment(String uEmail, int roomId, Date cTime, String cContent, String uName, String roomType) {
        this.uEmail = uEmail;
        this.roomId = roomId;
        this.cTime = cTime;
        this.cContent = cContent;
        this.uName = uName;
        this.roomType = roomType;
    }

    public Comment(int cId, String uEmail, int roomId, Date cTime, String cContent, String uName, String roomType) {
        this.cId = cId;
        this.uEmail = uEmail;
        this.roomId = roomId;
        this.cTime = cTime;
        this.cContent = cContent;
        this.uName = uName;
        this.roomType = roomType;
    }
}
