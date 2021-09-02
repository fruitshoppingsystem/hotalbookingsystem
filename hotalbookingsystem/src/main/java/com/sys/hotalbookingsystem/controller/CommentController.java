package com.sys.hotalbookingsystem.controller;

import com.sys.hotalbookingsystem.entity.Comment;
import com.sys.hotalbookingsystem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/addComment")
    @ResponseBody
    public Boolean addComment(String uEmail, int roomId, Date cTime, String cContent, String uName, String roomType){
        Comment comment = new Comment(uEmail, roomId, cTime, cContent, uName, roomType);
        commentService.addComment(comment);
        return true;
    }
    @RequestMapping("/deleteComment")
    @ResponseBody
    public Boolean deleteComment(int cId){
        commentService.deleteComment(cId);
        return true;
    }
}
