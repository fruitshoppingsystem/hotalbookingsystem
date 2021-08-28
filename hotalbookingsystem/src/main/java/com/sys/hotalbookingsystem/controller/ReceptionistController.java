package com.sys.hotalbookingsystem.controller;

import com.sys.hotalbookingsystem.service.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/receptionist")
public class ReceptionistController {
    @Autowired
    private ReceptionistService receptionistService;

    @RequestMapping("/receptionistLogin")
    @ResponseBody
    public Boolean receptionistLogin(int rId, String rPassword){
        if (receptionistService.findReceptionistById(rId) != 0){
            String password = receptionistService.selectPasswordById(rId);
            return rPassword.equals(password);
        }
        return false;
    }
}
