package com.sys.hotalbookingsystem.dao;

import com.sys.hotalbookingsystem.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CommentDao")
@Mapper
public interface CommentDao {
    void addComment(Comment comment);
    void deleteComment(int cId);
    List<Comment> selectAllComment();
}
