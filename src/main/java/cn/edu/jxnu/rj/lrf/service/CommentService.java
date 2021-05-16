package cn.edu.jxnu.rj.lrf.service;

import cn.edu.jxnu.rj.lrf.entity.Comment;

import java.util.List;

public interface CommentService {
    void post(Comment comment);//发表评论
    void delete(int commentId);//删除单个评论
    List<Comment> getAllByCommentId(int commentId);//查询某作品的所有评论
}
