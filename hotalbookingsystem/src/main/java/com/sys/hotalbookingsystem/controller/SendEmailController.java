package com.sys.hotalbookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Random;

@RestController
@RequestMapping("email")
public class SendEmailController {
    @Autowired
    JavaMailSender mail;

    @Value("${spring.mail.username}")
    private String username;

    @RequestMapping("/send")
    public @ResponseBody Boolean send(HttpSession httpSession, @RequestParam("userEmail") String userEmail){
        //生成六位数验证码
        String Captcha = String.valueOf(new Random().nextInt(899999) + 100000);
        httpSession.setAttribute("Captcha",Captcha);//存储验证码
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(username);

        message.setTo(userEmail);

        message.setSubject("验证码");

        message.setText("验证码：" + Captcha);

        mail.send(message);

        return true;
    }

    @RequestMapping("/deleteCaptcha")
    public @ResponseBody void deleteCaptcha(HttpSession httpSession){
        httpSession.removeAttribute("Captcha");
    }

    @RequestMapping("/checkCaptcha")
    public @ResponseBody boolean checkCaptcha(HttpSession httpSession, @RequestParam("captcha") String captcha){
        String captcha1 = (String) httpSession.getAttribute("Captcha");
        if(captcha.equals(captcha1)){
            return true;
        }else {
            return false;
        }
    }
}
