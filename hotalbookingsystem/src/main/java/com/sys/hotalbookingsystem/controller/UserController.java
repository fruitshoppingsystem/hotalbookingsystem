package com.sys.hotalbookingsystem.controller;

import com.sys.hotalbookingsystem.entity.User;
import com.sys.hotalbookingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    @ResponseBody
    public Boolean addUser(String uEmail, String uName, String uPassword, String uPhone, String uIDCard){
        if (userService.findUserByEmail(uEmail) == 0){
            User user = new User(uEmail, uName, uPassword, uPhone, uIDCard);
            userService.addUser(user);
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("/userLogin")
    @ResponseBody
    public Boolean userLogin(String uEmail, String uPassword){
        if (userService.findUserByEmail(uEmail) != 0){
            String password = userService.selectPasswordByEmail(uEmail);
            return uPassword.equals(password);
        }
        return false;
    }
    @RequestMapping("/updateUser")
    @ResponseBody
    public Boolean updateUser(String uEmail, String uName,  String uSex,  int uAge,  String uPhone, String uIDCard){
        User user = new User(uEmail, uName, uSex, uAge, uPhone, uIDCard);
        userService.updateUser(user);
        return true;
    }
    @RequestMapping("/deleteUser")
    @ResponseBody
    public Boolean deleteUser(String uEmail){
        userService.deleteUser(uEmail);
        return true;
    }
}
