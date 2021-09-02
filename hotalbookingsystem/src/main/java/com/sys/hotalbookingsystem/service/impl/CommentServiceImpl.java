package com.sys.hotalbookingsystem.service.impl;

import com.sys.hotalbookingsystem.dao.CommentDao;
import com.sys.hotalbookingsystem.entity.Comment;
import com.sys.hotalbookingsystem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("CommentService")
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Override
    public void addComment(Comment comment) {
        commentDao.addComment(comment);
    }

    @Override
    public void deleteComment(int cId) {
        commentDao.deleteComment(cId);
    }

    @Override
    public List<Comment> selectAllComment() {
        return commentDao.selectAllComment();
    }
}
