package com.sys.hotalbookingsystem.controller;

import com.sys.hotalbookingsystem.utils.RandomValidateCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/code")
public class CodeController {
    private static final Logger logger = LoggerFactory.getLogger(CodeController.class);

    @RequestMapping(value = "/getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response){
        try{
            response.setContentType("image/jpeg");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "No-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCodeUtil = new RandomValidateCodeUtil();
            randomValidateCodeUtil.getRandcode(request, response);
            } catch (Exception e) {
                logger.error("获取验证码失败>>>> ", e);
            }
    }

    @RequestMapping("/checkCode")
    @ResponseBody
    public Boolean checkCode(@RequestParam("code") String code, HttpSession session) {
        //从session中获取随机数
        String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
        if (random == null) {
            return false;
        }else if (random.equals(code)){
            return true;
        }else {
            return false;
        }
    }
}
