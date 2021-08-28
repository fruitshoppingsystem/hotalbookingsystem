package com.sys.hotalbookingsystem.controller;

import com.sys.hotalbookingsystem.entity.Admin;
import com.sys.hotalbookingsystem.service.AdminService;
import com.sys.hotalbookingsystem.service.ReceptionistService;
import com.sys.hotalbookingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReceptionistService receptionistService;
    @Autowired
    private AdminService adminService;
    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }
    @RequestMapping("/registerPage")
    public String registerPage(){
        return "register";
    }
    @RequestMapping("/userPage")
    public String userPage(String uEmail){
        return "user";
    }
    @RequestMapping("/adminPage")
    public String adminPage(int aId, Model model){
        Admin admin = adminService.selectAdminById(aId);
        model.addAttribute("admin",admin);
        return "admin";
    }
    @RequestMapping("/receptionistPage")
    public String receptionistPage(int rId){
        return "receptionist";
    }
}
