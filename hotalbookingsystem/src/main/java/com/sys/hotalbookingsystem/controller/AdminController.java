package com.sys.hotalbookingsystem.controller;

import com.sys.hotalbookingsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/adminLogin")
    @ResponseBody
    public Boolean adminLogin(int aId, String aPassword){
        if (adminService.findAdminById(aId) != 0){
            String password = adminService.selectPasswordById(aId);
            return aPassword.equals(password);
        }
        return false;
    }

}
