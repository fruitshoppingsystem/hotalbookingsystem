package com.sys.hotalbookingsystem.service;

import com.sys.hotalbookingsystem.entity.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);
    void deleteComment(int cId);
    List<Comment> selectAllComment();
}
