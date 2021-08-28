package com.sys.hotalbookingsystem.entity;

import lombok.Data;

@Data
public class User {
    private String uEmail;
    private String uName;
    private String uPassword;
    private String uSex;
    private int uAge;
    private String uPhone;
    private String uIDCard;

    public User(String uEmail, String uName, String uPassword, String uPhone, String uIDCard) {
        this.uEmail = uEmail;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uPhone = uPhone;
        this.uIDCard = uIDCard;
    }
}
